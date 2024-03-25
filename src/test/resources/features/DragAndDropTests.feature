@dragAndDropTests @regression
Feature: Test drag and drop view functionality

  Scenario: Check if drag "Drag Me" element and drop it to "Drop here" zone generates success message
    Given "Login" page is displayed
    When I login with user "admin" and password "admin"
    Then "Samples List" page is displayed
    When I go to "drag and drop" view
    Then "Drag & Drop" page is displayed
    When I drag "Drag Me" element and drop it to "Drop here" drop zone
    Then Following success message is displayed "Circle dropped"
    When I log out
    Then "Login" page is displayed
