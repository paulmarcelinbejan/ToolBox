package io.github.paulmarcelinbejan.toolbox.utils.time.localtime;

import static java.time.temporal.ChronoUnit.MICROS;
import static java.time.temporal.ChronoUnit.MILLIS;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Utility class for working with LocalTime objects.
 * <p>
 * This class provides various methods for adding and subtracting time components (e.g., hours, minutes),
 * as well as methods for comparing LocalTime instances.
 * </p>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocalTimeUtils {

    // NANO SECOND

    /**
     * Adds the specified number of nanoseconds to the given LocalTime.
     *
     * @param localTime    The original LocalTime.
     * @param nanosToAdd   The number of nanoseconds to add.
     * @return The LocalTime with nanoseconds added.
     */
    public static LocalTime addNanos(LocalTime localTime, int nanosToAdd) {
        return localTime.plusNanos(nanosToAdd);
    }

    /**
     * Subtracts the specified number of nanoseconds from the given LocalTime.
     *
     * @param localTime         The original LocalTime.
     * @param nanosToSubtract   The number of nanoseconds to subtract.
     * @return The LocalTime with nanoseconds subtracted.
     */
    public static LocalTime subtractNanos(LocalTime localTime, int nanosToSubtract) {
        return localTime.minusNanos(nanosToSubtract);
    }

    // MICRO SECOND

    /**
     * Adds the specified number of microseconds to the given LocalTime.
     *
     * @param localTime      The original LocalTime.
     * @param microsToAdd    The number of microseconds to add.
     * @return The LocalTime with microseconds added.
     */
    public static LocalTime addMicros(LocalTime localTime, int microsToAdd) {
        return localTime.plus(microsToAdd, MICROS);
    }

    /**
     * Subtracts the specified number of microseconds from the given LocalTime.
     *
     * @param localTime            The original LocalTime.
     * @param microsToSubtract     The number of microseconds to subtract.
     * @return The LocalTime with microseconds subtracted.
     */
    public static LocalTime subtractMicros(LocalTime localTime, int microsToSubtract) {
        return localTime.minus(microsToSubtract, MICROS);
    }

    // MILLI SECOND

    /**
     * Adds the specified number of milliseconds to the given LocalTime.
     *
     * @param localTime       The original LocalTime.
     * @param millisToAdd     The number of milliseconds to add.
     * @return The LocalTime with milliseconds added.
     */
    public static LocalTime addMillis(LocalTime localTime, int millisToAdd) {
        return localTime.plus(millisToAdd, MILLIS);
    }

    /**
     * Subtracts the specified number of milliseconds from the given LocalTime.
     *
     * @param localTime            The original LocalTime.
     * @param millisToSubtract     The number of milliseconds to subtract.
     * @return The LocalTime with milliseconds subtracted.
     */
    public static LocalTime subtractMillis(LocalTime localTime, int millisToSubtract) {
        return localTime.minus(millisToSubtract, MILLIS);
    }

    // SECOND

    /**
     * Adds the specified number of seconds to the given LocalTime.
     *
     * @param localTime        The original LocalTime.
     * @param secondsToAdd     The number of seconds to add.
     * @return The LocalTime with seconds added.
     */
    public static LocalTime addSeconds(LocalTime localTime, int secondsToAdd) {
        return localTime.plusSeconds(secondsToAdd);
    }

    /**
     * Subtracts the specified number of seconds from the given LocalTime.
     *
     * @param localTime            The original LocalTime.
     * @param secondsToSubtract    The number of seconds to subtract.
     * @return The LocalTime with seconds subtracted.
     */
    public static LocalTime subtractSeconds(LocalTime localTime, int secondsToSubtract) {
        return localTime.minusSeconds(secondsToSubtract);
    }

    // MINUTE

    /**
     * Adds the specified number of minutes to the given LocalTime.
     *
     * @param localTime        The original LocalTime.
     * @param minutesToAdd     The number of minutes to add.
     * @return The LocalTime with minutes added.
     */
    public static LocalTime addMinutes(LocalTime localTime, int minutesToAdd) {
        return localTime.plusMinutes(minutesToAdd);
    }

    /**
     * Subtracts the specified number of minutes from the given LocalTime.
     *
     * @param localTime            The original LocalTime.
     * @param minutesToSubtract    The number of minutes to subtract.
     * @return The LocalTime with minutes subtracted.
     */
    public static LocalTime subtractmMinutes(LocalTime localTime, int minutesToSubtract) {
        return localTime.minusMinutes(minutesToSubtract);
    }

    // HOUR

    /**
     * Adds the specified number of hours to the given LocalTime.
     *
     * @param localTime      The original LocalTime.
     * @param hoursToAdd     The number of hours to add.
     * @return The LocalTime with hours added.
     */
    public static LocalTime addHours(LocalTime localTime, int hoursToAdd) {
        return localTime.plusHours(hoursToAdd);
    }

    /**
     * Subtracts the specified number of hours from the given LocalTime.
     *
     * @param localTime         The original LocalTime.
     * @param hoursToSubtract   The number of hours to subtract.
     * @return The LocalTime with hours subtracted.
     */
    public static LocalTime subtractHours(LocalTime localTime, int hoursToSubtract) {
        return localTime.minusHours(hoursToSubtract);
    }

    // COMPARE

    /**
     * Checks if two LocalTime instances are equal.
     *
     * @param localTimeLeft    The first LocalTime.
     * @param localTimeRight   The second LocalTime.
     * @return True if the LocalTime instances are equal, false otherwise.
     */
    public static boolean isEquals(LocalTime localTimeLeft, LocalTime localTimeRight) {
        return localTimeLeft.equals(localTimeRight);
    }

    /**
     * Checks if two LocalTime instances are not equal.
     *
     * @param localTimeLeft    The first LocalTime.
     * @param localTimeRight   The second LocalTime.
     * @return True if the LocalTime instances are not equal, false otherwise.
     */
    public static boolean isNotEquals(LocalTime localTimeLeft, LocalTime localTimeRight) {
        return !localTimeLeft.equals(localTimeRight);
    }

    /**
     * Checks if the first LocalTime is before the second LocalTime.
     *
     * @param localTimeLeft    The first LocalTime.
     * @param localTimeRight   The second LocalTime.
     * @return True if the first LocalTime is before the second, false otherwise.
     */
    public static boolean isBefore(LocalTime localTimeLeft, LocalTime localTimeRight) {
        return localTimeLeft.isBefore(localTimeRight);
    }

    /**
     * Checks if the first LocalTime is after the second LocalTime.
     *
     * @param localTimeLeft    The first LocalTime.
     * @param localTimeRight   The second LocalTime.
     * @return True if the first LocalTime is after the second, false otherwise.
     */
    public static boolean isAfter(LocalTime localTimeLeft, LocalTime localTimeRight) {
        return localTimeLeft.isAfter(localTimeRight);
    }

    /**
     * Checks if the first LocalTime is before or equal to the second LocalTime.
     *
     * @param localTimeLeft    The first LocalTime.
     * @param localTimeRight   The second LocalTime.
     * @return True if the first LocalTime is before or equal to the second, false otherwise.
     */
    public static boolean isBeforeOrEquals(LocalTime localTimeLeft, LocalTime localTimeRight) {
        return localTimeLeft.compareTo(localTimeRight) <= 0;
    }

    /**
     * Checks if the first LocalTime is after or equal to the second LocalTime.
     *
     * @param localTimeLeft    The first LocalTime.
     * @param localTimeRight   The second LocalTime.
     * @return True if the first LocalTime is after or equal to the second, false otherwise.
     */
    public static boolean isAfterOrEquals(LocalTime localTimeLeft, LocalTime localTimeRight) {
        return localTimeLeft.compareTo(localTimeRight) >= 0;
    }

    /**
     * Checks if a LocalTime is between two other LocalTime instances (inclusive).
     *
     * @param left      The left boundary LocalTime.
     * @param between   The LocalTime to check if it's between the boundaries.
     * @param right     The right boundary LocalTime.
     * @return True if the LocalTime is between the boundaries (inclusive), false otherwise.
     */
    public static boolean isBetweenInclusive(LocalTime left, LocalTime between, LocalTime right) {
        return isBeforeOrEquals(left, between) && isBeforeOrEquals(between, right);
    }

    /**
     * Checks if a LocalTime is between two other LocalTime instances (exclusive).
     *
     * @param left      The left boundary LocalTime.
     * @param between   The LocalTime to check if it's between the boundaries.
     * @param right     The right boundary LocalTime.
     * @return True if the LocalTime is between the boundaries (exclusive), false otherwise.
     */
    public static boolean isBetweenExclusive(LocalTime left, LocalTime between, LocalTime right) {
        return isBefore(left, between) && isBefore(between, right);
    }

    // SET SPECIFIC DATE

    /**
     * Builds a LocalTime with the specified hour and minute.
     *
     * @param hour      The hour of the LocalTime.
     * @param minute    The minute of the LocalTime.
     * @return The constructed LocalTime.
     * @throws DateTimeException If the values are not valid for a LocalTime.
     */
    public static LocalTime buildLocalTime(int hour, int minute) {
        return LocalTime.of(hour, minute);
    }
	
    /**
     * Builds a LocalTime instance with the specified hour, minute, and second.
     *
     * @param hour    The hour-of-day to set, valid values are 0 to 23.
     * @param minute  The minute-of-hour to set, valid values are 0 to 59.
     * @param second  The second-of-minute to set, valid values are 0 to 59.
     * @return A LocalTime instance representing the specified time.
     * @throws DateTimeException if any of the input values is out of valid range.
     */
    public static LocalTime buildLocalTime(int hour, int minute, int second) {
        return LocalTime.of(hour, minute, second);
    }

    /**
     * Builds a LocalTime instance with the specified hour, minute, second, and millisecond.
     *
     * @param hour        The hour-of-day to set, valid values are 0 to 23.
     * @param minute      The minute-of-hour to set, valid values are 0 to 59.
     * @param second      The second-of-minute to set, valid values are 0 to 59.
     * @param millisecond The millisecond-of-second to set, valid values are 0 to 999.
     * @return A LocalTime instance representing the specified time.
     * @throws DateTimeException if any of the input values is out of valid range.
     */
    public static LocalTime buildLocalTimeWithMillis(int hour, int minute, int second, int millisecond) {
        return LocalTime.of(hour, minute, second).with(ChronoField.MILLI_OF_SECOND, millisecond);
    }

    /**
     * Builds a LocalTime instance with the specified hour, minute, second, and microsecond.
     *
     * @param hour       The hour-of-day to set, valid values are 0 to 23.
     * @param minute     The minute-of-hour to set, valid values are 0 to 59.
     * @param second     The second-of-minute to set, valid values are 0 to 59.
     * @param microsecond The microsecond-of-second to set, valid values are 0 to 999_999.
     * @return A LocalTime instance representing the specified time.
     * @throws DateTimeException if any of the input values is out of valid range.
     */
    public static LocalTime buildLocalTimeWithMicros(int hour, int minute, int second, int microsecond) {
        return LocalTime.of(hour, minute, second).with(ChronoField.MICRO_OF_SECOND, microsecond);
    }

    /**
     * Builds a LocalTime instance with the specified hour, minute, second, and nanosecond.
     *
     * @param hour       The hour-of-day to set, valid values are 0 to 23.
     * @param minute     The minute-of-hour to set, valid values are 0 to 59.
     * @param second     The second-of-minute to set, valid values are 0 to 59.
     * @param nanosecond The nanosecond-of-second to set, valid values are 0 to 999_999_999.
     * @return A LocalTime instance representing the specified time.
     * @throws DateTimeException if any of the input values is out of valid range.
     */
    public static LocalTime buildLocalTimeWithNanos(int hour, int minute, int second, int nanosecond) {
        return LocalTime.of(hour, minute, second, nanosecond);
    }

    /**
     * Changes the nanosecond-of-second field of the given LocalTime instance.
     *
     * @param localTime  The LocalTime instance to modify.
     * @param nanosecond The new nanosecond value, valid values are 0 to 999_999_999.
     * @return A new LocalTime instance with the specified nanosecond.
     * @throws DateTimeException if the nanosecond value is out of valid range.
     */
    public static LocalTime changeNanosecond(LocalTime localTime, int nanosecond) {
        return localTime.withNano(nanosecond);
    }

    /**
     * Changes the microsecond-of-second field of the given LocalTime instance.
     *
     * @param localTime   The LocalTime instance to modify.
     * @param microsecond The new microsecond value, valid values are 0 to 999_999.
     * @return A new LocalTime instance with the specified microsecond.
     * @throws DateTimeException if the microsecond value is out of valid range.
     */
    public static LocalTime changeMicrosecond(LocalTime localTime, int microsecond) {
        return localTime.with(ChronoField.MICRO_OF_SECOND, microsecond);
    }

    /**
     * Changes the millisecond-of-second field of the given LocalTime instance.
     *
     * @param localTime   The LocalTime instance to modify.
     * @param millisecond The new millisecond value, valid values are 0 to 999.
     * @return A new LocalTime instance with the specified millisecond.
     * @throws DateTimeException if the millisecond value is out of valid range.
     */
    public static LocalTime changeMillisecond(LocalTime localTime, int millisecond) {
        return localTime.with(ChronoField.MILLI_OF_SECOND, millisecond);
    }

    /**
     * Changes the second-of-minute field of the given LocalTime instance.
     *
     * @param localTime The LocalTime instance to modify.
     * @param second    The new second value, valid values are 0 to 59.
     * @return A new LocalTime instance with the specified second.
     * @throws DateTimeException if the second value is out of valid range.
     */
    public static LocalTime changeSecond(LocalTime localTime, int second) {
        return localTime.withSecond(second);
    }

    /**
     * Changes the minute-of-hour field of the given LocalTime instance.
     *
     * @param localTime The LocalTime instance to modify.
     * @param minute    The new minute value, valid values are 0 to 59.
     * @return A new LocalTime instance with the specified minute.
     * @throws DateTimeException if the minute value is out of valid range.
     */
    public static LocalTime changeMinute(LocalTime localTime, int minute) {
        return localTime.withMinute(minute);
    }

    /**
     * Changes the hour-of-day field of the given LocalTime instance.
     *
     * @param localTime The LocalTime instance to modify.
     * @param hour      The new hour value, valid values are 0 to 23.
     * @return A new LocalTime instance with the specified hour.
     * @throws DateTimeException if the hour value is out of valid range.
     */
    public static LocalTime changeHour(LocalTime localTime, int hour) {
        return localTime.withHour(hour);
    }

    /**
     * Changes the hour, minute, and second fields of the given LocalTime instance.
     *
     * @param localTime The LocalTime instance to modify.
     * @param hour      The new hour value, valid values are 0 to 23.
     * @param minute    The new minute value, valid values are 0 to 59.
     * @param second    The new second value, valid values are 0 to 59.
     * @return A new LocalTime instance with the specified hour, minute, and second.
     * @throws DateTimeException if any of the input values is out of valid range.
     */
    public static LocalTime changeHourMinuteSecond(LocalTime localTime, int hour, int minute, int second) {
        return localTime.withHour(hour).withMinute(minute).withSecond(second);
    }
	
}