package net.company.ms.petstoreservice.codeimpl.api.exception;

public class GenericServiceException extends RuntimeException {
  private static final long serialVersionUID = -1;

  public GenericServiceException(Exception e) {
    super(e);
  }

}
