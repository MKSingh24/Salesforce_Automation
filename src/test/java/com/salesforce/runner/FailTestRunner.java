package com.salesforce.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "@target/failedTest.txt",glue="com.salesforce.stepdefinitions",
        monochrome = true,dryRun = false,
        plugin = {"pretty","html:target/cucumber-reports.html","json:target/cucumber-json-reports.json"}
)
public class FailTestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object [] [] scenarios(){
        return super.scenarios();

    }
}
