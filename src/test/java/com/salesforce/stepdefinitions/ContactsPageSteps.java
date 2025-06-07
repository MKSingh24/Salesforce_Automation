package com.salesforce.stepdefinitions;

import com.salesforce.context.TestContext;
import com.salesforce.pageObject.ContactsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactsPageSteps {

    public TestContext testContext;
    public ContactsPage contactsPage;

    public ContactsPageSteps(TestContext testContext) {
        this.testContext = testContext;
    }
    @When("User click on new button in Contacts tab")
    public void userClickOnNewButton(){
        contactsPage=testContext.pageObjectManager.getContactsPage();
        contactsPage.clickNewButton();
    }
    @Then("User creates new contact by populating mandatory fields")
    public void userCreateContact(){
        contactsPage=testContext.pageObjectManager.getContactsPage();
        contactsPage.chooseSalutation("Mr.");
        contactsPage.enterFirstname("SalesForce");
        contactsPage.enterLastname("Automation");
        contactsPage.chooseAccount("sForce");

    }


}
