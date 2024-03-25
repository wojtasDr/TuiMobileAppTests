Feature: Test samples list functionality

  Scenario Outline: Check if possible to login, go to chosen view and log out
    Given "Login" page is displayed
    When I login with user "admin" and password "admin"
    Then "Samples List" page is displayed
    When I go to "<viewName>" view
    Then "<expectedViewPageTitle>" page is displayed
    When I log out
    Then "Login" page is displayed

    Examples:
      | viewName       | expectedViewPageTitle       |
      | native         | Native View Demo            |
      | vertical swipe | Vertical swiping            |
      | drag and drop  | Drag & Drop                 |
      | double tap     | Double Tap Demo             |
      | photo          | Photos - Ping & Zoom        |
      | web            | Webview                     |
      | carousel       | Carousel - Swipe left/right |
      | wheel picker   | Wheel Picker Demo           |
