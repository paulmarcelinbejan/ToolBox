package com.paulmarcelinbejan.toolbox.service.helper;

import com.paulmarcelinbejan.toolbox.service.helper.update.UpdateAndReturnEntityServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.update.UpdateAndReturnIdServiceHelper;

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
