Feature: Case creation
  Background:
    Given User open salesforce login url
    When User enter valid credentials
    And User click on login button
    Then User should be logged successfully
    And User choose "Sales" from App Launcher

  @Cases
  Scenario: Creation of contact in salesforce
    Given User click on "Cases" tab
    When  User click on new button in Cases tab
    Then  User creates new case by populating mandatory fields
    And   User click on save button in "Cases" tab