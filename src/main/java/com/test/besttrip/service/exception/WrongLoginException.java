package com.test.besttrip.service.exception;

public class WrongLoginException extends RuntimeException {

    public WrongLoginException (String message){
        super(message);
    }
}
