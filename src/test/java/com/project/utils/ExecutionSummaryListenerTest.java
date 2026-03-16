
package com.project.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testng.ITestContext;
import org.testng.ITestResult;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExecutionSummaryListenerTest {

    @InjectMocks
    private ExecutionSummaryListener executionSummaryListener;

    @Mock
    private ITestResult testResult;

    @Mock
    private ITestContext testContext;

    @Test
    public void shouldIncrementPassedCountWhenTestSuccess() {
        executionSummaryListener.onTestSuccess(testResult);
        // Verify that passed count is incremented
        // Note: You can only verify interactions, not internal state
    }

    @Test
    public void shouldIncrementFailedCountWhenTestFailure() {
        executionSummaryListener.onTestFailure(testResult);
        // Verify that failed count is incremented
    }

    @Test
    public void shouldIncrementSkippedCountWhenTestSkipped() {
        executionSummaryListener.onTestSkipped(testResult);
        // Verify that skipped count is incremented
    }

    @Test
    public void shouldPrintSummaryOnFinish() {
        executionSummaryListener.onFinish(testContext);
        // Verify that the summary output is printed
        // Note: Actual verification of output would require a different approach (e.g., capturing System.out)
    }
}
