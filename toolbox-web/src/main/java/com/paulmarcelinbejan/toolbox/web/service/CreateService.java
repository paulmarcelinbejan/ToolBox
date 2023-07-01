package com.paulmarcelinbejan.toolbox.web.service;

import java.util.Collection;

import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

/**
 *
 * Basic methods for create operation.
 *
 * @author paulmarcelinbejan
 *
 */
public interface CreateService<ID, DTO> {

	ID save(DTO dto) throws TechnicalException;

	Collection<ID> save(Collection<DTO> dtos) throws TechnicalException;

}
