package com.paulmarcelinbejan.toolbox.web.service.create;

import java.util.Collection;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

/**
*
* Basic methods for create operation returning saved entity.
*
* @author paulmarcelinbejan
*
*/
public interface CreateAndReturnEntityService<ENTITY> {
	
	ENTITY saveAndReturn(ENTITY entity) throws FunctionalException;
	
	Collection<ENTITY> saveAndReturn(Collection<ENTITY> entities) throws FunctionalException;

}