package io.github.paulmarcelinbejan.toolbox.service.helper.aggregate;

import io.github.paulmarcelinbejan.toolbox.service.helper.CreateServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.DeleteServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.UpdateServiceHelper;

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
