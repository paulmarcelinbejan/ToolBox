package com.paulmarcelinbejan.architecture.test.entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Car {

	private Manufacturer manufacturer;
	
	private String model;
	
	private int numberOfSeats;
	
	private int horsePower;
	
	private LocalDate registrationDate;
	
}
