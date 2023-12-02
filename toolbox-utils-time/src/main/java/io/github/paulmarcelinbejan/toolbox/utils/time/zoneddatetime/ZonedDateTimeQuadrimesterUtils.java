package io.github.paulmarcelinbejan.toolbox.utils.time.zoneddatetime;

import static io.github.paulmarcelinbejan.toolbox.utils.time.zoneddatetime.ZonedDateTimeUtils.buildZonedDateTime;
import static io.github.paulmarcelinbejan.toolbox.utils.time.zoneddatetime.ZonedDateTimeUtils.isFirstQuadrimester;
import static io.github.paulmarcelinbejan.toolbox.utils.time.zoneddatetime.ZonedDateTimeUtils.isSecondQuadrimester;
import static io.github.paulmarcelinbejan.toolbox.utils.time.zoneddatetime.ZonedDateTimeUtils.isThirdQuadrimester;
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

import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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
public class ZonedDateTimeQuadrimesterUtils {

	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> FIRST_DAY_OF_CURRENT_QUADRIMESTER = initializeFirstDayOfCurrentQuadrimesterMap();
	
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> LAST_DAY_OF_CURRENT_QUADRIMESTER = initializeLastDayOfCurrentQuadrimesterMap();
	
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> FIRST_DAY_OF_NEXT_QUADRIMESTER = initializeFirstDayOfNextQuadrimesterMap();
	
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> LAST_DAY_OF_NEXT_QUADRIMESTER = initializeLastDayOfNextQuadrimesterMap();
	
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> FIRST_DAY_OF_PREVIOUS_QUADRIMESTER = initializeFirstDayOfPreviousQuadrimesterMap();
	
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> LAST_DAY_OF_PREVIOUS_QUADRIMESTER = initializeLastDayOfPreviousQuadrimesterMap();
	
	// FIRST DAY of CURRENT QUADRIMESTER
	
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> initializeFirstDayOfCurrentQuadrimesterMap() {
		Map<Month, Function<ZonedDateTime, ZonedDateTime>> map = new EnumMap<>(Month.class);
		
		// FIRST QUADRIMESTER
		map.put(JANUARY, ZonedDateTimeQuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtFirstQuadrimester);
		map.put(FEBRUARY, ZonedDateTimeQuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtFirstQuadrimester);
		map.put(MARCH, ZonedDateTimeQuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtFirstQuadrimester);
		map.put(APRIL, ZonedDateTimeQuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtFirstQuadrimester);
		
		// SECOND QUADRIMESTER
		map.put(MAY, ZonedDateTimeQuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtSecondQuadrimester);
		map.put(JUNE, ZonedDateTimeQuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtSecondQuadrimester);
		map.put(JULY, ZonedDateTimeQuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtSecondQuadrimester);
		map.put(AUGUST, ZonedDateTimeQuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtSecondQuadrimester);
		
		// THIRD QUADRIMESTER
		map.put(SEPTEMBER, ZonedDateTimeQuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtThirdQuadrimester);
		map.put(OCTOBER, ZonedDateTimeQuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtThirdQuadrimester);
		map.put(NOVEMBER, ZonedDateTimeQuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtThirdQuadrimester);
		map.put(DECEMBER, ZonedDateTimeQuadrimesterUtils::firstDayOfCurrentQuadrimesterStartingAtThirdQuadrimester);
		
		return map;
	}
	
	// LAST DAY of CURRENT QUADRIMESTER
	
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> initializeLastDayOfCurrentQuadrimesterMap() {
		Map<Month, Function<ZonedDateTime, ZonedDateTime>> map = new EnumMap<>(Month.class);
		
		// FIRST QUADRIMESTER
		map.put(JANUARY, ZonedDateTimeQuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtFirstQuadrimester);
		map.put(FEBRUARY, ZonedDateTimeQuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtFirstQuadrimester);
		map.put(MARCH, ZonedDateTimeQuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtFirstQuadrimester);
		map.put(APRIL, ZonedDateTimeQuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtFirstQuadrimester);
		
		// SECOND QUADRIMESTER
		map.put(MAY, ZonedDateTimeQuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtSecondQuadrimester);
		map.put(JUNE, ZonedDateTimeQuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtSecondQuadrimester);
		map.put(JULY, ZonedDateTimeQuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtSecondQuadrimester);
		map.put(AUGUST, ZonedDateTimeQuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtSecondQuadrimester);
		
		// THIRD QUADRIMESTER
		map.put(SEPTEMBER, ZonedDateTimeQuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtThirdQuadrimester);
		map.put(OCTOBER, ZonedDateTimeQuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtThirdQuadrimester);
		map.put(NOVEMBER, ZonedDateTimeQuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtThirdQuadrimester);
		map.put(DECEMBER, ZonedDateTimeQuadrimesterUtils::lastDayOfCurrentQuadrimesterStartingAtThirdQuadrimester);
		
		return map;
	}
	
