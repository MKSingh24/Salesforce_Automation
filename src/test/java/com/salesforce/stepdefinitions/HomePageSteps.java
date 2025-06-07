package com.salesforce.stepdefinitions;

import com.salesforce.context.TestContext;
import com.salesforce.pageObject.HomePage;
import com.salesforce.pageObject.PageObjectManager;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

//import static com.salesforce.context.TestContext.driver;

public class HomePageSteps {

   // public WebDriver driver;
    public PageObjectManager pageObjectManager;
    public HomePage homePage;
    public TestContext testContext;

    public HomePageSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("User should be logged successfully")
    public void user_should_be_logged_successfully() {
        testContext.browserFactory.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       // pageObjectManager=new PageObjectManager(testContext.driver);
        //homePage=new HomePage(driver);
        homePage=testContext.pageObjectManager.getHomePage();
        homePage.displayedLoginIcon();


    }
}
