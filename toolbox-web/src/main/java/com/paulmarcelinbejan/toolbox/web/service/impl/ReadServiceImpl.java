package com.paulmarcelinbejan.toolbox.web.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;

import lombok.RequiredArgsConstructor;

/**
 *
 * Basic methods for read operation.
 *
 * @author paulmarcelinbejan
 *
 */
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReadServiceImpl<
		ID,
		ENTITY,
		REPOSITORY extends JpaRepository<ENTITY, ID>>
		implements
		ReadService<ID, ENTITY> {

	private final REPOSITORY repository;
	
	/**
	 * This can be a dynamic message, 
	 * Use {0} inside the message as placeholder to be replaced by the id that was not found on DB.
	 */
	private final String errorMessageIfEntityNotFound;

	@Override
	public ENTITY getReferenceById(ID id) {
		return repository.getReferenceById(id);
	}
	
	@Override
	public ENTITY findById(ID id) throws FunctionalException {
		return repository
				.findById(id)
				.orElseThrow(() -> new FunctionalException(MessageFormat.format(errorMessageIfEntityNotFound, id)));
	}

	@Override
	public Collection<ENTITY> findManyById(Collection<ID> ids) throws FunctionalException {
		Collection<ENTITY> entities = new ArrayList<>();
		for(ID id : ids) {
			entities.add(findById(id));
		}
		return entities;
	}

	@Override
	public Collection<ENTITY> findManyByIdIfPresent(Collection<ID> ids) {
		return repository.findAllById(ids);
	}

	@Override
	public Collection<ENTITY> findAll() {
		return repository.findAll();
	}

}
