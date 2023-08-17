package com.paulmarcelinbejan.toolbox.web.service;

import java.util.Collection;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

/**
 *
 * Basic methods for delete operation.
 *
 * @author paulmarcelinbejan
 *
 */
public interface DeleteService<ID> {

	/**
	 * If the Entity is not found in the persistence store, a FunctionalException will be thrown.
	 */
	void delete(ID id) throws FunctionalException;

	/**
	 * If the Entity is not present in the persistence store, it will be silently ignored.
	 */
	void deleteIfPresent(ID id);

	/**
	 * If an Entity is not found in the persistence store, a FunctionalException will be thrown.
	 */
	void deleteMany(Collection<ID> ids) throws FunctionalException;

	/**
	 * Entities that aren't found in the persistence store are silently ignored.
	 */
	void deleteManyIfPresent(Collection<ID> ids);

}
