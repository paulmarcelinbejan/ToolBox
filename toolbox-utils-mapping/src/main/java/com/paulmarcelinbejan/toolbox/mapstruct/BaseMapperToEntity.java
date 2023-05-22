package com.paulmarcelinbejan.toolbox.mapstruct;

import java.util.Collection;

import org.mapstruct.MappingTarget;

public interface BaseMapperToEntity<ENTITY, DTO> {

	ENTITY toEntity(DTO dto);

	Collection<ENTITY> toEntities(Collection<DTO> dtoList);

	void updateEntityFromDto(@MappingTarget ENTITY entity, DTO dto);

}
