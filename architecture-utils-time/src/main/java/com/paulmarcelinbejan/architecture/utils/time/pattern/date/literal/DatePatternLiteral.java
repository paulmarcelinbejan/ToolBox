package com.paulmarcelinbejan.architecture.utils.time.pattern.date.literal;

import com.paulmarcelinbejan.architecture.utils.time.pattern.date.DatePattern;

public enum DatePatternLiteral implements DatePattern {
	
	EEEdMMM("EEE d MMM"),

	EEEddMMM("EEE dd MMM"),
	
	EEEdMMMyyyy("EEE d MMM yyyy"),
	
	EEEddMMMyyyy("EEE dd MMM yyyy"),
	
	EEEdMMMM("EEE d MMMM"),
	
	EEEddMMMM("EEE dd MMMM"),

	EEEdMMMMyyyy("EEE d MMMM yyyy"),

	EEEddMMMMyyyy("EEE dd MMMM yyyy"),
	
	EEEEdMMM("EEEE d MMM"),
	
	EEEEddMMM("EEEE dd MMM"),

	EEEEdMMMyyyy("EEEE d MMM yyyy"),

	EEEEddMMMyyyy("EEEE dd MMM yyyy"),
	
	EEEEdMMMM("EEEE d MMMM"),

	EEEEddMMMM("EEEE dd MMMM"),

	EEEEdMMMMyyyy("EEEE d MMMM yyyy"),

	EEEEddMMMMyyyy("EEEE dd MMMM yyyy");
	
	public final String value;

    private DatePatternLiteral(String value) {
    	this.value = value;
    }
    
}
