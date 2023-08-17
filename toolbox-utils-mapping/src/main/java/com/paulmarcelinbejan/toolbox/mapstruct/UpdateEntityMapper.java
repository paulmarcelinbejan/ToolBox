package com.paulmarcelinbejan.toolbox.mapstruct;

public interface UpdateEntityMapper<ENTITY> {
	
	void updateEntity(ENTITY toUpdate, ENTITY newValue);

}
