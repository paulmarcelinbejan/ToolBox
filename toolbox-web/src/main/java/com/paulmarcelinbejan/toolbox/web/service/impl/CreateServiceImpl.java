package com.paulmarcelinbejan.toolbox.web.service.impl;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToEntity;
import com.paulmarcelinbejan.toolbox.web.service.CreateService;
import com.paulmarcelinbejan.toolbox.web.service.utils.ServiceUtils;

import lombok.RequiredArgsConstructor;

/**
 *
 * Basic methods for create operation.
 *
 * @author paulmarcelinbejan
 *
 */
@RequiredArgsConstructor
public class CreateServiceImpl<
		ID,
		ENTITY,
		DTO,
		MAPPER extends BaseMapperToEntity<ENTITY, DTO>,
		REPOSITORY extends JpaRepository<ENTITY, ID>>
		implements
		CreateService<ID, DTO> {

	private final MAPPER mapper;

	private final REPOSITORY repository;

	private final Class<ENTITY> entityClass;

	@Override
	public ID save(DTO dto) throws TechnicalException {
		ENTITY entity = mapper.toEntity(dto);

		entity = repository.save(entity);

		return ServiceUtils.retrieveId(entity, entityClass);
	}

	@Override
	public Collection<ID> save(Collection<DTO> dtos) throws TechnicalException {
		Collection<ENTITY> entities = mapper.toEntities(dtos);

		entities = repository.saveAll(entities);

		return ServiceUtils.retrieveIds(entities, entityClass);
	}

}
