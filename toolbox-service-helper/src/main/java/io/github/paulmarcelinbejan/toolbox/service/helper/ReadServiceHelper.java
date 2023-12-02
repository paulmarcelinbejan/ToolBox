package io.github.paulmarcelinbejan.toolbox.service.helper;

import java.util.Collection;
import java.util.List;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

/**
 *
 * Basic methods for read operation.
 *
 * @author paulmarcelinbejan
 *
 */
public interface ReadServiceHelper<ID, ENTITY> {

	/**
	 * Returns a reference to the entity with the given identifier.
	 */
	ENTITY getReferenceById(ID id);
	
	ENTITY findById(ID id) throws FunctionalException;

	/**
	 * If an Entity is not found in the persistence store, a FunctionalException will be thrown.
	 */
	List<ENTITY> findManyById(Collection<ID> ids) throws FunctionalException;

	/**
	 * Entities that aren't found in the persistence store are silently ignored.
	 */
	List<ENTITY> findManyByIdIfPresent(Collection<ID> ids);

	List<ENTITY> findAll();

}
