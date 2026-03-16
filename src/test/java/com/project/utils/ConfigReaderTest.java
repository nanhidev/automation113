
package com.project.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ConfigReaderTest {

    @InjectMocks
    private ConfigReader configReader;

    @Mock
    private Properties properties;

    @BeforeEach
    void setUp() throws Exception {
        String userDir = System.getProperty("user.dir");
        String filePath = userDir + FilePath.getConfigPropertyFilePath();
        File file = new File(filePath);
        
        when(properties.getProperty("browser")).thenReturn("chrome");
        when(properties.getProperty("url")).thenReturn("http://localhost");
        when(properties.getProperty("implicit.wait")).thenReturn("10");
        when(properties.getProperty("explicit.wait")).thenReturn("5");
        when(properties.getProperty("browser.headless")).thenReturn("false");
        when(properties.getProperty("environment")).thenReturn("dev");
        when(properties.getProperty("framework.type")).thenReturn("cucumber-testng");
        when(properties.getProperty("test.runner")).thenReturn("junit");
        when(properties.getProperty("cucumber.tags")).thenReturn("@smoke");
        when(properties.getProperty("cucumber.features.path")).thenReturn("features/");
        when(properties.getProperty("cucumber.glue.path")).thenReturn("steps/");
        when(properties.getProperty("report.path")).thenReturn("reports/");
        when(properties.getProperty("screenshot.on.failure")).thenReturn("true");
        when(properties.getProperty("playwright.enabled")).thenReturn("false");
        when(properties.getProperty("visual.regression.enabled")).thenReturn("false");
        when(properties.getProperty("playwright.browser")).thenReturn("chromium");
    }

    @Test
    void shouldReturnBrowserWhenGetBrowserCalled() {
        assertEquals("chrome", configReader.getBrowser());
    }

    @Test
    void shouldReturnBaseUrlWhenGetBaseUrlCalled() {
        assertEquals("http://localhost", configReader.getBaseUrl());
    }

    @Test
    void shouldReturnImplicitWaitWhenGetImplicitWaitCalled() {
        assertEquals(10, configReader.getImplicitWait());
    }

    @Test
    void shouldReturnExplicitWaitWhenGetExplicitWaitCalled() {
        assertEquals(5, configReader.getExplicitWait());
    }

    @Test
    void shouldReturnIsHeadlessWhenIsHeadlessCalled() {
        assertTrue(!configReader.isHeadless());
    }

    @Test
    void shouldReturnEnvironmentWhenGetEnvironmentCalled() {
        assertEquals("dev", configReader.getEnvironment());
    }

    @Test
    void shouldReturnFrameworkTypeWhenGetFrameworkTypeCalled() {
        assertEquals("cucumber-testng", configReader.getFrameworkType());
    }

    @Test
    void shouldReturnTestRunnerWhenGetTestRunnerCalled() {
        assertEquals("junit", configReader.getTestRunner());
    }

    @Test
    void shouldReturnCucumberTagsWhenGetCucumberTagsCalled() {
        assertEquals("@smoke", configReader.getCucumberTags());
    }

    @Test
    void shouldReturnFeaturePathWhenGetFeaturePathCalled() {
        assertEquals("features/", configReader.getFeaturePath());
    }

    @Test
    void shouldReturnGluePathWhenGetGluePathCalled() {
        assertEquals("steps/", configReader.getGluePath());
    }

    @Test
    void shouldReturnReportPathWhenGetReportPathCalled() {
        assertEquals("reports/", configReader.getReportPath());
    }

    @Test
    void shouldReturnIsScreenshotOnFailureWhenIsScreenshotOnFailureCalled() {
        assertTrue(configReader.isScreenshotOnFailure());
    }

    @Test
    void shouldReturnIsPlaywrightEnabledWhenIsPlaywrightEnabledCalled() {
        assertTrue(!configReader.isPlaywrightEnabled());
    }

    @Test
    void shouldReturnIsVisualRegressionEnabledWhenIsVisualRegressionEnabledCalled() {
        assertTrue(!configReader.isVisualRegressionEnabled());
    }

    @Test
    void shouldReturnPlaywrightBrowserWhenGetPlaywrightBrowserCalled() {
        assertEquals("chromium", configReader.getPlaywrightBrowser());
    }
}