	// FIRST DAY of NEXT QUADRIMESTER
	
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> initializeFirstDayOfNextQuadrimesterMap() {
		Map<Month, Function<ZonedDateTime, ZonedDateTime>> map = new EnumMap<>(Month.class);
		
		// FIRST QUADRIMESTER
		map.put(JANUARY, ZonedDateTimeQuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtFirstQuadrimester);
		map.put(FEBRUARY, ZonedDateTimeQuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtFirstQuadrimester);
		map.put(MARCH, ZonedDateTimeQuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtFirstQuadrimester);
		map.put(APRIL, ZonedDateTimeQuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtFirstQuadrimester);
		
		// SECOND QUADRIMESTER
		map.put(MAY, ZonedDateTimeQuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtSecondQuadrimester);
		map.put(JUNE, ZonedDateTimeQuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtSecondQuadrimester);
		map.put(JULY, ZonedDateTimeQuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtSecondQuadrimester);
		map.put(AUGUST, ZonedDateTimeQuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtSecondQuadrimester);
		
		// THIRD QUADRIMESTER
		map.put(SEPTEMBER, ZonedDateTimeQuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtThirdQuadrimester);
		map.put(OCTOBER, ZonedDateTimeQuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtThirdQuadrimester);
		map.put(NOVEMBER, ZonedDateTimeQuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtThirdQuadrimester);
		map.put(DECEMBER, ZonedDateTimeQuadrimesterUtils::firstDayOfNextQuadrimesterStartingAtThirdQuadrimester);
		
		return map;
	}
	
	// LAST DAY of NEXT QUADRIMESTER
	
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> initializeLastDayOfNextQuadrimesterMap() {
		Map<Month, Function<ZonedDateTime, ZonedDateTime>> map = new EnumMap<>(Month.class);
		
		// FIRST QUADRIMESTER
		map.put(JANUARY, ZonedDateTimeQuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtFirstQuadrimester);
		map.put(FEBRUARY, ZonedDateTimeQuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtFirstQuadrimester);
		map.put(MARCH, ZonedDateTimeQuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtFirstQuadrimester);
		map.put(APRIL, ZonedDateTimeQuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtFirstQuadrimester);
		
		// SECOND QUADRIMESTER
		map.put(MAY, ZonedDateTimeQuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtSecondQuadrimester);
		map.put(JUNE, ZonedDateTimeQuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtSecondQuadrimester);
		map.put(JULY, ZonedDateTimeQuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtSecondQuadrimester);
		map.put(AUGUST, ZonedDateTimeQuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtSecondQuadrimester);
		
		// THIRD QUADRIMESTER
		map.put(SEPTEMBER, ZonedDateTimeQuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtThirdQuadrimester);
		map.put(OCTOBER, ZonedDateTimeQuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtThirdQuadrimester);
		map.put(NOVEMBER, ZonedDateTimeQuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtThirdQuadrimester);
		map.put(DECEMBER, ZonedDateTimeQuadrimesterUtils::lastDayOfNextQuadrimesterStartingAtThirdQuadrimester);
		
		return map;
	}
	
	// FIRST DAY of PREVIOUS QUADRIMESTER
	
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> initializeFirstDayOfPreviousQuadrimesterMap() {
		Map<Month, Function<ZonedDateTime, ZonedDateTime>> map = new EnumMap<>(Month.class);
		
		// FIRST QUADRIMESTER
		map.put(JANUARY, ZonedDateTimeQuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtFirstQuadrimester);
		map.put(FEBRUARY, ZonedDateTimeQuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtFirstQuadrimester);
		map.put(MARCH, ZonedDateTimeQuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtFirstQuadrimester);
		map.put(APRIL, ZonedDateTimeQuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtFirstQuadrimester);
		
		// SECOND QUADRIMESTER
		map.put(MAY, ZonedDateTimeQuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtSecondQuadrimester);
		map.put(JUNE, ZonedDateTimeQuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtSecondQuadrimester);
		map.put(JULY, ZonedDateTimeQuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtSecondQuadrimester);
		map.put(AUGUST, ZonedDateTimeQuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtSecondQuadrimester);
		
		// THIRD QUADRIMESTER
		map.put(SEPTEMBER, ZonedDateTimeQuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtThirdQuadrimester);
		map.put(OCTOBER, ZonedDateTimeQuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtThirdQuadrimester);
		map.put(NOVEMBER, ZonedDateTimeQuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtThirdQuadrimester);
		map.put(DECEMBER, ZonedDateTimeQuadrimesterUtils::firstDayOfPreviousQuadrimesterStartingAtThirdQuadrimester);
		
		return map;
	}
	
