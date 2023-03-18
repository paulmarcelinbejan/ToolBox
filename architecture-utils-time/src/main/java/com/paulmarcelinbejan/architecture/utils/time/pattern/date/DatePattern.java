package com.paulmarcelinbejan.architecture.utils.time.pattern.date;

import java.time.format.DateTimeFormatter;

import com.paulmarcelinbejan.architecture.utils.time.pattern.DatePatternBase;

import lombok.Getter;

/**
 * Date Pattern
 */
public enum DatePattern {
	
	;
	
	/**
	 * Date Pattern containing the month written in letters
	 */
	enum Literal {
	
		;
		
		/**
		 *  Date Pattern containing the month written in letters, each date element is separated by a DOT
		 */
		enum WithDotSeparator implements DatePatternBase {
			
			/**
		     * The pattern for day without leading zero, abbreviated month name, and year.
		     * For example: "1.Jan.2023"
		     */
			dMMMyyyy("d.MMM.yyyy"),
			
			/**
		     * The pattern for day with leading zero, abbreviated month name, and year.
		     * For example: "01.Jan.2023"
		     */
			ddMMMyyyy("dd.MMM.yyyy"),
			
		    /**
		     * The pattern for day without leading zero, full month name, and year.
		     * For example: "1.January.2023"
		     */
			dMMMMyyyy("d.MMMM.yyyy"),
			
			/**
		     * The pattern for day with leading zero, full month name, and year.
		     * For example: "01.January.2023"
		     */
			ddMMMMyyyy("dd.MMMM.yyyy"),
			
			/**
		     * The pattern for year, abbreviated month name, and day without leading zero.
		     * For example: "2023.Jan.1"
		     */
			yyyyMMMd("yyyy.MMM.d"),
			
			/**
		     * The pattern for year, abbreviated month name, and day with leading zero.
		     * For example: "2023.Jan.01"
		     */
			yyyyMMMdd("yyyy.MMM.dd"),
			
			/**
		     * The pattern for year, full month name, and day without leading zero.
		     * For example: "2023.January.1"
		     */
			yyyyMMMMd("yyyy.MMMM.d"),
			
			/**
		     * The pattern for year, full month name, and day with leading zero.
		     * For example: "2023.January.01"
		     */
			yyyyMMMMdd("yyyy.MMMM.dd"),
			
			/**
		     * The pattern for abbreviated month name, day without leading zero, and year.
		     * For example: "Jan.1.2023"
		     */
			MMMdyyyy("MMM.d.yyyy"),
			
			/**
		     * The pattern for abbreviated month name, day with leading zero, and year.
		     * For example: "Jan.01.2023"
		     */
			MMMddyyyy("MMM.dd.yyyy"),
			
			/**
		     * The pattern for full month name, day without leading zero, and year.
		     * For example: "January.1.2023"
		     */
			MMMMdyyyy("MMMM.d.yyyy"),
			
			/**
		     * The pattern for full month name, day with leading zero, and year.
		     * For example: "January.01.2023"
		     */
			MMMMddyyyy("MMMM.dd.yyyy");
			
			/**
			 * The pattern value of the enum;
			 */
			@Getter
		    public final String value;

		    /**
		     * Configured formatter for the specified pattern
		     */
			@Getter
		    public final DateTimeFormatter formatter;
			
		    private WithDotSeparator(String value) {
		    	this.value = value;
		    	this.formatter = DateTimeFormatter.ofPattern(value);
		    }
		    
		}
		
		/**
		 *  Date Pattern containing the month written in letters, each date element is separated by a HYPHEN
		 */
		enum WithHyphenSeparator implements DatePatternBase {
			
			/**
		     * The pattern for day without leading zero, abbreviated month name, and year.
		     * For example: "1-Jan-2023"
		     */
			dMMMyyyy("d-MMM-yyyy"),
			
			/**
		     * The pattern for day with leading zero, abbreviated month name, and year.
		     * For example: "01-Jan-2023"
		     */
			ddMMMyyyy("dd-MMM-yyyy"),
			
			/**
		     * The pattern for day without leading zero, full month name, and year.
		     * For example: "1-January-2023"
		     */
			dMMMMyyyy("d-MMMM-yyyy"),
			
			/**
		     * The pattern for day with leading zero, full month name, and year.
		     * For example: "01-January-2023"
		     */
			ddMMMMyyyy("dd-MMMM-yyyy"),
			
			/**
		     * The pattern for year, abbreviated month name, and day without leading zero.
		     * For example: "2023-Jan-1"
		     */
			yyyyMMMd("yyyy-MMM-d"),
			
