package com.salesforce.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AccountPage {

    public WebDriver driver;
    public CommonPage commonPage;
   // By accountsTab=By.xpath("//*[@title='Accounts']");
    By newButton=By.xpath("//*[@title='New' and @class='forceActionLink']");
    By accountNameInputField=By.xpath("//*[@name='Name']");
    By ratingPickedList=By.xpath("//*[text()='Rating']/following::button[1]");
    By ratingPickedValuesHot=By.xpath("//span[text()='Hot']");
    //By saveButton=By.xpath("//*[@name='SaveEdit']"); move into commonPage class

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    /*public void clickAccountTab(){
        driver.findElement(accountsTab).click();
    }*/

    public void clickNewButton(){
        commonPage=new CommonPage(driver);
        commonPage.waitForElementToBePresence(newButton);
        commonPage.waitForElementToBeVisible(driver.findElement(newButton));
        commonPage.waitForElementToBeClickable(driver.findElement(newButton));
        driver.findElement(newButton).click();
    }
    public void enterAccountName(String accountName){
        driver.findElement(accountNameInputField).sendKeys(accountName);
    }
   /* public void chooseRatingList(){
        driver.findElement(ratingPickedList).click();
        driver.findElement(ratingPickedValuesHot).click();
    }*/

    public void chooseRatingList(String value){
        driver.findElement(ratingPickedList).click();
        WebElement element=driver.findElement(By.xpath("//span[text()='"+value+"']"));
        element.click();
    }

    public void assertAccountNae(String accountName){
        By locator=By.xpath("//lightning-formatted-text[text()='"+accountName+"']");
        commonPage=new CommonPage(driver);
        commonPage.waitForElementToBePresence(locator);
        WebElement element=driver.findElement(locator);
        Assert.assertEquals(element.getText(),accountName);
        Assert.assertTrue(element.isDisplayed());
       /* if(element.isDisplayed()){
            System.out.println("Account is created Successfully");
        }else{
            System.out.println("Account creation failed");
        }
        try{
            element.isDisplayed();
            System.out.println("Account is created Successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
    }
//    public void clickedSaveButton(){
//        driver.findElement(saveButton).click();
//
//    }


}
