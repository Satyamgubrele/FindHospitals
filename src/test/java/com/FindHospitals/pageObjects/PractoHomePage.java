package com.FindHospitals.pageObjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PractoHomePage extends basePage{

	
	@FindBy(xpath="//input[@data-qa-id='omni-searchbox-locality']")							
	WebElement locationSearchBar;
	
	@FindBy(xpath="//*[@data-qa-id='omni-suggestion-main']")							
	List<WebElement>selectLocation;
	
	@FindBy(xpath="//*[@data-qa-id='omni-searchbox-keyword']")							
	WebElement searchBar;
	
	@FindBy(xpath="//*[@data-qa-id='omni-suggestion-main']")							
	List<WebElement> specialityList;
	
	@FindBy(xpath="//*[@class='product-tab']//div[text()='Surgeries']")							
	WebElement surjuryButton;
	
	@FindBy(xpath="//*[@class='u-d-item up-triangle' ]//*[text()='For Corporates']")							
	WebElement forCorporates;
	
	@FindBy(xpath="//*[@class='u-d nav-dropdown text-left active-state' ]//*[text()='Health & Wellness Plans']")							
	WebElement healthFitness;
	
	public PractoHomePage(WebDriver driver) {
		super(driver);
	}
	
	public String GetTitle() {
		
		return driver.getTitle().toString();
	}


	public void setLocation(String location) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(locationSearchBar));
		locationSearchBar.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		locationSearchBar.sendKeys(location+" city");
	}

 
	public void chooseLocation(String location) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(selectLocation.get(0)));
		for(int i=0;i<selectLocation.size();i++)
		{
//			System.out.println(city.getText());
			String city=selectLocation.get(i).getText();
			if(city.equalsIgnoreCase(location))
			{
				selectLocation.get(i).click();
				break;
			}
		}
	}


	public Boolean validateLocation(String location) {
		// TODO Auto-generated method stub
		String loc=locationSearchBar.getAttribute("value");
		if(loc.equalsIgnoreCase(location))
		{
			return true;
		}
		else
			return false;
		
	}


	public void searchSpeciality(String speciality) {
		// TODO Auto-generated method stub
		searchBar.sendKeys(speciality);
		
	}


	public void selectSpeciality(String speciality) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(specialityList.get(0)));
		System.out.println(specialityList.size());
		
		for(int i=0;i<specialityList.size();i++)
		{
//			System.out.println(city.getText());
			String doctor=specialityList.get(i).getText();
			if(doctor.equalsIgnoreCase(speciality))
			{
				specialityList.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
	}

	public void clcikOnSurgury() {
		// TODO Auto-generated method stub
		surjuryButton.click();
		
		
	}

	public void selectHealthFitness() {
		// TODO Auto-generated method stub
		forCorporates.click();
		healthFitness.click();
		
	}

	
	
}
