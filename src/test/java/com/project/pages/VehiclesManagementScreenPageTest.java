
package com.project.pages;

import com.utils.ElementUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VehiclesManagementScreenPageTest {

    @Mock
    private WebDriver driver;

    @Mock
    private ElementUtils elementUtils;

    @Mock
    private WebElement vehicleList;

    @Mock
    private WebElement addVehicleForm;

    @Mock
    private WebElement successMessage;

    @Mock
    private WebElement labelField;

    @Mock
    private WebElement licensePlateField;

    @Mock
    private WebElement manufacturerField;

    @Mock
    private WebElement modelField;

    @Mock
    private WebElement seatsField;

    @Mock
    private WebElement phoneNumberField;

    @Mock
    private WebElement cancelButton;

    @Mock
    private WebElement editButton;

    @Mock
    private WebElement saveButton;

    @InjectMocks
    private VehiclesManagementScreenPage vehiclesManagementScreenPage;

    @BeforeEach
    public void setUp() {
        when(driver.get("http://localhost/vehicles-management")).thenReturn(null);
        when(elementUtils.isElementDisplayed(vehicleList)).thenReturn(true);
        when(elementUtils.isElementDisplayed(addVehicleForm)).thenReturn(true);
        when(elementUtils.isElementDisplayed(successMessage)).thenReturn(true);
    }

    @Test
    public void shouldNavigateToVehiclesManagementScreen() {
        vehiclesManagementScreenPage.navigateToVehiclesManagementScreen();
        verify(driver).get("http://localhost/vehicles-management");
    }

    @Test
    public void shouldReturnTrueWhenVehicleListIsDisplayedWithoutErrors() {
        boolean result = vehiclesManagementScreenPage.isVehicleListDisplayedWithoutErrors();
        verify(elementUtils).isElementDisplayed(vehicleList);
        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenFormIsDisplayed() {
        boolean result = vehiclesManagementScreenPage.isFormDisplayed("Add Vehicle");
        verify(elementUtils).isElementDisplayed(addVehicleForm);
        assertTrue(result);
    }

    @Test
    public void shouldFillInLabelField() {
        vehiclesManagementScreenPage.fillInLabelField("Test Label");
        verify(elementUtils).clearAndSendKeys(labelField, "Test Label");
    }

    @Test
    public void shouldFillInLicensePlateField() {
        vehiclesManagementScreenPage.fillInLicensePlateField("ABC123");
        verify(elementUtils).clearAndSendKeys(licensePlateField, "ABC123");
    }

    @Test
    public void shouldFillInManufacturerField() {
        vehiclesManagementScreenPage.fillInManufacturerField("Test Manufacturer");
        verify(elementUtils).clearAndSendKeys(manufacturerField, "Test Manufacturer");
    }

    @Test
    public void shouldFillInModelField() {
        vehiclesManagementScreenPage.fillInModelField("Test Model");
        verify(elementUtils).clearAndSendKeys(modelField, "Test Model");
    }

    @Test
    public void shouldFillInSeatsField() {
        vehiclesManagementScreenPage.fillInSeatsField("4");
        verify(elementUtils).clearAndSendKeys(seatsField, "4");
    }

    @Test
    public void shouldFillInPhoneNumberField() {
        vehiclesManagementScreenPage.fillInPhoneNumberField("1234567890");
        verify(elementUtils).clearAndSendKeys(phoneNumberField, "1234567890");
    }

    @Test
    public void shouldClickCancelButton() {
        vehiclesManagementScreenPage.clickButton("cancel");
        verify(elementUtils).clickElement(cancelButton);
    }

    @Test
    public void shouldClickEditButton() {
        vehiclesManagementScreenPage.clickButton("edit");
        verify(elementUtils).clickElement(editButton);
    }

    @Test
    public void shouldClickSaveButton() {
        vehiclesManagementScreenPage.clickButton("save");
        verify(elementUtils).clickElement(saveButton);
    }

    @Test
    public void shouldLeaveAllFieldsEmpty() {
        vehiclesManagementScreenPage.leaveAllFieldsEmpty();
        verify(elementUtils).clearElement(labelField);
        verify(elementUtils).clearElement(licensePlateField);
        verify(elementUtils).clearElement(manufacturerField);
        verify(elementUtils).clearElement(modelField);
        verify(elementUtils).clearElement(seatsField);
        verify(elementUtils).clearElement(phoneNumberField);
    }

    @Test
    public void shouldChangeLabelField() {
        vehiclesManagementScreenPage.changeLabelField("New Label");
        verify(elementUtils).clearAndSendKeys(labelField, "New Label");
    }

    @Test
    public void shouldChangeLicensePlateField() {
        vehiclesManagementScreenPage.changeLicensePlateField("XYZ789");
        verify(elementUtils).clearAndSendKeys(licensePlateField, "XYZ789");
    }

    @Test
    public void shouldReturnTrueIfSuccessMessageDisplayed() {
        boolean result = vehiclesManagementScreenPage.isSuccessMessageDisplayed();
        verify(elementUtils).isElementDisplayed(successMessage);
        assertTrue(result);
    }
}
