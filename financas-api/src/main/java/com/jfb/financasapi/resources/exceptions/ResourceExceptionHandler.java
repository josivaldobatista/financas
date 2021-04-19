package com.jfb.financasapi.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.jfb.financasapi.services.exceptions.ResourceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
    StandardError err = new StandardError();
    HttpStatus status = HttpStatus.NOT_FOUND;
      err.setTimestamp(Instant.now());
      err.setStatus(status.value());
      err.setError("Recurso não encontrado");
      err.setMessage(e.getMessage());
      err.setPath(request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }
  
  @ExceptionHandler(UnrecognizedPropertyException.class)
  public ResponseEntity<StandardError> entityNotFound(UnrecognizedPropertyException e, HttpServletRequest request) {
    StandardError err = new StandardError();
    HttpStatus status = HttpStatus.BAD_REQUEST;
      err.setTimestamp(Instant.now());
      err.setStatus(status.value());
      err.setError("Campo não reconhecido na inserção");
      err.setMessage(e.getMessage());
      err.setPath(request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }

}
