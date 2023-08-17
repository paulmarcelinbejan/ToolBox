package com.paulmarcelinbejan.toolbox.web.service.impl;

import java.util.Collection;
import java.util.function.Function;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.paulmarcelinbejan.toolbox.web.service.CreateService;

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
public class CreateServiceImpl<
		ID,
		ENTITY,
		REPOSITORY extends JpaRepository<ENTITY, ID>>
		implements
		CreateService<ID, ENTITY> {

	private final REPOSITORY repository;
	
	private final Function<ENTITY, ID> entityGetterId;

	@Override
	public ID save(ENTITY entity) {
		entity = saveAndReturn(entity);
		return entityGetterId.apply(entity);
	}
	
	@Override
	public ENTITY saveAndReturn(ENTITY entity) {
		entity = repository.save(entity);
		return entity;
	}

	@Override
	public Collection<ID> save(Collection<ENTITY> entities) {
		entities = saveAndReturn(entities);
		return entities.stream().map(entityGetterId).toList();
	}
	
	@Override
	public Collection<ENTITY> saveAndReturn(Collection<ENTITY> entities) {
		entities = repository.saveAll(entities);
		return entities;
	}

}
