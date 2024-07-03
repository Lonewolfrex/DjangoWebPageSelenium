package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import customMethods.selenium_utils;
import java.util.ArrayList;
import java.util.List;

public class homePage {
    private WebDriver driver;
    
    private WebElement home_page_title;
    private WebElement feature_options_calc;
    private WebElement feature_options_palindrome;
    private WebElement feature_options_fibonacci;

    // Constructor    
    public homePage(WebDriver driver) {
        this.driver = driver;
    }

    // Lazily initialize web elements
    private void initializeElements() {
		home_page_title = driver.findElement(By.xpath("//h1[text()='Welcome to the Web Application']"));
		feature_options_calc = driver.findElement(By.xpath("//div[@class='options']//a[@href='/calculator/']"));
		feature_options_palindrome = driver.findElement(By.xpath("//div[@class='options']//a[@href='/palindrome/']"));
		feature_options_fibonacci = driver.findElement(By.xpath("//div[@class='options']//a[@href='/fibonacci/']"));
    }

    // Verify products page
    public void verifyProductsPage() {
        initializeElements();
        
        String title = home_page_title.getText().toString();
        String btn_calc_text = feature_options_calc.getText();
        String btn_palindrome_text = feature_options_palindrome.getText();
        String btn_fibonacci_text = feature_options_fibonacci.getText();
        
        selenium_utils.assertText(driver, title, "Welcome to the Web Application", 3);
        
        selenium_utils.assertText(driver, btn_calc_text, "Calculator Application", 3);
        selenium_utils.assertText(driver, btn_palindrome_text, "Palindrome Checker", 3);
        selenium_utils.assertText(driver, btn_fibonacci_text, "Fibonacci Series", 3);
    }

    public void selectFeature(String feature) {
    	switch (feature.toLowerCase()) {
		case "calculator":
			selenium_utils.clickElement(driver, feature_options_calc, 0);
			break;
		case "palindrome":
			selenium_utils.clickElement(driver, feature_options_palindrome, 0);
			break;
		case "fibonacci":
			selenium_utils.clickElement(driver, feature_options_fibonacci, 0);
			break;			
		default:
			break;
		}
    }
}
