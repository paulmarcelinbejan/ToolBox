package com.paulmarcelinbejan.toolbox.utils.time.pattern.time;

import java.time.format.DateTimeFormatter;

import com.paulmarcelinbejan.toolbox.utils.time.pattern.TimePatternBase;

import lombok.Getter;

/**
 * Time Pattern
 */
public enum TimePattern {

	;
	
	/**
     * Time patterns with 12-hour clock format.
     */
	public enum With12HourClockFormat implements TimePatternBase {
		
		/**
         * The pattern for hours and minutes in 12-hour clock format, with AM/PM marker.
         * For example: "12:30 PM"
         */
		hhmm("hh:mm A"),
		
		/**
         * The pattern for hours, minutes, and seconds in 12-hour clock format, with AM/PM marker.
         * For example: "12:30:45 PM"
         */
		hhmmss("hh:mm:ss A"),
		
		/**
         * The pattern for hours, minutes, seconds, and microseconds in 12-hour clock format, with AM/PM marker.
         * For example: "12:30:45.123 PM"
         */
		hhmmss_SSS("hh:mm:ss.SSS A"),
		
		/**
         * The pattern for hours, minutes, seconds and microseconds in 12-hour clock format, with AM/PM marker.
         * For example: "12:30:45.123456 PM"
         */
		hhmmss_SSSSSS("hh:mm:ss.SSSSSS A"),
		
		/**
         * The pattern for hours, minutes, seconds and nanoseconds in 12-hour clock format, with AM/PM marker.
         * For example: "12:30:45.123456789 PM"
         */
		hhmmss_SSSSSSSSS("hh:mm:ss.SSSSSSSSS A");
		
		/**
		 * The pattern value of the enum;
		 */
		@Getter
	    public final String value;

		/**
	     * Configured formatter for the specified pattern.
	     * The formatter is not localized!
	     */
		@Getter
	    public final DateTimeFormatter formatter;
	    
	    private With12HourClockFormat(String value) {
	        this.value = value;
	        this.formatter = DateTimeFormatter.ofPattern(value);
	    }
	    
	}
	
	/**
     * Time patterns with 24-hour clock format.
     */
	public enum With24HourClockFormat implements TimePatternBase {
		
		/**
         * The pattern for hours and minutes in 24-hour clock format.
         * For example: "14:30"
         */
		HHmm("HH:mm"),
		
		/**
         * The pattern for hours, minutes, and seconds in 24-hour clock format.
         * For example: "14:30:45"
         */
		HHmmss("HH:mm:ss"),
		
		/**
         * The pattern for hours, minutes, seconds and milliseconds in 24-hour clock format.
         * For example: "14:30:45.123"
         */
		HHmmss_SSS("HH:mm:ss.SSS"),
		
		/**
         * The pattern for hours, minutes, seconds and microseconds in 24-hour clock format.
         * For example: "14:30:45.123456"
         */
		HHmmss_SSSSSS("HH:mm:ss.SSSSSS"),
		
		/**
         * The pattern for hours, minutes, seconds and nanoseconds in 24-hour clock format.
         * For example: "14:30:45.123456789"
         */
		HHmmss_SSSSSSSSS("HH:mm:ss.SSSSSSSSS");
		
		/**
		 * The pattern value of the enum;
		 */
		@Getter
	    public final String value;

		/**
	     * Configured formatter for the specified pattern.
	     * The formatter is not localized!
	     */
		@Getter
	    public final DateTimeFormatter formatter;
	    
	    private With24HourClockFormat(String value) {
	        this.value = value;
	        this.formatter = DateTimeFormatter.ofPattern(value);
	    }
	    
	}
	
}
