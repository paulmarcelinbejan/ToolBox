package com.paulmarcelinbejan.toolbox.service.helper.update;

import java.util.Collection;
import java.util.List;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

/**
 *
 * Basic methods for update operation returning updated entity.
 *
 * @author paulmarcelinbejan
 *
 */
public interface UpdateAndReturnEntityServiceHelper<ENTITY> {

	ENTITY updateAndReturn(ENTITY entity) throws FunctionalException;
	
	List<ENTITY> updateAndReturn(Collection<ENTITY> entities) throws FunctionalException;

}
