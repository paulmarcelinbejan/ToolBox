package com.paulmarcelinbejan.toolbox.utils.mapping;

public interface BaseFromSaveToResponseMapper<
		ENTITY,
		SAVE_REQUEST,
		RESPONSE>
		extends
		MapperFromSaveRequestToEntity<ENTITY, SAVE_REQUEST>,
		MapperToResponse<ENTITY, RESPONSE> {

}
