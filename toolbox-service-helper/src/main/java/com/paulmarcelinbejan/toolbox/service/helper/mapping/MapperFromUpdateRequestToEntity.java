package com.paulmarcelinbejan.toolbox.service.helper.mapping;

import java.util.Collection;
import java.util.List;

public interface MapperFromUpdateRequestToEntity<ENTITY, UPDATE_REQUEST> {
	
	ENTITY fromUpdateRequestToEntity(UPDATE_REQUEST updateRequest);
	
	List<ENTITY> fromUpdateRequestsToEntities(Collection<UPDATE_REQUEST> updateRequests);

}
