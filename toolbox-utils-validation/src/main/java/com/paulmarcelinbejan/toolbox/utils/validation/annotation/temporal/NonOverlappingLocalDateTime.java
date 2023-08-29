package com.paulmarcelinbejan.toolbox.utils.validation.annotation.temporal;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.paulmarcelinbejan.toolbox.utils.validation.annotation.temporal.validator.NonOverlappingLocalDateTimeValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { NonOverlappingLocalDateTimeValidator.class })
public @interface NonOverlappingLocalDateTime {

	/**
	 * Message to return if not valid
	 */
    String message() default "Overlapping_of_LocalDateTime";

    /**
     * Validation Groups
     */
    Class<?>[] groups() default {};

    /**
     * Payload
     */
    Class<? extends Payload>[] payload() default {};
	
}
