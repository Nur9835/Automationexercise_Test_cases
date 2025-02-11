@unregistered
Feature: Add Product In Cart
  Scenario:Add Product In Cart
    Given the browser is launched
    When the user clicks on Products button and add products to cart and click View Cart button
    Then Verify both products are added to Cart
    Then Verify their prices, quantity and total price
