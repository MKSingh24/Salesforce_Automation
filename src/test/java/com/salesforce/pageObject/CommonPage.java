package com.salesforce.pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CommonPage {
    WebDriver driver;
    public  static WebDriverWait wait;
    By saveButton=By.xpath("//*[@name='SaveEdit']");
    By appLauncher=By.xpath("//*[@title='App Launcher']");
    By searchAppCentre=By.xpath("//*[@class='slds-input']");

    public CommonPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickedSaveButton(){

        waitForElementToBePresence(saveButton);
        waitForElementToBeVisible(driver.findElement(saveButton));
        waitForElementToBeClickable(driver.findElement(saveButton));
        driver.findElement(saveButton).click();
    }

    public void openSalesforceTab(String tab){
      //  implicitWait();
        waitForElementToBePresence(By.xpath("//a[@title='"+tab+"']"));
        waitForElementToBeVisible(driver.findElement(By.xpath("//a[@title='"+tab+"']")));
        waitForElementToBeClickable(driver.findElement(By.xpath("//a[@title='"+tab+"']")));
        WebElement element=driver.findElement(By.xpath("//a[@title='"+tab+"']"));
        clickByJs(driver,element);
         //element.click();
    }



    public void chooseApp(String appName)  {
        waitForElementToBeVisible(driver.findElement(appLauncher));
        waitForElementToBeVisible(driver.findElement(appLauncher));
        driver.findElement(appLauncher).click();
        driver.findElement(searchAppCentre).sendKeys(appName);
        WebElement element=driver.findElement(By.xpath("//a[@id='07pNS00000102PcYAI']//b[contains(text(),'"+appName+"')]"));
        clickByJs(driver,element);
        //element.click();
        


    }

    public void clickByJs(WebDriver driver,WebElement element){
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();",element);
    }

    public void waitForElementToBeVisible(WebElement element){
     wait=new WebDriverWait(driver, Duration.ofSeconds(30))  ;
     wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element){
        wait=new WebDriverWait(driver, Duration.ofSeconds(30))  ;
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBePresence(By locator){
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void implicitWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }


}
