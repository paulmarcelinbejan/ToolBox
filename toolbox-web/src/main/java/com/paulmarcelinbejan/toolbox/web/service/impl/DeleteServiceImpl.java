package com.paulmarcelinbejan.toolbox.web.service.impl;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.web.service.DeleteService;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;

import lombok.RequiredArgsConstructor;

/**
 *
 * Basic methods for delete operation.
 *
 * @author paulmarcelinbejan
 *
 */
@Transactional
@RequiredArgsConstructor
public class DeleteServiceImpl<
		ID,
		ENTITY,
		REPOSITORY extends JpaRepository<ENTITY, ID>>
		implements
		DeleteService<ID> {

	private final REPOSITORY repository;

	private final ReadService<ID, ENTITY> readService;

	@Override
	public void delete(ID id) throws FunctionalException {
		ENTITY entity = readService.findById(id);
		repository.delete(entity);
	}
	
	@Override
	public void deleteIfPresent(ID id) {
		repository.deleteById(id);
	}

	@Override
	public void deleteMany(Collection<ID> ids) throws FunctionalException {
		for (ID id : ids) {
			delete(id);
		}
	}

	@Override
	public void deleteManyIfPresent(Collection<ID> ids) {
		repository.deleteAllById(ids);
	}

}
