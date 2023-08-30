package com.paulmarcelinbejan.toolbox.utils.validation.annotation.temporal;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.paulmarcelinbejan.toolbox.utils.validation.annotation.temporal.validator.LastDayOfMonthValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { LastDayOfMonthValidator.class })
public @interface LastDayOfMonth {

	/**
	 * Message to return if not valid
	 */
    String message() default "Last day of the month excpected.";

    /**
     * Validation Groups
     */
    Class<?>[] groups() default {};

    /**
     * Payload
     */
    Class<? extends Payload>[] payload() default {};
	
}
