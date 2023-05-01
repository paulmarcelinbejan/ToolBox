package com.paulmarcelinbejan.toolbox.utils.time.format.common;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FormatUtils {

	public static final DateTimeFormatter formatter(String pattern) {
		return DateTimeFormatter.ofPattern(pattern);
	}
	
	public static final DateTimeFormatter formatter(String pattern, Locale locale) {
		return formatter(pattern).localizedBy(locale);
	}
	
	public static final DateTimeFormatter localizedFormatter(DateTimeFormatter formatter, Locale locale) {
		return formatter.localizedBy(locale);
	}
	
}
