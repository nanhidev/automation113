
package com.project.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AssertTest {

    @Mock
    private WebDriver driver;

    @Mock
    private WebElement element;

    @InjectMocks
    private Assert assertObj;

    @Test
    public void shouldAssertTrueWhenConditionIsTrue() {
        assertObj.assertTrue(true, "Condition should be true");
    }

    @Test
    public void shouldAssertFalseWhenConditionIsFalse() {
        assertObj.assertFalse(false, "Condition should be false");
    }

    @Test
    public void shouldAssertEqualsWhenValuesAreEqual() {
        assertObj.assertEquals("value", "value", "Values should be equal");
    }

    @Test
    public void shouldAssertNotEqualsWhenValuesAreNotEqual() {
        assertObj.assertNotEquals("value1", "value2", "Values should not be equal");
    }

    @Test
    public void shouldAssertNotNullWhenObjectIsNotNull() {
        assertObj.assertNotNull(new Object(), "Object should not be null");
    }

    @Test
    public void shouldAssertNullWhenObjectIsNull() {
        assertObj.assertNull(null, "Object should be null");
    }

    @Test
    public void shouldAssertContainsWhenStringContainsSubstring() {
        assertObj.assertContains("Hello, World!", "World", "String should contain substring");
    }

    @Test
    public void shouldAssertNotContainsWhenStringDoesNotContainSubstring() {
        assertObj.assertNotContains("Hello, World!", "Java", "String should not contain substring");
    }

    @Test
    public void shouldAssertElementVisibleWhenElementIsVisible() {
        when(driver.findElement(any(By.class))).thenReturn(element);
        when(element.isDisplayed()).thenReturn(true);
        assertObj.assertElementVisible(driver, element, "Element should be visible");
    }

    @Test
    public void shouldAssertElementNotVisibleWhenElementIsNotVisible() {
        when(driver.findElement(any(By.class))).thenReturn(element);
        when(element.isDisplayed()).thenReturn(false);
        assertObj.assertElementNotVisible(driver, element, "Element should not be visible");
    }

    @Test
    public void shouldAssertElementEnabledWhenElementIsEnabled() {
        when(element.isEnabled()).thenReturn(true);
        assertObj.assertElementEnabled(driver, element, "Element should be enabled");
    }

    @Test
    public void shouldAssertElementDisabledWhenElementIsDisabled() {
        when(element.isEnabled()).thenReturn(false);
        assertObj.assertElementDisabled(driver, element, "Element should be disabled");
    }

    @Test
    public void shouldAssertElementTextWhenTextMatches() {
        when(element.getText()).thenReturn("Expected Text");
        assertObj.assertElementText(driver, element, "Expected Text", "Element text should match");
    }

    @Test
    public void shouldAssertListNotEmptyWhenListIsNotEmpty() {
        assertObj.assertListNotEmpty(Collections.singletonList(new Object()), "List should not be empty");
    }

    @Test
    public void shouldAssertListSizeWhenSizeMatches() {
        assertObj.assertListSize(Collections.singletonList(new Object()), 1, "List size should match");
    }

    @Test
    public void shouldAssertCurrentUrlWhenUrlMatches() {
        when(driver.getCurrentUrl()).thenReturn("http://example.com");
        assertObj.assertCurrentUrl(driver, "http://example.com");
    }

    @Test
    public void shouldAssertPageTitleWhenTitleMatches() {
        when(driver.getTitle()).thenReturn("Expected Title");
        assertObj.assertPageTitle(driver, "Expected Title");
    }
}
