package com.FindHospitals.stepDefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.junit.Assert;

import com.FindHospitals.pageObjects.*;
import com.FindHospitals.utils.baseClass;

import io.cucumber.java.en.*;

public class Definition {

	static PractoHomePage practoHomePage;
	static Properties p;
	static specialityPage spPage;
	static surgeryPage surPage;
	static healthWellnessPage HWpage;
	List<HashMap<String, String>> dataMap;
	
	@When("User navigates to practo home page")
	public void User_navigates_to_practo_home_page() {
		practoHomePage= new PractoHomePage(baseClass.getDriver());

	}
	

	@Then("validate the title of the page")
	public void validate_the_title_of_the_page()
	{
		p = baseClass.getProperties();
		System.out.println(practoHomePage.GetTitle());
		Assert.assertEquals(practoHomePage.GetTitle(),p.getProperty("title"));
	}
	
	@When("User search for location in the location search bar {string}")
	public void user_search_for_location_in_the_location_seach_bar(String location) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
//		System.out.println(location);
		practoHomePage.setLocation(location);
	    
	}
	@Then("select the location from the options {string}")
	public void select_the_location_from_the_options(String location) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    practoHomePage.chooseLocation(location);
	}
	@Then("validate the location change {string}")
	public void validate_the_location_change(String location) {
	    // Write code here that turns the phrase above into concrete actions
	    Boolean flag=practoHomePage.validateLocation(location);
	    Assert.assertTrue(flag);
	}
	
	@Then("user search for the {string}")
	public void user_seacrch_for_the(String speciality) {
	    // Write code here that turns the phrase above into concrete actions
		practoHomePage.searchSpeciality(speciality);
	}
	@Then("select the {string} from the dropdown")
	public void select_the_from_the_dropdown(String specialization) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		practoHomePage.selectSpeciality(specialization);
		Thread.sleep(4000);
		spPage=new specialityPage(baseClass.getDriver());
//		spPage=new specialityPage(baseClass.getDriver());
		
	}

	@When("user clicks selects the {string}")
	public void user_clicks_selects_the(String gender) {
	    // Write code here that turns the phrase above into concrete actions
		
		spPage.selectGender(gender);
	}
    
	@Then("validate the {string}")
	public void validate_the(String gender) {
	    // Write code here that turns the phrase above into concrete actions
		Boolean flag=spPage.validateGender(gender);
		Assert.assertTrue(flag);
	}
	
	@When("user selects the experience {string}")
	public void user_selects_the_experience(String string) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		spPage.selectExperience(string);
	}

	@Then("validate the experience {string}")
	public void  validate_the_experience(String string) {
	    // Write code here that turns the phrase above into concrete actions
		Boolean flag=spPage.validateExperience(string);
		Assert.assertTrue(flag);
	}
	
	@When("user selects the sort by {string}")
	public void user_selects_the_sort_by(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    spPage.selectSortOption(string);
	}

	@Then("Validate the sort by {string}")
	public void validate_the_sort_by(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    Boolean flag=spPage.validateSortOption(string);
	    Assert.assertTrue(flag);
	}

	@Then("user selects patient story option and validate")
	public void user_selects_patient_story_option() {
	    // Write code here that turns the phrase above into concrete actions
		Boolean flag=spPage.selectPatientStory();
		Assert.assertTrue(flag);
	    
	}
	
	@Then("user selects the cost filter with cost {string}")
	public void user_selcts_the_cost_filter_with_cost(String string) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    spPage.selectFees(string);
	    
	}

	@Then("user selects the availability filter with {string}")
	public void user_selcts_the_availability_filter_with_cost(String string) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    spPage.selectAvailability(string);
	}


	@When("user clciks on the surgery option")
	public void user_clciks_on_the_surgery_option() {
	    // Write code here that turns the phrase above into concrete actions
		practoHomePage.clcikOnSurgury();
		surPage=new surgeryPage(baseClass.getDriver());
	}

	@Then("Validate the title of the surgery page as {string}")
	public void validate_the_title_of_the_surgery_page_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertTrue(surPage.validateSurgeryPage(string));
	}
	
	@Then("count and store all the surgeries")
	public void count_and_store_all_the_surgeries() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		surPage.countAndStoreSurgery();
	    
	}
	
	@When("user selects health and wellness plans from the for corporates option")
	public void user_selects_health_and_wellness_plans_from_the_for_corporates_option() {
	    // Write code here that turns the phrase above into concrete actions
	    practoHomePage.selectHealthFitness();
	    HWpage=new healthWellnessPage(baseClass.getDriver());
	}

	@Then("validate the health and wellness plans page with title {string}")
	public void validate_the_health_and_wellness_plans_page_with_title(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertTrue(HWpage.validate(string));
	}
	

	
	
	@When("user fills the details from excel with index as {string}")
	public void user_fills_the_details_from_excel_with_index_as(String index) {
	    // Write code here that turns the phrase above into concrete actions
		HWpage.fillForm(index);
	}
	
	@Then("check if the schedule demo button is disabled")
	public void check_if_the_schedule_demo_button_is_disabled() {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertTrue(HWpage.isDemoButtonDisabled());
	}

	@Then("user clicks on take a demo button")
	public void user_clicks_on_take_a_demo_button() {
	    // Write code here that turns the phrase above into concrete actions
	    HWpage.submit();
	}

	@Then("validate the thank you message")
	public void validate_the_thank_you_message() {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertTrue(HWpage.validateThankYou());
	}
	@Then("Store the details of top {int} doctors")
	public void store_the_details_of_top_doctors(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@Then("Store the details of top five doctors")
	public void Store_the_details_of_top_five_doctors() throws IOException
    {
    	spPage.getDoctorDetails();
    }
}
