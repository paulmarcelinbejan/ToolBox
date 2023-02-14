package com.paulmarcelinbejan.architecture.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.paulmarcelinbejan.architecture.test.entities.Car;

class BuildObject_Test extends AbstractTest {

	@Test
	void testBuildObject() {

		Car car = buildObject(Car.class);
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
