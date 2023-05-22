package com.paulmarcelinbejan.toolbox.utils.text;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TextUtils {

	public static boolean areEquals(String left, String right) {
		return compareTo(left, right) == 0;
	}

	public static boolean areNotEquals(String left, String right) {
		return compareTo(left, right) != 0;
	}

	public static boolean isLessThan(String left, String right) {
		return compareTo(left, right) < 0;
	}

	public static boolean isLessThanOrEqualTo(String left, String right) {
		return compareTo(left, right) <= 0;
	}

	public static boolean isGreaterThan(String left, String right) {
		return compareTo(left, right) > 0;
	}

	public static boolean isGreaterThanOrEqualTo(String left, String right) {
		return compareTo(left, right) >= 0;
	}

	private static int compareTo(String left, String right) {
		return left.compareTo(right);
	}

}
