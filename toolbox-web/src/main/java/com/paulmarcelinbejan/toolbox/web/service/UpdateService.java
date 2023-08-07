package com.paulmarcelinbejan.toolbox.web.service;

import java.util.Collection;

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;

/**
 *
 * Basic methods for update operation.
 *
 * @author paulmarcelinbejan
 *
 */
public interface UpdateService<ID, DTO> {

	ID update(DTO dto) throws FunctionalException, TechnicalException;

	DTO updateAndReturn(DTO dto) throws FunctionalException, TechnicalException;
	
	Collection<ID> update(Collection<DTO> dtos) throws FunctionalException, TechnicalException;
	
	Collection<DTO> updateAndReturn(Collection<DTO> dtos) throws FunctionalException, TechnicalException;

}
