package com.paulmarcelinbejan.toolbox.service.helper.mapping;

public interface MapperUpdateEntity<ENTITY> {
	
	void updateEntity(ENTITY toUpdate, ENTITY newValue);

}
