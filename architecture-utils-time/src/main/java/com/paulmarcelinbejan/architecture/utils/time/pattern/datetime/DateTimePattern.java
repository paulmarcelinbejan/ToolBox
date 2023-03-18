package com.paulmarcelinbejan.architecture.utils.time.pattern.datetime;

import java.time.format.DateTimeFormatter;

import com.paulmarcelinbejan.architecture.utils.time.pattern.DateTimePatternBase;

import lombok.Getter;

/**
 * DateTimePattern
 *
 * Just a few, you can build a large number of DateTimePattern by combining a DatePattern with a TimePattern.
 * Use {@link DateTimeFormatUtils#buildPattern()} to create patterns with date and time.
 */
public enum DateTimePattern implements DateTimePatternBase {

	/**
	 * For example: "Thu, Sep 29, 2022 13:45:30 UTC"
	 */
	EEEMMMdyyyyhmmssaz("EEE, MMM d, yyyy HH:mm:ss z"),
	
	/**
	 * For example: "Tuesday, August 23, 2016 1:12:45 PM EEST"
	 */
	EEEEMMMMdyyyyhmmssaz("EEEE, MMMM d, yyyy h:mm:ss a z"),
	
	/**
	 * For example: "Thursday, March 17, 2023 2:30:45 PM EST"
	 */
	EEEEMMMMdyyyyhmmssazzz("EEEE, MMMM d, yyyy h:mm:ss A zzz"),
	
	/**
	 * For example: "Thu Mar 17 14:45:30 EDT 2023"
	 */
	EEEMMMddHHmmsszzzyyyy("EEE MMM dd HH:mm:ss zzz yyyy"),
	
	/**
	 * For example: "Jun 09 2018 15:28:14"
	 */
	MMMddyyyyHHmmss("MMM dd yyyy HH:mm:ss");
	
	/**
	 * The pattern value of the enum;
	 */
	@Getter
	public final String value;

	/**
     * Configured formatter for the specified pattern.
     * The formatter is not localized!
     */
	@Getter
	public final DateTimeFormatter formatter;
	
    private DateTimePattern(String value) {
    	this.value = value;
    	this.formatter = DateTimeFormatter.ofPattern(value);
    }
    
    // Too much work to create all possible combination of DatePattern with TimePattern.
    // Use the LocalDateTimeFormatUtils#buildPattern() to combine patterns.
    
//    enum Literal {
//    	
//    	;
//    	
//    	enum TimeWith12HourClockFormat {
//    		
//    		;
//    		
//    		enum DateWithDotSeparator {
//    			
//    		}
//    		
//    		enum DateWithHyphenSeparator {
//    			
//    		}
//    		
//    		enum DateWithSlashSeparator {
//    			
//    		}
//    		
//    		enum DateWithSpaceSeparator {
//    			
//    		}
//    		
//			enum DateFull {
//    			
//    		}
//    		
//    	}
//    	
//    	enum TimeWith24HourClockFormat {
//    		
//    		;
//    		
//    		enum DateWithDotSeparator {
//    			
//    		}
//    		
//    		enum DateWithHyphenSeparator {
//    			
//    		}
//    		
//    		enum DateWithSlashSeparator {
//    			
//    		}
//    		
//    		enum DateWithSpaceSeparator {
//    			
//    		}
//    		
//    		enum DateFull {
//    			
//    		}
//    		
//    	}
//    	
//    }
//    
//    enum Numeric {
//    	
//    	;
//    	
//    	enum TimeWith12HourClockFormat {
//    		
//    		;
//    		
//    		enum DateWithDotSeparator {
//    			
//    		}
//    		
//    		enum DateWithHyphenSeparator {
//    			
//    		}
//    		
//    		enum DateWithSlashSeparator {
//    			
//    		}
//    		
//    		enum DateWithSpaceSeparator {
//    			
//    		}
//    		
//    	}
//    	
//    	enum TimeWith24HourClockFormat {
//    		
//    		;
//    		
//    		enum DateWithDotSeparator {
//    			
//    		}
//    		
//    		enum DateWithHyphenSeparator {
//    			
//    		}
//    		
//    		enum DateWithSlashSeparator {
//    			
//    		}
//    		
//    		enum DateWithSpaceSeparator {
//    			
//    		}
//    		
//    	}
//    	
//    }
    
}
