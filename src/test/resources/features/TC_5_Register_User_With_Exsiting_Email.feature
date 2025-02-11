@registered
Feature: Signup with an already registered email
  Scenario: User should see an error when signing up with an already registered email
    Given the browser is launched
    When the user clicks on 'Signup / Login' button
    Then New User Signup! should be visible
    When the user enters name and an already registered email address and clicks the Signup button
    Then the error message Email Address already exist! should be visible

