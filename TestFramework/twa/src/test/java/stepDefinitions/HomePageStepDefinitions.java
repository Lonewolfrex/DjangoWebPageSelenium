package stepDefinitions;

import org.openqa.selenium.WebDriver;

import customMethods.custom_logger;
import customMethods.selenium_utils;
import customMethods.webdriver_factory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.homePage;

public class HomePageStepDefinitions extends BaseStepDefinitions {
    
    private WebDriver driver;
    private homePage home_page;
    
    @Before
    public void setUp() throws Throwable {
        driver = webdriver_factory.createDriver();
        home_page = new homePage(driver);
    }
    
    @After
    public void tearDown() {
        if (driver != null) {
            selenium_utils.killDriver(driver);
        }
    }
    
    @Given("I launch the Django demo website")
    public void launch_Website() {
    	custom_logger.log("I launch the Django demo website");
    	driver.get("http://127.0.0.1:8085");
        try {
            home_page.verifyProductsPage();
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        }
    }
    
    @Then("I view the Home Page")
    public void verifyHomePage() {
    	custom_logger.log("Feature File Step: I view the Home Page");
        try {
            home_page.verifyProductsPage();
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        }
    }
    @Then("I click on the {string}")
    public void clickOnFeature(String select_feature) {
    	custom_logger.log("Feature File Step:I click on the feature");
        try {
            home_page.selectFeature(select_feature);
        } catch (Exception e) {
            selenium_utils.killDriver(driver);
            throw e;
        }
    }
}