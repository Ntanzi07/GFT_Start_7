package br.com.dio.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(final String message){
        super(message);
    }
}
