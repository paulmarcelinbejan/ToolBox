package io.github.paulmarcelinbejan.toolbox.utils.validation.constraint.validator;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import io.github.paulmarcelinbejan.toolbox.utils.validation.constraint.ConditionalValidation;

/**
 * Validator for the {@link ConditionalValidation} annotation.
 * This validator checks whether the validation for a specified property should be executed based on the value of a conditional property.
 *
 * <p>The conditional property value is checked against a set of conditional values.
 * If the conditional property value matches any of the conditional values, the validation for the property to be validated is executed.</p>
 *
 * <p>The {@link #initialize(ConditionalValidation)} method initializes the validator with the attributes of the {@link ConditionalValidation} annotation.</p>
 *
 * <p>The {@link #isValid(Object, ConstraintValidatorContext)} method performs the actual validation logic.
 * It checks if the object is not null, retrieves the value of the conditional property using reflection,
 * and then determines whether the conditional property value matches any of the conditional values.
 * If it matches, it executes the validation for the property to be validated based on the {@link #required} attribute.</p>
 */
public class ConditionalValidationValidator implements ConstraintValidator<ConditionalValidation, Object> {

	/**
	 * The name of the property used for conditional validation.
	 */
	private String conditionalProperty;

	/**
	 * The array of values that trigger the conditional validation.
	 */
	private String[] conditionalValues;

	/**
	 * The name of the property to validate conditionally.
	 */
	private String propertyToValidate;

	/**
	 * Flag indicating whether the property to validate is required when the condition is met.
	 */
	private boolean required;

	/**
     * Initializes the validator with the constraint annotation attributes.
     *
     * @param constraintAnnotation the {@link ConditionalValidation} annotation instance
     */
    @Override
    public void initialize(ConditionalValidation constraintAnnotation) {
        conditionalProperty = constraintAnnotation.conditionalProperty();
        conditionalValues = constraintAnnotation.conditionalValues();
        propertyToValidate = constraintAnnotation.propertyToValidate();
		required = constraintAnnotation.required();
    }

    /**
     * Validates the specified object.
     *
     * @param object  the object to validate
     * @param context the validation context
     * @return {@code true} if the object is valid according to the specified conditions, {@code false} otherwise
     */
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
    
    /**
     * Checks if the value of the conditional property is within the specified conditional values.
     *
     * @param conditionalPropertyValue the value of the conditional property
     * @return {@code true} if the value is within the conditional values, {@code false} otherwise
     */
    private boolean isConditionalPropertyInConditionalValues(Object conditionalPropertyValue) {
        return Arrays.asList(conditionalValues).contains(conditionalPropertyValue);
    }
    
    /**
     * Executes the conditional validation based on the specified conditions.
     *
     * @param object the object to validate
     * @return {@code true} if the property to validate meets the conditions, {@code false} otherwise
     * @throws IllegalAccessException    if access to the property is not allowed
     * @throws InvocationTargetException if the property accessor method throws an exception
     * @throws NoSuchMethodException     if the property accessor method is not found
     */
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
