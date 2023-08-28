package com.paulmarcelinbejan.toolbox.web.service.delete;

import java.util.Collection;

/**
 *
 * Basic methods for delete operation if the entity with the given id is present.
 *
 * @author paulmarcelinbejan
 *
 */
public interface DeleteIfPresentService<ID> {

	/**
	 * If the Entity is not present in the persistence store, it will be silently ignored.
	 */
	void deleteIfPresent(ID id);

	/**
	 * Entities that aren't found in the persistence store are silently ignored.
	 */
	void deleteManyIfPresent(Collection<ID> ids);

}
