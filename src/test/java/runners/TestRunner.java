package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",   // feature file path
        glue = {"stepdefinitions", "hooks"},        // where step defs + hooks are
        plugin = {
                "pretty",                            // console output
                "html:target/cucumber-report.html"   // report generation
        },
        monochrome = true                            // clean console output
)
public class TestRunner extends AbstractTestNGCucumberTests {
}