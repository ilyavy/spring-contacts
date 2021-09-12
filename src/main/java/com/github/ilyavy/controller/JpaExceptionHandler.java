package com.github.ilyavy.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.Instant;

import com.github.ilyavy.dto.ErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class JpaExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    protected ResponseEntity<Object> handleConflict(RuntimeException exception, WebRequest request) {
        ErrorDto errorDto = new ErrorDto()
                .setTimestamp(Instant.now())
                .setStatus(HttpStatus.CONFLICT.value())
                .setError("SQLIntegrityConstraintViolationException")
                .setMessage("Cannot execute request due to the conflict")
                .setPath(((ServletWebRequest) request).getRequest().getRequestURI());

        return handleExceptionInternal(exception, errorDto, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
