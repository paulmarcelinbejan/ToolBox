package io.github.paulmarcelinbejan.toolbox.utils.rest.response;

import java.time.Instant;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ExceptionResponse {
	
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
	private String messageCode;
	
	@JsonProperty
	private Map<String, String> messageParams;
	
}
