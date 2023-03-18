package com.paulmarcelinbejan.architecture.utils.time.format;

import static com.paulmarcelinbejan.architecture.utils.time.format.common.FormatUtils.formatter;
import static com.paulmarcelinbejan.architecture.utils.time.format.common.FormatUtils.localizedFormatter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

import com.paulmarcelinbejan.architecture.utils.time.pattern.DatePatternBase;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Format a LocalDate / LocalDateTime into string containing date information.
 * Format a String into LocalDate / LocalDateTime.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateFormatUtils {
	
	// To String
	
	public static final <DatePattern extends DatePatternBase> String toString(LocalDate localDate, DatePattern datePattern) {
		return datePattern.getFormatter().format(localDate);
	}
	
	public static final <DatePattern extends DatePatternBase> String toString(LocalDate localDate, DatePattern datePattern, Locale locale) {
		return localizedFormatter(datePattern.getFormatter(), locale).format(localDate);
	}
	
	public static final <DatePattern extends DatePatternBase> String toString(LocalDateTime localDate, DatePattern datePattern) {
		return datePattern.getFormatter().format(localDate);
	}
	
	public static final <DatePattern extends DatePatternBase> String toString(LocalDateTime localDate, DatePattern datePattern, Locale locale) {
		return localizedFormatter(datePattern.getFormatter(), locale).format(localDate);
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 */
	public static final String toString(LocalDate localDate, String datePattern) {
		return formatter(datePattern).format(localDate);
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 */
	public static final String toString(LocalDate localDate, String datePattern, Locale locale) {
		return formatter(datePattern, locale).format(localDate);
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 */
	public static final String toString(LocalDateTime localDate, String datePattern) {
		return formatter(datePattern).format(localDate);
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 */
	public static final String toString(LocalDateTime localDate, String datePattern, Locale locale) {
		return formatter(datePattern, locale).format(localDate);
	}
	
	// To LocalDate
	
	/**
	 * @throws DateTimeParseException - if the text cannot be parsed
	 */
	public static final <DatePattern extends DatePatternBase> LocalDate toLocalDate(String date, DatePattern datePattern) {
		return LocalDate.parse(date, datePattern.getFormatter());
	}
	
	/**
	 * @throws DateTimeParseException - if the text cannot be parsed
	 */
	public static final <DatePattern extends DatePatternBase> LocalDate toLocalDate(String date, DatePattern datePattern, Locale locale) {
		return LocalDate.parse(date, localizedFormatter(datePattern.getFormatter(), locale));
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 * @throws DateTimeParseException - if the text cannot be parsed
	 */
	public static final LocalDate toLocalDate(String date, String datePattern) {
		return LocalDate.parse(date, formatter(datePattern));
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 * @throws DateTimeParseException - if the text cannot be parsed
	 */
	public static final LocalDate toLocalDate(String date, String datePattern, Locale locale) {
		return LocalDate.parse(date, formatter(datePattern, locale));
	}
	
	// To LocalDateTime
	
	/**
	 * @throws DateTimeParseException - if the text cannot be parsed
	 */
	public static final <DatePattern extends DatePatternBase> LocalDateTime toLocalDateTime(String date, DatePattern datePattern) {
		return LocalDateTime.parse(date, datePattern.getFormatter());
	}
	
	/**
	 * @throws DateTimeParseException - if the text cannot be parsed
	 */
	public static final <DatePattern extends DatePatternBase> LocalDateTime toLocalDateTime(String date, DatePattern datePattern, Locale locale) {
		return LocalDateTime.parse(date, localizedFormatter(datePattern.getFormatter(), locale));
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 * @throws DateTimeParseException - if the text cannot be parsed
	 */
	public static final LocalDateTime toLocalDateTime(String date, String datePattern) {
		return LocalDateTime.parse(date, formatter(datePattern));
	}
	
	/**
	 * @throws IllegalArgumentException if the pattern is invalid
	 * @throws DateTimeParseException - if the text cannot be parsed
	 */
	public static final LocalDateTime toLocalDateTime(String date, String datePattern, Locale locale) {
		return LocalDateTime.parse(date, formatter(datePattern, locale));
	}
	
}