			/**
		     * The pattern for year, abbreviated month name, and day with leading zero.
		     * For example: "2023-Jan-01"
		     */
			yyyyMMMdd("yyyy-MMM-dd"),
			
			/**
		     * The pattern for year, full month name, and day without leading zero.
		     * For example: "2023-January-1"
		     */
			yyyyMMMMd("yyyy-MMMM-d"),
			
			/**
		     * The pattern for year, full month name, and day with leading zero.
		     * For example: "2023-January-01"
		     */
			yyyyMMMMdd("yyyy-MMMM-dd"),
			
			/**
		     * The pattern for abbreviated month name, day without leading zero, and year.
		     * For example: "Jan-1-2023"
		     */
			MMMdyyyy("MMM-d-yyyy"),
			
			/**
		     * The pattern for abbreviated month name, day with leading zero, and year.
		     * For example: "Jan-01-2023"
		     */
			MMMddyyyy("MMM-dd-yyyy"),
			
			/**
		     * The pattern for full month name, day without leading zero, and year.
		     * For example: "January-1-2023"
		     */
			MMMMdyyyy("MMMM-d-yyyy"),
			
			/**
		     * The pattern for full month name, day with leading zero, and year.
		     * For example: "January-01-2023"
		     */
			MMMMddyyyy("MMMM-dd-yyyy");
			
			/**
			 * The pattern value of the enum;
			 */
			@Getter
		    public final String value;

		    /**
		     * Configured formatter for the specified pattern
		     */
			@Getter
		    public final DateTimeFormatter formatter;
			
		    private WithHyphenSeparator(String value) {
		    	this.value = value;
		    	this.formatter = DateTimeFormatter.ofPattern(value);
		    }
		    
		}
		
		/**
		 *  Date Pattern containing the month written in letters, each date element is separated by a SLASH
		 */
		enum WithSlashSeparator implements DatePatternBase {
			
			/**
		     * The pattern for day without leading zero, abbreviated month name, and year.
		     * For example: "1/Jan/2023"
		     */
			dMMMyyyy("d/MMM/yyyy"),
			
			/**
		     * The pattern for day with leading zero, abbreviated month name, and year.
		     * For example: "01/Jan/2023"
		     */
			ddMMMyyyy("dd/MMM/yyyy"),
			
			/**
		     * The pattern for day without leading zero, full month name, and year.
		     * For example: "1/January/2023"
		     */
			dMMMMyyyy("d/MMMM/yyyy"),
			
			/**
		     * The pattern for day with leading zero, full month name, and year.
		     * For example: "01/January/2023"
		     */
			ddMMMMyyyy("dd/MMMM/yyyy"),
			
			/**
		     * The pattern for year, abbreviated month name, and day without leading zero.
		     * For example: "2023/Jan/1"
		     */
			yyyyMMMd("yyyy/MMM/d"),
			
			/**
		     * The pattern for year, abbreviated month name, and day with leading zero.
		     * For example: "2023/Jan/01"
		     */
			yyyyMMMdd("yyyy/MMM/dd"),
			
			/**
		     * The pattern for year, full month name, and day without leading zero.
		     * For example: "2023/January/1"
		     */
			yyyyMMMMd("yyyy/MMMM/d"),
			
			/**
		     * The pattern for year, full month name, and day with leading zero.
		     * For example: "2023/January/01"
		     */
			yyyyMMMMdd("yyyy/MMMM/dd"),
			
			/**
		     * The pattern for abbreviated month name, day without leading zero, and year.
		     * For example: "Jan/1/2023"
		     */
			MMMdyyyy("MMM/d/yyyy"),
			
			/**
		     * The pattern for abbreviated month name, day with leading zero, and year.
		     * For example: "Jan/01/2023"
		     */
			MMMddyyyy("MMM/dd/yyyy"),
			
			/**
		     * The pattern for full month name, day without leading zero, and year.
		     * For example: "January/1/2023"
		     */
			MMMMdyyyy("MMMM/d/yyyy"),
			
			/**
		     * The pattern for full month name, day with leading zero, and year.
		     * For example: "January/01/2023"
		     */
			MMMMddyyyy("MMMM/dd/yyyy");
			
			/**
			 * The pattern value of the enum;
			 */
			@Getter
		    public final String value;

		    /**
		     * Configured formatter for the specified pattern
		     */
			@Getter
		    public final DateTimeFormatter formatter;
			
		    private WithSlashSeparator(String value) {
		    	this.value = value;
		    	this.formatter = DateTimeFormatter.ofPattern(value);
		    }
		    
		}
		
