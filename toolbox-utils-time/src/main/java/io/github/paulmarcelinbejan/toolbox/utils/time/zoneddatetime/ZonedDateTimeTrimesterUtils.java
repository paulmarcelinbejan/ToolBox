package io.github.paulmarcelinbejan.toolbox.utils.time.zoneddatetime;

import static io.github.paulmarcelinbejan.toolbox.utils.time.zoneddatetime.ZonedDateTimeUtils.buildZonedDateTime;
import static io.github.paulmarcelinbejan.toolbox.utils.time.zoneddatetime.ZonedDateTimeUtils.isFirstTrimester;
import static io.github.paulmarcelinbejan.toolbox.utils.time.zoneddatetime.ZonedDateTimeUtils.isFourthTrimester;
import static io.github.paulmarcelinbejan.toolbox.utils.time.zoneddatetime.ZonedDateTimeUtils.isSecondTrimester;
import static io.github.paulmarcelinbejan.toolbox.utils.time.zoneddatetime.ZonedDateTimeUtils.isThirdTrimester;
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
public class ZonedDateTimeTrimesterUtils {

	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> FIRST_DAY_OF_CURRENT_TRIMESTER = initializeFirstDayOfCurrentTrimesterMap();
	
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> LAST_DAY_OF_CURRENT_TRIMESTER = initializeLastDayOfCurrentTrimesterMap();
	
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> FIRST_DAY_OF_NEXT_TRIMESTER = initializeFirstDayOfNextTrimesterMap();
	
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> LAST_DAY_OF_NEXT_TRIMESTER = initializeLastDayOfNextTrimesterMap();
	
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> FIRST_DAY_OF_PREVIOUS_TRIMESTER = initializeFirstDayOfPreviousTrimesterMap();
	
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> LAST_DAY_OF_PREVIOUS_TRIMESTER = initializeLastDayOfPreviousTrimesterMap();
	
	// FIRST DAY of CURRENT TRIMESTER
	
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> initializeFirstDayOfCurrentTrimesterMap() {
		Map<Month, Function<ZonedDateTime, ZonedDateTime>> map = new EnumMap<>(Month.class);
		
		// FIRST TRIMESTER
		map.put(JANUARY, ZonedDateTimeTrimesterUtils::firstDayOfCurrentTrimesterStartingAtFirstTrimester);
		map.put(FEBRUARY, ZonedDateTimeTrimesterUtils::firstDayOfCurrentTrimesterStartingAtFirstTrimester);
		map.put(MARCH, ZonedDateTimeTrimesterUtils::firstDayOfCurrentTrimesterStartingAtFirstTrimester);
		
		// SECOND TRIMESTER
		map.put(APRIL, ZonedDateTimeTrimesterUtils::firstDayOfCurrentTrimesterStartingAtSecondTrimester);
		map.put(MAY, ZonedDateTimeTrimesterUtils::firstDayOfCurrentTrimesterStartingAtSecondTrimester);
		map.put(JUNE, ZonedDateTimeTrimesterUtils::firstDayOfCurrentTrimesterStartingAtSecondTrimester);
		
		// THIRD TRIMESTER
		map.put(JULY, ZonedDateTimeTrimesterUtils::firstDayOfCurrentTrimesterStartingAtThirdTrimester);
		map.put(AUGUST, ZonedDateTimeTrimesterUtils::firstDayOfCurrentTrimesterStartingAtThirdTrimester);
		map.put(SEPTEMBER, ZonedDateTimeTrimesterUtils::firstDayOfCurrentTrimesterStartingAtThirdTrimester);
		
		// FOURTH TRIMESTER
		map.put(OCTOBER, ZonedDateTimeTrimesterUtils::firstDayOfCurrentTrimesterStartingAtFourthTrimester);
		map.put(NOVEMBER, ZonedDateTimeTrimesterUtils::firstDayOfCurrentTrimesterStartingAtFourthTrimester);
		map.put(DECEMBER, ZonedDateTimeTrimesterUtils::firstDayOfCurrentTrimesterStartingAtFourthTrimester);
		
		return map;
	}
	
