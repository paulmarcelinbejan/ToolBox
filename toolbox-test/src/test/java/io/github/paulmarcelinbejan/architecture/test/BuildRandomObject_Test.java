package io.github.paulmarcelinbejan.architecture.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import io.github.paulmarcelinbejan.architecture.test.entities.Car;
import io.github.paulmarcelinbejan.toolbox.test.TestUtils;

class BuildRandomObject_Test {

	@Test
	void testBuildObject() {

		Car car = TestUtils.buildRandomObject(Car.class);
		System.out.println(car);
		
		assertNotNull(car.getManufacturer());
		assertNotNull(car.getModel());
		assertNotNull(car.getRegistrationDate());
		
	}
	
	//TODO
	@Test
	void testBuildObjectCustom() {
		
	}
	
}
