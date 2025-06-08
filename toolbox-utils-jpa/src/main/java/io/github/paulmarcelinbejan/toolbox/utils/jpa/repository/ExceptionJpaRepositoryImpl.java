package io.github.paulmarcelinbejan.toolbox.utils.jpa.repository;

import org.springframework.stereotype.Repository;

import io.github.paulmarcelinbejan.toolbox.utils.jpa.entity.ExceptionEntity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ExceptionJpaRepositoryImpl {

	private final EntityManager entityManager;

	/**
	 * Differently from JpaRepository implementation, 
	 * this save does not execute a SELECT before insert into table.
	 */
	@Transactional
	public <EE extends ExceptionEntity> EE save(EE entity) {
		entityManager.persist(entity);
		return entity;
	}

}