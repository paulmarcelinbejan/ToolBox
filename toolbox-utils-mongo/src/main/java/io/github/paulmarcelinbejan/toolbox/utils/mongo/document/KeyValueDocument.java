package io.github.paulmarcelinbejan.toolbox.utils.mongo.document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class KeyValueDocument {
	
	private Integer id;
	
	private String key;
	
	private String value;
	
}