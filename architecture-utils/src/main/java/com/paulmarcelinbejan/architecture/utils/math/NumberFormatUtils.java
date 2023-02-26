package com.paulmarcelinbejan.architecture.utils.math;

import static com.paulmarcelinbejan.architecture.constants.Symbols.DOT;
import static com.paulmarcelinbejan.architecture.utils.math.enums.NumberFormatPattern.DECIMALS_ALWAYS;
import static com.paulmarcelinbejan.architecture.utils.math.enums.NumberFormatPattern.DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT;
import static com.paulmarcelinbejan.architecture.utils.math.enums.NumberFormatPattern.DECIMALS_IF_PRESENT;
import static com.paulmarcelinbejan.architecture.utils.math.enums.NumberFormatPattern.DECIMALS_NEVER;
import static org.apache.commons.lang3.StringUtils.EMPTY;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Map;
import java.util.function.Function;

import com.paulmarcelinbejan.architecture.utils.math.enums.NumberFormatPattern;

import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NumberFormatUtils {
	
	private static final String INTEGER_PATTERN = "#0";
	
	private static final String SCALE_SHOW_ALWAYS_CAN_NOT_BE_GREATER_THAN_SCALE = "scaleShowAlways can't be greater than scale.";
	
	private static final Map<NumberFormatPattern, Function<Integer, String>> NUMBER_FORMAT_PATTERN_MAP = Map.of(
			DECIMALS_ALWAYS, NumberFormatUtils::buildPatternDecimalsAlways,
			DECIMALS_IF_PRESENT, NumberFormatUtils::buildPatternDecimalsIfPresent,
			DECIMALS_NEVER, NumberFormatUtils::buildPatternDecimalsNever
	);
	
	// FROM String TO BigDecimal
	
	/**
	 * @throws NumberFormatException if {@code numberToFormat} is not a valid
     *         representation of a {@code BigDecimal}.
	 */
	public static BigDecimal toBigDecimal(final String numberToFormat) {
		return NumberUtils.toBigDecimal(numberToFormat);
	}
	
	public static BigDecimal toBigDecimal(String numberToFormat, final char decimalSeparator) {
		numberToFormat = replaceDecimalSeparator(numberToFormat, decimalSeparator);
		return NumberUtils.toBigDecimal(numberToFormat);
	}
	
	public static BigDecimal toBigDecimal(String numberToFormat, final char decimalSeparator, final char groupingSeparator) {
		if (decimalSeparator == groupingSeparator) throw new IllegalArgumentException("decimalSeparator and groupingSeparator can't have the same value.");
		numberToFormat = replaceDecimalSeparator(numberToFormat, decimalSeparator);
		numberToFormat = replaceGroupingSeparator(numberToFormat, groupingSeparator);
		return NumberUtils.toBigDecimal(numberToFormat);
	}
	
	// FROM BigDecimal TO String
	
	public static String toString(final BigDecimal numberToFormat, @Positive final int scale, final NumberFormatPattern numberFormatPattern) {
		return format(numberToFormat, scale, numberFormatPattern);
	}
	
	/**
	 * Use this method for {@link NumberFormatPattern#DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT}
	 * 
	 * scale = the total number of decimal places
	 * scaleShowAlways = the number of decimal places that must be showed in any case.
	 */
	public static String toString(final BigDecimal numberToFormat, @Positive final int scale, @Positive final int scaleShowAlways) {
		if(scale < scaleShowAlways) throw new IllegalArgumentException(SCALE_SHOW_ALWAYS_CAN_NOT_BE_GREATER_THAN_SCALE);
		return format(numberToFormat, scale, scaleShowAlways);
	}
	
	public static String toString(final BigDecimal numberToFormat, @Positive final int scale, final char decimalSeparator, final NumberFormatPattern numberFormatPattern) {
		return format(numberToFormat, scale, decimalSeparator, numberFormatPattern);
	}
	
	/**
	 * Use this method for {@link NumberFormatPattern#DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT}
	 * 
	 * scale = the total number of decimal places
	 * scaleShowAlways = the number of decimal places that must be showed in any case.
	 */
	public static String toString(final BigDecimal numberToFormat, @Positive final int scale, @Positive final int scaleShowAlways, final char decimalSeparator) {
		if(scale < scaleShowAlways) throw new IllegalArgumentException(SCALE_SHOW_ALWAYS_CAN_NOT_BE_GREATER_THAN_SCALE);
		return format(numberToFormat, scale, scaleShowAlways, decimalSeparator);
	}
	
	public static String toString(final BigDecimal numberToFormat, @Positive final int scale, final char decimalSeparator, final char groupingSeparator, final NumberFormatPattern numberFormatPattern) {
		return format(numberToFormat, scale, decimalSeparator, groupingSeparator, numberFormatPattern);
	}
	
	/**
	 * Use this method for {@link NumberFormatPattern#DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT}
	 * 
	 * scale = the total number of decimal places
	 * scaleShowAlways = the number of decimal places that must be showed in any case.
	 */
	public static String toString(final BigDecimal numberToFormat, @Positive final int scale, @Positive final int scaleShowAlways, final char decimalSeparator, final char groupingSeparator) {
		if(scale < scaleShowAlways) throw new IllegalArgumentException(SCALE_SHOW_ALWAYS_CAN_NOT_BE_GREATER_THAN_SCALE);
		return format(numberToFormat, scale, scaleShowAlways, decimalSeparator, groupingSeparator);
	}
	
	// Format
	
	private static void invalidNumberFormatPattern(final NumberFormatPattern numberFormatPattern) {
		if(numberFormatPattern == DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT) {
			throw new IllegalArgumentException("DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT can't be used in this method. An additional parameter (int scaleShowAlways) is needed.");
		}
	}
	
	private static String format(final BigDecimal numberToFormat, final int scale, final NumberFormatPattern numberFormatPattern) {
		invalidNumberFormatPattern(numberFormatPattern);
		
		String pattern = getPattern(scale, numberFormatPattern);
		
		return getDecimalFormat(pattern).format(numberToFormat);
	}
	
	private static String format(final BigDecimal numberToFormat, final int scale, final int scaleShowAlways) {
		String pattern = getPattern(scale, scaleShowAlways);
		
		return getDecimalFormat(pattern).format(numberToFormat);
	}
	
	private static String format(final BigDecimal numberToFormat, final int scale, final char decimalSeparator, final NumberFormatPattern numberFormatPattern) {
		invalidNumberFormatPattern(numberFormatPattern);
		
		String pattern = getPattern(scale, numberFormatPattern);
		DecimalFormatSymbols symbols = getDecimalFormatSymbols(decimalSeparator);
		
		return getDecimalFormat(pattern, symbols).format(numberToFormat);
	}
	
	private static String format(final BigDecimal numberToFormat, final int scale, final int scaleShowAlways, final char decimalSeparator) {
		String pattern = getPattern(scale, scaleShowAlways);
		DecimalFormatSymbols symbols = getDecimalFormatSymbols(decimalSeparator);
		
		return getDecimalFormat(pattern, symbols).format(numberToFormat);
	}
	
	private static String format(final BigDecimal numberToFormat, final int scale, final char decimalSeparator, final char groupingSeparator, final NumberFormatPattern numberFormatPattern) {
		invalidNumberFormatPattern(numberFormatPattern);
		
		String pattern = getPattern(scale, numberFormatPattern);
		DecimalFormatSymbols symbols = getDecimalFormatSymbols(decimalSeparator, groupingSeparator);
		
		return getDecimalFormat(pattern, symbols).format(numberToFormat);
	}
	
	private static String format(final BigDecimal numberToFormat, final int scale, final int scaleShowAlways, final char decimalSeparator, final char groupingSeparator) {
		String pattern = getPattern(scale, scaleShowAlways);
		DecimalFormatSymbols symbols = getDecimalFormatSymbols(decimalSeparator, groupingSeparator);

		return getDecimalFormat(pattern, symbols).format(numberToFormat);
	}
	
	// DecimalFormat
	
	private static DecimalFormat getDecimalFormat(final String pattern) {
		return new DecimalFormat(pattern);
	}
	
	private static DecimalFormat getDecimalFormat(final String pattern, final DecimalFormatSymbols decimalFormatSymbols) {
		return new DecimalFormat(pattern, decimalFormatSymbols);
	}
	
	private static DecimalFormatSymbols getDecimalFormatSymbols(final char decimalSeparator) {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator(decimalSeparator);
		return symbols;
	}
	
	private static DecimalFormatSymbols getDecimalFormatSymbols(final char decimalSeparator, final char groupingSeparator) {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator(decimalSeparator);
		symbols.setGroupingSeparator(groupingSeparator);
		return symbols;
	}
	
	// Pattern 
	
	private static String getPattern(final int scale, final NumberFormatPattern numberFormatPattern) {
		return NUMBER_FORMAT_PATTERN_MAP.get(numberFormatPattern).apply(scale);
	}
	
	private static String getPattern(final int scale, final int scaleShowAlways) {
		return buildPatternDecimalsFirstPartAlwaysSecondPartIfPresent(scale, scaleShowAlways);
	}
	
	/**
	 * DECIMALS_ALWAYS
	 * show decimals always, also if it's equal to 0
	 * 
	 * Example:
	 * <br>scale 6: 24.102030 -> 24.102030
	 * <br>scale 4: 24.102030 -> 24.1020
	 */
	private static String buildPatternDecimalsAlways(final int scale) {
		if(scale == 0) {
			return INTEGER_PATTERN;
		}
		return "#0." + "0".repeat(scale);
	}
	
	/**
	 * DECIMALS_IF_PRESENT
	 * show decimals until the last valorized decimal
	 * 
	 * Example:
	 * <br>scale 6: 24.102030 -> 24.10203
	 * <br>scale 4: 24.102030 -> 24.102
	 */
	private static String buildPatternDecimalsIfPresent(final int scale) {
		if(scale == 0) {
			return INTEGER_PATTERN;
		}
		return "#0." + "#".repeat(scale);
	}
	
	/**
	 * DECIMALS_NEVER
	 * show only integer value
	 * 
	 * Example:
	 * <br>scale 6: 24.102030 -> 24
	 * <br>scale 4: 24.102030 -> 24
	 */
	private static String buildPatternDecimalsNever(final int scale) {
		return INTEGER_PATTERN;
	}
	
	/**
	 * DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT
	 * show first part of decimals in any case, then show decimals until the last valorized decimal
	 * 
	 * Example:
	 * <br>scale 6, scaleShowAlways 2: 24.102030 -> 24.10203
	 * <br>scale 6: scaleShowAlways 3: 24.000000 -> 24.000
	 */
	private static String buildPatternDecimalsFirstPartAlwaysSecondPartIfPresent(final int scale, final int scaleShowAlways) {
		if(scale == 0) {
			return INTEGER_PATTERN;
		}
		
		String pattern = "#0.";
		
		pattern = pattern + "0".repeat(scaleShowAlways);
		pattern = pattern + "#".repeat(scale - scaleShowAlways);
		
		return pattern;
	}
	
	private static String replaceDecimalSeparator(final String toFormat, final char decimalSeparator) {
		return toFormat.replace(String.valueOf(decimalSeparator), DOT);
	}
	
	private static String replaceGroupingSeparator(final String toFormat, final char groupingSeparator) {
		return toFormat.replace(String.valueOf(groupingSeparator), EMPTY);
	}
	
}
