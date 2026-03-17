package com.project.stepdefinitions;

import com.1.utils.ElementUtils;
import org.junit.Assert;
import com.1.driverfactory.DriverFactory;
import com.project.pages.Sheet1Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Sheet1 extends DriverFactory {
Sheet1Page sheet1Page = new Sheet1Page(driver);
@Given("the user is on the Login Screen")
public void the_user_is_on_the_login_screen() {
sheet1Page.navigateToLoginScreen();
}
@When("the user enters their Organization as {string}")
public void the_user_enters_their_organization_as(String organization) {
sheet1Page.enterOrganization(organization);
}
@When("the user enters their Email as {string}")
public void the_user_enters_their_email_as(String email) {
sheet1Page.enterEmail(email);
}
@When("the user enters their Password as {string}")
public void the_user_enters_their_password_as(String password) {
sheet1Page.enterPassword(password);
}
@Then("the user should be able to access the platform")
public void the_user_should_be_able_to_access_the_platform() {
sheet1Page.isUserAccessedPlatform();
}
@When("the user selects the Forgot Password option")
public void the_user_selects_the_forgot_password_option() {
sheet1Page.selectForgotPassword();
}
@Then("the user should be prompted to enter their Email for password reset as {string}")
public void the_user_should_be_prompted_to_enter_their_email_for_password_reset_as(String email) {
sheet1Page.isEmailPromptDisplayed(email);
}
@When("the user accesses the Home dashboard")
public void the_user_accesses_the_home_dashboard() {
sheet1Page.accessHomeDashboard();
}
@Then("the user should see different modules of the platform")
public void the_user_should_see_different_modules_of_the_platform() {
sheet1Page.areModulesDisplayed();
}
@When("the user navigates to the Operations Management screen")
public void the_user_navigates_to_the_operations_management_screen() {
sheet1Page.navigateToOperationsManagement();
}
@Then("the user should see vehicle status information")
public void the_user_should_see_vehicle_status_information() {
sheet1Page.isVehicleStatusDisplayed();
}
@Then("the user should see driver activity details")
public void the_user_should_see_driver_activity_details() {
sheet1Page.isDriverActivityDisplayed();
}
@Then("the user should see alerts related to operations")
public void the_user_should_see_alerts_related_to_operations() {
sheet1Page.isAlertsDisplayed();
}
@Then("the user should see operational services available")
public void the_user_should_see_operational_services_available() {
sheet1Page.isOperationalServicesDisplayed();
}
@When("the user views the Operations Management module")
public void the_user_views_the_operations_management_module() {
sheet1Page.viewOperationsManagementModule();
}
@Then("the user should see a menu bar for navigating to different operational sections")
public void the_user_should_see_a_menu_bar_for_navigating_to_different_operational_sections() {
sheet1Page.isMenuBarDisplayed();
}
@When("the dispatcher views the dashboard")
public void the_dispatcher_views_the_dashboard() {
sheet1Page.dispatcherViewsDashboard();
}
@Then("the dispatcher should see {string}")
public void the_dispatcher_should_see(String element) {
sheet1Page.isElementDisplayed(element);
}
@When("the user creates an operating period")
public void the_user_creates_an_operating_period() {
sheet1Page.createOperatingPeriod();
}
@When("the user copies schedules between weeks")
public void the_user_copies_schedules_between_weeks() {
sheet1Page.copySchedulesBetweenWeeks();
}
@When("the user exports schedule data")
public void the_user_exports_schedule_data() {
sheet1Page.exportScheduleData();
}
@Then("the user should see the updated operational schedules")
public void the_user_should_see_the_updated_operational_schedules() {
sheet1Page.isOperationalSchedulesUpdated();
}
@When("the user views the list of vehicles")
public void the_user_views_the_list_of_vehicles() {
sheet1Page.viewListOfVehicles();
}
@When("the user can add a new vehicle")
public void the_user_can_add_a_new_vehicle() {
sheet1Page.addNewVehicle();
}
@When("the user can edit an existing vehicle")
public void the_user_can_edit_an_existing_vehicle() {
sheet1Page.editExistingVehicle();
}
@When("the user can configure vehicle details")
public void the_user_can_configure_vehicle_details() {
sheet1Page.configureVehicleDetails();
}
@Then("the user successfully manages the vehicles")
public void the_user_successfully_manages_the_vehicles() {
sheet1Page.isVehicleManagementSuccessful();
}
@When("the administrator views the user list")
public void the_administrator_views_the_user_list() {
sheet1Page.viewUserList();
}
@When("the administrator assigns roles to existing users")
public void the_administrator_assigns_roles_to_existing_users() {
sheet1Page.assignRolesToUsers();
}
@When("the administrator adds a new user to the system")
public void the_administrator_adds_a_new_user_to_the_system() {
sheet1Page.addNewUser();
}
@Then("the administrator should see the personnel management actions completed successfully")
public void the_administrator_should_see_the_personnel_management_actions_completed_successfully() {
sheet1Page.isPersonnelManagementSuccessful();
}
@When("the user navigates to the Live Analytics Screen")
public void the_user_navigates_to_the_live_analytics_screen() {
sheet1Page.navigateToLiveAnalyticsScreen();
}
@Then("the user should see the operational metrics including {string}")
public void the_user_should_see_the_operational_metrics_including(String metric) {
sheet1Page.isMetricDisplayed(metric);
}
@When("the administrator activates a stop on the map")
public void the_administrator_activates_a_stop_on_the_map() {
sheet1Page.activateStopOnMap();
}
@Then("the stop should be marked as active")
public void the_stop_should_be_marked_as_active() {
sheet1Page.isStopActive();
}
@When("the administrator deactivates a stop on the map")
public void the_administrator_deactivates_a_stop_on_the_map() {
sheet1Page.deactivateStopOnMap();
}
@Then("the stop should be marked as inactive")
public void the_stop_should_be_marked_as_inactive() {
sheet1Page.isStopInactive();
}
@When("the user creates a new vehicle")
public void the_user_creates_a_new_vehicle() {
sheet1Page.createNewVehicle();
}
@Then("the vehicle should be successfully added to the system")
public void the_vehicle_should_be_successfully_added_to_the_system() {
sheet1Page.isVehicleAddedSuccessfully();
}
@When("the user creates a new personnel record")
public void the_user_creates_a_new_personnel_record() {
sheet1Page.createNewPersonnelRecord();
}
@Then("the personnel should be successfully added to the system")
public void the_personnel_should_be_successfully_added_to_the_system() {
sheet1Page.isPersonnelAddedSuccessfully();
}
@When("the user creates a new operating period")
public void the_user_creates_a_new_operating_period() {
sheet1Page.createNewOperatingPeriod();
}
@Then("the operating period should be successfully added to the system")
public void the_operating_period_should_be_successfully_added_to_the_system() {
sheet1Page.isOperatingPeriodAddedSuccessfully();
}
@When("the user assigns a driver to a vehicle")
public void the_user_assigns_a_driver_to_a_vehicle() {
sheet1Page.assignDriverToVehicle();
}
@Then("the driver should be successfully assigned to the vehicle")
public void the_driver_should_be_successfully_assigned_to_the_vehicle() {
sheet1Page.isDriverAssignedSuccessfully();
}
@When("the user sets the booking time window")
public void the_user_sets_the_booking_time_window() {
sheet1Page.setBookingTimeWindow();
}
@Then("the system should reflect the updated booking time window")
public void the_system_should_reflect_the_updated_booking_time_window() {
sheet1Page.isBookingTimeWindowUpdated();
}
@When("the user accesses the alerts monitoring section")
public void the_user_accesses_the_alerts_monitoring_section() {
sheet1Page.accessAlertsMonitoring();
}
@Then("the user should see all current alerts")
public void the_user_should_see_all_current_alerts() {
sheet1Page.areCurrentAlertsDisplayed();
}
@When("the user checks the wheelchair booking indicators")
public void the_user_checks_the_wheelchair_booking_indicators() {
sheet1Page.checkWheelchairBookingIndicators();
}
@Then("the indicators should show the current booking status")
public void the_indicators_should_show_the_current_booking_status() {
sheet1Page.isBookingStatusDisplayed();
}
@When("the user accesses the analytics tracking feature")
public void the_user_accesses_the_analytics_tracking_feature() {
sheet1Page.accessAnalyticsTracking();
}
@Then("the user should see the analytical data displayed")
public void the_user_should_see_the_analytical_data_displayed() {
sheet1Page.isAnalyticalDataDisplayed();
}