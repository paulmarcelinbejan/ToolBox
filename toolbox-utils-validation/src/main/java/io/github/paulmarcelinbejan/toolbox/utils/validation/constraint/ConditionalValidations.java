package io.github.paulmarcelinbejan.toolbox.utils.validation.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation used to group multiple {@link ConditionalValidation} annotations together.
 * This annotation allows the specification of conditional validations for a target type.
 * Conditional validations are applied based on certain conditions.
 *
 * @see ConditionalValidation
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@Documented
public @interface ConditionalValidations {

	/**
     * Specifies an array of {@link ConditionalValidation} annotations, each representing
     * a conditional validation rule.
     *
     * @return an array of ConditionalValidation annotations
     */
	ConditionalValidation[] value();

}
