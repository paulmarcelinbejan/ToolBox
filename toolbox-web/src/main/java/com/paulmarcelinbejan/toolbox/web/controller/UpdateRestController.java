package com.paulmarcelinbejan.toolbox.web.controller;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PutMapping;

import com.paulmarcelinbejan.toolbox.exception.technical.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToEntityAndToDTO;
import com.paulmarcelinbejan.toolbox.web.service.UpdateService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class UpdateRestController<
		ID,
		ENTITY,
		DTO,
		MAPPER extends BaseMapperToEntityAndToDTO<ENTITY, DTO>,
		REPOSITORY extends JpaRepository<ENTITY, ID>> {

	private final UpdateService<ID, ENTITY, DTO, MAPPER, REPOSITORY> service;

	@PutMapping("/update-one")
	public ID update(final DTO dto) throws FunctionalException, TechnicalException {
		return service.update(dto);
	}

	@PutMapping("/update-all")
	public Collection<ID> updateAll(final Collection<DTO> dtos) throws FunctionalException, TechnicalException {
		return service.update(dtos);
	}

}
