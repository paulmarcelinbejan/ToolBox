package com.paulmarcelinbejan.architecture.utils.math;

import static com.paulmarcelinbejan.architecture.utils.math.enums.NumberFormatPattern.DECIMALS_ALWAYS;
import static com.paulmarcelinbejan.architecture.utils.math.enums.NumberFormatPattern.DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT;
import static com.paulmarcelinbejan.architecture.utils.math.enums.NumberFormatPattern.DECIMALS_IF_PRESENT;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class NumberFormatUtilsTest {

	@Test
	void toBigDecimal() {
		String number = "123.456";
		BigDecimal numberBD = NumberFormatUtils.toBigDecimal(number);
		
		assertTrue(NumberUtils.isEquals(numberBD, NumberUtils.toBigDecimal(number)));
	}
	
	@Test
	void toBigDecimalWithDecimalSeparator() {
		String number = "123,456";
		assertDoesNotThrow(() -> NumberFormatUtils.toBigDecimal(number, ','));
	}
	
	@Test
	void toBigDecimalWithDecimalSeparatorAndGroupingSeparator() {
		String number = "123.456,789";
		assertDoesNotThrow(() -> NumberFormatUtils.toBigDecimal(number, ',', '.'));
		
		String invalidNumber = "123.456.789";
		assertThrows(IllegalArgumentException.class, () -> NumberFormatUtils.toBigDecimal(invalidNumber, '.', '.'));
	}
	
	@Test
	void _toString() {
		BigDecimal number = NumberUtils.toBigDecimal("123.456");
		assertDoesNotThrow(() -> NumberFormatUtils.toString(number));
	}
	
	@Test
	void _toString_INVALID_SCALE() {
		BigDecimal number1 = NumberUtils.toBigDecimal("123.456");
		assertThrows(IllegalArgumentException.class, () -> NumberFormatUtils.toString(number1, -1, ',', '.', DECIMALS_ALWAYS));
		
		BigDecimal number2 = NumberUtils.toBigDecimal("123.456");
		assertThrows(IllegalArgumentException.class, () -> NumberFormatUtils.toString(number2, 4, -2, ',', '.', DECIMALS_ALWAYS));
		
		BigDecimal number3 = NumberUtils.toBigDecimal("123.456");
		assertThrows(IllegalArgumentException.class, () -> NumberFormatUtils.toString(number3, 3, 5, ',', '.', DECIMALS_ALWAYS));
	}
	
	@Test
	void _toString_DECIMALS_ALWAYS() {
		String expected1 = "123.456";
		BigDecimal number1 = NumberUtils.toBigDecimal("123.456");
		String actual1 = NumberFormatUtils.toString(number1, 3, DECIMALS_ALWAYS);
		assertEquals(expected1, actual1);
		
		String expected2 = "123,456";
		BigDecimal number2 = NumberUtils.toBigDecimal("123.456");
		String actual2 = NumberFormatUtils.toString(number2, 3, ',', DECIMALS_ALWAYS);
		assertEquals(expected2, actual2);
		
		String expected3 = "123.456,789";
		BigDecimal number3 = NumberUtils.toBigDecimal("123456.789");
		String actual3 = NumberFormatUtils.toString(number3, 3, ',', '.', DECIMALS_ALWAYS);
		assertEquals(expected3, actual3);
	}
	
	@Test
	void _toString_DECIMALS_IF_PRESENT() {
		String expected1 = "123.45";
		BigDecimal number1 = NumberUtils.toBigDecimal("123.450");
		String actual1 = NumberFormatUtils.toString(number1, 3, DECIMALS_IF_PRESENT);
		assertEquals(expected1, actual1);
		
		String expected2 = "123,45";
		BigDecimal number2 = NumberUtils.toBigDecimal("123.450");
		String actual2 = NumberFormatUtils.toString(number2, 3, ',', DECIMALS_IF_PRESENT);
		assertEquals(expected2, actual2);
		
		String expected3 = "123.456,78";
		BigDecimal number3 = NumberUtils.toBigDecimal("123456.780");
		String actual3 = NumberFormatUtils.toString(number3, 3, ',', '.', DECIMALS_IF_PRESENT);
		assertEquals(expected3, actual3);
	}
	
	@Test
	void _toString_DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT() {
		String expected1 = "123.40";
		BigDecimal number1 = NumberUtils.toBigDecimal("123.4009");
		String actual1 = NumberFormatUtils.toString(number1, 3, 2, DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT);
		assertEquals(expected1, actual1);
		
		String expected2 = "123,456";
		BigDecimal number2 = NumberUtils.toBigDecimal("123.45607");
		String actual2 = NumberFormatUtils.toString(number2, 3, 2, ',', DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT);
		assertEquals(expected2, actual2);
		
		String expected3 = "123.456,001";
		BigDecimal number3 = NumberUtils.toBigDecimal("123456.001006");
		String actual3 = NumberFormatUtils.toString(number3, 5, 2, ',', '.', DECIMALS_FIRST_PART_ALWAYS_SECOND_PART_IF_PRESENT);
		assertEquals(expected3, actual3);
	}
	
}
