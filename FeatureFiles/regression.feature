@tag
Feature: regresssion

  @regression
  Scenario: gender and experience filter
    When User navigates to practo home page
    And User search for location in the location search bar "<location>"
    Then select the location from the options "<location>"
    And user search for the "<specialization>"
    And select the "<specialization>" from the dropdown
    When user clicks selects the "<gender>"
    Then validate the "<gender>"
    When user selects the experience "<experience>"
    Then validate the experience "<experience>"
    
    Examples:
    |  location | specialization  |   gender        |   experience  |
    |  bangalore| Dentist         |  Male Doctor    | 5+ Years of experience |
    #|  chennai  | cardiologist    |   Female Doctor | 10+ Years of experience |
    #|  pune     | dermatologist   |   Male Doctor   | 15+ Years of experience |
    
    @regression
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
    
    @regression
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
    |  bangalore| Dentist         |   Male Doctor   |
    #|  chennai  | cardiologist    |   Female Doctor |
    #|  pune     | dermatologist   |   Male Doctor   |
  