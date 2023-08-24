package com.paulmarcelinbejan.toolbox.utils.mapping;

import java.util.Collection;

public interface MapperFromUpdateRequestToEntity<ENTITY, UPDATE_REQUEST> {
	
	ENTITY fromUpdateRequestToEntity(UPDATE_REQUEST updateRequest);
	
	Collection<ENTITY> fromUpdateRequestsToEntities(Collection<UPDATE_REQUEST> updateRequests);

}
