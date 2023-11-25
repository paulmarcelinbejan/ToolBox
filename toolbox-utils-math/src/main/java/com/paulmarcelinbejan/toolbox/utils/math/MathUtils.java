package com.paulmarcelinbejan.toolbox.utils.math;

import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MathUtils {

	// Positive
	
	public static boolean isPositive(int value) {
		return value > 0;
	}
	
	public static boolean isPositive(long value) {
		return value > 0;
	}
	
	public static boolean isPositive(BigDecimal value) {
		return isGreaterThanZERO(value);
	}
	
	public static boolean isPositiveOrZERO(int value) {
		return value >= 0;
	}
	
	public static boolean isPositiveOrZERO(long value) {
		return value >= 0;
	}
	
	public static boolean isPositiveOrZERO(BigDecimal value) {
		return isGreaterThanOrEqualToZERO(value);
	}

	// Negative
	
	public static boolean isNegative(int value) {
		return value < 0;
	}
	
	public static boolean isNegative(long value) {
		return value < 0;
	}
	
	public static boolean isNegative(BigDecimal value) {
		return isLessThanZERO(value);
	}
	
	public static boolean isNegativeOrZERO(int value) {
		return value <= 0;
	}
	
	public static boolean isNegativeOrZERO(long value) {
		return value <= 0;
	}
	
	public static boolean isNegativeOrZERO(BigDecimal value) {
		return isLessThanOrEqualToZERO(value);
	}

	// To Positive
	
	public static int toPositive(int value) {
		return isNegative(value) ? 0 - value : value;
	}
	
	public static long toPositive(long value) {
		return isNegative(value) ? 0 - value : value;
	}
	
	public static BigDecimal toPositive(BigDecimal value) {
		return isNegative(value) ? subtraction(ZERO, value) : value;
	}
	
	// To Negative 
	
	public static int toNegative(int value) {
		return isPositive(value) ? 0 - value : value;
	}
	
	public static long toNegative(long value) {
		return isPositive(value) ? 0 - value : value;
	}

	public static BigDecimal toNegative(BigDecimal value) {
		return isPositive(value) ? subtraction(ZERO, value) : value;
	}

	// To BigDecimal

	public static BigDecimal toBigDecimal(int value) {
		return BigDecimal.valueOf(value);
	}

	public static BigDecimal toBigDecimal(long value) {
		return BigDecimal.valueOf(value);
	}

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
	 */
	public static BigDecimal truncateFloor(BigDecimal value, int decimalPlaces) {
		return value.setScale(decimalPlaces, RoundingMode.FLOOR);
	}

	/**
	 * See {@link MathUtils#truncateDown(BigDecimal, int)}
	 */
	public static BigDecimal truncateDownToZeroDecimalPlaces(BigDecimal value) {
		return truncateDown(value, 0);
	}
	
	/**
	 * See {@link MathUtils#truncateFloor(BigDecimal, int)}
	 */
	public static BigDecimal truncateFloorToZeroDecimalPlaces(BigDecimal value) {
		return truncateDown(value, 0);
	}

	// Round
	
	public static BigDecimal round(BigDecimal value, int decimalPlaces, RoundingMode roundingMode) {
		return value.setScale(decimalPlaces, roundingMode);
	}

	/**
	 * {@link Math#round()} adaptation for BigDecimal
	 */
	public static long mathRound(BigDecimal value) {
		return mathRound(value, 0).longValue();
	}

	/**
	 * {@link Math#round()} adaptation for BigDecimal
	 */
	public static BigDecimal mathRound(BigDecimal value, int decimalPlaces) {
		if(isPositive(value)) {
			return round(value, decimalPlaces, RoundingMode.HALF_UP);
		}
		return round(value, decimalPlaces, RoundingMode.HALF_DOWN);
	}

	// Addition

	public static BigDecimal addition(BigDecimal value1, BigDecimal value2) {
		return value1.add(value2);
	}

	public static BigDecimal addition(BigDecimal value1, int value2) {
		return addition(value1, toBigDecimal(value2));
	}

	public static BigDecimal addition(int value1, BigDecimal value2) {
		return addition(toBigDecimal(value1), value2);
	}

	public static BigDecimal addition(BigDecimal value1, long value2) {
		return addition(value1, toBigDecimal(value2));
	}

	public static BigDecimal addition(long value1, BigDecimal value2) {
		return addition(toBigDecimal(value1), value2);
	}

	public static BigDecimal addition(BigDecimal value1, BigDecimal... values) {
		BigDecimal result = value1;
		for (BigDecimal value : values) {
			result = addition(result, value);
		}
		return result;
	}

	// Subtraction

	public static BigDecimal subtraction(BigDecimal value1, BigDecimal value2) {
		return value1.subtract(value2);
	}

	public static BigDecimal subtraction(BigDecimal value1, int value2) {
		return subtraction(value1, toBigDecimal(value2));
	}

	public static BigDecimal subtraction(int value1, BigDecimal value2) {
		return subtraction(toBigDecimal(value1), value2);
	}

	public static BigDecimal subtraction(BigDecimal value1, long value2) {
		return subtraction(value1, toBigDecimal(value2));
	}

	public static BigDecimal subtraction(long value1, BigDecimal value2) {
		return subtraction(toBigDecimal(value1), value2);
	}

	public static BigDecimal subtraction(BigDecimal value1, BigDecimal... values) {
		BigDecimal result = value1;
		for (BigDecimal value : values) {
			result = subtraction(result, value);
		}
		return result;
	}

	// Multiplication

	public static BigDecimal multiplication(BigDecimal value1, BigDecimal value2) {
		return value1.multiply(value2);
	}

	public static BigDecimal multiplication(BigDecimal value1, int value2) {
		return multiplication(value1, toBigDecimal(value2));
	}

	public static BigDecimal multiplication(int value1, BigDecimal value2) {
		return multiplication(toBigDecimal(value1), value2);
	}

	public static BigDecimal multiplication(BigDecimal value1, long value2) {
		return multiplication(value1, toBigDecimal(value2));
	}

	public static BigDecimal multiplication(long value1, BigDecimal value2) {
		return multiplication(toBigDecimal(value1), value2);
	}

	public static BigDecimal multiplication(BigDecimal value1, BigDecimal... values) {
		BigDecimal result = value1;
		for (BigDecimal value : values) {
			result = multiplication(result, value);
		}
		return result;
	}

	// Division

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide decimalPlaces and a RoundingMode.
	 */
	public static BigDecimal division(BigDecimal value1, BigDecimal value2, int decimalPlaces, RoundingMode roundingMode) {
		return value1.divide(value2, decimalPlaces, roundingMode);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide decimalPlaces and a RoundingMode.
	 */
	public static BigDecimal division(BigDecimal value1, int value2, int decimalPlaces, RoundingMode roundingMode) {
		return division(value1, toBigDecimal(value2), decimalPlaces, roundingMode);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide decimalPlaces and a RoundingMode.
	 */
	public static BigDecimal division(int value1, BigDecimal value2, int decimalPlaces, RoundingMode roundingMode) {
		return division(toBigDecimal(value1), value2, decimalPlaces, roundingMode);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide decimalPlaces and a RoundingMode.
	 */
	public static BigDecimal division(BigDecimal value1, long value2, int decimalPlaces, RoundingMode roundingMode) {
		return division(value1, toBigDecimal(value2), decimalPlaces, roundingMode);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide decimalPlaces and a RoundingMode.
	 */
	public static BigDecimal division(long value1, BigDecimal value2, int decimalPlaces, RoundingMode roundingMode) {
		return division(toBigDecimal(value1), value2, decimalPlaces, roundingMode);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide decimalPlaces and a RoundingMode.
	 */
	public static BigDecimal division(int value1, long value2, int decimalPlaces, RoundingMode roundingMode) {
		return division(toBigDecimal(value1), toBigDecimal(value2), decimalPlaces, roundingMode);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide decimalPlaces and a RoundingMode.
	 */
	public static BigDecimal division(long value1, int value2, int decimalPlaces, RoundingMode roundingMode) {
		return division(toBigDecimal(value1), toBigDecimal(value2), decimalPlaces, roundingMode);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide decimalPlaces and a RoundingMode.
	 */
	public static BigDecimal division(int value1, int value2, int decimalPlaces, RoundingMode roundingMode) {
		return division(toBigDecimal(value1), toBigDecimal(value2), decimalPlaces, roundingMode);
	}
	
	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide decimalPlaces and a RoundingMode.
	 */
	public static BigDecimal division(long value1, long value2, int decimalPlaces, RoundingMode roundingMode) {
		return division(toBigDecimal(value1), toBigDecimal(value2), decimalPlaces, roundingMode);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * the result will be truncated using {@link RoundingMode#DOWN}.
	 */
	public static BigDecimal division(BigDecimal value1, BigDecimal value2, int decimalPlaces) {
		return division(value1, value2, decimalPlaces, RoundingMode.DOWN);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * the result will be truncated using {@link RoundingMode#DOWN}.
	 */
	public static BigDecimal division(BigDecimal value1, int value2, int decimalPlaces) {
		return division(value1, toBigDecimal(value2), decimalPlaces);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * the result will be truncated using {@link RoundingMode#DOWN}.
	 */
	public static BigDecimal division(int value1, BigDecimal value2, int decimalPlaces) {
		return division(toBigDecimal(value1), value2, decimalPlaces);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * the result will be truncated using {@link RoundingMode#DOWN}.
	 */
	public static BigDecimal division(BigDecimal value1, long value2, int decimalPlaces) {
		return division(value1, toBigDecimal(value2), decimalPlaces);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * the result will be truncated using {@link RoundingMode#DOWN}.
	 */
	public static BigDecimal division(long value1, BigDecimal value2, int decimalPlaces) {
		return division(toBigDecimal(value1), value2, decimalPlaces);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * the result will be truncated using {@link RoundingMode#DOWN}.
	 */
	public static BigDecimal division(int value1, long value2, int decimalPlaces) {
		return division(toBigDecimal(value1), toBigDecimal(value2), decimalPlaces);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * the result will be truncated using {@link RoundingMode#DOWN}.
	 */
	public static BigDecimal division(long value1, int value2, int decimalPlaces) {
		return division(toBigDecimal(value1), toBigDecimal(value2), decimalPlaces);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * the result will be truncated using {@link RoundingMode#DOWN}.
	 */
	public static BigDecimal division(int value1, int value2, int decimalPlaces) {
		return division(toBigDecimal(value1), toBigDecimal(value2), decimalPlaces);
	}
	
	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * the result will be truncated using {@link RoundingMode#DOWN}.
	 */
	public static BigDecimal division(long value1, long value2, int decimalPlaces) {
		return division(toBigDecimal(value1), toBigDecimal(value2), decimalPlaces);
	}

	// POW 
	
	public static BigDecimal pow(BigDecimal base, int power) {
		return base.pow(power);
	}

	// COMPARATORS

	public static boolean isEqualTo(BigDecimal left, BigDecimal right) {
		return compareTo(left, right) == 0;
	}

	public static boolean isEqualTo(BigDecimal left, int right) {
		return compareTo(left, right) == 0;
	}

	public static boolean isEqualTo(int left, BigDecimal right) {
		return compareTo(left, right) == 0;
	}

	public static boolean isEqualTo(BigDecimal left, long right) {
		return compareTo(left, right) == 0;
	}

	public static boolean isEqualTo(long left, BigDecimal right) {
		return compareTo(left, right) == 0;
	}

	public static boolean isNotEqualTo(BigDecimal left, BigDecimal right) {
		return compareTo(left, right) != 0;
	}

	public static boolean isNotEqualTo(BigDecimal left, int right) {
		return compareTo(left, right) != 0;
	}

	public static boolean isNotEqualTo(int left, BigDecimal right) {
		return compareTo(left, right) != 0;
	}

	public static boolean isNotEqualTo(BigDecimal left, long right) {
		return compareTo(left, right) != 0;
	}

	public static boolean isNotEqualTo(long left, BigDecimal right) {
		return compareTo(left, right) != 0;
	}

	public static boolean isLessThan(BigDecimal left, BigDecimal right) {
		return compareTo(left, right) < 0;
	}

	public static boolean isLessThan(BigDecimal left, int right) {
		return compareTo(left, right) < 0;
	}

	public static boolean isLessThan(int left, BigDecimal right) {
		return compareTo(left, right) < 0;
	}

	public static boolean isLessThan(BigDecimal left, long right) {
		return compareTo(left, right) < 0;
	}

	public static boolean isLessThan(long left, BigDecimal right) {
		return compareTo(left, right) < 0;
	}

	public static boolean isLessThanOrEqualTo(BigDecimal left, BigDecimal right) {
		return compareTo(left, right) <= 0;
	}

	public static boolean isLessThanOrEqualTo(BigDecimal left, int right) {
		return compareTo(left, right) <= 0;
	}

	public static boolean isLessThanOrEqualTo(int left, BigDecimal right) {
		return compareTo(left, right) <= 0;
	}

	public static boolean isLessThanOrEqualTo(BigDecimal left, long right) {
		return compareTo(left, right) <= 0;
	}

	public static boolean isLessThanOrEqualTo(long left, BigDecimal right) {
		return compareTo(left, right) <= 0;
	}

	public static boolean isGreaterThan(BigDecimal left, BigDecimal right) {
		return compareTo(left, right) > 0;
	}

	public static boolean isGreaterThan(BigDecimal left, int right) {
		return compareTo(left, right) > 0;
	}

	public static boolean isGreaterThan(int left, BigDecimal right) {
		return compareTo(left, right) > 0;
	}

	public static boolean isGreaterThan(BigDecimal left, long right) {
		return compareTo(left, right) > 0;
	}

	public static boolean isGreaterThan(long left, BigDecimal right) {
		return compareTo(left, right) > 0;
	}

	public static boolean isGreaterThanOrEqualTo(BigDecimal left, BigDecimal right) {
		return compareTo(left, right) >= 0;
	}

	public static boolean isGreaterThanOrEqualTo(BigDecimal left, int right) {
		return compareTo(left, right) >= 0;
	}

	public static boolean isGreaterThanOrEqualTo(int left, BigDecimal right) {
		return compareTo(left, right) >= 0;
	}

	public static boolean isGreaterThanOrEqualTo(BigDecimal left, long right) {
		return compareTo(left, right) >= 0;
	}

	public static boolean isGreaterThanOrEqualTo(long left, BigDecimal right) {
		return compareTo(left, right) >= 0;
	}

	// COMPARATORS FOR 0 AS FACILITY

	public static boolean isEqualToZERO(BigDecimal value) {
		return isEqualTo(value, ZERO);
	}

	public static boolean isNotEqualToZERO(BigDecimal value) {
		return isNotEqualTo(value, ZERO);
	}

	public static boolean isGreaterThanZERO(BigDecimal value) {
		return isGreaterThan(value, ZERO);
	}

	public static boolean isGreaterThanOrEqualToZERO(BigDecimal value) {
		return isGreaterThanOrEqualTo(value, ZERO);
	}

	public static boolean isLessThanZERO(BigDecimal value) {
		return isLessThan(value, ZERO);
	}

	public static boolean isLessThanOrEqualToZERO(BigDecimal value) {
		return isLessThanOrEqualTo(value, ZERO);
	}

	// COMPARE TO

	private static int compareTo(BigDecimal left, BigDecimal right) {
		return left.compareTo(right);
	}

	private static int compareTo(BigDecimal left, int right) {
		return left.compareTo(toBigDecimal(right));
	}

	private static int compareTo(int left, BigDecimal right) {
		return toBigDecimal(left).compareTo(right);
	}

	private static int compareTo(BigDecimal left, long right) {
		return left.compareTo(toBigDecimal(right));
	}

	private static int compareTo(long left, BigDecimal right) {
		return toBigDecimal(left).compareTo(right);
	}

}
