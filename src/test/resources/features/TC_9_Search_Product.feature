@unregistered
Feature: Search Product
  Scenario: Search for a product
    Given the browser is launched
    When the user clicks on Products button
    Then the user should be navigated to the ALL PRODUCTS page successfully
    When the user enters a product name in the search input and click the search button
    Then SEARCHED PRODUCTS should be visible
    Then Verify all the products related to search are visible