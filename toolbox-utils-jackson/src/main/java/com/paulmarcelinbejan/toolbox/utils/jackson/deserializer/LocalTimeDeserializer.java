package com.paulmarcelinbejan.toolbox.utils.jackson.deserializer;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.paulmarcelinbejan.toolbox.utils.time.pattern.time.TimePattern;

public class LocalTimeDeserializer extends JsonDeserializer<LocalTime> {

	private static final DateTimeFormatter FORMATTER = TimePattern.With24HourClockFormat.HHmmss.getFormatter();

	@Override
	public LocalTime deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
		String localTime = jsonParser.getText();
        return LocalTime.parse(localTime, FORMATTER);
	}
	
}
