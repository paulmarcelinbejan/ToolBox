package com.paulmarcelinbejan.architecture.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.paulmarcelinbejan.architecture.test.entities.Car;
import com.paulmarcelinbejan.architecture.test.entities.Manufacturer;

class AssertDeepEquals_Test extends AbstractTest {

	@Test
	void deepEqualsTrue() {

		Manufacturer ferrari = new Manufacturer("Ferrari", LocalDate.of(1947, 3, 12), "Maranello");
		Car ferrari_308GTB = new Car(ferrari, "308 GTB", 2, 255, LocalDate.of(1976, 1, 1));
		
		Manufacturer ferrari_same_value = new Manufacturer("Ferrari", LocalDate.of(1947, 3, 12), "Maranello");
		Car ferrari_308GTB_same_value = new Car(ferrari_same_value, "308 GTB", 2, 255, LocalDate.of(1976, 1, 1));
		
		System.out.println(ferrari_308GTB);
		System.out.println("---");
		System.out.println(ferrari_308GTB_same_value);
		
		assertDeepEquals(ferrari_308GTB, ferrari_308GTB_same_value);
		
	}
	
	@Test
	void deepEqualsFalse() {
		
		Manufacturer ferrari = new Manufacturer("Alfa Romeo", LocalDate.of(1947, 3, 12), "Maranello");
		Car ferrari_308GTB = new Car(ferrari, "308 GTB", 2, 255, LocalDate.of(1976, 1, 1));
		
		Manufacturer ferrari_different_value = new Manufacturer("Ferrari", LocalDate.of(1947, 3, 12), "Maranello");
		Car ferrari_308GTB_different_value = new Car(ferrari_different_value, "308 GTB", 2, 255, LocalDate.of(1976, 1, 1));
		
		System.out.println(ferrari_308GTB);
		System.out.println("---");
		System.out.println(ferrari_308GTB_different_value);
		
		try {
			assertDeepEquals(ferrari_308GTB, ferrari_308GTB_different_value);
		} catch (AssertionError e) {
			assertNotNull(e);
		}
		
	}
	
}
