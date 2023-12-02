package io.github.paulmarcelinbejan.toolbox.utils.time.pattern;

import java.time.format.DateTimeFormatter;

import io.github.paulmarcelinbejan.toolbox.base.enums.EnumBase;

/**
 * A base interface for date and time pattern enums, extending {@link EnumBase}.
 * It provides a method to obtain the associated {@link DateTimeFormatter}.
 */
public interface DateTimePatternBase extends EnumBase {

    /**
     * Gets the {@link DateTimeFormatter} associated with this date and time pattern.
     *
     * @return The {@link DateTimeFormatter} for this date and time pattern.
     */
    DateTimeFormatter getFormatter();
    
}

