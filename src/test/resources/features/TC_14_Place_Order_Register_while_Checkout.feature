@unregistered
Feature: Place Order: Register while Checkout
  Scenario:Place Order: Register while Checkout
    Given the browser is launched
    When click Product
    When Add products to cart and click Cart button
    Then Verify that cart page is displayed
    When Click Proceed To Checkout then Click Register-Login button And  Fill all details in Signup and create accountt
    Then Verify ACCOUNT CREATED! and click Continue button
    Then Verify Logged in as username at top
    Then Verify Address Details and Review Your Order
    Then Verify success message 'Congratulations! Your order has been confirmed!