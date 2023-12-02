package io.github.paulmarcelinbejan.toolbox.utils.time.aware;

import java.time.LocalDateTime;

/**
 * The {@code HistoricalLocalDateTimeAware} interface represents an entity that is aware of historical time
 * intervals defined by start and end {@link LocalDateTime}s.
 */
public interface HistoricalLocalDateTimeAware {

    /**
     * Gets the start local date and time of the historical time interval.
     *
     * @return The start {@link LocalDateTime}.
     */
    LocalDateTime startLocalDateTime();

    /**
     * Gets the end local date and time of the historical time interval.
     *
     * @return The end {@link LocalDateTime}.
     */
    LocalDateTime endLocalDateTime();
    
}

