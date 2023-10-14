package com.paulmarcelinbejan.toolbox.utils.time;

import static com.paulmarcelinbejan.toolbox.utils.time.LocalDateUtils.buildLocalDate;
import static com.paulmarcelinbejan.toolbox.utils.time.LocalDateUtils.isFirstTrimester;
import static com.paulmarcelinbejan.toolbox.utils.time.LocalDateUtils.isFourthTrimester;
import static com.paulmarcelinbejan.toolbox.utils.time.LocalDateUtils.isSecondTrimester;
import static com.paulmarcelinbejan.toolbox.utils.time.LocalDateUtils.isThirdTrimester;
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
 * A trimester is a period of three months. <br>
 * From latin trimestris: tri (three) mensis (month).
 * 
 * <p>
 * A year can be divided into four TRIMESTER (also known as Q1, Q2, Q3, Q4): <br>
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
 *  	<td>31st March</td>
 *  </tr>
 *  <tr>
 *  	<th>SECOND</td>
 *  	<td>1st April</td>
 *  	<td>30th June</td>
 *  </tr>
 *  <tr>
 *  	<th>THIRD</td>
 *  	<td>1st July</td>
 *  	<td>30th September</td>
 *  </tr>
 *  <tr>
 *  	<th>FOURTH</td>
 *  	<td>1st October</td>
 *  	<td>31st December</td>
 *  </tr>
 * </table>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class TrimesterUtils {

	static final Map<Month, Function<LocalDate, LocalDate>> FIRST_DAY_OF_CURRENT_TRIMESTER = initializeFirstDayOfCurrentTrimesterMap();
	
	static final Map<Month, Function<LocalDate, LocalDate>> LAST_DAY_OF_CURRENT_TRIMESTER = initializeLastDayOfCurrentTrimesterMap();
	
	static final Map<Month, Function<LocalDate, LocalDate>> FIRST_DAY_OF_NEXT_TRIMESTER = initializeFirstDayOfNextTrimesterMap();
	
	static final Map<Month, Function<LocalDate, LocalDate>> LAST_DAY_OF_NEXT_TRIMESTER = initializeLastDayOfNextTrimesterMap();
	
	static final Map<Month, Function<LocalDate, LocalDate>> FIRST_DAY_OF_PREVIOUS_TRIMESTER = initializeFirstDayOfPreviousTrimesterMap();
	
	static final Map<Month, Function<LocalDate, LocalDate>> LAST_DAY_OF_PREVIOUS_TRIMESTER = initializeLastDayOfPreviousTrimesterMap();
	
	// FIRST DAY of CURRENT TRIMESTER
	
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeFirstDayOfCurrentTrimesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST TRIMESTER
		map.put(JANUARY, TrimesterUtils::firstDayOfCurrentTrimesterStartingAtFirstTrimester);
		map.put(FEBRUARY, TrimesterUtils::firstDayOfCurrentTrimesterStartingAtFirstTrimester);
		map.put(MARCH, TrimesterUtils::firstDayOfCurrentTrimesterStartingAtFirstTrimester);
		
		// SECOND TRIMESTER
		map.put(APRIL, TrimesterUtils::firstDayOfCurrentTrimesterStartingAtSecondTrimester);
		map.put(MAY, TrimesterUtils::firstDayOfCurrentTrimesterStartingAtSecondTrimester);
		map.put(JUNE, TrimesterUtils::firstDayOfCurrentTrimesterStartingAtSecondTrimester);
		
		// THIRD TRIMESTER
		map.put(JULY, TrimesterUtils::firstDayOfCurrentTrimesterStartingAtThirdTrimester);
		map.put(AUGUST, TrimesterUtils::firstDayOfCurrentTrimesterStartingAtThirdTrimester);
		map.put(SEPTEMBER, TrimesterUtils::firstDayOfCurrentTrimesterStartingAtThirdTrimester);
		
		// FOURTH TRIMESTER
		map.put(OCTOBER, TrimesterUtils::firstDayOfCurrentTrimesterStartingAtFourthTrimester);
		map.put(NOVEMBER, TrimesterUtils::firstDayOfCurrentTrimesterStartingAtFourthTrimester);
		map.put(DECEMBER, TrimesterUtils::firstDayOfCurrentTrimesterStartingAtFourthTrimester);
		
		return map;
	}
	
	// LAST DAY of CURRENT TRIMESTER
	
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeLastDayOfCurrentTrimesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST TRIMESTER
		map.put(JANUARY, TrimesterUtils::lastDayOfCurrentTrimesterStartingAtFirstTrimester);
		map.put(FEBRUARY, TrimesterUtils::lastDayOfCurrentTrimesterStartingAtFirstTrimester);
		map.put(MARCH, TrimesterUtils::lastDayOfCurrentTrimesterStartingAtFirstTrimester);
		
		// SECOND TRIMESTER
		map.put(APRIL, TrimesterUtils::lastDayOfCurrentTrimesterStartingAtSecondTrimester);
		map.put(MAY, TrimesterUtils::lastDayOfCurrentTrimesterStartingAtSecondTrimester);
		map.put(JUNE, TrimesterUtils::lastDayOfCurrentTrimesterStartingAtSecondTrimester);
		
		// THIRD TRIMESTER
		map.put(JULY, TrimesterUtils::lastDayOfCurrentTrimesterStartingAtThirdTrimester);
		map.put(AUGUST, TrimesterUtils::lastDayOfCurrentTrimesterStartingAtThirdTrimester);
		map.put(SEPTEMBER, TrimesterUtils::lastDayOfCurrentTrimesterStartingAtThirdTrimester);
		
		// FOURTH TRIMESTER
		map.put(OCTOBER, TrimesterUtils::lastDayOfCurrentTrimesterStartingAtFourthTrimester);
		map.put(NOVEMBER, TrimesterUtils::lastDayOfCurrentTrimesterStartingAtFourthTrimester);
		map.put(DECEMBER, TrimesterUtils::lastDayOfCurrentTrimesterStartingAtFourthTrimester);
		
		return map;
	}
	
	// FIRST DAY of NEXT TRIMESTER
	
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeFirstDayOfNextTrimesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST TRIMESTER
		map.put(JANUARY, TrimesterUtils::firstDayOfNextTrimesterStartingAtFirstTrimester);
		map.put(FEBRUARY, TrimesterUtils::firstDayOfNextTrimesterStartingAtFirstTrimester);
		map.put(MARCH, TrimesterUtils::firstDayOfNextTrimesterStartingAtFirstTrimester);
		
		// SECOND TRIMESTER
		map.put(APRIL, TrimesterUtils::firstDayOfNextTrimesterStartingAtSecondTrimester);
		map.put(MAY, TrimesterUtils::firstDayOfNextTrimesterStartingAtSecondTrimester);
		map.put(JUNE, TrimesterUtils::firstDayOfNextTrimesterStartingAtSecondTrimester);
		
		// THIRD TRIMESTER
		map.put(JULY, TrimesterUtils::firstDayOfNextTrimesterStartingAtThirdTrimester);
		map.put(AUGUST, TrimesterUtils::firstDayOfNextTrimesterStartingAtThirdTrimester);
		map.put(SEPTEMBER, TrimesterUtils::firstDayOfNextTrimesterStartingAtThirdTrimester);
		
		// FOURTH TRIMESTER
		map.put(OCTOBER, TrimesterUtils::firstDayOfNextTrimesterStartingAtFourthTrimester);
		map.put(NOVEMBER, TrimesterUtils::firstDayOfNextTrimesterStartingAtFourthTrimester);
		map.put(DECEMBER, TrimesterUtils::firstDayOfNextTrimesterStartingAtFourthTrimester);
		
		return map;
	}
	
	// LAST DAY of NEXT TRIMESTER
	
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeLastDayOfNextTrimesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST TRIMESTER
		map.put(JANUARY, TrimesterUtils::lastDayOfNextTrimesterStartingAtFirstTrimester);
		map.put(FEBRUARY, TrimesterUtils::lastDayOfNextTrimesterStartingAtFirstTrimester);
		map.put(MARCH, TrimesterUtils::lastDayOfNextTrimesterStartingAtFirstTrimester);
		
		// SECOND TRIMESTER
		map.put(APRIL, TrimesterUtils::lastDayOfNextTrimesterStartingAtSecondTrimester);
		map.put(MAY, TrimesterUtils::lastDayOfNextTrimesterStartingAtSecondTrimester);
		map.put(JUNE, TrimesterUtils::lastDayOfNextTrimesterStartingAtSecondTrimester);
		
		// THIRD TRIMESTER
		map.put(JULY, TrimesterUtils::lastDayOfNextTrimesterStartingAtThirdTrimester);
		map.put(AUGUST, TrimesterUtils::lastDayOfNextTrimesterStartingAtThirdTrimester);
		map.put(SEPTEMBER, TrimesterUtils::lastDayOfNextTrimesterStartingAtThirdTrimester);
		
		// FOURTH TRIMESTER
		map.put(OCTOBER, TrimesterUtils::lastDayOfNextTrimesterStartingAtFourthTrimester);
		map.put(NOVEMBER, TrimesterUtils::lastDayOfNextTrimesterStartingAtFourthTrimester);
		map.put(DECEMBER, TrimesterUtils::lastDayOfNextTrimesterStartingAtFourthTrimester);
		
		return map;
	}
	
	// FIRST DAY of PREVIOUS TRIMESTER
	
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeFirstDayOfPreviousTrimesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST TRIMESTER
		map.put(JANUARY, TrimesterUtils::firstDayOfPreviousTrimesterStartingAtFirstTrimester);
		map.put(FEBRUARY, TrimesterUtils::firstDayOfPreviousTrimesterStartingAtFirstTrimester);
		map.put(MARCH, TrimesterUtils::firstDayOfPreviousTrimesterStartingAtFirstTrimester);
		
		// SECOND TRIMESTER
		map.put(APRIL, TrimesterUtils::firstDayOfPreviousTrimesterStartingAtSecondTrimester);
		map.put(MAY, TrimesterUtils::firstDayOfPreviousTrimesterStartingAtSecondTrimester);
		map.put(JUNE, TrimesterUtils::firstDayOfPreviousTrimesterStartingAtSecondTrimester);
		
		// THIRD TRIMESTER
		map.put(JULY, TrimesterUtils::firstDayOfPreviousTrimesterStartingAtThirdTrimester);
		map.put(AUGUST, TrimesterUtils::firstDayOfPreviousTrimesterStartingAtThirdTrimester);
		map.put(SEPTEMBER, TrimesterUtils::firstDayOfPreviousTrimesterStartingAtThirdTrimester);
		
		// FOURTH TRIMESTER
		map.put(OCTOBER, TrimesterUtils::firstDayOfPreviousTrimesterStartingAtFourthTrimester);
		map.put(NOVEMBER, TrimesterUtils::firstDayOfPreviousTrimesterStartingAtFourthTrimester);
		map.put(DECEMBER, TrimesterUtils::firstDayOfPreviousTrimesterStartingAtFourthTrimester);
		
		return map;
	}
	
	// LAST DAY of PREVIOUS TRIMESTER
	
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeLastDayOfPreviousTrimesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST TRIMESTER
		map.put(JANUARY, TrimesterUtils::lastDayOfPreviousTrimesterStartingAtFirstTrimester);
		map.put(FEBRUARY, TrimesterUtils::lastDayOfPreviousTrimesterStartingAtFirstTrimester);
		map.put(MARCH, TrimesterUtils::lastDayOfPreviousTrimesterStartingAtFirstTrimester);
		
		// SECOND TRIMESTER
		map.put(APRIL, TrimesterUtils::lastDayOfPreviousTrimesterStartingAtSecondTrimester);
		map.put(MAY, TrimesterUtils::lastDayOfPreviousTrimesterStartingAtSecondTrimester);
		map.put(JUNE, TrimesterUtils::lastDayOfPreviousTrimesterStartingAtSecondTrimester);
		
		// THIRD TRIMESTER
		map.put(JULY, TrimesterUtils::lastDayOfPreviousTrimesterStartingAtThirdTrimester);
		map.put(AUGUST, TrimesterUtils::lastDayOfPreviousTrimesterStartingAtThirdTrimester);
		map.put(SEPTEMBER, TrimesterUtils::lastDayOfPreviousTrimesterStartingAtThirdTrimester);
		
		// FOURTH TRIMESTER
		map.put(OCTOBER, TrimesterUtils::lastDayOfPreviousTrimesterStartingAtFourthTrimester);
		map.put(NOVEMBER, TrimesterUtils::lastDayOfPreviousTrimesterStartingAtFourthTrimester);
		map.put(DECEMBER, TrimesterUtils::lastDayOfPreviousTrimesterStartingAtFourthTrimester);
		
		return map;
	}
	
	private static final LocalDate firstDayOfFirstTrimester(final int year) {
		return buildLocalDate(year, 1, 1);
	}
	
	private static final LocalDate firstDayOfSecondTrimester(final int year) {
		return buildLocalDate(year, 4, 1);
	}
	
	private static final LocalDate firstDayOfThirdTrimester(final int year) {
		return buildLocalDate(year, 7, 1);
	}
	
	private static final LocalDate firstDayOfFourthTrimester(final int year) {
		return buildLocalDate(year, 10, 1);
	}
	
	private static final LocalDate lastDayOfFirstTrimester(final int year) {
		return buildLocalDate(year, 3, 31);
	}
	
	private static final LocalDate lastDayOfSecondTrimester(final int year) {
		return buildLocalDate(year, 6, 30);
	}
	
	private static final LocalDate lastDayOfThirdTrimester(final int year) {
		return buildLocalDate(year, 9, 30);
	}
	
	private static final LocalDate lastDayOfFourthTrimester(final int year) {
		return buildLocalDate(year, 12, 31);
	}
	
	private static final void throwExceptionIfIsNotTheFirstTrimester(final LocalDate localDate) {
		if(!isFirstTrimester(localDate)) throw new IllegalArgumentException("The localDate is not on first trimester");
	}
	
	private static final void throwExceptionIfIsNotTheSecondTrimester(final LocalDate localDate) {
		if(!isSecondTrimester(localDate)) throw new IllegalArgumentException("The localDate is not on second trimester");
	}
	
	private static final void throwExceptionIfIsNotTheThirdTrimester(final LocalDate localDate) {
		if(!isThirdTrimester(localDate)) throw new IllegalArgumentException("The localDate is not on third trimester");
	}
	
	private static final void throwExceptionIfIsNotTheFourthTrimester(final LocalDate localDate) {
		if(!isFourthTrimester(localDate)) throw new IllegalArgumentException("The localDate is not on fourth trimester");
	}
	
	// THIS TRIMESTER
	
	private static final LocalDate firstDayOfCurrentTrimesterStartingAtFirstTrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFirstTrimester(localDate);
		return firstDayOfFirstTrimester(localDate.getYear());
	}
	
	private static final LocalDate firstDayOfCurrentTrimesterStartingAtSecondTrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheSecondTrimester(localDate);
		return firstDayOfSecondTrimester(localDate.getYear());
	}
	
	private static final LocalDate firstDayOfCurrentTrimesterStartingAtThirdTrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheThirdTrimester(localDate);
		return firstDayOfThirdTrimester(localDate.getYear());
	}
	
	private static final LocalDate firstDayOfCurrentTrimesterStartingAtFourthTrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFourthTrimester(localDate);
		return firstDayOfFourthTrimester(localDate.getYear());
	}
	
	private static final LocalDate lastDayOfCurrentTrimesterStartingAtFirstTrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFirstTrimester(localDate);
		return lastDayOfFirstTrimester(localDate.getYear());
	}
	
	private static final LocalDate lastDayOfCurrentTrimesterStartingAtSecondTrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheSecondTrimester(localDate);
		return lastDayOfSecondTrimester(localDate.getYear());
	}
	
	private static final LocalDate lastDayOfCurrentTrimesterStartingAtThirdTrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheThirdTrimester(localDate);
		return lastDayOfThirdTrimester(localDate.getYear());
	}
	
	private static final LocalDate lastDayOfCurrentTrimesterStartingAtFourthTrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFourthTrimester(localDate);
		return lastDayOfFourthTrimester(localDate.getYear());
	}
	
	// NEXT TRIMESTER
	
	private static final LocalDate firstDayOfNextTrimesterStartingAtFirstTrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFirstTrimester(localDate);
		return firstDayOfSecondTrimester(localDate.getYear());
	}
	
	private static final LocalDate firstDayOfNextTrimesterStartingAtSecondTrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheSecondTrimester(localDate);
		return firstDayOfThirdTrimester(localDate.getYear());
	}
	
	private static final LocalDate firstDayOfNextTrimesterStartingAtThirdTrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheThirdTrimester(localDate);
		return firstDayOfFourthTrimester(localDate.getYear());
	}
	
	private static final LocalDate firstDayOfNextTrimesterStartingAtFourthTrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFourthTrimester(localDate);
		return firstDayOfFirstTrimester(localDate.getYear() + 1);
	}
	
	private static final LocalDate lastDayOfNextTrimesterStartingAtFirstTrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFirstTrimester(localDate);
		return lastDayOfSecondTrimester(localDate.getYear());
	}
	
	private static final LocalDate lastDayOfNextTrimesterStartingAtSecondTrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheSecondTrimester(localDate);
		return lastDayOfThirdTrimester(localDate.getYear());
	}
	
	private static final LocalDate lastDayOfNextTrimesterStartingAtThirdTrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheThirdTrimester(localDate);
		return lastDayOfFourthTrimester(localDate.getYear());
	}
	
	private static final LocalDate lastDayOfNextTrimesterStartingAtFourthTrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFourthTrimester(localDate);
		return lastDayOfFirstTrimester(localDate.getYear() + 1);
	}
	
	// PREVIOUS TRIMESTER
	
	private static final LocalDate firstDayOfPreviousTrimesterStartingAtFirstTrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFirstTrimester(localDate);
		return firstDayOfFourthTrimester(localDate.getYear() - 1);
	}
	
	private static final LocalDate firstDayOfPreviousTrimesterStartingAtSecondTrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheSecondTrimester(localDate);
		return firstDayOfFirstTrimester(localDate.getYear());
	}
	
	private static final LocalDate firstDayOfPreviousTrimesterStartingAtThirdTrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheThirdTrimester(localDate);
		return firstDayOfSecondTrimester(localDate.getYear());
	}
	
	private static final LocalDate firstDayOfPreviousTrimesterStartingAtFourthTrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFourthTrimester(localDate);
		return firstDayOfThirdTrimester(localDate.getYear());
	}
	
	private static final LocalDate lastDayOfPreviousTrimesterStartingAtFirstTrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFirstTrimester(localDate);
		return lastDayOfFourthTrimester(localDate.getYear() - 1);
	}
	
	private static final LocalDate lastDayOfPreviousTrimesterStartingAtSecondTrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheSecondTrimester(localDate);
		return lastDayOfFirstTrimester(localDate.getYear());
	}
	
	private static final LocalDate lastDayOfPreviousTrimesterStartingAtThirdTrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheThirdTrimester(localDate);
		return lastDayOfSecondTrimester(localDate.getYear());
	}
	
	private static final LocalDate lastDayOfPreviousTrimesterStartingAtFourthTrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFourthTrimester(localDate);
		return lastDayOfThirdTrimester(localDate.getYear());
	}
	
//	public enum TRIMESTER {
//	    FIRST,
//	    SECOND,
//	    THIRD, 
//	    FORUTH
//	}
	
}
