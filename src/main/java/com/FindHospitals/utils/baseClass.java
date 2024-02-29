package com.FindHospitals.utils;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.core.tools.picocli.CommandLine.Parameters;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class baseClass {

	static WebDriver driver;
	static Properties p; 
	//static Logger logger;

public static WebDriver initializeBrowse() throws IOException{			//method for initializing the browser


		
	switch(getProperties().getProperty("browser").toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();								//Creating new Chrome driver instance
			break;
		case "edge":
			driver = new EdgeDriver();									//Creating new Edge driver instance
			break;
		case "firefox":
			driver = new FirefoxDriver();								//Creating new Firefox driver instance
			break;
		default:
			System.out.println("no matching browser");	
			driver = null;
			
	}

	driver.manage().deleteAllCookies();									//deleting all cookies
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	//adding implicit wait
	
	
	return driver;														//returning the driver
	
}

public static WebDriver getDriver() {
	
	return driver;
}

public static Properties getProperties(){
	
	try {
		FileReader file = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		p = new Properties();											//Creating new Properties instance
		p.load(file);
	}
	catch(Exception e)
	{
		
	}
	return p;															//returning properties object
}


}
