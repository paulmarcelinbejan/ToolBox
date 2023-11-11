package com.paulmarcelinbejan.toolbox.utils.math.format;

import static com.paulmarcelinbejan.toolbox.constants.Symbols.DOT;
import static com.paulmarcelinbejan.toolbox.constants.Symbols.EMPTY;
import static com.paulmarcelinbejan.toolbox.utils.math.format.pattern.NumberPattern.DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import com.paulmarcelinbejan.toolbox.constants.SymbolsAsChar;
import com.paulmarcelinbejan.toolbox.utils.math.MathUtils;
import com.paulmarcelinbejan.toolbox.utils.math.format.pattern.NumberPattern;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

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
	
	// FROM String TO BigDecimal
	
	/**
	 * @throws NumberFormatException if {@code numberToFormat} is not a valid
     *         representation of a {@code BigDecimal}.
	 */
	public static BigDecimal toBigDecimal(String numberToFormat) {
		return MathUtils.toBigDecimal(numberToFormat);
	}
	
	/**
	 * @throws NumberFormatException if {@code numberToFormat} is not a valid
     *         representation of a {@code BigDecimal}.
	 */
	public static BigDecimal toBigDecimal(String numberToFormat, char decimalSeparator) {
		numberToFormat = replaceDecimalSeparator(numberToFormat, decimalSeparator);
		return MathUtils.toBigDecimal(numberToFormat);
	}
	
	/**
	 * @throws NumberFormatException if {@code numberToFormat} is not a valid
     *         representation of a {@code BigDecimal}.
	 */
	public static BigDecimal toBigDecimal(String numberToFormat, char decimalSeparator, char groupingSeparator) {
		validateSeparators(decimalSeparator, groupingSeparator);
		
		numberToFormat = replaceGroupingSeparator(numberToFormat, groupingSeparator);
		numberToFormat = replaceDecimalSeparator(numberToFormat, decimalSeparator);
		
		return MathUtils.toBigDecimal(numberToFormat);
	}
	
	// FROM BigDecimal TO String
	
	public static String toString(BigDecimal numberToFormat) {
		return numberToFormat.toString();
	}
	
	public static String toString(BigDecimal numberToFormat, int decimalPlaces, NumberPattern numberFormatPattern) {
		validateDecimalPlaces(decimalPlaces);
		
		return toString(numberToFormat, decimalPlaces, SymbolsAsChar.DOT, numberFormatPattern);
	}
	
	public static String toString(BigDecimal numberToFormat, int decimalPlaces, char decimalSeparator, NumberPattern numberFormatPattern) {
		validateDecimalPlaces(decimalPlaces);
		
		String pattern = getPattern(decimalPlaces, -0, numberFormatPattern);
		return format(numberToFormat, pattern, decimalSeparator);
	}
	
	public static String toString(BigDecimal numberToFormat, int decimalPlaces, char decimalSeparator, char groupingSeparator, NumberPattern numberFormatPattern) {
		validateDecimalPlaces(decimalPlaces);
		validateSeparators(decimalSeparator, groupingSeparator);
		
		String pattern = getPattern(decimalPlaces, -0, numberFormatPattern);
		return format(numberToFormat, pattern, decimalSeparator, groupingSeparator);
	}
	
	/**
	 * Method for {@link NumberPattern#DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT}
	 * 
	 * decimalPlacesTot = the total number of decimal places
	 * decimalPlacesToShowAlways = the number of decimal places that must be showed in any case.
	 */
	public static String toString(BigDecimal numberToFormat, int decimalPlacesTot, int decimalPlacesToShowAlways, NumberPattern numberFormatPattern) {
		validate_toString_for_DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT(decimalPlacesTot, decimalPlacesToShowAlways, numberFormatPattern);
		
		String pattern = getPattern(decimalPlacesTot, decimalPlacesToShowAlways, DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT);
		return format(numberToFormat, pattern, SymbolsAsChar.DOT);
	}
	
	/**
	 * Method for {@link NumberPattern#DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT}
	 * 
	 * decimalPlacesTot = the total number of decimal places
	 * decimalPlacesToShowAlways = the number of decimal places that must be showed in any case.
	 */
	public static String toString(BigDecimal numberToFormat, int decimalPlacesTot, int decimalPlacesToShowAlways, char decimalSeparator, NumberPattern numberFormatPattern) {
		validate_toString_for_DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT(decimalPlacesTot, decimalPlacesToShowAlways, numberFormatPattern);
		
		String pattern = getPattern(decimalPlacesTot, decimalPlacesToShowAlways, DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT);
		return format(numberToFormat, pattern, decimalSeparator);
	}
	
	/**
	 * Method for {@link NumberPattern#DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT}
	 * 
	 * decimalPlacesTot = the total number of decimal places
	 * decimalPlacesToShowAlways = the number of decimal places that must be showed in any case.
	 */
	public static String toString(BigDecimal numberToFormat, int decimalPlacesTot, int decimalPlacesToShowAlways, char decimalSeparator, char groupingSeparator, NumberPattern numberFormatPattern) {
		validate_toString_for_DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT(decimalPlacesTot, decimalPlacesToShowAlways, numberFormatPattern);
		validateSeparators(decimalSeparator, groupingSeparator);
		
		String pattern = getPattern(decimalPlacesTot, decimalPlacesToShowAlways, DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT);
		return format(numberToFormat, pattern, decimalSeparator, groupingSeparator);
	}
	
	// Format
	
	private static String format(BigDecimal numberToFormat, String pattern, char decimalSeparator) {
		DecimalFormatSymbols symbols = getDecimalFormatSymbols(decimalSeparator);
		DecimalFormat decimalFormat = getDecimalFormat(pattern, symbols);
		decimalFormat.setGroupingUsed(false);
		return decimalFormat.format(numberToFormat);
	}
	
	private static String format(BigDecimal numberToFormat, String pattern, char decimalSeparator, char groupingSeparator) {
		DecimalFormatSymbols symbols = getDecimalFormatSymbols(decimalSeparator, groupingSeparator);
		DecimalFormat decimalFormat = getDecimalFormat(pattern, symbols);
		return decimalFormat.format(numberToFormat);
	}
	
	// DecimalFormat
	
	private static DecimalFormat getDecimalFormat(String pattern, DecimalFormatSymbols decimalFormatSymbols) {
		DecimalFormat df = new DecimalFormat(pattern, decimalFormatSymbols);
		df.setRoundingMode(RoundingMode.FLOOR);
		return df;
	}
	
	// DecimalFormatSymbols
	
	private static DecimalFormatSymbols getDecimalFormatSymbols(char decimalSeparator) {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator(decimalSeparator);
		return symbols;
	}
	
	private static DecimalFormatSymbols getDecimalFormatSymbols(char decimalSeparator, char groupingSeparator) {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator(decimalSeparator);
		symbols.setGroupingSeparator(groupingSeparator);
		return symbols;
	}
	
	// Pattern 
		
	private static String getPattern(int decimalPlacesTot, int decimalPlacesToShowAlways, NumberPattern numberFormatPattern) {
		return switch (numberFormatPattern) {
        	case DECIMALS_ALWAYS -> buildPatternDecimalsAlways(decimalPlacesTot);
        	case DECIMALS_IF_PRESENT -> buildPatternDecimalsIfPresent(decimalPlacesTot);
        	case DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT -> buildPatternDecimalsFirstPartAlwaysSecondPartIfPresent(decimalPlacesTot, decimalPlacesToShowAlways);
		};
	}
	
	/**
	 * DECIMALS_ALWAYS
	 * show decimals always, also if it's equal to 0
	 * 
	 * Example:
	 * <br>decimalPlaces 6: 24.102030 -> 24.102030
	 * <br>decimalPlaces 4: 24.102030 -> 24.1020
	 */
	private static String buildPatternDecimalsAlways(int decimalPlaces) {
		return buildPattern(decimalPlaces, SHOW_DECIMALS_ALWAYS);
	}
	
	/**
	 * DECIMALS_IF_PRESENT
	 * show decimals until the last valorized decimal
	 * 
	 * Example:
	 * <br>decimalPlaces 6: 24.102030 -> 24.10203
	 * <br>decimalPlaces 4: 24.102030 -> 24.102
	 */
	private static String buildPatternDecimalsIfPresent(int decimalPlaces) {
		return buildPattern(decimalPlaces, SHOW_DECIMALS_IF_PRESENT);
	}
	
	private static String buildPattern(int decimalPlaces, String charPatternToBeRepeated) {
		if(decimalPlaces == 0) {
			return INTEGER_PATTERN;
		}
		return INTEGER_PATTERN_DOT + repeatString(charPatternToBeRepeated, decimalPlaces);
	}

	private static String repeatString(String stringToBeRepeated, int nTimes) {
		return stringToBeRepeated.repeat(nTimes);
	}
	
	/**
	 * {@link NumberPattern#DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT}
	 * show first part of decimals in any case, then show decimals until the last valorized decimal
	 * 
	 * Example:
	 * <br>decimalPlacesTot 6, decimalPlacesToShowAlways 2: 24.102030 -> 24.10203
	 * <br>decimalPlacesTot 6: decimalPlacesToShowAlways 3: 24.000000 -> 24.000
	 * 
	 * As example: ###,##0.00####
	 */
	private static String buildPatternDecimalsFirstPartAlwaysSecondPartIfPresent(int decimalPlacesTot, int decimalPlacesToShowAlways) {
		if(decimalPlacesTot == 0) {
			return INTEGER_PATTERN;
		}
		
		String pattern = new StringBuilder()
				.append(INTEGER_PATTERN_DOT)
				.append(repeatString(SHOW_DECIMALS_ALWAYS, decimalPlacesToShowAlways))
				.append(repeatString(SHOW_DECIMALS_IF_PRESENT, decimalPlacesTot - decimalPlacesToShowAlways))
				.toString();
		
		return pattern;
	}	
	
	private static String replaceDecimalSeparator(String toFormat, char decimalSeparator) {
		return toFormat.replace(String.valueOf(decimalSeparator), DOT);
	}
	
	private static String replaceGroupingSeparator(String toFormat, char groupingSeparator) {
		return toFormat.replace(String.valueOf(groupingSeparator), EMPTY);
	}
	
	// Validators
	
	private static void validateDecimalPlaces(int decimalPlaces) {
		if(decimalPlaces < 0) throw new IllegalArgumentException("decimalPlaces can't be less than 0.");
	}
	
	private static void validateSeparators(char decimalSeparator, char groupingSeparator) {
		if (decimalSeparator == groupingSeparator) throw new IllegalArgumentException("decimalSeparator and groupingSeparator can't be equals.");
	}
	
	/**
	 * Validate methods for {@link NumberPattern#DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT}
	 */
	private static void validate_toString_for_DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT(int decimalPlacesTot, int decimalPlacesToShowAlways, NumberPattern numberFormatPattern) {
		if(DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT != numberFormatPattern) throw new IllegalArgumentException("Invalid NumberFormatPattern. This method can only be used for: " + DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT);
		validateDecimalPlaces(decimalPlacesTot);
		validateDecimalPlaces(decimalPlacesToShowAlways);
		if(decimalPlacesTot < decimalPlacesToShowAlways) throw new IllegalArgumentException("decimalPlacesToShowAlways can't be greater than decimalPlacesTot.");
	}
	
	// Constants
	private static final String INTEGER_PATTERN = "###,##0";
	private static final String INTEGER_PATTERN_DOT = INTEGER_PATTERN + DOT;
	
	private static final String SHOW_DECIMALS_ALWAYS = "0";
	private static final String SHOW_DECIMALS_IF_PRESENT = "#";
	
}
