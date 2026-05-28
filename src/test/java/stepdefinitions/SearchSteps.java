package stepdefinitions;

import io.cucumber.java.en.*;
import pages.CoursesPage;

public class SearchSteps {

    CoursesPage courses = new CoursesPage();

    // Scenario: Course Search + Filter + Extract

    @Given("User is on homepage")
    public void user_is_on_homepage() {
        // Browser already opened via Hooks
    }

    @When("User performs course search, filter and extraction")
    public void user_performs_full_flow() {
        courses.searchFilterAndExtract();   // call single method
    }
}
