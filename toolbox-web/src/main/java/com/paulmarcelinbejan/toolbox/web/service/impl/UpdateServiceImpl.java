package com.paulmarcelinbejan.toolbox.web.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.utils.mapping.MapperUpdateEntity;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;
import com.paulmarcelinbejan.toolbox.web.service.UpdateService;

import lombok.RequiredArgsConstructor;

/**
 *
 * Basic methods for update operation.
 *
 * @author paulmarcelinbejan
 *
 */
@Transactional
@RequiredArgsConstructor
public class UpdateServiceImpl<
		ID,
		ENTITY,
		REPOSITORY extends JpaRepository<ENTITY, ID>,
		MAPPER extends MapperUpdateEntity<ENTITY>>
		implements
		UpdateService<ID, ENTITY> {

	private final REPOSITORY repository;
	
	private final MAPPER mapper;
	
	private final ReadService<ID, ENTITY> readService;

	private final Function<ENTITY, ID> entityGetterId;

	@Override
	public ID update(ENTITY entity) throws FunctionalException {
		entity = updateAndReturn(entity);
		return entityGetterId.apply(entity);
	}

	@Override
	public ENTITY updateAndReturn(ENTITY newEntity) throws FunctionalException {
		ENTITY entity = readService.findById(entityGetterId.apply(newEntity));
		mapper.updateEntity(entity, newEntity);
		entity = repository.save(entity);
		return entity;
	}
	
	@Override
	public Collection<ID> update(Collection<ENTITY> entities) throws FunctionalException {
		Collection<ID> ids = new ArrayList<>();
		for (ENTITY entity : entities) {
			ids.add(update(entity));
		}
		return ids;
	}

	@Override
	public Collection<ENTITY> updateAndReturn(Collection<ENTITY> entities) throws FunctionalException {
		Collection<ENTITY> entitiesUpdated = new ArrayList<>();
		for (ENTITY entity : entities) {
			entitiesUpdated.add(updateAndReturn(entity));
		}
		return entitiesUpdated;
	}

}
