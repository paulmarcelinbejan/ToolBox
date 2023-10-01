package com.paulmarcelinbejan.toolbox.web.service.aggregate;

import com.paulmarcelinbejan.toolbox.web.service.CreateService;
import com.paulmarcelinbejan.toolbox.web.service.DeleteService;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;

/**
 * CREATE, READ, DELETE service
 */
public interface CreateReadDeleteService<ID, ENTITY>
		extends
		CreateService<ID, ENTITY>,
		ReadService<ID, ENTITY>,
		DeleteService<ID> {

}
