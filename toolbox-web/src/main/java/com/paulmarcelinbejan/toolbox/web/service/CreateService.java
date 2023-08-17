package com.paulmarcelinbejan.toolbox.web.service;

import java.util.Collection;

/**
 *
 * Basic methods for create operation.
 *
 * @author paulmarcelinbejan
 *
 */
public interface CreateService<ID, ENTITY> {

	ID save(ENTITY entity);

	ENTITY saveAndReturn(ENTITY entity);
	
	Collection<ID> save(Collection<ENTITY> entities);
	
	Collection<ENTITY> saveAndReturn(Collection<ENTITY> entities);

}
