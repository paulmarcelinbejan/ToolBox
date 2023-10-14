package com.paulmarcelinbejan.toolbox.utils.validation.annotation.temporal.validator;

import static java.time.ZoneOffset.UTC;

import com.paulmarcelinbejan.toolbox.utils.time.ZonedDateTimeUtils;
import com.paulmarcelinbejan.toolbox.utils.time.aware.HistoricalInstantAware;
import com.paulmarcelinbejan.toolbox.utils.validation.annotation.temporal.NonOverlappingInstant;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NonOverlappingInstantValidator implements ConstraintValidator<NonOverlappingInstant, HistoricalInstantAware> {

    /**
     * Checks if is valid.
     */
    @Override
    public boolean isValid(HistoricalInstantAware historicalInstantAware, ConstraintValidatorContext constraintValidatorContext) {
    	return ZonedDateTimeUtils.isBefore(historicalInstantAware.startInstant().atZone(UTC), historicalInstantAware.endInstant().atZone(UTC));
    }

}
