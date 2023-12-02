package io.github.paulmarcelinbejan.toolbox.service.helper.update;

import java.util.Collection;
import java.util.List;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

/**
 *
 * Basic methods for update operation returning updated entity id
 *
 * @author paulmarcelinbejan
 *
 */
public interface UpdateAndReturnIdServiceHelper<ID, ENTITY> {

	ID update(ENTITY entity) throws FunctionalException;
	
	List<ID> update(Collection<ENTITY> entities) throws FunctionalException;

}
