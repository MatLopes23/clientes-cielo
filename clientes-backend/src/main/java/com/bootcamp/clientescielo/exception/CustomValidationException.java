package com.bootcamp.clientescielo.exception;

import jakarta.validation.ConstraintViolation;

import java.util.Set;

public class CustomValidationException extends RuntimeException {

    private final Set<? extends ConstraintViolation<?>> constraintViolations;

    public CustomValidationException(Set<? extends ConstraintViolation<?>> constraintViolations) {
        this.constraintViolations = constraintViolations;
    }

    public Set<? extends ConstraintViolation<?>> getConstraintViolations() {
        return constraintViolations;
    }
}
