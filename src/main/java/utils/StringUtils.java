package utils;

/**
 * Utility class for String operations.
 */
public final class StringUtils {

    private StringUtils() {
        // Private constructor to prevent instantiation
    }

    /**
     * Checks if a String is null or empty.
     *
     * @param value The string to check.
     * @return true if null or empty, false otherwise.
     */
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }
}
