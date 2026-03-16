
@feature_vehicles_management
Feature: VehiclesManagementScreen

Background: 
  Given the user is on the Vehicles Management Screen

@verify_vehicle_list
Scenario Outline: Verify that the vehicles page displays a list of vehicles with correct details
  When I wait for the vehicle list to load
  And I observe the displayed vehicle list
  Then the vehicle list is displayed without errors
  And all required columns are present
  And each vehicle entry shows valid and accurate information
  And the list is scrollable if necessary

Examples:
  | Label       | License Plate | Details       | Status   |
  | Vehicle A  | ABC123        | Detail A     | Active   |
  | Vehicle B  | DEF456        | Detail B     | Inactive |
  | Vehicle C  | GHI789        | Detail C     | Active   |

@valid_add_vehicle
Scenario Outline: Verify that a user can successfully add a new vehicle using valid data in all required fields
  When the user clicks on the "Add Vehicle" button
  And the user fills in the Label field with <label>
  And the user fills in the License Plate field with <license_plate>
  And the user fills in the Manufacturer field with <manufacturer>
  And the user fills in the Model field with <model>
  And the user fills in the Seats field with <seats>
  And the user fills in the Phone Number field with <phone_number>
  And the user clicks the "Save" button
  Then the "Add Vehicle" form should be displayed
  And all fields should accept valid data without errors
  And the vehicle should be added to the list successfully
  And a success message should be displayed confirming the addition
  And the new vehicle should appear in the vehicle list with correct details

Examples:
  | label   | license_plate | manufacturer | model    | seats | phone_number |
  | Toyota  | ABC1234       | Toyota       | Corolla  | 5     | 9876543210   |

  @validation_check
  Scenario Outline: Verify that the vehicle addition form validates required fields
    When the user clicks on the "Add Vehicle" button
    And the user leaves all fields empty
    And the user clicks the "Save" button
    Then validation messages should appear for each required field indicating they cannot be empty
    And the vehicle should not be added to the list

  Examples:
    | action                     |
    | Click on the "Add Vehicle" |
    | Leave all fields empty     |
    | Click the "Save" button    |

@edit_existing_vehicle
Scenario Outline: Verify that a user can successfully edit the details of an existing vehicle and save the changes
  Given the user clicks on an existing vehicle from the list
  When the user clicks the "Edit" button
  And the user changes the Label field to <label>
  And the user changes the License Plate field to <license_plate>
  And the user clicks the "Save" button
  Then the user should see a success message confirming the update

Examples:
  | label          | license_plate |
  | Toyota Camry   | ABC1234       |

@cancel_add_vehicle
Scenario Outline: Verify that a user can cancel the addition of a new vehicle and return to the vehicle list without saving changes
  When the user clicks on the "Add Vehicle" button
  And the user fills in <field1> and <field2> with valid data
  And the user clicks the "Cancel" button
  Then the user is prompted to confirm cancellation
  And upon confirmation, the user is redirected back to the vehicle list
  And no new vehicle is added to the list

Examples:
  | field1       | field2       |
  | valid data 1 | valid data 2 |

  @add_vehicle
  Scenario Outline: Verify that a user can configure access options such as capacity settings for a vehicle during the addition process
    When the user clicks on the "Add Vehicle" button
    And the user fills in all required fields with valid data
    And the user locates the capacity settings section
    And the user adjusts the capacity settings as needed
    And the user clicks the "Save" button
    Then a success message is displayed confirming the addition
    And the new vehicle appears in the vehicle list with correct capacity settings

    Examples:
      | <add_vehicle> |
      | valid_data    |

  @sort_by_label
  Scenario Outline: Verify that the user can sort the vehicle list by Label
    When the user clicks on the "<column>" column header to sort
    Then the vehicle list is sorted alphabetically by Label

    Examples:
      | column  |
      | Label   |

  @sort_by_license_plate
  Scenario Outline: Verify that the user can sort the vehicle list by License Plate
    When the user clicks on the "<column>" column header to sort
    Then the vehicle list is sorted correctly by License Plate

    Examples:
      | column          |
      | License Plate   |

  @sort_by_status
  Scenario Outline: Verify that the user can sort the vehicle list by Status
    When the user clicks on the "<column>" column header to sort
    Then the vehicle list is sorted correctly by Status

    Examples:
      | column  |
      | Status  |

  @vehicle-pagination
  Scenario Outline: Verify that the vehicle list supports pagination
    Then the vehicle list is displayed successfully
    And the correct number of vehicles is displayed on the first page
    When the user clicks on the pagination controls to go to the next page
    Then the user is taken to the next page with the correct vehicles displayed
    When the user clicks on the pagination controls to return to the first page
    Then the user can return to the first page without issues

  Examples:
    | vehicles_on_first_page | vehicles_on_second_page |
    | <number_of_vehicles_first_page> | <number_of_vehicles_second_page> |

  @edit_vehicle_details
  Scenario Outline: Verify that the correct details of a vehicle are displayed when the user clicks to edit it
    Given the user clicks on an existing vehicle from the list
    When the user clicks the "Edit" button
    Then the vehicle details are displayed in an editable form
    And all fields are pre-filled with the correct existing data

  Examples:
    | vehicle_id |
    | <vehicle_id> |

  @access-vehicles-management-screen
  Scenario Outline: Verify access to the Vehicles Management Screen
    When the user navigates to the Vehicles Management Screen
    Then the user should be able to access the Vehicles Management Screen without errors
    And the user can view, add, edit, and configure vehicles

  Examples:
    | username | password |
    | <username> | <password> |
