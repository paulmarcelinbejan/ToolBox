package io.github.paulmarcelinbejan.toolbox.service.helper.delete;

import java.util.Collection;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

/**
 *
 * Basic methods for delete operation that throws FunctionalException when the entity with the given id is not found.
 *
 * @author paulmarcelinbejan
 *
 */
public interface DeleteThrowsExceptionIfNotFoundServiceHelper<ID> {

	/**
	 * If the Entity is not found in the persistence store, a FunctionalException will be thrown.
	 */
	void delete(ID id) throws FunctionalException;

	/**
	 * If an Entity is not found in the persistence store, a FunctionalException will be thrown.
	 */
	void deleteMany(Collection<ID> ids) throws FunctionalException;

}
