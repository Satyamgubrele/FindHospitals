package com.FindHospitals.pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FindHospitals.utils.excelUtils;

public class specialityPage extends basePage{

	public specialityPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//*[@data-qa-id='doctor_gender_section']")							
	WebElement genderButton;
	
	@FindBy(xpath="//*[@data-qa-id='doctor_gender_list']//span")							
	List<WebElement> genderList;
	
	@FindBy(xpath="//*[@data-qa-id='years_of_experience_section']")							
	WebElement experienceButton;
	
	@FindBy(xpath="//*[@data-qa-id='years_of_experience_list']//span")							
	List<WebElement> experienceOptions;
	
	@FindBy(xpath="//*[@data-qa-id='sort_by_section']")							
	WebElement sortByButton;
	
	@FindBy(xpath="//*[@data-qa-id='sort_by_list']//span")							
	List<WebElement> sortByOptions;
	
	@FindBy(xpath="//*[@data-qa-id='doctor_review_count_section']")							
	WebElement patientStoryButton;
	
	@FindBy(xpath="(//*[@data-qa-id='doctor_review_count_list'])[1]//span")							
	List<WebElement> patientStoryOptions;
	
	@FindBy(xpath="//*[text()='All Filters']")							
	WebElement AllFilters;
	
	@FindBy(xpath="//*[@class='u-c-pointer u-d-block c-filter__label']//span//span")							
	List<WebElement> fees;
	
	@FindBy(xpath="//*[@class='u-c-pointer u-d-block c-filter__label']//span//span")							
	List<WebElement> availabilityOption;
	
	By doctor_cards = By.xpath("//div[@class=\"listing-doctor-card\"]");
	By doctor_name = By.xpath("//div[@class=\"info-section\"]/a");
	By doctor_details = By.xpath("//div[@class=\"pure-g g-card\"]");
	By doctor_share_story = By.xpath("//a[@class=\"u-primary-text u-t-underline\"]");
	By doctor_deatails_name = By.xpath("//h1[@data-qa-id=\"doctor-name\"]");
	By doctor_qualification = By.xpath("//div[@class=\"c-profile--qualification\"]/p");
	By doctor_designation = By.xpath("//h2[@class=\"u-d-inlineblock u-spacer--right-v-thin c-profile__details\"]");
	By doctor_sample = By.xpath("//div[@class=\"c-profile--qualification\"]");
	By dentist_name = By.xpath("//input[@data-qa-id=\"omni-searchbox-keyword\"]");

	public void selectGender(String gender) {
		// TODO Auto-generated method stub
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(genderButton));
		genderButton.click();
		
		wait.until(ExpectedConditions.visibilityOfAllElements(genderList));
		
		for(int i=0;i<genderList.size();i++)
		{
//			System.out.println(city.getText());
			String doctor=genderList.get(i).getText();
			if(doctor.equals(gender))
			{
				genderList.get(i).click();
				break;
			}
		}
	}

	public Boolean validateGender(String gender) {
		// TODO Auto-generated method stub
		if(genderButton.getText().equals(gender))
		   return true;
		else
		   return false;
	}

	public void selectExperience(String experience) throws InterruptedException {
		// TODO Auto-generated method stub
		experienceButton.click();
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(experienceOptions.get(0)));

		for(int i=0;i<experienceOptions.size();i++)
		{
			String exp=experienceOptions.get(i).getText();
//			System.out.println(experience);
//			System.out.println(1);

			if(exp.equals(experience))
			{
				experienceOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(5000);
		
	}

	public Boolean validateExperience(String experience) {
		// TODO Auto-generated method stub
		if(experienceButton.getText().contains(experience))
			   return true;
			else
			   return false;
	}

	public void selectSortOption(String option) {
		// TODO Auto-generated method stub
		sortByButton.click();
		for(int i=0;i<sortByOptions.size();i++)
		{
//			System.out.println(sortByOptions.get(i).getText());
			String doctor=sortByOptions.get(i).getText();
			if(doctor.equals(option))
			{
				sortByOptions.get(i).click();
				break;
			}
		}
		
	}

	public Boolean validateSortOption(String option) {
		// TODO Auto-generated method stub
//		System.out.println(sortByButton.getText());

		if(sortByButton.getText().equals(option))
			   return true;
			else
			   return false;
	}

	public Boolean selectPatientStory() {
		// TODO Auto-generated method stub
		patientStoryButton.click();
		
		String temp=patientStoryOptions.get(0).getText();
		patientStoryOptions.get(0).click();
		System.out.println(temp+patientStoryButton.getText());
		if(patientStoryButton.getText().contains(temp))
			   return true;
			else
			   return false;
	}

	public void selectFees(String string) throws InterruptedException {
		// TODO Auto-generated method stub
		AllFilters.click();
		for(int i=0;i<fees.size();i++)
		{
//			System.out.println(city.getText());
			String fee=fees.get(i).getText();
			if(fee.equals(string))
			{
				fees.get(i).click();
				break;
			}
		}
		Thread.sleep(4000);
		
	}
 
	public void selectAvailability(String string) throws InterruptedException {
		// TODO Auto-generated method stub
		AllFilters.click();
		System.out.println(string);

		for(int i=0;i<availabilityOption.size();i++)
		{
//			System.out.println(city.getText());
			String available=availabilityOption.get(i).getText();
			System.out.println(available);
			
			if(available.equals(string))
			{
				
				availabilityOption.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);

	}

	public void getDoctorDetails() throws IOException {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(doctor_cards));
		List<WebElement> allDoctors = driver.findElements(doctor_name);
		System.out.println("Total doctors available : " + allDoctors.size());
		int rowNum = 1;
		int colNum = 0;
		for (int i = 0; i < 5; i++) {
			WebElement doctorLink = allDoctors.get(i);
			String doctorName = doctorLink.getText();
			String trimDocName = doctorName.split(":")[0].trim();
 
			String currentWindowHandle = driver.getWindowHandle();
			doctorLink.click();
 
			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(currentWindowHandle)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}
 
			wait.until(ExpectedConditions.elementToBeClickable(doctor_share_story));
			WebElement qualification = driver.findElement(doctor_sample);
			String qual = qualification.getText();
			System.out.println("--------------------------------------------------------------------");
			System.out.println("Details for " + trimDocName + ": " + qual);
			System.out.println("--------------------------------------------------------------------");
            
			excelUtils.createRow(System.getProperty("user.dir")+"/test-output/ExcelData/surguries.xlsx", "Doctors", rowNum, colNum, trimDocName);

			excelUtils.setCellData(System.getProperty("user.dir")+"/test-output/ExcelData/surguries.xlsx", "Doctors", rowNum, colNum, trimDocName);
//			excelUtils.autoSizingCell(System.getProperty("user.dir")+"/test-output/ExcelData/surguries.xlsx", "Doctors", rowNum, colNum);
			colNum += 1;
			
			excelUtils.setCellData(System.getProperty("user.dir")+"/test-output/ExcelData/surguries.xlsx", "Doctors", rowNum, colNum, qual);
//			excelUtils.autoSizingCell(System.getProperty("user.dir")+"/test-output/ExcelData/surguries.xlsx", "Doctors", rowNum, colNum);
			colNum = 0;
			rowNum += 1;
			driver.close();
			driver.switchTo().window(currentWindowHandle);
		}
	}
    
	
	
}
