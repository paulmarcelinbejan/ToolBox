package com.paulmarcelinbejan.toolbox.jackson.deserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.paulmarcelinbejan.toolbox.utils.time.pattern.date.DatePattern;

public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DatePattern.Numeric.WithSlashSeparator.ddMMyyyy.getValue());

	@Override
	public LocalDate deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
		String localDate = jsonParser.getText();
        return LocalDate.parse(localDate, FORMATTER);
	}
	
}
