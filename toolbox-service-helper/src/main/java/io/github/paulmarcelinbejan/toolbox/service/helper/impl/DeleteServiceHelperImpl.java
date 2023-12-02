package io.github.paulmarcelinbejan.toolbox.service.helper.impl;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.service.helper.DeleteServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;
import lombok.RequiredArgsConstructor;

/**
 *
 * Basic methods for delete operation.
 *
 * @author paulmarcelinbejan
 *
 */
@Transactional
@RequiredArgsConstructor
public class DeleteServiceHelperImpl<
		ID,
		ENTITY,
		REPOSITORY extends JpaRepository<ENTITY, ID>>
		implements
		DeleteServiceHelper<ID> {

	private final REPOSITORY repository;

	private final ReadServiceHelper<ID, ENTITY> readServiceHelper;

	@Override
	public void delete(ID id) throws FunctionalException {
		ENTITY entity = readServiceHelper.findById(id);
		repository.delete(entity);
	}
	
	@Override
	public void deleteIfPresent(ID id) {
		repository.deleteById(id);
	}

	@Override
	public void deleteMany(Collection<ID> ids) throws FunctionalException {
		for (ID id : ids) {
			delete(id);
		}
	}

	@Override
	public void deleteManyIfPresent(Collection<ID> ids) {
		repository.deleteAllById(ids);
	}

}
