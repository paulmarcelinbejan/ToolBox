package io.github.paulmarcelinbejan.toolbox.base.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pair<L, R> {

	private L left;
	
	private R right;
	
}
