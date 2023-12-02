package io.github.paulmarcelinbejan.architecture.utils.time.pattern.time;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import org.junit.jupiter.api.Test;

import io.github.paulmarcelinbejan.toolbox.utils.time.pattern.time.TimePattern;

class TimePattern12HourTest {

	@Test
	void validatePatternsUsingLocalTime() {
		LocalTime time = LocalTime.of(20, 30, 10, 123456789);
		for(TimePattern.With12HourClockFormat tp : TimePattern.With12HourClockFormat.values()) {
			String timeString = tp.formatter.format(time);
			assertNotNull(timeString);
			System.out.println(timeString);
		}
	}
	
	@Test
	void validatePatternsUsingLocalDateTime() {
		LocalDateTime dateTime = LocalDateTime.of(2016, Month.AUGUST, 12, 9, 38, 12, 123456789);
		for(TimePattern.With12HourClockFormat tp : TimePattern.With12HourClockFormat.values()) {
			String dateTimeString = tp.formatter.format(dateTime);
			assertNotNull(dateTimeString);
			System.out.println(dateTimeString);
		}
	}
	
}
