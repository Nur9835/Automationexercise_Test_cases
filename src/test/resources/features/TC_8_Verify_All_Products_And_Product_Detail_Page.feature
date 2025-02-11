@unregistered
Feature: Verify All Products and Product Detail Page
  Scenario: User should be able to view all products and product details
    Given the browser is launched
    When the user clicks on Products button
    Then the user should be navigated to the ALL PRODUCTS page successfully
    Then Verify that detail detail is visible: product name, category, price, availability, condition, brand