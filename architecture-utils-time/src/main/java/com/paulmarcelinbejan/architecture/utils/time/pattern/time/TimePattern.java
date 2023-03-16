package com.paulmarcelinbejan.architecture.utils.time.pattern.time;

public enum TimePattern {

	/**
	 * 14:15
	 */
	HHmm("HH:mm"),
	
	/**
	 * 14:15:11
	 */
	HHmmss("HH:mm:ss"),
	
	/**
	 * 14:15:11.123
	 */
	HHmmss_SSS("HH:mm:ss.SSS"),
	
	/**
	 * 14:15:11.123456
	 */
	HHmmss_SSSSSS("HH:mm:ss.SSSSSS"),
	
	/**
	 * 14:15:11.123456789
	 */
	HHmmss_SSSSSSSSS("HH:mm:ss.SSSSSSSSS");
	
    public final String value;

    private TimePattern(String value) {
        this.value = value;
    }
	
}
