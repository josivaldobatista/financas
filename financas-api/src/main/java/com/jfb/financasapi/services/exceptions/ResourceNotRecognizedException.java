package com.jfb.financasapi.services.exceptions;

public class ResourceNotRecognizedException extends RuntimeException {

  public ResourceNotRecognizedException(String msg) {
    super(msg);
  }
}