		/**
		 *  Date Pattern containing the month written in letters, each date element is separated by a SPACE
		 */
		enum WithSpaceSeparator implements DatePatternBase {
			
			/**
		     * The pattern for day without leading zero, abbreviated month name, and year.
		     * For example: "1 Jan 2023"
		     */
			dMMMyyyy("d MMM yyyy"),
			
			/**
		     * The pattern for day with leading zero, abbreviated month name, and year.
		     * For example: "01 Jan 2023"
		     */
			ddMMMyyyy("dd MMM yyyy"),
			
			/**
		     * The pattern for day without leading zero, full month name, and year.
		     * For example: "1 January 2023"
		     */
			dMMMMyyyy("d MMMM yyyy"),
			
			/**
		     * The pattern for day with leading zero, full month name, and year.
		     * For example: "01 January 2023"
		     */
			ddMMMMyyyy("dd MMMM yyyy"),
			
			/**
		     * The pattern for year, abbreviated month name, and day without leading zero.
		     * For example: "2023 Jan 1"
		     */
			yyyyMMMd("yyyy MMM d"),
			
			/**
		     * The pattern for year, abbreviated month name, and day with leading zero.
		     * For example: "2023 Jan 01"
		     */
			yyyyMMMdd("yyyy MMM dd"),
			
			/**
		     * The pattern for year, full month name, and day without leading zero.
		     * For example: "2023 January 1"
		     */
			yyyyMMMMd("yyyy MMMM d"),
			
			/**
		     * The pattern for year, full month name, and day with leading zero.
		     * For example: "2023 January 01"
		     */
			yyyyMMMMdd("yyyy MMMM dd"),
			
			/**
		     * The pattern for abbreviated month name, day without leading zero, and year.
		     * For example: "Jan 1 2023"
		     */
			MMMdyyyy("MMM d yyyy"),
			
			/**
		     * The pattern for abbreviated month name, day with leading zero, and year.
		     * For example: "Jan 01 2023"
		     */
			MMMddyyyy("MMM dd yyyy"),
			
			/**
		     * The pattern for full month name, day without leading zero, and year.
		     * For example: "January 1 2023"
		     */
			MMMMdyyyy("MMMM d yyyy"),
			
			/**
		     * The pattern for full month name, day with leading zero, and year.
		     * For example: "January 01 2023"
		     */
			MMMMddyyyy("MMMM dd yyyy");
			
			/**
			 * The pattern value of the enum;
			 */
			@Getter
		    public final String value;

		    /**
		     * Configured formatter for the specified pattern
		     */
			@Getter
		    public final DateTimeFormatter formatter;
			
		    private WithSpaceSeparator(String value) {
		    	this.value = value;
		    	this.formatter = DateTimeFormatter.ofPattern(value);
		    }
		    
		}
		
	}
	
	/**
	 *  Date Pattern containing only numbers
	 */
	enum Numeric {
		
		;
		
		/**
		 *  Date Pattern containing only numbers, each date element is separated by a DOT
		 */
		enum WithDotSeparator implements DatePatternBase {

			/**
		     * The pattern for day without leading zero, month without leading zero, and year.
		     * For example: "1.1.2023"
		     */
			dMyyyy("d.M.yyyy"),
			
			/**
		     * The pattern for day with leading zero, month without leading zero, and year.
		     * For example: "01.1.2023"
		     */
			ddMyyyy("dd.M.yyyy"),
			
			/**
		     * The pattern for day without leading zero, month with leading zero, and year.
		     * For example: "1.01.2023"
		     */
			dMMyyyy("d.MM.yyyy"),
			
			/**
		     * The pattern for day with leading zero, month with leading zero, and year.
		     * For example: "01.01.2023"
		     */
			ddMMyyyy("dd.MM.yyyy"),
			
			/**
		     * The pattern for year, month without leading zero, and day without leading zero.
		     * For example: "2023.1.1"
		     */
			yyyyMd("yyyy.M.d"),
			
			/**
		     * The pattern for year, month without leading zero, and day with leading zero.
		     * For example: "2023.1.01"
		     */
			yyyyMdd("yyyy.M.dd"),
			
			/**
		     * The pattern for year, month with leading zero, and day without leading zero.
		     * For example: "2023.01.1"
		     */
			yyyyMMd("yyyy.MM.d"),
			
			/**
		     * The pattern for year, month with leading zero, and day with leading zero.
		     * For example: "2023.01.01"
		     */
			yyyyMMdd("yyyy.MM.dd"),
			
