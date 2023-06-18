package com.paulmarcelinbejan.toolbox.mapstruct;

import java.util.Collection;

public interface BaseMapperToEntity<ENTITY, DTO> {

	ENTITY toEntity(DTO dto);

	Collection<ENTITY> toEntities(Collection<DTO> dtoList);

	void updateEntityFromDto(ENTITY entity, DTO dto);

}
