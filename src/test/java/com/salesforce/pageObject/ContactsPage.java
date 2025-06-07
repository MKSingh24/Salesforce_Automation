package com.salesforce.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactsPage {

    WebDriver driver;
    public CommonPage commonPage;

   // By contactsTab=By.xpath("//*[@title='Contacts']");
    By newButton=By.xpath("//*[@name='NewContact']");
    By salutationPickedList=By.xpath("//*[text()='Salutation']/following::button[1]");
    By firstName=By.xpath("//*[@name='firstName']");
    By latName=By.xpath("//*[@name='lastName']");
    By accountLookingUpField=By.xpath(" //label[text()='Account Name']/following::input[1]");
    //By saveButton=By.xpath("//*[@name='SaveEdit']");


    public ContactsPage(WebDriver driver) {
        this.driver = driver;
    }

    /*public void clickContactsTab(){
        driver.findElement(contactsTab).click();
    }*/
    public void clickNewButton(){
        driver.findElement(newButton).click();
    }

    public void chooseSalutation(String value){
        commonPage=new CommonPage(driver);
        commonPage.waitForElementToBePresence(salutationPickedList);
        driver.findElement(salutationPickedList).click();
        commonPage.waitForElementToBePresence(By.xpath("//span[@title='"+value+"']"));
        commonPage.waitForElementToBeClickable(driver.findElement(By.xpath("//span[@title='"+value+"']")));
        WebElement element=driver.findElement(By.xpath("//span[@title='"+value+"']"));
        element.click();
    }
    public void enterFirstname(String firstname){
        driver.findElement(firstName).sendKeys(firstname);
    }
    public void enterLastname(String lastname){
        driver.findElement(latName).sendKeys(lastname);
    }

    public void chooseAccount(String value){
        commonPage=new CommonPage(driver);
        commonPage.waitForElementToBePresence(accountLookingUpField);
        driver.findElement(accountLookingUpField).sendKeys(value);
        commonPage.waitForElementToBePresence(By.xpath("//strong[text()='"+value+"']"));
        commonPage.waitForElementToBeClickable(driver.findElement(By.xpath("//strong[text()='"+value+"']")));
        WebElement element=driver.findElement(By.xpath("//strong[text()='"+value+"']"));
        element.click();
    }

//    public void clickedSaveButton(){
//        driver.findElement(saveButton).click();
//    }
}