	// LAST DAY of PREVIOUS QUADRIMESTER
	
	private static final Map<Month, Function<ZonedDateTime, ZonedDateTime>> initializeLastDayOfPreviousQuadrimesterMap() {
		Map<Month, Function<ZonedDateTime, ZonedDateTime>> map = new EnumMap<>(Month.class);
		
		// FIRST QUADRIMESTER
		map.put(JANUARY, ZonedDateTimeQuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtFirstQuadrimester);
		map.put(FEBRUARY, ZonedDateTimeQuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtFirstQuadrimester);
		map.put(MARCH, ZonedDateTimeQuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtFirstQuadrimester);
		map.put(APRIL, ZonedDateTimeQuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtFirstQuadrimester);
		
		// SECOND QUADRIMESTER
		map.put(MAY, ZonedDateTimeQuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtSecondQuadrimester);
		map.put(JUNE, ZonedDateTimeQuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtSecondQuadrimester);
		map.put(JULY, ZonedDateTimeQuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtSecondQuadrimester);
		map.put(AUGUST, ZonedDateTimeQuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtSecondQuadrimester);
		
		// THIRD QUADRIMESTER
		map.put(SEPTEMBER, ZonedDateTimeQuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtThirdQuadrimester);
		map.put(OCTOBER, ZonedDateTimeQuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtThirdQuadrimester);
		map.put(NOVEMBER, ZonedDateTimeQuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtThirdQuadrimester);
		map.put(DECEMBER, ZonedDateTimeQuadrimesterUtils::lastDayOfPreviousQuadrimesterStartingAtThirdQuadrimester);
		
		return map;
	}
	
	private static final ZonedDateTime firstDayOfFirstQuadrimesterAtStartOfDay(final int year, final ZoneId zoneId) {
		return buildZonedDateTime(year, 1, 1, zoneId);
	}
	
	private static final ZonedDateTime firstDayOfSecondQuadrimesterAtStartOfDay(final int year, final ZoneId zoneId) {
		return buildZonedDateTime(year, 5, 1, zoneId);
	}
	
	private static final ZonedDateTime firstDayOfThirdQuadrimesterAtStartOfDay(final int year, final ZoneId zoneId) {
		return buildZonedDateTime(year, 9, 1, zoneId);
	}
	
	private static final ZonedDateTime lastDayOfFirstQuadrimesterAtStartOfDay(final int year, final ZoneId zoneId) {
		return buildZonedDateTime(year, 4, 30, zoneId);
	}
	
	private static final ZonedDateTime lastDayOfSecondQuadrimesterAtStartOfDay(final int year, final ZoneId zoneId) {
		return buildZonedDateTime(year, 8, 31, zoneId);
	}
	
	private static final ZonedDateTime lastDayOfThirdQuadrimesterAtStartOfDay(final int year, final ZoneId zoneId) {
		return buildZonedDateTime(year, 12, 31, zoneId);
	}
	
	private static final void throwExceptionIfIsNotTheFirstQuadrimester(final ZonedDateTime zonedDateTime) {
		if(!isFirstQuadrimester(zonedDateTime)) throw new IllegalArgumentException("The zonedDateTime is not on first quadrimester");
	}
	
	private static final void throwExceptionIfIsNotTheSecondQuadrimester(final ZonedDateTime zonedDateTime) {
		if(!isSecondQuadrimester(zonedDateTime)) throw new IllegalArgumentException("The zonedDateTime is not on second quadrimester");
	}
	
	private static final void throwExceptionIfIsNotTheThirdQuadrimester(final ZonedDateTime zonedDateTime) {
		if(!isThirdQuadrimester(zonedDateTime)) throw new IllegalArgumentException("The zonedDateTime is not on third quadrimester");
	}
	
	// CURRENT QUADRIMESTER
	
	private static final ZonedDateTime firstDayOfCurrentQuadrimesterStartingAtFirstQuadrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheFirstQuadrimester(zonedDateTime);
		return firstDayOfFirstQuadrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime firstDayOfCurrentQuadrimesterStartingAtSecondQuadrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheSecondQuadrimester(zonedDateTime);
		return firstDayOfSecondQuadrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime firstDayOfCurrentQuadrimesterStartingAtThirdQuadrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheThirdQuadrimester(zonedDateTime);
		return firstDayOfThirdQuadrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime lastDayOfCurrentQuadrimesterStartingAtFirstQuadrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheFirstQuadrimester(zonedDateTime);
		return lastDayOfFirstQuadrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime lastDayOfCurrentQuadrimesterStartingAtSecondQuadrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheSecondQuadrimester(zonedDateTime);
		return lastDayOfSecondQuadrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime lastDayOfCurrentQuadrimesterStartingAtThirdQuadrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheThirdQuadrimester(zonedDateTime);
		return lastDayOfThirdQuadrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	// NEXT QUADRIMESTER
	
