package com.salesforce.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpportunityPage {

    WebDriver driver;
   // By opportunityTab=By.xpath("//*[@title='Opportunities']");
    By newButton=By.xpath("//div[@title='New']");
    By opportunityName=By.xpath("//input[@name='Name']");
    By amountInputField=By.xpath("//input[@name='Amount']");
    By closeDateInputField=By.xpath("//input[@name='CloseDate']");
    By stagePickedList=By.xpath("(//label[text()='Stage']/following::button)[1]");
   // By saveButton=By.xpath("//*[@name='SaveEdit']");

    public OpportunityPage(WebDriver driver) {
        this.driver = driver;
    }

   /* public void clickedOpportunityTab(){
        driver.findElement(opportunityTab).click();
    }*/
    public void clickNewButton(){
        driver.findElement(newButton).click();
    }

    public void enterOpportunityName(String OpportunityName){
        driver.findElement(opportunityName).sendKeys(OpportunityName);
    }

    public void enterAmount(int amount){
        driver.findElement(amountInputField).sendKeys(String.valueOf(amount));
    }
    //date Format-31/12/2024
    public void enterCloseDate(String date){
        driver.findElement(closeDateInputField).sendKeys(date);
    }
    public void chooseStageInOpportunity(String stageName){
        driver.findElement(stagePickedList).click();
        WebElement element=driver.findElement(By.xpath("//span[text()='"+stageName+"']"));
        element.click();
    }
//    public void clickedSaveButton(){
//        driver.findElement(saveButton).click();
//    }


}
