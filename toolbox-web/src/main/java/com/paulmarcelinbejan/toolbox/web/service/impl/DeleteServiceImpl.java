package com.paulmarcelinbejan.toolbox.web.service.impl;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

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
@RequiredArgsConstructor
public class DeleteServiceImpl<
		ID,
		ENTITY,
		DTO,
		REPOSITORY extends JpaRepository<ENTITY, ID>>
		implements
		DeleteService<ID> {

	private final REPOSITORY repository;

	private final ReadService<ID, ENTITY, DTO> readService;

	@Override
	public void delete(ID id) throws FunctionalException {
		ENTITY entity = readService.findById(id);
		repository.delete(entity);
	}
	
	@Override
	public void deleteIfPresent(ID id) throws FunctionalException {
		repository.deleteById(id);
	}

	@Override
	public void delete(Collection<ID> ids) throws FunctionalException {
		for (ID id : ids) {
			delete(id);
		}
	}

	@Override
	public void deleteIfPresent(Collection<ID> ids) {
		repository.deleteAllById(ids);
	}

}
