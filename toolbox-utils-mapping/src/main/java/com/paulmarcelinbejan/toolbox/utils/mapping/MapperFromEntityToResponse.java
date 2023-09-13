package com.paulmarcelinbejan.toolbox.utils.mapping;

import java.util.Collection;

public interface MapperFromEntityToResponse<ENTITY, RESPONSE> {

	RESPONSE toResponse(ENTITY entity);

	Collection<RESPONSE> toResponses(Collection<ENTITY> entities);

}
