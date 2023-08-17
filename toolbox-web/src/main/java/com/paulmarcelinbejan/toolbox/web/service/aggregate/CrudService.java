package com.paulmarcelinbejan.toolbox.web.service.aggregate;

import com.paulmarcelinbejan.toolbox.web.service.CreateService;
import com.paulmarcelinbejan.toolbox.web.service.DeleteService;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;
import com.paulmarcelinbejan.toolbox.web.service.UpdateService;

public interface CrudService<ID, ENTITY>
		extends
		CreateService<ID, ENTITY>,
		ReadService<ID, ENTITY>,
		UpdateService<ID, ENTITY>,
		DeleteService<ID> {

}
