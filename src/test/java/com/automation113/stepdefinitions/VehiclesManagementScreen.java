package com.project.stepdefinitions;

import com.1.utils.ElementUtils;
import org.junit.Assert;
import com.project.driverfactory.DriverFactory;
import com.project.pages.VehiclesManagementScreenPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class VehiclesManagementScreen extends DriverFactory {
VehiclesManagementScreenPage vehiclesManagementScreenPage = new VehiclesManagementScreenPage(driver);
@Given("the user is on the Vehicles Management Screen")
public void the_user_is_on_the_vehicles_management_screen() {
vehiclesManagementScreenPage.navigateToVehiclesManagementScreen();
}
@When("I wait for the vehicle list to load")
public void i_wait_for_the_vehicle_list_to_load() {
vehiclesManagementScreenPage.waitForVehicleListToLoad();
}
@When("I observe the displayed vehicle list")
public void i_observe_the_displayed_vehicle_list() {
vehiclesManagementScreenPage.observeDisplayedVehicleList();
}
@Then("the vehicle list is displayed without errors")
public void the_vehicle_list_is_displayed_without_errors() {
"Vehicle list should be displayed without errors", vehiclesManagementScreenPage.isVehicleListDisplayedWithoutErrors();
}
@Then("all required columns are present")
public void all_required_columns_are_present() {
"All required columns should be present", vehiclesManagementScreenPage.areAllRequiredColumnsPresent();
}
@Then("each vehicle entry shows valid and accurate information")
public void each_vehicle_entry_shows_valid_and_accurate_information() {
"Each vehicle entry should show valid and accurate information", vehiclesManagementScreenPage.isEachVehicleEntryValid();
}
@Then("the list is scrollable if necessary")
public void the_list_is_scrollable_if_necessary() {
"The list should be scrollable if necessary", vehiclesManagementScreenPage.isListScrollable();
}
// DUPLICATE: @When("the user clicks on the {string} button")
public void the_user_clicks_on_the_button(String button) {
vehiclesManagementScreenPage.clickButton(button);
}
@When("the user fills in the Label field with {string}")
public void the_user_fills_in_the_label_field_with(String label) {
vehiclesManagementScreenPage.fillInLabelField(label);
}
@When("the user fills in the License Plate field with {string}")
public void the_user_fills_in_the_license_plate_field_with(String licensePlate) {
vehiclesManagementScreenPage.fillInLicensePlateField(licensePlate);
}
@When("the user fills in the Manufacturer field with {string}")
public void the_user_fills_in_the_manufacturer_field_with(String manufacturer) {
vehiclesManagementScreenPage.fillInManufacturerField(manufacturer);
}
@When("the user fills in the Model field with {string}")
public void the_user_fills_in_the_model_field_with(String model) {
vehiclesManagementScreenPage.fillInModelField(model);
}
@When("the user fills in the Seats field with {string}")
public void the_user_fills_in_the_seats_field_with(String seats) {
vehiclesManagementScreenPage.fillInSeatsField(seats);
}
@When("the user fills in the Phone Number field with {string}")
public void the_user_fills_in_the_phone_number_field_with(String phoneNumber) {
vehiclesManagementScreenPage.fillInPhoneNumberField(phoneNumber);
}
@Then("the {string} form should be displayed")
public void the_form_should_be_displayed(String formName) {
formName + " form should be displayed", vehiclesManagementScreenPage.isFormDisplayed(formName);
}
@Then("all fields should accept valid data without errors")
public void all_fields_should_accept_valid_data_without_errors() {
"All fields should accept valid data without errors", vehiclesManagementScreenPage.areAllFieldsAcceptingValidData();
}
@Then("the vehicle should be added to the list successfully")
public void the_vehicle_should_be_added_to_the_list_successfully() {
"The vehicle should be added to the list successfully", vehiclesManagementScreenPage.isVehicleAddedToList();
}
@Then("a success message should be displayed confirming the addition")
public void a_success_message_should_be_displayed_confirming_the_addition() {
"A success message should be displayed confirming the addition", vehiclesManagementScreenPage.isSuccessMessageDisplayed();
}
@Then("the new vehicle should appear in the vehicle list with correct details")
public void the_new_vehicle_should_appear_in_the_vehicle_list_with_correct_details() {
"The new vehicle should appear in the vehicle list with correct details", vehiclesManagementScreenPage.isNewVehicleDisplayedWithCorrectDetails();
}
@When("the user leaves all fields empty")
public void the_user_leaves_all_fields_empty() {
vehiclesManagementScreenPage.leaveAllFieldsEmpty();
}
@Then("validation messages should appear for each required field indicating they cannot be empty")
public void validation_messages_should_appear_for_each_required_field_indicating_they_cannot_be_empty() {
"Validation messages should appear for each required field", vehiclesManagementScreenPage.areValidationMessagesDisplayed();
}
@Then("the vehicle should not be added to the list")
public void the_vehicle_should_not_be_added_to_the_list() {
"The vehicle should not be added to the list", vehiclesManagementScreenPage.isVehicleAddedToList();
}
@When("the user changes the Label field to {string}")
public void the_user_changes_the_label_field_to(String label) {
vehiclesManagementScreenPage.changeLabelField(label);
}
@When("the user changes the License Plate field to {string}")
public void the_user_changes_the_license_plate_field_to(String licensePlate) {
vehiclesManagementScreenPage.changeLicensePlateField(licensePlate);
}
@Then("the user should see a success message confirming the update")
public void the_user_should_see_a_success_message_confirming_the_update() {
"A success message should be displayed confirming the update", vehiclesManagementScreenPage.isUpdateSuccessMessageDisplayed();
}
@When("the user fills in {string} and {string} with valid data")
public void the_user_fills_in_and_with_valid_data(String field1, String field2) {
vehiclesManagementScreenPage.fillInFieldsWithValidData(field1, field2);
}
@Then("the user is prompted to confirm cancellation")
public void the_user_is_prompted_to_confirm_cancellation() {
"The user should be prompted to confirm cancellation", vehiclesManagementScreenPage.isPromptedToConfirmCancellation();
}
@Then("upon confirmation, the user is redirected back to the vehicle list")
public void upon_confirmation_the_user_is_redirected_back_to_the_vehicle_list() {
"The user should be redirected back to the vehicle list", vehiclesManagementScreenPage.isRedirectedToVehicleList();
}
@Then("no new vehicle is added to the list")
public void no_new_vehicle_is_added_to_the_list() {
"No new vehicle should be added to the list", vehiclesManagementScreenPage.isVehicleAddedToList();
}
@When("the user locates the capacity settings section")
public void the_user_locates_the_capacity_settings_section() {
vehiclesManagementScreenPage.locateCapacitySettingsSection();
}
@When("the user adjusts the capacity settings as needed")
public void the_user_adjusts_the_capacity_settings_as_needed() {
vehiclesManagementScreenPage.adjustCapacitySettings();
}
@When("the user clicks on the {string} column header to sort")
public void the_user_clicks_on_the_column_header_to_sort(String column) {
vehiclesManagementScreenPage.sortByColumn(column);
}
@Then("the vehicle list is sorted alphabetically by {string}")
public void the_vehicle_list_is_sorted_alphabetically_by(String column) {
"The vehicle list should be sorted alphabetically by " + column, vehiclesManagementScreenPage.isVehicleListSortedBy(column);
}
@Then("the correct number of vehicles is displayed on the first page")
public void the_correct_number_of_vehicles_is_displayed_on_the_first_page() {
"The correct number of vehicles should be displayed on the first page", vehiclesManagementScreenPage.isCorrectNumberOfVehiclesOnFirstPage();
}
@When("the user clicks on the pagination controls to go to the next page")
public void the_user_clicks_on_the_pagination_controls_to_go_to_the_next_page() {
vehiclesManagementScreenPage.goToNextPage();
}
@Then("the user is taken to the next page with the correct vehicles displayed")
public void the_user_is_taken_to_the_next_page_with_the_correct_vehicles_displayed() {
"The user should be taken to the next page with the correct vehicles displayed", vehiclesManagementScreenPage.isCorrectVehiclesDisplayedOnNextPage();
}
@When("the user clicks on the pagination controls to return to the first page")
public void the_user_clicks_on_the_pagination_controls_to_return_to_the_first_page() {
vehiclesManagementScreenPage.returnToFirstPage();
}
@Then("the user can return to the first page without issues")
public void the_user_can_return_to_the_first_page_without_issues() {
"The user should be able to return to the first page without issues", vehiclesManagementScreenPage.isOnFirstPage();
}
@Then("the vehicle details are displayed in an editable form")
public void the_vehicle_details_are_displayed_in_an_editable_form() {
"The vehicle details should be displayed in an editable form", vehiclesManagementScreenPage.isVehicleDetailsEditable();
}
@Then("all fields are pre-filled with the correct existing data")
public void all_fields_are_pre_filled_with_the_correct_existing_data() {
"All fields should be pre-filled with the correct existing data", vehiclesManagementScreenPage.areFieldsPreFilledWithCorrectData();
}
@When("the user navigates to the Vehicles Management Screen")
public void the_user_navigates_to_the_vehicles_management_screen() {
vehiclesManagementScreenPage.navigateToVehiclesManagementScreen();
}
@Then("the user should be able to access the Vehicles Management Screen without errors")
public void the_user_should_be_able_to_access_the_vehicles_management_screen_without_errors() {
"The user should be able to access the Vehicles Management Screen without errors", vehiclesManagementScreenPage.isAccessToVehiclesManagementScreenWithoutErrors();
}
@Then("the user can view, add, edit, and configure vehicles")
public void the_user_can_view_add_edit_and_configure_vehicles() {
"The user should be able to view, add, edit, and configure vehicles", vehiclesManagementScreenPage.canViewAddEditAndConfigureVehicles();
}

@Given("the vehicle list is displayed successfully")
public void the_vehicle_list_is_displayed_successfully() {
vehiclesManagementScreenPage.isVehicleListDisplayed();
}
@Given("the add vehicle form should be displayed")
public void the_add_vehicle_form_should_be_displayed() {
vehiclesManagementScreenPage.isAddVehicleFormDisplayed();
}
@Then("a success message is displayed confirming the addition")
public void a_success_message_is_displayed_confirming_the_addition() {
vehiclesManagementScreenPage.isSuccessMessageDisplayed();
}
@When("the user fills in all required fields with valid data")
public void the_user_fills_in_all_required_fields_with_valid_data() {
vehiclesManagementScreenPage.fillInRequiredFieldsWithValidData();
}
@When("the user clicks the cancel button")
public void the_user_clicks_the_cancel_button() {
vehiclesManagementScreenPage.clicksCancelButton();
}
@Then("the new vehicle appears in the vehicle list with correct capacity settings")
public void the_new_vehicle_appears_in_the_vehicle_list_with_correct_capacity_settings() {
vehiclesManagementScreenPage.isNewVehicleDisplayedWithCorrectCapacity();
}
@When("the user clicks the edit button")
public void the_user_clicks_the_edit_button() {
vehiclesManagementScreenPage.clicksEditButton();
}
@Then("the vehicle list is sorted alphabetically by label")
public void the_vehicle_list_is_sorted_alphabetically_by_label() {
vehiclesManagementScreenPage.isVehicleListSortedAlphabeticallyByLabel();
}
@When("the user clicks the save button")
public void the_user_clicks_the_save_button() {
vehiclesManagementScreenPage.clicksSaveButton();
}
@Then("the vehicle list is sorted correctly by license plate")
public void the_vehicle_list_is_sorted_correctly_by_license_plate() {
vehiclesManagementScreenPage.isVehicleListSortedCorrectlyByLicensePlate();
}
@When("the user clicks on the add vehicle button")
public void the_user_clicks_on_the_add_vehicle_button() {
vehiclesManagementScreenPage.clicksAddVehicleButton();
}
@Then("the vehicle list is sorted correctly by status")
public void the_vehicle_list_is_sorted_correctly_by_status() {
vehiclesManagementScreenPage.isVehicleListSortedCorrectlyByStatus();
}
}