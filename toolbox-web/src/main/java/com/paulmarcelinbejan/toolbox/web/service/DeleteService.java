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

	void delete(ID id) throws FunctionalException;

	/**
	 * If an Entity is not found in the persistence store, a FunctionalException
	 * will be thrown.
	 */
	void delete(Collection<ID> ids) throws FunctionalException;

	/**
	 * Entities that aren't found in the persistence store are silently ignored.
	 */
	void deleteIfPresent(Collection<ID> ids);

}
