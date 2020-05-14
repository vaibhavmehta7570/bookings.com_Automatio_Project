Feature: Searching for car in the car rental option on the application under test.

  @tag1
  Scenario: Search for the car.
    Given Open chrome browser and launch the application
    When user logged in to the application
    And User clicks on the car rental option
    And enter a pickup location
    When user clicks on the search button
    
   

 