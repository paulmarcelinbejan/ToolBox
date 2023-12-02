package io.github.paulmarcelinbejan.toolbox.service.helper;

import io.github.paulmarcelinbejan.toolbox.service.helper.create.CreateAndReturnEntityServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.create.CreateAndReturnIdServiceHelper;

/**
 *
 * Basic methods for create operation.
 *
 * @author paulmarcelinbejan
 *
 */
public interface CreateServiceHelper<ID, ENTITY> extends 
				 CreateAndReturnIdServiceHelper<ID, ENTITY>,
				 CreateAndReturnEntityServiceHelper<ENTITY> {

}
