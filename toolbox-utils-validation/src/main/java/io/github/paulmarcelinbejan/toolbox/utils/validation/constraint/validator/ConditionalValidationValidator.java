package io.github.paulmarcelinbejan.toolbox.utils.validation.constraint.validator;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import io.github.paulmarcelinbejan.toolbox.utils.validation.constraint.ConditionalValidation;

public class ConditionalValidationValidator implements ConstraintValidator<ConditionalValidation, Object> {

	private String conditionalProperty;
    private String[] conditionalValues;
    private String propertyToValidate;
	private boolean required;

    @Override
    public void initialize(ConditionalValidation constraintAnnotation) {
        conditionalProperty = constraintAnnotation.conditionalProperty();
        conditionalValues = constraintAnnotation.conditionalValues();
        propertyToValidate = constraintAnnotation.propertyToValidate();
		required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        if (object == null) {
			return true; // null object should be validated by another constraint!
        }

        try {
            Object conditionalPropertyValue = BeanUtils.getProperty(object, conditionalProperty);
            if (isConditionalPropertyInConditionalValues(conditionalPropertyValue)) {
                return executeConditionalValidation(object);
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
            return false;
        }

        return true;
    }
    
    private boolean isConditionalPropertyInConditionalValues(Object conditionalPropertyValue) {
        return Arrays.asList(conditionalValues).contains(conditionalPropertyValue);
    }
    
    private boolean executeConditionalValidation(Object object) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		boolean isValid = true;

        Object propertyToValidateValue = BeanUtils.getProperty(object, propertyToValidate);

		if (required) {
			isValid = propertyToValidateValue != null;
		} else {
			isValid = propertyToValidateValue == null;
        }
		
		return isValid;
    }
    
}
