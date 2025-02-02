package io.github.paulmarcelinbejan.toolbox.utils.jpa.repository;

import org.springframework.data.repository.NoRepositoryBean;

import io.github.paulmarcelinbejan.toolbox.utils.jpa.entities.StatusEntity;

@NoRepositoryBean
public interface StatusJpaRepository<ENTITY extends StatusEntity> extends CategorizationJpaRepository<ENTITY> {

}
