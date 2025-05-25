Feature: Contacts creation
  Background:
    Given User open salesforce login url
    When User enter valid credentials
    And User click on login button
    Then User should be logged successfully
    And User choose "Sales" from App Launcher

   @Regression
  Scenario: Creation of contact in salesforce
    Given User click on "Contacts" tab
    When  User click on new button in Contacts tab
    Then  User creates new contact by populating mandatory fields
    And   User click on save button in "Contacts" tab