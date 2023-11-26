package com.paulmarcelinbejan.toolbox.service.helper.mapping;

import java.util.Collection;

public interface MapperFromSaveRequestToEntity<ENTITY, SAVE_REQUEST> {

	ENTITY fromSaveRequestToEntity(SAVE_REQUEST saveRequest);

	Collection<ENTITY> fromSaveRequestsToEntities(Collection<SAVE_REQUEST> saveRequests);

}
