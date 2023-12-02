package io.github.paulmarcelinbejan.architecture.utils.time.pattern.date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;

import io.github.paulmarcelinbejan.toolbox.utils.time.pattern.date.DatePattern;

class DatePatternLiteralTest {
	
	@Test
	void validateDatePatternDotSeparator() {
		LocalDate date = LocalDate.of(2023, Month.APRIL, 6);
		for(DatePattern.Literal.WithDotSeparator datePattern : DatePattern.Literal.WithDotSeparator.values()) {
			String dateString = datePattern.formatter.format(date);
			assertNotNull(dateString);
//			System.out.println(dateString);
		}
	}
	
	@Test
	void validateDatePatternHyphenSeparator() {
		LocalDate date = LocalDate.of(2023, Month.APRIL, 6);
		for(DatePattern.Literal.WithHyphenSeparator datePattern : DatePattern.Literal.WithHyphenSeparator.values()) {
			String dateString = datePattern.formatter.format(date);
			assertNotNull(dateString);
//			System.out.println(dateString);
		}
	}
	
	@Test
	void validateDatePatternSlashSeparator() {
		LocalDate date = LocalDate.of(2023, Month.APRIL, 6);
		for(DatePattern.Literal.WithSlashSeparator datePattern : DatePattern.Literal.WithSlashSeparator.values()) {
			String dateString = datePattern.formatter.format(date);
			assertNotNull(dateString);
//			System.out.println(dateString);
		}
	}
	
	@Test
	void validateDatePatternSpaceSeparator() {
		LocalDate date = LocalDate.of(2023, Month.APRIL, 6);
		for(DatePattern.Literal.WithSpaceSeparator datePattern : DatePattern.Literal.WithSpaceSeparator.values()) {
			String dateString = datePattern.formatter.format(date);
			assertNotNull(dateString);
//			System.out.println(dateString);
		}
	}
	
}
