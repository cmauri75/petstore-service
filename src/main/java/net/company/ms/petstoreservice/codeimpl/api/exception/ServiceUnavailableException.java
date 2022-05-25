package net.company.ms.petstoreservice.codeimpl.api.exception;

public class ServiceUnavailableException extends RuntimeException {
  private static final long serialVersionUID = -1;

  public ServiceUnavailableException(Exception e) {
    super(e);
  }

  public ServiceUnavailableException(String message) {
    super(message);
  }
}
