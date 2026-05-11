package com.orange.factory;

import java.net.URI;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.orange.utils.Config;
import com.orange.utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static final Logger log = LoggerFactory.getLogger(DriverFactory.class);

    public static WebDriver createDriver() {
        if (Boolean.parseBoolean(Config.get(Constants.GRID_ENABLED))) {
            return getRemoteDriver();
        } else {
            return getLocalDriver();
        }
    }

    private static RemoteWebDriver getRemoteDriver() {
        Capabilities capabilities = new ChromeOptions();

        if (Constants.FIREFOX.equalsIgnoreCase(Config.get(Constants.BROWSER))) {
            capabilities = new FirefoxOptions();
        }

        String url = String.format(
                Config.get(Constants.GRID_URL_FORMAT),
                Config.get(Constants.GRID_HUB_HOST)
        );

        log.info("Grid URL: {}", url);

        try {
            return new RemoteWebDriver(new URI(url).toURL(), capabilities);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create RemoteWebDriver", e);
        }
    }

    private static WebDriver getLocalDriver() {
        String browser = Config.get(Constants.BROWSER);

        if ("firefox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else {
        	WebDriverManager.chromedriver().setup();

        	ChromeOptions options = new ChromeOptions();

        	if(Boolean.parseBoolean(Config.get(Constants.HEADLESS))) {
        	    options.addArguments("--headless=new");
        	    options.addArguments("--window-size=1920,1080");
        	}

        	return new ChromeDriver(options);
        }
    }
}