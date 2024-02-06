package io.github.paulmarcelinbejan.toolbox.web.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

import io.github.paulmarcelinbejan.toolbox.base.enums.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class OrderBy {

	@NotNull
	@JsonProperty
	private String field;
	
	@NotNull
	@JsonProperty
	private Order order;
	
}
