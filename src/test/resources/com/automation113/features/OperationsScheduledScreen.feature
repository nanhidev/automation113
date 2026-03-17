
@feature_operations_scheduled_screen
Feature: OperationsScheduledScreen

Background: 
  Given the user is on the Operations Scheduled page

@verify_week_dates
Scenario Outline: Operations Scheduled Screen
  When the user observes the displayed week start date
  And the user observes the displayed week end date
  And the user compares the displayed dates with the current date
  And the user checks if the week start date is the first day of the week
  And the user checks if the week end date is the last day of the week
  Then the week start date is displayed correctly
  And the week end date is displayed correctly
  And the week start date matches the expected first day of the week
  And the week end date matches the expected last day of the week

Examples:
  | week_start_date | week_end_date |
  | <week_start_date> | <week_end_date> |

@valid-operating-period
Scenario Outline: Verify that a user can successfully create a valid operating period for a selected day in the future
  When the user selects a future date from the calendar
  And the user clicks on the "Create Operating Period" button
  And the user enters valid start time and end time for the operating period
  And the user clicks on the "Save" button
  And the user refreshes the page
  Then the operating period is displayed for the selected date
  And the start time and end time are correctly shown
  And the operating period is marked as active

Examples:
  | future_date | start_time | end_time |
  | <future_date> | <start_time> | <end_time> |

  @create_multiple_operating_periods
  Scenario Outline: Verify that a user can create multiple non-overlapping operating periods for different days in the future
    When the user selects a future date
    And the user creates an operating period from <start_time_1> to <end_time_1>
    And the user selects another future date
    And the user creates a second operating period from <start_time_2> to <end_time_2>
    And the user refreshes the page
    Then both operating periods are displayed correctly for their respective dates
    And no overlap is present between the two operating periods

    Examples:
      | start_time_1 | end_time_1 | start_time_2 | end_time_2 |
      | 9 AM         | 11 AM      | 1 PM         | 3 PM       |

  @verify_copy_operations_data
  Scenario Outline: Verify that a user can successfully copy operations data from one week to another
    When the user selects the week containing the operations data to copy
    And the user clicks on the "Copy to Another Week" button
    And the user selects a target week from the calendar
    And the user confirms the copy action
    And the user refreshes the page and navigates to the target week
    Then the operations data from the source week should be displayed in the target week
    And all details of the copied operations should be intact

  Examples:
    | week_to_copy | target_week |
    | Week 1      | Week 2     |

@csv_export
Scenario Outline: Verify that a user can successfully export operations data in CSV format
  When the user clicks on the "Export" button
  And the user selects the CSV format option
  And the user confirms the export action
  Then the CSV file should be downloaded successfully
  And the CSV file should contain all relevant operations data

Examples:
  | action                       |
  | Navigate to the Operations Scheduled page |
  | Click on the "Export" button |
  | Select the CSV format option  |
  | Confirm the export action      |
  | Check the downloads folder for the CSV file |
  | Open the CSV file to verify its contents |

  @edit-operating-period
  Scenario Outline: Verify that a user can successfully edit an existing operating period
    When the user selects a date with an existing operating period
    And the user clicks on the existing operating period to edit
    And the user changes the start time and end time
    And the user clicks on the Save button
    And the user refreshes the page
    Then the edited operating period is displayed with the updated times
    And the changes are reflected correctly in the schedule

  Examples:
    | start_time | end_time |
    | <start_time> | <end_time> |

@delete_operating_period
Scenario Outline: Verify that a user can successfully delete an existing operating period
  Given the user selects a date with an existing operating period
  When the user clicks on the existing operating period to delete
  And the user clicks on the "Delete" button
  And the user confirms the deletion action
  And the user refreshes the page
  Then the operating period is no longer displayed for the selected date
  And the schedule is updated correctly without the deleted period

Examples:
  | date                |
  | <existing_date>    |

  @verify_operating_periods
  Scenario Outline: Verify that a user can view all operating periods scheduled for a selected week
    When the user selects a week from the calendar
    Then the user should observe the displayed operating periods for that week
    And the user checks the details of each operating period
    And the user verifies the start and end times for each period
    And the user ensures all periods are displayed without any missing data

  Examples:
    | week        |
    | <selected_week> |
