package com.paulmarcelinbejan.architecture.utils.time.pattern.date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;

class DatePatternLiteralTest {
	
	@Test
	void validateDatePatternDotSeparator() {
		LocalDate date = LocalDate.of(2023, Month.APRIL, 6);
		for(DatePattern.Literal.WithDotSeparator dp : DatePattern.Literal.WithDotSeparator.values()) {
			String timeString = dp.formatter.format(date);
			assertNotNull(timeString);
			System.out.println(timeString);
		}
	}
	
	@Test
	void validateDatePatternHyphenSeparator() {
		LocalDate date = LocalDate.of(2023, Month.APRIL, 6);
		for(DatePattern.Literal.WithHyphenSeparator dp : DatePattern.Literal.WithHyphenSeparator.values()) {
			String timeString = dp.formatter.format(date);
			assertNotNull(timeString);
			System.out.println(timeString);
		}
	}
	
	@Test
	void validateDatePatternSlashSeparator() {
		LocalDate date = LocalDate.of(2023, Month.APRIL, 6);
		for(DatePattern.Literal.WithSlashSeparator dp : DatePattern.Literal.WithSlashSeparator.values()) {
			String timeString = dp.formatter.format(date);
			assertNotNull(timeString);
			System.out.println(timeString);
		}
	}
	
	@Test
	void validateDatePatternSpaceSeparator() {
		LocalDate date = LocalDate.of(2023, Month.APRIL, 6);
		for(DatePattern.Literal.WithSpaceSeparator dp : DatePattern.Literal.WithSpaceSeparator.values()) {
			String timeString = dp.formatter.format(date);
			assertNotNull(timeString);
			System.out.println(timeString);
		}
	}
	
}
