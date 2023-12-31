package com.bootcamp.clientescielo.web.validation;

import com.bootcamp.clientescielo.exception.CustomValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.groups.Default;

import java.util.Set;

public class ValidatorUtil {

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    public static <T> void validate(T object, Class<?> group) {
        Set<ConstraintViolation<T>> violations = validator.validate(object, group, Default.class);

        if (!violations.isEmpty()) {
            throw new CustomValidationException(violations);
        }
    }
}
