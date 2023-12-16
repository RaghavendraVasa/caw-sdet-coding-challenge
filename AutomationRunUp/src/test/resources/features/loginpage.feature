Feature: Login Functionality
  Background:
    Given user should be logged in

  Scenario: Successful login with valid credentials
    When Navigate to Swag Labs Website and verify
    Then I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully

  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I have entered invalid "<username>" and "<password>"
    When I click on the login button
    Then I should see an error message indicating "<error_message>"

    Examples:
      | username          | password        | error_message                                         |
      | invalid@email.com | invalidPassword | Warning: No match for E-Mail Address and/or Password. |
      | standard_user  | secret_sauce       | No warning                                            |