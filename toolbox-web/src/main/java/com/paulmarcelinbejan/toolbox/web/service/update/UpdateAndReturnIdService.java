package com.paulmarcelinbejan.toolbox.web.service.update;

import java.util.Collection;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

/**
 *
 * Basic methods for update operation returning updated entity id
 *
 * @author paulmarcelinbejan
 *
 */
public interface UpdateAndReturnIdService<ID, ENTITY> {

	ID update(ENTITY entity) throws FunctionalException;
	
	Collection<ID> update(Collection<ENTITY> entities) throws FunctionalException;

}
