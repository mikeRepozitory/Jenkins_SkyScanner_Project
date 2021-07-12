package com.skyScanner.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/cucumber-reports/Cucumber.html"},
        features = {"src/test/resources/features"},
        glue = {"com.skyScanner"},
        dryRun = false,
        tags = ("@OneWayFlight")
)
public class TestRunner extends AbstractTestNGCucumberTests {



}

//h2[contains(text(),'A few of our most popular courses')]
//*[contains(text(), 'Sauce Labs Backpack')]
//   plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
