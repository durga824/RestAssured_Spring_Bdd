package CucumberRunner;

/**
 * Author: Durga Rao
 * Initial Date: 06/13/2024
 * Description: Test runner for Cucumber tests using TestNG.
 * This class configures the Cucumber options and specifies the location of feature files and step definitions.
 */

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/java/features/affiliate.feature",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports.html"})
public class TestRunner extends AbstractTestNGCucumberTests {
}