package com.paulmarcelinbejan.toolbox.web.service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zalando.fauxpas.FauxPas;

import com.paulmarcelinbejan.toolbox.exception.technical.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToEntityAndToDTO;
import com.paulmarcelinbejan.toolbox.utils.reflection.ReflectionUtils;
import com.paulmarcelinbejan.toolbox.utils.reflection.exception.ReflectionException;

import jakarta.annotation.PostConstruct;
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
public class UpdateService<
		ID,
		ENTITY,
		DTO,
		MAPPER extends BaseMapperToEntityAndToDTO<ENTITY, DTO>,
		REPOSITORY extends JpaRepository<ENTITY, ID>> {

	private final MAPPER mapper;

	private final REPOSITORY repository;

	private final ReadService<ID, ENTITY, DTO, MAPPER, REPOSITORY> readService;

	@Setter
	private Class<ID> idClass;

	@Setter
	private Class<ENTITY> entityClass;

	@Setter
	private Class<DTO> dtoClass;

	@PostConstruct
	public void injectClassOnBean() {
		readService.setEntityClass(entityClass);
	}

	@SuppressWarnings("unchecked")
	public ID update(DTO dto) throws FunctionalException, TechnicalException {

		ID id;
		Method getIdEntity;
		try {
			Field idEntity = ReflectionUtils.getFirstFieldAnnotatedWith(entityClass, jakarta.persistence.Id.class);
			getIdEntity = ReflectionUtils.getPublicGetterOfField(entityClass, idEntity);

			Field idDto = ReflectionUtils.getFieldByName(dtoClass, idEntity.getName());
			Method getIdDto = ReflectionUtils.getPublicGetterOfField(dtoClass, idDto);
			id = (ID) ReflectionUtils.invokeMethod(dto, getIdDto);
		} catch (ReflectionException e) {
			throw new TechnicalException(e);
		}

		ENTITY entity = readService.findById(id);

		mapper.updateEntityFromDto(entity, dto);

		entity = repository.save(entity);

		try {
			return (ID) ReflectionUtils.invokeMethod(entity, getIdEntity);
		} catch (ReflectionException e) {
			throw new TechnicalException(e);
		}
	}

	public Collection<ID> update(Collection<DTO> dtos) {
		return dtos
				.stream()
				.map(FauxPas.throwingFunction(this::update))
				.toList();
	}

}
