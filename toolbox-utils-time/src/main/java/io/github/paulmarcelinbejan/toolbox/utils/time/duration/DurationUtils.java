package io.github.paulmarcelinbejan.toolbox.utils.time.duration;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Utility class for working with durations and time units.
 * Provides methods to split durations into time units with ascending or descending order.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DurationUtils {

    /**
     * Splits the given duration in nanoseconds into time units with ascending order.
     *
     * @param durationInNanos the duration in nanoseconds to be split
     * @return an {@code EnumMap} containing time units and their corresponding values
     */
    public static EnumMap<TimeUnit, Long> splitNanosIntoTimeUnitsWithAscOrder(long durationInNanos) {
    	EnumMap<TimeUnit, Long> result = new EnumMap<>(TimeUnit.class);

        long days = TimeUnit.NANOSECONDS.toDays(durationInNanos);
        result.put(TimeUnit.DAYS, days);
        durationInNanos -= TimeUnit.DAYS.toNanos(days);

        long hours = TimeUnit.NANOSECONDS.toHours(durationInNanos);
        result.put(TimeUnit.HOURS, hours);
        durationInNanos -= TimeUnit.HOURS.toNanos(hours);

        long minutes = TimeUnit.NANOSECONDS.toMinutes(durationInNanos);
        result.put(TimeUnit.MINUTES, minutes);
        durationInNanos -= TimeUnit.MINUTES.toNanos(minutes);

        long seconds = TimeUnit.NANOSECONDS.toSeconds(durationInNanos);
        result.put(TimeUnit.SECONDS, seconds);
        durationInNanos -= TimeUnit.SECONDS.toNanos(seconds);

        long millis = TimeUnit.NANOSECONDS.toMillis(durationInNanos);
        result.put(TimeUnit.MILLISECONDS, millis);
        durationInNanos -= TimeUnit.MILLISECONDS.toNanos(millis);
        
        long micros = TimeUnit.NANOSECONDS.toMicros(durationInNanos);
        result.put(TimeUnit.MICROSECONDS, micros);
        durationInNanos -= TimeUnit.MICROSECONDS.toNanos(micros);

        result.put(TimeUnit.NANOSECONDS, durationInNanos);

        return result;
    }
    
    /**
     * Splits the given duration into time units with ascending order.
     *
     * @param duration the duration to be split
     * @return an {@code EnumMap} containing time units and their corresponding values
     */
    public static EnumMap<TimeUnit, Long> splitDurationIntoTimeUnitsWithAscOrder(Duration duration) {
        long durationInNanos = duration.toNanos();
        return splitNanosIntoTimeUnitsWithAscOrder(durationInNanos);
    }
    
    /**
     * Splits the given duration in nanoseconds into time units with descending order.
     *
     * @param durationInNanos the duration in nanoseconds to be split
     * @return a {@code LinkedHashMap} containing time units and their corresponding values in descending order
     */
    public static LinkedHashMap<TimeUnit, Long> splitNanosIntoTimeUnitsWithDescOrder(long durationInNanos) {
    	List<TimeUnit> timeUnitDescOrder = timeUnitsDescOrder();
    	LinkedHashMap<TimeUnit, Long> timeUnitValueMapDescOrder = new LinkedHashMap<>();
    	EnumMap<TimeUnit, Long> timeUnitValueMap = splitNanosIntoTimeUnitsWithAscOrder(durationInNanos);
    	for (TimeUnit timeUnit : timeUnitDescOrder) {
    		timeUnitValueMapDescOrder.put(timeUnit, timeUnitValueMap.get(timeUnit));
        }
		return timeUnitValueMapDescOrder;
    }
    
    /**
     * Splits the given duration into time units with descending order.
     *
     * @param duration the duration to be split
     * @return a {@code LinkedHashMap} containing time units and their corresponding values in descending order
     */
    public static LinkedHashMap<TimeUnit, Long> splitDurationIntoTimeUnitsWithDescOrder(Duration duration) {
        long durationInNanos = duration.toNanos();
        return splitNanosIntoTimeUnitsWithDescOrder(durationInNanos);
    }
    
    /**
     * Splits the given duration into time units with descending order.
     *
     * @param duration the duration to be split
     * @return a {@code LinkedHashMap} containing time units and their corresponding values in descending order
     */
    private static List<TimeUnit> timeUnitsDescOrder() {
    	List<TimeUnit> timeUnitsDescOrder = timeUnitsAscOrder();
    	Collections.reverse(timeUnitsDescOrder);
    	return timeUnitsDescOrder;
    }
    
    /**
     * @return a list of time units in ascending order
     */
    private static List<TimeUnit> timeUnitsAscOrder() {
    	return Arrays.asList(TimeUnit.values());
    }
    
}
