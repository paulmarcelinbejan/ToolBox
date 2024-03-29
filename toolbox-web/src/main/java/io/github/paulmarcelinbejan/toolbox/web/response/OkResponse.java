package io.github.paulmarcelinbejan.toolbox.web.response;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class OkResponse {

	private String status;

	private String message;

	public OkResponse() {
		status = String.valueOf(HttpStatus.OK.value());
		message = HttpStatus.OK.getReasonPhrase();
	}

}
