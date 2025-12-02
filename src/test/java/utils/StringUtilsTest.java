package utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    @DisplayName("Should return true for null value")
    void shouldReturnTrueForNullValue() {
        assertTrue(StringUtils.isNullOrEmpty(null));
    }

    @Test
    @DisplayName("Should return true for empty string")
    void shouldReturnTrueForEmptyString() {
        assertTrue(StringUtils.isNullOrEmpty(""));
    }

    @Test
    @DisplayName("Should return false for non-empty string")
    void shouldReturnFalseForNonEmptyString() {
        assertFalse(StringUtils.isNullOrEmpty("Hello"));
    }

    @Test
    @DisplayName("Should return false for whitespace string")
    void shouldReturnFalseForWhitespaceString() {
        assertFalse(StringUtils.isNullOrEmpty("   "));
    }
}
