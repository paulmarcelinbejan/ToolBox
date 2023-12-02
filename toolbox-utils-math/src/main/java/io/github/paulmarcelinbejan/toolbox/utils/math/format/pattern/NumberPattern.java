package io.github.paulmarcelinbejan.toolbox.utils.math.format.pattern;

public enum NumberPattern {

	/**
	 * DECIMALS_ALWAYS
	 * <br>show decimals always, also if it's equal to 0
	 * <br>
	 * <br>Example:
	 * <br>decimalPlaces 6: 24.102030 -> 24.102030
	 * <br>decimalPlaces 4: 24.102030 -> 24.1020
	 */
	DECIMALS_ALWAYS,
	
	/**
	 * DECIMALS_IF_PRESENT
	 * <br>show decimals until the last valorized decimal
	 * <br>
	 * <br>Example:
	 * <br>decimalPlaces 6: 24.102030 -> 24.10203
	 * <br>decimalPlaces 4: 24.102030 -> 24.102
	 */
	DECIMALS_IF_PRESENT,
	
	/**
	 * DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT
	 * <br>show first part of decimals in any case, then show decimals until the last valorized decimal
	 * <br>
	 * <br>Example:
	 * <br>decimalPlacesTot 6, decimalPlacesToShowAlways 2 : 24.102030 -> 24.10203
	 * <br>decimalPlacesTot 6, decimalPlacesToShowAlways 3 : 24.000000 -> 24.000
	 */
	DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT;
	
}
