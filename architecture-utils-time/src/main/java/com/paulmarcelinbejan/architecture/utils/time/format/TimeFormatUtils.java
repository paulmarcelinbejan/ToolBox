package com.paulmarcelinbejan.architecture.utils.time.format;

import static com.paulmarcelinbejan.architecture.utils.time.format.common.FormatUtils.formatter;
import static com.paulmarcelinbejan.architecture.utils.time.format.common.FormatUtils.localizedFormatter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.paulmarcelinbejan.architecture.utils.time.pattern.TimePatternBase;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Format a LocalTime / LocalDateTime into string containing time information.
 * Format a String into LocalTime.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeFormatUtils {

	public static final <TimePattern extends TimePatternBase> String toString(LocalTime localTime, TimePattern timePattern) {
		return timePattern.getFormatter().format(localTime);
	}
	
	public static final <TimePattern extends TimePatternBase> String toString(LocalTime localTime, TimePattern timePattern, Locale locale) {
		return timePattern.getFormatter().localizedBy(locale).format(localTime);
	}
	
	public static final <TimePattern extends TimePatternBase> String toString(LocalDateTime localTime, TimePattern timePattern) {
		return timePattern.getFormatter().format(localTime);
	}
	
	public static final <TimePattern extends TimePatternBase> String toString(LocalDateTime localTime, TimePattern timePattern, Locale locale) {
		return timePattern.getFormatter().localizedBy(locale).format(localTime);
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 */
	public static final String toString(LocalTime localTime, String timePattern) {
		return DateTimeFormatter.ofPattern(timePattern).format(localTime);
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 */
	public static final String toString(LocalTime localTime, String timePattern, Locale locale) {
		return DateTimeFormatter.ofPattern(timePattern).localizedBy(locale).format(localTime);
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 */
	public static final String toString(LocalDateTime localTime, String timePattern) {
		return DateTimeFormatter.ofPattern(timePattern).format(localTime);
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 */
	public static final String toString(LocalDateTime localTime, String timePattern, Locale locale) {
		return DateTimeFormatter.ofPattern(timePattern).localizedBy(locale).format(localTime);
	}
	
	// To LocalTime
	
	/**
	 * @throws DateTimeParseException - if the text cannot be parsed
	 */
	public static final <TimePattern extends TimePatternBase> LocalTime toLocalTime(String time, TimePattern timePattern) {
		return LocalTime.parse(time, timePattern.getFormatter());
	}
	
	/**
	 * @throws DateTimeParseException - if the text cannot be parsed
	 */
	public static final <TimePattern extends TimePatternBase> LocalTime toLocalTime(String time, TimePattern timePattern, Locale locale) {
		return LocalTime.parse(time, localizedFormatter(timePattern.getFormatter(), locale));
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 * @throws DateTimeParseException - if the text cannot be parsed
	 */
	public static final LocalTime toLocalTime(String time, String timePattern) {
		return LocalTime.parse(time, formatter(timePattern));
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 * @throws DateTimeParseException - if the text cannot be parsed
	 */
	public static final LocalTime toLocalTime(String time, String timePattern, Locale locale) {
		return LocalTime.parse(time, formatter(timePattern, locale));
	}
	
}
