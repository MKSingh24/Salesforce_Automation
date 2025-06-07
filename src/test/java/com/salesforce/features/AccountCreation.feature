Feature: Account creation
  Background:
    Given User open salesforce login url
    When User enter valid credentials
    And User click on login button
    Then User should be logged successfully
    And User choose "Sales" from App Launcher

  @Regression @SanityTest @mergeCheck
  Scenario Outline: Creation of account in salesforce
    Given User click on "Accounts" tab
    When  User click on new button in Account tab
    Then  User creates new account by populating "<Account Name>" and "<Rating>" fields
    And   User click on save button in "Accounts" tab
    Then  User verify account is created successfully


    Examples:
      | Account Name      | Rating |
      | Test Automation 1 | Hot    |
      | Test Automation 2 | Cold   |
      | Test Automation 3 | Warm   |
