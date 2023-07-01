package com.paulmarcelinbejan.toolbox.web.service.impl;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.paulmarcelinbejan.toolbox.exception.technical.FunctionalException;
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

	private final Class<ENTITY> entityClass;

	@Override
	public ENTITY findById(ID id) throws FunctionalException {
		return repository
				.findById(id)
				.orElseThrow(() -> new FunctionalException(
						"No " + entityClass.getSimpleName() + " found with the id: " + id));
	}

	@Override
	public DTO findByIdToDto(ID id) throws FunctionalException {
		return mapper.toDto(findById(id));
	}

	/**
	 * If some or all ids are not found, no entities are returned for these IDs.
	 */
	@Override
	public Collection<ENTITY> findManyById(Collection<ID> ids) {
		return repository.findAllById(ids);
	}

	/**
	 * If some or all ids are not found, no DTOs are returned for these IDs.
	 */
	@Override
	public Collection<DTO> findManyByIdToDto(Collection<ID> ids) {
		return mapper.toDtos(findManyById(ids));
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
