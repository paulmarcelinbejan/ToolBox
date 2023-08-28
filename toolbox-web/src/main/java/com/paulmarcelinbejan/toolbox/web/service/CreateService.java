package com.paulmarcelinbejan.toolbox.web.service;

import com.paulmarcelinbejan.toolbox.web.service.create.CreateAndReturnEntityService;
import com.paulmarcelinbejan.toolbox.web.service.create.CreateAndReturnIdService;

/**
 *
 * Basic methods for create operation.
 *
 * @author paulmarcelinbejan
 *
 */
public interface CreateService<ID, ENTITY> extends 
				 CreateAndReturnIdService<ID, ENTITY>,
				 CreateAndReturnEntityService<ENTITY> {

}
