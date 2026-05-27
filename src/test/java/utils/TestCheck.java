package utils;

import org.testng.annotations.Test;

public class TestCheck {

    @Test
    public void testBrowserLaunch() {

        // Start browser
        BaseClass.setup();

        // Print message
        System.out.println("Browser launched successfully");

        // Close browser
        BaseClass.tearDown();
    }
}
