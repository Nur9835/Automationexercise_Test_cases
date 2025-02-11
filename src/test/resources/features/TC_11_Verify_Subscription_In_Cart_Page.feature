@unregistered
Feature: Verify Subscription in Cart Page
  Scenario:Verify Subscription in Cart Page
    Given the browser is launched
    When the user clicks on Cart button and scroll down to footer
    When the user scroll down to footer
    Then SUBSCRIPTION should be visible
    When the user enter email address in input and click arrow button
    Then Verify success message You have been successfully subscribed! is visible
