package io.github.paulmarcelinbejan.toolbox.service.helper;

import io.github.paulmarcelinbejan.toolbox.service.helper.update.UpdateAndReturnEntityServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.update.UpdateAndReturnIdServiceHelper;

/**
 *
 * Basic methods for update operation.
 *
 * @author paulmarcelinbejan
 *
 */
public interface UpdateServiceHelper<ID, ENTITY> extends 
				 UpdateAndReturnIdServiceHelper<ID, ENTITY>,
				 UpdateAndReturnEntityServiceHelper<ENTITY> {

}
