package io.github.paulmarcelinbejan.toolbox.service.helper.create;

import java.util.Collection;
import java.util.List;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

/**
*
* Basic methods for create operation returning saved saved entity id.
*
* @author paulmarcelinbejan
*
*/
public interface CreateAndReturnIdServiceHelper<ID, ENTITY> {

	ID save(ENTITY entity) throws FunctionalException;
	
	List<ID> save(Collection<ENTITY> entities) throws FunctionalException;

}