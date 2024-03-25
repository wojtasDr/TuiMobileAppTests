Feature: Test double tap functionality

  Scenario: Check if double tap on "Double Tap Me" button generates success alert
    Given "Login" page is displayed
    When I login with user "admin" and password "admin"
    Then "Samples List" page is displayed
    When I go to "double tap" view
    Then "Double Tap Demo" page is displayed
    When I double tab "Double Tap Me" button
    Then Following alert message is displayed "Double tap successful!"
    When I click OK to close alert
    And I log out
    Then "Login" page is displayed
