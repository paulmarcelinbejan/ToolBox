package com.paulmarcelinbejan.toolbox.utils.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;

import com.paulmarcelinbejan.toolbox.utils.reflection.exception.ReflectionException;
import com.paulmarcelinbejan.toolbox.utils.text.TextUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReflectionUtils {

	private static final String GETTER_PREFIX = "get";

	@SuppressWarnings("unchecked")
	public static <T> Constructor<T> getNoArgsConstructor(Class<T> clazz) throws ReflectionException {
		return (Constructor<T>) Arrays
				.asList(clazz.getDeclaredConstructors())
				.stream()
				.filter(constructor -> constructor.getParameterCount() == 0)
				.findAny()
				.orElseThrow(() -> new ReflectionException(
						"Class " + clazz.getCanonicalName() + " doesn't have a no args contructor."));
	}

	public static <T> T getNewInstanceViaNoArgsConstructor(Class<T> clazz) throws ReflectionException {
		try {
			return getNoArgsConstructor(clazz).newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ReflectionException e) {
			throw new ReflectionException("Error handling " + clazz.getCanonicalName() + " with reflection.", e);
		}
	}

	public static <T, A> Field getFieldByName(Class<T> clazz, String fieldName)
			throws ReflectionException {
		return Stream
				// STREAM DECLARED FIELDS
				.of(clazz.getDeclaredFields())
				// FILTER TO FIND FIELD BY NAME
				.filter(field -> TextUtils.areEquals(field.getName(), fieldName))
				.findFirst()
				.orElseThrow(() -> new ReflectionException(
						"Class " + clazz.getCanonicalName() + " doesn't have a field with name " + fieldName));
	}

	public static <T, A> Field getFirstFieldAnnotatedWith(Class<T> clazz, Class<A> annotationClass)
			throws ReflectionException {
		return Stream
				// STREAM DECLARED FIELDS
				.of(clazz.getDeclaredFields())
				// FILTER TO FIND FIELDS ANNOTATED WITH PROVIDED ANNOTATION
				.filter(field -> Stream
						.of(field.getDeclaredAnnotations())
						.anyMatch(annotation -> annotationClass.equals(annotation.getClass())))
				.findFirst()
				.orElseThrow(() -> new ReflectionException(
						"Class " + clazz.getCanonicalName()
								+ " doesn't have a field annotated with " + annotationClass.getCanonicalName()));
	}

	public static <T> Method getPublicGetterOfField(Class<T> clazz, Field field) throws ReflectionException {
		String fieldName = field.getName();
		String getterNameOfField = GETTER_PREFIX + WordUtils.capitalize(fieldName);
		return getPublicGetters(clazz)
				.filter(getter -> getter.getName().contentEquals(getterNameOfField))
				.findFirst()
				.orElseThrow(() -> new ReflectionException(
						"Class " + clazz.getCanonicalName() + " doesn't have a getter method named " + getterNameOfField
								+ " for field " + fieldName));
	}

	public static Object invokeMethod(Object objectOnWhichToInvokeTheMethod, Method method) throws ReflectionException {
		try {
			return method.invoke(objectOnWhichToInvokeTheMethod);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new ReflectionException(
					"Error invoking method " + method.getName() + " of "
							+ objectOnWhichToInvokeTheMethod.getClass().getCanonicalName());
		}
	}

	public static Object invokeMethod(Object objectOnWhichToInvokeTheMethod, Method method, Object... paramsOfMethod)
			throws ReflectionException {
		try {
			return method.invoke(objectOnWhichToInvokeTheMethod, paramsOfMethod);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new ReflectionException(
					"Error invoking method " + method.getName() + " of "
							+ objectOnWhichToInvokeTheMethod.getClass().getCanonicalName());
		}
	}

	private static <T> Stream<Method> getPublicGetters(Class<T> clazz) {
		return Stream
				.of(clazz.getDeclaredMethods())
				.filter(method -> StringUtils.startsWith(method.getName(), GETTER_PREFIX))
				.filter(method -> method.getParameters().length == 0)
				.filter(method -> Modifier.isPublic(method.getModifiers()));
	}

}
