package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import utils.DriverSetup;

import java.util.List;

public class CoursesPage {

    WebDriver driver = DriverSetup.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // COMPLETE FLOW: Search + Filter + Extract
    public void searchFilterAndExtract() {

        //STEP 1: Search Web Development
        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@id='search-autocomplete-input']")
                )
        );
        searchBox.sendKeys("Web Development" + Keys.ENTER);

        //Scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");

        //STEP 2: Apply Beginner filter
        WebElement filterBtn1 = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[@id='search-results-frame']/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div[5]/button/div[1]")
                )
        );
        filterBtn1.click();

        WebElement beginner = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//label[.//span[text()='Beginner']]")
                )
        );
        beginner.click();

        WebElement view1 = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("/html/body/div[5]/div[3]/div/div/div[3]/div/div/div[1]/button")
                )
        );
        view1.click();

        //STEP 3: Apply English filter
        WebElement filterBtn2 = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[@id='search-results-frame']/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div[4]/button/div[1]")
                )
        );
        filterBtn2.click();

        WebElement english = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("/html/body/div[5]/div[3]/div/div/div[2]/div/div/div/div/div[2]/label")
                )
        );
        english.click();

        WebElement view2 = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("/html/body/div[5]/div[3]/div/div/div[3]/div/div/div[1]/button")
                )
        );
        view2.click();

        // STEP 4: Extract first 2 courses
        List<WebElement> courses = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//div[contains(@class,'cds-CommonCard')]")
                )
        );

        int count = courses.size();

        for (int i = 0; i < Math.min(2, count); i++) {

            boolean success = false;

            for (int retry = 0; retry < 2; retry++) {

                try {
                    // Re-fetch every time (VERY IMPORTANT)
                    List<WebElement> updatedCourses = wait.until(
                            ExpectedConditions.visibilityOfAllElementsLocatedBy(
                                    By.xpath("//div[contains(@class,'cds-CommonCard')]")
                            )
                    );

                    WebElement course = updatedCourses.get(i);

                    String name = course.findElement(By.tagName("h3")).getText();
                    String details = course.getText();

                    System.out.println("Course " + (i + 1) + ":");
                    System.out.println("Name: " + name);
                    System.out.println(details);
                    System.out.println("------------------------------");

                    success = true;
                    break; // break retry loop if success

                } catch (Exception e) {
                    // retry again
                }
            }

            if (!success) {
                System.out.println("Course " + (i + 1) + ": Still not loaded after retry");
            }
        }
    }
}
