package utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class BaseClass {

    public static WebDriver driver;
    public static Properties prop;

    public static void setup() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/features/config.properties");
            prop.load(fis);

            driver = DriverSetup.getDriver();
            driver.manage().window().maximize();
            driver.get(prop.getProperty("url"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void tearDown() {
        DriverSetup.quitDriver();
    }
}