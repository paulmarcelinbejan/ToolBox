package com.paulmarcelinbejan.architecture.utils.math.format;

import static com.paulmarcelinbejan.architecture.constants.Symbols.DOT;
import static com.paulmarcelinbejan.architecture.constants.Symbols.EMPTY;
import static com.paulmarcelinbejan.architecture.utils.math.format.pattern.NumberPattern.DECIMALS_ALWAYS;
import static com.paulmarcelinbejan.architecture.utils.math.format.pattern.NumberPattern.DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT;
import static com.paulmarcelinbejan.architecture.utils.math.format.pattern.NumberPattern.DECIMALS_IF_PRESENT;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import com.paulmarcelinbejan.architecture.constants.SymbolsAsChar;
import com.paulmarcelinbejan.architecture.utils.math.NumberUtils;
import com.paulmarcelinbejan.architecture.utils.math.format.pattern.NumberPattern;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * BigDecimal default representation consist of:
 * <br> decimalSeprator: DOT
 * <br> groupingSeparator: NONE
 * <br> example: 123456789.123456
 * 
 * <p>With this utility class, you can transform:
 * <br> BigDecimal into String
 * <br> String into BigDecimal
 * <br> using the format you prefer.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NumberFormatUtils {
	
	// Constants
	public static final String INTEGER_PATTERN = "###,##0";
	public static final String INTEGER_PATTERN_DOT = INTEGER_PATTERN+".";
	
	// FROM String TO BigDecimal
	
	/**
	 * @throws NumberFormatException if {@code numberToFormat} is not a valid
     *         representation of a {@code BigDecimal}.
	 */
	public static BigDecimal toBigDecimal(@NonNull final String numberToFormat) {
		return NumberUtils.toBigDecimal(numberToFormat);
	}
	
	public static BigDecimal toBigDecimal(@NonNull String numberToFormat, final char decimalSeparator) {
		numberToFormat = replaceDecimalSeparator(numberToFormat, decimalSeparator);
		return NumberUtils.toBigDecimal(numberToFormat);
	}
	
	public static BigDecimal toBigDecimal(@NonNull String numberToFormat, final char decimalSeparator, final char groupingSeparator) {
		validateSeparators(decimalSeparator, groupingSeparator);
		
		numberToFormat = replaceDecimalSeparator(numberToFormat, decimalSeparator);
		numberToFormat = replaceGroupingSeparator(numberToFormat, groupingSeparator);
		return NumberUtils.toBigDecimal(numberToFormat);
	}
	
	// FROM BigDecimal TO String
	
	public static String toString(final BigDecimal numberToFormat) {
		return numberToFormat.toString();
	}
	
	public static String toString(@NonNull final BigDecimal numberToFormat, final int scale, @NonNull final NumberPattern numberFormatPattern) {
		validateScale(scale);
		
		return toString(numberToFormat, scale, SymbolsAsChar.DOT, numberFormatPattern);
	}
	
	public static String toString(@NonNull final BigDecimal numberToFormat, final int scale, final char decimalSeparator, @NonNull final NumberPattern numberFormatPattern) {
		validateScale(scale);
		
		String pattern = getPattern(scale, numberFormatPattern);
		return format(numberToFormat, pattern, decimalSeparator);
	}
	
	public static String toString(@NonNull final BigDecimal numberToFormat, final int scale, final char decimalSeparator, final char groupingSeparator, @NonNull final NumberPattern numberFormatPattern) {
		validateScale(scale);
		validateSeparators(decimalSeparator, groupingSeparator);
		
		String pattern = getPattern(scale, numberFormatPattern);
		return format(numberToFormat, pattern, decimalSeparator, groupingSeparator);
	}
	
	/**
	 * Method for {@link NumberPattern#DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT}
	 * 
	 * scaleTot = the total number of decimal places
	 * scaleToShowAlways = the number of decimal places that must be showed in any case.
	 */
	public static String toString(@NonNull final BigDecimal numberToFormat, final int scaleTot, final int scaleToShowAlways, @NonNull final NumberPattern numberFormatPattern) {
		validate_toString(scaleTot, scaleToShowAlways, numberFormatPattern);
		
		String pattern = getPattern(scaleTot, scaleToShowAlways, DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT);
		return format(numberToFormat, pattern, SymbolsAsChar.DOT);
	}
	
	/**
	 * Method for {@link NumberPattern#DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT}
	 * 
	 * scale = the total number of decimal places
	 * scaleShowAlways = the number of decimal places that must be showed in any case.
	 */
	public static String toString(@NonNull final BigDecimal numberToFormat, final int scaleTot, final int scaleToShowAlways, final char decimalSeparator, @NonNull final NumberPattern numberFormatPattern) {
		validate_toString(scaleTot, scaleToShowAlways, numberFormatPattern);
		
		String pattern = getPattern(scaleTot, scaleToShowAlways, DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT);
		return format(numberToFormat, pattern, decimalSeparator);
	}
	
	/**
	 * Method for {@link NumberPattern#DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT}
	 * 
	 * scale = the total number of decimal places
	 * scaleShowAlways = the number of decimal places that must be showed in any case.
	 */
	public static String toString(@NonNull final BigDecimal numberToFormat, final int scaleTot, final int scaleToShowAlways, final char decimalSeparator, final char groupingSeparator, @NonNull final NumberPattern numberFormatPattern) {
		validate_toString(scaleTot, scaleToShowAlways, numberFormatPattern);
		validateSeparators(decimalSeparator, groupingSeparator);
		
		String pattern = getPattern(scaleTot, scaleToShowAlways, DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT);
		return format(numberToFormat, pattern, decimalSeparator, groupingSeparator);
	}
	
	// Format
	
	private static String format(final BigDecimal numberToFormat, final String pattern, final char decimalSeparator) {
		DecimalFormatSymbols symbols = getDecimalFormatSymbols(decimalSeparator);
		DecimalFormat decimalFormat = getDecimalFormat(pattern, symbols);
		decimalFormat.setGroupingUsed(false);
		return decimalFormat.format(numberToFormat);
	}
	
	private static String format(final BigDecimal numberToFormat, final String pattern, final char decimalSeparator, final char groupingSeparator) {
		DecimalFormatSymbols symbols = getDecimalFormatSymbols(decimalSeparator, groupingSeparator);
		DecimalFormat decimalFormat = getDecimalFormat(pattern, symbols);
		return decimalFormat.format(numberToFormat);
	}
	
	// DecimalFormat
	
	private static DecimalFormat getDecimalFormat(final String pattern, final DecimalFormatSymbols decimalFormatSymbols) {
		DecimalFormat df = new DecimalFormat(pattern, decimalFormatSymbols);
		df.setRoundingMode(RoundingMode.DOWN);
		return df;
	}
	
	// DecimalFormatSymbols
	
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
	
	private static String getPattern(final int scale, final NumberPattern numberFormatPattern) {
		validateNumberFormatPatternWhenOnlyScaleAvailable(numberFormatPattern);
		
		if(DECIMALS_ALWAYS == numberFormatPattern) {
			return buildPatternDecimalsAlways(scale);
		} else if (DECIMALS_IF_PRESENT == numberFormatPattern) {
			return buildPatternDecimalsIfPresent(scale);
		}
		
		throw new IllegalArgumentException(numberFormatPattern.toString() + " is not valid!");
	}
	
	private static String getPattern(final int scale, final int scaleToShowAlways, final NumberPattern numberFormatPattern) {
		if(DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT == numberFormatPattern) {
			return buildPatternDecimalsFirstPartAlwaysSecondPartIfPresent(scale, scaleToShowAlways);
		}
		
		throw new IllegalArgumentException(numberFormatPattern.toString() + " is not valid!");
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
		return INTEGER_PATTERN_DOT + "0".repeat(scale);
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
		return INTEGER_PATTERN_DOT + "#".repeat(scale);
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
		String pattern = INTEGER_PATTERN_DOT;
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
	
	// Validators
	private static void validateScale(final int scale) {
		if(scale < 0) throw new IllegalArgumentException("scale can't be less than 0.");
	}
	
	private static void validateSeparators(final char decimalSeparator, final char groupingSeparator) {
		if (decimalSeparator == groupingSeparator) throw new IllegalArgumentException("decimalSeparator and groupingSeparator can't be equals.");
	}
	
	private static void validateNumberFormatPatternWhenOnlyScaleAvailable(final NumberPattern numberFormatPattern) {
		if(numberFormatPattern == DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT) throw new IllegalArgumentException("DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT can't be used with only scale value. An additional parameter (int scaleToShowAlways) is needed.");
	}
	
	/**
	 * Validate methods for DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT
	 */
	private static void validate_toString(final int scaleTot, final int scaleToShowAlways, final NumberPattern numberFormatPattern) {
		if(DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT != numberFormatPattern) throw new IllegalArgumentException("Invalid NumberFormatPattern. This method can only be used for: " + DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT);
		validateScale(scaleTot);
		validateScale(scaleToShowAlways);
		if(scaleTot < scaleToShowAlways) throw new IllegalArgumentException("scaleToShowAlways can't be greater than scaleTot.");
	}
	
}
