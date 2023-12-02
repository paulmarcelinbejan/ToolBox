package io.github.paulmarcelinbejan.toolbox.utils.time.format;

import static io.github.paulmarcelinbejan.toolbox.utils.time.format.common.FormatUtils.formatter;
import static io.github.paulmarcelinbejan.toolbox.utils.time.format.common.FormatUtils.formatterLocalized;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import io.github.paulmarcelinbejan.toolbox.utils.time.pattern.DatePatternBase;
import io.github.paulmarcelinbejan.toolbox.utils.time.pattern.DateTimePatternBase;
import io.github.paulmarcelinbejan.toolbox.utils.time.pattern.TimePatternBase;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Format a LocalDateTime into string containing date and time information.
 * Format a String into LocalDateTime
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocalDateTimeFormatUtils {
	
	/**
	 * Build a pattern by combining DatePattern with TimePattern.
	 *
	 * @param <DatePattern> The type of DatePattern, extending DatePatternBase.
	 * @param <TimePattern> The type of TimePattern, extending TimePatternBase.
	 * @param datePattern   The DatePattern to be used.
	 * @param dateTimeConcatenation The String representing the concatenation between date and time, such as 'T' in ISO format or ' '.
	 * @param timePattern   The TimePattern to be used.
	 * @return A new DateTimePattern as a String.
	 */
	public static final <DatePattern extends DatePatternBase, TimePattern extends TimePatternBase> String buildPattern(DatePattern datePattern, String dateTimeConcatenation, TimePattern timePattern) {
	    return new StringBuilder()
	            .append(datePattern.getValue())
	            .append(dateTimeConcatenation)
	            .append(timePattern.getValue())
	            .toString();
	}

	/**
	 * Converts a LocalDateTime to a formatted String using the specified DatePattern, dateTimeConcatenation, and TimePattern.
	 *
	 * @param <DatePattern> The type of DatePattern, extending DatePatternBase.
	 * @param <TimePattern> The type of TimePattern, extending TimePatternBase.
	 * @param localDateTime The LocalDateTime to be formatted.
	 * @param datePattern   The DatePattern to be used.
	 * @param dateTimeConcatenation The String representing the concatenation between date and time, such as 'T' in ISO format or ' '.
	 * @param timePattern   The TimePattern to be used.
	 * @return A formatted String representation of the LocalDateTime.
	 */
	public static final <DatePattern extends DatePatternBase, TimePattern extends TimePatternBase> String toString(LocalDateTime localDateTime, DatePattern datePattern, String dateTimeConcatenation, TimePattern timePattern) {
	    return formatter(buildPattern(datePattern, dateTimeConcatenation, timePattern)).format(localDateTime);
	}

	/**
	 * Converts a LocalDateTime to a formatted String using the specified DatePattern, dateTimeConcatenation, TimePattern, and Locale.
	 *
	 * @param <DatePattern> The type of DatePattern, extending DatePatternBase.
	 * @param <TimePattern> The type of TimePattern, extending TimePatternBase.
	 * @param localDateTime The LocalDateTime to be formatted.
	 * @param datePattern   The DatePattern to be used.
	 * @param dateTimeConcatenation The String representing the concatenation between date and time, such as 'T' in ISO format or ' '.
	 * @param timePattern   The TimePattern to be used.
	 * @param locale        The Locale to be applied.
	 * @return A formatted String representation of the LocalDateTime with the specified Locale.
	 */
	public static final <DatePattern extends DatePatternBase, TimePattern extends TimePatternBase> String toString(LocalDateTime localDateTime, DatePattern datePattern, String dateTimeConcatenation, TimePattern timePattern, Locale locale) {
	    return formatterLocalized(buildPattern(datePattern, dateTimeConcatenation, timePattern), locale).format(localDateTime);
	}

	/**
	 * Converts a LocalDateTime to a formatted String using the specified DateTimePattern.
	 *
	 * @param <DateTimePattern> The type of DateTimePattern, extending DateTimePatternBase.
	 * @param localDateTime The LocalDateTime to be formatted.
	 * @param dateTimePattern The DateTimePattern to be used.
	 * @return A formatted String representation of the LocalDateTime.
	 * @throws IllegalArgumentException if the pattern is invalid.
	 */
	public static final <DateTimePattern extends DateTimePatternBase> String toString(LocalDateTime localDateTime, DateTimePattern dateTimePattern) {
	    return dateTimePattern.getFormatter().format(localDateTime);
	}

	/**
	 * Converts a LocalDateTime to a formatted String using the specified DateTimePattern and Locale.
	 *
	 * @param <DateTimePattern> The type of DateTimePattern, extending DateTimePatternBase.
	 * @param localDateTime The LocalDateTime to be formatted.
	 * @param dateTimePattern The DateTimePattern to be used.
	 * @param locale        The Locale to be applied.
	 * @return A formatted String representation of the LocalDateTime with the specified Locale.
	 * @throws IllegalArgumentException if the pattern is invalid.
	 */
	public static final <DateTimePattern extends DateTimePatternBase> String toString(LocalDateTime localDateTime, DateTimePattern dateTimePattern, Locale locale) {
	    return formatterLocalized(dateTimePattern.getFormatter(), locale).format(localDateTime);
	}

	/**
	 * Converts a LocalDateTime to a formatted String using the specified pattern.
	 *
	 * @param localDateTime The LocalDateTime to be formatted.
	 * @param dateTimePattern The pattern to be used.
	 * @return A formatted String representation of the LocalDateTime.
	 * @throws IllegalArgumentException if the pattern is invalid.
	 */
	public static final String toString(LocalDateTime localDateTime, String dateTimePattern) {
	    return formatter(dateTimePattern).format(localDateTime);
	}

	/**
	 * Converts a LocalDateTime to a formatted String using the specified pattern and Locale.
	 *
	 * @param localDateTime The LocalDateTime to be formatted.
	 * @param dateTimePattern The pattern to be used.
	 * @param locale        The Locale to be applied.
	 * @return A formatted String representation of the LocalDateTime with the specified Locale.
	 * @throws IllegalArgumentException if the pattern is invalid.
	 */
	public static final String toString(LocalDateTime localDateTime, String dateTimePattern, Locale locale) {
	    return formatterLocalized(dateTimePattern, locale).format(localDateTime);
	}

	// To LocalDateTime

	/**
	 * Parses a String to obtain a LocalDateTime using the specified DateTimePattern.
	 *
	 * @param <DateTimePattern> The type of DateTimePattern, extending DateTimePatternBase.
	 * @param dateTime The String to be parsed.
	 * @param dateTimePattern The DateTimePattern to be used.
	 * @return A LocalDateTime parsed from the input String.
	 * @throws DateTimeParseException if the text cannot be parsed.
	 */
	public static final <DateTimePattern extends DateTimePatternBase> LocalDateTime toLocalDateTime(String dateTime, DateTimePattern dateTimePattern) {
	    return LocalDateTime.parse(dateTime, dateTimePattern.getFormatter());
	}

	/**
	 * Parses a String to obtain a LocalDateTime using the specified DateTimePattern and Locale.
	 *
	 * @param <DateTimePattern> The type of DateTimePattern, extending DateTimePatternBase.
	 * @param dateTime The String to be parsed.
	 * @param dateTimePattern The DateTimePattern to be used.
	 * @param locale        The Locale to be applied.
	 * @return A LocalDateTime parsed from the input String with the specified Locale.
	 * @throws DateTimeParseException if the text cannot be parsed.
	 */
	public static final <DateTimePattern extends DateTimePatternBase> LocalDateTime toLocalDateTime(String dateTime, DateTimePattern dateTimePattern, Locale locale) {
	    return LocalDateTime.parse(dateTime, formatterLocalized(dateTimePattern.getFormatter(), locale));
	}

	/**
	 * Parses a String to obtain a LocalDateTime using the specified pattern.
	 *
	 * @param date The String to be parsed.
	 * @param dateTimePattern The pattern to be used.
	 * @return A LocalDateTime parsed from the input String.
	 * @throws IllegalArgumentException if the pattern is invalid.
	 * @throws DateTimeParseException if the text cannot be parsed.
	 */
	public static final LocalDateTime toLocalDateTime(String date, String dateTimePattern) {
	    return LocalDateTime.parse(date, formatter(dateTimePattern));
	}

	/**
	 * Parses a String to obtain a LocalDateTime using the specified pattern and Locale.
	 *
	 * @param date The String to be parsed.
	 * @param dateTimePattern The pattern to be used.
	 * @param locale        The Locale to be applied.
	 * @return A LocalDateTime parsed from the input String with the specified Locale.
	 * @throws IllegalArgumentException if the pattern is invalid.
	 * @throws DateTimeParseException if the text cannot be parsed.
	 */
	public static final LocalDateTime toLocalDateTime(String date, String dateTimePattern, Locale locale) {
	    return LocalDateTime.parse(date, formatterLocalized(dateTimePattern, locale));
	}
	
}
