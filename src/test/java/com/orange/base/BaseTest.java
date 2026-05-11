package com.orange.base;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.orange.factory.DriverFactory;
import com.orange.listeners.TestListeners;
import com.orange.utils.Config;
import com.orange.utils.Constants;

@Listeners(TestListeners.class)
public class BaseTest {

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeSuite
    public void setUpConfig() {
        Config.initialize();
    }

    @BeforeMethod
    public void setDriver(ITestContext ctx) {

        // Use DriverFactory instead of local methods
        DriverManager.setDriver(DriverFactory.createDriver());

        WebDriver driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get(Config.get(Constants.ORANGE_HRM_URL));

        ctx.setAttribute(Constants.DRIVER, driver);
    }

    @AfterMethod
    public void quitDriver() {
        DriverManager.getDriver().quit();
        DriverManager.unload();
    }
}