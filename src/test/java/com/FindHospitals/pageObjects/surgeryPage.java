package com.FindHospitals.pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.FindHospitals.utils.excelUtils;

public class surgeryPage extends basePage {

	public surgeryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//*[@class=\"text-module_base__1vdUh text-12px HassleFreeTreatment-module_headerTextColor__vN6mf\"]")							
	List<WebElement> surgeryList;
	
	public boolean validateSurgeryPage(String string) {
		// TODO Auto-generated method stub
		if(driver.getTitle().equals(string))
			return true;
		else
			return false;
	}

	public void countAndStoreSurgery() throws IOException {
		// TODO Auto-generated method stub
		int TotalNoOfSurgery=surgeryList.size();
		excelUtils.setCellData(System.getProperty("user.dir")+"/test-output/ExcelData/surguries.xlsx","Sheet1",0,1,Integer.toString(TotalNoOfSurgery));
		for(int i=0;i<TotalNoOfSurgery;i++)
		{
			excelUtils.createRow(System.getProperty("user.dir")+"/test-output/ExcelData/surguries.xlsx","Sheet1",i+2,3,"");
			excelUtils.setCellData(System.getProperty("user.dir")+"/test-output/ExcelData/surguries.xlsx","Sheet1",i+2,0,Integer.toString(i+1));

			excelUtils.setCellData(System.getProperty("user.dir")+"/test-output/ExcelData/surguries.xlsx","Sheet1",i+2,1,surgeryList.get(i).getText());

		}

      
		
	}
	
	

}
