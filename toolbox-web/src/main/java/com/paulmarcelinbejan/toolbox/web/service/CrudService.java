package com.paulmarcelinbejan.toolbox.web.service;

public interface CrudService<ID, ENTITY, DTO>
		extends
		CreateService<ID, DTO>,
		ReadService<ID, ENTITY, DTO>,
		UpdateService<ID, DTO>,
		DeleteService<ID> {

}
