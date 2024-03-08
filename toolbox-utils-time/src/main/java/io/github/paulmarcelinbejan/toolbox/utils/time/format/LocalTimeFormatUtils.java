package io.github.paulmarcelinbejan.toolbox.utils.time.format;

import static io.github.paulmarcelinbejan.toolbox.utils.time.format.common.FormatUtils.formatter;
import static io.github.paulmarcelinbejan.toolbox.utils.time.format.common.FormatUtils.formatterLocalized;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import io.github.paulmarcelinbejan.toolbox.utils.time.pattern.TimePatternBase;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Utility class for formatting and parsing LocalTime.
 * Provides methods to format instances using custom time patterns or strings,
 * and parse strings into LocalTime instances with specified patterns.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocalTimeFormatUtils {

	// TO String

    /**
     * Formats a LocalTime instance into a string using the specified time pattern.
     *
     * @param localTime    The LocalTime instance to be formatted.
     * @param timePattern  The custom time pattern to be used for formatting.
     * @param <TimePattern> A type parameter extending TimePatternBase.
     * @return A formatted string representing the provided LocalTime.
     */
    public static final <TimePattern extends TimePatternBase> String toString(LocalTime localTime, TimePattern timePattern) {
        return timePattern.getFormatter().format(localTime);
    }

    /**
     * Formats a LocalTime instance into a string using the specified time pattern and locale.
     *
     * @param localTime    The LocalTime instance to be formatted.
     * @param timePattern  The custom time pattern to be used for formatting.
     * @param locale       The locale to be applied to the formatter.
     * @param <TimePattern> A type parameter extending TimePatternBase.
     * @return A localized and formatted string representing the provided LocalTime.
     */
    public static final <TimePattern extends TimePatternBase> String toString(LocalTime localTime, TimePattern timePattern, Locale locale) {
        return timePattern.getFormatter().localizedBy(locale).format(localTime);
    }

    /**
     * Formats a LocalDateTime instance into a string using the specified time pattern.
     *
     * @param localTime    The LocalDateTime instance to be formatted.
     * @param timePattern  The custom time pattern to be used for formatting.
     * @param <TimePattern> A type parameter extending TimePatternBase.
     * @return A formatted string representing the provided LocalDateTime.
     */
    public static final <TimePattern extends TimePatternBase> String toString(LocalDateTime localTime, TimePattern timePattern) {
        return timePattern.getFormatter().format(localTime);
    }

    /**
     * Formats a LocalDateTime instance into a string using the specified time pattern and locale.
     *
     * @param localTime    The LocalDateTime instance to be formatted.
     * @param timePattern  The custom time pattern to be used for formatting.
     * @param locale       The locale to be applied to the formatter.
     * @param <TimePattern> A type parameter extending TimePatternBase.
     * @return A localized and formatted string representing the provided LocalDateTime.
     */
    public static final <TimePattern extends TimePatternBase> String toString(LocalDateTime localTime, TimePattern timePattern, Locale locale) {
        return timePattern.getFormatter().localizedBy(locale).format(localTime);
    }

    /**
     * Formats a LocalTime instance into a string using the specified time pattern as a string.
     *
     * @param localTime    The LocalTime instance to be formatted.
     * @param timePattern  The custom time pattern as a string to be used for formatting.
     * @return A formatted string representing the provided LocalTime.
     * @throws IllegalArgumentException if the pattern is invalid.
     */
    public static final String toString(LocalTime localTime, String timePattern) {
        return DateTimeFormatter.ofPattern(timePattern).format(localTime);
    }

    /**
     * Formats a LocalTime instance into a string using the specified time pattern as a string and locale.
     *
     * @param localTime    The LocalTime instance to be formatted.
     * @param timePattern  The custom time pattern as a string to be used for formatting.
     * @param locale       The locale to be applied to the formatter.
     * @return A localized and formatted string representing the provided LocalTime.
     * @throws IllegalArgumentException if the pattern is invalid.
     */
    public static final String toString(LocalTime localTime, String timePattern, Locale locale) {
        return DateTimeFormatter.ofPattern(timePattern).localizedBy(locale).format(localTime);
    }

    // To LocalTime

    /**
     * Parses a string into a LocalTime instance using the specified time pattern.
     *
     * @param time         The string to be parsed into a LocalTime instance.
     * @param timePattern  The custom time pattern to be used for parsing.
     * @param <TimePattern> A type parameter extending TimePatternBase.
     * @return The LocalTime instance parsed from the provided string.
     * @throws DateTimeParseException - if the text cannot be parsed.
     */
    public static final <TimePattern extends TimePatternBase> LocalTime toLocalTime(String time, TimePattern timePattern) {
        return LocalTime.parse(time, timePattern.getFormatter());
    }

    /**
     * Parses a string into a LocalTime instance using the specified time pattern and locale.
     *
     * @param time         The string to be parsed into a LocalTime instance.
     * @param timePattern  The custom time pattern to be used for parsing.
     * @param locale       The locale to be applied to the formatter.
     * @param <TimePattern> A type parameter extending TimePatternBase.
     * @return The LocalTime instance parsed from the provided string.
     * @throws DateTimeParseException - if the text cannot be parsed.
     */
    public static final <TimePattern extends TimePatternBase> LocalTime toLocalTime(String time, TimePattern timePattern, Locale locale) {
        return LocalTime.parse(time, formatterLocalized(timePattern.getFormatter(), locale));
    }

    /**
     * Parses a string into a LocalTime instance using the specified time pattern as a string.
     *
     * @param time         The string to be parsed into a LocalTime instance.
     * @param timePattern  The custom time pattern as a string to be used for parsing.
     * @return The LocalTime instance parsed from the provided string.
     * @throws IllegalArgumentException if the pattern is invalid.
     * @throws DateTimeParseException - if the text cannot be parsed.
     */
    public static final LocalTime toLocalTime(String time, String timePattern) {
        return LocalTime.parse(time, formatter(timePattern));
    }

    /**
     * Parses a string into a LocalTime instance using the specified time pattern as a string and locale.
     *
     * @param time         The string to be parsed into a LocalTime instance.
     * @param timePattern  The custom time pattern as a string to be used for parsing.
     * @param locale       The locale to be applied to the formatter.
     * @return The LocalTime instance parsed from the provided string.
     * @throws IllegalArgumentException if the pattern is invalid.
     * @throws DateTimeParseException - if the text cannot be parsed.
     */
    public static final LocalTime toLocalTime(String time, String timePattern, Locale locale) {
        return LocalTime.parse(time, formatterLocalized(timePattern, locale));
    }

}
