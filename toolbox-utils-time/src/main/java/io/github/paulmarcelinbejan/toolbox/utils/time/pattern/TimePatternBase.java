package io.github.paulmarcelinbejan.toolbox.utils.time.pattern;

import java.time.format.DateTimeFormatter;

import io.github.paulmarcelinbejan.toolbox.base.enums.EnumBase;

/**
 * A base interface for time patterns.
 */
public interface TimePatternBase extends EnumBase {

    /**
     * Gets the DateTimeFormatter associated with the time pattern.
     *
     * @return The DateTimeFormatter for the time pattern.
     */
	DateTimeFormatter getFormatter();

}
