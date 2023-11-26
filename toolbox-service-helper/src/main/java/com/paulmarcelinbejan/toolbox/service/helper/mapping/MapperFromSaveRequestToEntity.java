package com.paulmarcelinbejan.toolbox.service.helper.mapping;

import java.util.Collection;
import java.util.List;

public interface MapperFromSaveRequestToEntity<ENTITY, SAVE_REQUEST> {

	ENTITY fromSaveRequestToEntity(SAVE_REQUEST saveRequest);

	List<ENTITY> fromSaveRequestsToEntities(Collection<SAVE_REQUEST> saveRequests);

}
