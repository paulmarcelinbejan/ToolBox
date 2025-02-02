package io.github.paulmarcelinbejan.toolbox.utils.jpa.converter;

import java.time.Duration;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class DurationConverter implements AttributeConverter<Duration, String> {

	@Override
	public String convertToDatabaseColumn(Duration duration) {
		return duration != null ? duration.toString() : null;
	}

	@Override
	public Duration convertToEntityAttribute(String duration) {
		return duration != null ? Duration.parse(duration) : null;
	}

}
