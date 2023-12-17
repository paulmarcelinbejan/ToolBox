package io.github.paulmarcelinbejan.architecture.utils.time.duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import io.github.paulmarcelinbejan.toolbox.utils.time.duration.DurationUtils;

class DurationUtilsTest {

	@Test
    void splitNanosIntoTimeUnitsWithAscOrder() {
    	Long durationInNanoSeconds = 37_240_080_000_160L;
    	
    	Map<TimeUnit, Long> expected = new EnumMap<>(TimeUnit.class);
    	expected.put(TimeUnit.NANOSECONDS, 160L);
        expected.put(TimeUnit.MICROSECONDS, 0L);
        expected.put(TimeUnit.MILLISECONDS, 80L);
        expected.put(TimeUnit.SECONDS, 40L);
        expected.put(TimeUnit.MINUTES, 20L);
        expected.put(TimeUnit.HOURS, 10L);
        expected.put(TimeUnit.DAYS, 0L);
    	
        Map<TimeUnit, Long> timeUnitValueMap = DurationUtils.splitNanosIntoTimeUnitsWithAscOrder(durationInNanoSeconds);
    	
    	assertEquals(expected, timeUnitValueMap);
    }
    
	@Test
    void splitDurationIntoTimeUnitsWithAscOrder() {
    	Long durationInNanoSeconds = 37_240_080_000_160L;
    	Duration duration = Duration.ofNanos(durationInNanoSeconds);
    	
    	Map<TimeUnit, Long> expected = new EnumMap<>(TimeUnit.class);
    	expected.put(TimeUnit.NANOSECONDS, 160L);
        expected.put(TimeUnit.MICROSECONDS, 0L);
        expected.put(TimeUnit.MILLISECONDS, 80L);
        expected.put(TimeUnit.SECONDS, 40L);
        expected.put(TimeUnit.MINUTES, 20L);
        expected.put(TimeUnit.HOURS, 10L);
        expected.put(TimeUnit.DAYS, 0L);
        
        Map<TimeUnit, Long> timeUnitValueMap = DurationUtils.splitDurationIntoTimeUnitsWithAscOrder(duration);
        
        assertEquals(expected, timeUnitValueMap);
    }
	
	@Test
    void splitNanosIntoTimeUnitsWithDescOrder() {
		Long durationInNanoSeconds = 210_040_080_555_160L;
		
		LinkedHashMap<TimeUnit, Long> expected = new LinkedHashMap<>();
    	expected.put(TimeUnit.DAYS, 2L);
        expected.put(TimeUnit.HOURS, 10L);
        expected.put(TimeUnit.MINUTES, 20L);
        expected.put(TimeUnit.SECONDS, 40L);
        expected.put(TimeUnit.MILLISECONDS, 80L);
        expected.put(TimeUnit.MICROSECONDS, 555L);
        expected.put(TimeUnit.NANOSECONDS, 160L);
        
        LinkedHashMap<TimeUnit, Long> timeUnitValueListDescOrder = DurationUtils.splitNanosIntoTimeUnitsWithDescOrder(durationInNanoSeconds);
        
        assertEquals(expected, timeUnitValueListDescOrder);
    }
	
	@Test
    void splitDurationIntoTimeUnitsWithDescOrder() {
		Long durationInNanoSeconds = 210_040_080_555_160L;
		Duration duration = Duration.ofNanos(durationInNanoSeconds);
		
		LinkedHashMap<TimeUnit, Long> expected = new LinkedHashMap<>();
    	expected.put(TimeUnit.DAYS, 2L);
        expected.put(TimeUnit.HOURS, 10L);
        expected.put(TimeUnit.MINUTES, 20L);
        expected.put(TimeUnit.SECONDS, 40L);
        expected.put(TimeUnit.MILLISECONDS, 80L);
        expected.put(TimeUnit.MICROSECONDS, 555L);
        expected.put(TimeUnit.NANOSECONDS, 160L);
        
        LinkedHashMap<TimeUnit, Long> timeUnitValueListDescOrder = DurationUtils.splitDurationIntoTimeUnitsWithDescOrder(duration);
        
        assertEquals(expected, timeUnitValueListDescOrder);
    }
	
}
