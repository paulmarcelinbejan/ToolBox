package com.paulmarcelinbejan.architecture.utils.time.pattern.date.literal;

import com.paulmarcelinbejan.architecture.utils.time.pattern.date.DatePattern;

public enum DatePatternLiteralDotSeparator implements DatePattern  {
	
	dMMMyyyy("d.MMM.yyyy"),
	
	ddMMMyyyy("dd.MMM.yyyy"),
	
	dMMMMyyyy("d.MMMM.yyyy"),
	
	ddMMMMyyyy("dd.MMMM.yyyy"),
	
	yyyyMMMd("yyyy.MMM.d"),
	
	yyyyMMMdd("yyyy.MMM.dd"),
	
	yyyyMMMMd("yyyy.MMMM.d"),
	
	yyyyMMMMdd("yyyy.MMMM.dd"),
	
	MMMdyyyy("MMM.d.yyyy"),
	
	MMMddyyyy("MMM.dd.yyyy"),
	
	MMMMdyyyy("MMMM.d.yyyy"),
	
	MMMMddyyyy("MMMM.dd.yyyy");
	
	public final String value;

    private DatePatternLiteralDotSeparator(String value) {
    	this.value = value;
    }
    
}
