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
import java.time.temporal.TemporalAdjusters;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocalDateUtils {

	// DAY
	
	public static LocalDate addDays(final LocalDate localDate, final int daysToAdd) {
		return localDate.plusDays(daysToAdd);
	}
	
	public static LocalDate subtractDays(final LocalDate localDate, final int daysToSubtract) {
		return localDate.minusDays(daysToSubtract);
	}
	
	// WEEK
	
	public static LocalDate addWeeks(final LocalDate localDate, final int weeksToAdd) {
		return localDate.plusWeeks(weeksToAdd);
	}
	
	public static LocalDate subtractWeeks(final LocalDate localDate, final int weeksToSubtract) {
		return localDate.minusWeeks(weeksToSubtract);
	}
	
	// MONTH
	
	public static LocalDate addMonths(final LocalDate localDate, final int monthsToAdd) {
		return localDate.plusMonths(monthsToAdd);
	}
	
	public static LocalDate subtractMonths(final LocalDate localDate, final int monthsToSubtract) {
		return localDate.minusMonths(monthsToSubtract);
	}
	
	public static LocalDate firstDayOfMonth(final LocalDate localDate) {
		return localDate.with(TemporalAdjusters.firstDayOfMonth());
	}
	
	public static LocalDate lastDayOfMonth(final LocalDate localDate) {
		return localDate.with(TemporalAdjusters.lastDayOfMonth());
	}
	
	public static LocalDate firstDayOfNextMonth(final LocalDate localDate) {
		return localDate.plusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
	}
	
	public static LocalDate lastDayOfNextMonth(final LocalDate localDate) {
		return localDate.plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
	}
	
	public static LocalDate firstDayOfPreviousMonth(final LocalDate localDate) {
		return localDate.minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
	}
	
	public static LocalDate lastDayOfPreviousMonth(final LocalDate localDate) {
		return localDate.minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
	}
	
	// YEAR
	
	public static LocalDate addYears(final LocalDate localDate, final int yearsToAdd) {
		return localDate.plusYears(yearsToAdd);
	}
	
	public static LocalDate subtractYears(final LocalDate localDate, final int yearsToSubtract) {
		return localDate.minusYears(yearsToSubtract);
	}
	
	public static LocalDate firstDayOfYear(final LocalDate localDate) {
		return localDate.with(TemporalAdjusters.firstDayOfYear());
	}
	
	public static LocalDate lastDayOfYear(final LocalDate localDate) {
		return localDate.with(TemporalAdjusters.lastDayOfYear());
	}
	
	public static LocalDate firstDayOfNextYear(final LocalDate localDate) {
		return localDate.plusYears(1).with(TemporalAdjusters.firstDayOfYear());
	}
	
	public static LocalDate lastDayOfNextYear(final LocalDate localDate) {
		return localDate.plusYears(1).with(TemporalAdjusters.lastDayOfYear());
	}
	
	public static LocalDate firstDayOfPreviousYear(final LocalDate localDate) {
		return localDate.minusYears(1).with(TemporalAdjusters.firstDayOfYear());
	}
	
	public static LocalDate lastDayOfPreviousYear(final LocalDate localDate) {
		return localDate.minusYears(1).with(TemporalAdjusters.lastDayOfYear());
	}
	
	// TRIMESTER (3 month period)
	
	public static LocalDate firstDayOfCurrentTrimester(final LocalDate localDate) {
		return TrimesterUtils.FIRST_DAY_OF_CURRENT_TRIMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate lastDayOfCurrentTrimester(final LocalDate localDate) {
		return TrimesterUtils.LAST_DAY_OF_CURRENT_TRIMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate firstDayOfNextTrimester(final LocalDate localDate) {
		return TrimesterUtils.FIRST_DAY_OF_NEXT_TRIMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate lastDayOfNextTrimester(final LocalDate localDate) {
		return TrimesterUtils.LAST_DAY_OF_NEXT_TRIMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate firstDayOfPreviousTrimester(final LocalDate localDate) {
		return TrimesterUtils.FIRST_DAY_OF_PREVIOUS_TRIMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate lastDayOfPreviousTrimester(final LocalDate localDate) {
		return TrimesterUtils.LAST_DAY_OF_PREVIOUS_TRIMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static boolean isFirstTrimester(final LocalDate localDate) {
		int monthValue = localDate.getMonthValue();
		return monthValue >= 1 && monthValue <= 3;
	}
	
	public static boolean isSecondTrimester(final LocalDate localDate) {
		int monthValue = localDate.getMonthValue();
		return monthValue >= 4 && monthValue <= 6;
	}
	
	public static boolean isThirdTrimester(final LocalDate localDate) {
		int monthValue = localDate.getMonthValue();
		return monthValue >= 7 && monthValue <= 9;
	}
	
	public static boolean isFourthTrimester(final LocalDate localDate) {
		int monthValue = localDate.getMonthValue();
		return monthValue >= 10 && monthValue <= 12;
	}
	
	// QUADRIMESTER (4 month period)
	
	public static LocalDate firstDayOfCurrentQuadrimester(final LocalDate localDate) {
		return QuadrimesterUtils.FIRST_DAY_OF_CURRENT_QUADRIMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate lastDayOfCurrentQuadrimester(final LocalDate localDate) {
		return QuadrimesterUtils.LAST_DAY_OF_CURRENT_QUADRIMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate firstDayOfNextQuadrimester(final LocalDate localDate) {
		return QuadrimesterUtils.FIRST_DAY_OF_NEXT_QUADRIMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate lastDayOfNextQuadrimester(final LocalDate localDate) {
		return QuadrimesterUtils.LAST_DAY_OF_NEXT_QUADRIMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate firstDayOfPreviousQuadrimester(final LocalDate localDate) {
		return QuadrimesterUtils.FIRST_DAY_OF_PREVIOUS_QUADRIMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate lastDayOfPreviousQuadrimester(final LocalDate localDate) {
		return QuadrimesterUtils.LAST_DAY_OF_PREVIOUS_QUADRIMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static boolean isFirstQuadrimester(final LocalDate localDate) {
		int monthValue = localDate.getMonthValue();
		return monthValue >= 1 && monthValue <= 4;
	}
	
	public static boolean isSecondQuadrimester(final LocalDate localDate) {
		int monthValue = localDate.getMonthValue();
		return monthValue >= 5 && monthValue <= 8;
	}
	
	public static boolean isThirdQuadrimester(final LocalDate localDate) {
		int monthValue = localDate.getMonthValue();
		return monthValue >= 9 && monthValue <= 12;
	}
	
	// SEMESTER (6 month period)
	
	public static LocalDate firstDayOfCurrentSemester(final LocalDate localDate) {
		return SemesterUtils.FIRST_DAY_OF_CURRENT_SEMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate lastDayOfCurrentSemester(final LocalDate localDate) {
		return SemesterUtils.LAST_DAY_OF_CURRENT_SEMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate firstDayOfNextSemester(final LocalDate localDate) {
		return SemesterUtils.FIRST_DAY_OF_NEXT_SEMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate lastDayOfNextSemester(final LocalDate localDate) {
		return SemesterUtils.LAST_DAY_OF_NEXT_SEMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate firstDayOfPreviousSemester(final LocalDate localDate) {
		return SemesterUtils.FIRST_DAY_OF_PREVIOUS_SEMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static LocalDate lastDayOfPreviousSemester(final LocalDate localDate) {
		return SemesterUtils.LAST_DAY_OF_PREVIOUS_SEMESTER.get(localDate.getMonth()).apply(localDate);
	}
	
	public static boolean isFirstSemester(final LocalDate localDate) {
		int monthValue = localDate.getMonthValue();
		return monthValue >= 1 && monthValue <= 6;
	}
	
	public static boolean isSecondSemester(final LocalDate localDate) {
		int monthValue = localDate.getMonthValue();
		return monthValue >= 7 && monthValue <= 12;
	}
	
	// COMPARE
	
	public static boolean isEquals(final LocalDate localDateLeft, final LocalDate localDateRight) {
		return localDateLeft.equals(localDateRight);
	}
	
	public static boolean isNotEquals(final LocalDate localDateLeft, final LocalDate localDateRight) {
		return !localDateLeft.equals(localDateRight);
	}
	
	public static boolean isBefore(final LocalDate localDateLeft, final LocalDate localDateRight) {
		return localDateLeft.isBefore(localDateRight);
	}
	
	public static boolean isAfter(final LocalDate localDateLeft, final LocalDate localDateRight) {
		return localDateLeft.isAfter(localDateRight);
	}
	
	public static boolean isBeforeOrEquals(final LocalDate localDateLeft, final LocalDate localDateRight) {
		return localDateLeft.compareTo(localDateRight) <= 0;
	}
	
	public static boolean isAfterOrEquals(final LocalDate localDateLeft, final LocalDate localDateRight) {
		return localDateLeft.compareTo(localDateRight) >= 0;
	}
	
	public static boolean isBetweenInclusive(final LocalDate left, final LocalDate between, final LocalDate right) {
		return isBeforeOrEquals(left, between) && isBeforeOrEquals(between, right);
	}
	
	public static boolean isBetweenExclusive(final LocalDate left, final LocalDate between, final LocalDate right) {
		return isBefore(left, between) && isBefore(between, right);
	}
	
	// IS SPECIFIC DATE
	
	public static boolean isLeapYear(final LocalDate localDate) {
		return localDate.isLeapYear();
	}
	
	public static boolean isFirstDayOfMonth(final LocalDate localDate) {
		return localDate.getDayOfMonth() == 1;
	}
	
	public static boolean isLastDayOfMonth(final LocalDate localDate) {
		return localDate.getDayOfMonth() == lastDayOfMonth(localDate).getDayOfMonth();
	}
	
	public static boolean isFirstDayOfTheYear(final LocalDate localDate) {
		return isJanuary(localDate) && isFirstDayOfMonth(localDate);
	}
	
	public static boolean isLastDayOfTheYear(final LocalDate localDate) {
		return isDecember(localDate) && localDate.getDayOfMonth() == 31;
	}
	
	public static boolean isJanuary(final LocalDate localDate) {
		return JANUARY == localDate.getMonth();
	}
	
	public static boolean isFebruary(final LocalDate localDate) {
		return FEBRUARY == localDate.getMonth();
	}
	
	public static boolean isMarch(final LocalDate localDate) {
		return MARCH == localDate.getMonth();
	}
	
	public static boolean isApril(final LocalDate localDate) {
		return APRIL == localDate.getMonth();
	}
	
	public static boolean isMay(final LocalDate localDate) {
		return MAY == localDate.getMonth();
	}
	
	public static boolean isJune(final LocalDate localDate) {
		return JUNE == localDate.getMonth();
	}
	
	public static boolean isJuly(final LocalDate localDate) {
		return JULY == localDate.getMonth();
	}
	
	public static boolean isAugust(final LocalDate localDate) {
		return AUGUST == localDate.getMonth();
	}
	
	public static boolean isSeptember(final LocalDate localDate) {
		return SEPTEMBER == localDate.getMonth();
	}
	
	public static boolean isOctober(final LocalDate localDate) {
		return OCTOBER == localDate.getMonth();
	}
	
	public static boolean isNovember(final LocalDate localDate) {
		return NOVEMBER == localDate.getMonth();
	}
	
	public static boolean isDecember(final LocalDate localDate) {
		return DECEMBER == localDate.getMonth();
	}
	
	// SET SPECIFIC DATE
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalDate buildLocalDate(final int day, final int month, final int year) {
		return LocalDate.of(year, month, day);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalDate setDay(final LocalDate localDate, final int day) {
		return localDate.withDayOfMonth(day);
	}
	
	/**
	 * @throws DateTimeException
	 */
	public static LocalDate setDayAndMonth(final LocalDate localDate, final int day, final int month) {
		return localDate.withMonth(month).withDayOfMonth(day);
	}
	
}