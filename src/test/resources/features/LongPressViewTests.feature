@longPressTests @regression
Feature: Test long press view functionality

  Scenario: Check if long press on "Long Press Me" button generates success alert
    Given "Login" page is displayed
    When I login with user "admin" and password "admin"
    Then "Samples List" page is displayed
    When I go to "long press" view
    Then "Long Press Demo" page is displayed
    When I press long "Long Press Me" button
    Then Following alert message is displayed "you pressed me hard :P"
    When I click OK to close alert
    And I log out
    Then "Login" page is displayed
