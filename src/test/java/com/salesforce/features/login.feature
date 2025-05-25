Feature: Test salesforce login feature

  @SmokeTest @Regression
  Scenario: Verify user able to login with valid credentials
    Given User open salesforce login url
    When User enter valid credentials
    And User click on login button
    Then User should be logged successfully

  @Regression @ErrorValidation
  Scenario: Verify whether error is displayed when invalid credentials are entered
    Given User open salesforce login url
    When User enter invalid credentials
    And User click on login button
    Then User should see an error message