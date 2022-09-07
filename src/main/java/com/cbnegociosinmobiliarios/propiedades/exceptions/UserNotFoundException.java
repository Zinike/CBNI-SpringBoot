package com.cbnegociosinmobiliarios.propiedades.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
      }
}
