package com.test.besttrip.service.exception;

public class ExistingLoginException extends RuntimeException {

    public ExistingLoginException(String message){
        super(message);
    }

}
