package io.github.paulmarcelinbejan.toolbox.utils.mongo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import io.github.paulmarcelinbejan.toolbox.utils.mongo.document.KeyValueDocument;

@NoRepositoryBean
public interface KeyValueMongoRepository<DOCUMENT extends KeyValueDocument> extends MongoRepository<DOCUMENT, Integer> {

	Optional<DOCUMENT> findByKey(String key);
	
	List<DOCUMENT> findByKeyIn(List<String> keys);

}
