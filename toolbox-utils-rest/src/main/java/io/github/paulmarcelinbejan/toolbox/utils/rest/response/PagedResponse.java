package io.github.paulmarcelinbejan.toolbox.utils.rest.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PagedResponse {

	private List<?> list;
	
	private long totalElements;
	
	private int totalPages;
	
	private int currentPage;

}
