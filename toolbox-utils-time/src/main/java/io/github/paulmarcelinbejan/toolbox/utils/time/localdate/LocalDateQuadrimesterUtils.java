package io.github.paulmarcelinbejan.toolbox.utils.time.localdate;

import static io.github.paulmarcelinbejan.toolbox.utils.time.localdate.LocalDateUtils.buildLocalDate;
import static io.github.paulmarcelinbejan.toolbox.utils.time.localdate.LocalDateUtils.isFirstQuadrimester;
import static io.github.paulmarcelinbejan.toolbox.utils.time.localdate.LocalDateUtils.isSecondQuadrimester;
import static io.github.paulmarcelinbejan.toolbox.utils.time.localdate.LocalDateUtils.isThirdQuadrimester;
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
 *  <caption>Quadrimester Dates</caption>
 * 	<tr>
 * 		<th></th>
 * 		<th>First Day</th>
 * 		<th>Last Day</th>
 * 	</tr>
 * 	<tr>
 *  	<th>FIRST</th>
 *  	<td>1st January</td>
 *  	<td>30th April</td>
 *  </tr>
 *  <tr>
 *  	<th>SECOND</th>
 *  	<td>1st May</td>
 *  	<td>31st August</td>
 *  </tr>
 *  <tr>
 *  	<th>THIRD</th>
 *  	<td>1st September</td>
 *  	<td>31st December</td>
 *  </tr>
 * </table>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocalDateQuadrimesterUtils {

    /**
     * A map of months to functions that return the first day of the current quadrimester.
     */
    private static final Map<Month, Function<LocalDate, LocalDate>> FIRST_DAY_OF_CURRENT_QUADRIMESTER = initializeFirstDayOfCurrentQuadrimesterMap();

    /**
     * A map of months to functions that return the last day of the current quadrimester.
     */
    private static final Map<Month, Function<LocalDate, LocalDate>> LAST_DAY_OF_CURRENT_QUADRIMESTER = initializeLastDayOfCurrentQuadrimesterMap();

    /**
     * A map of months to functions that return the first day of the next quadrimester.
     */
    private static final Map<Month, Function<LocalDate, LocalDate>> FIRST_DAY_OF_NEXT_QUADRIMESTER = initializeFirstDayOfNextQuadrimesterMap();

    /**
     * A map of months to functions that return the last day of the next quadrimester.
     */
    private static final Map<Month, Function<LocalDate, LocalDate>> LAST_DAY_OF_NEXT_QUADRIMESTER = initializeLastDayOfNextQuadrimesterMap();

    /**
     * A map of months to functions that return the first day of the previous quadrimester.
     */
    private static final Map<Month, Function<LocalDate, LocalDate>> FIRST_DAY_OF_PREVIOUS_QUADRIMESTER = initializeFirstDayOfPreviousQuadrimesterMap();

    /**
     * A map of months to functions that return the last day of the previous quadrimester.
     */
    private static final Map<Month, Function<LocalDate, LocalDate>> LAST_DAY_OF_PREVIOUS_QUADRIMESTER = initializeLastDayOfPreviousQuadrimesterMap();
    
	// FIRST DAY of CURRENT QUADRIMESTER
	
    /**
     * Initializes a map containing functions to calculate the first day of the current quadrimester for each month.
     *
     * @return A map where each entry represents a month and its corresponding function to calculate the first day
     *         of the current quadrimester.
     */
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeFirstDayOfCurrentQuadrimesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST QUADRIMESTER
		map.put(JANUARY, LocalDateQuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtFirstQuadrimester);
		map.put(FEBRUARY, LocalDateQuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtFirstQuadrimester);
		map.put(MARCH, LocalDateQuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtFirstQuadrimester);
		map.put(APRIL, LocalDateQuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtFirstQuadrimester);
		
		// SECOND QUADRIMESTER
		map.put(MAY, LocalDateQuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtSecondQuadrimester);
		map.put(JUNE, LocalDateQuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtSecondQuadrimester);
		map.put(JULY, LocalDateQuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtSecondQuadrimester);
		map.put(AUGUST, LocalDateQuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtSecondQuadrimester);
		
		// THIRD QUADRIMESTER
		map.put(SEPTEMBER, LocalDateQuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtThirdQuadrimester);
		map.put(OCTOBER, LocalDateQuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtThirdQuadrimester);
		map.put(NOVEMBER, LocalDateQuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtThirdQuadrimester);
		map.put(DECEMBER, LocalDateQuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtThirdQuadrimester);
		
		return map;
	}
	
	// LAST DAY of CURRENT QUADRIMESTER
	
	/**
	 * Initializes a map containing functions to calculate the last day of the current quadrimester for each month.
	 *
	 * @return A map where each entry represents a month and its corresponding function to calculate the last day
	 *         of the current quadrimester.
	 */
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeLastDayOfCurrentQuadrimesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST QUADRIMESTER
		map.put(JANUARY, LocalDateQuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtFirstQuadrimester);
		map.put(FEBRUARY, LocalDateQuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtFirstQuadrimester);
		map.put(MARCH, LocalDateQuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtFirstQuadrimester);
		map.put(APRIL, LocalDateQuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtFirstQuadrimester);
		
		// SECOND QUADRIMESTER
		map.put(MAY, LocalDateQuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtSecondQuadrimester);
		map.put(JUNE, LocalDateQuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtSecondQuadrimester);
		map.put(JULY, LocalDateQuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtSecondQuadrimester);
		map.put(AUGUST, LocalDateQuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtSecondQuadrimester);
		
		// THIRD QUADRIMESTER
		map.put(SEPTEMBER, LocalDateQuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtThirdQuadrimester);
		map.put(OCTOBER, LocalDateQuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtThirdQuadrimester);
		map.put(NOVEMBER, LocalDateQuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtThirdQuadrimester);
		map.put(DECEMBER, LocalDateQuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtThirdQuadrimester);
		
		return map;
	}
	
	// FIRST DAY of NEXT QUADRIMESTER
	
	/**
	 * Initializes a map containing functions to calculate the first day of the next quadrimester for each month.
	 *
	 * @return A map where each entry represents a month and its corresponding function to calculate the first day
	 *         of the next quadrimester.
	 */
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeFirstDayOfNextQuadrimesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST QUADRIMESTER
		map.put(JANUARY, LocalDateQuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtFirstQuadrimester);
		map.put(FEBRUARY, LocalDateQuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtFirstQuadrimester);
		map.put(MARCH, LocalDateQuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtFirstQuadrimester);
		map.put(APRIL, LocalDateQuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtFirstQuadrimester);
		
		// SECOND QUADRIMESTER
		map.put(MAY, LocalDateQuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtSecondQuadrimester);
		map.put(JUNE, LocalDateQuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtSecondQuadrimester);
		map.put(JULY, LocalDateQuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtSecondQuadrimester);
		map.put(AUGUST, LocalDateQuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtSecondQuadrimester);
		
		// THIRD QUADRIMESTER
		map.put(SEPTEMBER, LocalDateQuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtThirdQuadrimester);
		map.put(OCTOBER, LocalDateQuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtThirdQuadrimester);
		map.put(NOVEMBER, LocalDateQuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtThirdQuadrimester);
		map.put(DECEMBER, LocalDateQuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtThirdQuadrimester);
		
		return map;
	}
	
	// LAST DAY of NEXT QUADRIMESTER
	
	/**
	 * Initializes a map containing functions to calculate the last day of the next quadrimester for each month.
	 *
	 * @return A map where each entry represents a month and its corresponding function to calculate the last day
	 *         of the next quadrimester.
	 */
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeLastDayOfNextQuadrimesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST QUADRIMESTER
		map.put(JANUARY, LocalDateQuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtFirstQuadrimester);
		map.put(FEBRUARY, LocalDateQuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtFirstQuadrimester);
		map.put(MARCH, LocalDateQuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtFirstQuadrimester);
		map.put(APRIL, LocalDateQuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtFirstQuadrimester);
		
		// SECOND QUADRIMESTER
		map.put(MAY, LocalDateQuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtSecondQuadrimester);
		map.put(JUNE, LocalDateQuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtSecondQuadrimester);
		map.put(JULY, LocalDateQuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtSecondQuadrimester);
		map.put(AUGUST, LocalDateQuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtSecondQuadrimester);
		
		// THIRD QUADRIMESTER
		map.put(SEPTEMBER, LocalDateQuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtThirdQuadrimester);
		map.put(OCTOBER, LocalDateQuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtThirdQuadrimester);
		map.put(NOVEMBER, LocalDateQuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtThirdQuadrimester);
		map.put(DECEMBER, LocalDateQuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtThirdQuadrimester);
		
		return map;
	}
	
	// FIRST DAY of PREVIOUS QUADRIMESTER
	
	/**
	 * Initializes a map containing functions to calculate the first day of the previous quadrimester for each month.
	 *
	 * @return A map where each entry represents a month and its corresponding function to calculate the first day
	 *         of the previous quadrimester.
	 */
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeFirstDayOfPreviousQuadrimesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST QUADRIMESTER
		map.put(JANUARY, LocalDateQuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtFirstQuadrimester);
		map.put(FEBRUARY, LocalDateQuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtFirstQuadrimester);
		map.put(MARCH, LocalDateQuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtFirstQuadrimester);
		map.put(APRIL, LocalDateQuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtFirstQuadrimester);
		
		// SECOND QUADRIMESTER
		map.put(MAY, LocalDateQuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtSecondQuadrimester);
		map.put(JUNE, LocalDateQuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtSecondQuadrimester);
		map.put(JULY, LocalDateQuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtSecondQuadrimester);
		map.put(AUGUST, LocalDateQuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtSecondQuadrimester);
		
		// THIRD QUADRIMESTER
		map.put(SEPTEMBER, LocalDateQuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtThirdQuadrimester);
		map.put(OCTOBER, LocalDateQuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtThirdQuadrimester);
		map.put(NOVEMBER, LocalDateQuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtThirdQuadrimester);
		map.put(DECEMBER, LocalDateQuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtThirdQuadrimester);
		
		return map;
	}
	
	// LAST DAY of PREVIOUS QUADRIMESTER
	
	/**
	 * Initializes a map containing functions to calculate the last day of the previous quadrimester for each month.
	 *
	 * @return A map where each entry represents a month and its corresponding function to calculate the last day
	 *         of the previous quadrimester.
	 */

	private static final Map<Month, Function<LocalDate, LocalDate>> initializeLastDayOfPreviousQuadrimesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST QUADRIMESTER
		map.put(JANUARY, LocalDateQuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtFirstQuadrimester);
		map.put(FEBRUARY, LocalDateQuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtFirstQuadrimester);
		map.put(MARCH, LocalDateQuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtFirstQuadrimester);
		map.put(APRIL, LocalDateQuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtFirstQuadrimester);
		
		// SECOND QUADRIMESTER
		map.put(MAY, LocalDateQuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtSecondQuadrimester);
		map.put(JUNE, LocalDateQuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtSecondQuadrimester);
		map.put(JULY, LocalDateQuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtSecondQuadrimester);
		map.put(AUGUST, LocalDateQuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtSecondQuadrimester);
		
		// THIRD QUADRIMESTER
		map.put(SEPTEMBER, LocalDateQuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtThirdQuadrimester);
		map.put(OCTOBER, LocalDateQuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtThirdQuadrimester);
		map.put(NOVEMBER, LocalDateQuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtThirdQuadrimester);
		map.put(DECEMBER, LocalDateQuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtThirdQuadrimester);
		
		return map;
	}
	
	/**
	 * Calculates the first day of the first quadrimester for a given year.
	 *
	 * @param year The year for which to calculate the first day.
	 * @return The first day of the first quadrimester.
	 */
	private static final LocalDate firstDayOfFirstQuadrimester(final int year) {
	    return buildLocalDate(year, 1, 1);
	}

	/**
	 * Calculates the first day of the second quadrimester for a given year.
	 *
	 * @param year The year for which to calculate the first day.
	 * @return The first day of the second quadrimester.
	 */
	private static final LocalDate firstDayOfSecondQuadrimester(final int year) {
	    return buildLocalDate(year, 5, 1);
	}

	/**
	 * Calculates the first day of the third quadrimester for a given year.
	 *
	 * @param year The year for which to calculate the first day.
	 * @return The first day of the third quadrimester.
	 */
	private static final LocalDate firstDayOfThirdQuadrimester(final int year) {
	    return buildLocalDate(year, 9, 1);
	}

	/**
	 * Calculates the last day of the first quadrimester for a given year.
	 *
	 * @param year The year for which to calculate the last day.
	 * @return The last day of the first quadrimester.
	 */
	private static final LocalDate lastDayOfFirstQuadrimester(final int year) {
	    return buildLocalDate(year, 4, 30);
	}

	/**
	 * Calculates the last day of the second quadrimester for a given year.
	 *
	 * @param year The year for which to calculate the last day.
	 * @return The last day of the second quadrimester.
	 */
	private static final LocalDate lastDayOfSecondQuadrimester(final int year) {
	    return buildLocalDate(year, 8, 31);
	}

	/**
	 * Calculates the last day of the third quadrimester for a given year.
	 *
	 * @param year The year for which to calculate the last day.
	 * @return The last day of the third quadrimester.
	 */
	private static final LocalDate lastDayOfThirdQuadrimester(final int year) {
	    return buildLocalDate(year, 12, 31);
	}

	/**
	 * Throws an exception if the given date is not in the first quadrimester.
	 *
	 * @param localDate The date to check.
	 * @throws IllegalArgumentException If the date is not in the first quadrimester.
	 */
	private static final void throwExceptionIfIsNotTheFirstQuadrimester(final LocalDate localDate) {
	    if (!isFirstQuadrimester(localDate)) throw new IllegalArgumentException("The localDate is not in the first quadrimester");
	}

	/**
	 * Throws an exception if the given date is not in the second quadrimester.
	 *
	 * @param localDate The date to check.
	 * @throws IllegalArgumentException If the date is not in the second quadrimester.
	 */
	private static final void throwExceptionIfIsNotTheSecondQuadrimester(final LocalDate localDate) {
	    if (!isSecondQuadrimester(localDate)) throw new IllegalArgumentException("The localDate is not in the second quadrimester");
	}

	/**
	 * Throws an exception if the given date is not in the third quadrimester.
	 *
	 * @param localDate The date to check.
	 * @throws IllegalArgumentException If the date is not in the third quadrimester.
	 */
	private static final void throwExceptionIfIsNotTheThirdQuadrimester(final LocalDate localDate) {
	    if (!isThirdQuadrimester(localDate)) throw new IllegalArgumentException("The localDate is not in the third quadrimester");
	}

	// CURRENT QUADRIMESTER

	/**
	 * Calculates the first day of the current quadrimester, starting in the first quadrimester, for a given date.
	 *
	 * @param localDate The date for which to calculate the first day.
	 * @return The first day of the current quadrimester.
	 * @throws IllegalArgumentException If the date is not in the first quadrimester.
	 */
	private static final LocalDate firstDayOfCurrentQuadrimesterStartingAtFirstQuadrimester(final LocalDate localDate) {
	    throwExceptionIfIsNotTheFirstQuadrimester(localDate);
	    return firstDayOfFirstQuadrimester(localDate.getYear());
	}

	/**
	 * Calculates the first day of the current quadrimester, starting in the second quadrimester, for a given date.
	 *
	 * @param localDate The date for which to calculate the first day.
	 * @return The first day of the current quadrimester.
	 * @throws IllegalArgumentException If the date is not in the second quadrimester.
	 */
	private static final LocalDate firstDayOfCurrentQuadrimesterStartingAtSecondQuadrimester(final LocalDate localDate) {
	    throwExceptionIfIsNotTheSecondQuadrimester(localDate);
	    return firstDayOfSecondQuadrimester(localDate.getYear());
	}

	/**
	 * Calculates the first day of the current quadrimester, starting in the third quadrimester, for a given date.
	 *
	 * @param localDate The date for which to calculate the first day.
	 * @return The first day of the current quadrimester.
	 * @throws IllegalArgumentException If the date is not in the third quadrimester.
	 */
	private static final LocalDate firstDayOfCurrentQuadrimesterStartingAtThirdQuadrimester(final LocalDate localDate) {
	    throwExceptionIfIsNotTheThirdQuadrimester(localDate);
	    return firstDayOfThirdQuadrimester(localDate.getYear());
	}

	/**
	 * Calculates the last day of the current quadrimester, starting in the first quadrimester, for a given date.
	 *
	 * @param localDate The date for which to calculate the last day.
	 * @return The last day of the current quadrimester.
	 * @throws IllegalArgumentException If the date is not in the first quadrimester.
	 */
	private static final LocalDate lastDayOfCurrentQuadrimesterStartingAtFirstQuadrimester(final LocalDate localDate) {
	    throwExceptionIfIsNotTheFirstQuadrimester(localDate);
	    return lastDayOfFirstQuadrimester(localDate.getYear());
	}

	/**
	 * Calculates the last day of the current quadrimester, starting in the second quadrimester, for a given date.
	 *
	 * @param localDate The date for which to calculate the last day.
	 * @return The last day of the current quadrimester.
	 * @throws IllegalArgumentException If the date is not in the second quadrimester.
	 */
	private static final LocalDate lastDayOfCurrentQuadrimesterStartingAtSecondQuadrimester(final LocalDate localDate) {
	    throwExceptionIfIsNotTheSecondQuadrimester(localDate);
	    return lastDayOfSecondQuadrimester(localDate.getYear());
	}

	/**
	 * Calculates the last day of the current quadrimester, starting in the third quadrimester, for a given date.
	 *
	 * @param localDate The date for which to calculate the last day.
	 * @return The last day of the current quadrimester.
	 * @throws IllegalArgumentException If the date is not in the third quadrimester.
	 */
	private static final LocalDate lastDayOfCurrentQuadrimesterStartingAtThirdQuadrimester(final LocalDate localDate) {
	    throwExceptionIfIsNotTheThirdQuadrimester(localDate);
	    return lastDayOfThirdQuadrimester(localDate.getYear());
	}

	// NEXT QUADRIMESTER

	/**
	 * Calculates the first day of the next quadrimester, starting in the first quadrimester, for a given date.
	 *
	 * @param localDate The date for which to calculate the first day.
	 * @return The first day of the next quadrimester.
	 * @throws IllegalArgumentException If the date is not in the first quadrimester.
	 */
	private static final LocalDate firstDayOfNextQuadrimesterStartingAtFirstQuadrimester(final LocalDate localDate) {
	    throwExceptionIfIsNotTheFirstQuadrimester(localDate);
	    return firstDayOfSecondQuadrimester(localDate.getYear());
	}

	/**
	 * Calculates the first day of the next quadrimester, starting in the second quadrimester, for a given date.
	 *
	 * @param localDate The date for which to calculate the first day.
	 * @return The first day of the next quadrimester.
	 * @throws IllegalArgumentException If the date is not in the second quadrimester.
	 */
	private static final LocalDate firstDayOfNextQuadrimesterStartingAtSecondQuadrimester(final LocalDate localDate) {
	    throwExceptionIfIsNotTheSecondQuadrimester(localDate);
	    return firstDayOfThirdQuadrimester(localDate.getYear());
	}

	/**
	 * Calculates the first day of the next quadrimester, starting in the third quadrimester, for a given date.
	 *
	 * @param localDate The date for which to calculate the first day.
	 * @return The first day of the next quadrimester.
	 * @throws IllegalArgumentException If the date is not in the third quadrimester.
	 */
	private static final LocalDate firstDayOfNextQuadrimesterStartingAtThirdQuadrimester(final LocalDate localDate) {
	    throwExceptionIfIsNotTheThirdQuadrimester(localDate);
	    return firstDayOfFirstQuadrimester(localDate.getYear() + 1);
	}

	/**
	 * Calculates the last day of the next quadrimester, starting in the first quadrimester, for a given date.
	 *
	 * @param localDate The date for which to calculate the last day.
	 * @return The last day of the next quadrimester.
	 * @throws IllegalArgumentException If the date is not in the first quadrimester.
	 */
	private static final LocalDate lastDayOfNextQuadrimesterStartingAtFirstQuadrimester(final LocalDate localDate) {
	    throwExceptionIfIsNotTheFirstQuadrimester(localDate);
	    return lastDayOfSecondQuadrimester(localDate.getYear());
	}

	/**
	 * Calculates the last day of the next quadrimester, starting in the second quadrimester, for a given date.
	 *
	 * @param localDate The date for which to calculate the last day.
	 * @return The last day of the next quadrimester.
	 * @throws IllegalArgumentException If the date is not in the second quadrimester.
	 */
	private static final LocalDate lastDayOfNextQuadrimesterStartingAtSecondQuadrimester(final LocalDate localDate) {
	    throwExceptionIfIsNotTheSecondQuadrimester(localDate);
	    return lastDayOfThirdQuadrimester(localDate.getYear());
	}

	/**
	 * Calculates the last day of the next quadrimester, starting in the third quadrimester, for a given date.
	 *
	 * @param localDate The date for which to calculate the last day.
	 * @return The last day of the next quadrimester.
	 * @throws IllegalArgumentException If the date is not in the third quadrimester.
	 */
	private static final LocalDate lastDayOfNextQuadrimesterStartingAtThirdQuadrimester(final LocalDate localDate) {
	    throwExceptionIfIsNotTheThirdQuadrimester(localDate);
	    return lastDayOfFirstQuadrimester(localDate.getYear() + 1);
	}

	// PREVIOUS QUADRIMESTER

	/**
	 * Calculates the first day of the previous quadrimester, starting in the first quadrimester, for a given date.
	 *
	 * @param localDate The date for which to calculate the first day.
	 * @return The first day of the previous quadrimester.
	 * @throws IllegalArgumentException If the date is not in the first quadrimester.
	 */
	private static final LocalDate firstDayOfPreviousQuadrimesterStartingAtFirstQuadrimester(final LocalDate localDate) {
	    throwExceptionIfIsNotTheFirstQuadrimester(localDate);
	    return firstDayOfThirdQuadrimester(localDate.getYear() - 1);
	}

	/**
	 * Calculates the first day of the previous quadrimester, starting in the second quadrimester, for a given date.
	 *
	 * @param localDate The date for which to calculate the first day.
	 * @return The first day of the previous quadrimester.
	 * @throws IllegalArgumentException If the date is not in the second quadrimester.
	 */
	private static final LocalDate firstDayOfPreviousQuadrimesterStartingAtSecondQuadrimester(final LocalDate localDate) {
	    throwExceptionIfIsNotTheSecondQuadrimester(localDate);
	    return firstDayOfFirstQuadrimester(localDate.getYear());
	}

	/**
	 * Calculates the first day of the previous quadrimester, starting in the third quadrimester, for a given date.
	 *
	 * @param localDate The date for which to calculate the first day.
	 * @return The first day of the previous quadrimester.
	 * @throws IllegalArgumentException If the date is not in the third quadrimester.
	 */
	private static final LocalDate firstDayOfPreviousQuadrimesterStartingAtThirdQuadrimester(final LocalDate localDate) {
	    throwExceptionIfIsNotTheThirdQuadrimester(localDate);
	    return firstDayOfSecondQuadrimester(localDate.getYear());
	}

	/**
	 * Calculates the last day of the previous quadrimester, starting in the first quadrimester, for a given date.
	 *
	 * @param localDate The date for which to calculate the last day.
	 * @return The last day of the previous quadrimester.
	 * @throws IllegalArgumentException If the date is not in the first quadrimester.
	 */
	private static final LocalDate lastDayOfPreviousQuadrimesterStartingAtFirstQuadrimester(final LocalDate localDate) {
	    throwExceptionIfIsNotTheFirstQuadrimester(localDate);
	    return lastDayOfThirdQuadrimester(localDate.getYear() - 1);
	}

	/**
	 * Calculates the last day of the previous quadrimester, starting in the second quadrimester, for a given date.
	 *
	 * @param localDate The date for which to calculate the last day.
	 * @return The last day of the previous quadrimester.
	 * @throws IllegalArgumentException If the date is not in the second quadrimester.
	 */
	private static final LocalDate lastDayOfPreviousQuadrimesterStartingAtSecondQuadrimester(final LocalDate localDate) {
	    throwExceptionIfIsNotTheSecondQuadrimester(localDate);
	    return lastDayOfFirstQuadrimester(localDate.getYear());
	}
	
	/**
	 * Calculates the last day of the previous quadrimester, starting in the third quadrimester, for a given date.
	 *
	 * @param localDate The date for which to calculate the last day.
	 * @return The last day of the previous quadrimester.
	 * @throws IllegalArgumentException If the date is not in the third quadrimester.
	 */
	private static final LocalDate lastDayOfPreviousQuadrimesterStartingAtThirdQuadrimester(final LocalDate localDate) {
	    throwExceptionIfIsNotTheThirdQuadrimester(localDate);
	    return lastDayOfSecondQuadrimester(localDate.getYear());
	}

	/**
	 * Retrieves a map containing functions to calculate the first day of the current quadrimester for each month.
	 *
	 * @return A map where each entry represents a month and its corresponding function to calculate the first day
	 *         of the current quadrimester.
	 */
	public static Map<Month, Function<LocalDate, LocalDate>> getFirstDayOfCurrentQuadrimester() {
	    return FIRST_DAY_OF_CURRENT_QUADRIMESTER;
	}

	/**
	 * Retrieves a map containing functions to calculate the last day of the current quadrimester for each month.
	 *
	 * @return A map where each entry represents a month and its corresponding function to calculate the last day
	 *         of the current quadrimester.
	 */
	public static Map<Month, Function<LocalDate, LocalDate>> getLastDayOfCurrentQuadrimester() {
	    return LAST_DAY_OF_CURRENT_QUADRIMESTER;
	}

	/**
	 * Retrieves a map containing functions to calculate the first day of the next quadrimester for each month.
	 *
	 * @return A map where each entry represents a month and its corresponding function to calculate the first day
	 *         of the next quadrimester.
	 */
	public static Map<Month, Function<LocalDate, LocalDate>> getFirstDayOfNextQuadrimester() {
	    return FIRST_DAY_OF_NEXT_QUADRIMESTER;
	}

	/**
	 * Retrieves a map containing functions to calculate the last day of the next quadrimester for each month.
	 *
	 * @return A map where each entry represents a month and its corresponding function to calculate the last day
	 *         of the next quadrimester.
	 */
	public static Map<Month, Function<LocalDate, LocalDate>> getLastDayOfNextQuadrimester() {
	    return LAST_DAY_OF_NEXT_QUADRIMESTER;
	}

	/**
	 * Retrieves a map containing functions to calculate the first day of the previous quadrimester for each month.
	 *
	 * @return A map where each entry represents a month and its corresponding function to calculate the first day
	 *         of the previous quadrimester.
	 */
	public static Map<Month, Function<LocalDate, LocalDate>> getFirstDayOfPreviousQuadrimester() {
	    return FIRST_DAY_OF_PREVIOUS_QUADRIMESTER;
	}

	/**
	 * Retrieves a map containing functions to calculate the last day of the previous quadrimester for each month.
	 *
	 * @return A map where each entry represents a month and its corresponding function to calculate the last day
	 *         of the previous quadrimester.
	 */
	public static Map<Month, Function<LocalDate, LocalDate>> getLastDayOfPreviousQuadrimester() {
	    return LAST_DAY_OF_PREVIOUS_QUADRIMESTER;
	}
	
//	public enum QUADRIMESTER {
//		FIRST, 
//		SECOND, 
//		THIRD
//	}
	
}
