package io.github.paulmarcelinbejan.toolbox.utils.time.zoneddatetime;

import static io.github.paulmarcelinbejan.toolbox.utils.time.zoneddatetime.ZonedDateTimeUtils.buildZonedDateTime;
import static io.github.paulmarcelinbejan.toolbox.utils.time.zoneddatetime.ZonedDateTimeUtils.isFirstSemester;
import static io.github.paulmarcelinbejan.toolbox.utils.time.zoneddatetime.ZonedDateTimeUtils.isSecondSemester;
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

import java.time.ZonedDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * A semester is a period of six months. <br>
 * From Latin semestris: sex (six) mensis (month).
 * 
 * <p>
 * A year can be divided into two SEMESTERS: <br>
 * 
 * <table>
 *  <caption>Semester Dates</caption>
 *  <tr>
 *      <th></th>
 *      <th>First Day</th>
 *      <th>Last Day</th>
 *  </tr>
 *  <tr>
 *      <th>FIRST</th>
 *      <td>1st January</td>
 *      <td>30th June</td>
 *  </tr>
 *  <tr>
 *      <th>SECOND</th>
 *      <td>1st July</td>
 *      <td>31st December</td>
 *  </tr>
 * </table>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ZonedDateTimeSemesterUtils {

	/**
	 * A map containing functions to get the first day of the current semester for each month.
	 * The map associates each Month with a corresponding function that takes a ZonedDateTime
	 * and returns the first day of the current semester.
	 */
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> FIRST_DAY_OF_CURRENT_SEMESTER = initializeFirstDayOfCurrentSemesterMap();

	/**
	 * A map containing functions to get the last day of the current semester for each month.
	 * The map associates each Month with a corresponding function that takes a ZonedDateTime
	 * and returns the last day of the current semester.
	 */
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> LAST_DAY_OF_CURRENT_SEMESTER = initializeLastDayOfCurrentSemesterMap();

	/**
	 * A map containing functions to get the first day of the next semester for each month.
	 * The map associates each Month with a corresponding function that takes a ZonedDateTime
	 * and returns the first day of the next semester.
	 */
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> FIRST_DAY_OF_NEXT_SEMESTER = initializeFirstDayOfNextSemesterMap();

	/**
	 * A map containing functions to get the last day of the next semester for each month.
	 * The map associates each Month with a corresponding function that takes a ZonedDateTime
	 * and returns the last day of the next semester.
	 */
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> LAST_DAY_OF_NEXT_SEMESTER = initializeLastDayOfNextSemesterMap();

	/**
	 * A map containing functions to get the first day of the previous semester for each month.
	 * The map associates each Month with a corresponding function that takes a ZonedDateTime
	 * and returns the first day of the previous semester.
	 */
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> FIRST_DAY_OF_PREVIOUS_SEMESTER = initializeFirstDayOfPreviousSemesterMap();

	/**
	 * A map containing functions to get the last day of the previous semester for each month.
	 * The map associates each Month with a corresponding function that takes a ZonedDateTime
	 * and returns the last day of the previous semester.
	 */
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> LAST_DAY_OF_PREVIOUS_SEMESTER = initializeLastDayOfPreviousSemesterMap();
	
	// FIRST DAY of CURRENT SEMESTER
	
	/**
	 * Initializes a map containing functions to calculate the first day of the current semester for each month.
	 * The key is the month, and the value is a function taking a {@code ZonedDateTime} and returning
	 * a {@code ZonedDateTime} representing the first day of the current semester in the same year and time zone.
	 *
	 * @return A map containing functions to calculate the first day of the current semester for each month.
	 */
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> initializeFirstDayOfCurrentSemesterMap() {
		Map<Month, Function<ZonedDateTime, ZonedDateTime>> map = new EnumMap<>(Month.class);
		
		// FIRST SEMESTER
		map.put(JANUARY, ZonedDateTimeSemesterUtils::firstDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(FEBRUARY, ZonedDateTimeSemesterUtils::firstDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(MARCH, ZonedDateTimeSemesterUtils::firstDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(APRIL, ZonedDateTimeSemesterUtils::firstDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(MAY, ZonedDateTimeSemesterUtils::firstDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(JUNE, ZonedDateTimeSemesterUtils::firstDayOfCurrentSemesterStartingAtFirstSemester);
		
		// SECOND SEMESTER
		map.put(JULY, ZonedDateTimeSemesterUtils::firstDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(AUGUST, ZonedDateTimeSemesterUtils::firstDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(SEPTEMBER, ZonedDateTimeSemesterUtils::firstDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(OCTOBER, ZonedDateTimeSemesterUtils::firstDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(NOVEMBER, ZonedDateTimeSemesterUtils::firstDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(DECEMBER, ZonedDateTimeSemesterUtils::firstDayOfCurrentSemesterStartingAtSecondSemester);
		
		return map;
	}
	
	// LAST DAY of CURRENT SEMESTER
	
	/**
	 * Initializes a map containing functions to calculate the last day of the current semester for each month.
	 * The key is the month, and the value is a function taking a {@code ZonedDateTime} and returning
	 * a {@code ZonedDateTime} representing the last day of the current semester in the same year and time zone.
	 *
	 * @return A map containing functions to calculate the last day of the current semester for each month.
	 */
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> initializeLastDayOfCurrentSemesterMap() {
		Map<Month, Function<ZonedDateTime, ZonedDateTime>> map = new EnumMap<>(Month.class);
		
		// FIRST SEMESTER
		map.put(JANUARY, ZonedDateTimeSemesterUtils::lastDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(FEBRUARY, ZonedDateTimeSemesterUtils::lastDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(MARCH, ZonedDateTimeSemesterUtils::lastDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(APRIL, ZonedDateTimeSemesterUtils::lastDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(MAY, ZonedDateTimeSemesterUtils::lastDayOfCurrentSemesterStartingAtFirstSemester);
		map.put(JUNE, ZonedDateTimeSemesterUtils::lastDayOfCurrentSemesterStartingAtFirstSemester);
		
		// SECOND SEMESTER
		map.put(JULY, ZonedDateTimeSemesterUtils::lastDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(AUGUST, ZonedDateTimeSemesterUtils::lastDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(SEPTEMBER, ZonedDateTimeSemesterUtils::lastDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(OCTOBER, ZonedDateTimeSemesterUtils::lastDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(NOVEMBER, ZonedDateTimeSemesterUtils::lastDayOfCurrentSemesterStartingAtSecondSemester);
		map.put(DECEMBER, ZonedDateTimeSemesterUtils::lastDayOfCurrentSemesterStartingAtSecondSemester);
		
		return map;
	}
	
	// FIRST DAY of NEXT SEMESTER
	
	/**
	 * Initializes a map containing functions to calculate the first day of the next semester for each month.
	 * The key is the month, and the value is a function taking a {@code ZonedDateTime} and returning
	 * a {@code ZonedDateTime} representing the first day of the next semester in the same year and time zone.
	 *
	 * @return A map containing functions to calculate the first day of the next semester for each month.
	 */
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> initializeFirstDayOfNextSemesterMap() {
		Map<Month, Function<ZonedDateTime, ZonedDateTime>> map = new EnumMap<>(Month.class);
		
		// FIRST SEMESTER
		map.put(JANUARY, ZonedDateTimeSemesterUtils::firstDayOfNextSemesterStartingAtFirstSemester);
		map.put(FEBRUARY, ZonedDateTimeSemesterUtils::firstDayOfNextSemesterStartingAtFirstSemester);
		map.put(MARCH, ZonedDateTimeSemesterUtils::firstDayOfNextSemesterStartingAtFirstSemester);
		map.put(APRIL, ZonedDateTimeSemesterUtils::firstDayOfNextSemesterStartingAtFirstSemester);
		map.put(MAY, ZonedDateTimeSemesterUtils::firstDayOfNextSemesterStartingAtFirstSemester);
		map.put(JUNE, ZonedDateTimeSemesterUtils::firstDayOfNextSemesterStartingAtFirstSemester);
		
		// SECOND SEMESTER
		map.put(JULY, ZonedDateTimeSemesterUtils::firstDayOfNextSemesterStartingAtSecondSemester);
		map.put(AUGUST, ZonedDateTimeSemesterUtils::firstDayOfNextSemesterStartingAtSecondSemester);
		map.put(SEPTEMBER, ZonedDateTimeSemesterUtils::firstDayOfNextSemesterStartingAtSecondSemester);
		map.put(OCTOBER, ZonedDateTimeSemesterUtils::firstDayOfNextSemesterStartingAtSecondSemester);
		map.put(NOVEMBER, ZonedDateTimeSemesterUtils::firstDayOfNextSemesterStartingAtSecondSemester);
		map.put(DECEMBER, ZonedDateTimeSemesterUtils::firstDayOfNextSemesterStartingAtSecondSemester);
		
		return map;
	}
	
	// LAST DAY of NEXT SEMESTER
	
	/**
	 * Initializes a map containing functions to calculate the last day of the next semester for each month.
	 * The key is the month, and the value is a function taking a {@code ZonedDateTime} and returning
	 * a {@code ZonedDateTime} representing the last day of the next semester in the same year and time zone.
	 *
	 * @return A map containing functions to calculate the last day of the next semester for each month.
	 */
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> initializeLastDayOfNextSemesterMap() {
		Map<Month, Function<ZonedDateTime, ZonedDateTime>> map = new EnumMap<>(Month.class);
		
		// FIRST SEMESTER
		map.put(JANUARY, ZonedDateTimeSemesterUtils::lastDayOfNextSemesterStartingAtFirstSemester);
		map.put(FEBRUARY, ZonedDateTimeSemesterUtils::lastDayOfNextSemesterStartingAtFirstSemester);
		map.put(MARCH, ZonedDateTimeSemesterUtils::lastDayOfNextSemesterStartingAtFirstSemester);
		map.put(APRIL, ZonedDateTimeSemesterUtils::lastDayOfNextSemesterStartingAtFirstSemester);
		map.put(MAY, ZonedDateTimeSemesterUtils::lastDayOfNextSemesterStartingAtFirstSemester);
		map.put(JUNE, ZonedDateTimeSemesterUtils::lastDayOfNextSemesterStartingAtFirstSemester);
		
		// SECOND SEMESTER
		map.put(JULY, ZonedDateTimeSemesterUtils::lastDayOfNextSemesterStartingAtSecondSemester);
		map.put(AUGUST, ZonedDateTimeSemesterUtils::lastDayOfNextSemesterStartingAtSecondSemester);
		map.put(SEPTEMBER, ZonedDateTimeSemesterUtils::lastDayOfNextSemesterStartingAtSecondSemester);
		map.put(OCTOBER, ZonedDateTimeSemesterUtils::lastDayOfNextSemesterStartingAtSecondSemester);
		map.put(NOVEMBER, ZonedDateTimeSemesterUtils::lastDayOfNextSemesterStartingAtSecondSemester);
		map.put(DECEMBER, ZonedDateTimeSemesterUtils::lastDayOfNextSemesterStartingAtSecondSemester);
		
		return map;
	}
	
	// FIRST DAY of PREVIOUS SEMESTER
	
	/**
	 * Initializes a map containing functions to calculate the first day of the previous semester for each month.
	 * The key is the month, and the value is a function taking a {@code ZonedDateTime} and returning
	 * a {@code ZonedDateTime} representing the first day of the previous semester in the same year and time zone.
	 *
	 * @return A map containing functions to calculate the first day of the previous semester for each month.
	 */
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> initializeFirstDayOfPreviousSemesterMap() {
		Map<Month, Function<ZonedDateTime, ZonedDateTime>> map = new EnumMap<>(Month.class);
		
		// FIRST SEMESTER
		map.put(JANUARY, ZonedDateTimeSemesterUtils::firstDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(FEBRUARY, ZonedDateTimeSemesterUtils::firstDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(MARCH, ZonedDateTimeSemesterUtils::firstDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(APRIL, ZonedDateTimeSemesterUtils::firstDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(MAY, ZonedDateTimeSemesterUtils::firstDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(JUNE, ZonedDateTimeSemesterUtils::firstDayOfPreviousSemesterStartingAtFirstSemester);
		
		// SECOND SEMESTER
		map.put(JULY, ZonedDateTimeSemesterUtils::firstDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(AUGUST, ZonedDateTimeSemesterUtils::firstDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(SEPTEMBER, ZonedDateTimeSemesterUtils::firstDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(OCTOBER, ZonedDateTimeSemesterUtils::firstDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(NOVEMBER, ZonedDateTimeSemesterUtils::firstDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(DECEMBER, ZonedDateTimeSemesterUtils::firstDayOfPreviousSemesterStartingAtSecondSemester);
		
		return map;
	}
	
	// LAST DAY of PREVIOUS SEMESTER
	
	/**
	 * Initializes a map containing functions to calculate the last day of the previous semester for each month.
	 * The key is the month, and the value is a function taking a {@code ZonedDateTime} and returning
	 * a {@code ZonedDateTime} representing the last day of the previous semester in the same year and time zone.
	 *
	 * @return A map containing functions to calculate the last day of the previous semester for each month.
	 */
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> initializeLastDayOfPreviousSemesterMap() {
		Map<Month, Function<ZonedDateTime, ZonedDateTime>> map = new EnumMap<>(Month.class);
		
		// FIRST SEMESTER
		map.put(JANUARY, ZonedDateTimeSemesterUtils::lastDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(FEBRUARY, ZonedDateTimeSemesterUtils::lastDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(MARCH, ZonedDateTimeSemesterUtils::lastDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(APRIL, ZonedDateTimeSemesterUtils::lastDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(MAY, ZonedDateTimeSemesterUtils::lastDayOfPreviousSemesterStartingAtFirstSemester);
		map.put(JUNE, ZonedDateTimeSemesterUtils::lastDayOfPreviousSemesterStartingAtFirstSemester);
		
		// SECOND SEMESTER
		map.put(JULY, ZonedDateTimeSemesterUtils::lastDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(AUGUST, ZonedDateTimeSemesterUtils::lastDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(SEPTEMBER, ZonedDateTimeSemesterUtils::lastDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(OCTOBER, ZonedDateTimeSemesterUtils::lastDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(NOVEMBER, ZonedDateTimeSemesterUtils::lastDayOfPreviousSemesterStartingAtSecondSemester);
		map.put(DECEMBER, ZonedDateTimeSemesterUtils::lastDayOfPreviousSemesterStartingAtSecondSemester);
		
		return map;
	}
	
	/**
	 * Returns the first day of the first semester at the start of the day for the specified year and time zone.
	 *
	 * @param year    The year for which to get the first day.
	 * @param zoneId  The time zone to consider.
	 * @return The {@code ZonedDateTime} representing the first day of the first semester at the start of the day.
	 */
	private static final ZonedDateTime firstDayOfFirstSemesterAtStartOfDay(final int year, final ZoneId zoneId) {
	    return buildZonedDateTime(year, 1, 1, zoneId);
	}

	/**
	 * Returns the first day of the second semester at the start of the day for the specified year and time zone.
	 *
	 * @param year    The year for which to get the first day.
	 * @param zoneId  The time zone to consider.
	 * @return The {@code ZonedDateTime} representing the first day of the second semester at the start of the day.
	 */
	private static final ZonedDateTime firstDayOfSecondSemesterAtStartOfDay(final int year, final ZoneId zoneId) {
	    return buildZonedDateTime(year, 7, 1, zoneId);
	}

	/**
	 * Returns the last day of the first semester at the start of the day for the specified year and time zone.
	 *
	 * @param year    The year for which to get the last day.
	 * @param zoneId  The time zone to consider.
	 * @return The {@code ZonedDateTime} representing the last day of the first semester at the start of the day.
	 */
	private static final ZonedDateTime lastDayOfFirstSemesterAtStartOfDay(final int year, final ZoneId zoneId) {
	    return buildZonedDateTime(year, 6, 30, zoneId);
	}

	/**
	 * Returns the last day of the second semester at the start of the day for the specified year and time zone.
	 *
	 * @param year    The year for which to get the last day.
	 * @param zoneId  The time zone to consider.
	 * @return The {@code ZonedDateTime} representing the last day of the second semester at the start of the day.
	 */
	private static final ZonedDateTime lastDayOfSecondSemesterAtStartOfDay(final int year, final ZoneId zoneId) {
	    return buildZonedDateTime(year, 12, 31, zoneId);
	}
	
	/**
	 * Throws an {@code IllegalArgumentException} if the provided {@code ZonedDateTime} is not in the first semester.
	 *
	 * @param zonedDateTime The {@code ZonedDateTime} to check.
	 * @throws IllegalArgumentException If the provided {@code ZonedDateTime} is not in the first semester.
	 */
	private static final void throwExceptionIfIsNotTheFirstSemester(final ZonedDateTime zonedDateTime) {
		if(!isFirstSemester(zonedDateTime)) throw new IllegalArgumentException("The zonedDateTime is not on first semester");
	}
	
	/**
	 * Throws an {@code IllegalArgumentException} if the provided {@code ZonedDateTime} is not in the second semester.
	 *
	 * @param zonedDateTime The {@code ZonedDateTime} to check.
	 * @throws IllegalArgumentException If the provided {@code ZonedDateTime} is not in the second semester.
	 */
	private static final void throwExceptionIfIsNotTheSecondSemester(final ZonedDateTime zonedDateTime) {
		if(!isSecondSemester(zonedDateTime)) throw new IllegalArgumentException("The zonedDateTime is not on second semester");
	}
	
	// CURRENT SEMESTER
	
	/**
	 * Returns the first day of the current semester, starting from the first semester, based on the provided {@code ZonedDateTime}.
	 *
	 * @param zonedDateTime The {@code ZonedDateTime} representing a date within the desired semester.
	 * @return The {@code ZonedDateTime} representing the first day of the current semester starting from the first semester.
	 * @throws IllegalArgumentException If the provided {@code ZonedDateTime} is not in the first semester.
	 */
	private static final ZonedDateTime firstDayOfCurrentSemesterStartingAtFirstSemester(final ZonedDateTime zonedDateTime) {
	    throwExceptionIfIsNotTheFirstSemester(zonedDateTime);
	    return firstDayOfFirstSemesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}

	/**
	 * Returns the first day of the current semester, starting from the second semester, based on the provided {@code ZonedDateTime}.
	 *
	 * @param zonedDateTime The {@code ZonedDateTime} representing a date within the desired semester.
	 * @return The {@code ZonedDateTime} representing the first day of the current semester starting from the second semester.
	 * @throws IllegalArgumentException If the provided {@code ZonedDateTime} is not in the second semester.
	 */
	private static final ZonedDateTime firstDayOfCurrentSemesterStartingAtSecondSemester(final ZonedDateTime zonedDateTime) {
	    throwExceptionIfIsNotTheSecondSemester(zonedDateTime);
	    return firstDayOfSecondSemesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}

	/**
	 * Returns the last day of the current semester, starting from the first semester, based on the provided {@code ZonedDateTime}.
	 *
	 * @param zonedDateTime The {@code ZonedDateTime} representing a date within the desired semester.
	 * @return The {@code ZonedDateTime} representing the last day of the current semester starting from the first semester.
	 * @throws IllegalArgumentException If the provided {@code ZonedDateTime} is not in the first semester.
	 */
	private static final ZonedDateTime lastDayOfCurrentSemesterStartingAtFirstSemester(final ZonedDateTime zonedDateTime) {
	    throwExceptionIfIsNotTheFirstSemester(zonedDateTime);
	    return lastDayOfFirstSemesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}

	/**
	 * Returns the last day of the current semester, starting from the second semester, based on the provided {@code ZonedDateTime}.
	 *
	 * @param zonedDateTime The {@code ZonedDateTime} representing a date within the desired semester.
	 * @return The {@code ZonedDateTime} representing the last day of the current semester starting from the second semester.
	 * @throws IllegalArgumentException If the provided {@code ZonedDateTime} is not in the second semester.
	 */
	private static final ZonedDateTime lastDayOfCurrentSemesterStartingAtSecondSemester(final ZonedDateTime zonedDateTime) {
	    throwExceptionIfIsNotTheSecondSemester(zonedDateTime);
	    return lastDayOfSecondSemesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	// NEXT SEMESTER
	
	/**
	 * Returns the first day of the next semester, starting from the first semester, based on the provided {@code ZonedDateTime}.
	 *
	 * @param zonedDateTime The {@code ZonedDateTime} representing a date within the desired semester.
	 * @return The {@code ZonedDateTime} representing the first day of the next semester starting from the first semester.
	 * @throws IllegalArgumentException If the provided {@code ZonedDateTime} is not in the first semester.
	 */
	private static final ZonedDateTime firstDayOfNextSemesterStartingAtFirstSemester(final ZonedDateTime zonedDateTime) {
	    throwExceptionIfIsNotTheFirstSemester(zonedDateTime);
	    return firstDayOfSecondSemesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}

	/**
	 * Returns the first day of the next semester, starting from the second semester, based on the provided {@code ZonedDateTime}.
	 *
	 * @param zonedDateTime The {@code ZonedDateTime} representing a date within the desired semester.
	 * @return The {@code ZonedDateTime} representing the first day of the next semester starting from the second semester.
	 * @throws IllegalArgumentException If the provided {@code ZonedDateTime} is not in the second semester.
	 */
	private static final ZonedDateTime firstDayOfNextSemesterStartingAtSecondSemester(final ZonedDateTime zonedDateTime) {
	    throwExceptionIfIsNotTheSecondSemester(zonedDateTime);
	    return firstDayOfFirstSemesterAtStartOfDay(zonedDateTime.getYear() + 1, zonedDateTime.getZone());
	}

	/**
	 * Returns the last day of the next semester, starting from the first semester, based on the provided {@code ZonedDateTime}.
	 *
	 * @param zonedDateTime The {@code ZonedDateTime} representing a date within the desired semester.
	 * @return The {@code ZonedDateTime} representing the last day of the next semester starting from the first semester.
	 * @throws IllegalArgumentException If the provided {@code ZonedDateTime} is not in the first semester.
	 */
	private static final ZonedDateTime lastDayOfNextSemesterStartingAtFirstSemester(final ZonedDateTime zonedDateTime) {
	    throwExceptionIfIsNotTheFirstSemester(zonedDateTime);
	    return lastDayOfSecondSemesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}

	/**
	 * Returns the last day of the next semester, starting from the second semester, based on the provided {@code ZonedDateTime}.
	 *
	 * @param zonedDateTime The {@code ZonedDateTime} representing a date within the desired semester.
	 * @return The {@code ZonedDateTime} representing the last day of the next semester starting from the second semester.
	 * @throws IllegalArgumentException If the provided {@code ZonedDateTime} is not in the second semester.
	 */
	private static final ZonedDateTime lastDayOfNextSemesterStartingAtSecondSemester(final ZonedDateTime zonedDateTime) {
	    throwExceptionIfIsNotTheSecondSemester(zonedDateTime);
	    return lastDayOfFirstSemesterAtStartOfDay(zonedDateTime.getYear() + 1, zonedDateTime.getZone());
	}
	
	// PREVIOUS SEMESTER
	
	/**
	 * Returns the first day of the previous semester, starting from the first semester, based on the provided {@code ZonedDateTime}.
	 *
	 * @param zonedDateTime The {@code ZonedDateTime} representing a date within the desired semester.
	 * @return The {@code ZonedDateTime} representing the first day of the previous semester starting from the first semester.
	 * @throws IllegalArgumentException If the provided {@code ZonedDateTime} is not in the first semester.
	 */
	private static final ZonedDateTime firstDayOfPreviousSemesterStartingAtFirstSemester(final ZonedDateTime zonedDateTime) {
	    throwExceptionIfIsNotTheFirstSemester(zonedDateTime);
	    return firstDayOfSecondSemesterAtStartOfDay(zonedDateTime.getYear() - 1, zonedDateTime.getZone());
	}

	/**
	 * Returns the first day of the previous semester, starting from the second semester, based on the provided {@code ZonedDateTime}.
	 *
	 * @param zonedDateTime The {@code ZonedDateTime} representing a date within the desired semester.
	 * @return The {@code ZonedDateTime} representing the first day of the previous semester starting from the second semester.
	 * @throws IllegalArgumentException If the provided {@code ZonedDateTime} is not in the second semester.
	 */
	private static final ZonedDateTime firstDayOfPreviousSemesterStartingAtSecondSemester(final ZonedDateTime zonedDateTime) {
	    throwExceptionIfIsNotTheSecondSemester(zonedDateTime);
	    return firstDayOfFirstSemesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}

	/**
	 * Returns the last day of the previous semester, starting from the first semester, based on the provided {@code ZonedDateTime}.
	 *
	 * @param zonedDateTime The {@code ZonedDateTime} representing a date within the desired semester.
	 * @return The {@code ZonedDateTime} representing the last day of the previous semester starting from the first semester.
	 * @throws IllegalArgumentException If the provided {@code ZonedDateTime} is not in the first semester.
	 */
	private static final ZonedDateTime lastDayOfPreviousSemesterStartingAtFirstSemester(final ZonedDateTime zonedDateTime) {
	    throwExceptionIfIsNotTheFirstSemester(zonedDateTime);
	    return lastDayOfSecondSemesterAtStartOfDay(zonedDateTime.getYear() - 1, zonedDateTime.getZone());
	}

	/**
	 * Returns the last day of the previous semester, starting from the second semester, based on the provided {@code ZonedDateTime}.
	 *
	 * @param zonedDateTime The {@code ZonedDateTime} representing a date within the desired semester.
	 * @return The {@code ZonedDateTime} representing the last day of the previous semester starting from the second semester.
	 * @throws IllegalArgumentException If the provided {@code ZonedDateTime} is not in the second semester.
	 */
	private static final ZonedDateTime lastDayOfPreviousSemesterStartingAtSecondSemester(final ZonedDateTime zonedDateTime) {
	    throwExceptionIfIsNotTheSecondSemester(zonedDateTime);
	    return lastDayOfFirstSemesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}

	/**
	 * Returns a mapping of months to functions that calculate the first day of the current semester based on the provided {@code ZonedDateTime}.
	 *
	 * @return A {@code Map} containing mappings from months to functions representing the first day of the current semester.
	 */
	public static Map<Month, Function<ZonedDateTime, ZonedDateTime>> getFirstDayOfCurrentSemester() {
	    return FIRST_DAY_OF_CURRENT_SEMESTER;
	}

	/**
	 * Returns a mapping of months to functions that calculate the last day of the current semester based on the provided {@code ZonedDateTime}.
	 *
	 * @return A {@code Map} containing mappings from months to functions representing the last day of the current semester.
	 */
	public static Map<Month, Function<ZonedDateTime, ZonedDateTime>> getLastDayOfCurrentSemester() {
	    return LAST_DAY_OF_CURRENT_SEMESTER;
	}

	/**
	 * Returns a mapping of months to functions that calculate the first day of the next semester based on the provided {@code ZonedDateTime}.
	 *
	 * @return A {@code Map} containing mappings from months to functions representing the first day of the next semester.
	 */
	public static Map<Month, Function<ZonedDateTime, ZonedDateTime>> getFirstDayOfNextSemester() {
	    return FIRST_DAY_OF_NEXT_SEMESTER;
	}

	/**
	 * Returns a mapping of months to functions that calculate the last day of the next semester based on the provided {@code ZonedDateTime}.
	 *
	 * @return A {@code Map} containing mappings from months to functions representing the last day of the next semester.
	 */
	public static Map<Month, Function<ZonedDateTime, ZonedDateTime>> getLastDayOfNextSemester() {
	    return LAST_DAY_OF_NEXT_SEMESTER;
	}

	/**
	 * Returns a mapping of months to functions that calculate the first day of the previous semester based on the provided {@code ZonedDateTime}.
	 *
	 * @return A {@code Map} containing mappings from months to functions representing the first day of the previous semester.
	 */
	public static Map<Month, Function<ZonedDateTime, ZonedDateTime>> getFirstDayOfPreviousSemester() {
	    return FIRST_DAY_OF_PREVIOUS_SEMESTER;
	}

	/**
	 * Returns a mapping of months to functions that calculate the last day of the previous semester based on the provided {@code ZonedDateTime}.
	 *
	 * @return A {@code Map} containing mappings from months to functions representing the last day of the previous semester.
	 */
	public static Map<Month, Function<ZonedDateTime, ZonedDateTime>> getLastDayOfPreviousSemester() {
	    return LAST_DAY_OF_PREVIOUS_SEMESTER;
	}
	
//	public enum SEMESTER {
//	    FIRST,
//	    SECOND
//	}
	
}
