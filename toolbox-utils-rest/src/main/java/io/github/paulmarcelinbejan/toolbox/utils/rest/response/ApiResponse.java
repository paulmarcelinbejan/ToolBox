package io.github.paulmarcelinbejan.toolbox.utils.rest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ApiResponse<T> {

	private String status;

	private T response;

	private ExceptionResponse error;
	
	public ApiResponse(T response) {
		this.status = ResponseStatus.OK.name();
		this.response = response;
	}
	
	public ApiResponse(ExceptionResponse exceptionResponse) {
		this.status = ResponseStatus.KO.name();
		this.error = exceptionResponse;
	}
	
	public static <T> ApiResponse<T> ok(T response) {
		return new ApiResponse<>(response);
	}
	
	public static ApiResponse<?> ko(ExceptionResponse exceptionResponse) {
		return new ApiResponse<>(exceptionResponse);
	}

}
