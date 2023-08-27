package ${PACKAGE}.${ENTITY_LOWERCASE}.mapper;

import java.util.Collection;

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

import com.paulmarcelinbejan.toolbox.utils.mapping.BaseMapperToEntityAndToResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class ${ENTITY}Mapper implements BaseMapperToEntityAndToResponse<${ENTITY}, ${ENTITY}SaveRequest, ${ENTITY}UpdateRequest, ${ENTITY}Response> {

	@Override
	@Named("fromSaveRequestToEntity")
	@Mapping(target = "id", ignore = true)
	public abstract ${ENTITY} fromSaveRequestToEntity(${ENTITY}SaveRequest saveRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToEntity")
	public abstract Collection<${ENTITY}> fromSaveRequestsToEntities(Collection<${ENTITY}SaveRequest> saveRequests);

	@Override
	@Named("fromUpdateRequestToEntity")
	@Mapping(target = "id", ignore = true)
	public abstract ${ENTITY} fromUpdateRequestToEntity(${ENTITY}UpdateRequest updateRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToEntity")
	public abstract Collection<${ENTITY}> fromUpdateRequestsToEntities(Collection<${ENTITY}UpdateRequest> updateRequests);

	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget ${ENTITY} toUpdate, ${ENTITY} newValue);

	@Override
	@Named("toResponse")
	public abstract ${ENTITY}Dto toResponse(${ENTITY} entity);

	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	public abstract Collection<${ENTITY}Dto> toResponses(Collection<${ENTITY}> entities);

}