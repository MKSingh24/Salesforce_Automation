package com.salesforce.stepdefinitions;

import com.aventstack.extentreports.Status;
import com.salesforce.context.TestContext;
import com.salesforce.pageObject.LoginPage;
import com.salesforce.pageObject.PageObjectManager;
import com.salesforce.utils.ConfigReader;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import javax.sound.midi.SysexMessage;
//import static com.salesforce.context.TestContext.driver;


public class LoginPageSteps {


    public PageObjectManager pageObjectManager;
    public LoginPage loginPage;
    public TestContext testContext;

    public LoginPageSteps(TestContext testContext)
    {
        this.testContext = testContext;
    }

    @Given("User open salesforce login url")
    public void user_open_salesforce_login_url() {

        String urlFromPropertyFile=ConfigReader.getProperty("url");
        String urlFromMaven=System.getProperty("url");
        String url=urlFromMaven!=null?urlFromMaven:urlFromPropertyFile;




      /*  testContext.driver=new ChromeDriver();
        testContext.driver.get("https://abc432-dev-ed.develop.my.salesforce.com/");
        testContext.driver.manage().window().maximize();*/
        //testContext.browserFactory.getDriver();
        try {
            testContext.browserFactory.launchBrowser(url);
            TestContext.extentTest.log(Status.PASS,"successfully Opened the url: "+ConfigReader.getProperty("url"));
        } catch (Exception e) {
            TestContext.extentTest.log(Status.WARNING,"Url is not open: "+ConfigReader.getProperty("url"));
        }
    }
    @When("User enter valid credentials")
    public void user_enter_valid_credentials() {

       // pageObjectManager=new PageObjectManager(driver);
        //loginPage=new LoginPage(driver);
        loginPage= testContext.pageObjectManager.getLoginPage();
        loginPage.enterUserName(System.getenv("Salesforce_userName"));
        loginPage.enterPassWord(System.getenv("Salesforce_pass"));
        TestContext.extentTest.log(Status.PASS,"Enter Valid credentials ");

    }
    @When("User click on login button")
    public void user_click_on_login_button() {


       // loginPage=new LoginPage(driver);
        loginPage.enterLoginButton();
        TestContext.extentTest.log(Status.PASS,"Successfully click on login button");
    }


    //move into homepagesteps
//    @Then("User should be logged successfully")
//    public void user_should_be_logged_successfully() {
//
//    }
    @When("User enter invalid credentials")
    public void user_enter_invalid_credentials() {
       // pageObjectManager=new PageObjectManager(driver);
      //  loginPage=new LoginPage(driver);
        loginPage=testContext.pageObjectManager.getLoginPage();
        loginPage.enterUserName(System.getenv("Salesforce_userName"));
        loginPage.enterPassWord("Banti@23");


    }
    @Then("User should see an error message")
    public void user_should_see_an_error_message() {
  //  WebElement errorMsg=driver.findElement(By.xpath("//*[@id='error']"));
   // String actualErrorMsg=errorMsg.getText();
    String expectedErrorMsg="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
    //Assert.assertEquals(actualErrorMsg,expectedErrorMsg);

     /*  if(actualErrorMsg.equals(expectedErrorMsg)){
           System.out.println("assert successful");
        }else{
           throw new IllegalArgumentException("Assert Fail");
          // System.err.println("Assert Fail");
          }*/
        loginPage=testContext.pageObjectManager.getLoginPage();
       if(loginPage.loginErrorMsg(expectedErrorMsg)){
           TestContext.extentTest.log(Status.PASS,"Error message displayed as expected ");
       }else{
           TestContext.extentTest.log(Status.FAIL,"Error message not  displayed as expected ");
       }
       }
    }




