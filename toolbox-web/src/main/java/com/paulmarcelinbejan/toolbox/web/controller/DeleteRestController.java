package com.paulmarcelinbejan.toolbox.web.controller;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.paulmarcelinbejan.toolbox.exception.technical.FunctionalException;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToDTO;
import com.paulmarcelinbejan.toolbox.web.dto.OkResponse;
import com.paulmarcelinbejan.toolbox.web.service.DeleteService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class DeleteRestController<
		ID,
		ENTITY,
		DTO,
		MAPPER extends BaseMapperToDTO<ENTITY, DTO>,
		REPOSITORY extends JpaRepository<ENTITY, ID>> {

	private final DeleteService<ID, ENTITY, DTO, MAPPER, REPOSITORY> service;

	@DeleteMapping("/{id}")
	public OkResponse delete(@PathVariable ID id) throws FunctionalException {
		service.delete(id);
		return new OkResponse();
	}

	@DeleteMapping("/")
	public OkResponse delete(Collection<ID> ids) throws FunctionalException {
		service.delete(ids);
		return new OkResponse();
	}

}
