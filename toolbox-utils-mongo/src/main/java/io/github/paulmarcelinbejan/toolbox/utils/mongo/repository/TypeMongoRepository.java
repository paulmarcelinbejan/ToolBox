package io.github.paulmarcelinbejan.toolbox.utils.mongo.repository;

import org.springframework.data.repository.NoRepositoryBean;

import io.github.paulmarcelinbejan.toolbox.utils.mongo.document.TypeDocument;

@NoRepositoryBean
public interface TypeMongoRepository<DOCUMENT extends TypeDocument> extends CategorizationMongoRepository<DOCUMENT> {

}
