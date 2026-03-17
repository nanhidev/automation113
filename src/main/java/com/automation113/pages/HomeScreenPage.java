package com.project.pages;

import com.utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

public class HomeScreenPage {
    private WebDriver driver;
    private ElementUtils elementUtils;

    @FindBy(id = "usernameField")
    private WebElement usernameField;

    @FindBy(id = "passwordField")
    private WebElement passwordField;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(id = "homeScreen")
    private WebElement homeScreen;

    @FindBy(id = "errorMessage")
    private WebElement errorMessage;

    @FindBy(id = "greetingText")
    private WebElement greetingText;

    @FindBy(id = "userName")
    private WebElement userName;

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(id = "userRole")
    private WebElement userRole;

    @FindBy(id = "logoutButton")
    private WebElement logoutButton;

    @FindBy(id = "profilePicture")
    private WebElement profilePicture;

    @FindBy(id = "currentDate")
    private WebElement currentDate;

    @FindBy(id = "currentTime")
    private WebElement currentTime;

    @FindBy(id = "notifications")
    private WebElement notifications;

    @FindBy(id = "modules")
    private WebElement modules;

    public HomeScreenPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        elementUtils.clearAndSendKeys(usernameField, username);
    }

    public void enterPassword(String password) {
        elementUtils.clearAndSendKeys(passwordField, password);
    }

    public void clicksLoginButton() {
        elementUtils.clickElement(loginButton);
    }

    public boolean isHomeScreenDisplayed() {
        return elementUtils.isElementDisplayed(homeScreen);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isErrorMessageDisplayed() {
        return elementUtils.isElementDisplayed(errorMessage);
    }

    public boolean isHomeScreenLoadedWithinTime() {
        // Implement logic to check if the home screen is loaded within an acceptable time frame
        return true; // Placeholder
    }

    public String getGreetingText() {
        return elementUtils.getElementText(greetingText);
    }

    public String getLoggedInUsername() {
        return elementUtils.getElementText(userName);
    }

    public boolean isGreetingTextVisible() {
        return elementUtils.isElementDisplayed(greetingText);
    }

    public boolean isModuleVisible(String module) {
        // Implement logic to check if the specified module is visible
        return true; // Placeholder
    }

    public boolean areAllModulesClickable() {
        // Implement logic to check if all modules are clickable
        return true; // Placeholder
    }

    public void clicksModule(String module) {
        // Implement logic to click the specified module
    }

    public boolean isNavigatedToPage(String expectedPage) {
        // Implement logic to check if the user is navigated to the expected page
        return true; // Placeholder
    }

    public void updateProfileInformation(String name, String email) {
        // Implement logic to update profile information
    }

    public void saveProfileChanges() {
        // Implement logic to save profile changes
    }

    public void refreshHomeScreen() {
        // Implement logic to refresh the Home screen
    }

    public boolean isUpdatedProfileDisplayed() {
        // Implement logic to check if updated profile information is displayed
        return true; // Placeholder
    }

    public boolean isOldInformationVisible() {
        // Implement logic to check if old information is not visible
        return true; // Placeholder
    }

    public void clickLogoutButton() {
        elementUtils.clickElement(logoutButton);
    }

    public boolean isLoginPageDisplayed() {
        // Implement logic to check if the login page is displayed
        return true; // Placeholder
    }

    public boolean isHomeScreenAccessible() {
        // Implement logic to check if the Home screen is accessible
        return true; // Placeholder
    }

    public boolean isLogoutConfirmationDisplayed() {
        // Implement logic to check if the logout confirmation is displayed
        return true; // Placeholder
    }

    public String getCurrentDate() {
        return elementUtils.getElementText(currentDate);
    }

    public String getCurrentTime() {
        return elementUtils.getElementText(currentTime);
    }

    public void retrieveUserProfileInformation() {
        // Implement logic to retrieve user profile information
    }

    public boolean isProfilePictureDisplayed() {
        return elementUtils.isElementDisplayed(profilePicture);
    }

    public boolean isUserPreferencesSaved() {
        // Implement logic to check if user preferences are saved
        return true; // Placeholder
    }

    public void selectCustomizationOptions() {
        // Implement logic to select customization options
    }

    public boolean isCustomizedLayoutDisplayed() {
        // Implement logic to check if the customized layout is displayed
        return true; // Placeholder
    }

    public void retrieveUserNotifications() {
        // Implement logic to retrieve user notifications
    }

    public boolean areNotificationsDisplayed() {
        return elementUtils.isElementDisplayed(notifications);
    }

    public boolean areNotificationsRelevant() {
        // Implement logic to check if notifications are relevant
        return true; // Placeholder
    }

    public boolean areNotificationsClickable() {
        // Implement logic to check if notifications are clickable
        return true; // Placeholder
    }

    public void retrieveCurrentDateTime() {
        // Implement logic to retrieve current date and time
    }

    public void constructGreetingMessage() {
        try {
            String greetingMessage = elementUtils.getElementText(greetingText);
            System.out.println(greetingMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUserEmail() {
        return elementUtils.getElementText(userEmail);
    }

    public String getUserRole() {
        return elementUtils.getElementText(userRole);
    }

    public String retrieveLoggedInUsername() {
        return elementUtils.getElementText(userName);
    }

    public void getGreetingUsername() {
        try {
            String actualUsername = elementUtils.getElementText(userName);
            String expectedUsername = "ExpectedUser"; // Update as needed
            Assert.assertEquals(actualUsername, expectedUsername, "Greeting username does not match!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}