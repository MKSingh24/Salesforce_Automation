package com.salesforce.stepdefinitions;

import com.salesforce.context.TestContext;
import com.salesforce.pageObject.AccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountsPageSteps {

    public TestContext testContext;
    public AccountPage accountPage;
    public static String accountName;

    public AccountsPageSteps(TestContext testContext) {
        this.testContext = testContext;
    }

//    @Given("User click on Account tab")
//    public void userClickOnAccountTab(){
//    }!!!move into common page step

    @When("User click on new button in Account tab")
    public void userClickOnNewButton(){
        accountPage=testContext.pageObjectManager.getAccountPage();
        accountPage.clickNewButton();
   }
    @Then("User creates new account by populating {string} and {string} fields")
    public void userCreatesNewAccountByPopulatingAndFields(String name, String rating){
        accountPage=testContext.pageObjectManager.getAccountPage();
        accountName=name;
        accountPage.enterAccountName(accountName);
        accountPage.chooseRatingList(rating);

    }

    @Then("User verify account is created successfully")
    public void userVerifyAccountIsCreatedSuccessfully() {
        accountPage=testContext.pageObjectManager.getAccountPage();
        accountPage.assertAccountNae(accountName);
    }
    /*@Then("^User creates new account by populating (.+) and (.+) fields$")
    public void userCreatesNewAccount(String name, String rating){
        accountPage=testContext.pageObjectManager.getAccountPage();
        accountPage.enterAccountName(name);
        accountPage.chooseRatingList(rating);
    }*/



}
