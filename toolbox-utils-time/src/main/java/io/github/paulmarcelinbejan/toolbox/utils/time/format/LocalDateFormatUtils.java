package io.github.paulmarcelinbejan.toolbox.utils.time.format;

import static io.github.paulmarcelinbejan.toolbox.utils.time.format.common.FormatUtils.formatter;
import static io.github.paulmarcelinbejan.toolbox.utils.time.format.common.FormatUtils.formatterLocalized;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import io.github.paulmarcelinbejan.toolbox.utils.time.pattern.DatePatternBase;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * The {@code LocalDateFormatUtils} class provides utility methods for
 * formatting and parsing {@link LocalDate} instances using different date
 * patterns. This class uses {@link DatePatternBase} for defining date patterns.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocalDateFormatUtils {

    // To String

    /**
     * Formats a {@link LocalDate} using the specified {@link DatePatternBase}.
     *
     * @param localDate   The {@code LocalDate} to format.
     * @param datePattern The date pattern to use.
     * @param <DatePattern> The type of date pattern.
     * @return The formatted date as a string.
     */
    public static final <DatePattern extends DatePatternBase> String toString(LocalDate localDate, DatePattern datePattern) {
        return datePattern.getFormatter().format(localDate);
    }

    /**
     * Formats a {@link LocalDate} using the specified {@link DatePatternBase} and locale.
     *
     * @param localDate   The {@code LocalDate} to format.
     * @param datePattern The date pattern to use.
     * @param locale      The locale to use for formatting.
     * @param <DatePattern> The type of date pattern.
     * @return The formatted date as a string.
     */
    public static final <DatePattern extends DatePatternBase> String toString(LocalDate localDate, DatePattern datePattern, Locale locale) {
        return formatterLocalized(datePattern.getFormatter(), locale).format(localDate);
    }

    /**
     * Formats a {@link LocalDate} using the specified date pattern string.
     *
     * @param localDate   The {@code LocalDate} to format.
     * @param datePattern The date pattern string to use.
     * @return The formatted date as a string.
     * @throws IllegalArgumentException if the pattern is invalid
     */
    public static final String toString(LocalDate localDate, String datePattern) {
        return formatter(datePattern).format(localDate);
    }

    /**
     * Formats a {@link LocalDate} using the specified date pattern string and locale.
     *
     * @param localDate   The {@code LocalDate} to format.
     * @param datePattern The date pattern string to use.
     * @param locale      The locale to use for formatting.
     * @return The formatted date as a string.
     * @throws IllegalArgumentException if the pattern is invalid
     */
    public static final String toString(LocalDate localDate, String datePattern, Locale locale) {
        return formatterLocalized(datePattern, locale).format(localDate);
    }

    // To LocalDate

    /**
     * Parses a {@link LocalDate} from the specified date string using the specified {@link DatePatternBase}.
     *
     * @param date        The date string to parse.
     * @param datePattern The date pattern to use for parsing.
     * @param <DatePattern> The type of date pattern.
     * @return The parsed {@code LocalDate}.
     * @throws DateTimeParseException if the text cannot be parsed
     */
    public static final <DatePattern extends DatePatternBase> LocalDate toLocalDate(String date, DatePattern datePattern) {
        return LocalDate.parse(date, datePattern.getFormatter());
    }

    /**
     * Parses a {@link LocalDate} from the specified date string using the specified {@link DatePatternBase} and locale.
     *
     * @param date        The date string to parse.
     * @param datePattern The date pattern to use for parsing.
     * @param locale      The locale to use for parsing.
     * @param <DatePattern> The type of date pattern.
     * @return The parsed {@code LocalDate}.
     * @throws DateTimeParseException if the text cannot be parsed
     */
    public static final <DatePattern extends DatePatternBase> LocalDate toLocalDate(String date, DatePattern datePattern, Locale locale) {
        return LocalDate.parse(date, formatterLocalized(datePattern.getFormatter(), locale));
    }

    /**
     * Parses a {@link LocalDate} from the specified date string using the specified date pattern string.
     *
     * @param date        The date string to parse.
     * @param datePattern The date pattern string to use for parsing.
     * @return The parsed {@code LocalDate}.
     * @throws IllegalArgumentException if the pattern is invalid
     * @throws DateTimeParseException if the text cannot be parsed
     */
    public static final LocalDate toLocalDate(String date, String datePattern) {
        return LocalDate.parse(date, formatter(datePattern));
    }

    /**
     * Parses a {@link LocalDate} from the specified date string using the specified date pattern string and locale.
     *
     * @param date        The date string to parse.
     * @param datePattern The date pattern string to use for parsing.
     * @param locale      The locale to use for parsing.
     * @return The parsed {@code LocalDate}.
     * @throws IllegalArgumentException if the pattern is invalid
     * @throws DateTimeParseException if the text cannot be parsed
     */
    public static final LocalDate toLocalDate(String date, String datePattern, Locale locale) {
        return LocalDate.parse(date, formatterLocalized(datePattern, locale));
    }

}
