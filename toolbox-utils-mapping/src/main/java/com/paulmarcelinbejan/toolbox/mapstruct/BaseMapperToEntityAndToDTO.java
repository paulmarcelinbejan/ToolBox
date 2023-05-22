package com.paulmarcelinbejan.toolbox.mapstruct;

public interface BaseMapperToEntityAndToDTO<
		ENTITY,
		DTO>
		extends
		BaseMapperToEntity<ENTITY, DTO>,
		BaseMapperToDTO<ENTITY, DTO> {

}
