package testRunners;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import customMethods.config_reader;
@CucumberOptions(
    features = {"src/test/resources/Feature_files/HomePage.feature"},
    glue = {"stepDefinitions"},   
    plugin = {"pretty", "html:target/cucumber-reports"}
)

public class TestRunner extends AbstractTestNGCucumberTests {
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	@BeforeTest
	@Parameters({ "browser" })
	public void defineBrowser(String browser) throws Throwable {
		config_reader.setBrowserType(browser);
	}
}
