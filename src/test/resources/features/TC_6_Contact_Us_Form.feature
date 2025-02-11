@unregistered
Feature: Contact Us Form Submission
  Scenario: Submit the contact us form successfully
    Given the browser is launched
    When the user clicks on Contact Us button
    Then GET IN TOUCH should be visible
    When the user enters name,email,subject,message, upload a file and click Submit and OK button on the alert button
    Then Success! Your details have been submitted successfully. should be visible
    Then the user click Home button and verify that landed on the home page successfully

