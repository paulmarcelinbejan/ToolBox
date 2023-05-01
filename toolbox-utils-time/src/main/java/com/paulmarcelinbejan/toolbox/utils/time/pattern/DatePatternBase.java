package com.paulmarcelinbejan.toolbox.utils.time.pattern;

import java.time.format.DateTimeFormatter;

import com.paulmarcelinbejan.toolbox.base.enums.EnumBase;

public interface DatePatternBase extends EnumBase {
	
	public DateTimeFormatter getFormatter();
	
}
