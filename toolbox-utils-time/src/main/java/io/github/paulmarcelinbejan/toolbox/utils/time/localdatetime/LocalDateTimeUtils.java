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
 * Utility class for handling operations related to LocalDateTime.
 * Be aware that LocalDateTime is time-zone agnostic!
 * This class provides various static methods for LocalDateTime manipulation and functionality.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocalDateTimeUtils {

	// NANO SECOND
	
	/**
	 * Adds the specified number of nanoseconds to the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime to which nanoseconds are added.
	 * @param nanosToAdd The number of nanoseconds to add.
	 * @return The LocalDateTime resulting from the addition of nanoseconds.
	 */
	public static LocalDateTime addNanos(LocalDateTime localDateTime, int nanosToAdd) {
	    return localDateTime.plusNanos(nanosToAdd);
	}

	/**
	 * Subtracts the specified number of nanoseconds from the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime from which nanoseconds are subtracted.
	 * @param nanosToSubtract The number of nanoseconds to subtract.
	 * @return The LocalDateTime resulting from the subtraction of nanoseconds.
	 */
	public static LocalDateTime subtractNanos(LocalDateTime localDateTime, int nanosToSubtract) {
	    return localDateTime.minusNanos(nanosToSubtract);
	}
	
	// MICRO SECOND
	
	/**
	 * Adds the specified number of microseconds to the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime to which microseconds are added.
	 * @param microsToAdd The number of microseconds to add.
	 * @return The LocalDateTime resulting from the addition of microseconds.
	 */
	public static LocalDateTime addMicros(LocalDateTime localDateTime, int microsToAdd) {
	    return localDateTime.plus(microsToAdd, MICROS);
	}

	/**
	 * Subtracts the specified number of microseconds from the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime from which microseconds are subtracted.
	 * @param microsToSubtract The number of microseconds to subtract.
	 * @return The LocalDateTime resulting from the subtraction of microseconds.
	 */
	public static LocalDateTime subtractMicros(LocalDateTime localDateTime, int microsToSubtract) {
	    return localDateTime.minus(microsToSubtract, MICROS);
	}
	
	// MILLI SECOND
	
	/**
	 * Adds the specified number of milliseconds to the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime to which milliseconds are added.
	 * @param millisToAdd The number of milliseconds to add.
	 * @return The LocalDateTime resulting from the addition of milliseconds.
	 */
	public static LocalDateTime addMillis(LocalDateTime localDateTime, int millisToAdd) {
	    return localDateTime.plus(millisToAdd, MILLIS);
	}

	/**
	 * Subtracts the specified number of milliseconds from the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime from which milliseconds are subtracted.
	 * @param millisToSubtract The number of milliseconds to subtract.
	 * @return The LocalDateTime resulting from the subtraction of milliseconds.
	 */
	public static LocalDateTime subtractMillis(LocalDateTime localDateTime, int millisToSubtract) {
	    return localDateTime.minus(millisToSubtract, MILLIS);
	}
	
	// SECOND
	
	/**
	 * Adds the specified number of seconds to the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime to which seconds are added.
	 * @param secondsToAdd The number of seconds to add.
	 * @return The LocalDateTime resulting from the addition of seconds.
	 */
	public static LocalDateTime addSeconds(LocalDateTime localDateTime, int secondsToAdd) {
	    return localDateTime.plusSeconds(secondsToAdd);
	}

	/**
	 * Subtracts the specified number of seconds from the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime from which seconds are subtracted.
	 * @param secondsToSubtract The number of seconds to subtract.
	 * @return The LocalDateTime resulting from the subtraction of seconds.
	 */
	public static LocalDateTime subtractSeconds(LocalDateTime localDateTime, int secondsToSubtract) {
	    return localDateTime.minusSeconds(secondsToSubtract);
	}
	
	// MINUTE
	
	/**
	 * Adds the specified number of minutes to the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime to which minutes are added.
	 * @param minutesToAdd The number of minutes to add.
	 * @return The LocalDateTime resulting from the addition of minutes.
	 */
	public static LocalDateTime addMinutes(LocalDateTime localDateTime, int minutesToAdd) {
	    return localDateTime.plusMinutes(minutesToAdd);
	}

	/**
	 * Subtracts the specified number of minutes from the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime from which minutes are subtracted.
	 * @param minutesToSubtract The number of minutes to subtract.
	 * @return The LocalDateTime resulting from the subtraction of minutes.
	 */
	public static LocalDateTime subtractMinutes(LocalDateTime localDateTime, int minutesToSubtract) {
	    return localDateTime.minusMinutes(minutesToSubtract);
	}
	
	// HOUR
	
	/**
	 * Adds the specified number of hours to the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime to which hours are added.
	 * @param hoursToAdd The number of hours to add.
	 * @return The LocalDateTime resulting from the addition of hours.
	 */
	public static LocalDateTime addHours(LocalDateTime localDateTime, int hoursToAdd) {
	    return localDateTime.plusHours(hoursToAdd);
	}

	/**
	 * Subtracts the specified number of hours from the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime from which hours are subtracted.
	 * @param hoursToSubtract The number of hours to subtract.
	 * @return The LocalDateTime resulting from the subtraction of hours.
	 */
	public static LocalDateTime subtractHours(LocalDateTime localDateTime, int hoursToSubtract) {
	    return localDateTime.minusHours(hoursToSubtract);
	}
	
	// DAY
	
	/**
	 * Adds the specified number of days to the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime to which days are added.
	 * @param daysToAdd The number of days to add.
	 * @return The LocalDateTime resulting from the addition of days.
	 */
	public static LocalDateTime addDays(LocalDateTime localDateTime, int daysToAdd) {
	    return localDateTime.plusDays(daysToAdd);
	}

	/**
	 * Subtracts the specified number of days from the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime from which days are subtracted.
	 * @param daysToSubtract The number of days to subtract.
	 * @return The LocalDateTime resulting from the subtraction of days.
	 */
	public static LocalDateTime subtractDays(LocalDateTime localDateTime, int daysToSubtract) {
	    return localDateTime.minusDays(daysToSubtract);
	}
	
	// WEEK
	
	/**
	 * Adds the specified number of weeks to the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime to which weeks are added.
	 * @param weeksToAdd The number of weeks to add.
	 * @return The LocalDateTime resulting from the addition of weeks.
	 */
	public static LocalDateTime addWeeks(LocalDateTime localDateTime, int weeksToAdd) {
	    return localDateTime.plusWeeks(weeksToAdd);
	}

	/**
	 * Subtracts the specified number of weeks from the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime from which weeks are subtracted.
	 * @param weeksToSubtract The number of weeks to subtract.
	 * @return The LocalDateTime resulting from the subtraction of weeks.
	 */
	public static LocalDateTime subtractWeeks(LocalDateTime localDateTime, int weeksToSubtract) {
	    return localDateTime.minusWeeks(weeksToSubtract);
	}
	
	// MONTH
	
	/**
	 * Adds the specified number of months to the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime to which months are added.
	 * @param monthsToAdd The number of months to add.
	 * @return The LocalDateTime resulting from the addition of months.
	 */
	public static LocalDateTime addMonths(LocalDateTime localDateTime, int monthsToAdd) {
	    return localDateTime.plusMonths(monthsToAdd);
	}

	/**
	 * Subtracts the specified number of months from the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime from which months are subtracted.
	 * @param monthsToSubtract The number of months to subtract.
	 * @return The LocalDateTime resulting from the subtraction of months.
	 */
	public static LocalDateTime subtractMonths(LocalDateTime localDateTime, int monthsToSubtract) {
	    return localDateTime.minusMonths(monthsToSubtract);
	}

	/**
	 * Returns the LocalDateTime representing the first day of the month for the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime for which to find the first day of the month.
	 * @return The LocalDateTime representing the first day of the month.
	 */
	public static LocalDateTime firstDayOfMonth(LocalDateTime localDateTime) {
	    return localDateTime.with(TemporalAdjusters.firstDayOfMonth());
	}

	/**
	 * Returns the LocalDateTime representing the last day of the month for the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime for which to find the last day of the month.
	 * @return The LocalDateTime representing the last day of the month.
	 */
	public static LocalDateTime lastDayOfMonth(LocalDateTime localDateTime) {
	    return localDateTime.with(TemporalAdjusters.lastDayOfMonth());
	}

	/**
	 * Returns the LocalDateTime representing the first day of the next month for the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime for which to find the first day of the next month.
	 * @return The LocalDateTime representing the first day of the next month.
	 */
	public static LocalDateTime firstDayOfNextMonth(LocalDateTime localDateTime) {
	    return localDateTime.plusMonths(1)
	    					.with(TemporalAdjusters.firstDayOfMonth());
	}

	/**
	 * Returns the LocalDateTime representing the last day of the next month for the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime for which to find the last day of the next month.
	 * @return The LocalDateTime representing the last day of the next month.
	 */
	public static LocalDateTime lastDayOfNextMonth(LocalDateTime localDateTime) {
	    return localDateTime.plusMonths(1)
	    					.with(TemporalAdjusters.lastDayOfMonth());
	}

	/**
	 * Returns the LocalDateTime representing the first day of the previous month for the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime for which to find the first day of the previous month.
	 * @return The LocalDateTime representing the first day of the previous month.
	 */
	public static LocalDateTime firstDayOfPreviousMonth(LocalDateTime localDateTime) {
	    return localDateTime.minusMonths(1)
	    					.with(TemporalAdjusters.firstDayOfMonth());
	}

	/**
	 * Returns the LocalDateTime representing the last day of the previous month for the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime for which to find the last day of the previous month.
	 * @return The LocalDateTime representing the last day of the previous month.
	 */
	public static LocalDateTime lastDayOfPreviousMonth(LocalDateTime localDateTime) {
	    return localDateTime.minusMonths(1)
	    					.with(TemporalAdjusters.lastDayOfMonth());
	}
	
	// YEAR
	
	/**
	 * Adds the specified number of years to the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime to which years are added.
	 * @param yearsToAdd The number of years to add.
	 * @return The LocalDateTime resulting from the addition of years.
	 */
	public static LocalDateTime addYears(LocalDateTime localDateTime, int yearsToAdd) {
	    return localDateTime.plusYears(yearsToAdd);
	}

	/**
	 * Subtracts the specified number of years from the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime from which years are subtracted.
	 * @param yearsToSubtract The number of years to subtract.
	 * @return The LocalDateTime resulting from the subtraction of years.
	 */
	public static LocalDateTime subtractYears(LocalDateTime localDateTime, int yearsToSubtract) {
	    return localDateTime.minusYears(yearsToSubtract);
	}

	/**
	 * Returns the LocalDateTime representing the first day of the year for the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime for which to find the first day of the year.
	 * @return The LocalDateTime representing the first day of the year.
	 */
	public static LocalDateTime firstDayOfYear(LocalDateTime localDateTime) {
	    return localDateTime.with(TemporalAdjusters.firstDayOfYear());
	}

	/**
	 * Returns the LocalDateTime representing the last day of the year for the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime for which to find the last day of the year.
	 * @return The LocalDateTime representing the last day of the year.
	 */
	public static LocalDateTime lastDayOfYear(LocalDateTime localDateTime) {
	    return localDateTime.with(TemporalAdjusters.lastDayOfYear());
	}

	/**
	 * Returns the LocalDateTime representing the first day of the next year for the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime for which to find the first day of the next year.
	 * @return The LocalDateTime representing the first day of the next year.
	 */
	public static LocalDateTime firstDayOfNextYear(LocalDateTime localDateTime) {
	    return localDateTime.plusYears(1)
	    					.with(TemporalAdjusters.firstDayOfYear());
	}

	/**
	 * Returns the LocalDateTime representing the last day of the next year for the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime for which to find the last day of the next year.
	 * @return The LocalDateTime representing the last day of the next year.
	 */
	public static LocalDateTime lastDayOfNextYear(LocalDateTime localDateTime) {
	    return localDateTime.plusYears(1)
	    					.with(TemporalAdjusters.lastDayOfYear());
	}

	/**
	 * Returns the LocalDateTime representing the first day of the previous year for the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime for which to find the first day of the previous year.
	 * @return The LocalDateTime representing the first day of the previous year.
	 */
	public static LocalDateTime firstDayOfPreviousYear(LocalDateTime localDateTime) {
	    return localDateTime.minusYears(1)
	    					.with(TemporalAdjusters.firstDayOfYear());
	}

	/**
	 * Returns the LocalDateTime representing the last day of the previous year for the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime for which to find the last day of the previous year.
	 * @return The LocalDateTime representing the last day of the previous year.
	 */
	public static LocalDateTime lastDayOfPreviousYear(LocalDateTime localDateTime) {
	    return localDateTime.minusYears(1)
	    					.with(TemporalAdjusters.lastDayOfYear());
	}
	
	// COMPARE
	
	/**
	 * Checks if two LocalDateTime objects are equal.
	 *
	 * @param localDateTimeLeft The first LocalDateTime object to compare.
	 * @param localDateTimeRight The second LocalDateTime object to compare.
	 * @return true if the two LocalDateTime objects are equal, false otherwise.
	 */
	public static boolean isEquals(LocalDateTime localDateTimeLeft, LocalDateTime localDateTimeRight) {
	    return localDateTimeLeft.equals(localDateTimeRight);
	}

	/**
	 * Checks if two LocalDateTime objects are not equal.
	 *
	 * @param localDateTimeLeft The first LocalDateTime object to compare.
	 * @param localDateTimeRight The second LocalDateTime object to compare.
	 * @return true if the two LocalDateTime objects are not equal, false otherwise.
	 */
	public static boolean isNotEquals(LocalDateTime localDateTimeLeft, LocalDateTime localDateTimeRight) {
	    return !localDateTimeLeft.equals(localDateTimeRight);
	}

	/**
	 * Checks if the first LocalDateTime is before the second LocalDateTime.
	 *
	 * @param localDateTimeLeft The LocalDateTime to check if it is before.
	 * @param localDateTimeRight The LocalDateTime to check if it is after.
	 * @return true if the first LocalDateTime is before the second LocalDateTime, false otherwise.
	 */
	public static boolean isBefore(LocalDateTime localDateTimeLeft, LocalDateTime localDateTimeRight) {
	    return localDateTimeLeft.isBefore(localDateTimeRight);
	}

	/**
	 * Checks if the first LocalDateTime is after the second LocalDateTime.
	 *
	 * @param localDateTimeLeft The LocalDateTime to check if it is after.
	 * @param localDateTimeRight The LocalDateTime to check if it is before.
	 * @return true if the first LocalDateTime is after the second LocalDateTime, false otherwise.
	 */
	public static boolean isAfter(LocalDateTime localDateTimeLeft, LocalDateTime localDateTimeRight) {
	    return localDateTimeLeft.isAfter(localDateTimeRight);
	}

	/**
	 * Checks if the first LocalDateTime is before or equal to the second LocalDateTime.
	 *
	 * @param localDateTimeLeft The LocalDateTime to check if it is before or equal to.
	 * @param localDateTimeRight The LocalDateTime to check if it is after or equal to.
	 * @return true if the first LocalDateTime is before or equal to the second LocalDateTime, false otherwise.
	 */
	public static boolean isBeforeOrEquals(LocalDateTime localDateTimeLeft, LocalDateTime localDateTimeRight) {
	    return localDateTimeLeft.compareTo(localDateTimeRight) <= 0;
	}

	/**
	 * Checks if the first LocalDateTime is after or equal to the second LocalDateTime.
	 *
	 * @param localDateTimeLeft The LocalDateTime to check if it is after or equal to.
	 * @param localDateTimeRight The LocalDateTime to check if it is before or equal to.
	 * @return true if the first LocalDateTime is after or equal to the second LocalDateTime, false otherwise.
	 */
	public static boolean isAfterOrEquals(LocalDateTime localDateTimeLeft, LocalDateTime localDateTimeRight) {
	    return localDateTimeLeft.compareTo(localDateTimeRight) >= 0;
	}

	/**
	 * Checks if a LocalDateTime is between two other LocalDateTime objects (inclusive).
	 *
	 * @param left The left boundary LocalDateTime.
	 * @param between The LocalDateTime to check if it is between the left and right boundaries (inclusive).
	 * @param right The right boundary LocalDateTime.
	 * @return true if the LocalDateTime is between the left and right boundaries (inclusive), false otherwise.
	 */
	public static boolean isBetweenInclusive(LocalDateTime left, LocalDateTime between, LocalDateTime right) {
	    return isBeforeOrEquals(left, between) && isBeforeOrEquals(between, right);
	}

	/**
	 * Checks if a LocalDateTime is between two other LocalDateTime objects (exclusive).
	 *
	 * @param left The left boundary LocalDateTime.
	 * @param between The LocalDateTime to check if it is between the left and right boundaries (exclusive).
	 * @param right The right boundary LocalDateTime.
	 * @return true if the LocalDateTime is between the left and right boundaries (exclusive), false otherwise.
	 */
	public static boolean isBetweenExclusive(LocalDateTime left, LocalDateTime between, LocalDateTime right) {
	    return isBefore(left, between) && isBefore(between, right);
	}
	
	// IS SPECIFIC DATE
	
	/**
	 * Checks if the given LocalDateTime is the first day of the month.
	 *
	 * @param localDateTime The LocalDateTime to check.
	 * @return true if the given LocalDateTime is the first day of the month, false otherwise.
	 */
	public static boolean isFirstDayOfMonth(LocalDateTime localDateTime) {
	    return localDateTime.getDayOfMonth() == 1;
	}

	/**
	 * Checks if the given LocalDateTime is the last day of the month.
	 *
	 * @param localDateTime The LocalDateTime to check.
	 * @return true if the given LocalDateTime is the last day of the month, false otherwise.
	 */
	public static boolean isLastDayOfMonth(LocalDateTime localDateTime) {
	    return localDateTime.getDayOfMonth() == lastDayOfMonth(localDateTime).getDayOfMonth();
	}

	/**
	 * Checks if the given LocalDateTime is the first day of the year.
	 *
	 * @param localDateTime The LocalDateTime to check.
	 * @return true if the given LocalDateTime is the first day of the year, false otherwise.
	 */
	public static boolean isFirstDayOfTheYear(LocalDateTime localDateTime) {
	    return isJanuary(localDateTime) && isFirstDayOfMonth(localDateTime);
	}

	/**
	 * Checks if the given LocalDateTime is the last day of the year.
	 *
	 * @param localDateTime The LocalDateTime to check.
	 * @return true if the given LocalDateTime is the last day of the year, false otherwise.
	 */
	public static boolean isLastDayOfTheYear(LocalDateTime localDateTime) {
	    return isDecember(localDateTime) && localDateTime.getDayOfMonth() == 31;
	}
	
	/**
	 * Checks if the given LocalDateTime is in January.
	 *
	 * @param localDateTime The LocalDateTime to check.
	 * @return true if the given LocalDateTime is in January, false otherwise.
	 */
	public static boolean isJanuary(LocalDateTime localDateTime) {
	    return JANUARY == localDateTime.getMonth();
	}

	/**
	 * Checks if the given LocalDateTime is in February.
	 *
	 * @param localDateTime The LocalDateTime to check.
	 * @return true if the given LocalDateTime is in February, false otherwise.
	 */
	public static boolean isFebruary(LocalDateTime localDateTime) {
	    return FEBRUARY == localDateTime.getMonth();
	}

	/**
	 * Checks if the given LocalDateTime is in March.
	 *
	 * @param localDateTime The LocalDateTime to check.
	 * @return true if the given LocalDateTime is in March, false otherwise.
	 */
	public static boolean isMarch(LocalDateTime localDateTime) {
	    return MARCH == localDateTime.getMonth();
	}

	/**
	 * Checks if the given LocalDateTime is in April.
	 *
	 * @param localDateTime The LocalDateTime to check.
	 * @return true if the given LocalDateTime is in April, false otherwise.
	 */
	public static boolean isApril(LocalDateTime localDateTime) {
	    return APRIL == localDateTime.getMonth();
	}

	/**
	 * Checks if the given LocalDateTime is in May.
	 *
	 * @param localDateTime The LocalDateTime to check.
	 * @return true if the given LocalDateTime is in May, false otherwise.
	 */
	public static boolean isMay(LocalDateTime localDateTime) {
	    return MAY == localDateTime.getMonth();
	}

	/**
	 * Checks if the given LocalDateTime is in June.
	 *
	 * @param localDateTime The LocalDateTime to check.
	 * @return true if the given LocalDateTime is in June, false otherwise.
	 */
	public static boolean isJune(LocalDateTime localDateTime) {
	    return JUNE == localDateTime.getMonth();
	}

	/**
	 * Checks if the given LocalDateTime is in July.
	 *
	 * @param localDateTime The LocalDateTime to check.
	 * @return true if the given LocalDateTime is in July, false otherwise.
	 */
	public static boolean isJuly(LocalDateTime localDateTime) {
	    return JULY == localDateTime.getMonth();
	}

	/**
	 * Checks if the given LocalDateTime is in August.
	 *
	 * @param localDateTime The LocalDateTime to check.
	 * @return true if the given LocalDateTime is in August, false otherwise.
	 */
	public static boolean isAugust(LocalDateTime localDateTime) {
	    return AUGUST == localDateTime.getMonth();
	}

	/**
	 * Checks if the given LocalDateTime is in September.
	 *
	 * @param localDateTime The LocalDateTime to check.
	 * @return true if the given LocalDateTime is in September, false otherwise.
	 */
	public static boolean isSeptember(LocalDateTime localDateTime) {
	    return SEPTEMBER == localDateTime.getMonth();
	}

	/**
	 * Checks if the given LocalDateTime is in October.
	 *
	 * @param localDateTime The LocalDateTime to check.
	 * @return true if the given LocalDateTime is in October, false otherwise.
	 */
	public static boolean isOctober(LocalDateTime localDateTime) {
	    return OCTOBER == localDateTime.getMonth();
	}

	/**
	 * Checks if the given LocalDateTime is in November.
	 *
	 * @param localDateTime The LocalDateTime to check.
	 * @return true if the given LocalDateTime is in November, false otherwise.
	 */
	public static boolean isNovember(LocalDateTime localDateTime) {
	    return NOVEMBER == localDateTime.getMonth();
	}

	/**
	 * Checks if the given LocalDateTime is in December.
	 *
	 * @param localDateTime The LocalDateTime to check.
	 * @return true if the given LocalDateTime is in December, false otherwise.
	 */
	public static boolean isDecember(LocalDateTime localDateTime) {
	    return DECEMBER == localDateTime.getMonth();
	}
	
	// SET SPECIFIC DATE
	
	/**
	 * Builds a LocalDateTime using the provided LocalDate and LocalTime.
	 *
	 * @param date The LocalDate to be used.
	 * @param time The LocalTime to be used.
	 * @return The LocalDateTime built from the provided LocalDate and LocalTime.
	 * @throws DateTimeException If the resulting LocalDateTime is invalid.
	 */
	public static LocalDateTime buildLocalDateTime(LocalDate date, LocalTime time) {
	    return LocalDateTime.of(date, time);
	}

	/**
	 * Builds a LocalDateTime using the provided year, month, day, hour, and minute.
	 *
	 * @param year The year to be used.
	 * @param month The month to be used.
	 * @param day The day to be used.
	 * @param hour The hour to be used.
	 * @param minute The minute to be used.
	 * @return The LocalDateTime built from the provided year, month, day, hour, and minute.
	 * @throws DateTimeException If the resulting LocalDateTime is invalid.
	 */
	public static LocalDateTime buildLocalDateTime(int year, int month, int day, int hour, int minute) {
	    return LocalDateTime.of(year, month, day, hour, minute);
	}

	/**
	 * Builds a LocalDateTime using the provided year, month, day, hour, minute, and second.
	 *
	 * @param year The year to be used.
	 * @param month The month to be used.
	 * @param day The day to be used.
	 * @param hour The hour to be used.
	 * @param minute The minute to be used.
	 * @param second The second to be used.
	 * @return The LocalDateTime built from the provided year, month, day, hour, minute, and second.
	 * @throws DateTimeException If the resulting LocalDateTime is invalid.
	 */
	public static LocalDateTime buildLocalDateTime(int year, int month, int day, int hour, int minute, int second) {
	    return LocalDateTime.of(year, month, day, hour, minute, second);
	}

	/**
	 * Changes the day of the month in the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime to be modified.
	 * @param day The new day of the month.
	 * @return The modified LocalDateTime with the specified day of the month.
	 * @throws DateTimeException If the resulting LocalDateTime is invalid.
	 */
	public static LocalDateTime changeDay(LocalDateTime localDateTime, int day) {
	    return localDateTime.withDayOfMonth(day);
	}

	/**
	 * Changes the month and day of the month in the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime to be modified.
	 * @param month The new month.
	 * @param day The new day of the month.
	 * @return The modified LocalDateTime with the specified month and day of the month.
	 * @throws DateTimeException If the resulting LocalDateTime is invalid.
	 */
	public static LocalDateTime changeMonthAndDay(LocalDateTime localDateTime, int month, int day) {
	    return localDateTime.withMonth(month)
	                        .withDayOfMonth(day);
	}

	/**
	 * Changes the second in the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime to be modified.
	 * @param second The new second.
	 * @return The modified LocalDateTime with the specified second.
	 * @throws DateTimeException If the resulting LocalDateTime is invalid.
	 */
	public static LocalDateTime changeSecond(LocalDateTime localDateTime, int second) {
	    return localDateTime.withSecond(second);
	}

	/**
	 * Changes the minute in the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime to be modified.
	 * @param minute The new minute.
	 * @return The modified LocalDateTime with the specified minute.
	 * @throws DateTimeException If the resulting LocalDateTime is invalid.
	 */
	public static LocalDateTime changeMinute(LocalDateTime localDateTime, int minute) {
	    return localDateTime.withMinute(minute);
	}

	/**
	 * Changes the hour in the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime to be modified.
	 * @param hour The new hour.
	 * @return The modified LocalDateTime with the specified hour.
	 * @throws DateTimeException If the resulting LocalDateTime is invalid.
	 */
	public static LocalDateTime changeHour(LocalDateTime localDateTime, int hour) {
	    return localDateTime.withHour(hour);
	}

	/**
	 * Changes the hour, minute, and second in the given LocalDateTime.
	 *
	 * @param localDateTime The LocalDateTime to be modified.
	 * @param hour The new hour.
	 * @param minute The new minute.
	 * @param second The new second.
	 * @return The modified LocalDateTime with the specified hour, minute, and second.
	 * @throws DateTimeException If the resulting LocalDateTime is invalid.
	 */
	public static LocalDateTime changeHourMinuteSecond(LocalDateTime localDateTime, int hour, int minute, int second) {
	    return localDateTime.withHour(hour)
	                        .withMinute(minute)
	                        .withSecond(second);
	}
	
}