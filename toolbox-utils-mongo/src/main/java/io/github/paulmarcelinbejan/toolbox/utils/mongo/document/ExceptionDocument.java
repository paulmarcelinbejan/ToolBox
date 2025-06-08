package io.github.paulmarcelinbejan.toolbox.utils.mongo.document;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Document("Exception")
public class ExceptionDocument {

	@Id
	@JsonProperty
	private String exceptionId;
	
	@JsonProperty
	private String requestId;
	
	@JsonProperty
	private String correlationId;

	@JsonProperty
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Instant timestampUTC;

	@JsonProperty
	private String exceptionType;

	@JsonProperty
	private String message;

	@JsonProperty
	private String stackTrace;

}