package com.FindHospitals.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {".//FeatureFiles/EndToEnd.feature"}, 
		glue = "com.FindHospital.stepDefinitions", 
		plugin = {"pretty","html:reports/report.html",
				  "rerun:target/rerun.txt",
				  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		dryRun=false,
		monochrome=true,
		publish=true
		
		)

public class testRunner {

}
