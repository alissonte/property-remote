package com.propremote.exception;

//FIXME: this class should be a checked exception
public class NoSuchGroupException extends RuntimeException {

    public NoSuchGroupException(String message) {
        super(message);
    }
}
