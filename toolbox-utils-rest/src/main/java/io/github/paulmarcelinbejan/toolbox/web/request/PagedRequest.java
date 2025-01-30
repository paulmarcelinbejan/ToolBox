package io.github.paulmarcelinbejan.toolbox.web.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PagedRequest {

	@NotNull
	@JsonProperty
	private List<FilterBy> filter;
	
	@NotNull
	@JsonProperty
	private List<OrderBy> order;
	
	@Min(1)
	@JsonProperty
	private int elementsForPage;
	
	@Min(1)
	@JsonProperty
	private int page;
	
}
