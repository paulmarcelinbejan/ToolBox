package io.github.paulmarcelinbejan.toolbox.service.helper.mapping;

import java.util.Collection;
import java.util.List;

public interface MapperFromEntityToResponse<ENTITY, RESPONSE> {

	RESPONSE toResponse(ENTITY entity);

	List<RESPONSE> toResponses(Collection<ENTITY> entities);

}
