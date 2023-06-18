package com.paulmarcelinbejan.toolbox.web.service;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paulmarcelinbejan.toolbox.exception.technical.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToEntity;
import com.paulmarcelinbejan.toolbox.web.service.utils.ServiceUtils;

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
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
@RequiredArgsConstructor
public class CreateService<
		ID,
		ENTITY,
		DTO,
		MAPPER extends BaseMapperToEntity<ENTITY, DTO>,
		REPOSITORY extends JpaRepository<ENTITY, ID>> {

	protected final MAPPER mapper;

	protected final REPOSITORY repository;

	@Setter
	private Class<ENTITY> entityClass;

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
