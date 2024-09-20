package com.springhayth.mediatech.Exceptions;

public class EntityAlreadyExistsException extends RuntimeException{
    public EntityAlreadyExistsException() {
    }

    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
