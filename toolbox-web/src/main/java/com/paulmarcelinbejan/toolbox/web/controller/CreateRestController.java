package com.paulmarcelinbejan.toolbox.web.controller;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PostMapping;

import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToEntity;
import com.paulmarcelinbejan.toolbox.web.service.CreateService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class CreateRestController<
		ID,
		ENTITY,
		DTO,
		MAPPER extends BaseMapperToEntity<ENTITY, DTO>,
		REPOSITORY extends JpaRepository<ENTITY, ID>> {

	private final CreateService<ID, ENTITY, DTO, MAPPER, REPOSITORY> service;

	@PostMapping("/save-one")
	public ID save(final DTO dto) throws TechnicalException {
		return service.save(dto);
	}

	@PostMapping("/save-all")
	public Collection<ID> saveAll(final Collection<DTO> dtos) throws TechnicalException {
		return service.save(dtos);
	}

}
