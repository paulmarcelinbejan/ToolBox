package com.paulmarcelinbejan.toolbox.web.service.create;

import java.util.Collection;

/**
*
* Basic methods for create operation returning saved entity.
*
* @author paulmarcelinbejan
*
*/
public interface CreateAndReturnEntityService<ENTITY> {
	
	ENTITY saveAndReturn(ENTITY entity);
	
	Collection<ENTITY> saveAndReturn(Collection<ENTITY> entities);

}