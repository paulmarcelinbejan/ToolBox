package com.paulmarcelinbejan.toolbox.web.controller;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.paulmarcelinbejan.toolbox.exception.technical.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToEntityAndToDTO;
import com.paulmarcelinbejan.toolbox.web.dto.OkResponse;
import com.paulmarcelinbejan.toolbox.web.service.CreateService;
import com.paulmarcelinbejan.toolbox.web.service.DeleteService;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;
import com.paulmarcelinbejan.toolbox.web.service.UpdateService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class CrudRestController<
		ID,
		ENTITY,
		DTO,
		MAPPER extends BaseMapperToEntityAndToDTO<ENTITY, DTO>,
		REPOSITORY extends JpaRepository<ENTITY, ID>> {

	private final ReadService<ID, ENTITY, DTO, MAPPER, REPOSITORY> readService;

	private final CreateService<ID, ENTITY, DTO, MAPPER, REPOSITORY> createService;

	private final UpdateService<ID, ENTITY, DTO, MAPPER, REPOSITORY> updateService;

	private final DeleteService<ID, ENTITY, DTO, MAPPER, REPOSITORY> deleteService;

	@GetMapping("/{id}")
	public DTO findById(@PathVariable ID id) throws FunctionalException {
		return readService.findByIdToDto(id);
	}

	@GetMapping("/")
	public Collection<DTO> findAll() {
		return readService.findAllToDto();
	}

	@PostMapping("/save-one")
	public ID save(final DTO dto) throws TechnicalException {
		return createService.save(dto);
	}

	@PostMapping("/save-all")
	public Collection<ID> saveAll(final Collection<DTO> dtos) throws TechnicalException {
		return createService.save(dtos);
	}

	@PutMapping("/update-one")
	public ID update(final DTO dto) throws FunctionalException, TechnicalException {
		return updateService.update(dto);
	}

	@PutMapping("/update-all")
	public Collection<ID> updateAll(final Collection<DTO> dtos) throws FunctionalException, TechnicalException {
		return updateService.update(dtos);
	}

	@DeleteMapping("/{id}")
	public OkResponse delete(@PathVariable ID id) throws FunctionalException {
		deleteService.delete(id);
		return new OkResponse();
	}

	@DeleteMapping("/")
	public OkResponse delete(Collection<ID> ids) throws FunctionalException {
		deleteService.delete(ids);
		return new OkResponse();
	}

}
