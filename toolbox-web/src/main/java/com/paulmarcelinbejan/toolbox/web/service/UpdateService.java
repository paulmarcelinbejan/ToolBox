package com.paulmarcelinbejan.toolbox.web.service;

import java.util.Collection;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

/**
 *
 * Basic methods for update operation.
 *
 * @author paulmarcelinbejan
 *
 */
public interface UpdateService<ID, ENTITY> {

	ID update(ENTITY entity) throws FunctionalException;

	ENTITY updateAndReturn(ENTITY entity) throws FunctionalException;
	
	Collection<ID> update(Collection<ENTITY> entities) throws FunctionalException;
	
	Collection<ENTITY> updateAndReturn(Collection<ENTITY> entities) throws FunctionalException;

}
