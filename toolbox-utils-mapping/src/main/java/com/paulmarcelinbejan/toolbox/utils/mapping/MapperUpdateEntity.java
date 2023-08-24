package com.paulmarcelinbejan.toolbox.utils.mapping;

public interface MapperUpdateEntity<ENTITY> {
	
	void updateEntity(ENTITY toUpdate, ENTITY newValue);

}
