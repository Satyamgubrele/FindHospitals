
Feature: smoke

  Scenario: open practo application
    When User navigates to practo home page
    Then validate the title of the page
    
  Scenario Outline: select location
    When User navigates to practo home page
    And User search for location in the location search bar "<location>"
    Then select the location from the options "<location>"
    And validate the location change "<location>"
   
    Examples:
    |  location |
    |  bangalore |
    #|  chennai  |
    #|  pune     |
    
    
  Scenario Outline: select doctor specialization
    When User navigates to practo home page
    And User search for location in the location search bar "<location>"
    Then select the location from the options "<location>"
    And user search for the "<specialization>"
    And select the "<specialization>" from the dropdown
   
    Examples:
    |  location | specialization  |
    |  bangalore | dentist         |
    #|  chennai  | cardiologist    |
    #|  pune     | dermatologist   |
    
  Scenario: Apply gender filter
    When User navigates to practo home page
    And User search for location in the location search bar "<location>"
    Then select the location from the options "<location>"
    And user search for the "<specialization>"
    And select the "<specialization>" from the dropdown
    When user clicks selects the "<gender>"
    Then validate the "<gender>"
    
    Examples:
    |  location | specialization  |   gender        |
    |  bangalore| Dentist         |  Male Doctor    |
    #|  chennai  | cardiologist    |   Female Doctor |
    #|  pune     | dermatologist   |   Male Doctor   |
    
    
  Scenario: Apply experince filter
    When User navigates to practo home page
    And User search for location in the location search bar "<location>"
    Then select the location from the options "<location>"
    And user search for the "<specialization>"
    And select the "<specialization>" from the dropdown  
    When user selects the experience "<experience>"
    Then validate the experience "<experience>"
    
     Examples:
    |  location | specialization  |   experience  |
    |  bangalore | dentist         |   5+ Years of experience         |
    #|  chennai  | cardiologist    |   10+ Years of experience         |
    #|  pune     | dermatologist   |   15+ Years of experience        |
    
  Scenario: Apply sort filter
    When User navigates to practo home page
    And User search for location in the location search bar "<location>"
    Then select the location from the options "<location>"
    And user search for the "<specialization>"
    And select the "<specialization>" from the dropdown
    When user selects the sort by "<option>"
    Then Validate the sort by "<option>"
    
    Examples:
    |  location | specialization  |   option                                  |
    |  bangalore | dentist        |   Experience - High to Low               |
    #|  chennai  | cardiologist    |  Experience - High to Low                 |
    #|  pune     | dermatologist   |  Consultation Fee - Low to High           |
    
  Scenario: Apply patient story filter
    When User navigates to practo home page
    And User search for location in the location search bar "<location>"
    Then select the location from the options "<location>"
    And user search for the "<specialization>"
    And select the "<specialization>" from the dropdown
    Then user selects patient story option and validate
    
    
   Examples:
    |  location | specialization  |  
    |  bangalore | dentist         |   
    #|  bangalore  | cardiologist    |  
    #|  bangalore    | dermatologist   |  
   

  Scenario: Apply cost filter
    When User navigates to practo home page
    And User search for location in the location search bar "<location>"
    Then select the location from the options "<location>"
    And user search for the "<specialization>"
    And select the "<specialization>" from the dropdown
    Then user selects the cost filter with cost "<cost>"
    
    
    Examples:
     |  location | specialization  |  cost   |
     |  bangalore | dentist         |  ₹0-₹500 |
    #|  chennai  | cardiologist    |  Above ₹500  |
    #|  pune     | dermatologist   |  Above ₹1000|
    #
   Scenario: Apply availability filter
    When User navigates to practo home page
    And User search for location in the location search bar "<location>"
    Then select the location from the options "<location>"
    And user search for the "<specialization>"
    And select the "<specialization>" from the dropdown
    Then user selects the availability filter with "<availibility>"
    
    Examples:
     |  location | specialization  |  availibility  |
     |  bangalore | dentist        |  Available in next 4 hours |
     #|  chennai  | cardiologist    |  Available Today  |
     #|  pune     | dermatologist   |  Available Tomorrow  |
    #
  Scenario: click on surgery
    When User navigates to practo home page
    And user clciks on the surgery option
    Then Validate the title of the surgery page as "Practo Care Surgeries | End to end care from top surgeons in your city"
    
  Scenario: count and store the popular surgery options
    When User navigates to practo home page
    And  user clciks on the surgery option
    Then count and store all the surgeries
    
  Scenario: open health and wellness plans
    When User navigates to practo home page
    And user selects health and wellness plans from the for corporates option
    Then validate the health and wellness plans page with title "Employee Health | Corporate Health & Wellness Plans | Practo"
    
  Scenario: fill heath&wellness form with invalid format
    When User navigates to practo home page
    And user selects health and wellness plans from the for corporates option
    And user fills the details from excel with index as "<index>"
    Then check if the schedule demo button is disabled
    
    Examples:
     |   index  |
     |       0  |
     #|       1  |
     #|       2  |
    
  Scenario: Capture the thank you message
    When User navigates to practo home page
    And user selects health and wellness plans from the for corporates option
    And user fills the details from excel with index as "<index>"
    Then user clicks on take a demo button
    And validate the thank you message
    
     Examples:
     |   index  |
     |       3  |
     #|       4  |
     #|       5  |
    
    
  
    
    
   
    
     
     

  
    

   
