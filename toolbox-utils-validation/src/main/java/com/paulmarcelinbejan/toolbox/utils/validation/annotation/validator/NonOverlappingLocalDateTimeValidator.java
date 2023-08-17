package com.paulmarcelinbejan.toolbox.utils.validation.annotation.validator;

import com.paulmarcelinbejan.toolbox.utils.time.DateTimeUtils;
import com.paulmarcelinbejan.toolbox.utils.time.aware.HistoricalLocalDateTimeAware;
import com.paulmarcelinbejan.toolbox.utils.validation.annotation.NonOverlappingLocalDateTime;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NonOverlappingLocalDateTimeValidator implements ConstraintValidator<NonOverlappingLocalDateTime, HistoricalLocalDateTimeAware> {

    /**
     * Checks if is valid.
     */
    @Override
    public boolean isValid(HistoricalLocalDateTimeAware historicalLocalDateTimeAware, ConstraintValidatorContext constraintValidatorContext) {
    	return DateTimeUtils.isBefore(historicalLocalDateTimeAware.startLocalDateTime(), historicalLocalDateTimeAware.endLocalDateTime());
    }

}