	// LAST DAY of CURRENT TRIMESTER
	
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> initializeLastDayOfCurrentTrimesterMap() {
		Map<Month, Function<ZonedDateTime, ZonedDateTime>> map = new EnumMap<>(Month.class);
		
		// FIRST TRIMESTER
		map.put(JANUARY, ZonedDateTimeTrimesterUtils::lastDayOfCurrentTrimesterStartingAtFirstTrimester);
		map.put(FEBRUARY, ZonedDateTimeTrimesterUtils::lastDayOfCurrentTrimesterStartingAtFirstTrimester);
		map.put(MARCH, ZonedDateTimeTrimesterUtils::lastDayOfCurrentTrimesterStartingAtFirstTrimester);
		
		// SECOND TRIMESTER
		map.put(APRIL, ZonedDateTimeTrimesterUtils::lastDayOfCurrentTrimesterStartingAtSecondTrimester);
		map.put(MAY, ZonedDateTimeTrimesterUtils::lastDayOfCurrentTrimesterStartingAtSecondTrimester);
		map.put(JUNE, ZonedDateTimeTrimesterUtils::lastDayOfCurrentTrimesterStartingAtSecondTrimester);
		
		// THIRD TRIMESTER
		map.put(JULY, ZonedDateTimeTrimesterUtils::lastDayOfCurrentTrimesterStartingAtThirdTrimester);
		map.put(AUGUST, ZonedDateTimeTrimesterUtils::lastDayOfCurrentTrimesterStartingAtThirdTrimester);
		map.put(SEPTEMBER, ZonedDateTimeTrimesterUtils::lastDayOfCurrentTrimesterStartingAtThirdTrimester);
		
		// FOURTH TRIMESTER
		map.put(OCTOBER, ZonedDateTimeTrimesterUtils::lastDayOfCurrentTrimesterStartingAtFourthTrimester);
		map.put(NOVEMBER, ZonedDateTimeTrimesterUtils::lastDayOfCurrentTrimesterStartingAtFourthTrimester);
		map.put(DECEMBER, ZonedDateTimeTrimesterUtils::lastDayOfCurrentTrimesterStartingAtFourthTrimester);
		
		return map;
	}
	
	// FIRST DAY of NEXT TRIMESTER
	
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> initializeFirstDayOfNextTrimesterMap() {
		Map<Month, Function<ZonedDateTime, ZonedDateTime>> map = new EnumMap<>(Month.class);
		
		// FIRST TRIMESTER
		map.put(JANUARY, ZonedDateTimeTrimesterUtils::firstDayOfNextTrimesterStartingAtFirstTrimester);
		map.put(FEBRUARY, ZonedDateTimeTrimesterUtils::firstDayOfNextTrimesterStartingAtFirstTrimester);
		map.put(MARCH, ZonedDateTimeTrimesterUtils::firstDayOfNextTrimesterStartingAtFirstTrimester);
		
		// SECOND TRIMESTER
		map.put(APRIL, ZonedDateTimeTrimesterUtils::firstDayOfNextTrimesterStartingAtSecondTrimester);
		map.put(MAY, ZonedDateTimeTrimesterUtils::firstDayOfNextTrimesterStartingAtSecondTrimester);
		map.put(JUNE, ZonedDateTimeTrimesterUtils::firstDayOfNextTrimesterStartingAtSecondTrimester);
		
		// THIRD TRIMESTER
		map.put(JULY, ZonedDateTimeTrimesterUtils::firstDayOfNextTrimesterStartingAtThirdTrimester);
		map.put(AUGUST, ZonedDateTimeTrimesterUtils::firstDayOfNextTrimesterStartingAtThirdTrimester);
		map.put(SEPTEMBER, ZonedDateTimeTrimesterUtils::firstDayOfNextTrimesterStartingAtThirdTrimester);
		
		// FOURTH TRIMESTER
		map.put(OCTOBER, ZonedDateTimeTrimesterUtils::firstDayOfNextTrimesterStartingAtFourthTrimester);
		map.put(NOVEMBER, ZonedDateTimeTrimesterUtils::firstDayOfNextTrimesterStartingAtFourthTrimester);
		map.put(DECEMBER, ZonedDateTimeTrimesterUtils::firstDayOfNextTrimesterStartingAtFourthTrimester);
		
		return map;
	}
	
