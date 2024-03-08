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

/**
 * Utility class for working with Java Instant objects.
 * This class provides various static methods for common operations involving Instant.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InstantUtils {

	// NANO SECOND

	/**
	 * Adds a specified number of nanoseconds to the given {@link Instant}.
	 *
	 * @param instant      The {@link Instant} to which nanoseconds are added.
	 * @param nanosToAdd   The number of nanoseconds to add.
	 * @return The {@link Instant} after adding the specified number of nanoseconds.
	 */
	public static Instant addNanos(Instant instant, int nanosToAdd) {
	    return instant.plusNanos(nanosToAdd);
	}

	/**
	 * Subtracts a specified number of nanoseconds from the given {@link Instant}.
	 *
	 * @param instant         The {@link Instant} from which nanoseconds are subtracted.
	 * @param nanosToSubtract The number of nanoseconds to subtract.
	 * @return The {@link Instant} after subtracting the specified number of nanoseconds.
	 */
	public static Instant subtractNanos(Instant instant, int nanosToSubtract) {
	    return instant.minusNanos(nanosToSubtract);
	}

	// MICRO SECOND

	/**
	 * Adds a specified number of microseconds to the given {@link Instant}.
	 *
	 * @param instant        The {@link Instant} to which microseconds are added.
	 * @param microsToAdd    The number of microseconds to add.
	 * @return The {@link Instant} after adding the specified number of microseconds.
	 */
	public static Instant addMicros(Instant instant, int microsToAdd) {
	    return instant.plus(microsToAdd, MICROS);
	}

	/**
	 * Subtracts a specified number of microseconds from the given {@link Instant}.
	 *
	 * @param instant            The {@link Instant} from which microseconds are subtracted.
	 * @param microsToSubtract   The number of microseconds to subtract.
	 * @return The {@link Instant} after subtracting the specified number of microseconds.
	 */
	public static Instant subtractMicros(Instant instant, int microsToSubtract) {
	    return instant.minus(microsToSubtract, MICROS);
	}

	// MILLI SECOND

	/**
	 * Adds a specified number of milliseconds to the given {@link Instant}.
	 *
	 * @param instant         The {@link Instant} to which milliseconds are added.
	 * @param millisToAdd     The number of milliseconds to add.
	 * @return The {@link Instant} after adding the specified number of milliseconds.
	 */
	public static Instant addMillis(Instant instant, int millisToAdd) {
	    return instant.plus(millisToAdd, MILLIS);
	}

	/**
	 * Subtracts a specified number of milliseconds from the given {@link Instant}.
	 *
	 * @param instant             The {@link Instant} from which milliseconds are subtracted.
	 * @param millisToSubtract    The number of milliseconds to subtract.
	 * @return The {@link Instant} after subtracting the specified number of milliseconds.
	 */
	public static Instant subtractMillis(Instant instant, int millisToSubtract) {
	    return instant.minus(millisToSubtract, MILLIS);
	}

	// SECOND

	/**
	 * Adds a specified number of seconds to the given {@link Instant}.
	 *
	 * @param instant          The {@link Instant} to which seconds are added.
	 * @param secondsToAdd     The number of seconds to add.
	 * @return The {@link Instant} after adding the specified number of seconds.
	 */
	public static Instant addSeconds(Instant instant, int secondsToAdd) {
	    return instant.plusSeconds(secondsToAdd);
	}

	/**
	 * Subtracts a specified number of seconds from the given {@link Instant}.
	 *
	 * @param instant              The {@link Instant} from which seconds are subtracted.
	 * @param secondsToSubtract    The number of seconds to subtract.
	 * @return The {@link Instant} after subtracting the specified number of seconds.
	 */
	public static Instant subtractSeconds(Instant instant, int secondsToSubtract) {
	    return instant.minusSeconds(secondsToSubtract);
	}

	// MINUTE

	/**
	 * Adds a specified number of minutes to the given {@link Instant}.
	 *
	 * @param instant          The {@link Instant} to which minutes are added.
	 * @param minutesToAdd     The number of minutes to add.
	 * @return The {@link Instant} after adding the specified number of minutes.
	 */
	public static Instant addMinutes(Instant instant, int minutesToAdd) {
	    return instant.plus(minutesToAdd, ChronoUnit.MINUTES);
	}

	/**
	 * Subtracts a specified number of minutes from the given {@link Instant}.
	 *
	 * @param instant              The {@link Instant} from which minutes are subtracted.
	 * @param minutesToSubtract    The number of minutes to subtract.
	 * @return The {@link Instant} after subtracting the specified number of minutes.
	 */
	public static Instant subtractmMinutes(Instant instant, int minutesToSubtract) {
	    return instant.minus(minutesToSubtract, ChronoUnit.MINUTES);
	}

	// HOUR

	/**
	 * Adds a specified number of hours to the given {@link Instant}.
	 *
	 * @param instant        The {@link Instant} to which hours are added.
	 * @param hoursToAdd     The number of hours to add.
	 * @return The {@link Instant} after adding the specified number of hours.
	 */
	public static Instant addHours(Instant instant, int hoursToAdd) {
	    return instant.plus(hoursToAdd, ChronoUnit.HOURS);
	}

	/**
	 * Subtracts a specified number of hours from the given {@link Instant}.
	 *
	 * @param instant            The {@link Instant} from which hours are subtracted.
	 * @param hoursToSubtract    The number of hours to subtract.
	 * @return The {@link Instant} after subtracting the specified number of hours.
	 */
	public static Instant subtractHours(Instant instant, int hoursToSubtract) {
	    return instant.minus(hoursToSubtract, ChronoUnit.HOURS);
	}

	// DAY

	/**
	 * Adds a specified number of days to the given {@link Instant}.
	 *
	 * @param instant        The {@link Instant} to which days are added.
	 * @param daysToAdd      The number of days to add.
	 * @return The {@link Instant} after adding the specified number of days.
	 */
	public static Instant addDays(Instant instant, int daysToAdd) {
	    return instant.plus(daysToAdd, ChronoUnit.DAYS);
	}

	/**
	 * Subtracts a specified number of days from the given {@link Instant}.
	 *
	 * @param instant          The {@link Instant} from which days are subtracted.
	 * @param daysToSubtract   The number of days to subtract.
	 * @return The {@link Instant} after subtracting the specified number of days.
	 */
	public static Instant subtractDays(Instant instant, int daysToSubtract) {
	    return instant.minus(daysToSubtract, ChronoUnit.DAYS);
	}

	// WEEK

	/**
	 * Adds a specified number of weeks to the given {@link Instant}.
	 *
	 * @param instant        The {@link Instant} to which weeks are added.
	 * @param weeksToAdd     The number of weeks to add.
	 * @return The {@link Instant} after adding the specified number of weeks.
	 */
	public static Instant addWeeks(Instant instant, int weeksToAdd) {
	    return instant.plus(weeksToAdd, ChronoUnit.WEEKS);
	}

	/**
	 * Subtracts a specified number of weeks from the given {@link Instant}.
	 *
	 * @param instant          The {@link Instant} from which weeks are subtracted.
	 * @param weeksToSubtract   The number of weeks to subtract.
	 * @return The {@link Instant} after subtracting the specified number of weeks.
	 */
	public static Instant subtractWeeks(Instant instant, int weeksToSubtract) {
	    return instant.minus(weeksToSubtract, ChronoUnit.WEEKS);
	}

	// MONTH

	/**
	 * Adds a specified number of months to the given {@link Instant}.
	 *
	 * @param instant          The {@link Instant} to which months are added.
	 * @param monthsToAdd      The number of months to add.
	 * @return The {@link Instant} after adding the specified number of months.
	 */
	public static Instant addMonths(Instant instant, int monthsToAdd) {
	    return instant.plus(monthsToAdd, ChronoUnit.MONTHS);
	}

	/**
	 * Subtracts a specified number of months from the given {@link Instant}.
	 *
	 * @param instant            The {@link Instant} from which months are subtracted.
	 * @param monthsToSubtract   The number of months to subtract.
	 * @return The {@link Instant} after subtracting the specified number of months.
	 */
	public static Instant subtractMonths(Instant instant, int monthsToSubtract) {
	    return instant.minus(monthsToSubtract, ChronoUnit.MONTHS);
	}

	/**
	 * Returns the first day of the month for the given {@link Instant}.
	 *
	 * @param instant The {@link Instant} for which the first day of the month is calculated.
	 * @return The {@link Instant} representing the first day of the month.
	 */
	public static Instant firstDayOfMonth(Instant instant) {
	    return instant.with(TemporalAdjusters.firstDayOfMonth());
	}

	/**
	 * Returns the last day of the month for the given {@link Instant}.
	 *
	 * @param instant The {@link Instant} for which the last day of the month is calculated.
	 * @return The {@link Instant} representing the last day of the month.
	 */
	public static Instant lastDayOfMonth(Instant instant) {
	    return instant.with(TemporalAdjusters.lastDayOfMonth());
	}

	/**
	 * Returns the first day of the month following the given {@link Instant}.
	 *
	 * @param instant The {@link Instant} for which the first day of the next month is calculated.
	 * @return The {@link Instant} representing the first day of the next month.
	 */
	public static Instant firstDayOfNextMonth(Instant instant) {
	    return addMonths(instant, 1).with(TemporalAdjusters.firstDayOfMonth());
	}

	/**
	 * Returns the last day of the month following the given {@link Instant}.
	 *
	 * @param instant The {@link Instant} for which the last day of the next month is calculated.
	 * @return The {@link Instant} representing the last day of the next month.
	 */
	public static Instant lastDayOfNextMonth(Instant instant) {
	    return addMonths(instant, 1).with(TemporalAdjusters.lastDayOfMonth());
	}

	/**
	 * Returns the first day of the month preceding the given {@link Instant}.
	 *
	 * @param instant The {@link Instant} for which the first day of the previous month is calculated.
	 * @return The {@link Instant} representing the first day of the previous month.
	 */
	public static Instant firstDayOfPreviousMonth(Instant instant) {
	    return subtractMonths(instant, 1).with(TemporalAdjusters.firstDayOfMonth());
	}

	/**
	 * Returns the last day of the month preceding the given {@link Instant}.
	 *
	 * @param instant The {@link Instant} for which the last day of the previous month is calculated.
	 * @return The {@link Instant} representing the last day of the previous month.
	 */
	public static Instant lastDayOfPreviousMonth(Instant instant) {
	    return subtractMonths(instant, 1).with(TemporalAdjusters.lastDayOfMonth());
	}
	
	// YEAR
	
	/**
	 * Adds a specified number of years to the given {@link Instant}.
	 *
	 * @param instant       The {@link Instant} to which years are added.
	 * @param yearsToAdd    The number of years to add.
	 * @return The {@link Instant} after adding the specified number of years.
	 */
	public static Instant addYears(Instant instant, int yearsToAdd) {
	    return instant.plus(yearsToAdd, ChronoUnit.YEARS);
	}

	/**
	 * Subtracts a specified number of years from the given {@link Instant}.
	 *
	 * @param instant           The {@link Instant} from which years are subtracted.
	 * @param yearsToSubtract   The number of years to subtract.
	 * @return The {@link Instant} after subtracting the specified number of years.
	 */
	public static Instant subtractYears(Instant instant, int yearsToSubtract) {
	    return instant.minus(yearsToSubtract, ChronoUnit.YEARS);
	}

	/**
	 * Returns the first day of the year for the given {@link Instant}.
	 *
	 * @param instant The {@link Instant} for which the first day of the year is calculated.
	 * @return The {@link Instant} representing the first day of the year.
	 */
	public static Instant firstDayOfYear(Instant instant) {
	    return instant.with(TemporalAdjusters.firstDayOfYear());
	}

	/**
	 * Returns the last day of the year for the given {@link Instant}.
	 *
	 * @param instant The {@link Instant} for which the last day of the year is calculated.
	 * @return The {@link Instant} representing the last day of the year.
	 */
	public static Instant lastDayOfYear(Instant instant) {
	    return instant.with(TemporalAdjusters.lastDayOfYear());
	}

	/**
	 * Returns the first day of the year following the given {@link Instant}.
	 *
	 * @param instant The {@link Instant} for which the first day of the next year is calculated.
	 * @return The {@link Instant} representing the first day of the next year.
	 */
	public static Instant firstDayOfNextYear(Instant instant) {
	    return addYears(instant, 1).with(TemporalAdjusters.firstDayOfYear());
	}

	/**
	 * Returns the last day of the year following the given {@link Instant}.
	 *
	 * @param instant The {@link Instant} for which the last day of the next year is calculated.
	 * @return The {@link Instant} representing the last day of the next year.
	 */
	public static Instant lastDayOfNextYear(Instant instant) {
	    return addYears(instant, 1).with(TemporalAdjusters.lastDayOfYear());
	}

	/**
	 * Returns the first day of the year preceding the given {@link Instant}.
	 *
	 * @param instant The {@link Instant} for which the first day of the previous year is calculated.
	 * @return The {@link Instant} representing the first day of the previous year.
	 */
	public static Instant firstDayOfPreviousYear(Instant instant) {
	    return subtractYears(instant, 1).with(TemporalAdjusters.firstDayOfYear());
	}

	/**
	 * Returns the last day of the year preceding the given {@link Instant}.
	 *
	 * @param instant The {@link Instant} for which the last day of the previous year is calculated.
	 * @return The {@link Instant} representing the last day of the previous year.
	 */
	public static Instant lastDayOfPreviousYear(Instant instant) {
	    return subtractYears(instant, 1).with(TemporalAdjusters.lastDayOfYear());
	}
	
	// COMPARE
	
	/**
	 * Checks if two {@link Instant} objects represent the same point in time.
	 *
	 * @param instantLeft  The first {@link Instant} to compare.
	 * @param instantRight The second {@link Instant} to compare.
	 * @return {@code true} if the two {@link Instant} objects are equal, {@code false} otherwise.
	 */
	public static boolean isEquals(Instant instantLeft, Instant instantRight) {
	    return instantLeft.equals(instantRight);
	}

	/**
	 * Checks if two {@link Instant} objects do not represent the same point in time.
	 *
	 * @param instantLeft  The first {@link Instant} to compare.
	 * @param instantRight The second {@link Instant} to compare.
	 * @return {@code true} if the two {@link Instant} objects are not equal, {@code false} otherwise.
	 */
	public static boolean isNotEquals(Instant instantLeft, Instant instantRight) {
	    return !instantLeft.equals(instantRight);
	}

	/**
	 * Checks if the first {@link Instant} is before the second {@link Instant}.
	 *
	 * @param instantLeft  The {@link Instant} to check if it is before the second {@link Instant}.
	 * @param instantRight The {@link Instant} to check if it is after the first {@link Instant}.
	 * @return {@code true} if the first {@link Instant} is before the second {@link Instant}, {@code false} otherwise.
	 */
	public static boolean isBefore(Instant instantLeft, Instant instantRight) {
	    return instantLeft.isBefore(instantRight);
	}

	/**
	 * Checks if the first {@link Instant} is after the second {@link Instant}.
	 *
	 * @param instantLeft  The {@link Instant} to check if it is after the second {@link Instant}.
	 * @param instantRight The {@link Instant} to check if it is before the first {@link Instant}.
	 * @return {@code true} if the first {@link Instant} is after the second {@link Instant}, {@code false} otherwise.
	 */
	public static boolean isAfter(Instant instantLeft, Instant instantRight) {
	    return instantLeft.isAfter(instantRight);
	}

	/**
	 * Checks if the first {@link Instant} is before or equal to the second {@link Instant}.
	 *
	 * @param instantLeft  The {@link Instant} to check if it is before or equal to the second {@link Instant}.
	 * @param instantRight The {@link Instant} to check if it is after or equal to the first {@link Instant}.
	 * @return {@code true} if the first {@link Instant} is before or equal to the second {@link Instant}, {@code false} otherwise.
	 */
	public static boolean isBeforeOrEquals(Instant instantLeft, Instant instantRight) {
	    return instantLeft.compareTo(instantRight) <= 0;
	}

	/**
	 * Checks if the first {@link Instant} is after or equal to the second {@link Instant}.
	 *
	 * @param instantLeft  The {@link Instant} to check if it is after or equal to the second {@link Instant}.
	 * @param instantRight The {@link Instant} to check if it is before or equal to the first {@link Instant}.
	 * @return {@code true} if the first {@link Instant} is after or equal to the second {@link Instant}, {@code false} otherwise.
	 */
	public static boolean isAfterOrEquals(Instant instantLeft, Instant instantRight) {
	    return instantLeft.compareTo(instantRight) >= 0;
	}

	/**
	 * Checks if a {@link Instant} is between two other {@link Instant} objects inclusively.
	 *
	 * @param left     The left boundary {@link Instant}.
	 * @param between  The {@link Instant} to check if it is between the left and right boundaries.
	 * @param right    The right boundary {@link Instant}.
	 * @return {@code true} if the {@link Instant} is between the left and right boundaries (inclusive), {@code false} otherwise.
	 */
	public static boolean isBetweenInclusive(Instant left, Instant between, Instant right) {
	    return isBeforeOrEquals(left, between) && isBeforeOrEquals(between, right);
	}

	/**
	 * Checks if a {@link Instant} is between two other {@link Instant} objects exclusively.
	 *
	 * @param left     The left boundary {@link Instant}.
	 * @param between  The {@link Instant} to check if it is between the left and right boundaries.
	 * @param right    The right boundary {@link Instant}.
	 * @return {@code true} if the {@link Instant} is between the left and right boundaries (exclusive), {@code false} otherwise.
	 */
	public static boolean isBetweenExclusive(Instant left, Instant between, Instant right) {
	    return isBefore(left, between) && isBefore(between, right);
	}
	
	// IS SPECIFIC DATE
	
	/**
	 * Checks if the provided {@link Instant} corresponds to the first day of the month.
	 *
	 * @param instant The {@link Instant} to check.
	 * @return {@code true} if the provided {@link Instant} is the first day of the month, {@code false} otherwise.
	 */
	public static boolean isFirstDayOfMonth(Instant instant) {
	    return LocalDateTimeUtils.isFirstDayOfMonth(toLocalDateTime(instant));
	}

	/**
	 * Checks if the provided {@link Instant} corresponds to the last day of the month.
	 *
	 * @param instant The {@link Instant} to check.
	 * @return {@code true} if the provided {@link Instant} is the last day of the month, {@code false} otherwise.
	 */
	public static boolean isLastDayOfMonth(Instant instant) {
	    return LocalDateTimeUtils.isLastDayOfMonth(toLocalDateTime(instant));
	}

	/**
	 * Checks if the provided {@link Instant} corresponds to the first day of the year.
	 *
	 * @param instant The {@link Instant} to check.
	 * @return {@code true} if the provided {@link Instant} is the first day of the year, {@code false} otherwise.
	 */
	public static boolean isFirstDayOfTheYear(Instant instant) {
	    return LocalDateTimeUtils.isFirstDayOfTheYear(toLocalDateTime(instant));
	}

	/**
	 * Checks if the provided {@link Instant} corresponds to the last day of the year.
	 *
	 * @param instant The {@link Instant} to check.
	 * @return {@code true} if the provided {@link Instant} is the last day of the year, {@code false} otherwise.
	 */
	public static boolean isLastDayOfTheYear(Instant instant) {
	    return LocalDateTimeUtils.isLastDayOfTheYear(toLocalDateTime(instant));
	}
	
	/**
	 * Checks if the month of the given {@link Instant} at UTC is January.
	 *
	 * @param instant The {@link Instant} to check.
	 * @return true if the month of the {@link Instant} at UTC is January.
	 */
	public static boolean isJanuary(Instant instant) {
	    return LocalDateTimeUtils.isJanuary(toLocalDateTime(instant));
	}

	/**
	 * Checks if the month of the given {@link Instant} at UTC is February.
	 *
	 * @param instant The {@link Instant} to check.
	 * @return true if the month of the {@link Instant} at UTC is February.
	 */
	public static boolean isFebruary(Instant instant) {
	    return LocalDateTimeUtils.isFebruary(toLocalDateTime(instant));
	}

	/**
	 * Checks if the month of the given {@link Instant} at UTC is March.
	 *
	 * @param instant The {@link Instant} to check.
	 * @return true if the month of the {@link Instant} at UTC is March.
	 */
	public static boolean isMarch(Instant instant) {
	    return LocalDateTimeUtils.isMarch(toLocalDateTime(instant));
	}

	/**
	 * Checks if the month of the given {@link Instant} at UTC is April.
	 *
	 * @param instant The {@link Instant} to check.
	 * @return true if the month of the {@link Instant} at UTC is April.
	 */
	public static boolean isApril(Instant instant) {
	    return LocalDateTimeUtils.isApril(toLocalDateTime(instant));
	}

	/**
	 * Checks if the month of the given {@link Instant} at UTC is May.
	 *
	 * @param instant The {@link Instant} to check.
	 * @return true if the month of the {@link Instant} at UTC is May.
	 */
	public static boolean isMay(Instant instant) {
	    return LocalDateTimeUtils.isMay(toLocalDateTime(instant));
	}

	/**
	 * Checks if the month of the given {@link Instant} at UTC is June.
	 *
	 * @param instant The {@link Instant} to check.
	 * @return true if the month of the {@link Instant} at UTC is June.
	 */
	public static boolean isJune(Instant instant) {
	    return LocalDateTimeUtils.isJune(toLocalDateTime(instant));
	}

	/**
	 * Checks if the month of the given {@link Instant} at UTC is July.
	 *
	 * @param instant The {@link Instant} to check.
	 * @return true if the month of the {@link Instant} at UTC is July.
	 */
	public static boolean isJuly(Instant instant) {
	    return LocalDateTimeUtils.isJuly(toLocalDateTime(instant));
	}

	/**
	 * Checks if the month of the given {@link Instant} at UTC is August.
	 *
	 * @param instant The {@link Instant} to check.
	 * @return true if the month of the {@link Instant} at UTC is August.
	 */
	public static boolean isAugust(Instant instant) {
	    return LocalDateTimeUtils.isAugust(toLocalDateTime(instant));
	}

	/**
	 * Checks if the month of the given {@link Instant} at UTC is September.
	 *
	 * @param instant The {@link Instant} to check.
	 * @return true if the month of the {@link Instant} at UTC is September.
	 */
	public static boolean isSeptember(Instant instant) {
	    return LocalDateTimeUtils.isSeptember(toLocalDateTime(instant));
	}

	/**
	 * Checks if the month of the given {@link Instant} at UTC is October.
	 *
	 * @param instant The {@link Instant} to check.
	 * @return true if the month of the {@link Instant} at UTC is October.
	 */
	public static boolean isOctober(Instant instant) {
	    return LocalDateTimeUtils.isOctober(toLocalDateTime(instant));
	}

	/**
	 * Checks if the month of the given {@link Instant} at UTC is November.
	 *
	 * @param instant The {@link Instant} to check.
	 * @return true if the month of the {@link Instant} at UTC is November.
	 */
	public static boolean isNovember(Instant instant) {
	    return LocalDateTimeUtils.isNovember(toLocalDateTime(instant));
	}

	/**
	 * Checks if the month of the given {@link Instant} at UTC is December.
	 *
	 * @param instant The {@link Instant} to check.
	 * @return true if the month of the {@link Instant} at UTC is December.
	 */
	public static boolean isDecember(Instant instant) {
	    return LocalDateTimeUtils.isDecember(toLocalDateTime(instant));
	}

	// SET SPECIFIC DATE

	/**
	 * Builds an {@link Instant} based on the specified {@link LocalDate}, {@link LocalTime}, and {@link ZoneOffset}.
	 *
	 * @param date       The {@link LocalDate}.
	 * @param time       The {@link LocalTime}.
	 * @param zoneOffset The {@link ZoneOffset}.
	 * @return An {@link Instant} representing the specified date and time at the given {@link ZoneOffset}.
	 */
	public static Instant buildInstant(LocalDate date, LocalTime time, ZoneOffset zoneOffset) {
	    LocalDateTime localDateTime = LocalDateTime.of(date, time);
	    return toInstant(localDateTime, zoneOffset);
	}

	/**
	 * Builds an {@link Instant} based on the specified {@link LocalDateTime} and {@link ZoneOffset}.
	 *
	 * @param localDateTime The {@link LocalDateTime}.
	 * @param zoneOffset    The {@link ZoneOffset}.
	 * @return An {@link Instant} representing the specified date and time at the given {@link ZoneOffset}.
	 */
	public static Instant buildInstant(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
	    return toInstant(localDateTime, zoneOffset);
	}

	/**
	 * Builds an {@link Instant} based on the specified {@link LocalDate}, {@link LocalTime}, and {@link ZoneId}.
	 *
	 * @param date   The {@link LocalDate}.
	 * @param time   The {@link LocalTime}.
	 * @param zoneId The {@link ZoneId}.
	 * @return An {@link Instant} representing the specified date and time at the given {@link ZoneId}.
	 */
	public static Instant buildInstant(LocalDate date, LocalTime time, ZoneId zoneId) {
	    return LocalDateTime.of(date, time).atZone(zoneId).toInstant();
	}

	/**
	 * Builds an {@link Instant} based on the specified {@link LocalDateTime} and {@link ZoneId}.
	 *
	 * @param localDateTime The {@link LocalDateTime}.
	 * @param zoneId        The {@link ZoneId}.
	 * @return An {@link Instant} representing the specified date and time at the given {@link ZoneId}.
	 */
	public static Instant buildInstant(LocalDateTime localDateTime, ZoneId zoneId) {
	    return localDateTime.atZone(zoneId).toInstant();
	}

	/**
	 * Builds an {@link Instant} based on the specified year, month, day, hour, and minute.
	 *
	 * @param year   The year.
	 * @param month  The month.
	 * @param day    The day.
	 * @param hour   The hour.
	 * @param minute The minute.
	 * @return An {@link Instant} representing the specified date and time.
	 */
	public static Instant buildInstant(int year, int month, int day, int hour, int minute) {
	    LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute);
	    return toInstant(localDateTime);
	}

	/**
	 * Builds an {@link Instant} based on the specified year, month, day, hour, minute, and second.
	 *
	 * @param year   The year.
	 * @param month  The month.
	 * @param day    The day.
	 * @param hour   The hour.
	 * @param minute The minute.
	 * @param second The second.
	 * @return An {@link Instant} representing the specified date and time.
	 */
	public static Instant buildInstant(int year, int month, int day, int hour, int minute, int second) {
	    LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute, second);
	    return toInstant(localDateTime);
	}

	/**
	 * Changes the day of the month in the given {@link Instant}.
	 *
	 * @param instant The {@link Instant} to modify.
	 * @param day     The new day of the month.
	 * @return An {@link Instant} with the modified day.
	 */
	public static Instant changeDay(Instant instant, int day) {
	    LocalDateTime localDateTime = LocalDateTimeUtils.changeDay(toLocalDateTime(instant), day);
	    return toInstant(localDateTime);
	}

	/**
	 * Changes the month and day of the month in the given {@link Instant}.
	 *
	 * @param instant The {@link Instant} to modify.
	 * @param month   The new month.
	 * @param day     The new day of the month.
	 * @return An {@link Instant} with the modified month and day.
	 */
	public static Instant changeMonthAndDay(Instant instant, int month, int day) {
	    LocalDateTime localDateTime = LocalDateTimeUtils.changeMonthAndDay(toLocalDateTime(instant), month, day);
	    return toInstant(localDateTime);
	}

	/**
	 * Changes the second of the minute in the given {@link Instant}.
	 *
	 * @param instant The {@link Instant} to modify.
	 * @param second  The new second of the minute.
	 * @return An {@link Instant} with the modified second.
	 */
	public static Instant changeSecond(Instant instant, int second) {
	    LocalDateTime localDateTime = LocalDateTimeUtils.changeSecond(toLocalDateTime(instant), second);
	    return toInstant(localDateTime);
	}

	/**
	 * Changes the minute of the hour in the given {@link Instant}.
	 *
	 * @param instant The {@link Instant} to modify.
	 * @param minute  The new minute of the hour.
	 * @return An {@link Instant} with the modified minute.
	 */
	public static Instant changeMinute(Instant instant, int minute) {
	    LocalDateTime localDateTime = LocalDateTimeUtils.changeMinute(toLocalDateTime(instant), minute);
	    return toInstant(localDateTime);
	}

	/**
	 * Changes the hour of the day in the given {@link Instant}.
	 *
	 * @param instant The {@link Instant} to modify.
	 * @param hour    The new hour of the day.
	 * @return An {@link Instant} with the modified hour.
	 */
	public static Instant changeHour(Instant instant, int hour) {
	    LocalDateTime localDateTime = LocalDateTimeUtils.changeHour(toLocalDateTime(instant), hour);
	    return toInstant(localDateTime);
	}

	/**
	 * Changes the hour, minute, and second in the given {@link Instant}.
	 *
	 * @param instant The {@link Instant} to modify.
	 * @param hour    The new hour of the day.
	 * @param minute  The new minute of the hour.
	 * @param second  The new second of the minute.
	 * @return An {@link Instant} with the modified hour, minute, and second.
	 */
	public static Instant changeHourMinuteSecond(Instant instant, int hour, int minute, int second) {
	    LocalDateTime localDateTime = LocalDateTimeUtils.changeHourMinuteSecond(toLocalDateTime(instant), hour, minute, second);
	    return toInstant(localDateTime);
	}

	/**
	 * Converts the given {@link Instant} to {@link LocalDateTime} at UTC.
	 *
	 * @param instant The {@link Instant} to convert.
	 * @return The {@link LocalDateTime} at UTC.
	 */
	private static LocalDateTime toLocalDateTime(Instant instant) {
	    return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
	}

	/**
	 * Converts the given {@link LocalDateTime} at UTC to {@link Instant}.
	 *
	 * @param localDateTime The {@link LocalDateTime} to convert.
	 * @return The {@link Instant} at UTC.
	 */
	private static Instant toInstant(LocalDateTime localDateTime) {
	    return toInstant(localDateTime, ZoneOffset.UTC);
	}

	/**
	 * Converts the given {@link LocalDateTime} at the specified {@link ZoneOffset} to {@link Instant}.
	 *
	 * @param localDateTime The {@link LocalDateTime} to convert.
	 * @param zoneOffset    The {@link ZoneOffset}.
	 * @return The {@link Instant} at the specified {@link ZoneOffset}.
	 */
	private static Instant toInstant(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
	    return localDateTime.toInstant(zoneOffset);
	}
	
}