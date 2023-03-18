package com.paulmarcelinbejan.architecture.utils.time.format;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.paulmarcelinbejan.architecture.utils.time.pattern.DatePatternBase;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Format a LocalDate / LocalDateTime into string containing date information
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateFormatUtils {
	
	public static final <DatePattern extends DatePatternBase> String toString(LocalDate localDate, DatePattern datePattern) {
		return datePattern.getFormatter().format(localDate);
	}
	
	public static final <DatePattern extends DatePatternBase> String toString(LocalDate localDate, DatePattern datePattern, Locale locale) {
		return datePattern.getFormatter().localizedBy(locale).format(localDate);
	}
	
	public static final <DatePattern extends DatePatternBase> String toString(LocalDateTime localDate, DatePattern datePattern) {
		return datePattern.getFormatter().format(localDate);
	}
	
	public static final <DatePattern extends DatePatternBase> String toString(LocalDateTime localDate, DatePattern datePattern, Locale locale) {
		return datePattern.getFormatter().localizedBy(locale).format(localDate);
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 */
	public static final String toString(LocalDate localDate, String datePattern) {
		return DateTimeFormatter.ofPattern(datePattern).format(localDate);
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 */
	public static final String toString(LocalDate localDate, String datePattern, Locale locale) {
		return DateTimeFormatter.ofPattern(datePattern).localizedBy(locale).format(localDate);
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 */
	public static final String toString(LocalDateTime localDate, String datePattern) {
		return DateTimeFormatter.ofPattern(datePattern).format(localDate);
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 */
	public static final String toString(LocalDateTime localDate, String datePattern, Locale locale) {
		return DateTimeFormatter.ofPattern(datePattern).localizedBy(locale).format(localDate);
	}
	
}
