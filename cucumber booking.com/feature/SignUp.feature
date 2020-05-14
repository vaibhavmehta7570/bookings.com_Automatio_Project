Feature: Sign up to the application under test
  @tag1
  Scenario: Sign up to the application
    Given Open chrome browser and launch the application
    When User enters the username onto the username field
    And User enter the password and confirm password onto pw and cpw field
    When User clicks on the create account button 
    