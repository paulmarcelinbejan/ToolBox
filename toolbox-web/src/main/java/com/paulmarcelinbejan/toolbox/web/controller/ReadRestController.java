package com.paulmarcelinbejan.toolbox.web.controller;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.paulmarcelinbejan.toolbox.exception.technical.FunctionalException;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToDTO;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class ReadRestController<
		ID,
		ENTITY,
		DTO,
		MAPPER extends BaseMapperToDTO<ENTITY, DTO>,
		REPOSITORY extends JpaRepository<ENTITY, ID>> {

	private final ReadService<ID, ENTITY, DTO, MAPPER, REPOSITORY> service;

	@GetMapping("/{id}")
	public DTO findById(@PathVariable ID id) throws FunctionalException {
		return service.findByIdToDto(id);
	}

	@GetMapping("/")
	public Collection<DTO> findAll() {
		return service.findAllToDto();
	}

}