	private static final ZonedDateTime firstDayOfNextQuadrimesterStartingAtFirstQuadrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheFirstQuadrimester(zonedDateTime);
		return firstDayOfSecondQuadrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime firstDayOfNextQuadrimesterStartingAtSecondQuadrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheSecondQuadrimester(zonedDateTime);
		return firstDayOfThirdQuadrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime firstDayOfNextQuadrimesterStartingAtThirdQuadrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheThirdQuadrimester(zonedDateTime);
		return firstDayOfFirstQuadrimesterAtStartOfDay(zonedDateTime.getYear() + 1, zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime lastDayOfNextQuadrimesterStartingAtFirstQuadrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheFirstQuadrimester(zonedDateTime);
		return lastDayOfSecondQuadrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime lastDayOfNextQuadrimesterStartingAtSecondQuadrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheSecondQuadrimester(zonedDateTime);
		return lastDayOfThirdQuadrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime lastDayOfNextQuadrimesterStartingAtThirdQuadrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheThirdQuadrimester(zonedDateTime);
		return lastDayOfFirstQuadrimesterAtStartOfDay(zonedDateTime.getYear() + 1, zonedDateTime.getZone());
	}
	
	// PREVIOUS QUADRIMESTER
	
	private static final ZonedDateTime firstDayOfPreviousQuadrimesterStartingAtFirstQuadrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheFirstQuadrimester(zonedDateTime);
		return firstDayOfThirdQuadrimesterAtStartOfDay(zonedDateTime.getYear() - 1, zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime firstDayOfPreviousQuadrimesterStartingAtSecondQuadrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheSecondQuadrimester(zonedDateTime);
		return firstDayOfFirstQuadrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime firstDayOfPreviousQuadrimesterStartingAtThirdQuadrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheThirdQuadrimester(zonedDateTime);
		return firstDayOfSecondQuadrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime lastDayOfPreviousQuadrimesterStartingAtFirstQuadrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheFirstQuadrimester(zonedDateTime);
		return lastDayOfThirdQuadrimesterAtStartOfDay(zonedDateTime.getYear() - 1, zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime lastDayOfPreviousQuadrimesterStartingAtSecondQuadrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheSecondQuadrimester(zonedDateTime);
		return lastDayOfFirstQuadrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}
	
	private static final ZonedDateTime lastDayOfPreviousQuadrimesterStartingAtThirdQuadrimester(final ZonedDateTime zonedDateTime) {
		throwExceptionIfIsNotTheThirdQuadrimester(zonedDateTime);
		return lastDayOfSecondQuadrimesterAtStartOfDay(zonedDateTime.getYear(), zonedDateTime.getZone());
	}

	public static Map<Month, Function<ZonedDateTime, ZonedDateTime>> getFirstDayOfCurrentQuadrimester() {
		return FIRST_DAY_OF_CURRENT_QUADRIMESTER;
	}

	public static Map<Month, Function<ZonedDateTime, ZonedDateTime>> getLastDayOfCurrentQuadrimester() {
		return LAST_DAY_OF_CURRENT_QUADRIMESTER;
	}

	public static Map<Month, Function<ZonedDateTime, ZonedDateTime>> getFirstDayOfNextQuadrimester() {
		return FIRST_DAY_OF_NEXT_QUADRIMESTER;
	}

	public static Map<Month, Function<ZonedDateTime, ZonedDateTime>> getLastDayOfNextQuadrimester() {
		return LAST_DAY_OF_NEXT_QUADRIMESTER;
	}

	public static Map<Month, Function<ZonedDateTime, ZonedDateTime>> getFirstDayOfPreviousQuadrimester() {
		return FIRST_DAY_OF_PREVIOUS_QUADRIMESTER;
	}

	public static Map<Month, Function<ZonedDateTime, ZonedDateTime>> getLastDayOfPreviousQuadrimester() {
		return LAST_DAY_OF_PREVIOUS_QUADRIMESTER;
	}
	
//	public enum QUADRIMESTER {
//		FIRST, 
//		SECOND, 
//		THIRD
//	}
	
}
