package com.paulmarcelinbejan.architecture.utils.time.format;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.paulmarcelinbejan.architecture.utils.time.pattern.DatePatternBase;
import com.paulmarcelinbejan.architecture.utils.time.pattern.TimePatternBase;
import com.paulmarcelinbejan.architecture.utils.time.pattern.datetime.DateTimePattern;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Format a LocalDateTime into string containing date and time information
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
		return DateTimeFormatter.ofPattern(buildPattern(datePattern, timePattern)).format(localDateTime);
	}
	
	public static final <DatePattern extends DatePatternBase, TimePattern extends TimePatternBase> String toString(LocalDateTime localDateTime, DatePattern datePattern, TimePattern timePattern, Locale locale) {
		return DateTimeFormatter.ofPattern(buildPattern(datePattern, timePattern)).localizedBy(locale).format(localDateTime);
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 */
	public static final String toString(LocalDateTime localDateTime, DateTimePattern pattern) {
		return pattern.formatter.format(localDateTime);
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 */
	public static final String toString(LocalDateTime localDateTime, DateTimePattern pattern, Locale locale) {
		return pattern.formatter.localizedBy(locale).format(localDateTime);
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 */
	public static final String toString(LocalDateTime localDateTime, String pattern) {
		return DateTimeFormatter.ofPattern(pattern).format(localDateTime);
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 */
	public static final String toString(LocalDateTime localDateTime, String pattern, Locale locale) {
		return DateTimeFormatter.ofPattern(pattern).localizedBy(locale).format(localDateTime);
	}
	
}
