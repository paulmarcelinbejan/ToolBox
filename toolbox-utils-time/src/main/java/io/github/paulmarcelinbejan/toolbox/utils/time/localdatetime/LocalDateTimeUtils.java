package io.github.paulmarcelinbejan.toolbox.utils.time.localdatetime;

import static java.time.Month.APRIL;
import static java.time.Month.AUGUST;
import static java.time.Month.DECEMBER;
import static java.time.Month.FEBRUARY;
import static java.time.Month.JANUARY;
import static java.time.Month.JULY;
import static java.time.Month.JUNE;
import static java.time.Month.MARCH;
import static java.time.Month.MAY;
import static java.time.Month.NOVEMBER;
import static java.time.Month.OCTOBER;
import static java.time.Month.SEPTEMBER;
import static java.time.temporal.ChronoUnit.MICROS;
import static java.time.temporal.ChronoUnit.MILLIS;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Be aware that LocalDateTime is time-zone agnostic!
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocalDateTimeUtils {

	// NANO SECOND
	
	public static LocalDateTime addNanos(LocalDateTime localDateTime, int nanosToAdd) {
		return localDateTime.plusNanos(nanosToAdd);
	}
	
	public static LocalDateTime subtractNanos(LocalDateTime localDateTime, int nanosToSubtract) {
		return localDateTime.minusNanos(nanosToSubtract);
	}
	
	// MICRO SECOND
	
	public static LocalDateTime addMicros(LocalDateTime localDateTime, int microsToAdd) {
		return localDateTime.plus(microsToAdd, MICROS);
	}
	
	public static LocalDateTime subtractMicros(LocalDateTime localDateTime, int microsToSubtract) {
		return localDateTime.minus(microsToSubtract, MICROS);
	}
	
	// MILLI SECOND
	
	public static LocalDateTime addMillis(LocalDateTime localDateTime, int millisToAdd) {
		return localDateTime.plus(millisToAdd, MILLIS);
	}
	
	public static LocalDateTime subtractMillis(LocalDateTime localDateTime, int millisToSubtract) {
		return localDateTime.minus(millisToSubtract, MILLIS);
	}
	
	// SECOND
	
	public static LocalDateTime addSeconds(LocalDateTime localDateTime, int secondsToAdd) {
		return localDateTime.plusSeconds(secondsToAdd);
	}
	
	public static LocalDateTime subtractSeconds(LocalDateTime localDateTime, int secondsToSubtract) {
		return localDateTime.minusSeconds(secondsToSubtract);
	}
	
	// MINUTE
	
	public static LocalDateTime addMinutes(LocalDateTime localDateTime, int minutesToAdd) {
		return localDateTime.plusMinutes(minutesToAdd);
	}
	
	public static LocalDateTime subtractmMinutes(LocalDateTime localDateTime, int minutesToSubtract) {
		return localDateTime.minusMinutes(minutesToSubtract);
	}
	
	// HOUR
	
	public static LocalDateTime addHours(LocalDateTime localDateTime, int hoursToAdd) {
		return localDateTime.plusHours(hoursToAdd);
	}
	
	public static LocalDateTime subtractHours(LocalDateTime localDateTime, int hoursToSubtract) {
		return localDateTime.minusHours(hoursToSubtract);
	}
	
	// DAY
	
	public static LocalDateTime addDays(LocalDateTime localDateTime, int daysToAdd) {
		return localDateTime.plusDays(daysToAdd);
	}
	
	public static LocalDateTime subtractDays(LocalDateTime localDateTime, int daysToSubtract) {
		return localDateTime.minusDays(daysToSubtract);
	}
	
	// WEEK
	
	public static LocalDateTime addWeeks(LocalDateTime localDateTime, int weeksToAdd) {
		return localDateTime.plusWeeks(weeksToAdd);
	}
	
	public static LocalDateTime subtractWeeks(LocalDateTime localDateTime, int weeksToSubtract) {
		return localDateTime.minusWeeks(weeksToSubtract);
	}
	
	// MONTH
	
	public static LocalDateTime addMonths(LocalDateTime localDateTime, int monthsToAdd) {
		return localDateTime.plusMonths(monthsToAdd);
	}
	
	public static LocalDateTime subtractMonths(LocalDateTime localDateTime, int monthsToSubtract) {
		return localDateTime.minusMonths(monthsToSubtract);
	}
	
	public static LocalDateTime firstDayOfMonth(LocalDateTime localDateTime) {
		return localDateTime.with(TemporalAdjusters.firstDayOfMonth());
	}
	
	public static LocalDateTime lastDayOfMonth(LocalDateTime localDateTime) {
		return localDateTime.with(TemporalAdjusters.lastDayOfMonth());
	}
	
	public static LocalDateTime firstDayOfNextMonth(LocalDateTime localDateTime) {
		return localDateTime.plusMonths(1)
							.with(TemporalAdjusters.firstDayOfMonth());
	}
	
	public static LocalDateTime lastDayOfNextMonth(LocalDateTime localDateTime) {
		return localDateTime.plusMonths(1)
							.with(TemporalAdjusters.lastDayOfMonth());
	}
	
	public static LocalDateTime firstDayOfPreviousMonth(LocalDateTime localDateTime) {
		return localDateTime.minusMonths(1)
							.with(TemporalAdjusters.firstDayOfMonth());
	}
	
	public static LocalDateTime lastDayOfPreviousMonth(LocalDateTime localDateTime) {
		return localDateTime.minusMonths(1)
							.with(TemporalAdjusters.lastDayOfMonth());
	}
	
	// YEAR
	
	public static LocalDateTime addYears(LocalDateTime localDateTime, int yearsToAdd) {
		return localDateTime.plusYears(yearsToAdd);
	}
	
	public static LocalDateTime subtractYears(LocalDateTime localDateTime, int yearsToSubtract) {
		return localDateTime.minusYears(yearsToSubtract);
	}
	
	public static LocalDateTime firstDayOfYear(LocalDateTime localDateTime) {
		return localDateTime.with(TemporalAdjusters.firstDayOfYear());
	}
	
	public static LocalDateTime lastDayOfYear(LocalDateTime localDateTime) {
		return localDateTime.with(TemporalAdjusters.lastDayOfYear());
	}
	
	public static LocalDateTime firstDayOfNextYear(LocalDateTime localDateTime) {
		return localDateTime.plusYears(1)
							.with(TemporalAdjusters.firstDayOfYear());
	}
	
	public static LocalDateTime lastDayOfNextYear(LocalDateTime localDateTime) {
		return localDateTime.plusYears(1)
							.with(TemporalAdjusters.lastDayOfYear());
	}
	
	public static LocalDateTime firstDayOfPreviousYear(LocalDateTime localDateTime) {
		return localDateTime.minusYears(1)
							.with(TemporalAdjusters.firstDayOfYear());
	}
	
	public static LocalDateTime lastDayOfPreviousYear(LocalDateTime localDateTime) {
		return localDateTime.minusYears(1)
							.with(TemporalAdjusters.lastDayOfYear());
	}
	
	// COMPARE
	
	public static boolean isEquals(LocalDateTime localDateTimeLeft, LocalDateTime localDateTimeRight) {
		return localDateTimeLeft.equals(localDateTimeRight);
	}
	
	public static boolean isNotEquals(LocalDateTime localDateTimeLeft, LocalDateTime localDateTimeRight) {
		return !localDateTimeLeft.equals(localDateTimeRight);
	}
	
	public static boolean isBefore(LocalDateTime localDateTimeLeft, LocalDateTime localDateTimeRight) {
		return localDateTimeLeft.isBefore(localDateTimeRight);
	}
	
	public static boolean isAfter(LocalDateTime localDateTimeLeft, LocalDateTime localDateTimeRight) {
		return localDateTimeLeft.isAfter(localDateTimeRight);
	}
	
	public static boolean isBeforeOrEquals(LocalDateTime localDateTimeLeft, LocalDateTime localDateTimeRight) {
		return localDateTimeLeft.compareTo(localDateTimeRight) <= 0;
	}
	
	public static boolean isAfterOrEquals(LocalDateTime localDateTimeLeft, LocalDateTime localDateTimeRight) {
		return localDateTimeLeft.compareTo(localDateTimeRight) >= 0;
	}
	
	public static boolean isBetweenInclusive(LocalDateTime left, LocalDateTime between, LocalDateTime right) {
		return isBeforeOrEquals(left, between) && isBeforeOrEquals(between, right);
	}
	
	public static boolean isBetweenExclusive(LocalDateTime left, LocalDateTime between, LocalDateTime right) {
		return isBefore(left, between) && isBefore(between, right);
	}
	
	// IS SPECIFIC DATE
	
	public static boolean isFirstDayOfMonth(LocalDateTime localDateTime) {
		return localDateTime.getDayOfMonth() == 1;
	}
	
	public static boolean isLastDayOfMonth(LocalDateTime localDateTime) {
		return localDateTime.getDayOfMonth() == lastDayOfMonth(localDateTime).getDayOfMonth();
	}
	
	public static boolean isFirstDayOfTheYear(LocalDateTime localDateTime) {
		return isJanuary(localDateTime) && isFirstDayOfMonth(localDateTime);
	}
	
	public static boolean isLastDayOfTheYear(LocalDateTime localDateTime) {
		return isDecember(localDateTime) && localDateTime.getDayOfMonth() == 31;
	}
	
	public static boolean isJanuary(LocalDateTime localDateTime) {
		return JANUARY == localDateTime.getMonth();
	}
	
	public static boolean isFebruary(LocalDateTime localDateTime) {
		return FEBRUARY == localDateTime.getMonth();
	}
	
	public static boolean isMarch(LocalDateTime localDateTime) {
		return MARCH == localDateTime.getMonth();
	}
	
	public static boolean isApril(LocalDateTime localDateTime) {
		return APRIL == localDateTime.getMonth();
	}
	
	public static boolean isMay(LocalDateTime localDateTime) {
		return MAY == localDateTime.getMonth();
	}
	
	public static boolean isJune(LocalDateTime localDateTime) {
		return JUNE == localDateTime.getMonth();
	}
	
	public static boolean isJuly(LocalDateTime localDateTime) {
		return JULY == localDateTime.getMonth();
	}
	
	public static boolean isAugust(LocalDateTime localDateTime) {
		return AUGUST == localDateTime.getMonth();
	}
	
	public static boolean isSeptember(LocalDateTime localDateTime) {
		return SEPTEMBER == localDateTime.getMonth();
	}
	
	public static boolean isOctober(LocalDateTime localDateTime) {
		return OCTOBER == localDateTime.getMonth();
	}
	
	public static boolean isNovember(LocalDateTime localDateTime) {
		return NOVEMBER == localDateTime.getMonth();
	}
	
	public static boolean isDecember(LocalDateTime localDateTime) {
		return DECEMBER == localDateTime.getMonth();
	}
	
	// SET SPECIFIC DATE
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalDateTime buildLocalDateTime(LocalDate date, LocalTime time) {
		return LocalDateTime.of(date, time);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalDateTime buildLocalDateTime(int year, int month, int day, int hour, int minute) {
		return LocalDateTime.of(year, month, day, hour, minute);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalDateTime buildLocalDateTime(int year, int month, int day, int hour, int minute, int second) {
		return LocalDateTime.of(year, month, day, hour, minute, second);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalDateTime changeDay(LocalDateTime localDateTime, int day) {
		return localDateTime.withDayOfMonth(day);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalDateTime changeMonthAndDay(LocalDateTime localDateTime, int month, int day) {
		return localDateTime.withMonth(month)
							.withDayOfMonth(day);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalDateTime changeSecond(LocalDateTime localDateTime, int second) {
		return localDateTime.withSecond(second);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalDateTime changeMinute(LocalDateTime localDateTime, int minute) {
		return localDateTime.withMinute(minute);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalDateTime changeHour(LocalDateTime localDateTime, int hour) {
		return localDateTime.withHour(hour);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalDateTime changeHourMinuteSecond(LocalDateTime localDateTime, int hour, int minute, int second) {
		return localDateTime.withHour(hour)
							.withMinute(minute)
							.withSecond(second);
	}
	
}