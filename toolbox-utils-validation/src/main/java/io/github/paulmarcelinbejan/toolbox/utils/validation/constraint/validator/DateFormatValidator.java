package io.github.paulmarcelinbejan.toolbox.utils.validation.constraint.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import io.github.paulmarcelinbejan.toolbox.utils.validation.constraint.DateFormat;

public class DateFormatValidator implements ConstraintValidator<DateFormat, String> {

	private String pattern;

	@Override
	public void initialize(DateFormat annotation) {
		pattern = annotation.pattern();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StringUtils.isBlank(value)) {
			return true; // @NotBlank handle blank values
		}
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
			LocalDate.parse(value, formatter);
			return true;
		} catch (@SuppressWarnings("unused") Exception e) {
			return false;
		}
	}

}