			/**
		     * The pattern for month without leading zero, year, and day without leading zero.
		     * For example: "1.1.2023"
		     */
			Mdyyyy("M.d.yyyy"),
			
			/**
		     * The pattern for month without leading zero, year, and day with leading zero.
		     * For example: "1.01.2023"
		     */
			Mddyyyy("M.dd.yyyy"),
			
			/**
		     * The pattern for month with leading zero, year, and day without leading zero.
		     * For example: "01.1.2023"
		     */
			MMdyyyy("MM.d.yyyy"),
			
			/**
		     * The pattern for month with leading zero, year, and day with leading zero.
		     * For example: "01.01.2023"
		     */
			MMddyyyy("MM.dd.yyyy");
			
			/**
			 * The pattern value of the enum;
			 */
			@Getter
		    public final String value;

		    /**
		     * Configured formatter for the specified pattern
		     */
			@Getter
		    public final DateTimeFormatter formatter;
			
		    private WithDotSeparator(String value) {
		    	this.value = value;
		    	this.formatter = DateTimeFormatter.ofPattern(value);
		    }
		    
		}

		/**
		 *  Date Pattern containing only numbers, each date element is separated by a HYPHEN
		 */
		enum WithHyphenSeparator implements DatePatternBase {

			/**
		     * The pattern for day without leading zero, month without leading zero, and year.
		     * For example: "1-1-2023"
		     */
			dMyyyy("d-M-yyyy"),
			
			/**
		     * The pattern for day with leading zero, month without leading zero, and year.
		     * For example: "01-1-2023"
		     */
			ddMyyyy("dd-M-yyyy"),
			
			/**
		     * The pattern for day without leading zero, month with leading zero, and year.
		     * For example: "1-01-2023"
		     */
			dMMyyyy("d-MM-yyyy"),

			/**
		     * The pattern for day with leading zero, month with leading zero, and year.
		     * For example: "01-01-2023"
		     */
			ddMMyyyy("dd-MM-yyyy"),

			/**
		     * The pattern for year, month without leading zero, and day without leading zero.
		     * For example: "2023-1-1"
		     */
			yyyyMd("yyyy-M-d"),

			/**
		     * The pattern for year, month without leading zero, and day with leading zero.
		     * For example: "2023-1-01"
		     */
			yyyyMdd("yyyy-M-dd"),
			
			/**
		     * The pattern for year, month with leading zero, and day without leading zero.
		     * For example: "2023-01-1"
		     */
			yyyyMMd("yyyy-MM-d"),

			/**
		     * The pattern for year, month with leading zero, and day with leading zero.
		     * For example: "2023-01-01"
		     */
			yyyyMMdd("yyyy-MM-dd"),

			/**
		     * The pattern for month without leading zero, year, and day without leading zero.
		     * For example: "1-1-2023"
		     */
			Mdyyyy("M-d-yyyy"),

			/**
		     * The pattern for month without leading zero, year, and day with leading zero.
		     * For example: "1-01-2023"
		     */
			Mddyyyy("M-dd-yyyy"),
			
			/**
		     * The pattern for month with leading zero, year, and day without leading zero.
		     * For example: "01-1-2023"
		     */
			MMdyyyy("MM-d-yyyy"),
			
			/**
		     * The pattern for month with leading zero, year, and day with leading zero.
		     * For example: "01-01-2023"
		     */
			MMddyyyy("MM-dd-yyyy");
			
			/**
			 * The pattern value of the enum;
			 */
			@Getter
		    public final String value;

		    /**
		     * Configured formatter for the specified pattern
		     */
			@Getter
		    public final DateTimeFormatter formatter;
			
		    private WithHyphenSeparator(String value) {
		    	this.value = value;
		    	this.formatter = DateTimeFormatter.ofPattern(value);
		    }
		    
		}
		
		/**
		 *  Date Pattern containing only numbers, each date element is separated by a SLASH
		 */
		enum WithSlashSeparator implements DatePatternBase {

			/**
		     * The pattern for day without leading zero, month without leading zero, and year.
		     * For example: "1/1/2023"
		     */
			dMyyyy("d/M/yyyy"),
			
			/**
		     * The pattern for day with leading zero, month without leading zero, and year.
		     * For example: "01/1/2023"
		     */
			ddMyyyy("dd/M/yyyy"),
			
			/**
		     * The pattern for day without leading zero, month with leading zero, and year.
		     * For example: "1/01/2023"
		     */
			dMMyyyy("d/MM/yyyy"),
			
			/**
		     * The pattern for day with leading zero, month with leading zero, and year.
		     * For example: "01/01/2023"
		     */
			ddMMyyyy("dd/MM/yyyy"),
			
