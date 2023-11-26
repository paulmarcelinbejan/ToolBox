package com.paulmarcelinbejan.toolbox.service.helper.aggregate;

import com.paulmarcelinbejan.toolbox.service.helper.CreateServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.DeleteServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.UpdateServiceHelper;

/**
 * CREATE, READ, UPDATE, DELETE service
 */
public interface CrudServiceHelper<ID, ENTITY>
		extends
		CreateServiceHelper<ID, ENTITY>,
		ReadServiceHelper<ID, ENTITY>,
		UpdateServiceHelper<ID, ENTITY>,
		DeleteServiceHelper<ID> {

}
