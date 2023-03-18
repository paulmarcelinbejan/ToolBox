package com.paulmarcelinbejan.architecture.utils.time.format;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.paulmarcelinbejan.architecture.utils.time.pattern.TimePatternBase;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Format a LocalTime / LocalDateTime into string containing time information
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
	
}
