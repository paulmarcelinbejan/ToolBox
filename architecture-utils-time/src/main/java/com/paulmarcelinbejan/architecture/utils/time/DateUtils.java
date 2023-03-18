package com.paulmarcelinbejan.architecture.utils.time;

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

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtils {

	// DAY
	
	public static LocalDate addDays(LocalDate localDate, int daysToAdd) {
		return localDate.plusDays(daysToAdd);
	}
	
	public static LocalDate subtractDays(LocalDate localDate, int daysToSubtract) {
		return localDate.minusDays(daysToSubtract);
	}
	
	// WEEK
	
	public static LocalDate addWeeks(LocalDate localDate, int weeksToAdd) {
		return localDate.plusWeeks(weeksToAdd);
	}
	
	public static LocalDate subtractWeeks(LocalDate localDate, int weeksToSubtract) {
		return localDate.minusWeeks(weeksToSubtract);
	}
	
	// MONTH
	
	public static LocalDate addMonths(LocalDate localDate, int monthsToAdd) {
		return localDate.plusMonths(monthsToAdd);
	}
	
	public static LocalDate subtractMonths(LocalDate localDate, int monthsToSubtract) {
		return localDate.minusMonths(monthsToSubtract);
	}
	
	public static LocalDate firstDayOfMonth(LocalDate localDate) {
		return localDate.with(TemporalAdjusters.firstDayOfMonth());
	}
	
	public static LocalDate lastDayOfMonth(LocalDate localDate) {
		return localDate.with(TemporalAdjusters.lastDayOfMonth());
	}
	
	public static LocalDate firstDayOfNextMonth(LocalDate localDate) {
		return localDate.plusMonths(1)
						.with(TemporalAdjusters.firstDayOfMonth());
	}
	
	public static LocalDate lastDayOfNextMonth(LocalDate localDate) {
		return localDate.plusMonths(1)
						.with(TemporalAdjusters.lastDayOfMonth());
	}
	
	public static LocalDate firstDayOfPreviousMonth(LocalDate localDate) {
		return localDate.minusMonths(1)
						.with(TemporalAdjusters.firstDayOfMonth());
	}
	
	public static LocalDate lastDayOfPreviousMonth(LocalDate localDate) {
		return localDate.minusMonths(1)
						.with(TemporalAdjusters.lastDayOfMonth());
	}
	
	// YEAR
	
	public static LocalDate addYears(LocalDate localDate, int yearsToAdd) {
		return localDate.plusYears(yearsToAdd);
	}
	
	public static LocalDate subtractYears(LocalDate localDate, int yearsToSubtract) {
		return localDate.minusYears(yearsToSubtract);
	}
	
	public static LocalDate firstDayOfYear(LocalDate localDate) {
		return localDate.with(TemporalAdjusters.firstDayOfYear());
	}
	
	public static LocalDate lastDayOfYear(LocalDate localDate) {
		return localDate.with(TemporalAdjusters.lastDayOfYear());
	}
	
	public static LocalDate firstDayOfNextYear(LocalDate localDate) {
		return localDate.plusYears(1)
						.with(TemporalAdjusters.firstDayOfYear());
	}
	
	public static LocalDate lastDayOfNextYear(LocalDate localDate) {
		return localDate.plusYears(1)
						.with(TemporalAdjusters.lastDayOfYear());
	}
	
	public static LocalDate firstDayOfPreviousYear(LocalDate localDate) {
		return localDate.minusYears(1)
						.with(TemporalAdjusters.firstDayOfYear());
	}
	
	public static LocalDate lastDayOfPreviousYear(LocalDate localDate) {
		return localDate.minusYears(1)
						.with(TemporalAdjusters.lastDayOfYear());
	}
	
	// TRIMESTER (3 month period)
	
	public static LocalDate firstDayOfCurrentTrimester(LocalDate localDate) {
		return TrimesterUtils.FIRST_DAY_OF_CURRENT_TRIMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate lastDayOfCurrentTrimester(LocalDate localDate) {
		return TrimesterUtils.LAST_DAY_OF_CURRENT_TRIMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate firstDayOfNextTrimester(LocalDate localDate) {
		return TrimesterUtils.FIRST_DAY_OF_NEXT_TRIMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate lastDayOfNextTrimester(LocalDate localDate) {
		return TrimesterUtils.LAST_DAY_OF_NEXT_TRIMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate firstDayOfPreviousTrimester(LocalDate localDate) {
		return TrimesterUtils.FIRST_DAY_OF_PREVIOUS_TRIMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate lastDayOfPreviousTrimester(LocalDate localDate) {
		return TrimesterUtils.LAST_DAY_OF_PREVIOUS_TRIMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static boolean isFirstTrimester(LocalDate localDate) {
		int monthValue = localDate.getMonthValue();
		return isBetweenInclusive(1, monthValue, 3);
	}
	
	public static boolean isSecondTrimester(LocalDate localDate) {
		int monthValue = localDate.getMonthValue();
		return isBetweenInclusive(4, monthValue, 6);
	}
	
	public static boolean isThirdTrimester(LocalDate localDate) {
		int monthValue = localDate.getMonthValue();
		return isBetweenInclusive(7, monthValue, 9);
	}
	
	public static boolean isFourthTrimester(LocalDate localDate) {
		int monthValue = localDate.getMonthValue();
		return isBetweenInclusive(10, monthValue, 12);
	}
	
	// QUADRIMESTER (4 month period)
	
	public static LocalDate firstDayOfCurrentQuadrimester(LocalDate localDate) {
		return QuadrimesterUtils.FIRST_DAY_OF_CURRENT_QUADRIMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate lastDayOfCurrentQuadrimester(LocalDate localDate) {
		return QuadrimesterUtils.LAST_DAY_OF_CURRENT_QUADRIMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate firstDayOfNextQuadrimester(LocalDate localDate) {
		return QuadrimesterUtils.FIRST_DAY_OF_NEXT_QUADRIMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate lastDayOfNextQuadrimester(LocalDate localDate) {
		return QuadrimesterUtils.LAST_DAY_OF_NEXT_QUADRIMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate firstDayOfPreviousQuadrimester(LocalDate localDate) {
		return QuadrimesterUtils.FIRST_DAY_OF_PREVIOUS_QUADRIMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate lastDayOfPreviousQuadrimester(LocalDate localDate) {
		return QuadrimesterUtils.LAST_DAY_OF_PREVIOUS_QUADRIMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static boolean isFirstQuadrimester(LocalDate localDate) {
		int monthValue = localDate.getMonthValue();
		return isBetweenInclusive(1, monthValue, 4);
	}
	
	public static boolean isSecondQuadrimester(LocalDate localDate) {
		int monthValue = localDate.getMonthValue();
		return isBetweenInclusive(5, monthValue, 8);
	}
	
	public static boolean isThirdQuadrimester(LocalDate localDate) {
		int monthValue = localDate.getMonthValue();
		return isBetweenInclusive(9, monthValue, 12);
	}
	
	// SEMESTER (6 month period)
	
	public static LocalDate firstDayOfCurrentSemester(LocalDate localDate) {
		return SemesterUtils.FIRST_DAY_OF_CURRENT_SEMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate lastDayOfCurrentSemester(LocalDate localDate) {
		return SemesterUtils.LAST_DAY_OF_CURRENT_SEMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate firstDayOfNextSemester(LocalDate localDate) {
		return SemesterUtils.FIRST_DAY_OF_NEXT_SEMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate lastDayOfNextSemester(LocalDate localDate) {
		return SemesterUtils.LAST_DAY_OF_NEXT_SEMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate firstDayOfPreviousSemester(LocalDate localDate) {
		return SemesterUtils.FIRST_DAY_OF_PREVIOUS_SEMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate lastDayOfPreviousSemester(LocalDate localDate) {
		return SemesterUtils.LAST_DAY_OF_PREVIOUS_SEMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static boolean isFirstSemester(LocalDate localDate) {
		int monthValue = localDate.getMonthValue();
		return isBetweenInclusive(1, monthValue, 6);
	}
	
	public static boolean isSecondSemester(LocalDate localDate) {
		int monthValue = localDate.getMonthValue();
		return isBetweenInclusive(7, monthValue, 12);
	}
	
	// COMPARE
	
	public static boolean isEquals(LocalDate localDateLeft, LocalDate localDateRight) {
		return localDateLeft.equals(localDateRight);
	}
	
	public static boolean isNotEquals(LocalDate localDateLeft, LocalDate localDateRight) {
		return !localDateLeft.equals(localDateRight);
	}
	
	public static boolean isBefore(LocalDate localDateLeft, LocalDate localDateRight) {
		return localDateLeft.isBefore(localDateRight);
	}
	
	public static boolean isAfter(LocalDate localDateLeft, LocalDate localDateRight) {
		return localDateLeft.isAfter(localDateRight);
	}
	
	public static boolean isBeforeOrEquals(LocalDate localDateLeft, LocalDate localDateRight) {
		return localDateLeft.compareTo(localDateRight) <= 0;
	}
	
	public static boolean isAfterOrEquals(LocalDate localDateLeft, LocalDate localDateRight) {
		return localDateLeft.compareTo(localDateRight) >= 0;
	}
	
	public static boolean isBetweenInclusive(LocalDate left, LocalDate between, LocalDate right) {
		return isBeforeOrEquals(left, between) && isBeforeOrEquals(between, right);
	}
	
	public static boolean isBetweenExclusive(LocalDate left, LocalDate between, LocalDate right) {
		return isBefore(left, between) && isBefore(between, right);
	}
	
	// IS SPECIFIC DATE
	
	public static boolean isLeapYear(LocalDate localDate) {
		return localDate.isLeapYear();
	}
	
	public static boolean isFirstDayOfMonth(LocalDate localDate) {
		return localDate.getDayOfMonth() == 1;
	}
	
	public static boolean isLastDayOfMonth(LocalDate localDate) {
		return localDate.getDayOfMonth() == lastDayOfMonth(localDate).getDayOfMonth();
	}
	
	public static boolean isFirstDayOfTheYear(LocalDate localDate) {
		return isJanuary(localDate) && isFirstDayOfMonth(localDate);
	}
	
	public static boolean isLastDayOfTheYear(LocalDate localDate) {
		return isDecember(localDate) && localDate.getDayOfMonth() == 31;
	}
	
	public static boolean isJanuary(LocalDate localDate) {
		return JANUARY == localDate.getMonth();
	}
	
	public static boolean isFebruary(LocalDate localDate) {
		return FEBRUARY == localDate.getMonth();
	}
	
	public static boolean isMarch(LocalDate localDate) {
		return MARCH == localDate.getMonth();
	}
	
	public static boolean isApril(LocalDate localDate) {
		return APRIL == localDate.getMonth();
	}
	
	public static boolean isMay(LocalDate localDate) {
		return MAY == localDate.getMonth();
	}
	
	public static boolean isJune(LocalDate localDate) {
		return JUNE == localDate.getMonth();
	}
	
	public static boolean isJuly(LocalDate localDate) {
		return JULY == localDate.getMonth();
	}
	
	public static boolean isAugust(LocalDate localDate) {
		return AUGUST == localDate.getMonth();
	}
	
	public static boolean isSeptember(LocalDate localDate) {
		return SEPTEMBER == localDate.getMonth();
	}
	
	public static boolean isOctober(LocalDate localDate) {
		return OCTOBER == localDate.getMonth();
	}
	
	public static boolean isNovember(LocalDate localDate) {
		return NOVEMBER == localDate.getMonth();
	}
	
	public static boolean isDecember(LocalDate localDate) {
		return DECEMBER == localDate.getMonth();
	}
	
	// SET SPECIFIC DATE
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalDate toLocalDate(LocalDateTime localDateTime) {
		return localDateTime.toLocalDate();
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalDate buildLocalDate(int year, int month, int day) {
		return LocalDate.of(year, month, day);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalDate changeDay(LocalDate localDate, int day) {
		return localDate.withDayOfMonth(day);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalDate changeMonthAndDay(LocalDate localDate, int month, int day) {
		return localDate.withMonth(month)
						.withDayOfMonth(day);
	}
	
	private static boolean isBetweenInclusive(int min, int between, int max) {
		return min <= between && between <= max; 
	}
	
}