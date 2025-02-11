@unregistered
Feature: Verify address details in checkout page
  Scenario: Verify address details in checkout page
    Given the browser is launched
    When Click Proceed To Checkout then Click Register-Login button And  Fill all details in Signup and create accountt
    Then Verify ACCOUNT CREATED! and click Continue button
    Then Verify Logged in as username at top
    When Add products to cart and click Cart button
    Then Verify that cart page is displayed
    Then Verify that the delivery address and the billing address is same address filled at the time registration of account
    Then Verify success message 'Congratulations! Your order has been confirmed!
    When the user clicks Delete Account button
    Then ACCOUNT DELETED should be visible