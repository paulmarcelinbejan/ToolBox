package io.github.paulmarcelinbejan.toolbox.utils.text;

import java.security.InvalidParameterException;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Utility class for common text-related operations.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TextUtils {

    /**
     * Checks if the given string is equal to any of the provided options.
     *
     * @param str     The string to compare.
     * @param options The options to compare against.
     * @return {@code true} if the string is equal to any of the options, {@code false} otherwise.
     */
	public static boolean isEqualToAny(final String text, final String... options) {
        for (String option : options) {
			if (isEqualTo(text, option)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if the given string is not equal to any of the provided options.
     *
     * @param str     The string to compare.
     * @param options The options to compare against.
     * @return {@code true} if the string is not equal to any of the options, {@code false} otherwise.
     */
	public static boolean isNotEqualToAny(final String text, final String... options) {
        for (String option : options) {
			if (isEqualTo(text, option)) {
                return false;
            }
        }
        return true;
    }
	
    /**
     * Checks if two strings are equal.
     *
     * @param left  The first string.
     * @param right The second string.
     * @return {@code true} if the strings are equal, {@code false} otherwise.
     */
	public static boolean isEqualTo(final String left, final String right) {
		return compareTo(left, right) == 0;
	}

	/**
     * Checks if two strings are not equal.
     *
     * @param left  The first string.
     * @param right The second string.
     * @return {@code true} if the strings are not equal, {@code false} otherwise.
     */
	public static boolean isNotEqualTo(final String left, final String right) {
		return compareTo(left, right) != 0;
	}

	 /**
     * Checks if the first string is lexicographically less than the second string.
     *
     * @param left  The first string.
     * @param right The second string.
     * @return {@code true} if the first string is less than the second string, {@code false} otherwise.
     */
		public static boolean isLessThan(final String left, final String right) {
		return compareTo(left, right) < 0;
	}

	/**
     * Checks if the first string is lexicographically less than or equal to the second string.
     *
     * @param left  The first string.
     * @param right The second string.
     * @return {@code true} if the first string is less than or equal to the second string, {@code false} otherwise.
     */
	public static boolean isLessThanOrEqualTo(final String left, final String right) {
		return compareTo(left, right) <= 0;
	}

	/**
     * Checks if the first string is lexicographically greater than the second string.
     *
     * @param left  The first string.
     * @param right The second string.
     * @return {@code true} if the first string is greater than the second string, {@code false} otherwise.
     */
	public static boolean isGreaterThan(final String left, final String right) {
		return compareTo(left, right) > 0;
	}

	/**
     * Checks if the first string is lexicographically greater than or equal to the second string.
     *
     * @param left  The first string.
     * @param right The second string.
     * @return {@code true} if the first string is greater than or equal to the second string, {@code false} otherwise.
     */
	public static boolean isGreaterThanOrEqualTo(final String left, final String right) {
		return compareTo(left, right) >= 0;
	}

	/**
     * Compares two strings lexicographically.
     *
     * @param left  The first string.
     * @param right The second string.
     * @return A negative integer, zero, or a positive integer as the first string is less than, equal to, or greater than the second string.
     */
	private static int compareTo(final String left, final String right) {
		return left.compareTo(right);
	}
	
	/**
     * Converts the first letter of the given string to uppercase.
     *
     * @param text The input string.
     * @return The input string with the first letter converted to uppercase.
     * @throws InvalidParameterException if the input string is null or empty.
     */
	public static String firstLetterUppercase(final String text) {
		if (text == null || text.isEmpty()) {
			throw new InvalidParameterException("The parameter text is null or empty!");
		}
		return new StringBuilder()
				.append(text.substring(0, 1).toUpperCase())
				.append(text.substring(1))
				.toString();
	}

}
