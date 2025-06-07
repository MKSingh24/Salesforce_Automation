package com.salesforce.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    public WebDriver driver;
    public  CommonPage commonPage;
    By loginIcon=By.xpath("//*[contains(@class,'forceSocialPhoto')]");
//    By appLauncher=By.xpath("//*[@title='App Launcher']");
//    By searchAppCentre=By.xpath("//*[@class='slds-input']"); Move into common page


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void displayedLoginIcon(){
        commonPage=new CommonPage(driver);
        commonPage.waitForElementToBePresence(loginIcon);
        WebElement icon=driver.findElement(loginIcon);
        if(icon.isDisplayed()){
            System.out.println("Login Successfully!!!!!!!!");
        }else{
            System.err.println("Icon is not Displayed");
        }
    }
    /*public void clickedAppLauncher(){
        driver.findElement(appLauncher).click();
    }

    public void searchApp(String value){
        driver.findElement(searchAppCentre).sendKeys(value);
        WebElement element=driver.findElement(By.xpath("//a[@id='07pNS00000102PcYAI']//b[contains(text(),'"+value+"')]"));
        element.click();
    }
    public void openSalesPage(){
        WebElement salesIcon=driver.findElement(By.xpath("//span[@title='Sales']"));
        if(salesIcon.isDisplayed()){
            System.out.println("Sales Page is displayed Successfully!!!!!!");
        }else{
            System.err.println("Sales Page is not displayed Successfully!!!!!!");
        }
    }*/
}
