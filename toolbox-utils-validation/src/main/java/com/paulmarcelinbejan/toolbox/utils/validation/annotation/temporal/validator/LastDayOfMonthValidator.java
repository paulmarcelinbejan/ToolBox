package com.paulmarcelinbejan.toolbox.utils.validation.annotation.temporal.validator;

import java.time.LocalDate;

import com.paulmarcelinbejan.toolbox.utils.time.DateUtils;
import com.paulmarcelinbejan.toolbox.utils.validation.annotation.temporal.FirstDayOfMonth;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LastDayOfMonthValidator implements ConstraintValidator<FirstDayOfMonth, LocalDate> {

    /**
     * Checks if is valid.
     */
    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
    	return DateUtils.isLastDayOfMonth(localDate);
    }

}
