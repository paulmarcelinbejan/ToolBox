package io.github.paulmarcelinbejan.toolbox.utils.time.instant;

import static java.time.temporal.ChronoUnit.MICROS;
import static java.time.temporal.ChronoUnit.MILLIS;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

import io.github.paulmarcelinbejan.toolbox.utils.time.localdatetime.LocalDateTimeUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InstantUtils {

	// NANO SECOND
	
	public static Instant addNanos(Instant instant, int nanosToAdd) {
		return instant.plusNanos(nanosToAdd);
	}
	
	public static Instant subtractNanos(Instant instant, int nanosToSubtract) {
		return instant.minusNanos(nanosToSubtract);
	}
	
	// MICRO SECOND
	
	public static Instant addMicros(Instant instant, int microsToAdd) {
		return instant.plus(microsToAdd, MICROS);
	}
	
	public static Instant subtractMicros(Instant instant, int microsToSubtract) {
		return instant.minus(microsToSubtract, MICROS);
	}
	
	// MILLI SECOND
	
	public static Instant addMillis(Instant instant, int millisToAdd) {
		return instant.plus(millisToAdd, MILLIS);
	}
	
	public static Instant subtractMillis(Instant instant, int millisToSubtract) {
		return instant.minus(millisToSubtract, MILLIS);
	}
	
	// SECOND
	
	public static Instant addSeconds(Instant instant, int secondsToAdd) {
		return instant.plusSeconds(secondsToAdd);
	}
	
	public static Instant subtractSeconds(Instant instant, int secondsToSubtract) {
		return instant.minusSeconds(secondsToSubtract);
	}
	
	// MINUTE
	
	public static Instant addMinutes(Instant instant, int minutesToAdd) {
		return instant.plus(minutesToAdd, ChronoUnit.MINUTES);
	}
	
	public static Instant subtractmMinutes(Instant instant, int minutesToSubtract) {
		return instant.minus(minutesToSubtract, ChronoUnit.MINUTES);
	}
	
	// HOUR
	
	public static Instant addHours(Instant instant, int hoursToAdd) {
		return instant.plus(hoursToAdd, ChronoUnit.HOURS);
	}
	
	public static Instant subtractHours(Instant instant, int hoursToSubtract) {
		return instant.minus(hoursToSubtract, ChronoUnit.HOURS);
	}
	
	// DAY
	
	public static Instant addDays(Instant instant, int daysToAdd) {
		return instant.plus(daysToAdd, ChronoUnit.DAYS);
	}
	
	public static Instant subtractDays(Instant instant, int daysToSubtract) {
		return instant.minus(daysToSubtract, ChronoUnit.DAYS);
	}
	
	// WEEK
	
	public static Instant addWeeks(Instant instant, int weeksToAdd) {
		return instant.plus(weeksToAdd, ChronoUnit.WEEKS);
	}
	
	public static Instant subtractWeeks(Instant instant, int weeksToSubtract) {
		return instant.minus(weeksToSubtract, ChronoUnit.WEEKS);
	}
	
	// MONTH
	
	public static Instant addMonths(Instant instant, int monthsToAdd) {
		return instant.plus(monthsToAdd, ChronoUnit.MONTHS);
	}
	
	public static Instant subtractMonths(Instant instant, int monthsToSubtract) {
		return instant.minus(monthsToSubtract, ChronoUnit.MONTHS);
	}
	
	public static Instant firstDayOfMonth(Instant instant) {
		return instant.with(TemporalAdjusters.firstDayOfMonth());
	}
	
	public static Instant lastDayOfMonth(Instant instant) {
		return instant.with(TemporalAdjusters.lastDayOfMonth());
	}
	
	public static Instant firstDayOfNextMonth(Instant instant) {
		return addMonths(instant, 1).with(TemporalAdjusters.firstDayOfMonth());
	}
	
	public static Instant lastDayOfNextMonth(Instant instant) {
		return addMonths(instant, 1).with(TemporalAdjusters.lastDayOfMonth());
	}
	
	public static Instant firstDayOfPreviousMonth(Instant instant) {
		return subtractMonths(instant, 1).with(TemporalAdjusters.firstDayOfMonth());
	}
	
	public static Instant lastDayOfPreviousMonth(Instant instant) {
		return subtractMonths(instant, 1).with(TemporalAdjusters.lastDayOfMonth());
	}
	
	// YEAR
	
	public static Instant addYears(Instant instant, int yearsToAdd) {
		return instant.plus(yearsToAdd, ChronoUnit.YEARS);
	}
	
	public static Instant subtractYears(Instant instant, int yearsToSubtract) {
		return instant.minus(yearsToSubtract, ChronoUnit.YEARS);
	}
	
	public static Instant firstDayOfYear(Instant instant) {
		return instant.with(TemporalAdjusters.firstDayOfYear());
	}
	
	public static Instant lastDayOfYear(Instant instant) {
		return instant.with(TemporalAdjusters.lastDayOfYear());
	}
	
	public static Instant firstDayOfNextYear(Instant instant) {
		return addYears(instant, 1).with(TemporalAdjusters.firstDayOfYear());
	}
	
	public static Instant lastDayOfNextYear(Instant instant) {
		return addYears(instant, 1).with(TemporalAdjusters.lastDayOfYear());
	}
	
	public static Instant firstDayOfPreviousYear(Instant instant) {
		return subtractYears(instant, 1).with(TemporalAdjusters.firstDayOfYear());
	}
	
	public static Instant lastDayOfPreviousYear(Instant instant) {
		return subtractYears(instant, 1).with(TemporalAdjusters.lastDayOfYear());
	}
	
	// COMPARE
	
	public static boolean isEquals(Instant instantLeft, Instant instantRight) {
		return instantLeft.equals(instantRight);
	}
	
	public static boolean isNotEquals(Instant instantLeft, Instant instantRight) {
		return !instantLeft.equals(instantRight);
	}
	
	public static boolean isBefore(Instant instantLeft, Instant instantRight) {
		return instantLeft.isBefore(instantRight);
	}
	
	public static boolean isAfter(Instant instantLeft, Instant instantRight) {
		return instantLeft.isAfter(instantRight);
	}
	
	public static boolean isBeforeOrEquals(Instant instantLeft, Instant instantRight) {
		return instantLeft.compareTo(instantRight) <= 0;
	}
	
	public static boolean isAfterOrEquals(Instant instantLeft, Instant instantRight) {
		return instantLeft.compareTo(instantRight) >= 0;
	}
	
	public static boolean isBetweenInclusive(Instant left, Instant between, Instant right) {
		return isBeforeOrEquals(left, between) && isBeforeOrEquals(between, right);
	}
	
	public static boolean isBetweenExclusive(Instant left, Instant between, Instant right) {
		return isBefore(left, between) && isBefore(between, right);
	}
	
	// IS SPECIFIC DATE
	
	public static boolean isFirstDayOfMonth(Instant instant) {
		return LocalDateTimeUtils.isFirstDayOfMonth(toLocalDateTime(instant));
	}
	
	public static boolean isLastDayOfMonth(Instant instant) {
		return LocalDateTimeUtils.isLastDayOfMonth(toLocalDateTime(instant));
	}
	
	public static boolean isFirstDayOfTheYear(Instant instant) {
		return LocalDateTimeUtils.isFirstDayOfTheYear(toLocalDateTime(instant));
	}
	
	public static boolean isLastDayOfTheYear(Instant instant) {
		return LocalDateTimeUtils.isLastDayOfTheYear(toLocalDateTime(instant));
	}
	
	public static boolean isJanuary(Instant instant) {
		return LocalDateTimeUtils.isJanuary(toLocalDateTime(instant));
	}
	
	public static boolean isFebruary(Instant instant) {
		return LocalDateTimeUtils.isFebruary(toLocalDateTime(instant));
	}
	
	public static boolean isMarch(Instant instant) {
		return LocalDateTimeUtils.isMarch(toLocalDateTime(instant));
	}
	
	public static boolean isApril(Instant instant) {
		return LocalDateTimeUtils.isApril(toLocalDateTime(instant));
	}
	
	public static boolean isMay(Instant instant) {
		return LocalDateTimeUtils.isMay(toLocalDateTime(instant));
	}
	
	public static boolean isJune(Instant instant) {
		return LocalDateTimeUtils.isJune(toLocalDateTime(instant));
	}
	
	public static boolean isJuly(Instant instant) {
		return LocalDateTimeUtils.isJuly(toLocalDateTime(instant));
	}
	
	public static boolean isAugust(Instant instant) {
		return LocalDateTimeUtils.isAugust(toLocalDateTime(instant));
	}
	
	public static boolean isSeptember(Instant instant) {
		return LocalDateTimeUtils.isSeptember(toLocalDateTime(instant));
	}
	
	public static boolean isOctober(Instant instant) {
		return LocalDateTimeUtils.isOctober(toLocalDateTime(instant));
	}
	
	public static boolean isNovember(Instant instant) {
		return LocalDateTimeUtils.isNovember(toLocalDateTime(instant));
	}
	
	public static boolean isDecember(Instant instant) {
		return LocalDateTimeUtils.isDecember(toLocalDateTime(instant));
	}
	
	// SET SPECIFIC DATE
	
	/**
	 * @return a point on the UTC timeline based on the LocalDateTime at the specified ZoneOffset.
	 */
	public static Instant buildInstant(LocalDate date, LocalTime time, ZoneOffset zoneOffset) {
		LocalDateTime localDateTime = LocalDateTime.of(date, time);
		return toInstant(localDateTime, zoneOffset);
	}
	
	/**
	 * @return a point on the UTC timeline based on the LocalDateTime at the specified ZoneOffset.
	 */
	public static Instant buildInstant(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
		return toInstant(localDateTime, zoneOffset);
	}
	
	/**
	 * @return a point on the UTC timeline based on the LocalDateTime at the specified ZoneId.
	 */
	public static Instant buildInstant(LocalDate date, LocalTime time, ZoneId zoneId) {
		return LocalDateTime.of(date, time).atZone(zoneId).toInstant();
	}
	
	/**
	 * @return a point on the UTC timeline based on the LocalDateTime at the specified ZoneId.
	 */
	public static Instant buildInstant(LocalDateTime localDateTime, ZoneId zoneId) {
		return localDateTime.atZone(zoneId).toInstant();
	}
	
	/**
	 * @return a point on the UTC timeline
	 */
	public static Instant buildInstant(int year, int month, int day, int hour, int minute) {
		LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute);
		return toInstant(localDateTime);
	}
	
	/**
	 * @return a point on the UTC timeline
	 */
	public static Instant buildInstant(int year, int month, int day, int hour, int minute, int second) {
		LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute, second);
		return toInstant(localDateTime);
	}
	
	public static Instant changeDay(Instant instant, int day) {
		LocalDateTime localDateTime = LocalDateTimeUtils.changeDay(toLocalDateTime(instant), day);
		return toInstant(localDateTime);
	}
	
	public static Instant changeMonthAndDay(Instant instant, int month, int day) {
		LocalDateTime localDateTime = LocalDateTimeUtils.changeMonthAndDay(toLocalDateTime(instant), month, day);
		return toInstant(localDateTime);
	}
	
	public static Instant changeSecond(Instant instant, int second) {
		LocalDateTime localDateTime = LocalDateTimeUtils.changeSecond(toLocalDateTime(instant), second);
		return toInstant(localDateTime);
	}
	
	public static Instant changeMinute(Instant instant, int minute) {
		LocalDateTime localDateTime = LocalDateTimeUtils.changeMinute(toLocalDateTime(instant), minute);
		return toInstant(localDateTime);
	}
	
	public static Instant changeHour(Instant instant, int hour) {
		LocalDateTime localDateTime = LocalDateTimeUtils.changeHour(toLocalDateTime(instant), hour);
		return toInstant(localDateTime);
	}
	
	public static Instant changeHourMinuteSecond(Instant instant, int hour, int minute, int second) {
		LocalDateTime localDateTime = LocalDateTimeUtils.changeHourMinuteSecond(toLocalDateTime(instant), hour, minute, second);
		return toInstant(localDateTime);
	}
	
	private static LocalDateTime toLocalDateTime(Instant instant) {
		return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
	}
	
	private static Instant toInstant(LocalDateTime localDateTime) {
		return toInstant(localDateTime, ZoneOffset.UTC);
	}
	
	private static Instant toInstant(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
		return localDateTime.toInstant(zoneOffset);
	}
	
}