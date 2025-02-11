@unregistered @register
Feature: User Registration and Account Management
  Scenario: User Successfully Signs Up and Deletes Account
    Given the browser is launched
    When the user clicks on 'Signup / Login' button
    Then New User Signup! should be visible
    When the user enters name and email address and clicks the Signup button
    Then ENTER ACCOUNT INFORMATION should be visible
    When the user fills in account details
    Then ACCOUNT CREATED should be visible
    When the user clicks 'Continue' button
    Then Logged in as username should be visible


