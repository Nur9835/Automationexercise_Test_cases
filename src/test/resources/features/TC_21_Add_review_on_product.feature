@unregistered
Feature: Add review on product
  Scenario: Add review on product
    Given the browser is launched
    When the user clicks on Products button
    Then the user should be navigated to the ALL PRODUCTS page successfully
    Then Verify Write Your Review is visible
    Then Verify success message Thank you for your review.
