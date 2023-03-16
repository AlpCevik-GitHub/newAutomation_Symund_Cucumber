@Outline
Feature:Symund app login feature

  User Story:As a user, I should be able to login.


  Background: For the scenarios in the feature file, user is expected to be on login page
    Given user is on the Symund login page
  @SYMU10-339 @first
  Scenario: Login as employee
    When user enters employee username in username field

      | username | Employee40 |
    And user enters employee password in  password field

      | password | Employee123 |
    And user hit the enter or click  login button
    Then user should see the dashboard

  @SYMU10-353
  Scenario Outline: Login as employee
    When user enters employee "<invalid username>" and "<invalid password>"
    And user hit the enter or click  the login button
    Then user should see wrong message
    Examples:
      | invalid username | invalid password |
      | Employee40       | Employee124      |
      | asdasdasd        | asdasdasd        |
  @SYMU10-354 @second
  Scenario Outline: Login as employee
    When user enters employee "<invalid username>" and "<invalid password>"
    And user hit the enter or click  the login button
    Then user should see Please fill out this field message
    Examples:
      | invalid username | invalid password |
      |                  | Employee124      |
      | asdasdasd        |                  |
@SYMU10-370
Scenario: Login as employee
  When User can see the password in a form of dots by default

  @third
  Scenario: Login as employee
    When user can see Forgot password? link
    And user click on forget password link
    Then user can see the Reset Password button on the next page

