Feature: Test vertical swiping functionality

  Scenario: Check if vertical swipe down to element is possible
    Given "Login" page is displayed
    When I login with user "admin" and password "admin"
    Then "Samples List" page is displayed
    When I go to "vertical swipe" view
    Then "Vertical swiping" page is displayed
    And I can vertically swipe down to element with text " Karma"
    And I can vertically swipe down to element with text " C"
    When I log out
    Then "Login" page is displayed
