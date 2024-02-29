package com.FindHospitals.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features= {".//FeatureFiles/EndToEnd.feature"}, 
		glue = "com.FindHospitals.stepDefinitions", 
		plugin = {"pretty","html:reports/report.html","rerun:target/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		dryRun=false,
		monochrome=false
		)
public class testNGRunner extends AbstractTestNGCucumberTests{

}
