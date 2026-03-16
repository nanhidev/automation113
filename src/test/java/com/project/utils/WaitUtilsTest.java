
package com.project.utils;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoExtension;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@ExtendWith(MockitoExtension.class)
class WaitUtilsTest {

    @Mock
    private WebDriver driver;

    @Mock
    private WebElement element;

    @Mock
    private By locator;

    @Mock
    private Alert alert;

    @Test
    void shouldReturnElementWhenVisible() {
        when(driver.findElement(locator)).thenReturn(element);
        when(driver).thenReturn(driver);
        when(ExpectedConditions.visibilityOf(element)).thenReturn(element);

        WebElement result = WaitUtils.waitForVisibility(driver, locator);
        
        assertNotNull(result);
        verify(driver).findElement(locator);
    }

    @Test
    void shouldReturnElementWhenClickable() {
        when(driver.findElement(locator)).thenReturn(element);
        when(ExpectedConditions.elementToBeClickable(element)).thenReturn(element);

        WebElement result = WaitUtils.waitForClickable(driver, locator);
        
        assertNotNull(result);
        verify(driver).findElement(locator);
    }

    @Test
    void shouldReturnListWhenAllVisible() {
        List<WebElement> elements = mock(List.class);
        when(driver.findElements(locator)).thenReturn(elements);
        when(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)).thenReturn(elements);

        List<WebElement> result = WaitUtils.waitForAllVisible(driver, locator);
        
        assertNotNull(result);
        verify(driver).findElements(locator);
    }

    @Test
    void shouldReturnTrueWhenInvisibility() {
        when(ExpectedConditions.invisibilityOfElementLocated(locator)).thenReturn(true);

        boolean result = WaitUtils.waitForInvisibility(driver, locator);
        
        assertTrue(result);
        verify(driver).findElement(locator);
    }

    @Test
    void shouldReturnAlertWhenPresent() {
        when(ExpectedConditions.alertIsPresent()).thenReturn(alert);

        Alert result = WaitUtils.waitForAlert(driver);
        
        assertNotNull(result);
        verify(driver).switchTo();
    }

    @Test
    void shouldCompletePageLoad() {
        when(ExpectedConditions.urlToBe(anyString())).thenReturn(true);
        
        WaitUtils.waitForPageLoad(driver);
        
        verify(driver).getCurrentUrl();
    }

    @Test
    void shouldReturnNumberOfWindows() {
        when(ExpectedConditions.numberOfWindowsToBe(1)).thenReturn(true);

        boolean result = WaitUtils.waitForNumberOfWindows(driver, 1);
        
        assertTrue(result);
        verify(driver).getWindowHandles();
    }
}
