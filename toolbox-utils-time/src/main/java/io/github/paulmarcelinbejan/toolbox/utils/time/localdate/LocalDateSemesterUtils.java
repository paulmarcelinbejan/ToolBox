package io.github.paulmarcelinbejan.toolbox.utils.time.localdate;

import static io.github.paulmarcelinbejan.toolbox.utils.time.localdate.LocalDateUtils.buildLocalDate;
import static io.github.paulmarcelinbejan.toolbox.utils.time.localdate.LocalDateUtils.isFirstSemester;
import static io.github.paulmarcelinbejan.toolbox.utils.time.localdate.LocalDateUtils.isSecondSemester;
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
 *  <caption>Semester Dates</caption>
 * 	<tr>
 * 		<th></th>
 * 		<th>First Day</th>
 * 		<th>Last Day</th>
 * 	</tr>
 * 	<tr>
 *  	<th>FIRST</th>
 *  	<td>1st January</td>
 *  	<td>30th June</td>
 *  </tr>
 *  <tr>
 *  	<th>SECOND</th>
 *  	<td>1st July</td>
 *  	<td>31st December</td>
 *  </tr>
 * </table>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocalDateSemesterUtils {

    /**
     * Map containing functions to calculate the first day of the current semester for each month.
     */
    private static final Map<Month, Function<LocalDate, LocalDate>> FIRST_DAY_OF_CURRENT_SEMESTER = initializeFirstDayOfCurrentSemesterMap();

    /**
     * Map containing functions to calculate the last day of the current semester for each month.
     */
    private static final Map<Month, Function<LocalDate, LocalDate>> LAST_DAY_OF_CURRENT_SEMESTER = initializeLastDayOfCurrentSemesterMap();

    /**
     * Map containing functions to calculate the first day of the next semester for each month.
     */
    private static final Map<Month, Function<LocalDate, LocalDate>> FIRST_DAY_OF_NEXT_SEMESTER = initializeFirstDayOfNextSemesterMap();

    /**
     * Map containing functions to calculate the last day of the next semester for each month.
     */
    private static final Map<Month, Function<LocalDate, LocalDate>> LAST_DAY_OF_NEXT_SEMESTER = initializeLastDayOfNextSemesterMap();

    /**
     * Map containing functions to calculate the first day of the previous semester for each month.
     */
    private static final Map<Month, Function<LocalDate, LocalDate>> FIRST_DAY_OF_PREVIOUS_SEMESTER = initializeFirstDayOfPreviousSemesterMap();

    /**
     * Map containing functions to calculate the last day of the previous semester for each month.
     */
    private static final Map<Month, Function<LocalDate, LocalDate>> LAST_DAY_OF_PREVIOUS_SEMESTER = initializeLastDayOfPreviousSemesterMap();
    
	// FIRST DAY of CURRENT SEMESTER
	
    /**
     * Initializes a map with functions to calculate the first day of the current semester for each month.
     * <p>
     * The returned map contains month-function pairs, where the function takes a {@code LocalDate} parameter
     * and returns the corresponding first day of the current semester for the specified month.
     * </p>
     *
     * @return The initialized map with month-function pairs for the first day of the current semester.
     */
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeFirstDayOfCurrentSemesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST SEMESTER
		map.put(JANUARY, LocalDateSemesterUtils::firstDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(FEBRUARY, LocalDateSemesterUtils::firstDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(MARCH, LocalDateSemesterUtils::firstDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(APRIL, LocalDateSemesterUtils::firstDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(MAY, LocalDateSemesterUtils::firstDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(JUNE, LocalDateSemesterUtils::firstDayOfCurrentSemesterStartingAtFirstSemester);
		
		// SECOND SEMESTER
		map.put(JULY, LocalDateSemesterUtils::firstDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(AUGUST, LocalDateSemesterUtils::firstDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(SEPTEMBER, LocalDateSemesterUtils::firstDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(OCTOBER, LocalDateSemesterUtils::firstDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(NOVEMBER, LocalDateSemesterUtils::firstDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(DECEMBER, LocalDateSemesterUtils::firstDayOfCurrentSemesterStartingAtSecondSemester);
		
		return map;
	}
	
	// LAST DAY of CURRENT SEMESTER
	
	/**
	 * Initializes a map with functions to calculate the last day of the current semester for each month.
	 * <p>
	 * The returned map contains month-function pairs, where the function takes a {@code LocalDate} parameter
	 * and returns the corresponding last day of the current semester for the specified month.
	 * </p>
	 *
	 * @return The initialized map with month-function pairs for the last day of the current semester.
	 */
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeLastDayOfCurrentSemesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST SEMESTER
		map.put(JANUARY, LocalDateSemesterUtils::lastDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(FEBRUARY, LocalDateSemesterUtils::lastDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(MARCH, LocalDateSemesterUtils::lastDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(APRIL, LocalDateSemesterUtils::lastDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(MAY, LocalDateSemesterUtils::lastDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(JUNE, LocalDateSemesterUtils::lastDayOfCurrentSemesterStartingAtFirstSemester);
		
		// SECOND SEMESTER
		map.put(JULY, LocalDateSemesterUtils::lastDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(AUGUST, LocalDateSemesterUtils::lastDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(SEPTEMBER, LocalDateSemesterUtils::lastDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(OCTOBER, LocalDateSemesterUtils::lastDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(NOVEMBER, LocalDateSemesterUtils::lastDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(DECEMBER, LocalDateSemesterUtils::lastDayOfCurrentSemesterStartingAtSecondSemester);
		
		return map;
	}
	
	// FIRST DAY of NEXT SEMESTER
	
	/**
	 * Initializes a map with functions to calculate the first day of the next semester for each month.
	 * <p>
	 * The returned map contains month-function pairs, where the function takes a {@code LocalDate} parameter
	 * and returns the corresponding first day of the next semester for the specified month.
	 * </p>
	 *
	 * @return The initialized map with month-function pairs for the first day of the next semester.
	 */
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeFirstDayOfNextSemesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST SEMESTER
		map.put(JANUARY, LocalDateSemesterUtils::firstDayOfNextSemesterStartingAtFirstSemester);
		map.put(FEBRUARY, LocalDateSemesterUtils::firstDayOfNextSemesterStartingAtFirstSemester);
		map.put(MARCH, LocalDateSemesterUtils::firstDayOfNextSemesterStartingAtFirstSemester);
		map.put(APRIL, LocalDateSemesterUtils::firstDayOfNextSemesterStartingAtFirstSemester);
		map.put(MAY, LocalDateSemesterUtils::firstDayOfNextSemesterStartingAtFirstSemester);
		map.put(JUNE, LocalDateSemesterUtils::firstDayOfNextSemesterStartingAtFirstSemester);
		
		// SECOND SEMESTER
		map.put(JULY, LocalDateSemesterUtils::firstDayOfNextSemesterStartingAtSecondSemester);
		map.put(AUGUST, LocalDateSemesterUtils::firstDayOfNextSemesterStartingAtSecondSemester);
		map.put(SEPTEMBER, LocalDateSemesterUtils::firstDayOfNextSemesterStartingAtSecondSemester);
		map.put(OCTOBER, LocalDateSemesterUtils::firstDayOfNextSemesterStartingAtSecondSemester);
		map.put(NOVEMBER, LocalDateSemesterUtils::firstDayOfNextSemesterStartingAtSecondSemester);
		map.put(DECEMBER, LocalDateSemesterUtils::firstDayOfNextSemesterStartingAtSecondSemester);
		
		return map;
	}
	
	// LAST DAY of NEXT SEMESTER
	
	/**
	 * Initializes a map with functions to calculate the last day of the next semester for each month.
	 * <p>
	 * The returned map contains month-function pairs, where the function takes a {@code LocalDate} parameter
	 * and returns the corresponding last day of the next semester for the specified month.
	 * </p>
	 *
	 * @return The initialized map with month-function pairs for the last day of the next semester.
	 */
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeLastDayOfNextSemesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST SEMESTER
		map.put(JANUARY, LocalDateSemesterUtils::lastDayOfNextSemesterStartingAtFirstSemester);
		map.put(FEBRUARY, LocalDateSemesterUtils::lastDayOfNextSemesterStartingAtFirstSemester);
		map.put(MARCH, LocalDateSemesterUtils::lastDayOfNextSemesterStartingAtFirstSemester);
		map.put(APRIL, LocalDateSemesterUtils::lastDayOfNextSemesterStartingAtFirstSemester);
		map.put(MAY, LocalDateSemesterUtils::lastDayOfNextSemesterStartingAtFirstSemester);
		map.put(JUNE, LocalDateSemesterUtils::lastDayOfNextSemesterStartingAtFirstSemester);
		
		// SECOND SEMESTER
		map.put(JULY, LocalDateSemesterUtils::lastDayOfNextSemesterStartingAtSecondSemester);
		map.put(AUGUST, LocalDateSemesterUtils::lastDayOfNextSemesterStartingAtSecondSemester);
		map.put(SEPTEMBER, LocalDateSemesterUtils::lastDayOfNextSemesterStartingAtSecondSemester);
		map.put(OCTOBER, LocalDateSemesterUtils::lastDayOfNextSemesterStartingAtSecondSemester);
		map.put(NOVEMBER, LocalDateSemesterUtils::lastDayOfNextSemesterStartingAtSecondSemester);
		map.put(DECEMBER, LocalDateSemesterUtils::lastDayOfNextSemesterStartingAtSecondSemester);
		
		return map;
	}
	
	// FIRST DAY of PREVIOUS SEMESTER
	
	/**
	 * Initializes a map with functions to calculate the first day of the previous semester for each month.
	 * <p>
	 * The returned map contains month-function pairs, where the function takes a {@code LocalDate} parameter
	 * and returns the corresponding first day of the previous semester for the specified month.
	 * </p>
	 *
	 * @return The initialized map with month-function pairs for the first day of the previous semester.
	 */
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeFirstDayOfPreviousSemesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST SEMESTER
		map.put(JANUARY, LocalDateSemesterUtils::firstDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(FEBRUARY, LocalDateSemesterUtils::firstDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(MARCH, LocalDateSemesterUtils::firstDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(APRIL, LocalDateSemesterUtils::firstDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(MAY, LocalDateSemesterUtils::firstDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(JUNE, LocalDateSemesterUtils::firstDayOfPreviousSemesterStartingAtFirstSemester);
		
		// SECOND SEMESTER
		map.put(JULY, LocalDateSemesterUtils::firstDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(AUGUST, LocalDateSemesterUtils::firstDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(SEPTEMBER, LocalDateSemesterUtils::firstDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(OCTOBER, LocalDateSemesterUtils::firstDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(NOVEMBER, LocalDateSemesterUtils::firstDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(DECEMBER, LocalDateSemesterUtils::firstDayOfPreviousSemesterStartingAtSecondSemester);
		
		return map;
	}
	
	// LAST DAY of PREVIOUS SEMESTER
	
	/**
	 * Initializes a map with functions to calculate the last day of the previous semester for each month.
	 * <p>
	 * The returned map contains month-function pairs, where the function takes a {@code LocalDate} parameter
	 * and returns the corresponding last day of the previous semester for the specified month.
	 * </p>
	 *
	 * @return The initialized map with month-function pairs for the last day of the previous semester.
	 */
	private static final Map<Month, Function<LocalDate, LocalDate>> initializeLastDayOfPreviousSemesterMap() {
		Map<Month, Function<LocalDate, LocalDate>> map = new EnumMap<>(Month.class);
		
		// FIRST SEMESTER
		map.put(JANUARY, LocalDateSemesterUtils::lastDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(FEBRUARY, LocalDateSemesterUtils::lastDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(MARCH, LocalDateSemesterUtils::lastDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(APRIL, LocalDateSemesterUtils::lastDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(MAY, LocalDateSemesterUtils::lastDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(JUNE, LocalDateSemesterUtils::lastDayOfPreviousSemesterStartingAtFirstSemester);
		
		// SECOND SEMESTER
		map.put(JULY, LocalDateSemesterUtils::lastDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(AUGUST, LocalDateSemesterUtils::lastDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(SEPTEMBER, LocalDateSemesterUtils::lastDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(OCTOBER, LocalDateSemesterUtils::lastDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(NOVEMBER, LocalDateSemesterUtils::lastDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(DECEMBER, LocalDateSemesterUtils::lastDayOfPreviousSemesterStartingAtSecondSemester);
		
		return map;
	}
	
	/**
	 * Returns the first day of the first semester for the specified year.
	 *
	 * @param year The year for which to calculate the first day of the first semester.
	 * @return The {@code LocalDate} representing the first day of the first semester.
	 */
	private static final LocalDate firstDayOfFirstSemester(final int year) {
		return buildLocalDate(year, 1, 1);
	}
	
	/**
	 * Returns the first day of the second semester for the specified year.
	 *
	 * @param year The year for which to calculate the first day of the second semester.
	 * @return The {@code LocalDate} representing the first day of the second semester.
	 */
	private static final LocalDate firstDayOfSecondSemester(final int year) {
		return buildLocalDate(year, 7, 1);
	}
	
	/**
	 * Returns the last day of the first semester for the specified year.
	 *
	 * @param year The year for which to calculate the last day of the first semester.
	 * @return The {@code LocalDate} representing the last day of the first semester.
	 */
	private static final LocalDate lastDayOfFirstSemester(final int year) {
		return buildLocalDate(year, 6, 30);
	}
	
	/**
	 * Returns the last day of the second semester for the specified year.
	 *
	 * @param year The year for which to calculate the last day of the second semester.
	 * @return The {@code LocalDate} representing the last day of the second semester.
	 */
	private static final LocalDate lastDayOfSecondSemester(final int year) {
		return buildLocalDate(year, 12, 31);
	}
	
	/**
	 * Throws an {@code IllegalArgumentException} if the specified {@code LocalDate} is not in the first semester.
	 *
	 * @param localDate The {@code LocalDate} to check for being in the first semester.
	 * @throws IllegalArgumentException If the specified {@code LocalDate} is not in the first semester.
	 */
	private static final void throwExceptionIfIsNotTheFirstSemester(final LocalDate localDate) {
		if(!isFirstSemester(localDate)) throw new IllegalArgumentException("The localDate is not on first semester");
	}
	
	/**
	 * Throws an {@code IllegalArgumentException} if the specified {@code LocalDate} is not in the second semester.
	 *
	 * @param localDate The {@code LocalDate} to check for being in the second semester.
	 * @throws IllegalArgumentException If the specified {@code LocalDate} is not in the second semester.
	 */
	private static final void throwExceptionIfIsNotTheSecondSemester(final LocalDate localDate) {
		if(!isSecondSemester(localDate)) throw new IllegalArgumentException("The localDate is not on second semester");
	}
	
	// CURRENT SEMESTER
	
	/**
	 * Returns the first day of the current semester starting at the first semester for the specified {@code LocalDate}.
	 *
	 * @param localDate The {@code LocalDate} representing the current semester starting point.
	 * @return The {@code LocalDate} representing the first day of the current semester.
	 * @throws IllegalArgumentException If the specified {@code LocalDate} is not in the first semester.
	 */
	private static final LocalDate firstDayOfCurrentSemesterStartingAtFirstSemester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFirstSemester(localDate);
		return firstDayOfFirstSemester(localDate.getYear());
	}
	
	/**
	 * Returns the first day of the current semester starting at the second semester for the specified {@code LocalDate}.
	 *
	 * @param localDate The {@code LocalDate} representing the current semester starting point.
	 * @return The {@code LocalDate} representing the first day of the current semester.
	 * @throws IllegalArgumentException If the specified {@code LocalDate} is not in the second semester.
	 */
	private static final LocalDate firstDayOfCurrentSemesterStartingAtSecondSemester(final LocalDate localDate) {
		throwExceptionIfIsNotTheSecondSemester(localDate);
		return firstDayOfSecondSemester(localDate.getYear());
	}
	
	/**
	 * Returns the last day of the current semester starting at the first semester for the specified {@code LocalDate}.
	 *
	 * @param localDate The {@code LocalDate} representing the current semester starting point.
	 * @return The {@code LocalDate} representing the last day of the current semester.
	 * @throws IllegalArgumentException If the specified {@code LocalDate} is not in the first semester.
	 */
	private static final LocalDate lastDayOfCurrentSemesterStartingAtFirstSemester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFirstSemester(localDate);
		return lastDayOfFirstSemester(localDate.getYear());
	}
	
	/**
	 * Returns the last day of the current semester starting at the second semester for the specified {@code LocalDate}.
	 *
	 * @param localDate The {@code LocalDate} representing the current semester starting point.
	 * @return The {@code LocalDate} representing the last day of the current semester.
	 * @throws IllegalArgumentException If the specified {@code LocalDate} is not in the second semester.
	 */
	private static final LocalDate lastDayOfCurrentSemesterStartingAtSecondSemester(final LocalDate localDate) {
		throwExceptionIfIsNotTheSecondSemester(localDate);
		return lastDayOfSecondSemester(localDate.getYear());
	}
	
	// NEXT SEMESTER
	
	/**
	 * Returns the first day of the next semester starting at the first semester for the specified {@code LocalDate}.
	 *
	 * @param localDate The {@code LocalDate} representing the current semester starting point.
	 * @return The {@code LocalDate} representing the first day of the next semester.
	 * @throws IllegalArgumentException If the specified {@code LocalDate} is not in the first semester.
	 */
	private static final LocalDate firstDayOfNextSemesterStartingAtFirstSemester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFirstSemester(localDate);
		return firstDayOfSecondSemester(localDate.getYear());
	}
	
	/**
	 * Returns the first day of the next semester starting at the second semester for the specified {@code LocalDate}.
	 *
	 * @param localDate The {@code LocalDate} representing the current semester starting point.
	 * @return The {@code LocalDate} representing the first day of the next semester.
	 * @throws IllegalArgumentException If the specified {@code LocalDate} is not in the second semester.
	 */
	private static final LocalDate firstDayOfNextSemesterStartingAtSecondSemester(final LocalDate localDate) {
		throwExceptionIfIsNotTheSecondSemester(localDate);
		return firstDayOfFirstSemester(localDate.getYear() + 1);
	}
	
	/**
	 * Returns the last day of the next semester starting at the first semester for the specified {@code LocalDate}.
	 *
	 * @param localDate The {@code LocalDate} representing the current semester starting point.
	 * @return The {@code LocalDate} representing the last day of the next semester.
	 * @throws IllegalArgumentException If the specified {@code LocalDate} is not in the first semester.
	 */
	private static final LocalDate lastDayOfNextSemesterStartingAtFirstSemester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFirstSemester(localDate);
		return lastDayOfSecondSemester(localDate.getYear());
	}
	
	/**
	 * Returns the last day of the next semester starting at the second semester for the specified {@code LocalDate}.
	 *
	 * @param localDate The {@code LocalDate} representing the current semester starting point.
	 * @return The {@code LocalDate} representing the last day of the next semester.
	 * @throws IllegalArgumentException If the specified {@code LocalDate} is not in the second semester.
	 */
	private static final LocalDate lastDayOfNextSemesterStartingAtSecondSemester(final LocalDate localDate) {
		throwExceptionIfIsNotTheSecondSemester(localDate);
		return lastDayOfFirstSemester(localDate.getYear() + 1);
	}
	
	// PREVIOUS SEMESTER
	
	/**
	 * Returns the first day of the previous semester starting at the first semester for the specified {@code LocalDate}.
	 *
	 * @param localDate The {@code LocalDate} representing the current semester starting point.
	 * @return The {@code LocalDate} representing the first day of the previous semester.
	 * @throws IllegalArgumentException If the specified {@code LocalDate} is not in the first semester.
	 */
	private static final LocalDate firstDayOfPreviousSemesterStartingAtFirstSemester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFirstSemester(localDate);
		return firstDayOfSecondSemester(localDate.getYear() - 1);
	}
	
	/**
	 * Returns the first day of the previous semester starting at the second semester for the specified {@code LocalDate}.
	 *
	 * @param localDate The {@code LocalDate} representing the current semester starting point.
	 * @return The {@code LocalDate} representing the first day of the previous semester.
	 * @throws IllegalArgumentException If the specified {@code LocalDate} is not in the second semester.
	 */
	private static final LocalDate firstDayOfPreviousSemesterStartingAtSecondSemester(final LocalDate localDate) {
		throwExceptionIfIsNotTheSecondSemester(localDate);
		return firstDayOfFirstSemester(localDate.getYear());
	}
	
	/**
	 * Returns the last day of the previous semester starting at the first semester for the specified {@code LocalDate}.
	 *
	 * @param localDate The {@code LocalDate} representing the current semester starting point.
	 * @return The {@code LocalDate} representing the last day of the previous semester.
	 * @throws IllegalArgumentException If the specified {@code LocalDate} is not in the first semester.
	 */
	private static final LocalDate lastDayOfPreviousSemesterStartingAtFirstSemester(final LocalDate localDate) {
		throwExceptionIfIsNotTheFirstSemester(localDate);
		return lastDayOfSecondSemester(localDate.getYear() - 1);
	}
	
	/**
	 * Returns the last day of the previous semester starting at the second semester for the specified {@code LocalDate}.
	 *
	 * @param localDate The {@code LocalDate} representing the current semester starting point.
	 * @return The {@code LocalDate} representing the last day of the previous semester.
	 * @throws IllegalArgumentException If the specified {@code LocalDate} is not in the second semester.
	 */
	private static final LocalDate lastDayOfPreviousSemesterStartingAtSecondSemester(final LocalDate localDate) {
		throwExceptionIfIsNotTheSecondSemester(localDate);
		return lastDayOfFirstSemester(localDate.getYear());
	}

	/**
	 * Returns the map of functions to calculate the first day of the current semester for each month.
	 *
	 * @return The map containing month-function pairs for the first day of the current semester.
	 */
	public static Map<Month, Function<LocalDate, LocalDate>> getFirstDayOfCurrentSemester() {
		return FIRST_DAY_OF_CURRENT_SEMESTER;
	}

	/**
	 * Returns the map of functions to calculate the last day of the current semester for each month.
	 *
	 * @return The map containing month-function pairs for the last day of the current semester.
	 */
	public static Map<Month, Function<LocalDate, LocalDate>> getLastDayOfCurrentSemester() {
		return LAST_DAY_OF_CURRENT_SEMESTER;
	}

	/**
	 * Returns the map of functions to calculate the first day of the next semester for each month.
	 *
	 * @return The map containing month-function pairs for the first day of the next semester.
	 */
	public static Map<Month, Function<LocalDate, LocalDate>> getFirstDayOfNextSemester() {
		return FIRST_DAY_OF_NEXT_SEMESTER;
	}

	/**
	 * Returns the map of functions to calculate the last day of the next semester for each month.
	 *
	 * @return The map containing month-function pairs for the last day of the next semester.
	 */
	public static Map<Month, Function<LocalDate, LocalDate>> getLastDayOfNextSemester() {
		return LAST_DAY_OF_NEXT_SEMESTER;
	}

	/**
	 * Returns the map of functions to calculate the first day of the previous semester for each month.
	 *
	 * @return The map containing month-function pairs for the first day of the previous semester.
	 */
	public static Map<Month, Function<LocalDate, LocalDate>> getFirstDayOfPreviousSemester() {
		return FIRST_DAY_OF_PREVIOUS_SEMESTER;
	}

	/**
	 * Returns the map of functions to calculate the last day of the previous semester for each month.
	 *
	 * @return The map containing month-function pairs for the last day of the previous semester.
	 */
	public static Map<Month, Function<LocalDate, LocalDate>> getLastDayOfPreviousSemester() {
		return LAST_DAY_OF_PREVIOUS_SEMESTER;
	}
	
//	public enum SEMESTER {
//	    FIRST,
//	    SECOND
//	}
	
}
