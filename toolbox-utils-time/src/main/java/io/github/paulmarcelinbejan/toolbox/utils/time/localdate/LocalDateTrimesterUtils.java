package io.github.paulmarcelinbejan.toolbox.utils.time.localdate;

import static io.github.paulmarcelinbejan.toolbox.utils.time.localdate.LocalDateUtils.buildLocalDate;
import static io.github.paulmarcelinbejan.toolbox.utils.time.localdate.LocalDateUtils.isFirstTrimester;
import static io.github.paulmarcelinbejan.toolbox.utils.time.localdate.LocalDateUtils.isFourthTrimester;
import static io.github.paulmarcelinbejan.toolbox.utils.time.localdate.LocalDateUtils.isSecondTrimester;
import static io.github.paulmarcelinbejan.toolbox.utils.time.localdate.LocalDateUtils.isThirdTrimester;
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
 *  <caption>Trimester Dates</caption>
 * 	<tr>
 * 		<th></th>
 * 		<th>First Day</th>
 * 		<th>Last Day</th>
 * 	</tr>
 * 	<tr>
 *  	<th>FIRST</th>
 *  	<td>1st January</td>
 *  	<td>31st March</td>
 *  </tr>
 *  <tr>
 *  	<th>SECOND</th>
 *  	<td>1st April</td>
 *  	<td>30th June</td>
 *  </tr>
 *  <tr>
 *  	<th>THIRD</th>
 *  	<td>1st July</td>
 *  	<td>30th September</td>
 *  </tr>
 *  <tr>
 *  	<th>FOURTH</th>
 *  	<td>1st October</td>
 *  	<td>31st December</td>
 *  </tr>
 * </table>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocalDateTrimesterUtils {

	private static final Map<Month, Function<LocalDate, LocalDate>> FIRST_DAY_OF_CURRENT_TRIMESTER = initializeFirstDayOfCurrentTrimesterMap();
	
	private static final Map<Month, Function<LocalDate, LocalDate>> LAST_DAY_OF_CURRENT_TRIMESTER = initializeLastDayOfCurrentTrimesterMap();
	
	private static final Map<Month, Function<LocalDate, LocalDate>> FIRST_DAY_OF_NEXT_TRIMESTER = initializeFirstDayOfNextTrimesterMap();
	
	private static final Map<Month, Function<LocalDate, LocalDate>> LAST_DAY_OF_NEXT_TRIMESTER = initializeLastDayOfNextTrimesterMap();
	
	private static final Map<Month, Function<LocalDate, LocalDate>> FIRST_DAY_OF_PREVIOUS_TRIMESTER = initializeFirstDayOfPreviousTrimesterMap();
	
	private static final Map<Month, Function<LocalDate, LocalDate>> LAST_DAY_OF_PREVIOUS_TRIMESTER = initializeLastDayOfPreviousTrimesterMap();
	
	// FIRST DAY of CURRENT TRIMESTER
	
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeFirstDayOfCurrentTrimesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST TRIMESTER
		map.put(JANUARY, LocalDateTrimesterUtils::firstDayOfCurrentTrimesterStartingAtFirstTrimester);
		map.put(FEBRUARY, LocalDateTrimesterUtils::firstDayOfCurrentTrimesterStartingAtFirstTrimester);
		map.put(MARCH, LocalDateTrimesterUtils::firstDayOfCurrentTrimesterStartingAtFirstTrimester);
		
		// SECOND TRIMESTER
		map.put(APRIL, LocalDateTrimesterUtils::firstDayOfCurrentTrimesterStartingAtSecondTrimester);
		map.put(MAY, LocalDateTrimesterUtils::firstDayOfCurrentTrimesterStartingAtSecondTrimester);
		map.put(JUNE, LocalDateTrimesterUtils::firstDayOfCurrentTrimesterStartingAtSecondTrimester);
		
		// THIRD TRIMESTER
		map.put(JULY, LocalDateTrimesterUtils::firstDayOfCurrentTrimesterStartingAtThirdTrimester);
		map.put(AUGUST, LocalDateTrimesterUtils::firstDayOfCurrentTrimesterStartingAtThirdTrimester);
		map.put(SEPTEMBER, LocalDateTrimesterUtils::firstDayOfCurrentTrimesterStartingAtThirdTrimester);
		
		// FOURTH TRIMESTER
		map.put(OCTOBER, LocalDateTrimesterUtils::firstDayOfCurrentTrimesterStartingAtFourthTrimester);
		map.put(NOVEMBER, LocalDateTrimesterUtils::firstDayOfCurrentTrimesterStartingAtFourthTrimester);
		map.put(DECEMBER, LocalDateTrimesterUtils::firstDayOfCurrentTrimesterStartingAtFourthTrimester);
		
		return map;
	}
	
	// LAST DAY of CURRENT TRIMESTER
	
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeLastDayOfCurrentTrimesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST TRIMESTER
		map.put(JANUARY, LocalDateTrimesterUtils::lastDayOfCurrentTrimesterStartingAtFirstTrimester);
		map.put(FEBRUARY, LocalDateTrimesterUtils::lastDayOfCurrentTrimesterStartingAtFirstTrimester);
		map.put(MARCH, LocalDateTrimesterUtils::lastDayOfCurrentTrimesterStartingAtFirstTrimester);
		
		// SECOND TRIMESTER
		map.put(APRIL, LocalDateTrimesterUtils::lastDayOfCurrentTrimesterStartingAtSecondTrimester);
		map.put(MAY, LocalDateTrimesterUtils::lastDayOfCurrentTrimesterStartingAtSecondTrimester);
		map.put(JUNE, LocalDateTrimesterUtils::lastDayOfCurrentTrimesterStartingAtSecondTrimester);
		
		// THIRD TRIMESTER
		map.put(JULY, LocalDateTrimesterUtils::lastDayOfCurrentTrimesterStartingAtThirdTrimester);
		map.put(AUGUST, LocalDateTrimesterUtils::lastDayOfCurrentTrimesterStartingAtThirdTrimester);
		map.put(SEPTEMBER, LocalDateTrimesterUtils::lastDayOfCurrentTrimesterStartingAtThirdTrimester);
		
		// FOURTH TRIMESTER
		map.put(OCTOBER, LocalDateTrimesterUtils::lastDayOfCurrentTrimesterStartingAtFourthTrimester);
		map.put(NOVEMBER, LocalDateTrimesterUtils::lastDayOfCurrentTrimesterStartingAtFourthTrimester);
		map.put(DECEMBER, LocalDateTrimesterUtils::lastDayOfCurrentTrimesterStartingAtFourthTrimester);
		
		return map;
	}
	
	// FIRST DAY of NEXT TRIMESTER
	
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeFirstDayOfNextTrimesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST TRIMESTER
		map.put(JANUARY, LocalDateTrimesterUtils::firstDayOfNextTrimesterStartingAtFirstTrimester);
		map.put(FEBRUARY, LocalDateTrimesterUtils::firstDayOfNextTrimesterStartingAtFirstTrimester);
		map.put(MARCH, LocalDateTrimesterUtils::firstDayOfNextTrimesterStartingAtFirstTrimester);
		
		// SECOND TRIMESTER
		map.put(APRIL, LocalDateTrimesterUtils::firstDayOfNextTrimesterStartingAtSecondTrimester);
		map.put(MAY, LocalDateTrimesterUtils::firstDayOfNextTrimesterStartingAtSecondTrimester);
		map.put(JUNE, LocalDateTrimesterUtils::firstDayOfNextTrimesterStartingAtSecondTrimester);
		
		// THIRD TRIMESTER
		map.put(JULY, LocalDateTrimesterUtils::firstDayOfNextTrimesterStartingAtThirdTrimester);
		map.put(AUGUST, LocalDateTrimesterUtils::firstDayOfNextTrimesterStartingAtThirdTrimester);
		map.put(SEPTEMBER, LocalDateTrimesterUtils::firstDayOfNextTrimesterStartingAtThirdTrimester);
		
		// FOURTH TRIMESTER
		map.put(OCTOBER, LocalDateTrimesterUtils::firstDayOfNextTrimesterStartingAtFourthTrimester);
		map.put(NOVEMBER, LocalDateTrimesterUtils::firstDayOfNextTrimesterStartingAtFourthTrimester);
		map.put(DECEMBER, LocalDateTrimesterUtils::firstDayOfNextTrimesterStartingAtFourthTrimester);
		
		return map;
	}
	
	// LAST DAY of NEXT TRIMESTER
	
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeLastDayOfNextTrimesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST TRIMESTER
		map.put(JANUARY, LocalDateTrimesterUtils::lastDayOfNextTrimesterStartingAtFirstTrimester);
		map.put(FEBRUARY, LocalDateTrimesterUtils::lastDayOfNextTrimesterStartingAtFirstTrimester);
		map.put(MARCH, LocalDateTrimesterUtils::lastDayOfNextTrimesterStartingAtFirstTrimester);
		
		// SECOND TRIMESTER
		map.put(APRIL, LocalDateTrimesterUtils::lastDayOfNextTrimesterStartingAtSecondTrimester);
		map.put(MAY, LocalDateTrimesterUtils::lastDayOfNextTrimesterStartingAtSecondTrimester);
		map.put(JUNE, LocalDateTrimesterUtils::lastDayOfNextTrimesterStartingAtSecondTrimester);
		
		// THIRD TRIMESTER
		map.put(JULY, LocalDateTrimesterUtils::lastDayOfNextTrimesterStartingAtThirdTrimester);
		map.put(AUGUST, LocalDateTrimesterUtils::lastDayOfNextTrimesterStartingAtThirdTrimester);
		map.put(SEPTEMBER, LocalDateTrimesterUtils::lastDayOfNextTrimesterStartingAtThirdTrimester);
		
		// FOURTH TRIMESTER
		map.put(OCTOBER, LocalDateTrimesterUtils::lastDayOfNextTrimesterStartingAtFourthTrimester);
		map.put(NOVEMBER, LocalDateTrimesterUtils::lastDayOfNextTrimesterStartingAtFourthTrimester);
		map.put(DECEMBER, LocalDateTrimesterUtils::lastDayOfNextTrimesterStartingAtFourthTrimester);
		
		return map;
	}
	
	// FIRST DAY of PREVIOUS TRIMESTER
	
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeFirstDayOfPreviousTrimesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST TRIMESTER
		map.put(JANUARY, LocalDateTrimesterUtils::firstDayOfPreviousTrimesterStartingAtFirstTrimester);
		map.put(FEBRUARY, LocalDateTrimesterUtils::firstDayOfPreviousTrimesterStartingAtFirstTrimester);
		map.put(MARCH, LocalDateTrimesterUtils::firstDayOfPreviousTrimesterStartingAtFirstTrimester);
		
		// SECOND TRIMESTER
		map.put(APRIL, LocalDateTrimesterUtils::firstDayOfPreviousTrimesterStartingAtSecondTrimester);
		map.put(MAY, LocalDateTrimesterUtils::firstDayOfPreviousTrimesterStartingAtSecondTrimester);
		map.put(JUNE, LocalDateTrimesterUtils::firstDayOfPreviousTrimesterStartingAtSecondTrimester);
		
		// THIRD TRIMESTER
		map.put(JULY, LocalDateTrimesterUtils::firstDayOfPreviousTrimesterStartingAtThirdTrimester);
		map.put(AUGUST, LocalDateTrimesterUtils::firstDayOfPreviousTrimesterStartingAtThirdTrimester);
		map.put(SEPTEMBER, LocalDateTrimesterUtils::firstDayOfPreviousTrimesterStartingAtThirdTrimester);
		
		// FOURTH TRIMESTER
		map.put(OCTOBER, LocalDateTrimesterUtils::firstDayOfPreviousTrimesterStartingAtFourthTrimester);
		map.put(NOVEMBER, LocalDateTrimesterUtils::firstDayOfPreviousTrimesterStartingAtFourthTrimester);
		map.put(DECEMBER, LocalDateTrimesterUtils::firstDayOfPreviousTrimesterStartingAtFourthTrimester);
		
		return map;
	}
	
	// LAST DAY of PREVIOUS TRIMESTER
	
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeLastDayOfPreviousTrimesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST TRIMESTER
		map.put(JANUARY, LocalDateTrimesterUtils::lastDayOfPreviousTrimesterStartingAtFirstTrimester);
		map.put(FEBRUARY, LocalDateTrimesterUtils::lastDayOfPreviousTrimesterStartingAtFirstTrimester);
		map.put(MARCH, LocalDateTrimesterUtils::lastDayOfPreviousTrimesterStartingAtFirstTrimester);
		
		// SECOND TRIMESTER
		map.put(APRIL, LocalDateTrimesterUtils::lastDayOfPreviousTrimesterStartingAtSecondTrimester);
		map.put(MAY, LocalDateTrimesterUtils::lastDayOfPreviousTrimesterStartingAtSecondTrimester);
		map.put(JUNE, LocalDateTrimesterUtils::lastDayOfPreviousTrimesterStartingAtSecondTrimester);
		
		// THIRD TRIMESTER
		map.put(JULY, LocalDateTrimesterUtils::lastDayOfPreviousTrimesterStartingAtThirdTrimester);
		map.put(AUGUST, LocalDateTrimesterUtils::lastDayOfPreviousTrimesterStartingAtThirdTrimester);
		map.put(SEPTEMBER, LocalDateTrimesterUtils::lastDayOfPreviousTrimesterStartingAtThirdTrimester);
		
		// FOURTH TRIMESTER
		map.put(OCTOBER, LocalDateTrimesterUtils::lastDayOfPreviousTrimesterStartingAtFourthTrimester);
		map.put(NOVEMBER, LocalDateTrimesterUtils::lastDayOfPreviousTrimesterStartingAtFourthTrimester);
		map.put(DECEMBER, LocalDateTrimesterUtils::lastDayOfPreviousTrimesterStartingAtFourthTrimester);
		
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

	public static Map<Month, Function<LocalDate, LocalDate>> getFirstDayOfCurrentTrimester() {
		return FIRST_DAY_OF_CURRENT_TRIMESTER;
	}

	public static Map<Month, Function<LocalDate, LocalDate>> getLastDayOfCurrentTrimester() {
		return LAST_DAY_OF_CURRENT_TRIMESTER;
	}

	public static Map<Month, Function<LocalDate, LocalDate>> getFirstDayOfNextTrimester() {
		return FIRST_DAY_OF_NEXT_TRIMESTER;
	}

	public static Map<Month, Function<LocalDate, LocalDate>> getLastDayOfNextTrimester() {
		return LAST_DAY_OF_NEXT_TRIMESTER;
	}

	public static Map<Month, Function<LocalDate, LocalDate>> getFirstDayOfPreviousTrimester() {
		return FIRST_DAY_OF_PREVIOUS_TRIMESTER;
	}

	public static Map<Month, Function<LocalDate, LocalDate>> getLastDayOfPreviousTrimester() {
		return LAST_DAY_OF_PREVIOUS_TRIMESTER;
	}
	
//	public enum TRIMESTER {
//	    FIRST,
//	    SECOND,
//	    THIRD, 
//	    FORUTH
//	}
	
}
