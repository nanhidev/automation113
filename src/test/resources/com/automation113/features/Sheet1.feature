
Feature: Sheet1
  @feature_user_login
  Background: 
    Given the user is on the Login Screen

  @valid_login
  Scenario Outline: Login Screen
    When the user enters their Organization as <organization>
    And the user enters their Email as <email>
    And the user enters their Password as <password>
    Then the user should be able to access the platform

    Examples:
      | organization | email              | password   |
      | Org1         | user1@example.com  | pass123    |
      | Org2         | user2@example.com  | pass456    |

  @forgot_password
  Scenario Outline: Reset Password
    When the user selects the Forgot Password option
    Then the user should be prompted to enter their Email for password reset as <email>

    Examples:
      | email              |
      | user1@example.com  |
      | user2@example.com  |

  @display_dashboard
  Scenario Outline: Home Screen
    When the user accesses the Home dashboard
    Then the user should see different modules of the platform

  Examples:
    | username | password |
    | user1    | pass1    |

  @access_operations_management
  Scenario Outline: Operations Management Screen
    When the user navigates to the Operations Management screen
    Then the user should see vehicle status information
    And the user should see driver activity details
    And the user should see alerts related to operations
    And the user should see operational services available

  Examples:
    | username | password |
    | user1    | pass1    |

  @menu-navigation
  Scenario Outline: Operations Management Menu
    When the user views the Operations Management module
    Then the user should see a menu bar for navigating to different operational sections

    Examples:
      | username | password |
      | user1    | pass1    |

  @monitoring_dashboard
  Scenario Outline: Real Time Operations
    When the dispatcher views the dashboard
    Then the dispatcher should see <element>

    Examples:
      | element                     |
      | drivers                     |
      | vehicles                    |
      | bookings                    |
      | alerts                      |
      | operational statuses        |

  @manage_schedules
  Scenario Outline: Operations Scheduled Screen
    When the user creates an operating period
    And the user copies schedules between weeks
    And the user exports schedule data
    Then the user should see the updated operational schedules

  Examples:
    | operating_period | week_from | week_to | schedule_data |
    | <operating_period> | <week_from> | <week_to> | <schedule_data> |

  @view-vehicles
  Scenario Outline: Vehicles Management Screen
    When the user views the list of vehicles
    And the user can add a new vehicle
    And the user can edit an existing vehicle
    And the user can configure vehicle details
    Then the user successfully manages the vehicles

  Examples:
    | vehicle_name | vehicle_type | vehicle_details |
    | Car          | Sedan        | Details about Car|
    | Truck        | Pickup       | Details about Truck|
    | Van          | Minivan      | Details about Van|

  @manage-personnel
  Scenario Outline: Personnel Management Screen
    When the administrator views the user list
    And the administrator assigns roles to existing users
    And the administrator adds a new user to the system
    Then the administrator should see the personnel management actions completed successfully

    Examples:
      | username      | role         | new_user      |
      | admin_user    | manager      | new_user_1    |

  @view-analytics
  Scenario Outline: Live Analytics Screen
    When the user navigates to the Live Analytics Screen
    Then the user should see the operational metrics including <metric>
    
    Examples:
      | metric                |
      | revenue               |
      | bookings              |
      | cancellations         |
      | distance traveled      |
      | utilization rates     |

  @activate_stop
  Scenario Outline: Activate a stop on the map
    When the administrator activates a stop on the map
    Then the stop should be marked as active

    Examples:
      | stop_id |
      | <stop_id> |

  @deactivate_stop
  Scenario Outline: Deactivate a stop on the map
    When the administrator deactivates a stop on the map
    Then the stop should be marked as inactive

    Examples:
      | stop_id |
      | <stop_id> |

  @feature_operational_management
  @vehicle_creation
  Scenario Outline: Vehicle Creation
    When the user creates a new vehicle
    Then the vehicle should be successfully added to the system

  @personnel_creation
  Scenario Outline: Personnel Creation
    When the user creates a new personnel record
    Then the personnel should be successfully added to the system

  @operating_period_creation
  Scenario Outline: Operating Period Creation
    When the user creates a new operating period
    Then the operating period should be successfully added to the system

  @driver_assignment
  Scenario Outline: Driver Assignment
    When the user assigns a driver to a vehicle
    Then the driver should be successfully assigned to the vehicle

  @booking_time_window_control
  Scenario Outline: Booking Time Window Control
    When the user sets the booking time window
    Then the system should reflect the updated booking time window

  @alerts_monitoring
  Scenario Outline: Alerts Monitoring
    When the user accesses the alerts monitoring section
    Then the user should see all current alerts

  @wheelchair_booking_indicators
  Scenario Outline: Wheelchair Booking Indicators
    When the user checks the wheelchair booking indicators
    Then the indicators should show the current booking status

  @analytics_tracking
  Scenario Outline: Analytics Tracking
    When the user accesses the analytics tracking feature
    Then the user should see the analytical data displayed

  Examples:
    | vehicle_name | personnel_name | operating_period | driver_name | booking_time_window | alert_type | wheelchair_status | analytics_data |
    | Vehicle A    | Personnel A    | Period A         | Driver A    | 9 AM - 5 PM        | Alert A    | Available         | Data A         |
