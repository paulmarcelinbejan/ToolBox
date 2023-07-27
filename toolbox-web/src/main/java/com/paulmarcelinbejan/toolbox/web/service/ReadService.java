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

	/**
	 * If some or all ids are not found, no entities are returned for these IDs.
	 */
	Collection<ENTITY> findManyById(Collection<ID> ids);

	/**
	 * If some or all ids are not found, no DTOs are returned for these IDs.
	 */
	Collection<DTO> findManyByIdToDto(Collection<ID> ids);

	Collection<ENTITY> findAll();

	Collection<DTO> findAllToDto();

}
