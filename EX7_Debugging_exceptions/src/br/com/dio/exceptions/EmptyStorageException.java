package br.com.dio.exceptions;

public class EmptyStorageException extends RuntimeException{
    public EmptyStorageException(final String message){
        super(message);
    }
}
