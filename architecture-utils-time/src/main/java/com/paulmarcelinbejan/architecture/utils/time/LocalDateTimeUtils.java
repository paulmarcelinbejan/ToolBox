package com.paulmarcelinbejan.architecture.utils.time;

import static java.time.temporal.ChronoUnit.MICROS;
import static java.time.temporal.ChronoUnit.MILLIS;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocalDateTimeUtils {

	// NANO SECOND
	
	public static LocalDateTime addNanos(final LocalDateTime localDateTime, final int nanosToAdd) {
		return localDateTime.plusNanos(nanosToAdd);
	}
	
	public static LocalDateTime subtractNanos(final LocalDateTime localDateTime, final int nanosToSubtract) {
		return localDateTime.minusNanos(nanosToSubtract);
	}
	
	// MICRO SECOND
	
	public static LocalDateTime addMicros(final LocalDateTime localDateTime, final int microsToAdd) {
		return localDateTime.plus(microsToAdd, MICROS);
	}
	
	public static LocalDateTime subtractMicros(final LocalDateTime localDateTime, final int microsToSubtract) {
		return localDateTime.minus(microsToSubtract, MICROS);
	}
	
	// MILLI SECOND
	
	public static LocalDateTime addMillis(final LocalDateTime localDateTime, final int millisToAdd) {
		return localDateTime.plus(millisToAdd, MILLIS);
	}
	
	public static LocalDateTime subtractMillis(final LocalDateTime localDateTime, final int millisToSubtract) {
		return localDateTime.minus(millisToSubtract, MILLIS);
	}
	
	// SECOND
	
	public static LocalDateTime addSeconds(final LocalDateTime localDateTime, final int secondsToAdd) {
		return localDateTime.plusSeconds(secondsToAdd);
	}
	
	public static LocalDateTime subtractSeconds(final LocalDateTime localDateTime, final int secondsToSubtract) {
		return localDateTime.minusSeconds(secondsToSubtract);
	}
	
	// MINUTE
	
	public static LocalDateTime addMinutes(final LocalDateTime localDateTime, final int minutesToAdd) {
		return localDateTime.plusMinutes(minutesToAdd);
	}
	
	public static LocalDateTime subtractmMinutes(final LocalDateTime localDateTime, final int minutesToSubtract) {
		return localDateTime.minusMinutes(minutesToSubtract);
	}
	
	// HOUR
	
	public static LocalDateTime addHours(final LocalDateTime localDateTime, final int hoursToAdd) {
		return localDateTime.plusHours(hoursToAdd);
	}
	
	public static LocalDateTime subtractHours(final LocalDateTime localDateTime, final int hoursToSubtract) {
		return localDateTime.minusHours(hoursToSubtract);
	}
	
	// DAY
	
	public static LocalDateTime addDays(final LocalDateTime localDateTime, final int daysToAdd) {
		return localDateTime.plusDays(daysToAdd);
	}
	
	public static LocalDateTime subtractDays(final LocalDateTime localDateTime, final int daysToSubtract) {
		return localDateTime.minusDays(daysToSubtract);
	}
	
	// WEEK
	
	public static LocalDateTime addWeeks(final LocalDateTime localDateTime, final int weeksToAdd) {
		return localDateTime.plusWeeks(weeksToAdd);
	}
	
	public static LocalDateTime subtractWeeks(final LocalDateTime localDateTime, final int weeksToSubtract) {
		return localDateTime.minusWeeks(weeksToSubtract);
	}
	
	// MONTH
	
	public static LocalDateTime addMonths(final LocalDateTime localDateTime, final int monthsToAdd) {
		return localDateTime.plusMonths(monthsToAdd);
	}
	
	public static LocalDateTime subtractMonths(final LocalDateTime localDateTime, final int monthsToSubtract) {
		return localDateTime.minusMonths(monthsToSubtract);
	}
	
	public static LocalDateTime firstDayOfMonth(final LocalDateTime localDateTime) {
		return localDateTime.with(TemporalAdjusters.firstDayOfMonth());
	}
	
	public static LocalDateTime lastDayOfMonth(final LocalDateTime localDateTime) {
		return localDateTime.with(TemporalAdjusters.lastDayOfMonth());
	}
	
	public static LocalDateTime firstDayOfNextMonth(final LocalDateTime localDateTime) {
		return localDateTime.plusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
	}
	
	public static LocalDateTime lastDayOfNextMonth(final LocalDateTime localDateTime) {
		return localDateTime.plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
	}
	
	public static LocalDateTime firstDayOfPreviousMonth(final LocalDateTime localDateTime) {
		return localDateTime.minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
	}
	
	public static LocalDateTime lastDayOfPreviousMonth(final LocalDateTime localDateTime) {
		return localDateTime.minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
	}
	
	// YEAR
	
	public static LocalDateTime addYears(final LocalDateTime localDateTime, final int yearsToAdd) {
		return localDateTime.plusYears(yearsToAdd);
	}
	
	public static LocalDateTime subtractYears(final LocalDateTime localDateTime, final int yearsToSubtract) {
		return localDateTime.minusYears(yearsToSubtract);
	}
	
	public static LocalDateTime firstDayOfYear(final LocalDateTime localDateTime) {
		return localDateTime.with(TemporalAdjusters.firstDayOfYear());
	}
	
	public static LocalDateTime lastDayOfYear(final LocalDateTime localDateTime) {
		return localDateTime.with(TemporalAdjusters.lastDayOfYear());
	}
	
	public static LocalDateTime firstDayOfNextYear(final LocalDateTime localDateTime) {
		return localDateTime.plusYears(1).with(TemporalAdjusters.firstDayOfYear());
	}
	
	public static LocalDateTime lastDayOfNextYear(final LocalDateTime localDateTime) {
		return localDateTime.plusYears(1).with(TemporalAdjusters.lastDayOfYear());
	}
	
	public static LocalDateTime firstDayOfPreviousYear(final LocalDateTime localDateTime) {
		return localDateTime.minusYears(1).with(TemporalAdjusters.firstDayOfYear());
	}
	
	public static LocalDateTime lastDayOfPreviousYear(final LocalDateTime localDateTime) {
		return localDateTime.minusYears(1).with(TemporalAdjusters.lastDayOfYear());
	}
	
	// COMPARE
	
	public static boolean isEquals(final LocalDateTime localDateTimeLeft, final LocalDateTime localDateTimeRight) {
		return localDateTimeLeft.equals(localDateTimeRight);
	}
	
	public static boolean isNotEquals(final LocalDateTime localDateTimeLeft, final LocalDateTime localDateTimeRight) {
		return !localDateTimeLeft.equals(localDateTimeRight);
	}
	
	public static boolean isBefore(final LocalDateTime localDateTimeLeft, final LocalDateTime localDateTimeRight) {
		return localDateTimeLeft.isBefore(localDateTimeRight);
	}
	
	public static boolean isAfter(final LocalDateTime localDateTimeLeft, final LocalDateTime localDateTimeRight) {
		return localDateTimeLeft.isAfter(localDateTimeRight);
	}
	
	public static boolean isBeforeOrEquals(final LocalDateTime localDateTimeLeft, final LocalDateTime localDateTimeRight) {
		return localDateTimeLeft.compareTo(localDateTimeRight) <= 0;
	}
	
	public static boolean isAfterOrEquals(final LocalDateTime localDateTimeLeft, final LocalDateTime localDateTimeRight) {
		return localDateTimeLeft.compareTo(localDateTimeRight) >= 0;
	}
	
}