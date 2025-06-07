package com.salesforce.pageObject;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public WebDriver driver;
    public LoginPage loginPage;
    public HomePage homePage;
    public AccountPage accountPage;
    public ContactsPage contactsPage;
    public OpportunityPage opportunityPage;
    public CasePage casePage;
    public CommonPage commonPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        loginPage=new LoginPage(driver);
        return loginPage;
    }

    public HomePage getHomePage() {
        homePage=new HomePage(driver);
        return homePage;
    }

    public AccountPage getAccountPage() {
        accountPage=new AccountPage(driver);
        return accountPage;
    }

    public ContactsPage getContactsPage() {
        contactsPage=new ContactsPage(driver);
        return contactsPage;
    }

    public OpportunityPage getOpportunityPage() {
        opportunityPage=new OpportunityPage(driver);
        return opportunityPage;
    }

    public CasePage getCasePage() {
        casePage=new CasePage(driver);
        return casePage;
    }

    public CommonPage getCommonPage() {
        commonPage=new CommonPage(driver);
        return commonPage;
    }
}
