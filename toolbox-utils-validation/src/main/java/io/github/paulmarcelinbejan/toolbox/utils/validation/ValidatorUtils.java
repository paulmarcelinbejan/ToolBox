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

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidatorUtils {

	private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();
	
	public static <T> void validate(T toValidate) {
		Set<ConstraintViolation<T>> violations = VALIDATOR.validate(toValidate);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(violations);
		}
	}

	/**
	 * Throws ConstraintViolationException with the first violation encountered as soon as one of the element to be validated is not valid.
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
	 * Validate all the elements of the collection, then if at least one was not valid, a ConstraintViolationException is thrown with all the violations encountered.
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

	public static <T> void validateByGroups(T toValidate, Class<?>... groups) {
		Set<ConstraintViolation<T>> violations = VALIDATOR.validate(toValidate, groups);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(violations);
		}
	}

	/**
	 * Throws ConstraintViolationException with the first violation encountered as soon as one of the element to be validated is not valid.
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
	 * Validate all the elements of the collection, then if at least one was not valid, a ConstraintViolationException is thrown with all the violations encountered.
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
