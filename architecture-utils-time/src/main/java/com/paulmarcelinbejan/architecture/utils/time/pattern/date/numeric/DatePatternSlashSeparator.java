package com.paulmarcelinbejan.architecture.utils.time.pattern.date.numeric;

import com.paulmarcelinbejan.architecture.utils.time.pattern.date.DatePattern;

public enum DatePatternSlashSeparator implements DatePattern {

	/**
	 * 1/1/2023
	 */
	dMyyyy("d/M/yyyy"),
	
	/**
	 * 1/01/2023
	 */
	dMMyyyy("d/MM/yyyy"),
	
	/**
	 * 01/1/2023
	 */
	ddMyyyy("dd/M/yyyy"),
	
	/**
	 * 31/12/2023
	 */
	ddMMyyyy("dd/MM/yyyy"),
	
	/**
	 * 2023/1/1
	 */
	yyyyMd("yyyy/M/d"),
	
	/**
	 * 2023/01/1
	 */
	yyyyMMd("yyyy/MM/d"),
	
	/**
	 * 2023/1/01
	 */
	yyyyMdd("yyyy/M/dd"),
	
	/**
	 * 2023/12/31
	 */
	yyyyMMdd("yyyy/MM/dd"),
	
	/**
	 * 1/1/2023
	 */
	Mdyyyy("M/d/yyyy"),
	
	/**
	 * 01/1/2023
	 */
	MMdyyyy("MM/d/yyyy"),
	
	/**
	 * 1/01/2023
	 */
	Mddyyyy("M/dd/yyyy"),
	
	/**
	 * 12/31/2023
	 */
	MMddyyyy("MM/dd/yyyy");
	
	public final String value;

    private DatePatternSlashSeparator(String value) {
    	this.value = value;
    }
    
}
