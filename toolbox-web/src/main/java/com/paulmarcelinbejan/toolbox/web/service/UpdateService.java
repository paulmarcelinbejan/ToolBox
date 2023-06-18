package com.paulmarcelinbejan.toolbox.web.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paulmarcelinbejan.toolbox.exception.technical.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToEntityAndToDTO;
import com.paulmarcelinbejan.toolbox.web.service.utils.ServiceUtils;

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

	public ID update(DTO dto) throws FunctionalException, TechnicalException {

		ID id = ServiceUtils.retrieveId(dto, dtoClass, entityClass);

		ENTITY entity = readService.findById(id);

		mapper.updateEntityFromDto(entity, dto);

		entity = repository.save(entity);

		return ServiceUtils.retrieveId(entity, entityClass);

	}

	public Collection<ID> update(Collection<DTO> dtos) throws FunctionalException, TechnicalException {
		Collection<ID> ids = new ArrayList<>();

		for (DTO dto : dtos) {
			ids.add(update(dto));
		}

		return ids;
	}

}
