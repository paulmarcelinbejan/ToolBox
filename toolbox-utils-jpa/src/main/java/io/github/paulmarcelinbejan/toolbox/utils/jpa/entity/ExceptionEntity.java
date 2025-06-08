package io.github.paulmarcelinbejan.toolbox.utils.jpa.entity;

import java.time.Instant;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public abstract class ExceptionEntity {

	@Id
	@Column(name = "exception_id", unique = true, nullable = false)
	private String exceptionId;
	
	@Column(name = "request_id", nullable = false)
	private String requestId;
	
	@Column(name = "correlation_id", nullable = false)
	private String correlationId;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@Column(name = "timestamp_UTC", nullable = false)
	private Instant timestampUTC;

	@Column(name = "exception_type", nullable = false)
	private String exceptionType;

	@Column(name = "message", nullable = false)
	private String message;

	@Column(name = "stack_trace", nullable = false)
	private String stackTrace;
	
}