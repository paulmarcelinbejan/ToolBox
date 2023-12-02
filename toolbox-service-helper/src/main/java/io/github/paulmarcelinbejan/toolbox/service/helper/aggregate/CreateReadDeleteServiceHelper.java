package io.github.paulmarcelinbejan.toolbox.service.helper.aggregate;

import io.github.paulmarcelinbejan.toolbox.service.helper.CreateServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.DeleteServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;

/**
 * CREATE, READ, DELETE service
 */
public interface CreateReadDeleteServiceHelper<ID, ENTITY>
		extends
		CreateServiceHelper<ID, ENTITY>,
		ReadServiceHelper<ID, ENTITY>,
		DeleteServiceHelper<ID> {

}
