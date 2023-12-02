package io.github.paulmarcelinbejan.toolbox.utils.time.pattern;

import java.time.format.DateTimeFormatter;

import io.github.paulmarcelinbejan.toolbox.base.enums.EnumBase;

public interface DatePatternBase extends EnumBase {
	
	public DateTimeFormatter getFormatter();
	
}
