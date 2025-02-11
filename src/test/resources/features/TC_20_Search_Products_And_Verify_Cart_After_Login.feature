@unregistered
Feature: Search Products and Verify Cart After Login
  Scenario: Search Products and Verify Cart After Login
    Given the browser is launched
    When the user clicks on Products button
    Then the user should be navigated to the ALL PRODUCTS page successfully
    When the user enters a product name in the search input and click the search button
    Then SEARCHED PRODUCTS should be visible
    When Add those products to cart
    And Click Cart button and verify that products are visible in cart
    Then Verify that those products are visible in cart after login as well
    Then Verify Cart is empty! Click here to buy products. is visible

