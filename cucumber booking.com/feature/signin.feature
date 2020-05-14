Feature: megento application

Scenario: Check the login functionality with valid credentials
    Given Launch the browser and open application
    When click on sign in button 
    And enter the valid email address and click on next button
    And enter the password and click on sign in button
  	Then Validate if User is sucessfully loged in