package io.github.paulmarcelinbejan.toolbox.utils.rest.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum ResponseStatus {

	OK,
	KO;
	
	@JsonCreator
	public static ResponseStatus fromJsonNode(JsonNode jsonNode) {
		return ResponseStatus.valueOf(jsonNode.asText());
	}

}
