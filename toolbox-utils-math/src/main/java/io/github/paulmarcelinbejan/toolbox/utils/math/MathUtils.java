package io.github.paulmarcelinbejan.toolbox.utils.math;

import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Utility class for mathematical operations.
 * This class provides static methods for common mathematical calculations.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MathUtils {

	// Positive
	
    /**
     * Checks if the specified integer value is positive.
     *
     * @param value The integer value to check.
     * @return {@code true} if the value is greater than 0, {@code false} otherwise.
     */
    public static boolean isPositive(int value) {
        return value > 0;
    }

    /**
     * Checks if the specified long value is positive.
     *
     * @param value The long value to check.
     * @return {@code true} if the value is greater than 0, {@code false} otherwise.
     */
    public static boolean isPositive(long value) {
        return value > 0;
    }

    /**
     * Checks if the specified BigDecimal value is positive.
     *
     * @param value The BigDecimal value to check.
     * @return {@code true} if the value is greater than 0, {@code false} otherwise.
     */
    public static boolean isPositive(BigDecimal value) {
        return isGreaterThanZERO(value);
    }

    /**
     * Checks if the specified integer value is non-negative.
     *
     * @param value The integer value to check.
     * @return {@code true} if the value is greater than or equal to 0, {@code false} otherwise.
     */
    public static boolean isPositiveOrZERO(int value) {
        return value >= 0;
    }

    /**
     * Checks if the specified long value is non-negative.
     *
     * @param value The long value to check.
     * @return {@code true} if the value is greater than or equal to 0, {@code false} otherwise.
     */
    public static boolean isPositiveOrZERO(long value) {
        return value >= 0;
    }

    /**
     * Checks if the specified BigDecimal value is non-negative.
     *
     * @param value The BigDecimal value to check.
     * @return {@code true} if the value is greater than or equal to 0, {@code false} otherwise.
     */
    public static boolean isPositiveOrZERO(BigDecimal value) {
        return isGreaterThanOrEqualToZERO(value);
    }

	// Negative
	
    /**
     * Checks if the specified integer value is negative.
     *
     * @param value The integer value to check.
     * @return {@code true} if the value is less than 0, {@code false} otherwise.
     */
    public static boolean isNegative(int value) {
        return value < 0;
    }

    /**
     * Checks if the specified long value is negative.
     *
     * @param value The long value to check.
     * @return {@code true} if the value is less than 0, {@code false} otherwise.
     */
    public static boolean isNegative(long value) {
        return value < 0;
    }

    /**
     * Checks if the specified BigDecimal value is negative.
     *
     * @param value The BigDecimal value to check.
     * @return {@code true} if the value is less than 0, {@code false} otherwise.
     */
    public static boolean isNegative(BigDecimal value) {
        return isLessThanZERO(value);
    }

    /**
     * Checks if the specified integer value is non-positive.
     *
     * @param value The integer value to check.
     * @return {@code true} if the value is less than or equal to 0, {@code false} otherwise.
     */
    public static boolean isNegativeOrZERO(int value) {
        return value <= 0;
    }

    /**
     * Checks if the specified long value is non-positive.
     *
     * @param value The long value to check.
     * @return {@code true} if the value is less than or equal to 0, {@code false} otherwise.
     */
    public static boolean isNegativeOrZERO(long value) {
        return value <= 0;
    }

    /**
     * Checks if the specified BigDecimal value is non-positive.
     *
     * @param value The BigDecimal value to check.
     * @return {@code true} if the value is less than or equal to 0, {@code false} otherwise.
     */
    public static boolean isNegativeOrZERO(BigDecimal value) {
        return isLessThanOrEqualToZERO(value);
    }

	// To Positive
	
    /**
     * Converts the specified integer value to its positive equivalent.
     *
     * @param value The integer value to convert.
     * @return The positive equivalent of the input value. If the input value is already positive or zero,
     *         the same value is returned.
     */
    public static int toPositive(int value) {
        return isNegative(value) ? 0 - value : value;
    }

    /**
     * Converts the specified long value to its positive equivalent.
     *
     * @param value The long value to convert.
     * @return The positive equivalent of the input value. If the input value is already positive or zero,
     *         the same value is returned.
     */
    public static long toPositive(long value) {
        return isNegative(value) ? 0 - value : value;
    }

    /**
     * Converts the specified BigDecimal value to its positive equivalent.
     *
     * @param value The BigDecimal value to convert.
     * @return The positive equivalent of the input value. If the input value is already positive or zero,
     *         the same value is returned.
     */
    public static BigDecimal toPositive(BigDecimal value) {
        return isNegative(value) ? subtraction(ZERO, value) : value;
    }
	
	// To Negative 
	
    /**
     * Converts the specified integer value to its negative equivalent.
     *
     * @param value The integer value to convert.
     * @return The negative equivalent of the input value. If the input value is already negative or zero,
     *         the same value is returned.
     */
    public static int toNegative(int value) {
        return isPositive(value) ? 0 - value : value;
    }

    /**
     * Converts the specified long value to its negative equivalent.
     *
     * @param value The long value to convert.
     * @return The negative equivalent of the input value. If the input value is already negative or zero,
     *         the same value is returned.
     */
    public static long toNegative(long value) {
        return isPositive(value) ? 0 - value : value;
    }

    /**
     * Converts the specified BigDecimal value to its negative equivalent.
     *
     * @param value The BigDecimal value to convert.
     * @return The negative equivalent of the input value. If the input value is already negative or zero,
     *         the same value is returned.
     */
    public static BigDecimal toNegative(BigDecimal value) {
        return isPositive(value) ? subtraction(ZERO, value) : value;
    }

	// To BigDecimal

    /**
     * Converts the specified integer value to a BigDecimal.
     *
     * @param value The integer value to convert.
     * @return A BigDecimal representation of the input integer value.
     */
    public static BigDecimal toBigDecimal(int value) {
        return BigDecimal.valueOf(value);
    }

    /**
     * Converts the specified long value to a BigDecimal.
     *
     * @param value The long value to convert.
     * @return A BigDecimal representation of the input long value.
     */
    public static BigDecimal toBigDecimal(long value) {
        return BigDecimal.valueOf(value);
    }

    /**
     * Converts the specified string to a BigDecimal.
     *
     * @param value The string representation of a number to convert.
     * @return A BigDecimal representation of the input string value.
     * @throws NumberFormatException if the string is not a valid representation of a BigDecimal.
     */
    public static BigDecimal toBigDecimal(String value) {
        return new BigDecimal(value);
    }
	
	// Truncate
	
	/**
	 * <pre>
	 * There are 2 options to truncate a number:
     * - RoundingMode.DOWN
	 * - RoundingMode.FLOOR
	 * 
	 * For positive numbers they works in the same way.
	 * For negative numbers:
	 * RoundingMode.DOWN will go to positive,
	 * RoundingMode.FLOOR will go to negative,
	 *	
	 * As Example:
	 * -1.6 will be truncated to:
	 * RoundingMode.DOWN -> -1
	 * RoundingMode.FLOOR -> -2
     * </pre>
     * 
	 * @param value 			The BigDecimal value to truncate.
	 * @param decimalPlaces		The number of decimal places to round to.
	 * @return 					The truncated BigDecimal value.
	 */
	public static BigDecimal truncateDown(BigDecimal value, int decimalPlaces) {
		return value.setScale(decimalPlaces, RoundingMode.DOWN);
	}
	
	/**
	 * <pre>
	 * There are 2 options to truncate a number:
     * - RoundingMode.DOWN
	 * - RoundingMode.FLOOR
	 * 
	 * For positive numbers they works in the same way.
	 * For negative numbers:
	 * RoundingMode.DOWN will go to positive,
	 * RoundingMode.FLOOR will go to negative,
	 *	
	 * As Example:
	 * -1.6 will be truncated to:
	 * RoundingMode.DOWN -> -1
	 * RoundingMode.FLOOR -> -2
     * </pre>
	 *
	 * @param value 			The BigDecimal value to truncate.
	 * @param decimalPlaces		The number of decimal places to round to.
	 * @return 					The truncated BigDecimal value.
	 */
	public static BigDecimal truncateFloor(BigDecimal value, int decimalPlaces) {
		return value.setScale(decimalPlaces, RoundingMode.FLOOR);
	}

	/**
	 * Truncates the given BigDecimal value down to zero decimal places.
	 *
	 * @param value The BigDecimal value to truncate.
	 * @return The truncated BigDecimal value.
	 * 
	 * @see MathUtils#truncateDown(BigDecimal, int)
	 */
	public static BigDecimal truncateDownToZeroDecimalPlaces(BigDecimal value) {
	    return truncateDown(value, 0);
	}

	/**
	 * Truncates the given BigDecimal value towards negative infinity to zero decimal places.
	 *
	 * @param value The BigDecimal value to truncate.
	 * @return The truncated BigDecimal value.
	 * 
	 * @see MathUtils#truncateFloor(BigDecimal, int)
	 */
	public static BigDecimal truncateFloorToZeroDecimalPlaces(BigDecimal value) {
	    return truncateFloor(value, 0);
	}

	// Round
	
	/**
	 * Rounds the specified BigDecimal value to the given number of decimal places using the specified rounding mode.
	 *
	 * @param value           The BigDecimal value to round.
	 * @param decimalPlaces   The number of decimal places to round to.
	 * @param roundingMode    The rounding mode to use.
	 * @return                A new BigDecimal representing the rounded value.
	 */
	public static BigDecimal round(BigDecimal value, int decimalPlaces, RoundingMode roundingMode) {
		return value.setScale(decimalPlaces, roundingMode);
	}

	/**
	 * Rounds the given BigDecimal value to the nearest whole number.
	 * This method is an adaptation of {@link Math#round(double)} for BigDecimal.
	 *
	 * @param value The BigDecimal value to be rounded.
	 * @return The rounded long value.
	 *
	 * @see MathUtils#round(BigDecimal, int, RoundingMode)
	 */
	public static long mathRound(BigDecimal value) {
	    return mathRound(value, 0).longValue();
	}

	/**
	 * Rounds the given BigDecimal value to the specified number of decimal places using the HALF_UP
	 * rounding mode if the value is positive, and the HALF_DOWN rounding mode if the value is negative.
	 * This method is an adaptation of {@link Math#round(double)} for BigDecimal.
	 *
	 * @param value The BigDecimal value to be rounded.
	 * @param decimalPlaces The number of decimal places to round to.
	 * @return The rounded BigDecimal value.
	 *
	 * @see MathUtils#round(BigDecimal, int, RoundingMode)
	 * @see BigDecimal#setScale(int, RoundingMode)
	 */
	public static BigDecimal mathRound(BigDecimal value, int decimalPlaces) {
	    if (isPositive(value)) {
	        return round(value, decimalPlaces, RoundingMode.HALF_UP);
	    }
		return round(value, decimalPlaces, RoundingMode.HALF_DOWN);
	}

	// Addition

	/**
	 * Adds two BigDecimal values.
	 *
	 * @param value1 The first BigDecimal value.
	 * @param value2 The second BigDecimal value.
	 * @return The result of adding the two BigDecimal values.
	 */
	public static BigDecimal addition(BigDecimal value1, BigDecimal value2) {
	    return value1.add(value2);
	}

	/**
	 * Adds a BigDecimal value and an integer value.
	 *
	 * @param value1 The BigDecimal value.
	 * @param value2 The integer value.
	 * @return The result of adding the BigDecimal and integer values.
	 */
	public static BigDecimal addition(BigDecimal value1, int value2) {
	    return addition(value1, toBigDecimal(value2));
	}

	/**
	 * Adds an integer value and a BigDecimal value.
	 *
	 * @param value1 The integer value.
	 * @param value2 The BigDecimal value.
	 * @return The result of adding the integer and BigDecimal values.
	 */
	public static BigDecimal addition(int value1, BigDecimal value2) {
	    return addition(toBigDecimal(value1), value2);
	}

	/**
	 * Adds a BigDecimal value and a long value.
	 *
	 * @param value1 The BigDecimal value.
	 * @param value2 The long value.
	 * @return The result of adding the BigDecimal and long values.
	 */
	public static BigDecimal addition(BigDecimal value1, long value2) {
	    return addition(value1, toBigDecimal(value2));
	}

	/**
	 * Adds a long value and a BigDecimal value.
	 *
	 * @param value1 The long value.
	 * @param value2 The BigDecimal value.
	 * @return The result of adding the long and BigDecimal values.
	 */
	public static BigDecimal addition(long value1, BigDecimal value2) {
	    return addition(toBigDecimal(value1), value2);
	}

	/**
	 * Adds multiple BigDecimal values.
	 *
	 * @param value1  The first BigDecimal value.
	 * @param values  Additional BigDecimal values to be added.
	 * @return        The result of adding all the BigDecimal values.
	 */
	public static BigDecimal addition(BigDecimal value1, BigDecimal... values) {
	    BigDecimal result = value1;
	    for (BigDecimal value : values) {
	        result = addition(result, value);
	    }
	    return result;
	}

	// Subtraction

	/**
	 * Subtracts the second BigDecimal value from the first BigDecimal value.
	 *
	 * @param value1 The minuend (the value to be subtracted from).
	 * @param value2 The subtrahend (the value to subtract).
	 * @return The result of subtracting value2 from value1.
	 */
	public static BigDecimal subtraction(BigDecimal value1, BigDecimal value2) {
	    return value1.subtract(value2);
	}

	/**
	 * Subtracts an integer value from a BigDecimal value.
	 *
	 * @param value1 The minuend (the BigDecimal value).
	 * @param value2 The subtrahend (the integer value to subtract).
	 * @return The result of subtracting the integer value2 from the BigDecimal value1.
	 */
	public static BigDecimal subtraction(BigDecimal value1, int value2) {
	    return subtraction(value1, toBigDecimal(value2));
	}

	/**
	 * Subtracts a BigDecimal value from an integer value.
	 *
	 * @param value1 The minuend (the integer value).
	 * @param value2 The subtrahend (the BigDecimal value to subtract).
	 * @return The result of subtracting the BigDecimal value2 from the integer value1.
	 */
	public static BigDecimal subtraction(int value1, BigDecimal value2) {
	    return subtraction(toBigDecimal(value1), value2);
	}

	/**
	 * Subtracts a long value from a BigDecimal value.
	 *
	 * @param value1 The minuend (the BigDecimal value).
	 * @param value2 The subtrahend (the long value to subtract).
	 * @return The result of subtracting the long value2 from the BigDecimal value1.
	 */
	public static BigDecimal subtraction(BigDecimal value1, long value2) {
	    return subtraction(value1, toBigDecimal(value2));
	}

	/**
	 * Subtracts a BigDecimal value from a long value.
	 *
	 * @param value1 The minuend (the long value).
	 * @param value2 The subtrahend (the BigDecimal value to subtract).
	 * @return The result of subtracting the BigDecimal value2 from the long value1.
	 */
	public static BigDecimal subtraction(long value1, BigDecimal value2) {
	    return subtraction(toBigDecimal(value1), value2);
	}

	/**
	 * Subtracts multiple BigDecimal values.
	 *
	 * @param value1  The minuend (the first BigDecimal value).
	 * @param values  Additional BigDecimal values to be subtracted.
	 * @return        The result of subtracting all the BigDecimal values.
	 */
	public static BigDecimal subtraction(BigDecimal value1, BigDecimal... values) {
	    BigDecimal result = value1;
	    for (BigDecimal value : values) {
	        result = subtraction(result, value);
	    }
	    return result;
	}

	// Multiplication

	/**
	 * Multiplies two BigDecimal values.
	 *
	 * @param value1 The first BigDecimal value.
	 * @param value2 The second BigDecimal value.
	 * @return The result of multiplying the two BigDecimal values.
	 */
	public static BigDecimal multiplication(BigDecimal value1, BigDecimal value2) {
	    return value1.multiply(value2);
	}

	/**
	 * Multiplies a BigDecimal value by an integer value.
	 *
	 * @param value1 The BigDecimal value.
	 * @param value2 The integer value to multiply.
	 * @return The result of multiplying the BigDecimal value by the integer value.
	 */
	public static BigDecimal multiplication(BigDecimal value1, int value2) {
	    return multiplication(value1, toBigDecimal(value2));
	}

	/**
	 * Multiplies an integer value by a BigDecimal value.
	 *
	 * @param value1 The integer value to multiply.
	 * @param value2 The BigDecimal value.
	 * @return The result of multiplying the integer value by the BigDecimal value.
	 */
	public static BigDecimal multiplication(int value1, BigDecimal value2) {
	    return multiplication(toBigDecimal(value1), value2);
	}

	/**
	 * Multiplies a BigDecimal value by a long value.
	 *
	 * @param value1 The BigDecimal value.
	 * @param value2 The long value to multiply.
	 * @return The result of multiplying the BigDecimal value by the long value.
	 */
	public static BigDecimal multiplication(BigDecimal value1, long value2) {
	    return multiplication(value1, toBigDecimal(value2));
	}

	/**
	 * Multiplies a long value by a BigDecimal value.
	 *
	 * @param value1 The long value to multiply.
	 * @param value2 The BigDecimal value.
	 * @return The result of multiplying the long value by the BigDecimal value.
	 */
	public static BigDecimal multiplication(long value1, BigDecimal value2) {
	    return multiplication(toBigDecimal(value1), value2);
	}

	/**
	 * Multiplies multiple BigDecimal values.
	 *
	 * @param value1  The first BigDecimal value.
	 * @param values  Additional BigDecimal values to be multiplied.
	 * @return        The result of multiplying all the BigDecimal values.
	 */
	public static BigDecimal multiplication(BigDecimal value1, BigDecimal... values) {
	    BigDecimal result = value1;
	    for (BigDecimal value : values) {
	        result = multiplication(result, value);
	    }
	    return result;
	}

	// Division

	/**
	 * Divides the first BigDecimal value by the second BigDecimal value with specified decimal places and rounding mode.
	 *
	 * @param value1         The dividend (numerator).
	 * @param value2         The divisor (denominator).
	 * @param decimalPlaces  The number of decimal places in the result.
	 * @param roundingMode   The rounding mode to be used for the result.
	 * @return               The result of dividing value1 by value2 with the specified decimal places and rounding mode.
	 * @throws ArithmeticException if the quotient has a nonterminating decimal expansion.
	 */
	public static BigDecimal division(BigDecimal value1, BigDecimal value2, int decimalPlaces, RoundingMode roundingMode) {
	    return value1.divide(value2, decimalPlaces, roundingMode);
	}

	/**
	 * Divides the first BigDecimal value by the second integer value with specified decimal places and rounding mode.
	 *
	 * @param value1         The dividend (numerator).
	 * @param value2         The divisor (denominator).
	 * @param decimalPlaces  The number of decimal places in the result.
	 * @param roundingMode   The rounding mode to be used for the result.
	 * @return               The result of dividing value1 by value2 with the specified decimal places and rounding mode.
	 * @throws ArithmeticException if the quotient has a nonterminating decimal expansion.
	 */
	public static BigDecimal division(BigDecimal value1, int value2, int decimalPlaces, RoundingMode roundingMode) {
	    return division(value1, toBigDecimal(value2), decimalPlaces, roundingMode);
	}

	/**
	 * Divides the first integer value by the second BigDecimal value with specified decimal places and rounding mode.
	 *
	 * @param value1         The dividend (numerator).
	 * @param value2         The divisor (denominator).
	 * @param decimalPlaces  The number of decimal places in the result.
	 * @param roundingMode   The rounding mode to be used for the result.
	 * @return               The result of dividing value1 by value2 with the specified decimal places and rounding mode.
	 * @throws ArithmeticException if the quotient has a nonterminating decimal expansion.
	 */
	public static BigDecimal division(int value1, BigDecimal value2, int decimalPlaces, RoundingMode roundingMode) {
	    return division(toBigDecimal(value1), value2, decimalPlaces, roundingMode);
	}

	/**
	 * Divides the first BigDecimal value by the second long value with specified decimal places and rounding mode.
	 *
	 * @param value1         The dividend (numerator).
	 * @param value2         The divisor (denominator).
	 * @param decimalPlaces  The number of decimal places in the result.
	 * @param roundingMode   The rounding mode to be used for the result.
	 * @return               The result of dividing value1 by value2 with the specified decimal places and rounding mode.
	 * @throws ArithmeticException if the quotient has a nonterminating decimal expansion.
	 */
	public static BigDecimal division(BigDecimal value1, long value2, int decimalPlaces, RoundingMode roundingMode) {
	    return division(value1, toBigDecimal(value2), decimalPlaces, roundingMode);
	}

	/**
	 * Divides the first long value by the second BigDecimal value with specified decimal places and rounding mode.
	 *
	 * @param value1         The dividend (numerator).
	 * @param value2         The divisor (denominator).
	 * @param decimalPlaces  The number of decimal places in the result.
	 * @param roundingMode   The rounding mode to be used for the result.
	 * @return               The result of dividing value1 by value2 with the specified decimal places and rounding mode.
	 * @throws ArithmeticException if the quotient has a nonterminating decimal expansion.
	 */
	public static BigDecimal division(long value1, BigDecimal value2, int decimalPlaces, RoundingMode roundingMode) {
	    return division(toBigDecimal(value1), value2, decimalPlaces, roundingMode);
	}

	/**
	 * Divides the first integer value by the second long value with specified decimal places and rounding mode.
	 * 
	 * @param value1         The dividend (numerator).
	 * @param value2         The divisor (denominator).
	 * @param decimalPlaces  The number of decimal places in the result.
	 * @param roundingMode   The rounding mode to be used for the result.
	 * @return               The result of dividing value1 by value2 with the specified decimal places and rounding mode.
	 * @throws ArithmeticException if the quotient has a nonterminating decimal expansion.
	 */
	public static BigDecimal division(int value1, long value2, int decimalPlaces, RoundingMode roundingMode) {
	    return division(toBigDecimal(value1), toBigDecimal(value2), decimalPlaces, roundingMode);
	}

	/**
	 * Divides the first long value by the second integer value with specified decimal places and rounding mode.
	 * 
	 * @param value1         The dividend (numerator).
	 * @param value2         The divisor (denominator).
	 * @param decimalPlaces  The number of decimal places in the result.
	 * @param roundingMode   The rounding mode to be used for the result.
	 * @return               The result of dividing value1 by value2 with the specified decimal places and rounding mode.
	 * @throws ArithmeticException if the quotient has a nonterminating decimal expansion.
	 */
	public static BigDecimal division(long value1, int value2, int decimalPlaces, RoundingMode roundingMode) {
	    return division(toBigDecimal(value1), toBigDecimal(value2), decimalPlaces, roundingMode);
	}

	/**
	 * Divides the first integer value by the second integer value with specified decimal places and rounding mode.
	 * 
	 * @param value1         The dividend (numerator).
	 * @param value2         The divisor (denominator).
	 * @param decimalPlaces  The number of decimal places in the result.
	 * @param roundingMode   The rounding mode to be used for the result.
	 * @return               The result of dividing value1 by value2 with the specified decimal places and rounding mode.
	 * @throws ArithmeticException if the quotient has a nonterminating decimal expansion.
	 */
	public static BigDecimal division(int value1, int value2, int decimalPlaces, RoundingMode roundingMode) {
	    return division(toBigDecimal(value1), toBigDecimal(value2), decimalPlaces, roundingMode);
	}

	/**
	 * Divides the first long value by the second long value with specified decimal places and rounding mode.
	 * 
	 * @param value1         The dividend (numerator).
	 * @param value2         The divisor (denominator).
	 * @param decimalPlaces  The number of decimal places in the result.
	 * @param roundingMode   The rounding mode to be used for the result.
	 * @return               The result of dividing value1 by value2 with the specified decimal places and rounding mode.
	 * @throws ArithmeticException if the quotient has a nonterminating decimal expansion.
	 */
	public static BigDecimal division(long value1, long value2, int decimalPlaces, RoundingMode roundingMode) {
	    return division(toBigDecimal(value1), toBigDecimal(value2), decimalPlaces, roundingMode);
	}

	/**
	 * Divides the first BigDecimal value by the second BigDecimal value with specified decimal places and rounding mode.
	 * The result will be truncated using {@link RoundingMode#DOWN}.
	 * 
	 * @param value1         The dividend (numerator).
	 * @param value2         The divisor (denominator).
	 * @param decimalPlaces  The number of decimal places in the result.
	 * @return               The result of dividing value1 by value2 with the specified decimal places, using {@link RoundingMode#DOWN}.
	 * @throws ArithmeticException if the quotient has a nonterminating decimal expansion.
	 */
	public static BigDecimal division(BigDecimal value1, BigDecimal value2, int decimalPlaces) {
	    return division(value1, value2, decimalPlaces, RoundingMode.DOWN);
	}

	/**
	 * Divides the first BigDecimal value by the second integer value with specified decimal places.
	 * The result will be truncated using {@link RoundingMode#DOWN}.
	 *
	 * @param value1         The dividend (numerator).
	 * @param value2         The divisor (denominator).
	 * @param decimalPlaces  The number of decimal places in the result.
	 * @return               The result of dividing value1 by value2 with the specified decimal places, using {@link RoundingMode#DOWN}.
	 * @throws ArithmeticException if the quotient has a nonterminating decimal expansion.
	 */
	public static BigDecimal division(BigDecimal value1, int value2, int decimalPlaces) {
	    return division(value1, toBigDecimal(value2), decimalPlaces);
	}

	/**
	 * Divides the first integer value by the second BigDecimal value with specified decimal places.
	 * The result will be truncated using {@link RoundingMode#DOWN}.
	 *
	 * @param value1         The dividend (numerator).
	 * @param value2         The divisor (denominator).
	 * @param decimalPlaces  The number of decimal places in the result.
	 * @return               The result of dividing value1 by value2 with the specified decimal places, using {@link RoundingMode#DOWN}.
	 * @throws ArithmeticException if the quotient has a nonterminating decimal expansion.
	 */
	public static BigDecimal division(int value1, BigDecimal value2, int decimalPlaces) {
	    return division(toBigDecimal(value1), value2, decimalPlaces);
	}

	/**
	 * Divides the first BigDecimal value by the second long value with specified decimal places.
	 * The result will be truncated using {@link RoundingMode#DOWN}.
	 *
	 * @param value1         The dividend (numerator).
	 * @param value2         The divisor (denominator).
	 * @param decimalPlaces  The number of decimal places in the result.
	 * @return               The result of dividing value1 by value2 with the specified decimal places, using {@link RoundingMode#DOWN}.
	 * @throws ArithmeticException if the quotient has a nonterminating decimal expansion.
	 */
	public static BigDecimal division(BigDecimal value1, long value2, int decimalPlaces) {
	    return division(value1, toBigDecimal(value2), decimalPlaces);
	}

	/**
	 * Divides the first long value by the second BigDecimal value with specified decimal places.
	 * The result will be truncated using {@link RoundingMode#DOWN}.
	 *
	 * @param value1         The dividend (numerator).
	 * @param value2         The divisor (denominator).
	 * @param decimalPlaces  The number of decimal places in the result.
	 * @return               The result of dividing value1 by value2 with the specified decimal places, using {@link RoundingMode#DOWN}.
	 * @throws ArithmeticException if the quotient has a nonterminating decimal expansion.
	 */
	public static BigDecimal division(long value1, BigDecimal value2, int decimalPlaces) {
	    return division(toBigDecimal(value1), value2, decimalPlaces);
	}

	/**
	 * Divides the first integer value by the second long value with specified decimal places.
	 * The result will be truncated using {@link RoundingMode#DOWN}.
	 *
	 * @param value1         The dividend (numerator).
	 * @param value2         The divisor (denominator).
	 * @param decimalPlaces  The number of decimal places in the result.
	 * @return               The result of dividing value1 by value2 with the specified decimal places, using {@link RoundingMode#DOWN}.
	 * @throws ArithmeticException if the quotient has a nonterminating decimal expansion.
	 */
	public static BigDecimal division(int value1, long value2, int decimalPlaces) {
	    return division(toBigDecimal(value1), toBigDecimal(value2), decimalPlaces);
	}

	/**
	 * Divides the first long value by the second integer value with specified decimal places.
	 * The result will be truncated using {@link RoundingMode#DOWN}.
	 *
	 * @param value1         The dividend (numerator).
	 * @param value2         The divisor (denominator).
	 * @param decimalPlaces  The number of decimal places in the result.
	 * @return               The result of dividing value1 by value2 with the specified decimal places, using {@link RoundingMode#DOWN}.
	 * @throws ArithmeticException if the quotient has a nonterminating decimal expansion.
	 */
	public static BigDecimal division(long value1, int value2, int decimalPlaces) {
	    return division(toBigDecimal(value1), toBigDecimal(value2), decimalPlaces);
	}

	/**
	 * Divides the first integer value by the second integer value with specified decimal places.
	 * The result will be truncated using {@link RoundingMode#DOWN}.
	 *
	 * @param value1         The dividend (numerator).
	 * @param value2         The divisor (denominator).
	 * @param decimalPlaces  The number of decimal places in the result.
	 * @return               The result of dividing value1 by value2 with the specified decimal places, using {@link RoundingMode#DOWN}.
	 * @throws ArithmeticException if the quotient has a nonterminating decimal expansion.
	 */
	public static BigDecimal division(int value1, int value2, int decimalPlaces) {
	    return division(toBigDecimal(value1), toBigDecimal(value2), decimalPlaces);
	}

	/**
	 * Divides the first long value by the second long value with specified decimal places.
	 * The result will be truncated using {@link RoundingMode#DOWN}.
	 *
	 * @param value1         The dividend (numerator).
	 * @param value2         The divisor (denominator).
	 * @param decimalPlaces  The number of decimal places in the result.
	 * @return               The result of dividing value1 by value2 with the specified decimal places, using {@link RoundingMode#DOWN}.
	 * @throws ArithmeticException if the quotient has a nonterminating decimal expansion.
	 */
	public static BigDecimal division(long value1, long value2, int decimalPlaces) {
	    return division(toBigDecimal(value1), toBigDecimal(value2), decimalPlaces);
	}

	// POW 
	
	/**
	 * Raises the given base to the power of the specified exponent.
	 *
	 * @param base   The base value.
	 * @param power  The exponent value.
	 * @return       The result of raising the base to the power of the exponent.
	 */
	public static BigDecimal pow(BigDecimal base, int power) {
	    return base.pow(power);
	}

	// COMPARATORS

	/**
	 * Checks if two BigDecimal values are equal.
	 *
	 * @param left   The first BigDecimal value.
	 * @param right  The second BigDecimal value.
	 * @return       {@code true} if left is equal to right, {@code false} otherwise.
	 */
	public static boolean isEqualTo(BigDecimal left, BigDecimal right) {
	    return compareTo(left, right) == 0;
	}

	/**
	 * Checks if a BigDecimal value is equal to an integer value.
	 *
	 * @param left   The BigDecimal value.
	 * @param right  The integer value.
	 * @return       {@code true} if left is equal to right, {@code false} otherwise.
	 */
	public static boolean isEqualTo(BigDecimal left, int right) {
	    return compareTo(left, right) == 0;
	}

	/**
	 * Checks if an integer value is equal to a BigDecimal value.
	 *
	 * @param left   The integer value.
	 * @param right  The BigDecimal value.
	 * @return       {@code true} if left is equal to right, {@code false} otherwise.
	 */
	public static boolean isEqualTo(int left, BigDecimal right) {
	    return compareTo(left, right) == 0;
	}

	/**
	 * Checks if a BigDecimal value is equal to a long value.
	 *
	 * @param left   The BigDecimal value.
	 * @param right  The long value.
	 * @return       {@code true} if left is equal to right, {@code false} otherwise.
	 */
	public static boolean isEqualTo(BigDecimal left, long right) {
	    return compareTo(left, right) == 0;
	}

	/**
	 * Checks if a long value is equal to a BigDecimal value.
	 *
	 * @param left   The long value.
	 * @param right  The BigDecimal value.
	 * @return       {@code true} if left is equal to right, {@code false} otherwise.
	 */
	public static boolean isEqualTo(long left, BigDecimal right) {
	    return compareTo(left, right) == 0;
	}

	/**
	 * Checks if two BigDecimal values are not equal.
	 *
	 * @param left   The first BigDecimal value.
	 * @param right  The second BigDecimal value.
	 * @return       {@code true} if left is not equal to right, {@code false} otherwise.
	 */
	public static boolean isNotEqualTo(BigDecimal left, BigDecimal right) {
	    return compareTo(left, right) != 0;
	}

	/**
	 * Checks if a BigDecimal value is not equal to an integer value.
	 *
	 * @param left   The BigDecimal value.
	 * @param right  The integer value.
	 * @return       {@code true} if left is not equal to right, {@code false} otherwise.
	 */
	public static boolean isNotEqualTo(BigDecimal left, int right) {
	    return compareTo(left, right) != 0;
	}

	/**
	 * Checks if an integer value is not equal to a BigDecimal value.
	 *
	 * @param left   The integer value.
	 * @param right  The BigDecimal value.
	 * @return       {@code true} if left is not equal to right, {@code false} otherwise.
	 */
	public static boolean isNotEqualTo(int left, BigDecimal right) {
	    return compareTo(left, right) != 0;
	}

	/**
	 * Checks if a BigDecimal value is not equal to a long value.
	 *
	 * @param left   The BigDecimal value.
	 * @param right  The long value.
	 * @return       {@code true} if left is not equal to right, {@code false} otherwise.
	 */
	public static boolean isNotEqualTo(BigDecimal left, long right) {
	    return compareTo(left, right) != 0;
	}

	/**
	 * Checks if a long value is not equal to a BigDecimal value.
	 *
	 * @param left   The long value.
	 * @param right  The BigDecimal value.
	 * @return       {@code true} if left is not equal to right, {@code false} otherwise.
	 */
	public static boolean isNotEqualTo(long left, BigDecimal right) {
	    return compareTo(left, right) != 0;
	}

	/**
	 * Checks if a BigDecimal value is less than another BigDecimal value.
	 *
	 * @param left   The first BigDecimal value.
	 * @param right  The second BigDecimal value.
	 * @return       {@code true} if left is less than right, {@code false} otherwise.
	 */
	public static boolean isLessThan(BigDecimal left, BigDecimal right) {
	    return compareTo(left, right) < 0;
	}

	/**
	 * Checks if a BigDecimal value is less than an integer value.
	 *
	 * @param left   The BigDecimal value.
	 * @param right  The integer value.
	 * @return       {@code true} if left is less than right, {@code false} otherwise.
	 */
	public static boolean isLessThan(BigDecimal left, int right) {
	    return compareTo(left, right) < 0;
	}

	/**
	 * Checks if an integer value is less than a BigDecimal value.
	 *
	 * @param left   The integer value.
	 * @param right  The BigDecimal value.
	 * @return       {@code true} if left is less than right, {@code false} otherwise.
	 */
	public static boolean isLessThan(int left, BigDecimal right) {
	    return compareTo(left, right) < 0;
	}

	/**
	 * Checks if a BigDecimal value is less than a long value.
	 *
	 * @param left   The BigDecimal value.
	 * @param right  The long value.
	 * @return       {@code true} if left is less than right, {@code false} otherwise.
	 */
	public static boolean isLessThan(BigDecimal left, long right) {
	    return compareTo(left, right) < 0;
	}

	/**
	 * Checks if a long value is less than a BigDecimal value.
	 *
	 * @param left   The long value.
	 * @param right  The BigDecimal value.
	 * @return       {@code true} if left is less than right, {@code false} otherwise.
	 */
	public static boolean isLessThan(long left, BigDecimal right) {
	    return compareTo(left, right) < 0;
	}

	/**
	 * Checks if a BigDecimal value is less than or equal to another BigDecimal value.
	 *
	 * @param left   The first BigDecimal value.
	 * @param right  The second BigDecimal value.
	 * @return       {@code true} if left is less than or equal to right, {@code false} otherwise.
	 */
	public static boolean isLessThanOrEqualTo(BigDecimal left, BigDecimal right) {
	    return compareTo(left, right) <= 0;
	}

	/**
	 * Checks if a BigDecimal value is less than or equal to an integer value.
	 *
	 * @param left   The BigDecimal value.
	 * @param right  The integer value.
	 * @return       {@code true} if left is less than or equal to right, {@code false} otherwise.
	 */
	public static boolean isLessThanOrEqualTo(BigDecimal left, int right) {
	    return compareTo(left, right) <= 0;
	}

	/**
	 * Checks if an integer value is less than or equal to a BigDecimal value.
	 *
	 * @param left   The integer value.
	 * @param right  The BigDecimal value.
	 * @return       {@code true} if left is less than or equal to right, {@code false} otherwise.
	 */
	public static boolean isLessThanOrEqualTo(int left, BigDecimal right) {
	    return compareTo(left, right) <= 0;
	}

	/**
	 * Checks if a BigDecimal value is less than or equal to a long value.
	 *
	 * @param left   The BigDecimal value.
	 * @param right  The long value.
	 * @return       {@code true} if left is less than or equal to right, {@code false} otherwise.
	 */
	public static boolean isLessThanOrEqualTo(BigDecimal left, long right) {
	    return compareTo(left, right) <= 0;
	}

	/**
	 * Checks if a long value is less than or equal to a BigDecimal value.
	 *
	 * @param left   The long value.
	 * @param right  The BigDecimal value.
	 * @return       {@code true} if left is less than or equal to right, {@code false} otherwise.
	 */
	public static boolean isLessThanOrEqualTo(long left, BigDecimal right) {
	    return compareTo(left, right) <= 0;
	}

	/**
	 * Checks if a BigDecimal value is greater than another BigDecimal value.
	 *
	 * @param left   The first BigDecimal value.
	 * @param right  The second BigDecimal value.
	 * @return       {@code true} if left is greater than right, {@code false} otherwise.
	 */
	public static boolean isGreaterThan(BigDecimal left, BigDecimal right) {
	    return compareTo(left, right) > 0;
	}

	/**
	 * Checks if a BigDecimal value is greater than an integer value.
	 *
	 * @param left   The BigDecimal value.
	 * @param right  The integer value.
	 * @return       {@code true} if left is greater than right, {@code false} otherwise.
	 */
	public static boolean isGreaterThan(BigDecimal left, int right) {
	    return compareTo(left, right) > 0;
	}

	/**
	 * Checks if an integer value is greater than a BigDecimal value.
	 *
	 * @param left   The integer value.
	 * @param right  The BigDecimal value.
	 * @return       {@code true} if left is greater than right, {@code false} otherwise.
	 */
	public static boolean isGreaterThan(int left, BigDecimal right) {
	    return compareTo(left, right) > 0;
	}

	/**
	 * Checks if a BigDecimal value is greater than a long value.
	 *
	 * @param left   The BigDecimal value.
	 * @param right  The long value.
	 * @return       {@code true} if left is greater than right, {@code false} otherwise.
	 */
	public static boolean isGreaterThan(BigDecimal left, long right) {
	    return compareTo(left, right) > 0;
	}

	/**
	 * Checks if a long value is greater than a BigDecimal value.
	 *
	 * @param left   The long value.
	 * @param right  The BigDecimal value.
	 * @return       {@code true} if left is greater than right, {@code false} otherwise.
	 */
	public static boolean isGreaterThan(long left, BigDecimal right) {
	    return compareTo(left, right) > 0;
	}

	/**
	 * Checks if a BigDecimal value is greater than or equal to another BigDecimal value.
	 *
	 * @param left   The first BigDecimal value.
	 * @param right  The second BigDecimal value.
	 * @return       {@code true} if left is greater than or equal to right, {@code false} otherwise.
	 */
	public static boolean isGreaterThanOrEqualTo(BigDecimal left, BigDecimal right) {
	    return compareTo(left, right) >= 0;
	}

	/**
	 * Checks if a BigDecimal value is greater than or equal to an integer value.
	 *
	 * @param left   The BigDecimal value.
	 * @param right  The integer value.
	 * @return       {@code true} if left is greater than or equal to right, {@code false} otherwise.
	 */
	public static boolean isGreaterThanOrEqualTo(BigDecimal left, int right) {
	    return compareTo(left, right) >= 0;
	}

	/**
	 * Checks if an integer value is greater than or equal to a BigDecimal value.
	 *
	 * @param left   The integer value.
	 * @param right  The BigDecimal value.
	 * @return       {@code true} if left is greater than or equal to right, {@code false} otherwise.
	 */
	public static boolean isGreaterThanOrEqualTo(int left, BigDecimal right) {
	    return compareTo(left, right) >= 0;
	}

	/**
	 * Checks if a BigDecimal value is greater than or equal to a long value.
	 *
	 * @param left   The left operand (BigDecimal).
	 * @param right  The right operand (long).
	 * @return       {@code true} if left is greater than or equal to right; {@code false} otherwise.
	 */
	public static boolean isGreaterThanOrEqualTo(BigDecimal left, long right) {
	    return compareTo(left, right) >= 0;
	}

	/**
	 * Checks if a long value is greater than or equal to a BigDecimal value.
	 *
	 * @param left   The left operand (long).
	 * @param right  The right operand (BigDecimal).
	 * @return       {@code true} if left is greater than or equal to right; {@code false} otherwise.
	 */
	public static boolean isGreaterThanOrEqualTo(long left, BigDecimal right) {
	    return compareTo(left, right) >= 0;
	}

	// COMPARATORS FOR 0 AS FACILITY

	/**
	 * Checks if a BigDecimal value is equal to zero.
	 *
	 * @param value  The BigDecimal value to compare.
	 * @return       {@code true} if the value is equal to zero; {@code false} otherwise.
	 */
	public static boolean isEqualToZERO(BigDecimal value) {
	    return isEqualTo(value, ZERO);
	}

	/**
	 * Checks if a BigDecimal value is not equal to zero.
	 *
	 * @param value  The BigDecimal value to compare.
	 * @return       {@code true} if the value is not equal to zero; {@code false} otherwise.
	 */
	public static boolean isNotEqualToZERO(BigDecimal value) {
	    return isNotEqualTo(value, ZERO);
	}

	/**
	 * Checks if a BigDecimal value is greater than zero.
	 *
	 * @param value  The BigDecimal value to compare.
	 * @return       {@code true} if the value is greater than zero; {@code false} otherwise.
	 */
	public static boolean isGreaterThanZERO(BigDecimal value) {
	    return isGreaterThan(value, ZERO);
	}

	/**
	 * Checks if a BigDecimal value is greater than or equal to zero.
	 *
	 * @param value  The BigDecimal value to compare.
	 * @return       {@code true} if the value is greater than or equal to zero; {@code false} otherwise.
	 */
	public static boolean isGreaterThanOrEqualToZERO(BigDecimal value) {
	    return isGreaterThanOrEqualTo(value, ZERO);
	}

	/**
	 * Checks if a BigDecimal value is less than zero.
	 *
	 * @param value  The BigDecimal value to compare.
	 * @return       {@code true} if the value is less than zero; {@code false} otherwise.
	 */
	public static boolean isLessThanZERO(BigDecimal value) {
	    return isLessThan(value, ZERO);
	}

	/**
	 * Checks if a BigDecimal value is less than or equal to zero.
	 *
	 * @param value  The BigDecimal value to compare.
	 * @return       {@code true} if the value is less than or equal to zero; {@code false} otherwise.
	 */
	public static boolean isLessThanOrEqualToZERO(BigDecimal value) {
	    return isLessThanOrEqualTo(value, ZERO);
	}

	// COMPARE TO

	/**
	 * Compares two BigDecimal values.
	 *
	 * @param left   The left operand (BigDecimal).
	 * @param right  The right operand (BigDecimal).
	 * @return       A negative integer, zero, or a positive integer as the left value is less than, equal to,
	 *               or greater than the right value.
	 */
	private static int compareTo(BigDecimal left, BigDecimal right) {
	    return left.compareTo(right);
	}

	/**
	 * Compares a BigDecimal value to an integer value.
	 *
	 * @param left   The left operand (BigDecimal).
	 * @param right  The right operand (integer).
	 * @return       A negative integer, zero, or a positive integer as the left value is less than, equal to,
	 *               or greater than the right value.
	 */
	private static int compareTo(BigDecimal left, int right) {
	    return left.compareTo(toBigDecimal(right));
	}

	/**
	 * Compares an integer value to a BigDecimal value.
	 *
	 * @param left   The left operand (integer).
	 * @param right  The right operand (BigDecimal).
	 * @return       A negative integer, zero, or a positive integer as the left value is less than, equal to,
	 *               or greater than the right value.
	 */
	private static int compareTo(int left, BigDecimal right) {
	    return toBigDecimal(left).compareTo(right);
	}

	/**
	 * Compares a BigDecimal value to a long value.
	 *
	 * @param left   The left operand (BigDecimal).
	 * @param right  The right operand (long).
	 * @return       A negative integer, zero, or a positive integer as the left value is less than, equal to,
	 *               or greater than the right value.
	 */
	private static int compareTo(BigDecimal left, long right) {
	    return left.compareTo(toBigDecimal(right));
	}

	/**
	 * Compares a long value to a BigDecimal value.
	 *
	 * @param left   The left operand (long).
	 * @param right  The right operand (BigDecimal).
	 * @return       A negative integer, zero, or a positive integer as the left value is less than, equal to,
	 *               or greater than the right value.
	 */
	private static int compareTo(long left, BigDecimal right) {
	    return toBigDecimal(left).compareTo(right);
	}

}
