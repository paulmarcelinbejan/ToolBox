package com.paulmarcelinbejan.toolbox.mapstruct;

import java.util.Collection;

public interface BaseMapperToEntity<ENTITY, DTO> extends UpdateEntityMapper<ENTITY> {

	ENTITY toEntity(DTO dto);

	Collection<ENTITY> toEntities(Collection<DTO> dtoList);

}
