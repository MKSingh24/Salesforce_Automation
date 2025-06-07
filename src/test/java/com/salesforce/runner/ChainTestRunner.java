package com.salesforce.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/java/com/salesforce/features",glue="com.salesforce.stepdefinitions",
        monochrome = true,dryRun = false,tags = "@SmokeTest or @ErrorValidation",
        plugin = {"pretty","com.aventstack.chaintest.plugins.ChainTestCucumberListener:",
        "rerun:target/failedTest.txt"}
)
public class ChainTestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object [] [] scenarios(){
        return super.scenarios();

    }
}
