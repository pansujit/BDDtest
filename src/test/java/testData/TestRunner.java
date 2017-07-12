package testData;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = "html:target/cucumber-report.html",features = "Feature",glue="")
public class TestRunner extends AbstractTestNGCucumberTests {
}
