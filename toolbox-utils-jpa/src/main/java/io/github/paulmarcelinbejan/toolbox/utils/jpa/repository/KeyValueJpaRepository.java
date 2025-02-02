package io.github.paulmarcelinbejan.toolbox.utils.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import io.github.paulmarcelinbejan.toolbox.utils.jpa.entities.KeyValueEntity;

@NoRepositoryBean
public interface KeyValueJpaRepository<ENTITY extends KeyValueEntity> extends JpaRepository<ENTITY, Integer> {

	Optional<ENTITY> findByKey(String key);

}
