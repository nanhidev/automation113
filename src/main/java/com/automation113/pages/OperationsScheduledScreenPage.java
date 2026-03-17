package com.1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.1.utils.ElementUtils;
import org.junit.Assert;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OperationsScheduledScreenPage {
    private WebDriver driver;
    private ElementUtils elementUtils;

    public OperationsScheduledScreenPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "weekStartDate")
    private WebElement weekStartDateElement;

    @FindBy(id = "weekEndDate")
    private WebElement weekEndDateElement;

    @FindBy(id = "createOperatingPeriodButton")
    private WebElement createOperatingPeriodButton;

    @FindBy(id = "exportButton")
    private WebElement exportButton;

    @FindBy(id = "deleteButton")
    private WebElement deleteButton;

    @FindBy(id = "confirmDeletionButton")
    private WebElement confirmDeletionButton;

    @FindBy(id = "copyToAnotherWeekButton")
    private WebElement copyToAnotherWeekButton;

    @FindBy(id = "saveButton")
    private WebElement saveButton;

    // Method to navigate to the Operations Scheduled page
    public void navigateToOperationsScheduledPage() {
        driver.get("http://localhost/operations-scheduled");
    }

    // Method to observe displayed week start date
    public void observeDisplayedWeekStartDate() {
        try {
            String displayedDate = elementUtils.getElementText(weekStartDateElement);
            System.out.println("Displayed Week Start Date: " + displayedDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to observe displayed week end date
    public void observeDisplayedWeekEndDate() {
        try {
            String displayedDate = elementUtils.getElementText(weekEndDateElement);
            System.out.println("Displayed Week End Date: " + displayedDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to check if the week start date is the first day of the week
    public void checkWeekStartDateIsFirstDay() {
        try {
            String actualDate = elementUtils.getElementText(weekStartDateElement);
            String expectedFirstDay = "2023-01-01"; // Example expected date
            Assert.assertEquals("Week start date does not match the expected first day!", expectedFirstDay, actualDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to check if the week end date is the last day of the week
    public void checkWeekEndDateIsLastDay() {
        try {
            String actualDate = elementUtils.getElementText(weekEndDateElement);
            String expectedLastDay = "2023-01-07"; // Example expected date
            Assert.assertEquals("Week end date does not match the expected last day!", expectedLastDay, actualDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to select a future date from the calendar
    public void selectFutureDateFromCalendar() {
        try {
            elementUtils.clickElement(createOperatingPeriodButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to create an operating period from start time to end time
    public void createOperatingPeriod(String startTime, String endTime) {
        try {
            // Assuming there are methods to set time which are not shown here
            // elementUtils.clearAndSendKeys(startTimeElement, startTime);
            // elementUtils.clearAndSendKeys(endTimeElement, endTime);
            elementUtils.clickElement(saveButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to confirm the deletion action
    public void confirmDeletionAction() {
        try {
            elementUtils.clickElement(confirmDeletionButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to verify the csv file contains relevant operations data
    public void isCsvFileContainsRelevantData() {
        try {
            File csvFile = new File("path/to/your/csvfile.csv");
            FileInputStream fis = new FileInputStream(csvFile);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            var sheet = workbook.getSheetAt(0);
            List<String> expectedData = List.of("Expected1", "Expected2", "Expected3"); // Example expected data
            for (Row row : sheet) {
                for (int i = 0; i < row.getLastCellNum(); i++) {
                    String cellValue = row.getCell(i).getStringCellValue();
                    Assert.assertTrue("CSV file does not contain expected data!", expectedData.contains(cellValue));
                }
            }
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createsSecondOperatingPeriod(String startTime, String endTime) {
        try {
            elementUtils.clickElement(createOperatingPeriodButton);
            // Logic to set the second operating period's start and end time
            elementUtils.clickElement(saveButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clicksSaveButton() {
        try {
            elementUtils.clickElement(saveButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectsCsvFormatOption() {
        try {
            WebElement csvOption = driver.findElement(By.id("csvFormatOption"));
            elementUtils.clickElement(csvOption);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyStartAndEndTimes(String expectedStartTime, String expectedEndTime) {
        try {
            WebElement startTimeElement = driver.findElement(By.id("startTime"));
            String actualStartTime = elementUtils.getElementText(startTimeElement);
            Assert.assertEquals(actualStartTime, expectedStartTime, "Start time does not match!");

            WebElement endTimeElement = driver.findElement(By.id("endTime"));
            String actualEndTime = elementUtils.getElementText(endTimeElement);
            Assert.assertEquals(actualEndTime, expectedEndTime, "End time does not match!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickButton(String buttonId) {
        try {
            WebElement button = driver.findElement(By.id(buttonId));
            elementUtils.clickElement(button);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void isEditedOperatingPeriodDisplayed() {
        try {
            WebElement editedPeriod = driver.findElement(By.id("editedOperatingPeriod"));
            Assert.assertTrue(elementUtils.isElementDisplayed(editedPeriod), "Edited operating period is not displayed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refreshPageAndNavigateToTargetWeek() {
        try {
            driver.navigate().refresh();
            // Logic to navigate to the target week can be added here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void areChangesReflectedInSchedule() {
        try {
            WebElement scheduleElement = driver.findElement(By.id("schedule"));
            Assert.assertTrue(elementUtils.isElementDisplayed(scheduleElement), "Changes are not reflected in schedule!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void isWeekStartDateMatchingExpected(String expectedStartDate) {
        try {
            String actualStartDate = elementUtils.getElementText(weekStartDateElement);
            Assert.assertEquals(actualStartDate, expectedStartDate, "Week start date does not match!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void isOperatingPeriodActive() {
        try {
            WebElement activePeriod = driver.findElement(By.id("activeOperatingPeriod"));
            Assert.assertTrue(elementUtils.isElementDisplayed(activePeriod), "Operating period is not active!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkDetailsOfOperatingPeriods() {
        try {
            // Logic to check details can be added here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clicksDeleteButton() {
        try {
            elementUtils.clickElement(deleteButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void isWeekEndDateMatchingExpected(String expectedEndDate) {
        try {
            String actualEndDate = elementUtils.getElementText(weekEndDateElement);
            Assert.assertEquals(actualEndDate, expectedEndDate, "Week end date does not match!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clicksExportButton() {
        try {
            elementUtils.clickElement(exportButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void confirmExportAction() {
        try {
            elementUtils.acceptAlert();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void isWeekStartDateDisplayedCorrectly(String expectedStartDate) {
        try {
            String actualStartDate = elementUtils.getElementText(weekStartDateElement);
            Assert.assertEquals(actualStartDate, expectedStartDate, "Week start date is not displayed correctly!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void areCopiedOperationsDetailsIntact() {
        try {
            // Logic to check copied operations details can be added here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void isScheduleUpdatedCorrectly() {
        try {
            // Logic to validate if schedule is updated correctly can be added here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectsTargetWeekFromCalendar(String targetWeek) {
        try {
            // Logic to select target week from calendar can be added here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectsAnotherFutureDate(String futureDate) {
        try {
            // Logic to select another future date from calendar can be added here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void isOperationsDataCopied() {
        try {
            // Logic to verify if operations data is copied can be added here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void confirmCopyAction() {
        try {
            elementUtils.acceptAlert();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void areOperatingPeriodsDisplayedForSelectedWeek() {
        try {
            // Logic to check if operating periods are displayed for the selected week
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clicksCreateOperatingPeriodButton() {
        try {
            elementUtils.clickElement(createOperatingPeriodButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clicksCopyToAnotherWeekButton() {
        try {
            elementUtils.clickElement(copyToAnotherWeekButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void areAllPeriodsDisplayed() {
        try {
            // Logic to check if all periods are displayed can be added here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void isWeekEndDateDisplayedCorrectly(String expectedEndDate) {
        try {
            String actualEndDate = elementUtils.getElementText(weekEndDateElement);
            Assert.assertEquals(actualEndDate, expectedEndDate, "Week end date is not displayed correctly!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeOperatingPeriodTimes(String newStartTime, String newEndTime) {
        try {
            WebElement startTimeField = driver.findElement(By.id("startTimeInput"));
            elementUtils.clearAndSendKeys(startTimeField, newStartTime);

            WebElement endTimeField = driver.findElement(By.id("endTimeInput"));
            elementUtils.clearAndSendKeys(endTimeField, newEndTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectWeekFromCalendar(String week) {
        try {
            // Logic to select week from calendar can be added here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void areOperatingPeriodTimesCorrect(String expectedStartTime, String expectedEndTime) {
        try {
            WebElement startTimeElement = driver.findElement(By.id("startTime"));
            String actualStartTime = elementUtils.getElementText(startTimeElement);
            Assert.assertEquals(actualStartTime, expectedStartTime, "Start time does not match!");

            WebElement endTimeElement = driver.findElement(By.id("endTime"));
            String actualEndTime = elementUtils.getElementText(endTimeElement);
            Assert.assertEquals(actualEndTime, expectedEndTime, "End time does not match!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refreshPage() {
        try {
            driver.navigate().refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickExistingOperatingPeriodToDelete() {
        try {
            WebElement existingPeriod = driver.findElement(By.id("existingOperatingPeriod"));
            elementUtils.clickElement(existingPeriod);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectWeekToCopy(String week) {
        try {
            // Logic to select week to copy can be added here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectDateWithExistingOperatingPeriod(String date) {
        try {
            // Logic to select a date with an existing operating period can be added here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void isCsvFileDownloadedSuccessfully() {
        try {
            // Logic to check if CSV file is downloaded successfully can be added here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void areOperatingPeriodsDisplayedCorrectly() {
        try {
            // Logic to check if operating periods are displayed correctly can be added here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterValidOperatingPeriodTimes(String startTime, String endTime) {
        try {
            WebElement startTimeField = driver.findElement(By.id("startTimeInput"));
            elementUtils.clearAndSendKeys(startTimeField, startTime);

            WebElement endTimeField = driver.findElement(By.id("endTimeInput"));
            elementUtils.clearAndSendKeys(endTimeField, endTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void isOverlapPresent() {
        try {
            // Logic to check if overlap is present can be added here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void isOperatingPeriodDisplayed() {
        try {
            WebElement operatingPeriod = driver.findElement(By.id("operatingPeriod"));
            Assert.assertTrue(elementUtils.isElementDisplayed(operatingPeriod), "Operating period is not displayed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void compareDisplayedDatesWithCurrentDate() {
        try {
            // Logic to compare displayed dates with the current date can be added here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clicksExistingOperatingPeriodToEdit() {
        try {
            WebElement existingPeriod = driver.findElement(By.id("existingOperatingPeriod"));
            elementUtils.clickElement(existingPeriod);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectsFutureDate(String futureDate) {
        try {
            // Logic to select a future date can be added here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}