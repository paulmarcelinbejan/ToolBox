//package com.paulmarcelinbejan.toolbox.utils.validation;
//
//import java.lang.annotation.Documented;
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
//import jakarta.validation.Constraint;
//import jakarta.validation.Payload;
//
//@Target({ ElementType.TYPE_USE })
//@Retention(RetentionPolicy.RUNTIME)
//@Constraint(validatedBy = { ElementValidator.class })
//@Documented
//public @interface Validate {
//
//	/**
//	 * Message.
//	 *
//	 * @return the string
//	 */
//	String message() default "Element not valid.";
//
//	/**
//	 * Groups.
//	 *
//	 * @return the class[]
//	 */
//	Class<?>[] groups() default {};
//
//	/**
//	 * Payload.
//	 *
//	 * @return the class<? extends payload>[]
//	 */
//	Class<? extends Payload>[] payload() default {};
//
//}
