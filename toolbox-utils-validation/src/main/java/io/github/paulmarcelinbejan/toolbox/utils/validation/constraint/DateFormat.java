package io.github.paulmarcelinbejan.toolbox.utils.validation.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import io.github.paulmarcelinbejan.toolbox.utils.validation.constraint.validator.DateFormatValidator;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateFormatValidator.class)
public @interface DateFormat {

	String pattern() default "yyyy-MM-dd";

	String message() default "Invalid date format";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
