package com.paulmarcelinbejan.toolbox.utils.mapping;

public interface FullMapper<
		ENTITY,
		SAVE_REQUEST,
		UPDATE_REQUEST,
		RESPONSE>
		extends
		MapperFromSaveRequestToEntity<ENTITY, SAVE_REQUEST>,
		MapperFromUpdateRequestToEntity<ENTITY, UPDATE_REQUEST>,
		MapperUpdateEntity<ENTITY>,
		MapperFromEntityToResponse<ENTITY, RESPONSE> {

}
