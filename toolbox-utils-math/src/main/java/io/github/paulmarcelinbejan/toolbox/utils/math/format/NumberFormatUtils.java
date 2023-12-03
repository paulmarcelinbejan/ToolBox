package io.github.paulmarcelinbejan.toolbox.utils.math.format;

import static io.github.paulmarcelinbejan.toolbox.constants.Symbols.DOT;
import static io.github.paulmarcelinbejan.toolbox.constants.Symbols.EMPTY;
import static io.github.paulmarcelinbejan.toolbox.utils.math.format.pattern.NumberPattern.DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import io.github.paulmarcelinbejan.toolbox.constants.SymbolsAsChar;
import io.github.paulmarcelinbejan.toolbox.utils.math.MathUtils;
import io.github.paulmarcelinbejan.toolbox.utils.math.format.pattern.NumberPattern;
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
	 * Converts the specified string to a {@code BigDecimal}.
	 *
	 * @param numberToFormat The string to be converted.
	 * @return The {@code BigDecimal} representation of the string.
	 * @throws NumberFormatException If {@code numberToFormat} is not a valid representation of a {@code BigDecimal}.
	 */
	public static BigDecimal toBigDecimal(String numberToFormat) {
	    return MathUtils.toBigDecimal(numberToFormat);
	}

	/**
	 * Converts the specified string to a {@code BigDecimal}, considering the provided decimal separator.
	 *
	 * @param numberToFormat The string to be converted.
	 * @param decimalSeparator The character representing the decimal separator.
	 * @return The {@code BigDecimal} representation of the string.
	 * @throws NumberFormatException If {@code numberToFormat} is not a valid representation of a {@code BigDecimal}.
	 */
	public static BigDecimal toBigDecimal(String numberToFormat, char decimalSeparator) {
	    numberToFormat = replaceDecimalSeparator(numberToFormat, decimalSeparator);
	    return MathUtils.toBigDecimal(numberToFormat);
	}

	/**
	 * Converts the specified string to a {@code BigDecimal}, considering the provided decimal and grouping separators.
	 *
	 * @param numberToFormat The string to be converted.
	 * @param decimalSeparator The character representing the decimal separator.
	 * @param groupingSeparator The character representing the grouping separator.
	 * @return The {@code BigDecimal} representation of the string.
	 * @throws NumberFormatException If {@code numberToFormat} is not a valid representation of a {@code BigDecimal}.
	 */
	public static BigDecimal toBigDecimal(String numberToFormat, char decimalSeparator, char groupingSeparator) {
	    validateSeparators(decimalSeparator, groupingSeparator);

	    numberToFormat = replaceGroupingSeparator(numberToFormat, groupingSeparator);
	    numberToFormat = replaceDecimalSeparator(numberToFormat, decimalSeparator);

	    return MathUtils.toBigDecimal(numberToFormat);
	}
	
	// FROM BigDecimal TO String
	
	/**
	 * Converts the specified {@code BigDecimal} to its string representation using the default formatting.
	 *
	 * @param numberToFormat The {@code BigDecimal} to be converted to a string.
	 * @return The string representation of the {@code BigDecimal}.
	 */
	public static String toString(BigDecimal numberToFormat) {
	    return numberToFormat.toString();
	}

	/**
	 * Converts the specified {@code BigDecimal} to its string representation with the specified decimal places
	 * and number format pattern.
	 *
	 * @param numberToFormat      The {@code BigDecimal} to be converted to a string.
	 * @param decimalPlaces       The number of decimal places to include in the string.
	 * @param numberFormatPattern The pattern to be applied for formatting.
	 * @return The formatted string representation of the {@code BigDecimal}.
	 * @throws IllegalArgumentException If the provided decimal places is negative.
	 */
	public static String toString(BigDecimal numberToFormat, int decimalPlaces, NumberPattern numberFormatPattern) {
	    validateDecimalPlaces(decimalPlaces);
	    
	    return toString(numberToFormat, decimalPlaces, SymbolsAsChar.DOT, numberFormatPattern);
	}

	/**
	 * Converts the specified {@code BigDecimal} to its string representation with the specified decimal places,
	 * decimal separator, and number format pattern.
	 *
	 * @param numberToFormat      The {@code BigDecimal} to be converted to a string.
	 * @param decimalPlaces       The number of decimal places to include in the string.
	 * @param decimalSeparator    The character representing the decimal separator.
	 * @param numberFormatPattern The pattern to be applied for formatting.
	 * @return The formatted string representation of the {@code BigDecimal}.
	 * @throws IllegalArgumentException If the provided decimal places is negative.
	 */
	public static String toString(BigDecimal numberToFormat, int decimalPlaces, char decimalSeparator, NumberPattern numberFormatPattern) {
	    validateDecimalPlaces(decimalPlaces);
	    
	    String pattern = getPattern(decimalPlaces, -0, numberFormatPattern);
	    return format(numberToFormat, pattern, decimalSeparator);
	}

	/**
	 * Converts the specified {@code BigDecimal} to its string representation with the specified decimal places,
	 * decimal separator, grouping separator, and number format pattern.
	 *
	 * @param numberToFormat      The {@code BigDecimal} to be converted to a string.
	 * @param decimalPlaces       The number of decimal places to include in the string.
	 * @param decimalSeparator    The character representing the decimal separator.
	 * @param groupingSeparator   The character representing the grouping separator.
	 * @param numberFormatPattern The pattern to be applied for formatting.
	 * @return The formatted string representation of the {@code BigDecimal}.
	 * @throws IllegalArgumentException If the provided decimal places is negative.
	 */
	public static String toString(BigDecimal numberToFormat, int decimalPlaces, char decimalSeparator, char groupingSeparator, NumberPattern numberFormatPattern) {
	    validateDecimalPlaces(decimalPlaces);
	    validateSeparators(decimalSeparator, groupingSeparator);
	    
	    String pattern = getPattern(decimalPlaces, -0, numberFormatPattern);
	    return format(numberToFormat, pattern, decimalSeparator, groupingSeparator);
	}
	
	/**
	 * Converts the specified {@code BigDecimal} to its string representation with a custom pattern
	 * for the {@link NumberPattern#DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT} format.
	 *
	 * @param numberToFormat           The {@code BigDecimal} to be converted to a string.
	 * @param decimalPlacesTot         The total number of decimal places.
	 * @param decimalPlacesToShowAlways The number of decimal places that must always be shown.
	 * @param numberFormatPattern      The custom number format pattern to be applied.
	 * @return The formatted string representation of the {@code BigDecimal}.
	 * @throws IllegalArgumentException If the parameters violate the constraints for the specified format.
	 */
	public static String toString(BigDecimal numberToFormat, int decimalPlacesTot, int decimalPlacesToShowAlways, NumberPattern numberFormatPattern) {
	    validate_toString_for_DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT(decimalPlacesTot, decimalPlacesToShowAlways, numberFormatPattern);

	    String pattern = getPattern(decimalPlacesTot, decimalPlacesToShowAlways, DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT);
	    return format(numberToFormat, pattern, SymbolsAsChar.DOT);
	}

	/**
	 * Converts the specified {@code BigDecimal} to its string representation with a custom pattern
	 * for the {@link NumberPattern#DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT} format.
	 *
	 * @param numberToFormat           The {@code BigDecimal} to be converted to a string.
	 * @param decimalPlacesTot         The total number of decimal places.
	 * @param decimalPlacesToShowAlways The number of decimal places that must always be shown.
	 * @param decimalSeparator         The character representing the decimal separator.
	 * @param numberFormatPattern      The custom number format pattern to be applied.
	 * @return The formatted string representation of the {@code BigDecimal}.
	 * @throws IllegalArgumentException If the parameters violate the constraints for the specified format.
	 */
	public static String toString(BigDecimal numberToFormat, int decimalPlacesTot, int decimalPlacesToShowAlways, char decimalSeparator, NumberPattern numberFormatPattern) {
	    validate_toString_for_DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT(decimalPlacesTot, decimalPlacesToShowAlways, numberFormatPattern);

	    String pattern = getPattern(decimalPlacesTot, decimalPlacesToShowAlways, DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT);
	    return format(numberToFormat, pattern, decimalSeparator);
	}

	/**
	 * Converts the specified {@code BigDecimal} to its string representation with a custom pattern
	 * for the {@link NumberPattern#DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT} format.
	 *
	 * @param numberToFormat           The {@code BigDecimal} to be converted to a string.
	 * @param decimalPlacesTot         The total number of decimal places.
	 * @param decimalPlacesToShowAlways The number of decimal places that must always be shown.
	 * @param decimalSeparator         The character representing the decimal separator.
	 * @param groupingSeparator        The character representing the grouping separator.
	 * @param numberFormatPattern      The custom number format pattern to be applied.
	 * @return The formatted string representation of the {@code BigDecimal}.
	 * @throws IllegalArgumentException If the parameters violate the constraints for the specified format.
	 */
	public static String toString(BigDecimal numberToFormat, int decimalPlacesTot, int decimalPlacesToShowAlways, char decimalSeparator, char groupingSeparator, NumberPattern numberFormatPattern) {
	    validate_toString_for_DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT(decimalPlacesTot, decimalPlacesToShowAlways, numberFormatPattern);
	    validateSeparators(decimalSeparator, groupingSeparator);

	    String pattern = getPattern(decimalPlacesTot, decimalPlacesToShowAlways, DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT);
	    return format(numberToFormat, pattern, decimalSeparator, groupingSeparator);
	}
	
	// Format
	
	/**
	 * Formats the specified {@code BigDecimal} using the provided pattern and decimal separator.
	 *
	 * @param numberToFormat   The {@code BigDecimal} to be formatted.
	 * @param pattern          The pattern to be applied during formatting.
	 * @param decimalSeparator The character representing the decimal separator.
	 * @return The formatted string representation of the {@code BigDecimal}.
	 */
	private static String format(BigDecimal numberToFormat, String pattern, char decimalSeparator) {
	    DecimalFormatSymbols symbols = getDecimalFormatSymbols(decimalSeparator);
	    DecimalFormat decimalFormat = getDecimalFormat(pattern, symbols);
	    decimalFormat.setGroupingUsed(false);
	    return decimalFormat.format(numberToFormat);
	}

	/**
	 * Formats the specified {@code BigDecimal} using the provided pattern, decimal separator,
	 * and grouping separator.
	 *
	 * @param numberToFormat   The {@code BigDecimal} to be formatted.
	 * @param pattern          The pattern to be applied during formatting.
	 * @param decimalSeparator The character representing the decimal separator.
	 * @param groupingSeparator The character representing the grouping separator.
	 * @return The formatted string representation of the {@code BigDecimal}.
	 */
	private static String format(BigDecimal numberToFormat, String pattern, char decimalSeparator, char groupingSeparator) {
	    DecimalFormatSymbols symbols = getDecimalFormatSymbols(decimalSeparator, groupingSeparator);
	    DecimalFormat decimalFormat = getDecimalFormat(pattern, symbols);
	    return decimalFormat.format(numberToFormat);
	}
	
	// DecimalFormat
	
	/**
	 * Creates and configures a {@link DecimalFormat} instance with the specified pattern
	 * and {@link DecimalFormatSymbols}.
	 *
	 * @param pattern               The pattern for formatting the decimal number.
	 * @param decimalFormatSymbols The symbols used for formatting decimal numbers.
	 * @return A configured {@link DecimalFormat} instance.
	 * @throws NullPointerException If either {@code pattern} or {@code decimalFormatSymbols}
	 *                              is {@code null}.
	 *
	 * @see DecimalFormat
	 * @see DecimalFormatSymbols
	 * @see RoundingMode#DOWN
	 */
	private static DecimalFormat getDecimalFormat(String pattern, DecimalFormatSymbols decimalFormatSymbols) {
		DecimalFormat df = new DecimalFormat(pattern, decimalFormatSymbols);
		df.setRoundingMode(RoundingMode.DOWN);
		return df;
	}
	
	// DecimalFormatSymbols
	
	/**
	 * Creates and configures a {@link DecimalFormatSymbols} instance with the specified
	 * decimal separator.
	 *
	 * @param decimalSeparator The character used as the decimal separator.
	 * @return A configured {@link DecimalFormatSymbols} instance.
	 *
	 * @see DecimalFormatSymbols
	 */
	private static DecimalFormatSymbols getDecimalFormatSymbols(char decimalSeparator) {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator(decimalSeparator);
		return symbols;
	}
	
	/**
	 * Creates and configures a {@link DecimalFormatSymbols} instance with the specified
	 * decimal separator and grouping separator.
	 *
	 * @param decimalSeparator  The character used as the decimal separator.
	 * @param groupingSeparator The character used as the grouping separator.
	 * @return A configured {@link DecimalFormatSymbols} instance.
	 *
	 * @see DecimalFormatSymbols
	 */
	private static DecimalFormatSymbols getDecimalFormatSymbols(char decimalSeparator, char groupingSeparator) {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator(decimalSeparator);
		symbols.setGroupingSeparator(groupingSeparator);
		return symbols;
	}
	
	// Pattern 
	
	/**
	 * Generates a formatting pattern based on the specified number of total decimal places,
	 * the number of decimal places to show always, and the chosen {@link NumberPattern}.
	 *
	 * @param decimalPlacesTot          The total number of decimal places.
	 * @param decimalPlacesToShowAlways The number of decimal places to show always.
	 * @param numberFormatPattern       The chosen {@link NumberPattern}.
	 * @return A formatting pattern for the specified criteria.
	 *
	 * @throws IllegalArgumentException If an unsupported or undefined {@link NumberPattern} is provided.
	 *
	 * @see NumberPattern
	 */
	private static String getPattern(int decimalPlacesTot, int decimalPlacesToShowAlways, NumberPattern numberFormatPattern) {
		return switch (numberFormatPattern) {
        	case DECIMALS_ALWAYS -> buildPatternDecimalsAlways(decimalPlacesTot);
        	case DECIMALS_IF_PRESENT -> buildPatternDecimalsIfPresent(decimalPlacesTot);
        	case DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT -> buildPatternDecimalsFirstPartAlwaysSecondPartIfPresent(decimalPlacesTot, decimalPlacesToShowAlways);
		};
	}
	
	/**
	 * Builds a formatting pattern for {@link NumberPattern#DECIMALS_ALWAYS}.
	 * Show decimals always, even if they are equal to 0.
	 *
	 * @param decimalPlaces The total number of decimal places.
	 * @return A formatting pattern for {@link NumberPattern#DECIMALS_ALWAYS}.
	 */
	private static String buildPatternDecimalsAlways(int decimalPlaces) {
	    return buildPattern(decimalPlaces, SHOW_DECIMALS_ALWAYS);
	}

	/**
	 * Builds a formatting pattern for {@link NumberPattern#DECIMALS_IF_PRESENT}.
	 * Show decimals until the last valorized decimal.
	 *
	 * @param decimalPlaces The total number of decimal places.
	 * @return A formatting pattern for {@link NumberPattern#DECIMALS_IF_PRESENT}.
	 */
	private static String buildPatternDecimalsIfPresent(int decimalPlaces) {
	    return buildPattern(decimalPlaces, SHOW_DECIMALS_IF_PRESENT);
	}

	/**
	 * Builds a general formatting pattern based on the specified character pattern to be repeated.
	 *
	 * @param decimalPlaces            The total number of decimal places.
	 * @param charPatternToBeRepeated The character pattern to be repeated.
	 * @return The generated formatting pattern.
	 */
	private static String buildPattern(int decimalPlaces, String charPatternToBeRepeated) {
	    if (decimalPlaces == 0) {
	        return INTEGER_PATTERN;
	    }
	    return INTEGER_PATTERN_DOT + repeatString(charPatternToBeRepeated, decimalPlaces);
	}

	/**
	 * Repeats a given string a specified number of times.
	 *
	 * @param stringToBeRepeated The string to be repeated.
	 * @param nTimes             The number of times to repeat the string.
	 * @return The repeated string.
	 */
	private static String repeatString(String stringToBeRepeated, int nTimes) {
	    return stringToBeRepeated.repeat(nTimes);
	}

	/**
	 * Builds a formatting pattern for {@link NumberPattern#DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT}.
	 * Shows the first part of decimals in any case, then shows decimals until the last valorized decimal.
	 *
	 * @param decimalPlacesTot         The total number of decimal places.
	 * @param decimalPlacesToShowAlways The number of decimal places to show always.
	 * @return A formatting pattern for {@link NumberPattern#DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT}.
	 */
	private static String buildPatternDecimalsFirstPartAlwaysSecondPartIfPresent(int decimalPlacesTot, int decimalPlacesToShowAlways) {
	    if (decimalPlacesTot == 0) {
	        return INTEGER_PATTERN;
	    }

	    String pattern = new StringBuilder()
	            .append(INTEGER_PATTERN_DOT)
	            .append(repeatString(SHOW_DECIMALS_ALWAYS, decimalPlacesToShowAlways))
	            .append(repeatString(SHOW_DECIMALS_IF_PRESENT, decimalPlacesTot - decimalPlacesToShowAlways))
	            .toString();
	    
	    return pattern;
	}

	/**
	 * Replaces the decimal separator in the given string.
	 *
	 * @param toFormat        The string to be formatted.
	 * @param decimalSeparator The decimal separator to replace.
	 * @return The string with the replaced decimal separator.
	 */
	private static String replaceDecimalSeparator(String toFormat, char decimalSeparator) {
	    return toFormat.replace(String.valueOf(decimalSeparator), DOT);
	}

	/**
	 * Replaces the grouping separator in the given string.
	 *
	 * @param toFormat          The string to be formatted.
	 * @param groupingSeparator The grouping separator to replace.
	 * @return The string with the replaced grouping separator.
	 */
	private static String replaceGroupingSeparator(String toFormat, char groupingSeparator) {
	    return toFormat.replace(String.valueOf(groupingSeparator), EMPTY);
	}
	
	// Validators
	
	/**
	 * Validates the number of decimal places.
	 *
	 * @param decimalPlaces The number of decimal places to validate.
	 * @throws IllegalArgumentException If the specified decimal places are less than 0.
	 */
	private static void validateDecimalPlaces(int decimalPlaces) {
	    if (decimalPlaces < 0) throw new IllegalArgumentException("Decimal places cannot be less than 0.");
	}

	/**
	 * Validates decimal and grouping separators.
	 *
	 * @param decimalSeparator  The decimal separator character.
	 * @param groupingSeparator The grouping separator character.
	 * @throws IllegalArgumentException If the decimal separator and grouping separator are the same.
	 */
	private static void validateSeparators(char decimalSeparator, char groupingSeparator) {
	    if (decimalSeparator == groupingSeparator) throw new IllegalArgumentException("Decimal separator and grouping separator cannot be equal.");
	}

	
	/**
	 * Validates parameters for the {@link NumberPattern#DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT} formatting pattern.
	 *
	 * @param decimalPlacesTot        The total number of decimal places.
	 * @param decimalPlacesToShowAlways The number of decimal places that must always be shown.
	 * @param numberFormatPattern      The number format pattern to validate.
	 * @throws IllegalArgumentException If the provided number format pattern is not {@link NumberPattern#DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT},
	 *                                  or if the decimal places to show always is greater than the total decimal places.
	 */
	private static void validate_toString_for_DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT(int decimalPlacesTot, int decimalPlacesToShowAlways, NumberPattern numberFormatPattern) {
		if(DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT != numberFormatPattern) throw new IllegalArgumentException("Invalid NumberFormatPattern. This method can only be used for: " + DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT);
		validateDecimalPlaces(decimalPlacesTot);
		validateDecimalPlaces(decimalPlacesToShowAlways);
		if(decimalPlacesTot < decimalPlacesToShowAlways) throw new IllegalArgumentException("decimalPlacesToShowAlways can't be greater than decimalPlacesTot.");
	}
	
	// Constants
	
	/**
	 * The pattern for formatting integers with grouping separators.
	 * Example: "###,##0"
	 */
	private static final String INTEGER_PATTERN = "###,##0";

	/**
	 * The pattern for formatting integers with a decimal separator.
	 * Example: "###,##0."
	 */
	private static final String INTEGER_PATTERN_DOT = INTEGER_PATTERN + ".";

	/**
	 * The placeholder to show decimals always, even if the value is zero.
	 * Example: "0"
	 */
	private static final String SHOW_DECIMALS_ALWAYS = "0";

	/**
	 * The placeholder to show decimals only if present.
	 * Example: "#"
	 */
	private static final String SHOW_DECIMALS_IF_PRESENT = "#";
	
}
