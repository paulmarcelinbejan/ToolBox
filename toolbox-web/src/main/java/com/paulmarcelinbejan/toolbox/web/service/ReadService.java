package com.paulmarcelinbejan.toolbox.web.service;

import java.util.Collection;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

/**
 *
 * Basic methods for read operation.
 *
 * @author paulmarcelinbejan
 *
 */
public interface ReadService<ID, ENTITY, DTO> {

	ENTITY findById(ID id) throws FunctionalException;

	DTO findByIdToDto(ID id) throws FunctionalException;

	Collection<ENTITY> findManyById(Collection<ID> ids) throws FunctionalException;

	/**
	 * If some or all ids are not found, no entities are returned for these IDs.
	 */
	Collection<ENTITY> findManyByIdIfPresent(Collection<ID> ids);
	
	Collection<DTO> findManyByIdToDto(Collection<ID> ids) throws FunctionalException;

	/**
	 * If some or all ids are not found, no DTOs are returned for these IDs.
	 */
	Collection<DTO> findManyByIdToDtoIfPresent(Collection<ID> ids);

	Collection<ENTITY> findAll();

	Collection<DTO> findAllToDto();

}
