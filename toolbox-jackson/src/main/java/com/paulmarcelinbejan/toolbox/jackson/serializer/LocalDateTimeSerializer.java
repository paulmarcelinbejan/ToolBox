package com.paulmarcelinbejan.toolbox.jackson.serializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.paulmarcelinbejan.toolbox.utils.time.format.DateTimeFormatUtils;
import com.paulmarcelinbejan.toolbox.utils.time.pattern.date.DatePattern;
import com.paulmarcelinbejan.toolbox.utils.time.pattern.time.TimePattern;

public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DateTimeFormatUtils.buildPattern(DatePattern.Numeric.WithSlashSeparator.ddMMyyyy, TimePattern.With24HourClockFormat.HHmmss));
	
	@Override
	public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeString(value.format(FORMATTER));
	}

}
