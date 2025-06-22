package com.salesforce.stepdefinitions;

import com.salesforce.context.TestContext;
import com.salesforce.pageObject.CasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CasePageSteps {

    public TestContext testContext;
    public CasePage casePage;

    public CasePageSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("User click on new button in Cases tab")
    public void userClickOnNewButton() {
        casePage=testContext.pageObjectManager.getCasePage();
        casePage.clickNewButton();

    }

    @Then("User creates new case by populating mandatory fields")
    public void userCreateCase() {

    }


}
