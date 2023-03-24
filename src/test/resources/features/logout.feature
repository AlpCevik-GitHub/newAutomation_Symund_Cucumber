@SYMU10-484
Feature:Symund app logout feature

  User Story:As a user, I should be able to logout.

  Background:
    Given user is on the dashboard page
  @SYMU10-482
  Scenario:log out as employee
    When User click log out button
    Then User ends up in login page


@SYMU10-483
  Scenario:log out as employee
    When User click log out button
    And User click  step back button
    Then User can not go to home page