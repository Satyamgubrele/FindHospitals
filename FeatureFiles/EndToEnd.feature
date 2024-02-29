
Feature: EndToEnd 

  Scenario Outline: Selecting Doctors
    When User navigates to practo home page
    Then validate the title of the page
    And User search for location in the location search bar "<location>"
    Then select the location from the options "<location>"
    And validate the location change "<location>"
    And user search for the "<specialization>"
    And select the "<specialization>" from the dropdown
    When user clicks selects the "<gender>"
    Then validate the "<gender>"
    When user selects the experience "<experience>"
    Then validate the experience "<experience>"
    When user selects the sort by "<option>"
    Then Validate the sort by "<option>"
    Then user selects patient story option and validate
    Then user selects the cost filter with cost "<cost>"
    Then user selects the availability filter with "<availibility>"
    And Store the details of top five doctors
    
    Examples:
    |  location | specialization|   gender     |   experience           |    option                   | cost       | availibility  |
    | bangalore | Dentist       | Male Doctor  | 5+ Years of experience |Experience - High to Low     | ₹0-₹500    |Available in next 4 hours |
    #|  chennai  | cardiologist  | Female Doctor| 10+ Years of Experience|Experience - High to Low     |Above ₹500  |Available Today         |
    #|  pune     | dermatologist | Male Doctor  | 15+ Years of Experience|Consultation Fee - Low to High|Above ₹1000|Available Tomorrow      |
    
    
  Scenario: Store all the surgery
    When User navigates to practo home page
    And user clciks on the surgery option
    Then Validate the title of the surgery page as "Practo Care Surgeries | End to end care from top surgeons in your city"
    Then count and store all the surgeries
    
  Scenario Outline: Health and Wellness form
    When User navigates to practo home page
    And user selects health and wellness plans from the for corporates option
    Then validate the health and wellness plans page with title "Employee Health | Corporate Health & Wellness Plans | Practo"
    And user fills the details from excel with index as "<index>"
    Then check if the schedule demo button is disabled
    And user fills the details from excel with index as "<ind>"
    Then user clicks on take a demo button
    And validate the thank you message
    
     Examples:
     |   index  | ind  |
     |       0  |  3   |
     #|       1  |  4   |
     #|       2  |  5   |
