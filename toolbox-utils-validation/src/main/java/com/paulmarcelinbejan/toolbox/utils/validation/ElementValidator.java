//package com.paulmarcelinbejan.toolbox.utils.validation;
//
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//
//public class ElementValidator implements ConstraintValidator<Validate, Object> {
//
//	private Class<?>[] groups;
//
//	@Override
//	public void initialize(Validate validate) {
//		groups = validate.groups();
//	}
//
//	@Override
//	public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
//		ValidationUtils.validateGroups(object, groups);
//		return true;
//	}
//
//}
