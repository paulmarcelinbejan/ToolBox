package ${PACKAGE}.${ENTITY_LOWERCASE}.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};

@Repository
public interface ${ENTITY}Repository extends JpaRepository<${ENTITY}, ${ID_TYPE}> {

}
