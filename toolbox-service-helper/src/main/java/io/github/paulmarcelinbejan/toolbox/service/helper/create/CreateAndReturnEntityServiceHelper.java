package io.github.paulmarcelinbejan.toolbox.service.helper.create;

import java.util.Collection;
import java.util.List;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

/**
*
* Basic methods for create operation returning saved entity.
*
* @author paulmarcelinbejan
*
*/
public interface CreateAndReturnEntityServiceHelper<ENTITY> {
	
	ENTITY saveAndReturn(ENTITY entity) throws FunctionalException;
	
	List<ENTITY> saveAndReturn(Collection<ENTITY> entities) throws FunctionalException;

}