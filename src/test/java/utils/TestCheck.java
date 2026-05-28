package utils;

public class TestCheck {

    public static void main(String[] args) {

        DriverSetup.initDriver();

        DriverSetup.getDriver().get(DriverSetup.getURL());

        System.out.println("Browser Launched Successfully");

        DriverSetup.quitDriver();
    }
}
