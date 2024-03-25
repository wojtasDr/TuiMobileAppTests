@wheelPickerTests @regression
Feature: Test wheel picker view functionality

  Scenario: Check if long press on "Long Press Me" button generates success alert
    Given "Login" page is displayed
    When I login with user "admin" and password "admin"
    Then "Samples List" page is displayed
    When I go to "wheel picker" view
    Then "Wheel Picker Demo" page is displayed
    When I set spinner color to "blue"
    Then The "blue" color is set
    When I log out
    Then "Login" page is displayed
