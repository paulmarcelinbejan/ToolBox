package com.paulmarcelinbejan.architecture.utils.math;

import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NumberUtils {

	// Positive
	
	public static boolean isPositive(final int value) {
		return value > 0;
	}
	
	public static boolean isPositive(final long value) {
		return value > 0;
	}
	
	public static boolean isPositive(final BigDecimal value) {
		return isGreaterThanZERO(value);
	}
	
	public static boolean isPositiveOrZERO(final int value) {
		return value >= 0;
	}
	
	public static boolean isPositiveOrZERO(final long value) {
		return value >= 0;
	}
	
	public static boolean isPositiveOrZERO(final BigDecimal value) {
		return isGreaterOrEqualThanZERO(value);
	}

	// Negative
	
	public static boolean isNegative(final int value) {
		return value < 0;
	}
	
	public static boolean isNegative(final long value) {
		return value < 0;
	}
	
	public static boolean isNegative(final BigDecimal value) {
		return isLessThanZERO(value);
	}
	
	public static boolean isNegativeOrZERO(final int value) {
		return value <= 0;
	}
	
	public static boolean isNegativeOrZERO(final long value) {
		return value <= 0;
	}
	
	public static boolean isNegativeOrZERO(final BigDecimal value) {
		return isLessOrEqualThanZERO(value);
	}

	// To Positive
	
	public static int toPositive(final int value) {
		return isNegative(value) ? 0 - value : value;
	}
	
	public static long toPositive(final long value) {
		return isNegative(value) ? 0 - value : value;
	}
	
	public static BigDecimal toPositive(final BigDecimal value) {
		return isNegative(value) ? subtraction(ZERO, value) : value;
	}
	
	// To Negative 
	
	public static int toNegative(final int value) {
		return isPositive(value) ? 0 - value : value;
	}
	
	public static long toNegative(final long value) {
		return isPositive(value) ? 0 - value : value;
	}

	public static BigDecimal toNegative(final BigDecimal value) {
		return isPositive(value) ? subtraction(ZERO, value) : value;
	}

	// To BigDecimal

	public static BigDecimal toBigDecimal(final int value) {
		return BigDecimal.valueOf(value);
	}

	public static BigDecimal toBigDecimal(final long value) {
		return BigDecimal.valueOf(value);
	}

	public static BigDecimal toBigDecimal(final String value) {
		return new BigDecimal(value);
	}
	
	// Truncate
	
	/*
		2 Options:
		- RoundingMode.DOWN
		- RoundingMode.FLOOR
		For positive numbers they works in the same way.
		For negative numbers:
		RoundingMode.DOWN will go to positive,
		RoundingMode.FLOOR will go to negative,
		
		As Example:
		-1.6 will be truncated to:
		RoundingMode.DOWN -> -1
		RoundingMode.FLOOR -> -2
	 */
	
	/**
	 * The truncate function use {@link RoundingMode#DOWN} to truncate the number.
	 */
	public static BigDecimal truncate(final BigDecimal value, final int scale) {
		return value.setScale(scale, RoundingMode.DOWN);
	}

	public static BigDecimal truncateToZeroDecimal(final BigDecimal value) {
		return truncate(value, 0);
	}

	// Round

	public static BigDecimal round(final BigDecimal value, final int scale, final RoundingMode roundingMode) {
		return value.setScale(scale, roundingMode);
	}

	/**
	 * {@link Math#round()} adaptation for BigDecimal
	 */
	public static long mathRound(final BigDecimal value) {
		if(isPositive(value)) {
			return round(value, 0, RoundingMode.HALF_UP).longValue();
		}
		return round(value, 0, RoundingMode.HALF_DOWN).longValue();
	}

	/**
	 * {@link Math#round()} adaptation for BigDecimal
	 */
	public static BigDecimal mathRound(final BigDecimal value, final int scale) {
		if(isPositive(value)) {
			return round(value, scale, RoundingMode.HALF_UP);
		}
		return round(value, scale, RoundingMode.HALF_DOWN);
	}

	// Addition

	public static BigDecimal addition(final BigDecimal value1, final BigDecimal value2) {
		return value1.add(value2);
	}

	public static BigDecimal addition(final BigDecimal value1, final int value2) {
		return addition(value1, toBigDecimal(value2));
	}

	public static BigDecimal addition(final int value1, final BigDecimal value2) {
		return addition(toBigDecimal(value1), value2);
	}

	public static BigDecimal addition(final BigDecimal value1, final long value2) {
		return addition(value1, toBigDecimal(value2));
	}

	public static BigDecimal addition(final long value1, final BigDecimal value2) {
		return addition(toBigDecimal(value1), value2);
	}

	public static BigDecimal addition(final BigDecimal value1, final BigDecimal... values) {
		BigDecimal result = value1;
		for (BigDecimal value : values) {
			result = addition(result, value);
		}
		return result;
	}

	// Subtraction

	public static BigDecimal subtraction(final BigDecimal value1, final BigDecimal value2) {
		return value1.subtract(value2);
	}

	public static BigDecimal subtraction(final BigDecimal value1, final int value2) {
		return subtraction(value1, toBigDecimal(value2));
	}

	public static BigDecimal subtraction(final int value1, final BigDecimal value2) {
		return subtraction(toBigDecimal(value1), value2);
	}

	public static BigDecimal subtraction(final BigDecimal value1, final long value2) {
		return subtraction(value1, toBigDecimal(value2));
	}

	public static BigDecimal subtraction(final long value1, final BigDecimal value2) {
		return subtraction(toBigDecimal(value1), value2);
	}

	public static BigDecimal subtraction(final BigDecimal value1, final BigDecimal... values) {
		BigDecimal result = value1;
		for (BigDecimal value : values) {
			result = subtraction(result, value);
		}
		return result;
	}

	// Multiplication

	public static BigDecimal multiplication(final BigDecimal value1, final BigDecimal value2) {
		return value1.multiply(value2);
	}

	public static BigDecimal multiplication(final BigDecimal value1, final int value2) {
		return multiplication(value1, toBigDecimal(value2));
	}

	public static BigDecimal multiplication(final int value1, final BigDecimal value2) {
		return multiplication(toBigDecimal(value1), value2);
	}

	public static BigDecimal multiplication(final BigDecimal value1, final long value2) {
		return multiplication(value1, toBigDecimal(value2));
	}

	public static BigDecimal multiplication(final long value1, final BigDecimal value2) {
		return multiplication(toBigDecimal(value1), value2);
	}

	public static BigDecimal multiplication(final BigDecimal value1, final BigDecimal... values) {
		BigDecimal result = value1;
		for (BigDecimal value : values) {
			result = multiplication(result, value);
		}
		return result;
	}

	// Division

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide a scale (number of decimals places) and a RoundingMode
	 */
	public static BigDecimal division(final BigDecimal value1, final BigDecimal value2, final int scale, final RoundingMode roundingMode) {
		return value1.divide(value2, scale, roundingMode);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide a scale (number of decimals places) and a RoundingMode
	 */
	public static BigDecimal division(final BigDecimal value1, final int value2, final int scale, final RoundingMode roundingMode) {
		return division(value1, toBigDecimal(value2), scale, roundingMode);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide a scale (number of decimals places) and a RoundingMode
	 */
	public static BigDecimal division(final int value1, final BigDecimal value2, final int scale, final RoundingMode roundingMode) {
		return division(toBigDecimal(value1), value2, scale, roundingMode);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide a scale (number of decimals places) and a RoundingMode
	 */
	public static BigDecimal division(final BigDecimal value1, final long value2, final int scale, final RoundingMode roundingMode) {
		return division(value1, toBigDecimal(value2), scale, roundingMode);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide a scale (number of decimals places) and a RoundingMode
	 */
	public static BigDecimal division(final long value1, final BigDecimal value2, final int scale, final RoundingMode roundingMode) {
		return division(toBigDecimal(value1), value2, scale, roundingMode);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide a scale (number of decimals places) and a RoundingMode
	 */
	public static BigDecimal division(final int value1, final long value2, final int scale, final RoundingMode roundingMode) {
		return division(toBigDecimal(value1), toBigDecimal(value2), scale, roundingMode);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide a scale (number of decimals places) and a RoundingMode
	 */
	public static BigDecimal division(final long value1, final int value2, final int scale, final RoundingMode roundingMode) {
		return division(toBigDecimal(value1), toBigDecimal(value2), scale, roundingMode);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide a scale (number of decimals places) and a RoundingMode
	 */
	public static BigDecimal division(final long value1, final long value2, final int scale, final RoundingMode roundingMode) {
		return division(toBigDecimal(value1), toBigDecimal(value2), scale, roundingMode);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide a scale (number of decimals places) and a RoundingMode
	 */
	public static BigDecimal division(final int value1, final int value2, final int scale, final RoundingMode roundingMode) {
		return division(toBigDecimal(value1), toBigDecimal(value2), scale, roundingMode);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide a scale (number of decimals places).
	 * The result will be truncated using {@link NumberUtils#truncate()}
	 */
	public static BigDecimal division(final BigDecimal value1, final BigDecimal value2, final int scale) {
		return division(value1, value2, scale, RoundingMode.DOWN);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide a scale (number of decimals places).
	 * The result will be truncated using {@link NumberUtils#truncate()}
	 */
	public static BigDecimal division(final BigDecimal value1, final int value2, final int scale) {
		return division(value1, toBigDecimal(value2), scale);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide a scale (number of decimals places).
	 * The result will be truncated using {@link NumberUtils#truncate()}
	 */
	public static BigDecimal division(final int value1, final BigDecimal value2, final int scale) {
		return division(toBigDecimal(value1), value2, scale);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide a scale (number of decimals places).
	 * The result will be truncated using {@link NumberUtils#truncate()}
	 */
	public static BigDecimal division(final BigDecimal value1, final long value2, final int scale) {
		return division(value1, toBigDecimal(value2), scale);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide a scale (number of decimals places).
	 * The result will be truncated using {@link NumberUtils#truncate()}
	 */
	public static BigDecimal division(final long value1, final BigDecimal value2, final int scale) {
		return division(toBigDecimal(value1), value2, scale);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide a scale (number of decimals places).
	 * The result will be truncated using {@link NumberUtils#truncate()}
	 */
	public static BigDecimal division(final int value1, final long value2, final int scale) {
		return division(toBigDecimal(value1), toBigDecimal(value2), scale);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide a scale (number of decimals places).
	 * The result will be truncated using {@link NumberUtils#truncate()}
	 */
	public static BigDecimal division(final long value1, final int value2, final int scale) {
		return division(toBigDecimal(value1), toBigDecimal(value2), scale);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide a scale (number of decimals places).
	 * The result will be truncated using {@link NumberUtils#truncate()}
	 */
	public static BigDecimal division(final long value1, final long value2, final int scale) {
		return division(toBigDecimal(value1), toBigDecimal(value2), scale);
	}

	/**
	 * In order to avoid <b>ArithmeticException</b> caused by quotient with a nonterminating decimal expansion
	 * please provide a scale (number of decimals places). 
	 * The result will be truncated using {@link NumberUtils#truncate()}
	 */
	public static BigDecimal division(final int value1, final int value2, final int scale) {
		return division(toBigDecimal(value1), toBigDecimal(value2), scale);
	}

	// POW 
	
	public static BigDecimal pow(final BigDecimal base, final int power) {
		return base.pow(power);
	}

	// COMPARATORS

	public static boolean isEquals(final BigDecimal left, final BigDecimal right) {
		return compareTo(left, right) == 0;
	}

	public static boolean isEquals(final BigDecimal left, final int right) {
		return compareTo(left, right) == 0;
	}

	public static boolean isEquals(final int left, final BigDecimal right) {
		return compareTo(left, right) == 0;
	}

	public static boolean isEquals(final BigDecimal left, final long right) {
		return compareTo(left, right) == 0;
	}

	public static boolean isEquals(final long left, final BigDecimal right) {
		return compareTo(left, right) == 0;
	}

	public static boolean isNotEquals(final BigDecimal left, final BigDecimal right) {
		return compareTo(left, right) != 0;
	}

	public static boolean isNotEquals(final BigDecimal left, final int right) {
		return compareTo(left, right) != 0;
	}

	public static boolean isNotEquals(final int left, final BigDecimal right) {
		return compareTo(left, right) != 0;
	}

	public static boolean isNotEquals(final BigDecimal left, final long right) {
		return compareTo(left, right) != 0;
	}

	public static boolean isNotEquals(final long left, final BigDecimal right) {
		return compareTo(left, right) != 0;
	}

	public static boolean isLessThan(final BigDecimal left, final BigDecimal right) {
		return compareTo(left, right) < 0;
	}

	public static boolean isLessThan(final BigDecimal left, final int right) {
		return compareTo(left, right) < 0;
	}

	public static boolean isLessThan(final int left, final BigDecimal right) {
		return compareTo(left, right) < 0;
	}

	public static boolean isLessThan(final BigDecimal left, final long right) {
		return compareTo(left, right) < 0;
	}

	public static boolean isLessThan(final long left, final BigDecimal right) {
		return compareTo(left, right) < 0;
	}

	public static boolean isLessOrEqualThan(final BigDecimal left, final BigDecimal right) {
		return compareTo(left, right) <= 0;
	}

	public static boolean isLessOrEqualThan(final BigDecimal left, final int right) {
		return compareTo(left, right) <= 0;
	}

	public static boolean isLessOrEqualThan(final int left, final BigDecimal right) {
		return compareTo(left, right) <= 0;
	}

	public static boolean isLessOrEqualThan(final BigDecimal left, final long right) {
		return compareTo(left, right) <= 0;
	}

	public static boolean isLessOrEqualThan(final long left, final BigDecimal right) {
		return compareTo(left, right) <= 0;
	}

	public static boolean isGreaterThan(final BigDecimal left, final BigDecimal right) {
		return compareTo(left, right) > 0;
	}

	public static boolean isGreaterThan(final BigDecimal left, final int right) {
		return compareTo(left, right) > 0;
	}

	public static boolean isGreaterThan(final int left, final BigDecimal right) {
		return compareTo(left, right) > 0;
	}

	public static boolean isGreaterThan(final BigDecimal left, final long right) {
		return compareTo(left, right) > 0;
	}

	public static boolean isGreaterThan(final long left, final BigDecimal right) {
		return compareTo(left, right) > 0;
	}

	public static boolean isGreaterOrEqualThan(final BigDecimal left, final BigDecimal right) {
		return compareTo(left, right) >= 0;
	}

	public static boolean isGreaterOrEqualThan(final BigDecimal left, final int right) {
		return compareTo(left, right) >= 0;
	}

	public static boolean isGreaterOrEqualThan(final int left, final BigDecimal right) {
		return compareTo(left, right) >= 0;
	}

	public static boolean isGreaterOrEqualThan(final BigDecimal left, final long right) {
		return compareTo(left, right) >= 0;
	}

	public static boolean isGreaterOrEqualThan(final long left, final BigDecimal right) {
		return compareTo(left, right) >= 0;
	}

	// COMPARATORS FOR 0 AS FACILITY

	public static boolean isEqualsToZERO(final BigDecimal value) {
		return isEquals(value, ZERO);
	}

	public static boolean isNotEqualsToZERO(final BigDecimal value) {
		return isNotEquals(value, ZERO);
	}

	public static boolean isGreaterThanZERO(final BigDecimal value) {
		return isGreaterThan(value, ZERO);
	}

	public static boolean isGreaterOrEqualThanZERO(final BigDecimal value) {
		return isGreaterOrEqualThan(value, ZERO);
	}

	public static boolean isLessThanZERO(final BigDecimal value) {
		return isLessThan(value, ZERO);
	}

	public static boolean isLessOrEqualThanZERO(final BigDecimal value) {
		return isLessOrEqualThan(value, ZERO);
	}

	// COMPARE TO

	private static int compareTo(final BigDecimal left, final BigDecimal right) {
		return left.compareTo(right);
	}

	private static int compareTo(final BigDecimal left, final int right) {
		return left.compareTo(toBigDecimal(right));
	}

	private static int compareTo(final int left, final BigDecimal right) {
		return toBigDecimal(left).compareTo(right);
	}

	private static int compareTo(final BigDecimal left, final long right) {
		return left.compareTo(toBigDecimal(right));
	}

	private static int compareTo(final long left, final BigDecimal right) {
		return toBigDecimal(left).compareTo(right);
	}

}
