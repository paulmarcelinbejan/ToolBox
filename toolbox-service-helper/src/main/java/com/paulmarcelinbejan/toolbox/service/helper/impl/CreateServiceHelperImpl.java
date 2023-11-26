package com.paulmarcelinbejan.toolbox.service.helper.impl;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.paulmarcelinbejan.toolbox.service.helper.CreateServiceHelper;

import lombok.RequiredArgsConstructor;

/**
 *
 * Basic methods for create operation.
 *
 * @author paulmarcelinbejan
 *
 */
@Transactional
@RequiredArgsConstructor
public class CreateServiceHelperImpl<
		ID,
		ENTITY,
		REPOSITORY extends JpaRepository<ENTITY, ID>>
		implements
		CreateServiceHelper<ID, ENTITY> {

	private final REPOSITORY repository;
	
	private final Function<ENTITY, ID> entityGetterId;

	@Override
	public ID save(ENTITY entity) {
		ENTITY savedEntity = saveAndReturn(entity);
		ID id = entityGetterId.apply(savedEntity);
		return id;
	}
	
	@Override
	public ENTITY saveAndReturn(ENTITY entity) {
		ENTITY savedEntity = repository.save(entity);
		return savedEntity;
	}

	@Override
	public List<ID> save(Collection<ENTITY> entities) {
		List<ENTITY> savedEntities = saveAndReturn(entities);
		List<ID> ids = savedEntities.stream().map(entityGetterId).toList();
		return ids;
	}
	
	@Override
	public List<ENTITY> saveAndReturn(Collection<ENTITY> entities) {
		List<ENTITY> savedEntities = repository.saveAll(entities);
		return savedEntities;
	}

}
