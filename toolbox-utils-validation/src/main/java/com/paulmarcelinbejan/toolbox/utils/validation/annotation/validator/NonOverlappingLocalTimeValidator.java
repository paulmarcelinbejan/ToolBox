package com.paulmarcelinbejan.toolbox.utils.validation.annotation.validator;

import com.paulmarcelinbejan.toolbox.utils.time.TimeUtils;
import com.paulmarcelinbejan.toolbox.utils.time.aware.HistoricalLocalTimeAware;
import com.paulmarcelinbejan.toolbox.utils.validation.annotation.NonOverlappingLocalTime;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NonOverlappingLocalTimeValidator implements ConstraintValidator<NonOverlappingLocalTime, HistoricalLocalTimeAware> {

    /**
     * Checks if is valid.
     */
    @Override
    public boolean isValid(HistoricalLocalTimeAware historicalLocalTimeAware, ConstraintValidatorContext constraintValidatorContext) {
    	return TimeUtils.isBefore(historicalLocalTimeAware.startLocalTime(), historicalLocalTimeAware.endLocalTime());
    }

}
