package com.paulmarcelinbejan.toolbox.utils.validation.annotation.temporal.validator;

import com.paulmarcelinbejan.toolbox.utils.time.LocalTimeUtils;
import com.paulmarcelinbejan.toolbox.utils.time.aware.HistoricalLocalTimeAware;
import com.paulmarcelinbejan.toolbox.utils.validation.annotation.temporal.NonOverlappingLocalTime;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NonOverlappingLocalTimeValidator implements ConstraintValidator<NonOverlappingLocalTime, HistoricalLocalTimeAware> {

    /**
     * Checks if is valid.
     */
    @Override
    public boolean isValid(HistoricalLocalTimeAware historicalLocalTimeAware, ConstraintValidatorContext constraintValidatorContext) {
    	return LocalTimeUtils.isBefore(historicalLocalTimeAware.startLocalTime(), historicalLocalTimeAware.endLocalTime());
    }

}
