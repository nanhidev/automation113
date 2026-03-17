
@feature_user_login
Feature: HomeScreen

Background: 
  Given the user is on the Login Page

@successful-login
Scenario Outline: Verify that the user is redirected to the Home screen after a successful login
  When I enter "<username>"
  And I enter "<password>"
  And the user clicks the "Login" button
  Then the user should be redirected to the Home screen
  And the URL of the Home screen should be displayed correctly
  And no error messages should be shown
  And the Home screen should load within an acceptable time frame

Examples:
  | username        | password            |
  | validUser123    | SecurePassword!2023  |

  Scenario Outline: Home Screen Greeting Display
    When the system retrieves the username of the logged-in user
    And the system constructs the greeting message
    Then the greeting text is displayed as "Hello <username>, what would you like to do today?"
    And the username is correctly displayed in the greeting
    And the greeting text is prominently visible

    Examples:
      | username  |
      | John Doe  |

  Scenario Outline: Home Screen
    Then the "<module>" module is visible
    And all modules are clickable and lead to the respective pages

    Examples:
      | module                        |
      | Operations Management         |
      | BI Reporting                 |
      | Telephone Booking Service     |
      | Customer Support Portal       |

  @verify_profile_information
  Scenario Outline: Verify that the user's profile information is visible on the Home screen
    When the system retrieves user profile information
    Then the user's name is displayed correctly
    And the user's email address is displayed correctly
    And the user's profile picture is displayed
    And the user's role or designation is displayed

  Examples:
    | username | email              | profile_picture | role          |
    | <username> | <email>          | <profile_picture> | <role>       |

  @navigation_operations_management
  Scenario Outline: Verify that clicking on Operations Management module navigates to the correct page
    When the user clicks on "<module>" module
    Then the user is navigated to the "<expected_page>" page

    Examples:
      | module                        | expected_page                  |
      | Operations Management         | Operations Management          |
      | BI Reporting                  | BI Reporting                   |
      | Telephone Booking Service     | Telephone Booking Service      |
      | Customer Support Portal       | Customer Support Portal        |

  @profile-update
  Scenario Outline: Verify that updates made to profile are reflected on the Home screen
    When the user updates their profile information with the name <name> and email <email>
    And the user saves the changes
    And the user refreshes the Home screen
    Then the updated profile information should be displayed on the Home screen
    And no old information should be visible

    Examples:
      | name    | email               |
      | krishna | krishna@gmail.com   |

  @successful_logout
  Scenario Outline: Verify that the user can log out successfully
    When the user clicks on the "Logout" button
    Then the user should be redirected to the login page
    And the user should no longer be able to access the Home screen
    And a confirmation message should be displayed indicating successful logout

  Examples:
    | action                |
    | Logout button clicked  |

  @verify_current_date_time
  Scenario Outline: Home Screen displays current date and time correctly
    When the system retrieves the current date and time
    Then the current date is displayed correctly
    And the current time is displayed correctly
    And the date and time format is consistent with user locale settings

  Examples:
    | current_date | current_time |
    | <current_date> | <current_time> |

  @verify_notifications
  Scenario Outline: Home Screen
    When the system retrieves user notifications
    Then notifications are displayed prominently on the Home screen
    And notifications are relevant to the user
    And notifications are clickable and lead to the relevant pages

  Examples:
    | username | password |
    | user1    | pass1    |

  @customization-test
  Scenario Outline: Verify that users can customize their Home screen layout or modules as per their preferences
    When the user selects customization options
    And the user saves the changes
    And the user refreshes the Home screen
    Then the Home screen reflects the customized layout
    And the user's preferences are saved correctly

  Examples:
    | customization_options |
    | rearranging modules    |
