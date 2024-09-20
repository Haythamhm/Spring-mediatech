package com.springhayth.mediatech.Exceptions;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException() {

    }
}
