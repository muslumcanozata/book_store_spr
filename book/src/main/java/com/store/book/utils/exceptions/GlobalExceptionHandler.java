package com.store.book.utils.exceptions;

import com.store.book.utils.results.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.bind.ValidationException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<ErrorResult> handleRuntimeException(Exception ex) {
        log.error("[RuntimeException].", ex);
        return ResponseEntity.status(500).body(new ErrorResult(ex.getMessage()));
    }

    @ExceptionHandler(ApplicationException.class)
    @ResponseBody
    public ResponseEntity<ErrorResult> handleApplicationException(Exception ex) {
        ApplicationException exception = (ApplicationException) ex;
        log.error("[ApplicationException]. Exception: {0}", exception);
        return ResponseEntity.status(500).body(new ErrorResult(exception.getMessage()));
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    public ResponseEntity<ErrorResult> handleValidationException(Exception ex) {
        ValidationException exception = (ValidationException) ex;
        log.error("[ValidationException]. Exception: {0}", exception);
        return ResponseEntity.status(400).body(new ErrorResult(exception.getMessage()));
    }
}