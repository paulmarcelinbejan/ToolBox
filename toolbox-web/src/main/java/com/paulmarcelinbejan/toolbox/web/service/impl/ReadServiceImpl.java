package com.paulmarcelinbejan.toolbox.web.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToDTO;
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
		DTO,
		MAPPER extends BaseMapperToDTO<ENTITY, DTO>,
		REPOSITORY extends JpaRepository<ENTITY, ID>>
		implements
		ReadService<ID, ENTITY, DTO> {

	private final MAPPER mapper;

	private final REPOSITORY repository;
	
	/**
	 * This can be a dynamic message, 
	 * just put {0} inside your message to be replaced by the id that was not found on DB.
	 */
	private final String errorMessageIfEntityNotFound;

	@Override
	public ENTITY findById(ID id) throws FunctionalException {
		return repository
				.findById(id)
				.orElseThrow(() -> new FunctionalException(MessageFormat.format(errorMessageIfEntityNotFound, id)));
	}

	@Override
	public DTO findByIdToDto(ID id) throws FunctionalException {
		ENTITY entity = findById(id);
		return mapper.toDto(entity);
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
	public Collection<DTO> findManyByIdToDto(Collection<ID> ids) throws FunctionalException {
		Collection<ENTITY> entities = findManyById(ids);
		return mapper.toDtos(entities);
	}
	
	@Override
	public Collection<DTO> findManyByIdToDtoIfPresent(Collection<ID> ids) {
		Collection<ENTITY> entities = findManyByIdIfPresent(ids);
		return mapper.toDtos(entities);
	}

	@Override
	public Collection<ENTITY> findAll() {
		return repository.findAll();
	}

	@Override
	public Collection<DTO> findAllToDto() {
		return mapper.toDtos(findAll());
	}

}
