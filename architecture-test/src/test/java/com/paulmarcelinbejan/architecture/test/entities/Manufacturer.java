package com.paulmarcelinbejan.architecture.test.entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Manufacturer {

	private String name;
	
	private LocalDate foundation;
	
	private String headquarters;
	
}
