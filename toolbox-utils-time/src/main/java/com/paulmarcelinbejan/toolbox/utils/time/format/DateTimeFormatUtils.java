package com.paulmarcelinbejan.toolbox.utils.time.format;

import static com.paulmarcelinbejan.toolbox.utils.time.format.common.FormatUtils.formatter;
import static com.paulmarcelinbejan.toolbox.utils.time.format.common.FormatUtils.localizedFormatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import com.paulmarcelinbejan.toolbox.utils.time.pattern.DatePatternBase;
import com.paulmarcelinbejan.toolbox.utils.time.pattern.DateTimePatternBase;
import com.paulmarcelinbejan.toolbox.utils.time.pattern.TimePatternBase;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Format a LocalDateTime into string containing date and time information.
 * Format a String into LocalDateTime
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateTimeFormatUtils {
	
	/**
	 * Build a pattern combining DatePattern with TimePattern.
	 * 
	 * @param DatePattern datePattern
	 * @param TimePattern timePattern
	 * @return a new DateTimePattern
	 */
	public static final <DatePattern extends DatePatternBase, TimePattern extends TimePatternBase> String buildPattern(DatePattern datePattern, TimePattern timePattern) {
		return datePattern.getValue() + " " + timePattern.getValue();
	}
	
	public static final <DatePattern extends DatePatternBase, TimePattern extends TimePatternBase> String toString(LocalDateTime localDateTime, DatePattern datePattern, TimePattern timePattern) {
		return formatter(buildPattern(datePattern, timePattern)).format(localDateTime);
	}
	
	public static final <DatePattern extends DatePatternBase, TimePattern extends TimePatternBase> String toString(LocalDateTime localDateTime, DatePattern datePattern, TimePattern timePattern, Locale locale) {
		return formatter(buildPattern(datePattern, timePattern), locale).format(localDateTime);
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
		return localizedFormatter(dateTimePattern.getFormatter(), locale).format(localDateTime);
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
		return formatter(dateTimePattern, locale).format(localDateTime);
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
		return LocalDateTime.parse(dateTime, localizedFormatter(dateTimePattern.getFormatter(), locale));
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
		return LocalDateTime.parse(date, formatter(dateTimePattern, locale));
	}
	
}
