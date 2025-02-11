@registered
Feature: User Logout
  Scenario: User Successfully Login with correct email and password
    Given the browser is launched
    When the user clicks on 'Signup / Login' button
    Then Login to your account  should be visible
    When the user enters name and email address and clicks the Login button
    Then Logged in as username should be visible-login
    Then the user clicks on Logout button and  should be navigated to the login page
