package ${PACKAGE}.${ENTITY_LOWERCASE}.service;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Dto;
import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};
import com.paulmarcelinbejan.toolbox.web.service.CrudService;

public interface ${ENTITY}Service extends CrudService<${ID_TYPE}, ${ENTITY}, ${ENTITY}Dto> {

}
