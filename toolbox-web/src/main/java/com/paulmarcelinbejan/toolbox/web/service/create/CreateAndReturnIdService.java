package com.paulmarcelinbejan.toolbox.web.service.create;

import java.util.Collection;
import java.util.List;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

/**
*
* Basic methods for create operation returning saved saved entity id.
*
* @author paulmarcelinbejan
*
*/
public interface CreateAndReturnIdService<ID, ENTITY> {

	ID save(ENTITY entity) throws FunctionalException;
	
	List<ID> save(Collection<ENTITY> entities) throws FunctionalException;

}