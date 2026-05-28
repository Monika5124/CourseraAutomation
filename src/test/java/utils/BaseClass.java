package utils;

import org.openqa.selenium.WebDriver;

public class BaseClass {

    protected WebDriver driver;

    // Setup method
    public void setup() {
        driver = DriverSetup.initDriver();
        driver.get(DriverSetup.getURL());
    }

    // TearDown method
    public void tearDown() {
        DriverSetup.quitDriver();
    }

    // Get driver method
    public WebDriver getDriver() {
        return driver;
    }
}

