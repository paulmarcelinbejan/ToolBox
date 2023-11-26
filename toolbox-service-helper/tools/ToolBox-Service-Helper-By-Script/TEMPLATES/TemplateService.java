package ${PACKAGE}.${ENTITY_LOWERCASE}.service;

import java.util.List;

import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};

public interface ${ENTITY}Service {

	// CREATE 

	${ID_TYPE} save(${ENTITY} entity) throws FunctionalException;
	
	List<${ID_TYPE}> save(List<${ENTITY}> entities) throws FunctionalException;

	${ENTITY} saveAndReturn(${ENTITY} entity) throws FunctionalException;
	
	List<${ENTITY}> saveAndReturn(List<${ENTITY}> entities) throws FunctionalException;

	// READ 

	/**
	 * Returns a reference to the entity with the given identifier.
	 */
	${ENTITY} getReferenceById(${ID_TYPE} id);
	
	${ENTITY} findById(${ID_TYPE} id) throws FunctionalException;

	/**
	 * If an Entity is not found in the persistence store, a FunctionalException will be thrown.
	 */
	List<${ENTITY}> findManyById(List<${ID_TYPE}> ids) throws FunctionalException;

	/**
	 * Entities that aren't found in the persistence store are silently ignored.
	 */
	List<${ENTITY}> findManyByIdIfPresent(List<${ID_TYPE}> ids);

	List<${ENTITY}> findAll();

	// UPDATE 

	${ID_TYPE} update(${ENTITY} entity) throws FunctionalException;
	
	List<${ID_TYPE}> update(List<${ENTITY}> entities) throws FunctionalException;

	${ENTITY} updateAndReturn(${ENTITY} entity) throws FunctionalException;
	
	List<${ENTITY}> updateAndReturn(List<${ENTITY}> entities) throws FunctionalException;

	// DELETE 

	/**
	 * If the Entity is not found in the persistence store, a FunctionalException will be thrown.
	 */
	void delete(${ID_TYPE} id) throws FunctionalException;

	/**
	 * If an Entity is not found in the persistence store, a FunctionalException will be thrown.
	 */
	void deleteMany(List<${ID_TYPE}> ids) throws FunctionalException;

	/**
	 * If the Entity is not present in the persistence store, it will be silently ignored.
	 */
	void deleteIfPresent(${ID_TYPE} id);

	/**
	 * Entities that aren't found in the persistence store are silently ignored.
	 */
	void deleteManyIfPresent(List<${ID_TYPE}> ids);

}
