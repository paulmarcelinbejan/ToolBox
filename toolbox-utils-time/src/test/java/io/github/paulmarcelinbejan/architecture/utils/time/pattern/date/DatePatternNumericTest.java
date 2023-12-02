package io.github.paulmarcelinbejan.architecture.utils.time.pattern.date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;

import io.github.paulmarcelinbejan.toolbox.utils.time.pattern.date.DatePattern;

class DatePatternNumericTest {

	@Test
	void validateDatePatternDotSeparator() {
		LocalDate date = LocalDate.of(2023, Month.APRIL, 6);
		for(DatePattern.Numeric.WithDotSeparator datePattern : DatePattern.Numeric.WithDotSeparator.values()) {
			String dateString = datePattern.formatter.format(date);
			assertNotNull(dateString);
//			System.out.println(dateString);
		}
	}
	
	@Test
	void validateDatePatternHyphenSeparator() {
		LocalDate date = LocalDate.of(2023, Month.APRIL, 6);
		for(DatePattern.Numeric.WithHyphenSeparator datePattern : DatePattern.Numeric.WithHyphenSeparator.values()) {
			String dateString = datePattern.formatter.format(date);
			assertNotNull(dateString);
//			System.out.println(dateString);
		}
	}
	
	@Test
	void validateDatePatternSlashSeparator() {
		LocalDate date = LocalDate.of(2023, Month.APRIL, 6);
		for(DatePattern.Numeric.WithSlashSeparator datePattern : DatePattern.Numeric.WithSlashSeparator.values()) {
			String dateString = datePattern.formatter.format(date);
			assertNotNull(dateString);
//			System.out.println(dateString);
		}
	}
	
	@Test
	void validateDatePatternSpaceSeparator() {
		LocalDate date = LocalDate.of(2023, Month.APRIL, 6);
		for(DatePattern.Numeric.WithSpaceSeparator datePattern : DatePattern.Numeric.WithSpaceSeparator.values()) {
			String dateString = datePattern.formatter.format(date);
			assertNotNull(dateString);
//			System.out.println(dateString);
		}
	}
	
}
