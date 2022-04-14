package com.store.book.utils.exceptions;

import org.springframework.validation.BindingResult;

public class ValidationException extends ApplicationException {

    public ValidationException(BindingResult result) {
        super(result.toString());
    }
}