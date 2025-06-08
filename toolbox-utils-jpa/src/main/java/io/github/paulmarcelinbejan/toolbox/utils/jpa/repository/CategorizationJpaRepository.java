package io.github.paulmarcelinbejan.toolbox.utils.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import io.github.paulmarcelinbejan.toolbox.utils.jpa.entity.CategorizationEntity;

@NoRepositoryBean
public interface CategorizationJpaRepository<ENTITY extends CategorizationEntity> extends JpaRepository<ENTITY, Integer> {

	Optional<ENTITY> findByCode(String code);

}
