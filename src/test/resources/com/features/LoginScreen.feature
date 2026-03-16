
@feature_user_login
Feature: LoginScreen

  Background: 
    Given the user is on the Login Screen

  @valid-login
  Scenario Outline: Verify that a user can successfully log in using valid Organization, Email, and Password
    When I enter "<organization>" in the Organization field
    And I enter "<email>" in the Email field
    And I enter "<password>" in the Password field
    And the user clicks the Login button
    Then the user should be redirected to the home screen
    And a welcome message should be displayed on the home screen

    Examples:
      | organization      | email              | password           |
      | MyOrganization    | user@example.com   | SecurePassword123  |

@enabled_login_button
Scenario Outline: Verify that the Login button is enabled when all required fields are filled with valid data
  When I enter "<organization>" in the Organization field
  And I enter "<email>" in the Email field
  And I enter "<password>" in the Password field
  Then the Login button should be enabled

Examples:
  | organization     | email              | password            |
  | MyOrganization    | user@example.com   | SecurePassword123   |

  @valid-navigation
  Scenario Outline: Verify navigation to Forgot Password screen
    When the user clicks the Forgot Password link
    Then the user should be redirected to the Forgot Password screen
    And the Forgot Password screen displays Organization and Email fields

  Examples:
    | action                       |
    | Launch the application URL.  |
    | Locate and click the Forgot Password link. |

@valid-password-reset
Scenario Outline: Verify that the user can successfully send a password reset email
  Given the user enters "<organization>" in the Organization field
  And the user enters "<email>" in the Email field
  When the user clicks the Send button
  Then the system processes the request and displays a confirmation message
  And the user receives a password reset email in their inbox

  Examples:
    | organization          | email                   |
    | ValidOrganizationName | valid.email@example.com |

  @login-button-disabled
  Scenario Outline: Verify that the Login button remains disabled when only Organization and Email are filled, but Password is empty
    When the user enters a valid Organization name in the Organization field
    And the user enters a valid Email address in the Email field
    And the user leaves the Password field empty
    Then the Login button remains disabled

    Examples:
      | Organization              | Email                     | Password |
      | valid_organization_name    | valid_email@example.com   |          |

  @disabled-login-button
  Scenario Outline: Verify that the Login button remains disabled
    When I enter a valid Organization name in the Organization field
    And I leave the Email field empty
    And I enter a valid Password in the Password field
    Then the Login button remains disabled

    Examples:
      | Organization      | Password       |
      | validOrgName     | validPassword   |

  @disabled-login-button
  Scenario Outline: Verify that the Login button remains disabled when only Email and Password are filled, but Organization is empty
    When the user leaves the Organization field empty
    And the user enters <email> in the Email field
    And the user enters <password> in the Password field
    Then the Login button should remain disabled

    Examples:
      | email               | password          |
      | krishna@gmail.com   | ValidPassword123  |

  @ui-elements-validation
  Scenario Outline: Verify Presence of UI Elements on Login Screen
    When I launch the application URL
    Then the <field> field is displayed

    Examples:
      | field               |
      | Organization        |
      | Email               |
      | Password            |
      | Forgot Password link |
      | Login button        |

  @ui-elements-check
  Scenario Outline: Verify UI elements on Forgot Password screen
    When I launch the application URL
    And I click the Forgot Password link to navigate to the Forgot Password screen
    Then the Organization field is displayed
    And the Email field is displayed
    And the Send button is displayed

  Examples:
    |   |
    |   |

  @disabled-login-button
  Scenario Outline: Verify that the Login button remains disabled after entering an invalid Organization
    When I enter "<organization>" in the Organization field
    And I enter "<email>" in the Email field
    And I enter "<password>" in the Password field
    Then the Login button should remain disabled

    Examples:
      | organization            | email                   | password      |
      | invalid_organization_name | valid_email@example.com | valid_password |
