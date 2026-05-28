package utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup {

    private static WebDriver driver;
    private static Properties prop;

    public static WebDriver initDriver() {

        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/features/config.properties");
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String browser = prop.getProperty("browser");

        if (driver == null) {

            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            } else {
                driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
        }

        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getURL() {
        return prop.getProperty("url");
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
