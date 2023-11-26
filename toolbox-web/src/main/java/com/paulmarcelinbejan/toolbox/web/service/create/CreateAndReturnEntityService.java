package com.paulmarcelinbejan.toolbox.web.service.create;

import java.util.Collection;
import java.util.List;

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
	
	List<ENTITY> saveAndReturn(Collection<ENTITY> entities) throws FunctionalException;

}