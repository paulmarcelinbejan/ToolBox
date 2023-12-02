package io.github.paulmarcelinbejan.toolbox.utils.time.pattern.datetime;

import java.time.format.DateTimeFormatter;

import io.github.paulmarcelinbejan.toolbox.utils.time.pattern.DateTimePatternBase;
import io.github.paulmarcelinbejan.toolbox.utils.time.pattern.date.DatePattern;
import io.github.paulmarcelinbejan.toolbox.utils.time.pattern.time.TimePattern;
import lombok.Getter;

/**
 * DateTimePattern
 * <p>
 * Represents various date and time patterns. You can build a large number of DateTimePattern instances
 * by combining a DatePattern with a TimePattern. Use the {@link DateTimePattern#buildPattern(DatePattern, String, TimePattern)} method
 * to create patterns with date and time.
 * </p>
 */
public enum DateTimePattern implements DateTimePatternBase {

    /**
     * For example: "Thu, Sep 29, 2022 13:45:30 UTC"
     */
    EEEMMMdyyyyhmmssaz("EEE, MMM d, yyyy HH:mm:ss z"),

    /**
     * For example: "Tuesday, August 23, 2016 1:12:45 PM EEST"
     */
    EEEEMMMMdyyyyhmmssaz("EEEE, MMMM d, yyyy h:mm:ss a z"),

    /**
     * For example: "Thursday, March 17, 2023 2:30:45 PM EST"
     */
    EEEEMMMMdyyyyhmmssazzz("EEEE, MMMM d, yyyy h:mm:ss A zzz"),

    /**
     * For example: "Thu Mar 17 14:45:30 EDT 2023"
     */
    EEEMMMddHHmmsszzzyyyy("EEE MMM dd HH:mm:ss zzz yyyy"),

    /**
     * For example: "Jun 09 2018 15:28:14"
     */
    MMMddyyyyHHmmss("MMM dd yyyy HH:mm:ss");

    /**
     * The pattern value of the enum;
     */
    @Getter
    public final String value;

    /**
     * Configured formatter for the specified pattern. The formatter is not localized!
     */
    @Getter
    public final DateTimeFormatter formatter;

    /**
     * Constructs a DateTimePattern with the given pattern value.
     *
     * @param value The pattern value.
     */
    private DateTimePattern(String value) {
        this.value = value;
        this.formatter = DateTimeFormatter.ofPattern(value);
    }
    
}
