package com.paulmarcelinbejan.toolbox.service.helper.aggregate;

import com.paulmarcelinbejan.toolbox.service.helper.CreateServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.DeleteServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;

/**
 * CREATE, READ, DELETE service
 */
public interface CreateReadDeleteServiceHelper<ID, ENTITY>
		extends
		CreateServiceHelper<ID, ENTITY>,
		ReadServiceHelper<ID, ENTITY>,
		DeleteServiceHelper<ID> {

}
