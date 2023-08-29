package com.paulmarcelinbejan.toolbox.utils.validation.annotation.temporal.validator;

import com.paulmarcelinbejan.toolbox.utils.time.DateUtils;
import com.paulmarcelinbejan.toolbox.utils.time.aware.HistoricalLocalDateAware;
import com.paulmarcelinbejan.toolbox.utils.validation.annotation.temporal.NonOverlappingLocalDate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NonOverlappingLocalDateValidator implements ConstraintValidator<NonOverlappingLocalDate, HistoricalLocalDateAware> {

    /**
     * Checks if is valid.
     */
    @Override
    public boolean isValid(HistoricalLocalDateAware historicalLocalDateAware, ConstraintValidatorContext constraintValidatorContext) {
    	return DateUtils.isBefore(historicalLocalDateAware.startLocalDate(), historicalLocalDateAware.endLocalDate());
    }
    
}
