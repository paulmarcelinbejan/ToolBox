package io.github.paulmarcelinbejan.toolbox.utils.mongo.repository;

import org.springframework.data.repository.NoRepositoryBean;

import io.github.paulmarcelinbejan.toolbox.utils.mongo.document.StatusDocument;

@NoRepositoryBean
public interface StatusMongoRepository<DOCUMENT extends StatusDocument> extends CategorizationMongoRepository<DOCUMENT> {

}
