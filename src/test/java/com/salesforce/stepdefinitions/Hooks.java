package com.salesforce.stepdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.salesforce.context.TestContext;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Hooks {
    public TestContext testContext;


    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @BeforeAll
    public static void beforeAll(){

        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter("target/ExtentReports/ExtentReport.html");
        TestContext.extentReports=new ExtentReports();
        TestContext.extentReports.attachReporter(extentSparkReporter);
    }

    @Before
    public void initiateTest(io.cucumber.java.Scenario scenario){
        TestContext.extentTest=TestContext.extentReports.createTest(scenario.getName());
        TestContext.extentTest.log(Status.INFO,"Starting the scenario: "+scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario){
        try {
            String base64ScreenShot = captureScreenShotAsBASE64();
            TestContext.extentTest.addScreenCaptureFromBase64String(base64ScreenShot);
        } catch (Exception e) {
            TestContext.extentTest.log(Status.WARNING,"Failed to capture screenShot: "+e.getMessage());
        }
    }

    @After
    public void cleanUp(Scenario scenario) throws InterruptedException {
        if(!scenario.isFailed()){
            TestContext.extentTest.log(Status.PASS,"Scenario passed successfully");
        } else{
            WebDriver driver=testContext.browserFactory.getDriver();
            final byte[] screenShot=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot,"image/png",screenShot.toString());

            TestContext.extentTest.log(Status.FAIL,"Scenario is failed");
        }
        Thread.sleep(3000);
        testContext.browserFactory.getDriver().quit();
    }

    @AfterAll
    public static void afterAll(){


        TestContext.extentReports.flush();
    }

    public String captureScreenShotAsBASE64()  {
        WebDriver driver=testContext.browserFactory.getDriver();
      /*  File screenShot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenShotPath="target/ExtentReports/screenShots/"+stepName.replaceAll(" ","_")+"_"+System.currentTimeMillis()+".png";
        File screenShotFile=new File(screenShotPath);
        FileUtils.copyFile(screenShot,screenShotFile);
        return screenShotFile.getPath();*/


        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }


}
