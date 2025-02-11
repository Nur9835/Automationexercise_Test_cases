@unregistered @d
Feature: Remove Products From Cart
  Scenario:Remove Products From Cart
    Given the browser is launched
    When Add products to cart and click Cart button
    Then Verify that cart page is displayed
    When the user click on X button corresponding to particular product
    Then Verify that product is removed from the cart