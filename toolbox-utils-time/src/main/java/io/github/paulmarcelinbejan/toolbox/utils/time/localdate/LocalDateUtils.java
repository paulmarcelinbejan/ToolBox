package io.github.paulmarcelinbejan.toolbox.utils.time.localdate;

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

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Utility class for LocalDate operations.
 * Be aware that LocalDate is time-zone agnostic!
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocalDateUtils {

	/**
	 * 31/12/9999 LocalDate that can be used when an end date is not defined.
	 */
	public static final LocalDate MAX_END_DATE = LocalDateUtils.buildLocalDate(9999, 12, 31);
	
	// DAY

	/**
	 * Adds the specified number of days to the given LocalDate.
	 *
	 * @param localDate The LocalDate to which days are added.
	 * @param daysToAdd The number of days to add.
	 * @return The LocalDate after adding the specified number of days.
	 */
	public static LocalDate addDays(LocalDate localDate, int daysToAdd) {
	    return localDate.plusDays(daysToAdd);
	}

	/**
	 * Subtracts the specified number of days from the given LocalDate.
	 *
	 * @param localDate The LocalDate from which days are subtracted.
	 * @param daysToSubtract The number of days to subtract.
	 * @return The LocalDate after subtracting the specified number of days.
	 */
	public static LocalDate subtractDays(LocalDate localDate, int daysToSubtract) {
	    return localDate.minusDays(daysToSubtract);
	}

	// WEEK

	/**
	 * Adds the specified number of weeks to the given LocalDate.
	 *
	 * @param localDate The LocalDate to which weeks are added.
	 * @param weeksToAdd The number of weeks to add.
	 * @return The LocalDate after adding the specified number of weeks.
	 */
	public static LocalDate addWeeks(LocalDate localDate, int weeksToAdd) {
	    return localDate.plusWeeks(weeksToAdd);
	}

	/**
	 * Subtracts the specified number of weeks from the given LocalDate.
	 *
	 * @param localDate The LocalDate from which weeks are subtracted.
	 * @param weeksToSubtract The number of weeks to subtract.
	 * @return The LocalDate after subtracting the specified number of weeks.
	 */
	public static LocalDate subtractWeeks(LocalDate localDate, int weeksToSubtract) {
	    return localDate.minusWeeks(weeksToSubtract);
	}

	// MONTH

	/**
	 * Adds the specified number of months to the given LocalDate.
	 *
	 * @param localDate The LocalDate to which months are added.
	 * @param monthsToAdd The number of months to add.
	 * @return The LocalDate after adding the specified number of months.
	 */
	public static LocalDate addMonths(LocalDate localDate, int monthsToAdd) {
	    return localDate.plusMonths(monthsToAdd);
	}

	/**
	 * Subtracts the specified number of months from the given LocalDate.
	 *
	 * @param localDate The LocalDate from which months are subtracted.
	 * @param monthsToSubtract The number of months to subtract.
	 * @return The LocalDate after subtracting the specified number of months.
	 */
	public static LocalDate subtractMonths(LocalDate localDate, int monthsToSubtract) {
	    return localDate.minusMonths(monthsToSubtract);
	}

	/**
	 * Returns the first day of the month for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the first day of the month is returned.
	 * @return The LocalDate representing the first day of the month.
	 */
	public static LocalDate firstDayOfMonth(LocalDate localDate) {
	    return localDate.with(TemporalAdjusters.firstDayOfMonth());
	}

	/**
	 * Returns the last day of the month for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the last day of the month is returned.
	 * @return The LocalDate representing the last day of the month.
	 */
	public static LocalDate lastDayOfMonth(LocalDate localDate) {
	    return localDate.with(TemporalAdjusters.lastDayOfMonth());
	}

	/**
	 * Returns the first day of the next month for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the first day of the next month is returned.
	 * @return The LocalDate representing the first day of the next month.
	 */
	public static LocalDate firstDayOfNextMonth(LocalDate localDate) {
	    return localDate.plusMonths(1)
	                    .with(TemporalAdjusters.firstDayOfMonth());
	}

	/**
	 * Returns the last day of the next month for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the last day of the next month is returned.
	 * @return The LocalDate representing the last day of the next month.
	 */
	public static LocalDate lastDayOfNextMonth(LocalDate localDate) {
	    return localDate.plusMonths(1)
	                    .with(TemporalAdjusters.lastDayOfMonth());
	}

	/**
	 * Returns the first day of the previous month for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the first day of the previous month is returned.
	 * @return The LocalDate representing the first day of the previous month.
	 */
	public static LocalDate firstDayOfPreviousMonth(LocalDate localDate) {
	    return localDate.minusMonths(1)
	                    .with(TemporalAdjusters.firstDayOfMonth());
	}

	/**
	 * Returns the last day of the previous month for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the last day of the previous month is returned.
	 * @return The LocalDate representing the last day of the previous month.
	 */
	public static LocalDate lastDayOfPreviousMonth(LocalDate localDate) {
	    return localDate.minusMonths(1)
	                    .with(TemporalAdjusters.lastDayOfMonth());
	}
	
	// YEAR
	
	/**
	 * Adds the specified number of years to the given LocalDate.
	 *
	 * @param localDate The LocalDate to which years are added.
	 * @param yearsToAdd The number of years to add.
	 * @return The LocalDate after adding the specified number of years.
	 */
	public static LocalDate addYears(LocalDate localDate, int yearsToAdd) {
	    return localDate.plusYears(yearsToAdd);
	}

	/**
	 * Subtracts the specified number of years from the given LocalDate.
	 *
	 * @param localDate The LocalDate from which years are subtracted.
	 * @param yearsToSubtract The number of years to subtract.
	 * @return The LocalDate after subtracting the specified number of years.
	 */
	public static LocalDate subtractYears(LocalDate localDate, int yearsToSubtract) {
	    return localDate.minusYears(yearsToSubtract);
	}

	/**
	 * Returns the first day of the year for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the first day of the year is returned.
	 * @return The LocalDate representing the first day of the year.
	 */
	public static LocalDate firstDayOfYear(LocalDate localDate) {
	    return localDate.with(TemporalAdjusters.firstDayOfYear());
	}

	/**
	 * Returns the last day of the year for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the last day of the year is returned.
	 * @return The LocalDate representing the last day of the year.
	 */
	public static LocalDate lastDayOfYear(LocalDate localDate) {
	    return localDate.with(TemporalAdjusters.lastDayOfYear());
	}

	/**
	 * Returns the first day of the next year for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the first day of the next year is returned.
	 * @return The LocalDate representing the first day of the next year.
	 */
	public static LocalDate firstDayOfNextYear(LocalDate localDate) {
	    return localDate.plusYears(1)
	                    .with(TemporalAdjusters.firstDayOfYear());
	}

	/**
	 * Returns the last day of the next year for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the last day of the next year is returned.
	 * @return The LocalDate representing the last day of the next year.
	 */
	public static LocalDate lastDayOfNextYear(LocalDate localDate) {
	    return localDate.plusYears(1)
	                    .with(TemporalAdjusters.lastDayOfYear());
	}

	/**
	 * Returns the first day of the previous year for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the first day of the previous year is returned.
	 * @return The LocalDate representing the first day of the previous year.
	 */
	public static LocalDate firstDayOfPreviousYear(LocalDate localDate) {
	    return localDate.minusYears(1)
	                    .with(TemporalAdjusters.firstDayOfYear());
	}

	/**
	 * Returns the last day of the previous year for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the last day of the previous year is returned.
	 * @return The LocalDate representing the last day of the previous year.
	 */
	public static LocalDate lastDayOfPreviousYear(LocalDate localDate) {
	    return localDate.minusYears(1)
	                    .with(TemporalAdjusters.lastDayOfYear());
	}
	
	// TRIMESTER (3 month period)
	
	/**
	 * Returns the first day of the current trimester for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the first day of the current trimester is returned.
	 * @return The LocalDate representing the first day of the current trimester.
	 */
	public static LocalDate firstDayOfCurrentTrimester(LocalDate localDate) {
	    return LocalDateTrimesterUtils.getFirstDayOfCurrentTrimester().get(localDate.getMonth()).apply(localDate);
	}

	/**
	 * Returns the last day of the current trimester for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the last day of the current trimester is returned.
	 * @return The LocalDate representing the last day of the current trimester.
	 */
	public static LocalDate lastDayOfCurrentTrimester(LocalDate localDate) {
	    return LocalDateTrimesterUtils.getLastDayOfCurrentTrimester().get(localDate.getMonth()).apply(localDate);
	}

	/**
	 * Returns the first day of the next trimester for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the first day of the next trimester is returned.
	 * @return The LocalDate representing the first day of the next trimester.
	 */
	public static LocalDate firstDayOfNextTrimester(LocalDate localDate) {
	    return LocalDateTrimesterUtils.getFirstDayOfNextTrimester().get(localDate.getMonth()).apply(localDate);
	}

	/**
	 * Returns the last day of the next trimester for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the last day of the next trimester is returned.
	 * @return The LocalDate representing the last day of the next trimester.
	 */
	public static LocalDate lastDayOfNextTrimester(LocalDate localDate) {
	    return LocalDateTrimesterUtils.getLastDayOfNextTrimester().get(localDate.getMonth()).apply(localDate);
	}

	/**
	 * Returns the first day of the previous trimester for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the first day of the previous trimester is returned.
	 * @return The LocalDate representing the first day of the previous trimester.
	 */
	public static LocalDate firstDayOfPreviousTrimester(LocalDate localDate) {
	    return LocalDateTrimesterUtils.getFirstDayOfPreviousTrimester().get(localDate.getMonth()).apply(localDate);
	}

	/**
	 * Returns the last day of the previous trimester for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the last day of the previous trimester is returned.
	 * @return The LocalDate representing the last day of the previous trimester.
	 */
	public static LocalDate lastDayOfPreviousTrimester(LocalDate localDate) {
	    return LocalDateTrimesterUtils.getLastDayOfPreviousTrimester().get(localDate.getMonth()).apply(localDate);
	}
	
	/**
	 * Checks if the given LocalDate is in the first trimester.
	 *
	 * @param localDate The LocalDate to check.
	 * @return True if the LocalDate is in the first trimester, false otherwise.
	 */
	public static boolean isFirstTrimester(LocalDate localDate) {
	    int monthValue = localDate.getMonthValue();
	    return isBetweenInclusive(1, monthValue, 3);
	}

	/**
	 * Checks if the given LocalDate is in the second trimester.
	 *
	 * @param localDate The LocalDate to check.
	 * @return True if the LocalDate is in the second trimester, false otherwise.
	 */
	public static boolean isSecondTrimester(LocalDate localDate) {
	    int monthValue = localDate.getMonthValue();
	    return isBetweenInclusive(4, monthValue, 6);
	}

	/**
	 * Checks if the given LocalDate is in the third trimester.
	 *
	 * @param localDate The LocalDate to check.
	 * @return True if the LocalDate is in the third trimester, false otherwise.
	 */
	public static boolean isThirdTrimester(LocalDate localDate) {
	    int monthValue = localDate.getMonthValue();
	    return isBetweenInclusive(7, monthValue, 9);
	}

	/**
	 * Checks if the given LocalDate is in the fourth trimester.
	 *
	 * @param localDate The LocalDate to check.
	 * @return True if the LocalDate is in the fourth trimester, false otherwise.
	 */
	public static boolean isFourthTrimester(LocalDate localDate) {
	    int monthValue = localDate.getMonthValue();
	    return isBetweenInclusive(10, monthValue, 12);
	}
	
	// QUADRIMESTER (4 month period)
	
	/**
	 * Returns the first day of the current quadrimester for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the first day of the current quadrimester is returned.
	 * @return The LocalDate representing the first day of the current quadrimester.
	 */
	public static LocalDate firstDayOfCurrentQuadrimester(LocalDate localDate) {
	    return LocalDateQuadrimesterUtils.getFirstDayOfCurrentQuadrimester().get(localDate.getMonth()).apply(localDate);
	}

	/**
	 * Returns the last day of the current quadrimester for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the last day of the current quadrimester is returned.
	 * @return The LocalDate representing the last day of the current quadrimester.
	 */
	public static LocalDate lastDayOfCurrentQuadrimester(LocalDate localDate) {
	    return LocalDateQuadrimesterUtils.getLastDayOfCurrentQuadrimester().get(localDate.getMonth()).apply(localDate);
	}

	/**
	 * Returns the first day of the next quadrimester for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the first day of the next quadrimester is returned.
	 * @return The LocalDate representing the first day of the next quadrimester.
	 */
	public static LocalDate firstDayOfNextQuadrimester(LocalDate localDate) {
	    return LocalDateQuadrimesterUtils.getFirstDayOfNextQuadrimester().get(localDate.getMonth()).apply(localDate);
	}

	/**
	 * Returns the last day of the next quadrimester for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the last day of the next quadrimester is returned.
	 * @return The LocalDate representing the last day of the next quadrimester.
	 */
	public static LocalDate lastDayOfNextQuadrimester(LocalDate localDate) {
	    return LocalDateQuadrimesterUtils.getLastDayOfNextQuadrimester().get(localDate.getMonth()).apply(localDate);
	}

	/**
	 * Returns the first day of the previous quadrimester for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the first day of the previous quadrimester is returned.
	 * @return The LocalDate representing the first day of the previous quadrimester.
	 */
	public static LocalDate firstDayOfPreviousQuadrimester(LocalDate localDate) {
	    return LocalDateQuadrimesterUtils.getFirstDayOfPreviousQuadrimester().get(localDate.getMonth()).apply(localDate);
	}

	/**
	 * Returns the last day of the previous quadrimester for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the last day of the previous quadrimester is returned.
	 * @return The LocalDate representing the last day of the previous quadrimester.
	 */
	public static LocalDate lastDayOfPreviousQuadrimester(LocalDate localDate) {
	    return LocalDateQuadrimesterUtils.getLastDayOfPreviousQuadrimester().get(localDate.getMonth()).apply(localDate);
	}

	/**
	 * Checks if the given LocalDate is in the first quadrimester.
	 *
	 * @param localDate The LocalDate to check.
	 * @return True if the LocalDate is in the first quadrimester, false otherwise.
	 */
	public static boolean isFirstQuadrimester(LocalDate localDate) {
	    int monthValue = localDate.getMonthValue();
	    return isBetweenInclusive(1, monthValue, 4);
	}

	/**
	 * Checks if the given LocalDate is in the second quadrimester.
	 *
	 * @param localDate The LocalDate to check.
	 * @return True if the LocalDate is in the second quadrimester, false otherwise.
	 */
	public static boolean isSecondQuadrimester(LocalDate localDate) {
	    int monthValue = localDate.getMonthValue();
	    return isBetweenInclusive(5, monthValue, 8);
	}

	/**
	 * Checks if the given LocalDate is in the third quadrimester.
	 *
	 * @param localDate The LocalDate to check.
	 * @return True if the LocalDate is in the third quadrimester, false otherwise.
	 */
	public static boolean isThirdQuadrimester(LocalDate localDate) {
	    int monthValue = localDate.getMonthValue();
	    return isBetweenInclusive(9, monthValue, 12);
	}
	
	// SEMESTER (6 month period)
	
	/**
	 * Returns the first day of the current semester for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the first day of the current semester is returned.
	 * @return The LocalDate representing the first day of the current semester.
	 */
	public static LocalDate firstDayOfCurrentSemester(LocalDate localDate) {
	    return LocalDateSemesterUtils.getFirstDayOfCurrentSemester().get(localDate.getMonth()).apply(localDate);
	}

	/**
	 * Returns the last day of the current semester for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the last day of the current semester is returned.
	 * @return The LocalDate representing the last day of the current semester.
	 */
	public static LocalDate lastDayOfCurrentSemester(LocalDate localDate) {
	    return LocalDateSemesterUtils.getLastDayOfCurrentSemester().get(localDate.getMonth()).apply(localDate);
	}

	/**
	 * Returns the first day of the next semester for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the first day of the next semester is returned.
	 * @return The LocalDate representing the first day of the next semester.
	 */
	public static LocalDate firstDayOfNextSemester(LocalDate localDate) {
	    return LocalDateSemesterUtils.getFirstDayOfNextSemester().get(localDate.getMonth()).apply(localDate);
	}

	/**
	 * Returns the last day of the next semester for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the last day of the next semester is returned.
	 * @return The LocalDate representing the last day of the next semester.
	 */
	public static LocalDate lastDayOfNextSemester(LocalDate localDate) {
	    return LocalDateSemesterUtils.getLastDayOfNextSemester().get(localDate.getMonth()).apply(localDate);
	}

	/**
	 * Returns the first day of the previous semester for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the first day of the previous semester is returned.
	 * @return The LocalDate representing the first day of the previous semester.
	 */
	public static LocalDate firstDayOfPreviousSemester(LocalDate localDate) {
	    return LocalDateSemesterUtils.getFirstDayOfPreviousSemester().get(localDate.getMonth()).apply(localDate);
	}

	/**
	 * Returns the last day of the previous semester for the given LocalDate.
	 *
	 * @param localDate The LocalDate for which the last day of the previous semester is returned.
	 * @return The LocalDate representing the last day of the previous semester.
	 */
	public static LocalDate lastDayOfPreviousSemester(LocalDate localDate) {
	    return LocalDateSemesterUtils.getLastDayOfPreviousSemester().get(localDate.getMonth()).apply(localDate);
	}

	/**
	 * Checks if the given LocalDate is in the first semester.
	 *
	 * @param localDate The LocalDate to check.
	 * @return True if the LocalDate is in the first semester, false otherwise.
	 */
	public static boolean isFirstSemester(LocalDate localDate) {
	    int monthValue = localDate.getMonthValue();
	    return isBetweenInclusive(1, monthValue, 6);
	}

	/**
	 * Checks if the given LocalDate is in the second semester.
	 *
	 * @param localDate The LocalDate to check.
	 * @return True if the LocalDate is in the second semester, false otherwise.
	 */
	public static boolean isSecondSemester(LocalDate localDate) {
	    int monthValue = localDate.getMonthValue();
	    return isBetweenInclusive(7, monthValue, 12);
	}
	
	// COMPARE
	
	/**
	 * Checks if two LocalDate objects are equal.
	 *
	 * @param localDateLeft  The first LocalDate to compare.
	 * @param localDateRight The second LocalDate to compare.
	 * @return True if the two LocalDate objects are equal, false otherwise.
	 */
	public static boolean isEquals(LocalDate localDateLeft, LocalDate localDateRight) {
	    return localDateLeft.equals(localDateRight);
	}

	/**
	 * Checks if two LocalDate objects are not equal.
	 *
	 * @param localDateLeft  The first LocalDate to compare.
	 * @param localDateRight The second LocalDate to compare.
	 * @return True if the two LocalDate objects are not equal, false otherwise.
	 */
	public static boolean isNotEquals(LocalDate localDateLeft, LocalDate localDateRight) {
	    return !localDateLeft.equals(localDateRight);
	}

	/**
	 * Checks if the first LocalDate is before the second LocalDate.
	 *
	 * @param localDateLeft  The LocalDate to check if it is before.
	 * @param localDateRight The LocalDate to check if it is after.
	 * @return True if the first LocalDate is before the second LocalDate, false otherwise.
	 */
	public static boolean isBefore(LocalDate localDateLeft, LocalDate localDateRight) {
	    return localDateLeft.isBefore(localDateRight);
	}

	/**
	 * Checks if the first LocalDate is after the second LocalDate.
	 *
	 * @param localDateLeft  The LocalDate to check if it is after.
	 * @param localDateRight The LocalDate to check if it is before.
	 * @return True if the first LocalDate is after the second LocalDate, false otherwise.
	 */
	public static boolean isAfter(LocalDate localDateLeft, LocalDate localDateRight) {
	    return localDateLeft.isAfter(localDateRight);
	}

	/**
	 * Checks if the first LocalDate is before or equal to the second LocalDate.
	 *
	 * @param localDateLeft  The LocalDate to check if it is before or equal to.
	 * @param localDateRight The LocalDate to check if it is after or equal to.
	 * @return True if the first LocalDate is before or equal to the second LocalDate, false otherwise.
	 */
	public static boolean isBeforeOrEquals(LocalDate localDateLeft, LocalDate localDateRight) {
	    return localDateLeft.compareTo(localDateRight) <= 0;
	}

	/**
	 * Checks if the first LocalDate is after or equal to the second LocalDate.
	 *
	 * @param localDateLeft  The LocalDate to check if it is after or equal to.
	 * @param localDateRight The LocalDate to check if it is before or equal to.
	 * @return True if the first LocalDate is after or equal to the second LocalDate, false otherwise.
	 */
	public static boolean isAfterOrEquals(LocalDate localDateLeft, LocalDate localDateRight) {
	    return localDateLeft.compareTo(localDateRight) >= 0;
	}

	/**
	 * Checks if a given LocalDate is between two other LocalDate objects (inclusive).
	 *
	 * @param left    The left boundary LocalDate.
	 * @param between The LocalDate to check if it is between the left and right boundaries (inclusive).
	 * @param right   The right boundary LocalDate.
	 * @return True if the given LocalDate is between the left and right boundaries (inclusive), false otherwise.
	 */
	public static boolean isBetweenInclusive(LocalDate left, LocalDate between, LocalDate right) {
	    return isBeforeOrEquals(left, between) && isBeforeOrEquals(between, right);
	}

	/**
	 * Checks if a given LocalDate is between two other LocalDate objects (exclusive).
	 *
	 * @param left    The left boundary LocalDate.
	 * @param between The LocalDate to check if it is between the left and right boundaries (exclusive).
	 * @param right   The right boundary LocalDate.
	 * @return True if the given LocalDate is between the left and right boundaries (exclusive), false otherwise.
	 */
	public static boolean isBetweenExclusive(LocalDate left, LocalDate between, LocalDate right) {
	    return isBefore(left, between) && isBefore(between, right);
	}
	
	// IS SPECIFIC DATE
	
	/**
	 * Checks if a given year is a leap year.
	 *
	 * @param localDate The LocalDate to check for leap year.
	 * @return True if the year of the LocalDate is a leap year, false otherwise.
	 */
	public static boolean isLeapYear(LocalDate localDate) {
	    return localDate.isLeapYear();
	}

	/**
	 * Checks if a given LocalDate is the first day of the month.
	 *
	 * @param localDate The LocalDate to check.
	 * @return True if the given LocalDate is the first day of the month, false otherwise.
	 */
	public static boolean isFirstDayOfMonth(LocalDate localDate) {
	    return localDate.getDayOfMonth() == 1;
	}

	/**
	 * Checks if a given LocalDate is the last day of the month.
	 *
	 * @param localDate The LocalDate to check.
	 * @return True if the given LocalDate is the last day of the month, false otherwise.
	 */
	public static boolean isLastDayOfMonth(LocalDate localDate) {
	    return localDate.getDayOfMonth() == lastDayOfMonth(localDate).getDayOfMonth();
	}

	/**
	 * Checks if a given LocalDate is the first day of the year and in January.
	 *
	 * @param localDate The LocalDate to check.
	 * @return True if the given LocalDate is the first day of the year and in January, false otherwise.
	 */
	public static boolean isFirstDayOfTheYear(LocalDate localDate) {
	    return isJanuary(localDate) && isFirstDayOfMonth(localDate);
	}

	/**
	 * Checks if a given LocalDate is the last day of the year and in December.
	 *
	 * @param localDate The LocalDate to check.
	 * @return True if the given LocalDate is the last day of the year and in December, false otherwise.
	 */
	public static boolean isLastDayOfTheYear(LocalDate localDate) {
	    return isDecember(localDate) && localDate.getDayOfMonth() == 31;
	}
	
	/**
	 * Checks if a given LocalDate is in the month of January.
	 *
	 * @param localDate The LocalDate to check.
	 * @return True if the given LocalDate is in January, false otherwise.
	 */
	public static boolean isJanuary(LocalDate localDate) {
	    return JANUARY == localDate.getMonth();
	}

	/**
	 * Checks if a given LocalDate is in the month of February.
	 *
	 * @param localDate The LocalDate to check.
	 * @return True if the given LocalDate is in February, false otherwise.
	 */
	public static boolean isFebruary(LocalDate localDate) {
	    return FEBRUARY == localDate.getMonth();
	}

	/**
	 * Checks if a given LocalDate is in the month of March.
	 *
	 * @param localDate The LocalDate to check.
	 * @return True if the given LocalDate is in March, false otherwise.
	 */
	public static boolean isMarch(LocalDate localDate) {
	    return MARCH == localDate.getMonth();
	}

	/**
	 * Checks if a given LocalDate is in the month of April.
	 *
	 * @param localDate The LocalDate to check.
	 * @return True if the given LocalDate is in April, false otherwise.
	 */
	public static boolean isApril(LocalDate localDate) {
	    return APRIL == localDate.getMonth();
	}

	/**
	 * Checks if a given LocalDate is in the month of May.
	 *
	 * @param localDate The LocalDate to check.
	 * @return True if the given LocalDate is in May, false otherwise.
	 */
	public static boolean isMay(LocalDate localDate) {
	    return MAY == localDate.getMonth();
	}

	/**
	 * Checks if a given LocalDate is in the month of June.
	 *
	 * @param localDate The LocalDate to check.
	 * @return True if the given LocalDate is in June, false otherwise.
	 */
	public static boolean isJune(LocalDate localDate) {
	    return JUNE == localDate.getMonth();
	}

	/**
	 * Checks if a given LocalDate is in the month of July.
	 *
	 * @param localDate The LocalDate to check.
	 * @return True if the given LocalDate is in July, false otherwise.
	 */
	public static boolean isJuly(LocalDate localDate) {
	    return JULY == localDate.getMonth();
	}

	/**
	 * Checks if a given LocalDate is in the month of August.
	 *
	 * @param localDate The LocalDate to check.
	 * @return True if the given LocalDate is in August, false otherwise.
	 */
	public static boolean isAugust(LocalDate localDate) {
	    return AUGUST == localDate.getMonth();
	}

	/**
	 * Checks if a given LocalDate is in the month of September.
	 *
	 * @param localDate The LocalDate to check.
	 * @return True if the given LocalDate is in September, false otherwise.
	 */
	public static boolean isSeptember(LocalDate localDate) {
	    return SEPTEMBER == localDate.getMonth();
	}

	/**
	 * Checks if a given LocalDate is in the month of October.
	 *
	 * @param localDate The LocalDate to check.
	 * @return True if the given LocalDate is in October, false otherwise.
	 */
	public static boolean isOctober(LocalDate localDate) {
	    return OCTOBER == localDate.getMonth();
	}

	/**
	 * Checks if a given LocalDate is in the month of November.
	 *
	 * @param localDate The LocalDate to check.
	 * @return True if the given LocalDate is in November, false otherwise.
	 */
	public static boolean isNovember(LocalDate localDate) {
	    return NOVEMBER == localDate.getMonth();
	}

	/**
	 * Checks if a given LocalDate is in the month of December.
	 *
	 * @param localDate The LocalDate to check.
	 * @return True if the given LocalDate is in December, false otherwise.
	 */
	public static boolean isDecember(LocalDate localDate) {
	    return DECEMBER == localDate.getMonth();
	}
	
	// SET SPECIFIC DATE
	
	/**
	 * Converts a LocalDateTime to a LocalDate.
	 *
	 * @param localDateTime The LocalDateTime to convert.
	 * @return The LocalDate part of the LocalDateTime.
	 * @throws DateTimeException If unable to obtain a LocalDate from the LocalDateTime.
	 */
	public static LocalDate toLocalDate(LocalDateTime localDateTime) {
	    return localDateTime.toLocalDate();
	}

	/**
	 * Builds a LocalDate from the specified year, month, and day.
	 *
	 * @param year  The year of the LocalDate.
	 * @param month The month of the LocalDate.
	 * @param day   The day of the LocalDate.
	 * @return The constructed LocalDate.
	 * @throws DateTimeException If the values are not valid for a LocalDate.
	 */
	public static LocalDate buildLocalDate(int year, int month, int day) {
	    return LocalDate.of(year, month, day);
	}

	/**
	 * Changes the day of the month of the given LocalDate.
	 *
	 * @param localDate The original LocalDate.
	 * @param day       The new day of the month.
	 * @return The LocalDate with the updated day.
	 * @throws DateTimeException If the resulting LocalDate is invalid.
	 */
	public static LocalDate changeDay(LocalDate localDate, int day) {
	    return localDate.withDayOfMonth(day);
	}

	/**
	 * Changes the month and day of the given LocalDate.
	 *
	 * @param localDate The original LocalDate.
	 * @param month     The new month.
	 * @param day       The new day of the month.
	 * @return The LocalDate with the updated month and day.
	 * @throws DateTimeException If the resulting LocalDate is invalid.
	 */
	public static LocalDate changeMonthAndDay(LocalDate localDate, int month, int day) {
	    return localDate.withMonth(month)
	                    .withDayOfMonth(day);
	}

	/**
	 * Checks if a value is between a specified range (inclusive).
	 *
	 * @param min     The minimum value of the range.
	 * @param between The value to check if it's within the range.
	 * @param max     The maximum value of the range.
	 * @return True if the value is within the specified range (inclusive), false otherwise.
	 */
	private static boolean isBetweenInclusive(int min, int between, int max) {
	    return min <= between && between <= max;
	}
	
}