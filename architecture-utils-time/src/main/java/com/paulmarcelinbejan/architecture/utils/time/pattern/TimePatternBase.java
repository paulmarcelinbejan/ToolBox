package com.paulmarcelinbejan.architecture.utils.time.pattern;

import java.time.format.DateTimeFormatter;

import com.paulmarcelinbejan.architecture.base.enums.EnumBase;

public interface TimePatternBase extends EnumBase {
	
	public DateTimeFormatter getFormatter();
	
}
