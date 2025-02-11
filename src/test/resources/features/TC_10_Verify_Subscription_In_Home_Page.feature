@unregistered
Feature: Verify Subscription in Home Page
  Scenario:Verify Subscription in Home Page
    Given the browser is launched
    When the user scroll down to footer
    Then SUBSCRIPTION should be visible
    When the user enter email address in input and click arrow button
    Then Verify success message You have been successfully subscribed! is visible
