package ${PACKAGE}.${ENTITY_LOWERCASE}.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;
import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}SaveRequest;
import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}UpdateRequest;
import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};

import io.github.paulmarcelinbejan.toolbox.service.helper.mapping.FullMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class ${ENTITY}Mapper implements FullMapper<${ENTITY}, ${ENTITY}SaveRequest, ${ENTITY}UpdateRequest, ${ENTITY}Response> {

	@Override
	@Named("fromSaveRequestToEntity")
	@Mapping(target = "id", ignore = true)
	public abstract ${ENTITY} fromSaveRequestToEntity(${ENTITY}SaveRequest saveRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToEntity")
	public abstract List<${ENTITY}> fromSaveRequestsToEntities(Collection<${ENTITY}SaveRequest> saveRequests);

	@Override
	@Named("fromUpdateRequestToEntity")
	@Mapping(target = "id", ignore = true)
	public abstract ${ENTITY} fromUpdateRequestToEntity(${ENTITY}UpdateRequest updateRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToEntity")
	public abstract List<${ENTITY}> fromUpdateRequestsToEntities(Collection<${ENTITY}UpdateRequest> updateRequests);

	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget ${ENTITY} toUpdate, ${ENTITY} newValue);

	@Override
	@Named("toResponse")
	public abstract ${ENTITY}Response toResponse(${ENTITY} entity);

	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	public abstract List<${ENTITY}Response> toResponses(Collection<${ENTITY}> entities);

}