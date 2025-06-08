package io.github.paulmarcelinbejan.toolbox.utils.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.github.paulmarcelinbejan.toolbox.utils.mongo.document.ExceptionDocument;

@Repository
public interface ExceptionMongoRepository extends MongoRepository<ExceptionDocument, String> {

}
