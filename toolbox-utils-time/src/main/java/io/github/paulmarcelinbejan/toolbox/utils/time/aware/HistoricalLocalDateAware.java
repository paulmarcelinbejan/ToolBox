package io.github.paulmarcelinbejan.toolbox.utils.time.aware;

import java.time.LocalDate;

/**
 * The {@code HistoricalLocalDateAware} interface represents an entity that is aware of historical time
 * intervals defined by start and end {@link LocalDate}s.
 */
public interface HistoricalLocalDateAware {

    /**
     * Gets the start date of the historical time interval.
     *
     * @return The start {@link LocalDate}.
     */
    LocalDate startLocalDate();

    /**
     * Gets the end date of the historical time interval.
     *
     * @return The end {@link LocalDate}.
     */
    LocalDate endLocalDate();
    
}
