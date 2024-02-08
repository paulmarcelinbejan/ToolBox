package io.github.paulmarcelinbejan.toolbox.utils.validation.stereotype;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

/**
 * Indicates that a class is a validator component. This annotation serves
 * as a specialization of the {@link Component @Component} annotation, allowing
 * for the autodetection of validator classes in the Spring context.
 *
 * <p>Validator classes annotated with {@code @Validator} are automatically
 * detected and registered as Spring beans in the application context.
 *
 * @see Component
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Validator {

	/**
	 * The value may indicate a suggestion for a logical component name,
	 * to be turned into a Spring bean in case of an autodetected component.
	 * @return the suggested component name, if any (or empty String otherwise)
	 */
	@AliasFor(annotation = Component.class)
	String value() default "";

}
