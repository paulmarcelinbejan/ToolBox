package ${PACKAGE}.${ENTITY_LOWERCASE}.mapper;

import java.util.Collection;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Dto;
import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToEntityAndToDTO;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class ${ENTITY}Mapper implements BaseMapperToEntityAndToDTO<${ENTITY}, ${ENTITY}Dto> {

	@Override
	@Named("toEntity")
	public abstract ${ENTITY} toEntity(${ENTITY}Dto dto);

	@Override
	@IterableMapping(qualifiedByName = "toEntity")
	public abstract Collection<${ENTITY}> toEntities(Collection<${ENTITY}Dto> dtos);

	@Override
	@Named("toDto")
	public abstract ${ENTITY}Dto toDto(${ENTITY} entity);

	@Override
	@IterableMapping(qualifiedByName = "toDto")
	public abstract Collection<${ENTITY}Dto> toDtos(Collection<${ENTITY}> entities);

	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget ${ENTITY} toUpdate, ${ENTITY} newValue);

}