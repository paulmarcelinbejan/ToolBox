package com.paulmarcelinbejan.toolbox.jackson.serializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.paulmarcelinbejan.toolbox.utils.time.pattern.date.DatePattern;

public class LocalDateSerializer extends JsonSerializer<LocalDate> {

	private static final DateTimeFormatter FORMATTER = DatePattern.Numeric.WithSlashSeparator.ddMMyyyy.getFormatter();
	
	@Override
	public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeString(value.format(FORMATTER));
	}

}
