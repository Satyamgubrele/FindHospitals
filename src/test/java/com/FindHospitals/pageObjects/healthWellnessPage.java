package com.FindHospitals.pageObjects;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FindHospitals.utils.DataReader;

public class healthWellnessPage extends basePage {

	
	public healthWellnessPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy(xpath="(//*[@id='organizationName'])[1]")							
	WebElement orgName;
	
	@FindBy(xpath="(//*[@id='name'])[1]")							
	WebElement Name;
	
	@FindBy(xpath="(//*[@id='contactNumber'])[1]")							
	WebElement contact;
	
	@FindBy(xpath="(//*[@id='officialEmailId'])[1]")							
	WebElement email;
	
	@FindBy(xpath="(//*[@id='organizationSize'])[1]")							
	WebElement orgSize;
	
	@FindBy(xpath="(//*[@id='interestedIn'])[1]")							
	WebElement intrest;
	
	@FindBy(xpath="(//*[@id=\"organizationSize\"])[1]//option")							
	List<WebElement> orgSizeList;
	
	@FindBy(xpath="(//*[@id=\"interestedIn\"])[1]//option")							
	List<WebElement> intrestList;

	@FindBy(xpath="(//button[text()='Schedule a demo'])[1]")							
	WebElement demoButton;
	
	@FindBy(xpath="(//*[text()='THANK YOU'])[1]")							
	WebElement thankUMessage;
	
	public boolean validate(String string) {
			// TODO Auto-generated method stub
		if(driver.getTitle().equals(string))
			return true;
		else
			return false;
	}


	public void fillForm(String index) {
		// TODO Auto-generated method stub
		List<HashMap<String , String>> dataMap= DataReader.data(System.getProperty("user.dir")+"/src/test/resources/input.xlsx","details");
		int ind=Integer.parseInt(index);
		Name.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));

		Name.sendKeys(dataMap.get(ind).get("Name"));
		orgName.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));

		orgName.sendKeys(dataMap.get(ind).get("orgName"));
		contact.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));

		contact.sendKeys(dataMap.get(ind).get("Contact"));
		email.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));

		email.sendKeys(dataMap.get(ind).get("Email"));
		orgSize.click();
		String orgsize=dataMap.get(ind).get("orgSize");
		for(int i=0;i<orgSizeList.size();i++)
		{
			if(orgSizeList.get(i).getText().equals(orgsize))
				{
				   orgSizeList.get(i).click();
				   break;
				}
		}
		intrest.click();
		String Intrest=dataMap.get(ind).get("Intrest");
		for(int i=0;i<intrestList.size();i++)
		{
			if(intrestList.get(i).getText().equals(Intrest))
				{
				   intrestList.get(i).click();
				   break;
				}
		}
	}


	public boolean isDemoButtonDisabled() {
		// TODO Auto-generated method stub
		return !(demoButton.isEnabled());
	}


	public void submit() {
		// TODO Auto-generated method stub
		demoButton.click();
		
	}


	public boolean validateThankYou() {
		// TODO Auto-generated method stub
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(thankUMessage));
		return thankUMessage.isDisplayed();
	}
	
}
