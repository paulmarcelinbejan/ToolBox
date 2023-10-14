package com.paulmarcelinbejan.toolbox.utils.time;

import static com.paulmarcelinbejan.toolbox.utils.time.LocalDateUtils.buildLocalDate;
import static com.paulmarcelinbejan.toolbox.utils.time.LocalDateUtils.isFirstQuadrimester;
import static com.paulmarcelinbejan.toolbox.utils.time.LocalDateUtils.isSecondQuadrimester;
import static com.paulmarcelinbejan.toolbox.utils.time.LocalDateUtils.isThirdQuadrimester;
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
 * A quadrimester is a period of four months. <br>
 * From latin quadri (four) mensis (month).
 * 
 * <p>
 * 
 * A year can be divided into three QUADRIMESTER: <br>
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
 *  	<td>30th April</td>
 *  </tr>
 *  <tr>
 *  	<th>SECOND</td>
 *  	<td>1st May</td>
 *  	<td>31st August</td>
 *  </tr>
 *  <tr>
 *  	<th>THIRD</td>
 *  	<td>1st September</td>
 *  	<td>31st December</td>
 *  </tr>
 * </table>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class QuadrimesterUtils {

	static final Map<Month, Function<LocalDate, LocalDate>> FIRST_DAY_OF_CURRENT_QUADRIMESTER = initializeFirstDayOfCurrentQuadrimesterMap();
	
	static final Map<Month, Function<LocalDate, LocalDate>> LAST_DAY_OF_CURRENT_QUADRIMESTER = initializeLastDayOfCurrentQuadrimesterMap();
	
	static final Map<Month, Function<LocalDate, LocalDate>> FIRST_DAY_OF_NEXT_QUADRIMESTER = initializeFirstDayOfNextQuadrimesterMap();
	
	static final Map<Month, Function<LocalDate, LocalDate>> LAST_DAY_OF_NEXT_QUADRIMESTER = initializeLastDayOfNextQuadrimesterMap();
	
	static final Map<Month, Function<LocalDate, LocalDate>> FIRST_DAY_OF_PREVIOUS_QUADRIMESTER = initializeFirstDayOfPreviousQuadrimesterMap();
	
	static final Map<Month, Function<LocalDate, LocalDate>> LAST_DAY_OF_PREVIOUS_QUADRIMESTER = initializeLastDayOfPreviousQuadrimesterMap();
	
	// FIRST DAY of CURRENT QUADRIMESTER
	
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeFirstDayOfCurrentQuadrimesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST QUADRIMESTER
		map.put(JANUARY, QuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtFirstQuadrimester);
		map.put(FEBRUARY, QuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtFirstQuadrimester);
		map.put(MARCH, QuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtFirstQuadrimester);
		map.put(APRIL, QuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtFirstQuadrimester);
		
		// SECOND QUADRIMESTER
		map.put(MAY, QuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtSecondQuadrimester);
		map.put(JUNE, QuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtSecondQuadrimester);
		map.put(JULY, QuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtSecondQuadrimester);
		map.put(AUGUST, QuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtSecondQuadrimester);
		
		// THIRD QUADRIMESTER
		map.put(SEPTEMBER, QuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtThirdQuadrimester);
		map.put(OCTOBER, QuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtThirdQuadrimester);
		map.put(NOVEMBER, QuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtThirdQuadrimester);
		map.put(DECEMBER, QuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtThirdQuadrimester);
		
		return map;
	}
	
	// LAST DAY of CURRENT QUADRIMESTER
	
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeLastDayOfCurrentQuadrimesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST QUADRIMESTER
		map.put(JANUARY, QuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtFirstQuadrimester);
		map.put(FEBRUARY, QuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtFirstQuadrimester);
		map.put(MARCH, QuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtFirstQuadrimester);
		map.put(APRIL, QuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtFirstQuadrimester);
		
		// SECOND QUADRIMESTER
		map.put(MAY, QuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtSecondQuadrimester);
		map.put(JUNE, QuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtSecondQuadrimester);
		map.put(JULY, QuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtSecondQuadrimester);
		map.put(AUGUST, QuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtSecondQuadrimester);
		
		// THIRD QUADRIMESTER
		map.put(SEPTEMBER, QuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtThirdQuadrimester);
		map.put(OCTOBER, QuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtThirdQuadrimester);
		map.put(NOVEMBER, QuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtThirdQuadrimester);
		map.put(DECEMBER, QuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtThirdQuadrimester);
		
		return map;
	}
	
	// FIRST DAY of NEXT QUADRIMESTER
	
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeFirstDayOfNextQuadrimesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST QUADRIMESTER
		map.put(JANUARY, QuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtFirstQuadrimester);
		map.put(FEBRUARY, QuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtFirstQuadrimester);
		map.put(MARCH, QuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtFirstQuadrimester);
		map.put(APRIL, QuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtFirstQuadrimester);
		
		// SECOND QUADRIMESTER
		map.put(MAY, QuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtSecondQuadrimester);
		map.put(JUNE, QuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtSecondQuadrimester);
		map.put(JULY, QuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtSecondQuadrimester);
		map.put(AUGUST, QuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtSecondQuadrimester);
		
		// THIRD QUADRIMESTER
		map.put(SEPTEMBER, QuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtThirdQuadrimester);
		map.put(OCTOBER, QuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtThirdQuadrimester);
		map.put(NOVEMBER, QuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtThirdQuadrimester);
		map.put(DECEMBER, QuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtThirdQuadrimester);
		
		return map;
	}
	
	// LAST DAY of NEXT QUADRIMESTER
	
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeLastDayOfNextQuadrimesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST QUADRIMESTER
		map.put(JANUARY, QuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtFirstQuadrimester);
		map.put(FEBRUARY, QuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtFirstQuadrimester);
		map.put(MARCH, QuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtFirstQuadrimester);
		map.put(APRIL, QuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtFirstQuadrimester);
		
		// SECOND QUADRIMESTER
		map.put(MAY, QuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtSecondQuadrimester);
		map.put(JUNE, QuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtSecondQuadrimester);
		map.put(JULY, QuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtSecondQuadrimester);
		map.put(AUGUST, QuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtSecondQuadrimester);
		
		// THIRD QUADRIMESTER
		map.put(SEPTEMBER, QuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtThirdQuadrimester);
		map.put(OCTOBER, QuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtThirdQuadrimester);
		map.put(NOVEMBER, QuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtThirdQuadrimester);
		map.put(DECEMBER, QuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtThirdQuadrimester);
		
		return map;
	}
	
	// FIRST DAY of PREVIOUS QUADRIMESTER
	
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeFirstDayOfPreviousQuadrimesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST QUADRIMESTER
		map.put(JANUARY, QuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtFirstQuadrimester);
		map.put(FEBRUARY, QuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtFirstQuadrimester);
		map.put(MARCH, QuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtFirstQuadrimester);
		map.put(APRIL, QuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtFirstQuadrimester);
		
		// SECOND QUADRIMESTER
		map.put(MAY, QuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtSecondQuadrimester);
		map.put(JUNE, QuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtSecondQuadrimester);
		map.put(JULY, QuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtSecondQuadrimester);
		map.put(AUGUST, QuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtSecondQuadrimester);
		
		// THIRD QUADRIMESTER
		map.put(SEPTEMBER, QuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtThirdQuadrimester);
		map.put(OCTOBER, QuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtThirdQuadrimester);
		map.put(NOVEMBER, QuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtThirdQuadrimester);
		map.put(DECEMBER, QuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtThirdQuadrimester);
		
		return map;
	}
	
	// LAST DAY of PREVIOUS QUADRIMESTER
	
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeLastDayOfPreviousQuadrimesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST QUADRIMESTER
		map.put(JANUARY, QuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtFirstQuadrimester);
		map.put(FEBRUARY, QuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtFirstQuadrimester);
		map.put(MARCH, QuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtFirstQuadrimester);
		map.put(APRIL, QuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtFirstQuadrimester);
		
		// SECOND QUADRIMESTER
		map.put(MAY, QuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtSecondQuadrimester);
		map.put(JUNE, QuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtSecondQuadrimester);
		map.put(JULY, QuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtSecondQuadrimester);
		map.put(AUGUST, QuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtSecondQuadrimester);
		
		// THIRD QUADRIMESTER
		map.put(SEPTEMBER, QuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtThirdQuadrimester);
		map.put(OCTOBER, QuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtThirdQuadrimester);
		map.put(NOVEMBER, QuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtThirdQuadrimester);
		map.put(DECEMBER, QuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtThirdQuadrimester);
		
		return map;
	}
	
	private static final LocalDate firstDayOfFirstQuadrimester(final int year) {
		return buildLocalDate(year, 1, 1);
	}
	
	private static final LocalDate firstDayOfSecondQuadrimester(final int year) {
		return buildLocalDate(year, 5, 1);
	}
	
	private static final LocalDate firstDayOfThirdQuadrimester(final int year) {
		return buildLocalDate(year, 9, 1);
	}
	
	private static final LocalDate lastDayOfFirstQuadrimester(final int year) {
		return buildLocalDate(year, 4, 30);
	}
	
	private static final LocalDate lastDayOfSecondQuadrimester(final int year) {
		return buildLocalDate(year, 8, 31);
	}
	
	private static final LocalDate lastDayOfThirdQuadrimester(final int year) {
		return buildLocalDate(year, 12, 31);
	}
	
	private static final void throwExceptionIfIsNotTheFirstQuadrimester(final LocalDate localDate) {
		if(!isFirstQuadrimester(localDate)) throw new IllegalArgumentException("The localDate is not on first quadrimester");
	}
	
	private static final void throwExceptionIfIsNotTheSecondQuadrimester(final LocalDate localDate) {
		if(!isSecondQuadrimester(localDate)) throw new IllegalArgumentException("The localDate is not on second quadrimester");
	}
	
	private static final void throwExceptionIfIsNotTheThirdQuadrimester(final LocalDate localDate) {
		if(!isThirdQuadrimester(localDate)) throw new IllegalArgumentException("The localDate is not on third quadrimester");
	}
	
	// CURRENT QUADRIMESTER
	
	private static final LocalDate firstDayOfCurrentQuadrimesterStartingAtFirstQuadrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFirstQuadrimester(localDate);
		return firstDayOfFirstQuadrimester(localDate.getYear());
	}
	
	private static final LocalDate firstDayOfCurrentQuadrimesterStartingAtSecondQuadrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheSecondQuadrimester(localDate);
		return firstDayOfSecondQuadrimester(localDate.getYear());
	}
	
	private static final LocalDate firstDayOfCurrentQuadrimesterStartingAtThirdQuadrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheThirdQuadrimester(localDate);
		return firstDayOfThirdQuadrimester(localDate.getYear());
	}
	
	private static final LocalDate lastDayOfCurrentQuadrimesterStartingAtFirstQuadrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFirstQuadrimester(localDate);
		return lastDayOfFirstQuadrimester(localDate.getYear());
	}
	
	private static final LocalDate lastDayOfCurrentQuadrimesterStartingAtSecondQuadrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheSecondQuadrimester(localDate);
		return lastDayOfSecondQuadrimester(localDate.getYear());
	}
	
	private static final LocalDate lastDayOfCurrentQuadrimesterStartingAtThirdQuadrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheThirdQuadrimester(localDate);
		return lastDayOfThirdQuadrimester(localDate.getYear());
	}
	
	// NEXT QUADRIMESTER
	
	private static final LocalDate firstDayOfNextQuadrimesterStartingAtFirstQuadrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFirstQuadrimester(localDate);
		return firstDayOfSecondQuadrimester(localDate.getYear());
	}
	
	private static final LocalDate firstDayOfNextQuadrimesterStartingAtSecondQuadrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheSecondQuadrimester(localDate);
		return firstDayOfThirdQuadrimester(localDate.getYear());
	}
	
	private static final LocalDate firstDayOfNextQuadrimesterStartingAtThirdQuadrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheThirdQuadrimester(localDate);
		return firstDayOfFirstQuadrimester(localDate.getYear() + 1);
	}
	
	private static final LocalDate lastDayOfNextQuadrimesterStartingAtFirstQuadrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFirstQuadrimester(localDate);
		return lastDayOfSecondQuadrimester(localDate.getYear());
	}
	
	private static final LocalDate lastDayOfNextQuadrimesterStartingAtSecondQuadrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheSecondQuadrimester(localDate);
		return lastDayOfThirdQuadrimester(localDate.getYear());
	}
	
	private static final LocalDate lastDayOfNextQuadrimesterStartingAtThirdQuadrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheThirdQuadrimester(localDate);
		return lastDayOfFirstQuadrimester(localDate.getYear() + 1);
	}
	
	// PREVIOUS QUADRIMESTER
	
	private static final LocalDate firstDayOfPreviousQuadrimesterStartingAtFirstQuadrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFirstQuadrimester(localDate);
		return firstDayOfThirdQuadrimester(localDate.getYear() - 1);
	}
	
	private static final LocalDate firstDayOfPreviousQuadrimesterStartingAtSecondQuadrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheSecondQuadrimester(localDate);
		return firstDayOfFirstQuadrimester(localDate.getYear());
	}
	
	private static final LocalDate firstDayOfPreviousQuadrimesterStartingAtThirdQuadrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheThirdQuadrimester(localDate);
		return firstDayOfSecondQuadrimester(localDate.getYear());
	}
	
	private static final LocalDate lastDayOfPreviousQuadrimesterStartingAtFirstQuadrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFirstQuadrimester(localDate);
		return lastDayOfThirdQuadrimester(localDate.getYear() - 1);
	}
	
	private static final LocalDate lastDayOfPreviousQuadrimesterStartingAtSecondQuadrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheSecondQuadrimester(localDate);
		return lastDayOfFirstQuadrimester(localDate.getYear());
	}
	
	private static final LocalDate lastDayOfPreviousQuadrimesterStartingAtThirdQuadrimester(final LocalDate localDate) {
		throwExceptionIfIsNotTheThirdQuadrimester(localDate);
		return lastDayOfSecondQuadrimester(localDate.getYear());
	}
	
//	public enum QUADRIMESTER {
//		FIRST, 
//		SECOND, 
//		THIRD
//	}
	
}
