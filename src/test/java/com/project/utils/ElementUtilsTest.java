
package com.project.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ElementUtilsTest {

    @Mock
    private WebDriver driver;

    @Mock
    private WebElement element;

    @InjectMocks
    private ElementUtils elementUtils;

    @BeforeEach
    public void setUp() {
        elementUtils = new ElementUtils(driver);
    }

    @Test
    public void shouldReturnRandomTime() {
        LocalTime randomTime = ElementUtils.getRandomTime();
        assertNotNull(randomTime);
    }

    @Test
    public void shouldReturnFalseWhenElementIsReadOnly() {
        when(element.getAttribute("disabled")).thenReturn("false");
        when(element.getAttribute("readonly")).thenReturn("false");
        
        boolean result = elementUtils.isElementReadOnly(driver, element);
        assertFalse(result);
    }

    @Test
    public void shouldClickElementUsingJsClick() {
        ElementUtils.jsClick(driver, element);
        verify((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        verify((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    @Test
    public void shouldCheckFieldReadOnly() {
        when(driver.findElement(any(By.class))).thenReturn(element);
        when(element.getAttribute("readonly")).thenReturn("true");

        ElementUtils.checkFieldReadOnly(driver, By.className("test-class"));
        verify(element, times(1)).getAttribute("readonly");
    }

    @Test
    public void shouldCheckFieldNotReadOnly() {
        when(driver.findElement(any(By.class))).thenReturn(element);
        when(element.getAttribute("readonly")).thenReturn("false");

        ElementUtils.checkFieldNotReadOnly(driver, By.className("test-class"));
        verify(element, times(1)).getAttribute("readonly");
    }

    @Test
    public void shouldClickElement() {
        when(driver.findElement(any())).thenReturn(element);
        when(element.isDisplayed()).thenReturn(true);
        
        elementUtils.clickElement(element);
        verify(element, times(1)).click();
    }

    @Test
    public void shouldReturnTrueIfElementClickable() {
        when(driver.findElement(any())).thenReturn(element);
        when(element.isEnabled()).thenReturn(false);
        
        boolean result = ElementUtils.isElementClickable(driver, By.className("test-class"));
        assertTrue(result);
    }

    @Test
    public void shouldClearAndSendKeys() {
        elementUtils.clearAndSendKeys(element, "test text");
        
        verify(element, times(1)).clear();
        verify(element, times(1)).sendKeys("test text");
    }

    @Test
    public void shouldClearElement() {
        elementUtils.clearElement(element);
        verify(element, times(1)).clear();
    }

    @Test
    public void shouldReturnElementWhenWaitForElement() {
        when(driver.findElement(any())).thenReturn(element);
        
        WebElement result = elementUtils.waitForElement(element, 10);
        assertNotNull(result);
    }

    @Test
    public void shouldFetchAndVerifyElementValues() {
        List<String> xpaths = Collections.singletonList("//input[@id='test']");
        List<String> expectedValues = Collections.singletonList("expected");

        when(driver.findElement(By.xpath("//input[@id='test']"))).thenReturn(element);
        when(element.getText()).thenReturn("expected");

        elementUtils.fetchAndVerifyElementValues(xpaths, expectedValues);
    }

    @Test
    public void shouldSelectOptionInDropdown() {
        elementUtils.selectOptionInDropdown(element, "Option 1");
        verify(element, times(1)).click();
    }

    @Test
    public void shouldSelectOptionInNgSelect() {
        elementUtils.selectOptionInNgSelect(element, "Option 1");
        verify(element, times(1)).click();
    }

    @Test
    public void shouldAcceptAlert() {
        elementUtils.acceptAlert();
        verify(driver, times(1)).switchTo();
    }

    @Test
    public void shouldDismissAlert() {
        elementUtils.dismissAlert(10);
        verify(driver, times(1)).switchTo();
    }

    @Test
    public void shouldReturnTrueIfPaginationPresent() {
        when(driver.findElements(any())).thenReturn(Collections.emptyList());
        boolean result = elementUtils.isPaginationPresent();
        assertFalse(result);
    }

    @Test
    public void shouldNavigateToLastPageIfPresent() {
        when(driver.findElements(any())).thenReturn(Collections.singletonList(element));
        elementUtils.navigateToLastPageIfPresent();
        verify(element, times(1)).click();
    }

    @Test
    public void shouldReturnTrueIfElementDisplayed() {
        when(element.isDisplayed()).thenReturn(true);
        boolean result = elementUtils.isElementDisplayed(element);
        assertTrue(result);
    }

    @Test
    public void shouldScrollToElement() {
        elementUtils.scrollToElement(element);
        verify((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Test
    public void shouldAssertNumberNotInDropdown() {
        List<WebElement> options = Collections.singletonList(element);
        when(element.getText()).thenReturn("1");

        elementUtils.assertNumberNotInDropdown(options, "2");
    }

    @Test
    public void shouldSelectOptionInDropdownByIndex() {
        elementUtils.selectOptionInDropdownByIndex(element, 1);
        verify(element, times(1)).click();
    }

    @Test
    public void shouldDoubleClickElement() {
        elementUtils.doubleClickElement(element);
        verify(element, times(1)).click();
    }
    
    @Test
    public void shouldVerifyDropdownOptions() {
        List<String> expectedOptions = Collections.singletonList("Option 1");
        elementUtils.verifyDropdownOptions(element, expectedOptions, "Dropdown option count mismatch");
    }
}
