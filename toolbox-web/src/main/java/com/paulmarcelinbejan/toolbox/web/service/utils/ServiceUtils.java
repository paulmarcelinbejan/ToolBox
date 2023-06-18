package com.paulmarcelinbejan.toolbox.web.service.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.utils.reflection.ReflectionUtils;
import com.paulmarcelinbejan.toolbox.utils.reflection.exception.ReflectionException;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ServiceUtils {

	@SuppressWarnings("unchecked")
	public static <ID, ENTITY> ID retrieveId(ENTITY entity, Class<ENTITY> entityClass) throws TechnicalException {
		try {
			return (ID) ReflectionUtils.invokeMethod(entity, entityIdGetter(entityClass));
		} catch (ReflectionException e) {
			throw new TechnicalException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <ID, ENTITY> Collection<ID> retrieveIds(Collection<ENTITY> entities, Class<ENTITY> entityClass)
			throws TechnicalException {
		try {
			Method idGetter = entityIdGetter(entityClass);

			Collection<ID> ids = new ArrayList<>();

			for (ENTITY entity : entities) {
				ids.add((ID) ReflectionUtils.invokeMethod(entity, idGetter));
			}

			return ids;
		} catch (ReflectionException e) {
			throw new TechnicalException(e);
		}
	}

	public static <ENTITY> Method entityIdGetter(Class<ENTITY> entityClass) throws ReflectionException {
		Field idField = ReflectionUtils.getFirstFieldAnnotatedWith(entityClass, jakarta.persistence.Id.class);
		return ReflectionUtils.getPublicGetterOfField(entityClass, idField);
	}

	@SuppressWarnings("unchecked")
	public static <ID, ENTITY, DTO> ID retrieveId(DTO dto, Class<DTO> dtoClass, Class<ENTITY> entityClass)
			throws TechnicalException {
		try {
			Field idEntity = ReflectionUtils.getFirstFieldAnnotatedWith(entityClass, jakarta.persistence.Id.class);
			Field idDto = ReflectionUtils.getFieldByName(dtoClass, idEntity.getName());
			Method getIdDto = ReflectionUtils.getPublicGetterOfField(dtoClass, idDto);
			return (ID) ReflectionUtils.invokeMethod(dto, getIdDto);
		} catch (ReflectionException e) {
			throw new TechnicalException(e);
		}
	}

}