			/**
		     * The pattern for year, month without leading zero, and day without leading zero.
		     * For example: "2023/1/1"
		     */
			yyyyMd("yyyy/M/d"),
			
			/**
		     * The pattern for year, month without leading zero, and day with leading zero.
		     * For example: "2023/1/01"
		     */
			yyyyMdd("yyyy/M/dd"),
			
			/**
		     * The pattern for year, month with leading zero, and day without leading zero.
		     * For example: "2023/01/1"
		     */
			yyyyMMd("yyyy/MM/d"),
			
			/**
		     * The pattern for year, month with leading zero, and day with leading zero.
		     * For example: "2023/01/01"
		     */
			yyyyMMdd("yyyy/MM/dd"),
			
			/**
		     * The pattern for month without leading zero, year, and day without leading zero.
		     * For example: "1/1/2023"
		     */
			Mdyyyy("M/d/yyyy"),
			
			/**
		     * The pattern for month without leading zero, year, and day with leading zero.
		     * For example: "1/01/2023"
		     */
			Mddyyyy("M/dd/yyyy"),
			
			/**
		     * The pattern for month with leading zero, year, and day without leading zero.
		     * For example: "01/1/2023"
		     */
			MMdyyyy("MM/d/yyyy"),
			
			/**
		     * The pattern for month with leading zero, year, and day with leading zero.
		     * For example: "01/01/2023"
		     */
			MMddyyyy("MM/dd/yyyy");
			
			/**
			 * The pattern value of the enum;
			 */
			@Getter
		    public final String value;

		    /**
		     * Configured formatter for the specified pattern
		     */
			@Getter
		    public final DateTimeFormatter formatter;
			
		    private WithSlashSeparator(String value) {
		    	this.value = value;
		    	this.formatter = DateTimeFormatter.ofPattern(value);
		    }
		    
		}

		/**
		 *  Date Pattern containing only numbers, each date element is separated by a SPACE
		 */
		enum WithSpaceSeparator implements DatePatternBase {

			/**
		     * The pattern for day without leading zero, month without leading zero, and year.
		     * For example: "1 1 2023"
		     */
			dMyyyy("d M yyyy"),
			
			/**
		     * The pattern for day with leading zero, month without leading zero, and year.
		     * For example: "01 1 2023"
		     */
			ddMyyyy("dd M yyyy"),
			
			/**
		     * The pattern for day without leading zero, month with leading zero, and year.
		     * For example: "1 01 2023"
		     */
			dMMyyyy("d MM yyyy"),
			
			/**
		     * The pattern for day with leading zero, month with leading zero, and year.
		     * For example: "01 01 2023"
		     */
			ddMMyyyy("dd MM yyyy"),
			
			/**
		     * The pattern for year, month without leading zero, and day without leading zero.
		     * For example: "2023 1 1"
		     */
			yyyyMd("yyyy M d"),
			
			/**
		     * The pattern for year, month without leading zero, and day with leading zero.
		     * For example: "2023 1 01"
		     */
			yyyyMdd("yyyy M dd"),
			
			/**
		     * The pattern for year, month with leading zero, and day without leading zero.
		     * For example: "2023 01 1"
		     */
			yyyyMMd("yyyy MM d"),
			
			/**
		     * The pattern for year, month with leading zero, and day with leading zero.
		     * For example: "2023 01 01"
		     */
			yyyyMMdd("yyyy MM dd"),
			
			/**
		     * The pattern for month without leading zero, year, and day without leading zero.
		     * For example: "1 1 2023"
		     */
			Mdyyyy("M d yyyy"),
			
			/**
		     * The pattern for month without leading zero, year, and day with leading zero.
		     * For example: "1 01 2023"
		     */
			Mddyyyy("M dd yyyy"),
			
			/**
		     * The pattern for month with leading zero, year, and day without leading zero.
		     * For example: "01 1 2023"
		     */
			MMdyyyy("MM d yyyy"),
			
			/**
		     * The pattern for month with leading zero, year, and day with leading zero.
		     * For example: "01 01 2023"
		     */
			MMddyyyy("MM dd yyyy");
			
			/**
			 * The pattern value of the enum;
			 */
			@Getter
		    public final String value;

		    /**
		     * Configured formatter for the specified pattern
		     */
			@Getter
		    public final DateTimeFormatter formatter;
			
		    private WithSpaceSeparator(String value) {
		    	this.value = value;
		    	this.formatter = DateTimeFormatter.ofPattern(value);
		    }
		    
		}
		
	}
	
}