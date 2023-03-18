package com.paulmarcelinbejan.architecture.utils.time.pattern.date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;

class DatePatternNumericTest {

	@Test
	void validateDatePatternDotSeparator() {
		LocalDate date = LocalDate.of(2023, Month.APRIL, 6);
		for(DatePattern.Numeric.WithDotSeparator dp : DatePattern.Numeric.WithDotSeparator.values()) {
			String timeString = dp.formatter.format(date);
			assertNotNull(timeString);
			System.out.println(timeString);
		}
	}
	
	@Test
	void validateDatePatternHyphenSeparator() {
		LocalDate date = LocalDate.of(2023, Month.APRIL, 6);
		for(DatePattern.Numeric.WithHyphenSeparator dp : DatePattern.Numeric.WithHyphenSeparator.values()) {
			String timeString = dp.formatter.format(date);
			assertNotNull(timeString);
			System.out.println(timeString);
		}
	}
	
	@Test
	void validateDatePatternSlashSeparator() {
		LocalDate date = LocalDate.of(2023, Month.APRIL, 6);
		for(DatePattern.Numeric.WithSlashSeparator dp : DatePattern.Numeric.WithSlashSeparator.values()) {
			String timeString = dp.formatter.format(date);
			assertNotNull(timeString);
			System.out.println(timeString);
		}
	}
	
	@Test
	void validateDatePatternSpaceSeparator() {
		LocalDate date = LocalDate.of(2023, Month.APRIL, 6);
		for(DatePattern.Numeric.WithSpaceSeparator dp : DatePattern.Numeric.WithSpaceSeparator.values()) {
			String timeString = dp.formatter.format(date);
			assertNotNull(timeString);
			System.out.println(timeString);
		}
	}
	
}
