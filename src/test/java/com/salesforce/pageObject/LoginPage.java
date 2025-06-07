package com.salesforce.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class LoginPage {
    public WebDriver driver;
    public CommonPage commonPage;
    By userName=By.id("username");
    By passWord=By.xpath("//*[@id='password']");
    By loginButton=By.xpath("//*[@id='Login']");
    By errorMsg=By.xpath("//div[@id='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String username) {
        driver.findElement(userName).sendKeys(username);

    }

    public void enterPassWord(String password) {
        driver.findElement(passWord).sendKeys(password);
    }

    public void enterLoginButton() {
        driver.findElement(loginButton).click();
    }
    public boolean loginErrorMsg(String errorMessage){
        commonPage=new CommonPage(driver);
        commonPage.waitForElementToBePresence(errorMsg);
        WebElement errorEle=driver.findElement(errorMsg);
        Assert.assertEquals(errorEle.getText(),errorMessage);
        return true;
    }
}
