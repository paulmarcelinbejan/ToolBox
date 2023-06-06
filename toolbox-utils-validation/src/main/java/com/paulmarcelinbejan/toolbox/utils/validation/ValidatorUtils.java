package com.paulmarcelinbejan.toolbox.utils.validation;

import java.util.Collection;
import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidatorUtils {

	public static <TO_VALIDATE> void validate(TO_VALIDATE toValidate) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<TO_VALIDATE>> violations = validator.validate(toValidate);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(violations);
		}
	}

	public static <TO_VALIDATE> void validate(Collection<TO_VALIDATE> collectionToValidate) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		for (TO_VALIDATE toValidate : collectionToValidate) {
			Set<ConstraintViolation<TO_VALIDATE>> violations = validator.validate(toValidate);
			if (!violations.isEmpty()) {
				throw new ConstraintViolationException(violations);
			}
		}
	}

	public static <TO_VALIDATE> void validateGroups(TO_VALIDATE toValidate, Class<?>... groups) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<TO_VALIDATE>> violations = validator.validate(toValidate, groups);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(violations);
		}
	}

	public static <TO_VALIDATE> void validateGroups(Collection<TO_VALIDATE> collectionToValidate, Class<?>... groups) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		for (TO_VALIDATE toValidate : collectionToValidate) {
			Set<ConstraintViolation<TO_VALIDATE>> violations = validator.validate(toValidate, groups);
			if (!violations.isEmpty()) {
				throw new ConstraintViolationException(violations);
			}
		}
	}

}
