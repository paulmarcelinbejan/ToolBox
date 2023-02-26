package com.paulmarcelinbejan.architecture.utils.math;

import static com.paulmarcelinbejan.architecture.constants.Symbols.DOT;
import static com.paulmarcelinbejan.architecture.utils.math.enums.NumberFormatPattern.DECIMALS_ALWAYS;
import static com.paulmarcelinbejan.architecture.utils.math.enums.NumberFormatPattern.DECIMALS_IF_PRESENT;
import static com.paulmarcelinbejan.architecture.utils.math.enums.NumberFormatPattern.DECIMALS_NEVER;
import static org.apache.commons.lang3.StringUtils.EMPTY;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Map;
import java.util.function.Function;

import com.paulmarcelinbejan.architecture.constants.numeric.Numbers;
import com.paulmarcelinbejan.architecture.utils.math.enums.NumberFormatPattern;

import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NumberFormatUtils {
	
	private static final String INTEGER_PATTERN = "#0";
	
	private static final Map<NumberFormatPattern, Function<Integer, String>> NUMBER_FORMAT_PATTERN_MAP = Map.of(
			DECIMALS_ALWAYS, NumberFormatUtils::getPatternDecimalsAlways,
			DECIMALS_IF_PRESENT, NumberFormatUtils::getPatternDecimalsIfPresent,
			DECIMALS_NEVER, NumberFormatUtils::getPatternDecimalsNever
	);
	
	// FROM BigDecimal TO String
	
	public static String toString(final BigDecimal numberToFormat, @Positive final int scale, final NumberFormatPattern numberFormatPattern) {
		return getDecimalFormat(scale, numberFormatPattern).format(numberToFormat);
	}
	
	public static String toString(final BigDecimal numberToFormat, @Positive final int scale, final char decimalSeparator, final NumberFormatPattern numberFormatPattern) {
		return getDecimalFormat(scale, decimalSeparator, numberFormatPattern).format(numberToFormat);
	}
	
	public static String toString(final BigDecimal numberToFormat, @Positive final int scale, final char decimalSeparator, final char groupingSeparator, final NumberFormatPattern numberFormatPattern) {
		return getDecimalFormat(scale, decimalSeparator, groupingSeparator, numberFormatPattern).format(numberToFormat);
	}
	
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
		if (decimalSeparator == groupingSeparator) throw new IllegalArgumentException("decimalSeparator and groupingSeparator can't have the same value");
		numberToFormat = replaceDecimalSeparator(numberToFormat, decimalSeparator);
		numberToFormat = replaceGroupingSeparator(numberToFormat, groupingSeparator);
		return NumberUtils.toBigDecimal(numberToFormat);
	}
	
	private static DecimalFormat getDecimalFormat(final int scale, final NumberFormatPattern numberFormatPattern) {		
		String pattern = NUMBER_FORMAT_PATTERN_MAP.get(numberFormatPattern).apply(scale);
		return new DecimalFormat(pattern);
	}
	
	private static DecimalFormat getDecimalFormat(final int scale, final char decimalSeparator, final NumberFormatPattern numberFormatPattern) {
		final DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator(decimalSeparator);
		
		String pattern = NUMBER_FORMAT_PATTERN_MAP.get(numberFormatPattern).apply(scale);
		return new DecimalFormat(pattern, symbols);
	}
	
	private static DecimalFormat getDecimalFormat(final int scale, final char decimalSeparator, final char groupingSeparator, final NumberFormatPattern numberFormatPattern) {
		final DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator(decimalSeparator);
		symbols.setGroupingSeparator(groupingSeparator);
		
		String pattern = NUMBER_FORMAT_PATTERN_MAP.get(numberFormatPattern).apply(scale);
		return new DecimalFormat(pattern, symbols);
	}
	
	/**
	 * DECIMALS_ALWAYS
	 * show decimals always, also if it's equal to 0
	 * 
	 * Example:
	 * <br>scale 6: 24.102030 -> 24.102030
	 * <br>scale 4: 24.102030 -> 24.1020
	 */
	private static String getPatternDecimalsAlways(final int scale) {
		if(scale == 0) {
			return INTEGER_PATTERN;
		}
		return "#0." + "0".repeat(scale);
	}
	
	/**
	 * DECIMALS_IF_PRESENT
	 * show decimals until the last decimal value
	 * 
	 * Example:
	 * <br>scale 6: 24.102030 -> 24.10203
	 * <br>scale 4: 24.102030 -> 24.102
	 */
	private static String getPatternDecimalsIfPresent(final int scale) {
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
	private static String getPatternDecimalsNever(final int scale) {
		return INTEGER_PATTERN;
	}
	
	private static String replaceDecimalSeparator(final String toFormat, final char decimalSeparator) {
		return toFormat.replace(String.valueOf(decimalSeparator), DOT);
	}
	
	private static String replaceGroupingSeparator(final String toFormat, final char groupingSeparator) {
		return toFormat.replace(String.valueOf(groupingSeparator), EMPTY);
	}
	
}
