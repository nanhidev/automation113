
package com.project.utils;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.Scenario;

import java.awt.*;
import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class CommonUtilsTest {

    @Mock
    private WebDriver driver;

    @Mock
    private WebElement dropdownElement;

    @Mock
    private Select dropdown;

    @InjectMocks
    private CommonUtils commonUtils;

    @Test
    public void shouldGenerateEmailWithTimeStamp() {
        String email = CommonUtils.getEmailWithTimeStamp();
        assertNotNull(email);
        assertTrue(email.contains("@gmail.com"));
    }

    @Test
    public void shouldTakeScreenshot() {
        Scenario scenario = mock(Scenario.class);
        String scenarioName = "testScenario";
        when(driver.getScreenshotAs(OutputType.BYTES)).thenReturn(new byte[0]);

        byte[] screenshot = CommonUtils.takeScreenShot(scenario, driver, scenarioName);
        assertNotNull(screenshot);
        verify(driver).getScreenshotAs(OutputType.BYTES);
    }

    @Test
    public void shouldScrollToBottom() {
        when(driver instanceof JavascriptExecutor).thenReturn(true);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        when(js.executeScript("return document.body.scrollHeight")).thenReturn(100L, 200L, 200L);

        CommonUtils.scrollToBottom(driver);

        verify(js, times(3)).executeScript(anyString());
    }

    @Test
    public void shouldScrollToTop() {
        when(driver instanceof JavascriptExecutor).thenReturn(true);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        when(js.executeScript("return window.pageYOffset")).thenReturn(100L, 50L, 0L);

        CommonUtils.scrollToTop(driver);

        verify(js, times(3)).executeScript(anyString());
    }

    @Test
    public void shouldVerifyDropdownSelectedOptionIndex() {
        WebElement selectedOption = mock(WebElement.class);
        when(dropdownElement.getTagName()).thenReturn("select");
        when(dropdown.getFirstSelectedOption()).thenReturn(selectedOption);
        when(dropdown.getOptions()).thenReturn(new ArrayList<>());
        when(dropdown.getOptions().indexOf(selectedOption)).thenReturn(0);
        when(dropdownElement.getFirstSelectedOption()).thenReturn(selectedOption);
        
        CommonUtils.DropdownSelectedOptionVerification(dropdownElement, 0, "Dropdown option mismatch");

        verify(dropdown).getFirstSelectedOption();
        verify(dropdown).getOptions();
    }

    @Test
    public void shouldCaptureScreenshot() throws IOException {
        String name = "screenshot";
        File fileMock = mock(File.class);
        when(driver.getScreenshotAs(OutputType.FILE)).thenReturn(fileMock);
        when(fileMock.getPath()).thenReturn("mockPath");

        String resultPath = CommonUtils.captureScreenshot(driver, name);
        assertEquals(System.getProperty("user.dir") + "/screenshots/" + name + ".png", resultPath);
        verify(driver).getScreenshotAs(OutputType.FILE);
    }

    @Test
    public void shouldSwitchToNewWindow() {
        when(driver.getWindowHandle()).thenReturn("currentWindow");
        when(driver.getWindowHandles()).thenReturn(new ArrayList<String>() {{
            add("currentWindow");
            add("newWindow");
        }});

        CommonUtils.switchToNewWindow(driver);

        verify(driver).switchTo().window("newWindow");
    }

    @Test
    public void shouldSwitchToParentWindow() {
        when(driver.getWindowHandles()).thenReturn(new ArrayList<String>() {{
            add("parentWindow");
        }});

        CommonUtils.switchToParentWindow(driver);

        verify(driver).switchTo().window("parentWindow");
    }

    @Test
    public void shouldUploadFile() {
        String filePath = "path/to/file";
        CommonUtils.uploadFile(dropdownElement, filePath);
        verify(dropdownElement).sendKeys(filePath);
    }

    @Test
    public void shouldCheckIfAlertIsPresent() {
        when(driver.switchTo().alert()).thenThrow(new NoAlertPresentException("No alert"));

        boolean result = CommonUtils.isAlertPresent(driver);
        assertFalse(result);
        verify(driver).switchTo();
    }

    @Test
    public void shouldAcceptAlert() {
        Alert alertMock = mock(Alert.class);
        when(driver.switchTo().alert()).thenReturn(alertMock);

        CommonUtils.acceptAlert(driver);
        verify(alertMock).accept();
    }

    @Test
    public void shouldDismissAlert() {
        Alert alertMock = mock(Alert.class);
        when(driver.switchTo().alert()).thenReturn(alertMock);

        CommonUtils.dismissAlert(driver);
        verify(alertMock).dismiss();
    }

    @Test
    public void shouldWaitForElementVisible() {
        WebElement elementMock = mock(WebElement.class);
        WebDriverWait waitMock = mock(WebDriverWait.class);
        when(driver, any())).thenReturn(waitMock);

        CommonUtils.waitForElementVisible(driver, elementMock);
        verify(waitMock).until(any());
    }

    @Test
    public void shouldWaitForElementClickable() {
        WebElement elementMock = mock(WebElement.class);
        WebDriverWait waitMock = mock(WebDriverWait.class);
        when(driver, any())).thenReturn(waitMock);

        CommonUtils.waitForElementClickable(driver, elementMock);
        verify(waitMock).until(any());
    }

    @Test
    public void shouldWaitForPageLoad() {
        WebDriverWait waitMock = mock(WebDriverWait.class);
        when(driver, any())).thenReturn(waitMock);

        CommonUtils.waitForPageLoad(driver);
        verify(waitMock).until(any());
    }

    @Test
    public void shouldRefreshPage() {
        CommonUtils.refreshPage(driver);
        verify(driver).navigate().refresh();
    }

    @Test
    public void shouldMaximizeWindow() {
        CommonUtils.maximizeWindow(driver);
        verify(driver.manage().window()).maximize();
    }

    @Test
    public void shouldSleep() throws InterruptedException {
        CommonUtils.sleep(1);
        // Here we can't verify sleep directly, but we can check that it doesn't throw an exception
    }
}