	// LAST DAY of NEXT TRIMESTER
	
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> initializeLastDayOfNextTrimesterMap() {
		Map<Month, Function<ZonedDateTime, ZonedDateTime>> map = new EnumMap<>(Month.class);
		
		// FIRST TRIMESTER
		map.put(JANUARY, ZonedDateTimeTrimesterUtils::lastDayOfNextTrimesterStartingAtFirstTrimester);
		map.put(FEBRUARY, ZonedDateTimeTrimesterUtils::lastDayOfNextTrimesterStartingAtFirstTrimester);
		map.put(MARCH, ZonedDateTimeTrimesterUtils::lastDayOfNextTrimesterStartingAtFirstTrimester);
		
		// SECOND TRIMESTER
		map.put(APRIL, ZonedDateTimeTrimesterUtils::lastDayOfNextTrimesterStartingAtSecondTrimester);
		map.put(MAY, ZonedDateTimeTrimesterUtils::lastDayOfNextTrimesterStartingAtSecondTrimester);
		map.put(JUNE, ZonedDateTimeTrimesterUtils::lastDayOfNextTrimesterStartingAtSecondTrimester);
		
		// THIRD TRIMESTER
		map.put(JULY, ZonedDateTimeTrimesterUtils::lastDayOfNextTrimesterStartingAtThirdTrimester);
		map.put(AUGUST, ZonedDateTimeTrimesterUtils::lastDayOfNextTrimesterStartingAtThirdTrimester);
		map.put(SEPTEMBER, ZonedDateTimeTrimesterUtils::lastDayOfNextTrimesterStartingAtThirdTrimester);
		
		// FOURTH TRIMESTER
		map.put(OCTOBER, ZonedDateTimeTrimesterUtils::lastDayOfNextTrimesterStartingAtFourthTrimester);
		map.put(NOVEMBER, ZonedDateTimeTrimesterUtils::lastDayOfNextTrimesterStartingAtFourthTrimester);
		map.put(DECEMBER, ZonedDateTimeTrimesterUtils::lastDayOfNextTrimesterStartingAtFourthTrimester);
		
		return map;
	}
	
	// FIRST DAY of PREVIOUS TRIMESTER
	
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> initializeFirstDayOfPreviousTrimesterMap() {
		Map<Month, Function<ZonedDateTime, ZonedDateTime>> map = new EnumMap<>(Month.class);
		
		// FIRST TRIMESTER
		map.put(JANUARY, ZonedDateTimeTrimesterUtils::firstDayOfPreviousTrimesterStartingAtFirstTrimester);
		map.put(FEBRUARY, ZonedDateTimeTrimesterUtils::firstDayOfPreviousTrimesterStartingAtFirstTrimester);
		map.put(MARCH, ZonedDateTimeTrimesterUtils::firstDayOfPreviousTrimesterStartingAtFirstTrimester);
		
		// SECOND TRIMESTER
		map.put(APRIL, ZonedDateTimeTrimesterUtils::firstDayOfPreviousTrimesterStartingAtSecondTrimester);
		map.put(MAY, ZonedDateTimeTrimesterUtils::firstDayOfPreviousTrimesterStartingAtSecondTrimester);
		map.put(JUNE, ZonedDateTimeTrimesterUtils::firstDayOfPreviousTrimesterStartingAtSecondTrimester);
		
		// THIRD TRIMESTER
		map.put(JULY, ZonedDateTimeTrimesterUtils::firstDayOfPreviousTrimesterStartingAtThirdTrimester);
		map.put(AUGUST, ZonedDateTimeTrimesterUtils::firstDayOfPreviousTrimesterStartingAtThirdTrimester);
		map.put(SEPTEMBER, ZonedDateTimeTrimesterUtils::firstDayOfPreviousTrimesterStartingAtThirdTrimester);
		
		// FOURTH TRIMESTER
		map.put(OCTOBER, ZonedDateTimeTrimesterUtils::firstDayOfPreviousTrimesterStartingAtFourthTrimester);
		map.put(NOVEMBER, ZonedDateTimeTrimesterUtils::firstDayOfPreviousTrimesterStartingAtFourthTrimester);
		map.put(DECEMBER, ZonedDateTimeTrimesterUtils::firstDayOfPreviousTrimesterStartingAtFourthTrimester);
		
		return map;
	}
	
	// LAST DAY of PREVIOUS TRIMESTER
	
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> initializeLastDayOfPreviousTrimesterMap() {
		Map<Month, Function<ZonedDateTime, ZonedDateTime>> map = new EnumMap<>(Month.class);
		
		// FIRST TRIMESTER
		map.put(JANUARY, ZonedDateTimeTrimesterUtils::lastDayOfPreviousTrimesterStartingAtFirstTrimester);
		map.put(FEBRUARY, ZonedDateTimeTrimesterUtils::lastDayOfPreviousTrimesterStartingAtFirstTrimester);
		map.put(MARCH, ZonedDateTimeTrimesterUtils::lastDayOfPreviousTrimesterStartingAtFirstTrimester);
		
		// SECOND TRIMESTER
		map.put(APRIL, ZonedDateTimeTrimesterUtils::lastDayOfPreviousTrimesterStartingAtSecondTrimester);
		map.put(MAY, ZonedDateTimeTrimesterUtils::lastDayOfPreviousTrimesterStartingAtSecondTrimester);
		map.put(JUNE, ZonedDateTimeTrimesterUtils::lastDayOfPreviousTrimesterStartingAtSecondTrimester);
		
		// THIRD TRIMESTER
		map.put(JULY, ZonedDateTimeTrimesterUtils::lastDayOfPreviousTrimesterStartingAtThirdTrimester);
		map.put(AUGUST, ZonedDateTimeTrimesterUtils::lastDayOfPreviousTrimesterStartingAtThirdTrimester);
		map.put(SEPTEMBER, ZonedDateTimeTrimesterUtils::lastDayOfPreviousTrimesterStartingAtThirdTrimester);
		
		// FOURTH TRIMESTER
		map.put(OCTOBER, ZonedDateTimeTrimesterUtils::lastDayOfPreviousTrimesterStartingAtFourthTrimester);
		map.put(NOVEMBER, ZonedDateTimeTrimesterUtils::lastDayOfPreviousTrimesterStartingAtFourthTrimester);
		map.put(DECEMBER, ZonedDateTimeTrimesterUtils::lastDayOfPreviousTrimesterStartingAtFourthTrimester);
		
		return map;
	}
	
