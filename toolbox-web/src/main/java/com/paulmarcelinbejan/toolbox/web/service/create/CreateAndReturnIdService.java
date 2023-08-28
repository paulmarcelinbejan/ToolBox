package com.paulmarcelinbejan.toolbox.web.service.create;

import java.util.Collection;

/**
*
* Basic methods for create operation returning saved saved entity id.
*
* @author paulmarcelinbejan
*
*/
public interface CreateAndReturnIdService<ID, ENTITY> {

	ID save(ENTITY entity);
	
	Collection<ID> save(Collection<ENTITY> entities);

}