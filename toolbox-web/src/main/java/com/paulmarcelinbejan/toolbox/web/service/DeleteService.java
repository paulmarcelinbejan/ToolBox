package com.paulmarcelinbejan.toolbox.web.service;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paulmarcelinbejan.toolbox.exception.technical.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToDTO;

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
public class DeleteService<
		ID,
		ENTITY,
		DTO,
		MAPPER extends BaseMapperToDTO<ENTITY, DTO>,
		REPOSITORY extends JpaRepository<ENTITY, ID>> {

	private final REPOSITORY repository;

	private final ReadService<ID, ENTITY, DTO, MAPPER, REPOSITORY> readService;

	@Setter
	private Class<ENTITY> entityClass;

	@PostConstruct
	public void injectClassOnBean() {
		readService.setEntityClass(entityClass);
	}

	public void delete(ID id) throws FunctionalException {
		ENTITY entity = readService.findById(id);
		repository.delete(entity);
	}

	/**
	 * If an Entity is not found in the persistence store, a FunctionalException
	 * will be thrown.
	 */
	public void delete(Collection<ID> ids) throws FunctionalException {
		for (ID id : ids) {
			delete(id);
		}
	}

	/**
	 * Entities that aren't found in the persistence store are silently ignored.
	 */
	public void deleteIfPresent(Collection<ID> ids) {
		repository.deleteAllById(ids);
	}

}
