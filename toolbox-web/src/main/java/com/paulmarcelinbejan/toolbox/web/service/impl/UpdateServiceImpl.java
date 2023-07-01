package com.paulmarcelinbejan.toolbox.web.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulmarcelinbejan.toolbox.exception.technical.FunctionalException;
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

	private final Class<ENTITY> entityClass;

	private final Class<DTO> dtoClass;

	@Override
	public ID update(DTO dto) throws FunctionalException, TechnicalException {

		ID id = ServiceUtils.retrieveId(dto, dtoClass, entityClass);

		ENTITY entity = readService.findById(id);

		mapper.updateEntityFromDto(entity, dto);

		entity = repository.save(entity);

		return ServiceUtils.retrieveId(entity, entityClass);

	}

	@Override
	public Collection<ID> update(Collection<DTO> dtos) throws FunctionalException, TechnicalException {
		Collection<ID> ids = new ArrayList<>();

		for (DTO dto : dtos) {
			ids.add(update(dto));
		}

		return ids;
	}

}
