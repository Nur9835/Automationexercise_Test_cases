@unregistered
Feature: Verify Product Quantity In Cart
  Scenario:Verify Product Quantity In Cart
    Given the browser is launched
    When the user clicks on View Product for any product on home page
    Then Verify product detail is opened
    When Increase quantity to 4,click Add to cart button and View button
    Then Verify that product is displayed in cart page with exact quantity
