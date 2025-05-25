package com.salesforce.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CasePage {

    WebDriver driver;
   // By caseTab=By.xpath("//*[@title='Cases']");
    By newButton=By.xpath("//div[@title='New']");
    By statusPickedList=By.xpath("//label[text()='Status']/following::button[1]");
    By caseOriginPickedList=By.xpath("//label[text()='Case Origin']/following::button[1]");
    By DescriptionInputField=By.xpath("//label[text()='Description']/following::textarea[1]");
  //  By saveButton=By.xpath("//button[@name='SaveEdit']");

    public CasePage(WebDriver driver) {
        this.driver = driver;
    }
    /*public void clickedCaseTab(){
        driver.findElement(caseTab).click();
    }*/
    public void clickNewButton(){
        driver.findElement(newButton).click();
    }
    public void chooseStatusInCase(String status){
        driver.findElement(statusPickedList).click();
        WebElement element=driver.findElement(By.xpath("//span[@title='"+status+"']"));
        element.click();
    }

    public void chooseOriginInCase(String caseOrigin){
        driver.findElement(caseOriginPickedList).click();
        WebElement element=driver.findElement(By.xpath("//span[@title='"+caseOrigin+"']"));
        element.click();
    }

    public void enterDescription(String description){
        driver.findElement(DescriptionInputField).sendKeys(description);
    }
//    public void clickedSaveButton(){
//        driver.findElement(saveButton).click();
//    }
}

