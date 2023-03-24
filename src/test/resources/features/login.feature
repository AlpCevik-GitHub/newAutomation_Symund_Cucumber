@SYMU10-394
Feature:Symund app login feature

  User Story:As a user, I should be able to login.


  Background: For the scenarios in the feature file, user is expected to be on login page
    Given user is on the Symund login page

  @SYMU10-339
  Scenario: Login as employee
    When user enters employee username in username field

      | username | Employee40 |
    And user enters employee password in  password field

      | password | Employee123 |
    And user hit the enter
    Then user should see the dashboard

  @SYMU10-353
  Scenario Outline: Login as employee
    When user enters employee as a "<invalid username>" and "<invalid password>"
    And user hit the enter
    Then user should see wrong message
    Examples:
      | invalid username | invalid password |
      | Employee40       | Employee124      |
      | asdasdasd        | asdasdasd        |


  @SYMU10-355
  Scenario Outline: Login as employee
    When user enters employee as a "<invalid username>" and "<invalid password>"
    And user click the login button
    Then user should see wrong message
    Examples:
      | invalid username | invalid password |
      | Employee40       | Employee124      |
      | asdasdasd        | asdasdasd        |

  @SYMU10-354
  Scenario Outline: Login as employee
    When user enters employee "<username>" and "<password>"
    And user hit the enter
    Then user should see Please fill out this field message

    Examples:
      | username  | password    |
      |           | Employee124 |
      | asdasdasd |             |

  @SYMU10-356
  Scenario Outline: Login as employee
    When user enters employee "<invalid username>" and "<invalid password>"
    And user click the login button
    Then user should see Please fill out this field message

    Examples:
      | invalid username | invalid password |
      |                  | Employee124      |
      | asdasdasd        |                  |

  @SYMU10-370
  Scenario: Login as employee
    When User can see the password in a form of dots by default

  @SYMU10-384
  Scenario: User can see password explicitly
    When user enters employee password in  password field
      | password | Employee123 |
    And user click explicitly image to see password
    Then user  can see password explicitly

  @SYMU10-386
  Scenario: Login as employee
    When user can see Forgot password? link
    And user click on forget password link
    Then user can see the Reset Password button on the next page

  @SYMU10-388
  Scenario: Login as employee
    When User can see valid placeholders on Username and Password fields