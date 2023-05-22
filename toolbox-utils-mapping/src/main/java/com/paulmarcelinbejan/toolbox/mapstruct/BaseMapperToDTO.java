package com.paulmarcelinbejan.toolbox.mapstruct;

import java.util.Collection;

public interface BaseMapperToDTO<ENTITY, DTO> {

	DTO toDto(ENTITY entity);

	Collection<DTO> toDtos(Collection<ENTITY> entities);

}
