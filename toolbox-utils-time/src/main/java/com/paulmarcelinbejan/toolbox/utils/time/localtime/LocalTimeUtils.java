package com.paulmarcelinbejan.toolbox.utils.time.localtime;

import static java.time.temporal.ChronoUnit.MICROS;
import static java.time.temporal.ChronoUnit.MILLIS;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocalTimeUtils {

	// NANO SECOND
	
	public static LocalTime addNanos(LocalTime localTime, int nanosToAdd) {
		return localTime.plusNanos(nanosToAdd);
	}
	
	public static LocalTime subtractNanos(LocalTime localTime, int nanosToSubtract) {
		return localTime.minusNanos(nanosToSubtract);
	}
	
	// MICRO SECOND
	
	public static LocalTime addMicros(LocalTime localTime, int microsToAdd) {
		return localTime.plus(microsToAdd, MICROS);
	}
	
	public static LocalTime subtractMicros(LocalTime localTime, int microsToSubtract) {
		return localTime.minus(microsToSubtract, MICROS);
	}
	
	// MILLI SECOND
	
	public static LocalTime addMillis(LocalTime localTime, int millisToAdd) {
		return localTime.plus(millisToAdd, MILLIS);
	}
	
	public static LocalTime subtractMillis(LocalTime localTime, int millisToSubtract) {
		return localTime.minus(millisToSubtract, MILLIS);
	}
	
	// SECOND
	
	public static LocalTime addSeconds(LocalTime localTime, int secondsToAdd) {
		return localTime.plusSeconds(secondsToAdd);
	}
	
	public static LocalTime subtractSeconds(LocalTime localTime, int secondsToSubtract) {
		return localTime.minusSeconds(secondsToSubtract);
	}
	
	// MINUTE
	
	public static LocalTime addMinutes(LocalTime localTime, int minutesToAdd) {
		return localTime.plusMinutes(minutesToAdd);
	}
	
	public static LocalTime subtractmMinutes(LocalTime localTime, int minutesToSubtract) {
		return localTime.minusMinutes(minutesToSubtract);
	}
	
	// HOUR
	
	public static LocalTime addHours(LocalTime localTime, int hoursToAdd) {
		return localTime.plusHours(hoursToAdd);
	}
	
	public static LocalTime subtractHours(LocalTime localTime, int hoursToSubtract) {
		return localTime.minusHours(hoursToSubtract);
	}
	
	// COMPARE
	
	public static boolean isEquals(LocalTime localTimeLeft, LocalTime localTimeRight) {
		return localTimeLeft.equals(localTimeRight);
	}
	
	public static boolean isNotEquals(LocalTime localTimeLeft, LocalTime localTimeRight) {
		return !localTimeLeft.equals(localTimeRight);
	}
	
	public static boolean isBefore(LocalTime localTimeLeft, LocalTime localTimeRight) {
		return localTimeLeft.isBefore(localTimeRight);
	}
	
	public static boolean isAfter(LocalTime localTimeLeft, LocalTime localTimeRight) {
		return localTimeLeft.isAfter(localTimeRight);
	}
	
	public static boolean isBeforeOrEquals(LocalTime localTimeLeft, LocalTime localTimeRight) {
		return localTimeLeft.compareTo(localTimeRight) <= 0;
	}
	
	public static boolean isAfterOrEquals(LocalTime localTimeLeft, LocalTime localTimeRight) {
		return localTimeLeft.compareTo(localTimeRight) >= 0;
	}
	
	public static boolean isBetweenInclusive(LocalTime left, LocalTime between, LocalTime right) {
		return isBeforeOrEquals(left, between) && isBeforeOrEquals(between, right);
	}
	
	public static boolean isBetweenExclusive(LocalTime left, LocalTime between, LocalTime right) {
		return isBefore(left, between) && isBefore(between, right);
	}
	
	// SET SPECIFIC DATE
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalTime buildLocalTime(int hour, int minute) {
		return LocalTime.of(hour, minute);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalTime buildLocalTime(int hour, int minute, int second) {
		return LocalTime.of(hour, minute, second);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalTime buildLocalTimeWithMillis(int hour, int minute, int second, int millisecond) {
		return LocalTime.of(hour, minute, second)
						.with(ChronoField.MILLI_OF_SECOND, millisecond);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalTime buildLocalTimeWithMicros(int hour, int minute, int second, int microsecond) {
		return LocalTime.of(hour, minute, second)
						.with(ChronoField.MICRO_OF_SECOND, microsecond);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalTime buildLocalTimeWithNanos(int hour, int minute, int second, int nanosecond) {
		return LocalTime.of(hour, minute, second, nanosecond);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalTime changeNanosecond(LocalTime localTime, int nanosecond) {
		return localTime.withNano(nanosecond);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalTime changeMicrosecond(LocalTime localTime, int microsecond) {
		return localTime.with(ChronoField.MICRO_OF_SECOND, microsecond);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalTime changeMillisecond(LocalTime localTime, int millisecond) {
		return localTime.with(ChronoField.MILLI_OF_SECOND, millisecond);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalTime changeSecond(LocalTime localTime, int second) {
		return localTime.withSecond(second);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalTime changeMinute(LocalTime localTime, int minute) {
		return localTime.withMinute(minute);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalTime changeHour(LocalTime localTime, int hour) {
		return localTime.withHour(hour);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalTime changeHourMinuteSecond(LocalTime localTime, int hour, int minute, int second) {
		return localTime.withHour(hour)
						.withMinute(minute)
						.withSecond(second);
	}
	
}