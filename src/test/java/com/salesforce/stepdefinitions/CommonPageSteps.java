package com.salesforce.stepdefinitions;

import com.salesforce.context.TestContext;
import com.salesforce.pageObject.AccountPage;
import com.salesforce.pageObject.CommonPage;
import com.salesforce.pageObject.ContactsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.concurrent.TimeUnit;

public class CommonPageSteps {

    public TestContext testContext;
    public CommonPage commonPage;


    public CommonPageSteps(TestContext testContext) {
        this.testContext = testContext;
    }
    @Given("User click on {string} tab")

    public void userClickOnAccountTab(String tabName){
        commonPage=testContext.pageObjectManager.getCommonPage();
        commonPage.openSalesforceTab(tabName);
    }

    @And("User click on save button in {string} tab")
        public void ClickOnSaveButton(String newTab){
        commonPage=testContext.pageObjectManager.getCommonPage();
        commonPage.clickedSaveButton();
    }


    @And("User choose {string} from App Launcher")
    public void userChooseFromAppLauncher(String appName) {
        commonPage=testContext.pageObjectManager.getCommonPage();
        commonPage.chooseApp(appName);

    }
}
