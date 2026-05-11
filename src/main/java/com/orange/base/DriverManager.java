package com.orange.base;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    // Thread-safe WebDriver storage
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Private constructor → prevent object creation
    private DriverManager() {}

    // Set driver for current thread
    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    // Get driver for current thread
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Remove driver (important for memory cleanup)
    public static void unload() {
        driver.remove();
    }
}