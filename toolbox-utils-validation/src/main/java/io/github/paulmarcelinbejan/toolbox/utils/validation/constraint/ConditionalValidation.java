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
 *
 * <p>Example usage:</p>
 * <pre>
 * @ConditionalValidation(
 *     conditionalProperty = "type", conditionalValues = {"A", "B"},
 *     propertyToValidate = "value", required = true,
 *     message = "When type is A or B, value is REQUIRED"
 * )
 * public class MyClass {
 *     private String type;
 *     private String value;
 * }
 * </pre>
 */
@Repeatable(ConditionalValidations.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ConditionalValidationValidator.class)
@Documented
public @interface ConditionalValidation {

	String message() default "Validation failed for ConditionalValidation";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
     * Name of the property whose value is checked for applying the validation.
     */
	String conditionalProperty();

	/**
     * Possible values of the conditional property for which the validation should be applied.
     */
	String[] conditionalValues();

	/**
     * Name of the property to be validated.
     */
	String propertyToValidate();

	/**
     * Indicates whether the property to validate is required or not.
     * If true, the property to validate must not be null; if false, the property
     * to validate must be null for the validation to pass.
     */
	boolean required();

}
