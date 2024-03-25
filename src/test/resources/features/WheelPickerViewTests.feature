Feature: Test long press view functionality

  @dev1
  Scenario: Check if long press on "Long Press Me" button generates success alert
    Given "Login" page is displayed
    When I login with user "admin" and password "admin"
    Then "Samples List" page is displayed
    When I go to "wheel picker" view
    Then "Wheel Picker Demo" page is displayed
    When I set following spinner color "blue"
    Then Following color is set "blue"
    When I log out
    Then "Login" page is displayed
