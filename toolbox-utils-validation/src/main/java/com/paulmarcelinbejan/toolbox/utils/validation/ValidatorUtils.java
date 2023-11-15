package com.paulmarcelinbejan.toolbox.utils.validation;

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
	
	public static <TO_VALIDATE> void validate(TO_VALIDATE toValidate) {
		Set<ConstraintViolation<TO_VALIDATE>> violations = VALIDATOR.validate(toValidate);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(violations);
		}
	}

	/**
	 * Throws ConstraintViolationException with the first violation encountered as soon as one of the element to be validated is not valid.
	 */
	public static <TO_VALIDATE> void validate(Collection<TO_VALIDATE> collectionToValidate) {
		for (TO_VALIDATE toValidate : collectionToValidate) {
			Set<ConstraintViolation<TO_VALIDATE>> violations = VALIDATOR.validate(toValidate);
			if (!violations.isEmpty()) {
				throw new ConstraintViolationException(violations);
			}
		}
	}
	
	/**
	 * Validate all the elements of the collection, then if at least one was not valid, a ConstraintViolationException is thrown with all the violations encountered.
	 */
	public static <TO_VALIDATE> void validateAll(Collection<TO_VALIDATE> collectionToValidate) {
		Set<ConstraintViolation<TO_VALIDATE>> allViolations = new HashSet<>();
		for (TO_VALIDATE toValidate : collectionToValidate) {
			Set<ConstraintViolation<TO_VALIDATE>> violations = VALIDATOR.validate(toValidate);
			allViolations.addAll(violations);
		}
		if (!allViolations.isEmpty()) {
			throw new ConstraintViolationException(allViolations);
		}
	}

	public static <TO_VALIDATE> void validateByGroups(TO_VALIDATE toValidate, Class<?>... groups) {
		Set<ConstraintViolation<TO_VALIDATE>> violations = VALIDATOR.validate(toValidate, groups);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(violations);
		}
	}

	/**
	 * Throws ConstraintViolationException with the first violation encountered as soon as one of the element to be validated is not valid.
	 */
	public static <TO_VALIDATE> void validateByGroups(Collection<TO_VALIDATE> collectionToValidate, Class<?>... groups) {
		for (TO_VALIDATE toValidate : collectionToValidate) {
			Set<ConstraintViolation<TO_VALIDATE>> violations = VALIDATOR.validate(toValidate, groups);
			if (!violations.isEmpty()) {
				throw new ConstraintViolationException(violations);
			}
		}
	}
	
	/**
	 * Validate all the elements of the collection, then if at least one was not valid, a ConstraintViolationException is thrown with all the violations encountered.
	 */
	public static <TO_VALIDATE> void validateAllByGroups(Collection<TO_VALIDATE> collectionToValidate, Class<?>... groups) {
		Set<ConstraintViolation<TO_VALIDATE>> allViolations = new HashSet<>();
		for (TO_VALIDATE toValidate : collectionToValidate) {
			Set<ConstraintViolation<TO_VALIDATE>> violations =  VALIDATOR.validate(toValidate, groups);
			allViolations.addAll(violations);
		}
		if (!allViolations.isEmpty()) {
			throw new ConstraintViolationException(allViolations);
		}
	}

}
