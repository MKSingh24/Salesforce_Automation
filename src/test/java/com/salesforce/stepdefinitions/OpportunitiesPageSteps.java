package com.salesforce.stepdefinitions;

import com.salesforce.context.TestContext;
import com.salesforce.pageObject.OpportunityPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpportunitiesPageSteps {

    public TestContext testContext;
    public OpportunityPage opportunityPage;

    public OpportunitiesPageSteps(TestContext testContext) {
        this.testContext = testContext;
    }
    @When("User click on new button in Opportunities tab")
    public void userClickOnNewButton(){
        opportunityPage=testContext.pageObjectManager.getOpportunityPage();
        opportunityPage.clickNewButton();
    }
    @Then("User creates new Opportunities by populating mandatory fields")
    public void userCreateOpportunities(){
        opportunityPage=testContext.pageObjectManager.getOpportunityPage();
        opportunityPage.enterOpportunityName("opportunityPage1");
        opportunityPage.enterAmount(1000);
        opportunityPage.enterCloseDate("05/03/2025");
        opportunityPage.chooseStageInOpportunity("Prospecting");

    }
}
