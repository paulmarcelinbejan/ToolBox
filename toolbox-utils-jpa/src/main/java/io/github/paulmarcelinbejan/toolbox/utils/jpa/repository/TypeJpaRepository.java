package io.github.paulmarcelinbejan.toolbox.utils.jpa.repository;

import org.springframework.data.repository.NoRepositoryBean;

import io.github.paulmarcelinbejan.toolbox.utils.jpa.entity.TypeEntity;

@NoRepositoryBean
public interface TypeJpaRepository<ENTITY extends TypeEntity> extends CategorizationJpaRepository<ENTITY> {

}
