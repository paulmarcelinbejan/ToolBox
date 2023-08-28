package com.paulmarcelinbejan.toolbox.web.service;

import com.paulmarcelinbejan.toolbox.web.service.delete.DeleteIfPresentService;
import com.paulmarcelinbejan.toolbox.web.service.delete.DeleteThrowsExceptionIfNotFoundService;

/**
 *
 * Basic methods for delete operation.
 *
 * @author paulmarcelinbejan
 *
 */
public interface DeleteService<ID> extends 
				 DeleteThrowsExceptionIfNotFoundService<ID>, 
				 DeleteIfPresentService<ID> {

}
