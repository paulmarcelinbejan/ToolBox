package com.paulmarcelinbejan.toolbox.web.service.utils;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.paulmarcelinbejan.toolbox.exception.technical.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToEntity;

import lombok.RequiredArgsConstructor;

/**
 * @author paulmarcelinbejan
 *
 * @param <ID>
 * @param <ENTITY>
 * @param <DTO>
 * @param <MAPPER>
 * @param <REPOSITORY>
 */
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
@RequiredArgsConstructor
public class CreateService<
		ID,
		ENTITY,
		DTO,
		MAPPER extends BaseMapperToEntity<ENTITY, DTO>,
		REPOSITORY extends JpaRepository<ENTITY, ID>> {

	private final MAPPER mapper;

	private final REPOSITORY repository;

	private final Class<ENTITY> entityClass;

	public ID save(DTO dto) throws TechnicalException {
		ENTITY entity = mapper.toEntity(dto);

		entity = repository.save(entity);

		return ServiceUtils.retrieveId(entity, entityClass);
	}

	public Collection<ID> save(Collection<DTO> dtos) throws TechnicalException {
		Collection<ENTITY> entities = mapper.toEntities(dtos);

		entities = repository.saveAll(entities);

		return ServiceUtils.retrieveIds(entities, entityClass);
	}

}
