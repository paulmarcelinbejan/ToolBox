package io.github.paulmarcelinbejan.toolbox.utils.time.pattern;

import java.time.format.DateTimeFormatter;

import io.github.paulmarcelinbejan.toolbox.base.enums.EnumBase;

/**
 * A base interface for date patterns.
 */
public interface DatePatternBase extends EnumBase {

    /**
     * Gets the DateTimeFormatter associated with the date pattern.
     *
     * @return The DateTimeFormatter for the date pattern.
     */
    public DateTimeFormatter getFormatter();

}
