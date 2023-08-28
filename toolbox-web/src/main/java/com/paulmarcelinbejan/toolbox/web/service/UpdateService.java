package com.paulmarcelinbejan.toolbox.web.service;

import com.paulmarcelinbejan.toolbox.web.service.update.UpdateAndReturnEntityService;
import com.paulmarcelinbejan.toolbox.web.service.update.UpdateAndReturnIdService;

/**
 *
 * Basic methods for update operation.
 *
 * @author paulmarcelinbejan
 *
 */
public interface UpdateService<ID, ENTITY> extends 
				 UpdateAndReturnIdService<ID, ENTITY>,
				 UpdateAndReturnEntityService<ENTITY> {

}
