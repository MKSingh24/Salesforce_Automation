Feature: Opportunities creation
  Background:
    Given User open salesforce login url
    When User enter valid credentials
    And User click on login button
    Then User should be logged successfully

  Scenario: Creation of Opportunities in salesforce
    Given User click on "Opportunities" tab
    When  User click on new button in Opportunities tab
    Then  User creates new Opportunities by populating mandatory fields
    And   User click on save button in "Opportunities" tab