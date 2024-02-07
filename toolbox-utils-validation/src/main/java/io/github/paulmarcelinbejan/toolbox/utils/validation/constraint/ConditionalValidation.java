package io.github.paulmarcelinbejan.toolbox.utils.validation.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import io.github.paulmarcelinbejan.toolbox.utils.validation.constraint.validator.ConditionalValidationValidator;

@Repeatable(ConditionalValidations.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ConditionalValidationValidator.class)
@Documented
public @interface ConditionalValidation {

	String message() default "Validation failed for ConditionalValidation";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String conditionalProperty();

	String[] conditionalValues();

	String propertyToValidate();

	boolean required();

}
