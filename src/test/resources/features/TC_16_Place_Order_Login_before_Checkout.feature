@registered
Feature: Place Order: Login before Checkout
  Scenario:Place Order: Login before Checkout
    Given the browser is launched
    When the user clicks on 'Signup / Login' button
    Then Login to your account  should be visible
    When the user enters name and email address and clicks the Login button
    Then Verify Logged in as username at top
    When Add products to cart and click Cart button
    Then Verify that cart page is displayed
    When the user clicks on proceed To Checkout button
    Then Verify Address Details and Review Your Order
    Then Verify success message 'Congratulations! Your order has been confirmed!


