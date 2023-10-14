package com.paulmarcelinbejan.toolbox.jackson.deserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.paulmarcelinbejan.toolbox.utils.time.format.LocalDateTimeFormatUtils;
import com.paulmarcelinbejan.toolbox.utils.time.pattern.date.DatePattern;
import com.paulmarcelinbejan.toolbox.utils.time.pattern.time.TimePattern;

public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(LocalDateTimeFormatUtils.buildPattern(DatePattern.Numeric.WithSlashSeparator.ddMMyyyy, TimePattern.With24HourClockFormat.HHmmss));

	@Override
	public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
		String localDateTime = jsonParser.getText();
        return LocalDateTime.parse(localDateTime, FORMATTER);
	}
	
}
