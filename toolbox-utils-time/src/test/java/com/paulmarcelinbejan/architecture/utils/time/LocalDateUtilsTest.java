package com.paulmarcelinbejan.architecture.utils.time;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;

class LocalDateUtilsTest {

	@Test
	void test() {
		LocalDate _10_10_2023 =LocalDate.of(2023, 10, 10);
		System.out.println(_10_10_2023);
		ZonedDateTime rome_10_10_2023 = _10_10_2023.atStartOfDay(ZoneId.of("Europe/Rome"));
		System.out.println(rome_10_10_2023);
		ZonedDateTime tokyo_10_10_2023 = _10_10_2023.atStartOfDay(ZoneId.of("Asia/Tokyo"));
		System.out.println(tokyo_10_10_2023);
	}
	
}
