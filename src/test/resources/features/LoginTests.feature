@loginTests @regression
Feature: Test login and log out functionality

  @smoke
  Scenario: Check if possible to login with valid credentials and log out
    Given "Login" page is displayed
    When I login with user "admin" and password "admin"
    Then "Samples List" page is displayed
    When I log out
    Then "Login" page is displayed

  Scenario Outline: Check if authentication failed when login with invalid credentials
    Given "Login" page is displayed
    When I login with user "<userName>" and password "<password>"
    Then Following alert message is displayed "Invalid  Credentials"
    When I click OK to close alert
    Then "Login" page is displayed

    Examples:
      | userName | password |
      | admin    | amin     |
      | Admin    | admin    |
      | admin1   | Admin    |