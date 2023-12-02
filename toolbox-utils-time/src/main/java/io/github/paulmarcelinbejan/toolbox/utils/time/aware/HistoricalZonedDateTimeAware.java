package io.github.paulmarcelinbejan.toolbox.utils.time.aware;

import java.time.ZonedDateTime;

/**
 * The {@code HistoricalZonedDateTimeAware} interface represents an entity that is aware of historical time
 * intervals defined by start and end {@code ZonedDateTime}s.
 */
public interface HistoricalZonedDateTimeAware {

    /**
     * Gets the start ZonedDateTime of the historical time interval.
     *
     * @return The start {@code ZonedDateTime}.
     */
    ZonedDateTime startInstant();

    /**
     * Gets the end ZonedDateTime of the historical time interval.
     *
     * @return The end {@code ZonedDateTime}.
     */
    ZonedDateTime endInstant();

}
