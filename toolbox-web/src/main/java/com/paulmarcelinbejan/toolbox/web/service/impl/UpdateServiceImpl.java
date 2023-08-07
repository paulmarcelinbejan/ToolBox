package com.paulmarcelinbejan.toolbox.web.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToEntityAndToDTO;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;
import com.paulmarcelinbejan.toolbox.web.service.UpdateService;
import com.paulmarcelinbejan.toolbox.web.service.utils.ServiceUtils;

import lombok.RequiredArgsConstructor;

/**
 *
 * Basic methods for update operation.
 *
 * @author paulmarcelinbejan
 *
 */
@RequiredArgsConstructor
public class UpdateServiceImpl<
		ID,
		ENTITY,
		DTO,
		MAPPER extends BaseMapperToEntityAndToDTO<ENTITY, DTO>,
		REPOSITORY extends JpaRepository<ENTITY, ID>>
		implements
		UpdateService<ID, DTO> {

	private final MAPPER mapper;

	private final REPOSITORY repository;

	private final ReadService<ID, ENTITY, DTO> readService;

	private final Function<ENTITY, ID> entityGetterId;
	
	private final Function<DTO, ID> dtoGetterId;

	@Override
	public ID update(DTO dto) throws FunctionalException {
		ENTITY entity = updateEntityByDto(dto);
		return entityGetterId.apply(entity);
	}

	@Override
	public DTO updateAndReturn(DTO dto) throws FunctionalException {
		ENTITY entity = updateEntityByDto(dto);
		DTO dtoUpdated = mapper.toDto(entity);
		return dtoUpdated;
	}
	
	@Override
	public Collection<ID> update(Collection<DTO> dtos) throws FunctionalException {
		Collection<ID> ids = new ArrayList<>();

		for (DTO dto : dtos) {
			ids.add(update(dto));
		}

		return ids;
	}

	@Override
	public Collection<DTO> updateAndReturn(Collection<DTO> dtos) throws FunctionalException {
		Collection<DTO> dtosUpdated = new ArrayList<>();

		for (DTO dto : dtos) {
			dtosUpdated.add(updateAndReturn(dto));
		}

		return dtosUpdated;
	}

	private ENTITY updateEntityByDto(DTO dto) throws FunctionalException {
		ID id = dtoGetterId.apply(dto);
		ENTITY entity = readService.findById(id);
		mapper.updateEntityFromDto(entity, dto);
		entity = repository.save(entity);
		return entity;
	}

}
