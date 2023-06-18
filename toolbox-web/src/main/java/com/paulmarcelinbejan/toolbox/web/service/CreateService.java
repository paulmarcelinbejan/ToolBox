package com.paulmarcelinbejan.toolbox.web.service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paulmarcelinbejan.toolbox.exception.technical.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToEntity;
import com.paulmarcelinbejan.toolbox.utils.reflection.ReflectionUtils;
import com.paulmarcelinbejan.toolbox.utils.reflection.exception.ReflectionException;

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

	@SuppressWarnings("unchecked")
	public ID save(DTO dto) throws TechnicalException {
		ENTITY entity = mapper.toEntity(dto);

		entity = repository.save(entity);

		try {
			Field idField = ReflectionUtils.getFirstFieldAnnotatedWith(entityClass, jakarta.persistence.Id.class);
			Method idGetter = ReflectionUtils.getPublicGetterOfField(entityClass, idField);
			return (ID) ReflectionUtils.invokeMethod(entity, idGetter);
		} catch (ReflectionException e) {
			throw new TechnicalException(e);
		}
	}

	public Collection<ID> save(Collection<DTO> dtos) throws TechnicalException {
		Collection<ID> savedIds = new ArrayList<>();

		for (DTO dto : dtos) {
			ID id = save(dto);
			savedIds.add(id);
		}

		return savedIds;
	}

}
