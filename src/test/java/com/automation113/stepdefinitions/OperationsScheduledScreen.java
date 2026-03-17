package com.automation113.stepdefinitions;

import com.1.utils.ElementUtils;
import org.junit.Assert;
import com.1.driverfactory.DriverFactory;
import com.automation113.pages.OperationsScheduledScreenPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class OperationsScheduledScreen extends DriverFactory {
OperationsScheduledScreenPage operationsScheduledScreenPage = new OperationsScheduledScreenPage(driver);
@Given("the user is on the Operations Scheduled page")
public void the_user_is_on_the_operations_scheduled_page() {
operationsScheduledScreenPage.navigateToOperationsScheduledPage();
}
@When("the user observes the displayed week start date")
public void the_user_observes_the_displayed_week_start_date() {
operationsScheduledScreenPage.observeDisplayedWeekStartDate();
}
@When("the user observes the displayed week end date")
public void the_user_observes_the_displayed_week_end_date() {
operationsScheduledScreenPage.observeDisplayedWeekEndDate();
}
@When("the user compares the displayed dates with the current date")
public void the_user_compares_the_displayed_dates_with_the_current_date() {
operationsScheduledScreenPage.compareDisplayedDatesWithCurrentDate();
}
@When("the user checks if the week start date is the first day of the week")
public void the_user_checks_if_the_week_start_date_is_the_first_day_of_the_week() {
operationsScheduledScreenPage.checkWeekStartDateIsFirstDay();
}
@When("the user checks if the week end date is the last day of the week")
public void the_user_checks_if_the_week_end_date_is_the_last_day_of_the_week() {
operationsScheduledScreenPage.checkWeekEndDateIsLastDay();
}
@Then("the week start date is displayed correctly")
public void the_week_start_date_is_displayed_correctly() {
operationsScheduledScreenPage.isWeekStartDateDisplayedCorrectly();
}
@Then("the week end date is displayed correctly")
public void the_week_end_date_is_displayed_correctly() {
operationsScheduledScreenPage.isWeekEndDateDisplayedCorrectly();
}
@Then("the week start date matches the expected first day of the week")
public void the_week_start_date_matches_the_expected_first_day_of_the_week() {
operationsScheduledScreenPage.isWeekStartDateMatchingExpected();
}
@Then("the week end date matches the expected last day of the week")
public void the_week_end_date_matches_the_expected_last_day_of_the_week() {
operationsScheduledScreenPage.isWeekEndDateMatchingExpected();
}
@When("the user selects a future date from the calendar")
public void the_user_selects_a_future_date_from_the_calendar() {
operationsScheduledScreenPage.selectFutureDateFromCalendar();
}
// DUPLICATE: @When("the user clicks on the {string} button")
public void the_user_clicks_on_button(String buttonName) {
operationsScheduledScreenPage.clickButton(buttonName);
}
@When("the user enters valid start time and end time for the operating period")
public void the_user_enters_valid_start_time_and_end_time_for_the_operating_period() {
operationsScheduledScreenPage.enterValidOperatingPeriodTimes();
}
@Then("the operating period is displayed for the selected date")
public void the_operating_period_is_displayed_for_the_selected_date() {
operationsScheduledScreenPage.isOperatingPeriodDisplayed();
}
@Then("the start time and end time are correctly shown")
public void the_start_time_and_end_time_are_correctly_shown() {
operationsScheduledScreenPage.areOperatingPeriodTimesCorrect();
}
@Then("the operating period is marked as active")
public void the_operating_period_is_marked_as_active() {
operationsScheduledScreenPage.isOperatingPeriodActive();
}
@When("the user creates an operating period from {string} to {string}")
public void the_user_creates_an_operating_period_from_to(String startTime, String endTime) {
operationsScheduledScreenPage.createOperatingPeriod(startTime, endTime);
}
@Then("both operating periods are displayed correctly for their respective dates")
public void both_operating_periods_are_displayed_correctly_for_their_respective_dates() {
operationsScheduledScreenPage.areOperatingPeriodsDisplayedCorrectly();
}
@Then("no overlap is present between the two operating periods")
public void no_overlap_is_present_between_the_two_operating_periods() {
operationsScheduledScreenPage.isOverlapPresent();
}
@When("the user selects the week containing the operations data to copy")
public void the_user_selects_the_week_containing_the_operations_data_to_copy() {
operationsScheduledScreenPage.selectWeekToCopy();
}
@When("the user confirms the copy action")
public void the_user_confirms_the_copy_action() {
operationsScheduledScreenPage.confirmCopyAction();
}
@Then("the operations data from the source week should be displayed in the target week")
public void the_operations_data_from_the_source_week_should_be_displayed_in_the_target_week() {
operationsScheduledScreenPage.isOperationsDataCopied();
}
@Then("all details of the copied operations should be intact")
public void all_details_of_the_copied_operations_should_be_intact() {
operationsScheduledScreenPage.areCopiedOperationsDetailsIntact();
}
@When("the user selects a date with an existing operating period")
public void the_user_selects_a_date_with_an_existing_operating_period() {
operationsScheduledScreenPage.selectDateWithExistingOperatingPeriod();
}
@When("the user changes the start time and end time")
public void the_user_changes_the_start_time_and_end_time() {
operationsScheduledScreenPage.changeOperatingPeriodTimes();
}
@Then("the edited operating period is displayed with the updated times")
public void the_edited_operating_period_is_displayed_with_the_updated_times() {
operationsScheduledScreenPage.isEditedOperatingPeriodDisplayed();
}
@Then("the changes are reflected correctly in the schedule")
public void the_changes_are_reflected_correctly_in_the_schedule() {
operationsScheduledScreenPage.areChangesReflectedInSchedule();
}
@When("the user clicks on the existing operating period to delete")
public void the_user_clicks_on_the_existing_operating_period_to_delete() {
operationsScheduledScreenPage.clickExistingOperatingPeriodToDelete();
}
@Then("the operating period is no longer displayed for the selected date")
public void the_operating_period_is_no_longer_displayed_for_the_selected_date() {
operationsScheduledScreenPage.isOperatingPeriodDisplayed();
}
@Then("the schedule is updated correctly without the deleted period")
public void the_schedule_is_updated_correctly_without_the_deleted_period() {
operationsScheduledScreenPage.isScheduleUpdatedCorrectly();
}
@When("the user selects a week from the calendar")
public void the_user_selects_a_week_from_the_calendar() {
operationsScheduledScreenPage.selectWeekFromCalendar();
}
@Then("the user should observe the displayed operating periods for that week")
public void the_user_should_observe_the_displayed_operating_periods_for_that_week() {
operationsScheduledScreenPage.areOperatingPeriodsDisplayedForSelectedWeek();
}
@Then("the user checks the details of each operating period")
public void the_user_checks_the_details_of_each_operating_period() {
operationsScheduledScreenPage.checkDetailsOfOperatingPeriods();
}
@Then("the user verifies the start and end times for each period")
public void the_user_verifies_the_start_and_end_times_for_each_period() {
operationsScheduledScreenPage.verifyStartAndEndTimes();
}
@Then("the user ensures all periods are displayed without any missing data")
public void the_user_ensures_all_periods_are_displayed_without_any_missing_data() {
operationsScheduledScreenPage.areAllPeriodsDisplayed();
}

@When("the user confirms the deletion action")
public void the_user_confirms_the_deletion_action() {
operationsScheduledScreenPage.confirmDeletionAction();
}
@When("the user clicks on the create operating period button")
public void the_user_clicks_on_the_create_operating_period_button() {
operationsScheduledScreenPage.clicksCreateOperatingPeriodButton();
}
@When("the user clicks on the copy to another week button")
public void the_user_clicks_on_the_copy_to_another_week_button() {
operationsScheduledScreenPage.clicksCopyToAnotherWeekButton();
}
@When("the user selects a future date")
public void the_user_selects_a_future_date() {
operationsScheduledScreenPage.selectsFutureDate();
}
@When("the user refreshes the page navigates to the target week")
public void the_user_refreshes_the_page_navigates_to_the_target_week() {
operationsScheduledScreenPage.refreshPageAndNavigateToTargetWeek();
}
@When("the user clicks on the export button")
public void the_user_clicks_on_the_export_button() {
operationsScheduledScreenPage.clicksExportButton();
}
@When("the user selects another future date")
public void the_user_selects_another_future_date() {
operationsScheduledScreenPage.selectsAnotherFutureDate();
}
@When("the user clicks on the save button")
public void the_user_clicks_on_the_save_button() {
operationsScheduledScreenPage.clicksSaveButton();
}
@When("the user creates a second operating period from {string} to {string}")
public void the_user_creates_a_second_operating_period_from_to(String startDate, String endDate) {
operationsScheduledScreenPage.createsSecondOperatingPeriod(startDate, endDate);
}
@When("the user confirms the export action")
public void the_user_confirms_the_export_action() {
operationsScheduledScreenPage.confirmExportAction();
}
@When("the user clicks on the delete button")
public void the_user_clicks_on_the_delete_button() {
operationsScheduledScreenPage.clicksDeleteButton();
}
@Then("the csv file should contain all relevant operations data")
public void the_csv_file_should_contain_all_relevant_operations_data() {
operationsScheduledScreenPage.isCsvFileContainsRelevantData();
}
@Then("the csv file should be downloaded successfully")
public void the_csv_file_should_be_downloaded_successfully() {
operationsScheduledScreenPage.isCsvFileDownloadedSuccessfully();
}
@When("the user selects a target week from the calendar")
public void the_user_selects_a_target_week_from_the_calendar() {
operationsScheduledScreenPage.selectsTargetWeekFromCalendar();
}
@When("the user refreshes the page")
public void the_user_refreshes_the_page() {
operationsScheduledScreenPage.refreshPage();
}
@When("the user clicks on the existing operating period to edit")
public void the_user_clicks_on_the_existing_operating_period_to_edit() {
operationsScheduledScreenPage.clicksExistingOperatingPeriodToEdit();
}
@When("the user selects the csv format option")
public void the_user_selects_the_csv_format_option() {
operationsScheduledScreenPage.selectsCsvFormatOption();
}
}