package com.paulmarcelinbejan.toolbox.utils.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import com.paulmarcelinbejan.toolbox.utils.reflection.exception.ReflectionException;
import com.paulmarcelinbejan.toolbox.utils.text.TextUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReflectionUtils {
	
	@SuppressWarnings("unchecked")
	public static <T> Constructor<T> getNoArgsConstructor(Class<T> clazz) {
		return (Constructor<T>) Arrays
				.asList(clazz.getDeclaredConstructors())
				.stream()
				.filter(constructor -> constructor.getParameterCount() == 0)
				.findAny()
				.orElseThrow(() -> new ReflectionException(MessageFormat.format("Class {} doesn't have a no args contructor.", clazz.getCanonicalName())));
	}

	public static <T> T getNewInstanceViaNoArgsConstructor(Class<T> clazz) {
		try {
			return getNoArgsConstructor(clazz).newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ReflectionException e) {
			throw new ReflectionException(MessageFormat.format("Error handling {} with reflection.", clazz.getCanonicalName()), e);
		}
	}

	public static boolean isFieldAccessible(final Object instance, final Field field) {
		return field.canAccess(instance);
	}
	
	private static void makeFieldAccessible(final Field field) {
		field.setAccessible(true);
	}
	
	public static Object getFieldValue(final Object instance, final Field field) {
		boolean isFieldAccessible = isFieldAccessible(instance, field);
		
		if(!isFieldAccessible) {
			makeFieldAccessible(field);
		}
		
		Object fieldValue;
		try {
			fieldValue = field.get(instance);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ReflectionException(MessageFormat.format("Error retrieving value of field {} with reflection.", field.getName()), e);
		}
		
		if(!isFieldAccessible) {
			field.setAccessible(false);
		}
		
		return fieldValue;
	}
	
	public static <T> Field getFieldByName(Class<T> clazz, String fieldName) {
		return Stream
				// STREAM DECLARED FIELDS
				.of(clazz.getDeclaredFields())
				// FILTER TO FIND FIELD BY NAME
				.filter(field -> TextUtils.isEqualTo(field.getName(), fieldName))
				.findFirst()
				.orElseThrow(() -> new ReflectionException(MessageFormat.format("Class {} doesn't have a field with name {}.", clazz.getCanonicalName(), fieldName)));
	}

	public static <T, A> Field getFirstFieldAnnotatedWith(Class<T> clazz, Class<A> annotationType) {

		return Stream
				// STREAM DECLARED FIELDS
				.of(clazz.getDeclaredFields())
				// FILTER TO FIND FIELDS ANNOTATED WITH PROVIDED ANNOTATION
				.filter(field -> Stream
						.of(field.getDeclaredAnnotations())
						.anyMatch(annotation -> annotationType.equals(annotation.annotationType())))
				.findFirst()
				.orElseThrow(() -> new ReflectionException(MessageFormat.format("Class {} doesn't have a field annotated with {}.", clazz.getCanonicalName(), annotationType.getCanonicalName())));

	}

	public static <T> Method getPublicGetterOfFieldName(Class<T> clazz, String fieldName) {
		String getterNameOfField = GETTER_PREFIX + TextUtils.firstLetterUppercase(fieldName);
		return getPublicGetters(clazz)
				.filter(getter -> getter.getName().contentEquals(getterNameOfField))
				.findFirst()
				.orElseThrow(() -> new ReflectionException(MessageFormat.format("Class {} doesn't have a getter method named {} for field {}.", clazz.getCanonicalName(), getterNameOfField, fieldName)));
	}
	
	public static <T> Method getPublicGetterOfField(Class<T> clazz, Field field) {
		String fieldName = field.getName();
		return getPublicGetterOfFieldName(clazz, fieldName);
	}

	public static Object invokeMethod(Object objectOnWhichToInvokeTheMethod, Method method) {
		try {
			return method.invoke(objectOnWhichToInvokeTheMethod);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new ReflectionException(MessageFormat.format("Error invoking method {} of {}.", method.getName(), objectOnWhichToInvokeTheMethod.getClass().getCanonicalName()));
		}
	}

	public static Object invokeMethod(Object objectOnWhichToInvokeTheMethod, Method method, Object... paramsOfMethod) {
		try {
			return method.invoke(objectOnWhichToInvokeTheMethod, paramsOfMethod);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new ReflectionException(MessageFormat.format("Error invoking method {} of {}.", method.getName(), objectOnWhichToInvokeTheMethod.getClass().getCanonicalName()));
		}
	}
	
    public static String getterName(String fieldName) {
        StringBuilder builder = new StringBuilder(GETTER_PREFIX);
        builder.append(Character.toUpperCase(fieldName.charAt(0)));
        builder.append(fieldName.substring(1));
        return builder.toString();
    }
    
	private static <T> Stream<Method> getPublicGetters(Class<T> clazz) {
		return Stream
				.of(clazz.getDeclaredMethods())
				.filter(method -> StringUtils.startsWith(method.getName(), GETTER_PREFIX))
				.filter(method -> method.getParameters().length == 0)
				.filter(method -> Modifier.isPublic(method.getModifiers()));
	}
    
	private static final String GETTER_PREFIX = "get";	

}