	private static final ZonedDateTime firstDayOfFirstTrimesterAtStartOfDay(final int year, final ZoneId zoneId) {
		return buildZonedDateTime(year, 1, 1, zoneId);
	}
	
	private static final ZonedDateTime firstDayOfSecondTrimesterAtStartOfDay(final int year, final ZoneId zoneId) {
		return buildZonedDateTime(year, 4, 1, zoneId);
	}
	
	private static final ZonedDateTime firstDayOfThirdTrimesterAtStartOfDay(final int year, final ZoneId zoneId) {
		return buildZonedDateTime(year, 7, 1, zoneId);
	}
	
	private static final ZonedDateTime firstDayOfFourthTrimesterAtStartOfDay(final int year, final ZoneId zoneId) {
		return buildZonedDateTime(year, 10, 1, zoneId);
	}
	
	private static final ZonedDateTime lastDayOfFirstTrimesterAtStartOfDay(final int year, final ZoneId zoneId) {
		return buildZonedDateTime(year, 3, 31, zoneId);
	}
	
	private static final ZonedDateTime lastDayOfSecondTrimesterAtStartOfDay(final int year, final ZoneId zoneId) {
		return buildZonedDateTime(year, 6, 30, zoneId);
	}
	
	private static final ZonedDateTime lastDayOfThirdTrimesterAtStartOfDay(final int year, final ZoneId zoneId) {
		return buildZonedDateTime(year, 9, 30, zoneId);
	}
	
	private static final ZonedDateTime lastDayOfFourthTrimesterAtStartOfDay(final int year, final ZoneId zoneId) {
		return buildZonedDateTime(year, 12, 31, zoneId);
	}
	
	private static final void throwExceptionIfIsNotTheFirstTrimester(final ZonedDateTime zonedDateTime) {
		if(!isFirstTrimester(zonedDateTime)) throw new IllegalArgumentException("The zonedDateTime is not on first trimester");
	}
	
	private static final void throwExceptionIfIsNotTheSecondTrimester(final ZonedDateTime zonedDateTime) {
		if(!isSecondTrimester(zonedDateTime)) throw new IllegalArgumentException("The zonedDateTime is not on second trimester");
	}
	
	private static final void throwExceptionIfIsNotTheThirdTrimester(final ZonedDateTime zonedDateTime) {
		if(!isThirdTrimester(zonedDateTime)) throw new IllegalArgumentException("The zonedDateTime is not on third trimester");
	}
	
	private static final void throwExceptionIfIsNotTheFourthTrimester(final ZonedDateTime zonedDateTime) {
		if(!isFourthTrimester(zonedDateTime)) throw new IllegalArgumentException("The zonedDateTime is not on fourth trimester");
	}
	
	// THIS TRIMESTER
	
	private static final ZonedDateTime firstDayOfCurrentTrimesterStartingAtFirstTrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheFirstTrimester(zonedDateTime);
		return firstDayOfFirstTrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime firstDayOfCurrentTrimesterStartingAtSecondTrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheSecondTrimester(zonedDateTime);
		return firstDayOfSecondTrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime firstDayOfCurrentTrimesterStartingAtThirdTrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheThirdTrimester(zonedDateTime);
		return firstDayOfThirdTrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime firstDayOfCurrentTrimesterStartingAtFourthTrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheFourthTrimester(zonedDateTime);
		return firstDayOfFourthTrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime lastDayOfCurrentTrimesterStartingAtFirstTrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheFirstTrimester(zonedDateTime);
		return lastDayOfFirstTrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime lastDayOfCurrentTrimesterStartingAtSecondTrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheSecondTrimester(zonedDateTime);
		return lastDayOfSecondTrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime lastDayOfCurrentTrimesterStartingAtThirdTrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheThirdTrimester(zonedDateTime);
		return lastDayOfThirdTrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime lastDayOfCurrentTrimesterStartingAtFourthTrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheFourthTrimester(zonedDateTime);
		return lastDayOfFourthTrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	// NEXT TRIMESTER
	
