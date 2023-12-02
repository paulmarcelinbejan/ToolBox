package io.github.paulmarcelinbejan.toolbox.service.helper;

import io.github.paulmarcelinbejan.toolbox.service.helper.delete.DeleteIfPresentServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.delete.DeleteThrowsExceptionIfNotFoundServiceHelper;

/**
 *
 * Basic methods for delete operation.
 *
 * @author paulmarcelinbejan
 *
 */
public interface DeleteServiceHelper<ID> extends 
				 DeleteThrowsExceptionIfNotFoundServiceHelper<ID>, 
				 DeleteIfPresentServiceHelper<ID> {

}
