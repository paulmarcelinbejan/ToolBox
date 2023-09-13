package com.paulmarcelinbejan.toolbox.jackson.serializer;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.paulmarcelinbejan.toolbox.utils.time.pattern.time.TimePattern;

public class LocalTimeSerializer extends JsonSerializer<LocalTime> {

	private static final DateTimeFormatter FORMATTER = TimePattern.With24HourClockFormat.HHmmss.getFormatter();
	
	@Override
	public void serialize(LocalTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeString(value.format(FORMATTER));
	}

}
