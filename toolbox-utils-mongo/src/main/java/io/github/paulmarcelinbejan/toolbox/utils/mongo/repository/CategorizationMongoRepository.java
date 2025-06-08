package io.github.paulmarcelinbejan.toolbox.utils.mongo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import io.github.paulmarcelinbejan.toolbox.utils.mongo.document.CategorizationDocument;

@NoRepositoryBean
public interface CategorizationMongoRepository<DOCUMENT extends CategorizationDocument> extends MongoRepository<DOCUMENT, Integer> {

	Optional<DOCUMENT> findByCode(String code);

}
