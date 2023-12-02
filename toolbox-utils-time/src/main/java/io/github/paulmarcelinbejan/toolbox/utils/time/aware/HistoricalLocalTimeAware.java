package io.github.paulmarcelinbejan.toolbox.utils.time.aware;

import java.time.LocalTime;

/**
 * The {@code HistoricalLocalTimeAware} interface represents an entity that is aware of historical time
 * intervals defined by start and end {@code LocalTime}s.
 */
public interface HistoricalLocalTimeAware {

    /**
     * Gets the start local time of the historical time interval.
     *
     * @return The start {@code LocalTime}.
     */
    LocalTime startLocalTime();

    /**
     * Gets the end local time of the historical time interval.
     *
     * @return The end {@code LocalTime}.
     */
    LocalTime endLocalTime();
    
}

