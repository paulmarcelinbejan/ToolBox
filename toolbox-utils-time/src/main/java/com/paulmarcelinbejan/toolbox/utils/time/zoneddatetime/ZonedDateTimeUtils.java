package com.paulmarcelinbejan.toolbox.utils.time.zoneddatetime;

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
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;

import com.paulmarcelinbejan.toolbox.utils.time.localdate.LocalDateUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ZonedDateTimeUtils {

	// NANO SECOND
	
	public static ZonedDateTime addNanos(ZonedDateTime zonedDateTime, int nanosToAdd) {
		return zonedDateTime.plusNanos(nanosToAdd);
	}
	
	public static ZonedDateTime subtractNanos(ZonedDateTime zonedDateTime, int nanosToSubtract) {
		return zonedDateTime.minusNanos(nanosToSubtract);
	}
	
	// MICRO SECOND
	
	public static ZonedDateTime addMicros(ZonedDateTime zonedDateTime, int microsToAdd) {
		return zonedDateTime.plus(microsToAdd, MICROS);
	}
	
	public static ZonedDateTime subtractMicros(ZonedDateTime zonedDateTime, int microsToSubtract) {
		return zonedDateTime.minus(microsToSubtract, MICROS);
	}
	
	// MILLI SECOND
	
	public static ZonedDateTime addMillis(ZonedDateTime zonedDateTime, int millisToAdd) {
		return zonedDateTime.plus(millisToAdd, MILLIS);
	}
	
	public static ZonedDateTime subtractMillis(ZonedDateTime zonedDateTime, int millisToSubtract) {
		return zonedDateTime.minus(millisToSubtract, MILLIS);
	}
	
	// SECOND
	
	public static ZonedDateTime addSeconds(ZonedDateTime zonedDateTime, int secondsToAdd) {
		return zonedDateTime.plusSeconds(secondsToAdd);
	}
	
	public static ZonedDateTime subtractSeconds(ZonedDateTime zonedDateTime, int secondsToSubtract) {
		return zonedDateTime.minusSeconds(secondsToSubtract);
	}
	
	// MINUTE
	
	public static ZonedDateTime addMinutes(ZonedDateTime zonedDateTime, int minutesToAdd) {
		return zonedDateTime.plusMinutes(minutesToAdd);
	}
	
	public static ZonedDateTime subtractmMinutes(ZonedDateTime zonedDateTime, int minutesToSubtract) {
		return zonedDateTime.minusMinutes(minutesToSubtract);
	}
	
	// HOUR
	
	public static ZonedDateTime addHours(ZonedDateTime zonedDateTime, int hoursToAdd) {
		return zonedDateTime.plusHours(hoursToAdd);
	}
	
	public static ZonedDateTime subtractHours(ZonedDateTime zonedDateTime, int hoursToSubtract) {
		return zonedDateTime.minusHours(hoursToSubtract);
	}
	
	// DAY
	
	public static ZonedDateTime addDays(ZonedDateTime zonedDateTime, int daysToAdd) {
		return zonedDateTime.plusDays(daysToAdd);
	}
	
	public static ZonedDateTime subtractDays(ZonedDateTime zonedDateTime, int daysToSubtract) {
		return zonedDateTime.minusDays(daysToSubtract);
	}
	
	// WEEK
	
	public static ZonedDateTime addWeeks(ZonedDateTime zonedDateTime, int weeksToAdd) {
		return zonedDateTime.plusWeeks(weeksToAdd);
	}
	
	public static ZonedDateTime subtractWeeks(ZonedDateTime zonedDateTime, int weeksToSubtract) {
		return zonedDateTime.minusWeeks(weeksToSubtract);
	}
	
	// MONTH
	
	public static ZonedDateTime addMonths(ZonedDateTime zonedDateTime, int monthsToAdd) {
		return zonedDateTime.plusMonths(monthsToAdd);
	}
	
	public static ZonedDateTime subtractMonths(ZonedDateTime zonedDateTime, int monthsToSubtract) {
		return zonedDateTime.minusMonths(monthsToSubtract);
	}
	
	public static ZonedDateTime firstDayOfMonth(ZonedDateTime zonedDateTime) {
		return zonedDateTime.with(TemporalAdjusters.firstDayOfMonth());
	}

	public static ZonedDateTime firstDayOfMonthAtStartOfDay(ZonedDateTime zonedDateTime) {
		return zonedDateTime.with(TemporalAdjusters.firstDayOfMonth())
							.toLocalDate()
							.atStartOfDay(zonedDateTime.getZone());
	}
	
	public static ZonedDateTime lastDayOfMonth(ZonedDateTime zonedDateTime) {
		return zonedDateTime.with(TemporalAdjusters.lastDayOfMonth());
	}
	
	public static ZonedDateTime lastDayOfMonthAtStartOfDay(ZonedDateTime zonedDateTime) {
		return zonedDateTime.with(TemporalAdjusters.lastDayOfMonth())
							.toLocalDate()
							.atStartOfDay(zonedDateTime.getZone());
	}
	
	public static ZonedDateTime firstDayOfNextMonth(ZonedDateTime zonedDateTime) {
		return zonedDateTime.plusMonths(1)
							.with(TemporalAdjusters.firstDayOfMonth());
	}
	
	public static ZonedDateTime firstDayOfNextMonthAtStartOfDay(ZonedDateTime zonedDateTime) {
		return zonedDateTime.plusMonths(1)
							.with(TemporalAdjusters.firstDayOfMonth())
							.toLocalDate()
							.atStartOfDay(zonedDateTime.getZone());
	}
	
	public static ZonedDateTime lastDayOfNextMonth(ZonedDateTime zonedDateTime) {
		return zonedDateTime.plusMonths(1)
							.with(TemporalAdjusters.lastDayOfMonth());
	}
	
	public static ZonedDateTime lastDayOfNextMonthAtStartOfDay(ZonedDateTime zonedDateTime) {
		return zonedDateTime.plusMonths(1)
							.with(TemporalAdjusters.lastDayOfMonth())
							.toLocalDate()
							.atStartOfDay(zonedDateTime.getZone());
	}
	
	public static ZonedDateTime firstDayOfPreviousMonth(ZonedDateTime zonedDateTime) {
		return zonedDateTime.minusMonths(1)
							.with(TemporalAdjusters.firstDayOfMonth());
	}
	
	public static ZonedDateTime firstDayOfPreviousMonthAtStartOfDay(ZonedDateTime zonedDateTime) {
		return zonedDateTime.minusMonths(1)
							.with(TemporalAdjusters.firstDayOfMonth())
							.toLocalDate()
							.atStartOfDay(zonedDateTime.getZone());
	}
	
	public static ZonedDateTime lastDayOfPreviousMonth(ZonedDateTime zonedDateTime) {
		return zonedDateTime.minusMonths(1)
							.with(TemporalAdjusters.lastDayOfMonth());
	}
	
	public static ZonedDateTime lastDayOfPreviousMonthAtStartOfDay(ZonedDateTime zonedDateTime) {
		return zonedDateTime.minusMonths(1)
							.with(TemporalAdjusters.lastDayOfMonth())
							.toLocalDate()
							.atStartOfDay(zonedDateTime.getZone());
	}
	
	// YEAR
	
	public static ZonedDateTime addYears(ZonedDateTime zonedDateTime, int yearsToAdd) {
		return zonedDateTime.plusYears(yearsToAdd);
	}
	
	public static ZonedDateTime subtractYears(ZonedDateTime zonedDateTime, int yearsToSubtract) {
		return zonedDateTime.minusYears(yearsToSubtract);
	}
	
	public static ZonedDateTime firstDayOfYear(ZonedDateTime zonedDateTime) {
		return zonedDateTime.with(TemporalAdjusters.firstDayOfYear());
	}
	
	public static ZonedDateTime firstDayOfYearAtStartOfDay(ZonedDateTime zonedDateTime) {
		return zonedDateTime.with(TemporalAdjusters.firstDayOfYear())
							.toLocalDate()
							.atStartOfDay(zonedDateTime.getZone());
	}
	
	public static ZonedDateTime lastDayOfYear(ZonedDateTime zonedDateTime) {
		return zonedDateTime.with(TemporalAdjusters.lastDayOfYear());
	}
	
	public static ZonedDateTime lastDayOfYearAtStartOfDay(ZonedDateTime zonedDateTime) {
		return zonedDateTime.with(TemporalAdjusters.lastDayOfYear())
							.toLocalDate()
							.atStartOfDay(zonedDateTime.getZone());
	}
	
	public static ZonedDateTime firstDayOfNextYear(ZonedDateTime zonedDateTime) {
		return zonedDateTime.plusYears(1)
							.with(TemporalAdjusters.firstDayOfYear());
	}
	
	public static ZonedDateTime firstDayOfNextYearAtStartOfDay(ZonedDateTime zonedDateTime) {
		return zonedDateTime.plusYears(1)
							.with(TemporalAdjusters.firstDayOfYear())
							.toLocalDate()
							.atStartOfDay(zonedDateTime.getZone());
	}
	
	public static ZonedDateTime lastDayOfNextYear(ZonedDateTime zonedDateTime) {
		return zonedDateTime.plusYears(1)
							.with(TemporalAdjusters.lastDayOfYear());
	}
	
	public static ZonedDateTime lastDayOfNextYearAtStartOfDay(ZonedDateTime zonedDateTime) {
		return zonedDateTime.plusYears(1)
							.with(TemporalAdjusters.lastDayOfYear())
							.toLocalDate()
							.atStartOfDay(zonedDateTime.getZone());
	}
	
	public static ZonedDateTime firstDayOfPreviousYear(ZonedDateTime zonedDateTime) {
		return zonedDateTime.minusYears(1)
							.with(TemporalAdjusters.firstDayOfYear());
	}
	
	public static ZonedDateTime firstDayOfPreviousYearAtStartOfDay(ZonedDateTime zonedDateTime) {
		return zonedDateTime.minusYears(1)
							.with(TemporalAdjusters.firstDayOfYear())
							.toLocalDate()
							.atStartOfDay(zonedDateTime.getZone());
	}
	
	public static ZonedDateTime lastDayOfPreviousYear(ZonedDateTime zonedDateTime) {
		return zonedDateTime.minusYears(1)
							.with(TemporalAdjusters.lastDayOfYear());
	}
	
	public static ZonedDateTime lastDayOfPreviousYearAtStartOfDay(ZonedDateTime zonedDateTime) {
		return zonedDateTime.minusYears(1)
							.with(TemporalAdjusters.lastDayOfYear())
							.toLocalDate()
							.atStartOfDay(zonedDateTime.getZone());
	}
	
	// TRIMESTER (3 month period)
	
	public static ZonedDateTime firstDayOfCurrentTrimester(ZonedDateTime zonedDateTime) {
		return ZonedDateTimeTrimesterUtils.getFirstDayOfCurrentTrimester().get(zonedDateTime.getMonth()).apply(zonedDateTime);
	}
	
	public static ZonedDateTime lastDayOfCurrentTrimester(ZonedDateTime zonedDateTime) {
		return ZonedDateTimeTrimesterUtils.getLastDayOfCurrentTrimester().get(zonedDateTime.getMonth()).apply(zonedDateTime);
	}
	
	public static ZonedDateTime firstDayOfNextTrimester(ZonedDateTime zonedDateTime) {
		return ZonedDateTimeTrimesterUtils.getFirstDayOfNextTrimester().get(zonedDateTime.getMonth()).apply(zonedDateTime);
	}
	
	public static ZonedDateTime lastDayOfNextTrimester(ZonedDateTime zonedDateTime) {
		return ZonedDateTimeTrimesterUtils.getLastDayOfNextTrimester().get(zonedDateTime.getMonth()).apply(zonedDateTime);
	}
	
	public static ZonedDateTime firstDayOfPreviousTrimester(ZonedDateTime zonedDateTime) {
		return ZonedDateTimeTrimesterUtils.getFirstDayOfPreviousTrimester().get(zonedDateTime.getMonth()).apply(zonedDateTime);
	}
	
	public static ZonedDateTime lastDayOfPreviousTrimester(ZonedDateTime zonedDateTime) {
		return ZonedDateTimeTrimesterUtils.getLastDayOfPreviousTrimester().get(zonedDateTime.getMonth()).apply(zonedDateTime);
	}
	
	public static boolean isFirstTrimester(ZonedDateTime zonedDateTime) {
		int monthValue = zonedDateTime.getMonthValue();
		return isBetweenInclusive(1, monthValue, 3);
	}
	
	public static boolean isSecondTrimester(ZonedDateTime zonedDateTime) {
		int monthValue = zonedDateTime.getMonthValue();
		return isBetweenInclusive(4, monthValue, 6);
	}
	
	public static boolean isThirdTrimester(ZonedDateTime zonedDateTime) {
		int monthValue = zonedDateTime.getMonthValue();
		return isBetweenInclusive(7, monthValue, 9);
	}
	
	public static boolean isFourthTrimester(ZonedDateTime zonedDateTime) {
		int monthValue = zonedDateTime.getMonthValue();
		return isBetweenInclusive(10, monthValue, 12);
	}
	
	// QUADRIMESTER (4 month period)
	
	public static ZonedDateTime firstDayOfCurrentQuadrimester(ZonedDateTime zonedDateTime) {
		return ZonedDateTimeQuadrimesterUtils.getFirstDayOfCurrentQuadrimester().get(zonedDateTime.getMonth()).apply(zonedDateTime);
	}
	
	public static ZonedDateTime lastDayOfCurrentQuadrimester(ZonedDateTime zonedDateTime) {
		return ZonedDateTimeQuadrimesterUtils.getLastDayOfCurrentQuadrimester().get(zonedDateTime.getMonth()).apply(zonedDateTime);
	}
	
	public static ZonedDateTime firstDayOfNextQuadrimester(ZonedDateTime zonedDateTime) {
		return ZonedDateTimeQuadrimesterUtils.getFirstDayOfNextQuadrimester().get(zonedDateTime.getMonth()).apply(zonedDateTime);
	}
	
	public static ZonedDateTime lastDayOfNextQuadrimester(ZonedDateTime zonedDateTime) {
		return ZonedDateTimeQuadrimesterUtils.getLastDayOfNextQuadrimester().get(zonedDateTime.getMonth()).apply(zonedDateTime);
	}
	
	public static ZonedDateTime firstDayOfPreviousQuadrimester(ZonedDateTime zonedDateTime) {
		return ZonedDateTimeQuadrimesterUtils.getFirstDayOfPreviousQuadrimester().get(zonedDateTime.getMonth()).apply(zonedDateTime);
	}
	
	public static ZonedDateTime lastDayOfPreviousQuadrimester(ZonedDateTime zonedDateTime) {
		return ZonedDateTimeQuadrimesterUtils.getLastDayOfPreviousQuadrimester().get(zonedDateTime.getMonth()).apply(zonedDateTime);
	}
	
	public static boolean isFirstQuadrimester(ZonedDateTime zonedDateTime) {
		int monthValue = zonedDateTime.getMonthValue();
		return isBetweenInclusive(1, monthValue, 4);
	}
	
	public static boolean isSecondQuadrimester(ZonedDateTime zonedDateTime) {
		int monthValue = zonedDateTime.getMonthValue();
		return isBetweenInclusive(5, monthValue, 8);
	}
	
	public static boolean isThirdQuadrimester(ZonedDateTime zonedDateTime) {
		int monthValue = zonedDateTime.getMonthValue();
		return isBetweenInclusive(9, monthValue, 12);
	}
	
	// SEMESTER (6 month period)
	
	public static ZonedDateTime firstDayOfCurrentSemester(ZonedDateTime zonedDateTime) {
		return ZonedDateTimeSemesterUtils.getFirstDayOfCurrentSemester().get(zonedDateTime.getMonth()).apply(zonedDateTime);
	}
	
	public static ZonedDateTime lastDayOfCurrentSemester(ZonedDateTime zonedDateTime) {
		return ZonedDateTimeSemesterUtils.getLastDayOfCurrentSemester().get(zonedDateTime.getMonth()).apply(zonedDateTime);
	}
	
	public static ZonedDateTime firstDayOfNextSemester(ZonedDateTime zonedDateTime) {
		return ZonedDateTimeSemesterUtils.getFirstDayOfNextSemester().get(zonedDateTime.getMonth()).apply(zonedDateTime);
	}
	
	public static ZonedDateTime lastDayOfNextSemester(ZonedDateTime zonedDateTime) {
		return ZonedDateTimeSemesterUtils.getLastDayOfNextSemester().get(zonedDateTime.getMonth()).apply(zonedDateTime);
	}
	
	public static ZonedDateTime firstDayOfPreviousSemester(ZonedDateTime zonedDateTime) {
		return ZonedDateTimeSemesterUtils.getFirstDayOfPreviousSemester().get(zonedDateTime.getMonth()).apply(zonedDateTime);
	}
	
	public static ZonedDateTime lastDayOfPreviousSemester(ZonedDateTime zonedDateTime) {
		return ZonedDateTimeSemesterUtils.getLastDayOfPreviousSemester().get(zonedDateTime.getMonth()).apply(zonedDateTime);
	}
	
	public static boolean isFirstSemester(ZonedDateTime zonedDateTime) {
		int monthValue = zonedDateTime.getMonthValue();
		return isBetweenInclusive(1, monthValue, 6);
	}
	
	public static boolean isSecondSemester(ZonedDateTime zonedDateTime) {
		int monthValue = zonedDateTime.getMonthValue();
		return isBetweenInclusive(7, monthValue, 12);
	}
	
	// COMPARE
	
	public static boolean isEquals(ZonedDateTime zonedDateTimeLeft, ZonedDateTime zonedDateTimeRight) {
		return zonedDateTimeLeft.equals(zonedDateTimeRight);
	}
	
	public static boolean isNotEquals(ZonedDateTime zonedDateTimeLeft, ZonedDateTime zonedDateTimeRight) {
		return !zonedDateTimeLeft.equals(zonedDateTimeRight);
	}
	
	public static boolean isBefore(ZonedDateTime zonedDateTimeLeft, ZonedDateTime zonedDateTimeRight) {
		return zonedDateTimeLeft.isBefore(zonedDateTimeRight);
	}
	
	public static boolean isAfter(ZonedDateTime zonedDateTimeLeft, ZonedDateTime zonedDateTimeRight) {
		return zonedDateTimeLeft.isAfter(zonedDateTimeRight);
	}
	
	public static boolean isBeforeOrEquals(ZonedDateTime zonedDateTimeLeft, ZonedDateTime zonedDateTimeRight) {
		return zonedDateTimeLeft.compareTo(zonedDateTimeRight) <= 0;
	}
	
	public static boolean isAfterOrEquals(ZonedDateTime zonedDateTimeLeft, ZonedDateTime zonedDateTimeRight) {
		return zonedDateTimeLeft.compareTo(zonedDateTimeRight) >= 0;
	}
	
	public static boolean isBetweenInclusive(ZonedDateTime left, ZonedDateTime between, ZonedDateTime right) {
		return isBeforeOrEquals(left, between) && isBeforeOrEquals(between, right);
	}
	
	public static boolean isBetweenExclusive(ZonedDateTime left, ZonedDateTime between, ZonedDateTime right) {
		return isBefore(left, between) && isBefore(between, right);
	}
	
	// IS SPECIFIC DATE
	
	public static boolean isLeapYear(ZonedDateTime zonedDateTime) {
		return zonedDateTime.toLocalDate().isLeapYear();
	}
	
	public static boolean isFirstDayOfMonth(ZonedDateTime zonedDateTime) {
		return zonedDateTime.getDayOfMonth() == 1;
	}
	
	public static boolean isLastDayOfMonth(ZonedDateTime zonedDateTime) {
		return zonedDateTime.getDayOfMonth() == lastDayOfMonth(zonedDateTime).getDayOfMonth();
	}
	
	public static boolean isFirstDayOfTheYear(ZonedDateTime zonedDateTime) {
		return isJanuary(zonedDateTime) && zonedDateTime.getDayOfMonth() == 1;
	}
	
	public static boolean isLastDayOfTheYear(ZonedDateTime zonedDateTime) {
		return isDecember(zonedDateTime) && zonedDateTime.getDayOfMonth() == 31;
	}
	
	public static boolean isJanuary(ZonedDateTime zonedDateTime) {
		return JANUARY == zonedDateTime.getMonth();
	}
	
	public static boolean isFebruary(ZonedDateTime zonedDateTime) {
		return FEBRUARY == zonedDateTime.getMonth();
	}
	
	public static boolean isMarch(ZonedDateTime zonedDateTime) {
		return MARCH == zonedDateTime.getMonth();
	}
	
	public static boolean isApril(ZonedDateTime zonedDateTime) {
		return APRIL == zonedDateTime.getMonth();
	}
	
	public static boolean isMay(ZonedDateTime zonedDateTime) {
		return MAY == zonedDateTime.getMonth();
	}
	
	public static boolean isJune(ZonedDateTime zonedDateTime) {
		return JUNE == zonedDateTime.getMonth();
	}
	
	public static boolean isJuly(ZonedDateTime zonedDateTime) {
		return JULY == zonedDateTime.getMonth();
	}
	
	public static boolean isAugust(ZonedDateTime zonedDateTime) {
		return AUGUST == zonedDateTime.getMonth();
	}
	
	public static boolean isSeptember(ZonedDateTime zonedDateTime) {
		return SEPTEMBER == zonedDateTime.getMonth();
	}
	
	public static boolean isOctober(ZonedDateTime zonedDateTime) {
		return OCTOBER == zonedDateTime.getMonth();
	}
	
	public static boolean isNovember(ZonedDateTime zonedDateTime) {
		return NOVEMBER == zonedDateTime.getMonth();
	}
	
	public static boolean isDecember(ZonedDateTime zonedDateTime) {
		return DECEMBER == zonedDateTime.getMonth();
	}
	
	// SET SPECIFIC DATE
	
	public static ZonedDateTime buildZonedDateTime(int year, int month, int day, ZoneId zoneId) {
		return LocalDateUtils.buildLocalDate(year, month, day).atStartOfDay(zoneId);
	}
	
	public static ZonedDateTime buildZonedDateTime(LocalDateTime dateTime, ZoneId zoneId) {
		return ZonedDateTime.of(dateTime, zoneId);
	}
	
	public static ZonedDateTime buildZonedDateTime(LocalDate date, LocalTime time, ZoneId zoneId) {
		return ZonedDateTime.of(date, time, zoneId);
	}
	
	public static ZonedDateTime buildZonedDateTime(int year, int month, int day, int hour, int minute, ZoneId zoneId) {
		return ZonedDateTime.of(year, month, day, hour, minute, 0, 0, zoneId);
	}
	
	public static ZonedDateTime buildZonedDateTime(int year, int month, int day, int hour, int minute, int second, ZoneId zoneId) {
		return ZonedDateTime.of(year, month, day, hour, minute, second, 0, zoneId);
	}
	
	public static ZonedDateTime buildZonedDateTime(int year, int month, int day, int hour, int minute, int second, int nanoOfSecond, ZoneId zoneId) {
		return ZonedDateTime.of(year, month, day, hour, minute, second, nanoOfSecond, zoneId);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static ZonedDateTime changeDay(ZonedDateTime zonedDateTime, int dayOfMonth) {
		return zonedDateTime.withDayOfMonth(dayOfMonth);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static ZonedDateTime changeMonthAndDay(ZonedDateTime zonedDateTime, int month, int dayOfMonth) {
		return zonedDateTime.withMonth(month)
							.withDayOfMonth(dayOfMonth);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static ZonedDateTime changeNanoSecond(ZonedDateTime zonedDateTime, int nanoSecond) {
		return zonedDateTime.withNano(nanoSecond);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static ZonedDateTime changeSecond(ZonedDateTime zonedDateTime, int second) {
		return zonedDateTime.withSecond(second);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static ZonedDateTime changeMinute(ZonedDateTime zonedDateTime, int minute) {
		return zonedDateTime.withMinute(minute);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static ZonedDateTime changeHour(ZonedDateTime zonedDateTime, int hour) {
		return zonedDateTime.withHour(hour);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static ZonedDateTime changeHourMinuteSecond(ZonedDateTime zonedDateTime, int hour, int minute, int second) {
		return zonedDateTime.withHour(hour)
							.withMinute(minute)
							.withSecond(second);
	}
	
	private static boolean isBetweenInclusive(int min, int between, int max) {
		return min <= between && between <= max; 
	}
	
}