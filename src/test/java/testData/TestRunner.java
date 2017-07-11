package testData;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = "json:target/cucumber-report.json")
public class TestRunner extends AbstractTestNGCucumberTests {
}
