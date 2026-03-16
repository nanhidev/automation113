
package com.project.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FilePathTest {

    @Test
    public void shouldReturnConfigPropertyFilePath() {
        String expectedPath = "/src/test/resources/com/project/config/config.properties";
        String actualPath = FilePath.getConfigPropertyFilePath();
        assertEquals(expectedPath, actualPath);
    }
}
