package com.propremote.exception;

//FIXME: this class should be a checked exception
public class NoSuchPropertyException extends RuntimeException {

    public NoSuchPropertyException(String message) {
        super(message);
    }
}