	private static final ZonedDateTime firstDayOfNextTrimesterStartingAtFirstTrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheFirstTrimester(zonedDateTime);
		return firstDayOfSecondTrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime firstDayOfNextTrimesterStartingAtSecondTrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheSecondTrimester(zonedDateTime);
		return firstDayOfThirdTrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime firstDayOfNextTrimesterStartingAtThirdTrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheThirdTrimester(zonedDateTime);
		return firstDayOfFourthTrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime firstDayOfNextTrimesterStartingAtFourthTrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheFourthTrimester(zonedDateTime);
		return firstDayOfFirstTrimesterAtStartOfDay(zonedDateTime.getYear() + 1, zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime lastDayOfNextTrimesterStartingAtFirstTrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheFirstTrimester(zonedDateTime);
		return lastDayOfSecondTrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime lastDayOfNextTrimesterStartingAtSecondTrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheSecondTrimester(zonedDateTime);
		return lastDayOfThirdTrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime lastDayOfNextTrimesterStartingAtThirdTrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheThirdTrimester(zonedDateTime);
		return lastDayOfFourthTrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime lastDayOfNextTrimesterStartingAtFourthTrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheFourthTrimester(zonedDateTime);
		return lastDayOfFirstTrimesterAtStartOfDay(zonedDateTime.getYear() + 1, zonedDateTime.getZone());
	}
	
	// PREVIOUS TRIMESTER
	
	private static final ZonedDateTime firstDayOfPreviousTrimesterStartingAtFirstTrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheFirstTrimester(zonedDateTime);
		return firstDayOfFourthTrimesterAtStartOfDay(zonedDateTime.getYear() - 1, zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime firstDayOfPreviousTrimesterStartingAtSecondTrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheSecondTrimester(zonedDateTime);
		return firstDayOfFirstTrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime firstDayOfPreviousTrimesterStartingAtThirdTrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheThirdTrimester(zonedDateTime);
		return firstDayOfSecondTrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime firstDayOfPreviousTrimesterStartingAtFourthTrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheFourthTrimester(zonedDateTime);
		return firstDayOfThirdTrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime lastDayOfPreviousTrimesterStartingAtFirstTrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheFirstTrimester(zonedDateTime);
		return lastDayOfFourthTrimesterAtStartOfDay(zonedDateTime.getYear() - 1, zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime lastDayOfPreviousTrimesterStartingAtSecondTrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheSecondTrimester(zonedDateTime);
		return lastDayOfFirstTrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime lastDayOfPreviousTrimesterStartingAtThirdTrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheThirdTrimester(zonedDateTime);
		return lastDayOfSecondTrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime lastDayOfPreviousTrimesterStartingAtFourthTrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheFourthTrimester(zonedDateTime);
		return lastDayOfThirdTrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}

	public static Map<Month, Function<ZonedDateTime, ZonedDateTime>> getFirstDayOfCurrentTrimester() {
		return FIRST_DAY_OF_CURRENT_TRIMESTER;
	}

	public static Map<Month, Function<ZonedDateTime, ZonedDateTime>> getLastDayOfCurrentTrimester() {
		return LAST_DAY_OF_CURRENT_TRIMESTER;
	}

	public static Map<Month, Function<ZonedDateTime, ZonedDateTime>> getFirstDayOfNextTrimester() {
		return FIRST_DAY_OF_NEXT_TRIMESTER;
	}

	public static Map<Month, Function<ZonedDateTime, ZonedDateTime>> getLastDayOfNextTrimester() {
		return LAST_DAY_OF_NEXT_TRIMESTER;
	}

	public static Map<Month, Function<ZonedDateTime, ZonedDateTime>> getFirstDayOfPreviousTrimester() {
		return FIRST_DAY_OF_PREVIOUS_TRIMESTER;
	}

	public static Map<Month, Function<ZonedDateTime, ZonedDateTime>> getLastDayOfPreviousTrimester() {
		return LAST_DAY_OF_PREVIOUS_TRIMESTER;
	}
	
//	public enum TRIMESTER {
//	    FIRST,
//	    SECOND,
//	    THIRD, 
//	    FORUTH
//	}
	
}
