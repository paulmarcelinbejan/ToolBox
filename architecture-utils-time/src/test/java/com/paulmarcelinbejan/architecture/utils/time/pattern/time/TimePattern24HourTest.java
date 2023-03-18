package com.paulmarcelinbejan.architecture.utils.time.pattern.time;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import org.junit.jupiter.api.Test;

class TimePattern24HourTest {

	@Test
	void validatePatternsWithLocalTime() {
		LocalTime time = LocalTime.of(20, 30, 10, 123456789);
		for(TimePattern.With24HourClockFormat tp : TimePattern.With24HourClockFormat.values()) {
			String timeString = tp.formatter.format(time);
			assertNotNull(timeString);
			System.out.println(timeString);
		}
	}
	
	@Test
	void validatePatternsWithLocalDateTime() {
		LocalDateTime dateTime = LocalDateTime.of(2016, Month.AUGUST, 12, 9, 38, 12, 123456789);
		for(TimePattern.With24HourClockFormat tp : TimePattern.With24HourClockFormat.values()) {
			String dateTimeString = tp.formatter.format(dateTime);
			assertNotNull(dateTimeString);
			System.out.println(dateTimeString);
		}
	}
	
}
