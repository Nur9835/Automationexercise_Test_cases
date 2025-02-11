@unregistered
Feature: Place Order: Register before Checkout
  Scenario:Place Order: Register before Checkout
    Given the browser is launched
    When the user clicks on 'Signup / Login' button
    Then New User Signup! should be visible
    When the user enters name and email address and clicks the Signup button
    Then ENTER ACCOUNT INFORMATION should be visible
    When the user fills in account details
    Then ACCOUNT CREATED should be visible
    When the user clicks 'Continue' button
    Then Logged in as username should be visible
    When Add products to cart and click Cart button
    Then Verify that cart page is displayed
    When the user clicks on proceed To Checkout button
    Then Verify Address Details and Review Your Order
    Then Verify success message 'Congratulations! Your order has been confirmed!
