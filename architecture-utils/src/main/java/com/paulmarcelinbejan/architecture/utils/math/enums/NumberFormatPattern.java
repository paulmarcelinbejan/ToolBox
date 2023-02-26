package com.paulmarcelinbejan.architecture.utils.math.enums;

public enum NumberFormatPattern {

	/**
	 * DECIMALS_ALWAYS
	 * show decimals always, also if it's equal to 0
	 * 
	 * Example:
	 * <br>scale 6: 24.102030 -> 24.102030
	 * <br>scale 4: 24.102030 -> 24.1020
	 */
	DECIMALS_ALWAYS,
	
	/**
	 * DECIMALS_IF_PRESENT
	 * show decimals until the last valorized decimal
	 * 
	 * Example:
	 * <br>scale 6: 24.102030 -> 24.10203
	 * <br>scale 4: 24.102030 -> 24.102
	 */
	DECIMALS_IF_PRESENT,
	
	/**
	 * DECIMALS_NEVER
	 * show only integer value
	 * 
	 * Example:
	 * <br>scale 6: 24.102030 -> 24
	 * <br>scale 4: 24.102030 -> 24
	 */
	DECIMALS_NEVER,
	
	/**
	 * DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT
	 * show first part of decimals in any case, then show decimals until the last valorized decimal
	 * 
	 * Example:
	 * <br>scale 6, scaleShowAlways 2: 24.102030 -> 24.10203
	 * <br>scale 6: scaleShowAlways 3: 24.000000 -> 24.000
	 */
	DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT;
	
}
