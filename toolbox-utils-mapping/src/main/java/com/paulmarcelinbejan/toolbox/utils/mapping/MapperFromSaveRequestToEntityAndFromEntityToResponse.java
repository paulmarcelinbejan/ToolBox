package com.paulmarcelinbejan.toolbox.utils.mapping;

public interface MapperFromSaveRequestToEntityAndFromEntityToResponse<
		ENTITY,
		SAVE_REQUEST,
		RESPONSE>
		extends
		MapperFromSaveRequestToEntity<ENTITY, SAVE_REQUEST>,
		MapperFromEntityToResponse<ENTITY, RESPONSE> {

}
