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

/**
 * Annotation used to specify conditional validation constraints for a target element.
 * This annotation can be applied to a class to specify conditional validation rules
 * based on the value of a conditional property.
 *
 * <p>The {@link #conditionalProperty()} attribute specifies the name of the property whose value is checked
 * to determine if the validation should be applied.</p>
 *
 * <p>The {@link #conditionalValues()} attribute specifies the possible values of the conditional property
 * for which the validation should be applied.</p>
 *
 * <p>The {@link #propertyToValidate()} attribute specifies the name of the property to be validated.</p>
 *
 * <p>The {@link #required()} attribute indicates whether the property to validate is required or not.
 * If {@code true}, the property to validate must not be {@code null}; if {@code false}, the property
 * to validate must be {@code null} for the validation to pass.</p>
 *
 * <p>This annotation can be repeated using the {@link ConditionalValidations} annotation
 * for specifying multiple conditional validation rules.</p>
 */
@Repeatable(ConditionalValidations.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ConditionalValidationValidator.class)
@Documented
public @interface ConditionalValidation {

	/**
     * Defines a custom error message for validation failures.
     * If not specified, the default message "Validation failed for ConditionalValidation" is used.
     *
     * @return the custom error message for validation failures
     */
    String message() default "Validation failed for ConditionalValidation";

    /**
     * Specifies the validation groups targeted for this constraint.
     * By default, no groups are targeted.
     *
     * @return the validation groups targeted for this constraint
     */
	Class<?>[] groups() default {};

	/**
     * Defines custom payloads that can be attached to a constraint.
     * This can be used to carry metadata or information about the error.
     * By default, no payloads are defined.
     *
     * @return custom payloads that can be attached to a constraint
     */
	Class<? extends Payload>[] payload() default {};

	/**
     * Specifies the name of the property whose value is checked for applying the validation.
     *
     * @return the name of the property whose value is checked for applying the validation
     */
	String conditionalProperty();

	/**
     * Specifies the possible values of the conditional property for which the validation should be applied.
     *
     * @return the possible values of the conditional property for which the validation should be applied
     */
	String[] conditionalValues();

	/**
     * Specifies the name of the property to be validated.
     *
     * @return the name of the property to be validated
     */
	String propertyToValidate();

	/**
     * Indicates whether the property to validate is required or not.
     * If {@code true}, the property to validate must not be {@code null};
     * if {@code false}, the property to validate must be {@code null} for the validation to pass.
     *
     * @return {@code true} if the property to validate is required, {@code false} otherwise
     */
	boolean required();

}
