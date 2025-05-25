package com.salesforce.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

import java.util.Objects;

@CucumberOptions(features = "src/test/java/com/salesforce/features",glue="com.salesforce.stepdefinitions",
        monochrome = true,dryRun = false,tags = "@SmokeTest or @ErrorValidation",
        plugin = {"pretty","html:target/cucumber-reports.html","json:target/cucumber-json-reports.json",
        "rerun:target/failedTest.txt"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object [] [] scenarios(){
        return super.scenarios();

    }
}
