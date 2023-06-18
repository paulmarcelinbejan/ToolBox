package com.paulmarcelinbejan.toolbox.web.service;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paulmarcelinbejan.toolbox.exception.technical.FunctionalException;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToDTO;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author paulmarcelinbejan
 *
 * @param <ID>
 * @param <ENTITY>
 * @param <DTO>
 * @param <MAPPER>
 * @param <REPOSITORY>
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReadService<
		ID,
		ENTITY,
		DTO,
		MAPPER extends BaseMapperToDTO<ENTITY, DTO>,
		REPOSITORY extends JpaRepository<ENTITY, ID>> {

	protected final MAPPER mapper;

	protected final REPOSITORY repository;

	@Setter
	private Class<ENTITY> entityClass;

	public ENTITY findById(ID id) throws FunctionalException {
		return repository
				.findById(id)
				.orElseThrow(() -> new FunctionalException(
						"No " + entityClass.getSimpleName() + " found with the id: " + id));
	}

	public DTO findByIdToDto(ID id) throws FunctionalException {
		return mapper.toDto(findById(id));
	}

	/**
	 * If some or all ids are not found, no entities are returned for these IDs.
	 */
	public Collection<ENTITY> findManyById(Collection<ID> ids) {
		return repository.findAllById(ids);
	}

	/**
	 * If some or all ids are not found, no DTOs are returned for these IDs.
	 */
	public Collection<DTO> findManyByIdToDto(Collection<ID> ids) {
		return mapper.toDtos(findManyById(ids));
	}

	public Collection<ENTITY> findAll() {
		return repository.findAll();
	}

	public Collection<DTO> findAllToDto() {
		return mapper.toDtos(findAll());
	}

}
