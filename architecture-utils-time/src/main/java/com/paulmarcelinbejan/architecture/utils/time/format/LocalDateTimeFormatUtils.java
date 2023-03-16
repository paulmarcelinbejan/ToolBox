package com.paulmarcelinbejan.architecture.utils.time.format;

import com.paulmarcelinbejan.architecture.utils.time.pattern.date.DatePattern;
import com.paulmarcelinbejan.architecture.utils.time.pattern.time.TimePattern;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocalDateTimeFormatUtils {

	public static final String buildPattern(DatePattern datePattern, TimePattern timePattern) {
		return datePattern + " " + timePattern.value;
	}
	
}
