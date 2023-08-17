package com.paulmarcelinbejan.toolbox.web.service;

import java.util.Collection;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

/**
 *
 * Basic methods for read operation.
 *
 * @author paulmarcelinbejan
 *
 */
public interface ReadService<ID, ENTITY> {

	/**
	 * Returns a reference to the entity with the given identifier.
	 */
	ENTITY getReferenceById(ID id);
	
	ENTITY findById(ID id) throws FunctionalException;

	/**
	 * If an Entity is not found in the persistence store, a FunctionalException will be thrown.
	 */
	Collection<ENTITY> findManyById(Collection<ID> ids) throws FunctionalException;

	/**
	 * Entities that aren't found in the persistence store are silently ignored.
	 */
	Collection<ENTITY> findManyByIdIfPresent(Collection<ID> ids);

	Collection<ENTITY> findAll();

}
