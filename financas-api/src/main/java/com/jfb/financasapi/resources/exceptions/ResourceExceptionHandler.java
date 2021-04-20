package com.jfb.financasapi.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.jfb.financasapi.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

  @Autowired
  private MessageSource messageSource;

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
    StandardError err = new StandardError();
    HttpStatus status = HttpStatus.NOT_FOUND;
    err.setTimestamp(Instant.now());
    err.setStatus(status.value());
    err.setError(messageSource.getMessage("recurso.nao.encontrado", null, LocaleContextHolder.getLocale()));
    err.setMessage(e.getMessage());
    err.setPath(request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(UnrecognizedPropertyException.class)
  public ResponseEntity<StandardError> entityNotFound(UnrecognizedPropertyException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    StandardError err = new StandardError();
    err.setTimestamp(Instant.now());
    err.setStatus(status.value());
    err.setError(messageSource.getMessage("campo.nao.reconhecido", null, LocaleContextHolder.getLocale()));
    err.setMessage(e.getMessage());
    err.setPath(request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
    ValidationError err = new ValidationError();
    err.setTimestamp(Instant.now());
    err.setStatus(status.value());
    err.setError(messageSource.getMessage("erro.validacao", null, LocaleContextHolder.getLocale()));
    err.setMessage(e.getMessage());
    err.setPath(request.getRequestURI());

    for (FieldError f : e.getBindingResult().getFieldErrors()) {
      err.addError(f.getField(), f.getDefaultMessage());
    }

    return ResponseEntity.status(status).body(err);
  }

}
