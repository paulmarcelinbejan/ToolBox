package io.github.paulmarcelinbejan.toolbox.utils.validation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Utility class for validating objects using Bean Validation API.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidatorUtils {

	private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();
	
	/**
     * Validates the given object.
     *
     * @param toValidate the object to validate
     * @param <T>        the type of the object
     * @throws ConstraintViolationException if the object is not valid
     */
	public static <T> void validate(T toValidate) {
		Set<ConstraintViolation<T>> violations = VALIDATOR.validate(toValidate);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(violations);
		}
	}

	/**
     * Validates each object in the given collection.
     *
     * @param collectionToValidate the collection of objects to validate
     * @param <T>                  the type of objects in the collection
     * @throws ConstraintViolationException if any object in the collection is not valid
     */
	public static <T> void validate(Collection<T> collectionToValidate) {
		for (T toValidate : collectionToValidate) {
			Set<ConstraintViolation<T>> violations = VALIDATOR.validate(toValidate);
			if (!violations.isEmpty()) {
				throw new ConstraintViolationException(violations);
			}
		}
	}
	
	/**
     * Validates all objects in the given collection, throwing an exception with all violations encountered.
     *
     * @param collectionToValidate the collection of objects to validate
     * @param <T>                  the type of objects in the collection
     * @throws ConstraintViolationException if any object in the collection is not valid
     */
	public static <T> void validateAll(Collection<T> collectionToValidate) {
		Set<ConstraintViolation<T>> allViolations = new HashSet<>();
		for (T toValidate : collectionToValidate) {
			Set<ConstraintViolation<T>> violations = VALIDATOR.validate(toValidate);
			allViolations.addAll(violations);
		}
		if (!allViolations.isEmpty()) {
			throw new ConstraintViolationException(allViolations);
		}
	}

	/**
     * Validates the given object using the specified validation groups.
     *
     * @param toValidate the object to validate
     * @param groups     the validation groups
     * @param <T>        the type of the object
     * @throws ConstraintViolationException if the object is not valid
     */
	public static <T> void validateByGroups(T toValidate, Class<?>... groups) {
		Set<ConstraintViolation<T>> violations = VALIDATOR.validate(toValidate, groups);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(violations);
		}
	}

	/**
     * Validates each object in the given collection using the specified validation groups.
     *
     * @param collectionToValidate the collection of objects to validate
     * @param groups               the validation groups
     * @param <T>                  the type of objects in the collection
     * @throws ConstraintViolationException if any object in the collection is not valid
     */
	public static <T> void validateByGroups(Collection<T> collectionToValidate, Class<?>... groups) {
		for (T toValidate : collectionToValidate) {
			Set<ConstraintViolation<T>> violations = VALIDATOR.validate(toValidate, groups);
			if (!violations.isEmpty()) {
				throw new ConstraintViolationException(violations);
			}
		}
	}
	
	/**
     * Validates all objects in the given collection using the specified validation groups,
     * throwing an exception with all violations encountered.
     *
     * @param collectionToValidate the collection of objects to validate
     * @param groups               the validation groups
     * @param <T>                  the type of objects in the collection
     * @throws ConstraintViolationException if any object in the collection is not valid
     */
	public static <T> void validateAllByGroups(Collection<T> collectionToValidate, Class<?>... groups) {
		Set<ConstraintViolation<T>> allViolations = new HashSet<>();
		for (T toValidate : collectionToValidate) {
			Set<ConstraintViolation<T>> violations =  VALIDATOR.validate(toValidate, groups);
			allViolations.addAll(violations);
		}
		if (!allViolations.isEmpty()) {
			throw new ConstraintViolationException(allViolations);
		}
	}

}
