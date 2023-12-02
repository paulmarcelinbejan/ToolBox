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
	 * Build a pattern combining DatePattern with TimePattern.
	 * 
	 * @param DatePattern datePattern
	 * @param String dateTimeConcatenation, 'T' as in ISO format, ' ' or whatever
	 * @param TimePattern timePattern
	 * 
	 * @return a new DateTimePattern
	 */
	public static final <DatePattern extends DatePatternBase, TimePattern extends TimePatternBase> String buildPattern(DatePattern datePattern, String dateTimeConcatenation, TimePattern timePattern) {
		return new StringBuilder()
				.append(datePattern.getValue())
				.append(dateTimeConcatenation)
				.append(timePattern.getValue())
				.toString();
	}
	
	public static final <DatePattern extends DatePatternBase, TimePattern extends TimePatternBase> String toString(LocalDateTime localDateTime, DatePattern datePattern, String dateTimeConcatenation, TimePattern timePattern) {
		return formatter(buildPattern(datePattern, dateTimeConcatenation, timePattern)).format(localDateTime);
	}
	
	public static final <DatePattern extends DatePatternBase, TimePattern extends TimePatternBase> String toString(LocalDateTime localDateTime, DatePattern datePattern, String dateTimeConcatenation, TimePattern timePattern, Locale locale) {
		return formatterLocalized(buildPattern(datePattern, dateTimeConcatenation, timePattern), locale).format(localDateTime);
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 */
	public static final <DateTimePattern extends DateTimePatternBase> String toString(LocalDateTime localDateTime, DateTimePattern dateTimePattern) {
		return dateTimePattern.getFormatter().format(localDateTime);
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 */
	public static final <DateTimePattern extends DateTimePatternBase> String toString(LocalDateTime localDateTime, DateTimePattern dateTimePattern, Locale locale) {
		return formatterLocalized(dateTimePattern.getFormatter(), locale).format(localDateTime);
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 */
	public static final String toString(LocalDateTime localDateTime, String dateTimePattern) {
		return formatter(dateTimePattern).format(localDateTime);
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 */
	public static final String toString(LocalDateTime localDateTime, String dateTimePattern, Locale locale) {
		return formatterLocalized(dateTimePattern, locale).format(localDateTime);
	}
	
	// To LocalDateTime
	
	/**
	 * @throws DateTimeParseException - if the text cannot be parsed
	 */
	public static final <DateTimePattern extends DateTimePatternBase> LocalDateTime toLocalDateTime(String dateTime, DateTimePattern dateTimePattern) {
		return LocalDateTime.parse(dateTime, dateTimePattern.getFormatter());
	}
	
	/**
	 * @throws DateTimeParseException - if the text cannot be parsed
	 */
	public static final <DateTimePattern extends DateTimePatternBase> LocalDateTime toLocalDateTime(String dateTime, DateTimePattern dateTimePattern, Locale locale) {
		return LocalDateTime.parse(dateTime, formatterLocalized(dateTimePattern.getFormatter(), locale));
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 */
	public static final LocalDateTime toLocalDateTime(String date, String dateTimePattern) {
		return LocalDateTime.parse(date, formatter(dateTimePattern));
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 * @throws DateTimeParseException - if the text cannot be parsed
	 */
	public static final LocalDateTime toLocalDateTime(String date, String dateTimePattern, Locale locale) {
		return LocalDateTime.parse(date, formatterLocalized(dateTimePattern, locale));
	}
	
}
