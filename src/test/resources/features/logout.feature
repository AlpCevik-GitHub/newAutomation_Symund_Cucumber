Feature:Symund app logout feature

  User Story:As a user, I should be able to logout.

@logout
  Scenario:log out as employee
    Given User is on the Dashboard Page
    When User click log out button
    Then User ends up in login page