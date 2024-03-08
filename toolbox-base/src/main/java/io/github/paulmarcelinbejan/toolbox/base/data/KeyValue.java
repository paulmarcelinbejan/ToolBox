package io.github.paulmarcelinbejan.toolbox.base.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class KeyValue<K, V> {

	private K key;
	
	private V value;
	
}
