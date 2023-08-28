package com.paulmarcelinbejan.toolbox.web.service.update;

import java.util.Collection;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

/**
 *
 * Basic methods for update operation returning updated entity.
 *
 * @author paulmarcelinbejan
 *
 */
public interface UpdateAndReturnEntityService<ENTITY> {

	ENTITY updateAndReturn(ENTITY entity) throws FunctionalException;
	
	Collection<ENTITY> updateAndReturn(Collection<ENTITY> entities) throws FunctionalException;

}
