package com.paulmarcelinbejan.architecture.utils.time;

import static com.paulmarcelinbejan.architecture.utils.time.DateUtils.buildLocalDate;
import static com.paulmarcelinbejan.architecture.utils.time.DateUtils.isFirstSemester;
import static com.paulmarcelinbejan.architecture.utils.time.DateUtils.isSecondSemester;
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

import java.time.LocalDate;
import java.time.Month;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * A semester is a period of six months. <br>
 * From latin semestris: sex (six) mensis (month).
 * 
 * <p>
 * A year can be divided into two SEMESTER: <br>
 * 
 * <table>
 * 	<tr>
 * 		<th></th>
 * 		<th>First Day</th>
 * 		<th>Last Day</th>
 * 	</tr>
 * 	<tr>
 *  	<th>FIRST</td>
 *  	<td>1st January</td>
 *  	<td>30th June</td>
 *  </tr>
 *  <tr>
 *  	<th>SECOND</td>
 *  	<td>1st July</td>
 *  	<td>31st December</td>
 *  </tr>
 * </table>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class SemesterUtils {

	static final Map<Month, Function<LocalDate, LocalDate>> FIRST_DAY_OF_CURRENT_SEMESTER = initializeFirstDayOfCurrentSemesterMap();
	
	static final Map<Month, Function<LocalDate, LocalDate>> LAST_DAY_OF_CURRENT_SEMESTER = initializeLastDayOfCurrentSemesterMap();
	
	static final Map<Month, Function<LocalDate, LocalDate>> FIRST_DAY_OF_NEXT_SEMESTER = initializeFirstDayOfNextSemesterMap();
	
	static final Map<Month, Function<LocalDate, LocalDate>> LAST_DAY_OF_NEXT_SEMESTER = initializeLastDayOfNextSemesterMap();
	
	static final Map<Month, Function<LocalDate, LocalDate>> FIRST_DAY_OF_PREVIOUS_SEMESTER = initializeFirstDayOfPreviousSemesterMap();
	
	static final Map<Month, Function<LocalDate, LocalDate>> LAST_DAY_OF_PREVIOUS_SEMESTER = initializeLastDayOfPreviousSemesterMap();
	
	// FIRST DAY of CURRENT SEMESTER
	
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeFirstDayOfCurrentSemesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST SEMESTER
		map.put(JANUARY, SemesterUtils::firstDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(FEBRUARY, SemesterUtils::firstDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(MARCH, SemesterUtils::firstDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(APRIL, SemesterUtils::firstDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(MAY, SemesterUtils::firstDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(JUNE, SemesterUtils::firstDayOfCurrentSemesterStartingAtFirstSemester);
		
		// SECOND SEMESTER
		map.put(JULY, SemesterUtils::firstDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(AUGUST, SemesterUtils::firstDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(SEPTEMBER, SemesterUtils::firstDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(OCTOBER, SemesterUtils::firstDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(NOVEMBER, SemesterUtils::firstDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(DECEMBER, SemesterUtils::firstDayOfCurrentSemesterStartingAtSecondSemester);
		
		return map;
	}
	
	// LAST DAY of CURRENT SEMESTER
	
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeLastDayOfCurrentSemesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST SEMESTER
		map.put(JANUARY, SemesterUtils::lastDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(FEBRUARY, SemesterUtils::lastDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(MARCH, SemesterUtils::lastDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(APRIL, SemesterUtils::lastDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(MAY, SemesterUtils::lastDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(JUNE, SemesterUtils::lastDayOfCurrentSemesterStartingAtFirstSemester);
		
		// SECOND SEMESTER
		map.put(JULY, SemesterUtils::lastDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(AUGUST, SemesterUtils::lastDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(SEPTEMBER, SemesterUtils::lastDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(OCTOBER, SemesterUtils::lastDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(NOVEMBER, SemesterUtils::lastDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(DECEMBER, SemesterUtils::lastDayOfCurrentSemesterStartingAtSecondSemester);
		
		return map;
	}
	
	// FIRST DAY of NEXT SEMESTER
	
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeFirstDayOfNextSemesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST SEMESTER
		map.put(JANUARY, SemesterUtils::firstDayOfNextSemesterStartingAtFirstSemester);
		map.put(FEBRUARY, SemesterUtils::firstDayOfNextSemesterStartingAtFirstSemester);
		map.put(MARCH, SemesterUtils::firstDayOfNextSemesterStartingAtFirstSemester);
		map.put(APRIL, SemesterUtils::firstDayOfNextSemesterStartingAtFirstSemester);
		map.put(MAY, SemesterUtils::firstDayOfNextSemesterStartingAtFirstSemester);
		map.put(JUNE, SemesterUtils::firstDayOfNextSemesterStartingAtFirstSemester);
		
		// SECOND SEMESTER
		map.put(JULY, SemesterUtils::firstDayOfNextSemesterStartingAtSecondSemester);
		map.put(AUGUST, SemesterUtils::firstDayOfNextSemesterStartingAtSecondSemester);
		map.put(SEPTEMBER, SemesterUtils::firstDayOfNextSemesterStartingAtSecondSemester);
		map.put(OCTOBER, SemesterUtils::firstDayOfNextSemesterStartingAtSecondSemester);
		map.put(NOVEMBER, SemesterUtils::firstDayOfNextSemesterStartingAtSecondSemester);
		map.put(DECEMBER, SemesterUtils::firstDayOfNextSemesterStartingAtSecondSemester);
		
		return map;
	}
	
	// LAST DAY of NEXT SEMESTER
	
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeLastDayOfNextSemesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST SEMESTER
		map.put(JANUARY, SemesterUtils::lastDayOfNextSemesterStartingAtFirstSemester);
		map.put(FEBRUARY, SemesterUtils::lastDayOfNextSemesterStartingAtFirstSemester);
		map.put(MARCH, SemesterUtils::lastDayOfNextSemesterStartingAtFirstSemester);
		map.put(APRIL, SemesterUtils::lastDayOfNextSemesterStartingAtFirstSemester);
		map.put(MAY, SemesterUtils::lastDayOfNextSemesterStartingAtFirstSemester);
		map.put(JUNE, SemesterUtils::lastDayOfNextSemesterStartingAtFirstSemester);
		
		// SECOND SEMESTER
		map.put(JULY, SemesterUtils::lastDayOfNextSemesterStartingAtSecondSemester);
		map.put(AUGUST, SemesterUtils::lastDayOfNextSemesterStartingAtSecondSemester);
		map.put(SEPTEMBER, SemesterUtils::lastDayOfNextSemesterStartingAtSecondSemester);
		map.put(OCTOBER, SemesterUtils::lastDayOfNextSemesterStartingAtSecondSemester);
		map.put(NOVEMBER, SemesterUtils::lastDayOfNextSemesterStartingAtSecondSemester);
		map.put(DECEMBER, SemesterUtils::lastDayOfNextSemesterStartingAtSecondSemester);
		
		return map;
	}
	
	// FIRST DAY of PREVIOUS SEMESTER
	
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeFirstDayOfPreviousSemesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST SEMESTER
		map.put(JANUARY, SemesterUtils::firstDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(FEBRUARY, SemesterUtils::firstDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(MARCH, SemesterUtils::firstDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(APRIL, SemesterUtils::firstDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(MAY, SemesterUtils::firstDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(JUNE, SemesterUtils::firstDayOfPreviousSemesterStartingAtFirstSemester);
		
		// SECOND SEMESTER
		map.put(JULY, SemesterUtils::firstDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(AUGUST, SemesterUtils::firstDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(SEPTEMBER, SemesterUtils::firstDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(OCTOBER, SemesterUtils::firstDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(NOVEMBER, SemesterUtils::firstDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(DECEMBER, SemesterUtils::firstDayOfPreviousSemesterStartingAtSecondSemester);
		
		return map;
	}
	
	// LAST DAY of PREVIOUS SEMESTER
	
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeLastDayOfPreviousSemesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST SEMESTER
		map.put(JANUARY, SemesterUtils::lastDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(FEBRUARY, SemesterUtils::lastDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(MARCH, SemesterUtils::lastDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(APRIL, SemesterUtils::lastDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(MAY, SemesterUtils::lastDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(JUNE, SemesterUtils::lastDayOfPreviousSemesterStartingAtFirstSemester);
		
		// SECOND SEMESTER
		map.put(JULY, SemesterUtils::lastDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(AUGUST, SemesterUtils::lastDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(SEPTEMBER, SemesterUtils::lastDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(OCTOBER, SemesterUtils::lastDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(NOVEMBER, SemesterUtils::lastDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(DECEMBER, SemesterUtils::lastDayOfPreviousSemesterStartingAtSecondSemester);
		
		return map;
	}
	
	private static final LocalDate firstDayOfFirstSemester(final int year) {
		return buildLocalDate(year, 1, 1);
	}
	
	private static final LocalDate firstDayOfSecondSemester(final int year) {
		return buildLocalDate(year, 7, 1);
	}
	
	private static final LocalDate lastDayOfFirstSemester(final int year) {
		return buildLocalDate(year, 6, 30);
	}
	
	private static final LocalDate lastDayOfSecondSemester(final int year) {
		return buildLocalDate(year, 12, 31);
	}
	
	private static final void throwExceptionIfIsNotTheFirstSemester(final LocalDate localDate) {
		if(!isFirstSemester(localDate)) throw new IllegalArgumentException("The localDate is not on first semester");
	}
	
	private static final void throwExceptionIfIsNotTheSecondSemester(final LocalDate localDate) {
		if(!isSecondSemester(localDate)) throw new IllegalArgumentException("The localDate is not on second semester");
	}
	
	// CURRENT SEMESTER
	
	private static final LocalDate firstDayOfCurrentSemesterStartingAtFirstSemester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFirstSemester(localDate);
		return firstDayOfFirstSemester(localDate.getYear());
	}
	
	private static final LocalDate firstDayOfCurrentSemesterStartingAtSecondSemester(final LocalDate localDate) {
		throwExceptionIfIsNotTheSecondSemester(localDate);
		return firstDayOfSecondSemester(localDate.getYear());
	}
	
	private static final LocalDate lastDayOfCurrentSemesterStartingAtFirstSemester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFirstSemester(localDate);
		return lastDayOfFirstSemester(localDate.getYear());
	}
	
	private static final LocalDate lastDayOfCurrentSemesterStartingAtSecondSemester(final LocalDate localDate) {
		throwExceptionIfIsNotTheSecondSemester(localDate);
		return lastDayOfSecondSemester(localDate.getYear());
	}
	
	// NEXT SEMESTER
	
	private static final LocalDate firstDayOfNextSemesterStartingAtFirstSemester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFirstSemester(localDate);
		return firstDayOfSecondSemester(localDate.getYear());
	}
	
	private static final LocalDate firstDayOfNextSemesterStartingAtSecondSemester(final LocalDate localDate) {
		throwExceptionIfIsNotTheSecondSemester(localDate);
		return firstDayOfFirstSemester(localDate.getYear() + 1);
	}
	
	private static final LocalDate lastDayOfNextSemesterStartingAtFirstSemester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFirstSemester(localDate);
		return lastDayOfSecondSemester(localDate.getYear());
	}
	
	private static final LocalDate lastDayOfNextSemesterStartingAtSecondSemester(final LocalDate localDate) {
		throwExceptionIfIsNotTheSecondSemester(localDate);
		return lastDayOfFirstSemester(localDate.getYear() + 1);
	}
	
	// PREVIOUS SEMESTER
	
	private static final LocalDate firstDayOfPreviousSemesterStartingAtFirstSemester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFirstSemester(localDate);
		return firstDayOfSecondSemester(localDate.getYear() - 1);
	}
	
	private static final LocalDate firstDayOfPreviousSemesterStartingAtSecondSemester(final LocalDate localDate) {
		throwExceptionIfIsNotTheSecondSemester(localDate);
		return firstDayOfFirstSemester(localDate.getYear());
	}
	
	private static final LocalDate lastDayOfPreviousSemesterStartingAtFirstSemester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFirstSemester(localDate);
		return lastDayOfSecondSemester(localDate.getYear() - 1);
	}
	
	private static final LocalDate lastDayOfPreviousSemesterStartingAtSecondSemester(final LocalDate localDate) {
		throwExceptionIfIsNotTheSecondSemester(localDate);
		return lastDayOfFirstSemester(localDate.getYear());
	}
	
//	public enum SEMESTER {
//	    FIRST,
//	    SECOND
//	}
	
}
