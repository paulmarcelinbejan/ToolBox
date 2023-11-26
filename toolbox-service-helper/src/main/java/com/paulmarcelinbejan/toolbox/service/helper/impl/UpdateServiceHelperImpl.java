package com.paulmarcelinbejan.toolbox.service.helper.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.UpdateServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.mapping.MapperUpdateEntity;

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
public class UpdateServiceHelperImpl<
		ID,
		ENTITY,
		REPOSITORY extends JpaRepository<ENTITY, ID>,
		MAPPER extends MapperUpdateEntity<ENTITY>>
		implements
		UpdateServiceHelper<ID, ENTITY> {

	private final REPOSITORY repository;
	
	private final MAPPER mapper;
	
	private final ReadServiceHelper<ID, ENTITY> readServiceHelper;

	private final Function<ENTITY, ID> entityGetterId;

	@Override
	public ID update(ENTITY entity) throws FunctionalException {
		entity = updateAndReturn(entity);
		return entityGetterId.apply(entity);
	}

	@Override
	public ENTITY updateAndReturn(ENTITY newEntity) throws FunctionalException {
		ENTITY entity = readServiceHelper.findById(entityGetterId.apply(newEntity));
		mapper.updateEntity(entity, newEntity);
		entity = repository.save(entity);
		return entity;
	}
	
	@Override
	public List<ID> update(Collection<ENTITY> entities) throws FunctionalException {
		List<ID> ids = new ArrayList<>();
		for (ENTITY entity : entities) {
			ids.add(update(entity));
		}
		return ids;
	}

	@Override
	public List<ENTITY> updateAndReturn(Collection<ENTITY> entities) throws FunctionalException {
		List<ENTITY> entitiesUpdated = new ArrayList<>();
		for (ENTITY entity : entities) {
			entitiesUpdated.add(updateAndReturn(entity));
		}
		return entitiesUpdated;
	}

}
