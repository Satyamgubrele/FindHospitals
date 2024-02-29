package com.FindHospitals.stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.FindHospitals.utils.baseClass;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class hooks {

	static WebDriver driver;
	static Properties p;
	
	@Before
	public static void setup() throws IOException, InterruptedException{
		driver = baseClass.initializeBrowse();		//calling the initializeBrowser method of baseClass to get the driver
		
		p = baseClass.getProperties();				//calling the getProperties method of baseClass
		driver.manage().window().maximize();		//Maximizing the browser window 
		
		driver.get(p.getProperty("appUrl"));	
//		Thread.sleep(20000);//navigating to the appUrl
		
	}
	
	@After
	public static void tearDown() {
		
		driver.quit();								//closing the browser
	}
	

	
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		//this is for cucumber junit report
			System.out.println(scenario.getName());
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
	            // Specify the path where you want to save the screenshot
	            FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.dir")+"/src/test/resources/ScreenShots/"+scenario.getName()+".png"));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	

}
