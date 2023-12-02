package io.github.paulmarcelinbejan.toolbox.utils.time.aware;

import java.time.Instant;

/**
 * The {@code HistoricalInstantAware} interface represents an entity that is aware of historical time
 * intervals defined by start and end {@link Instant}s.
 */
public interface HistoricalInstantAware {

    /**
     * Gets the start instant of the historical time interval.
     *
     * @return The start {@link Instant}.
     */
    Instant startInstant();

    /**
     * Gets the end instant of the historical time interval.
     *
     * @return The end {@link Instant}.
     */
    Instant endInstant();
    
}
