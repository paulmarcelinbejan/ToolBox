package io.github.paulmarcelinbejan.toolbox.service.helper.mapping;

public interface MapperFromSaveRequestToEntityAndFromEntityToResponse<
		ENTITY,
		SAVE_REQUEST,
		RESPONSE>
		extends
		MapperFromSaveRequestToEntity<ENTITY, SAVE_REQUEST>,
		MapperFromEntityToResponse<ENTITY, RESPONSE> {

}
