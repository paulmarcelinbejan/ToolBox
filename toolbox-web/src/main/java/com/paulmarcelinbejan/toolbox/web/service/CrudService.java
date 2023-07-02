package com.paulmarcelinbejan.toolbox.web.service;

public interface CrudService<ID, ENTITY, DTO>
		extends
		ReadService<ID, ENTITY, DTO>,
		CreateService<ID, DTO>,
		UpdateService<ID, DTO>,
		DeleteService<ID> {

}
