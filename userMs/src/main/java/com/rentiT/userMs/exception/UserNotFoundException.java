package com.rentiT.userMs.exception;

public class UserNotFoundException extends RuntimeException{
    String exceptionMessage;
    public UserNotFoundException(String exceptionMessage)  {
        super(exceptionMessage);
    }
}
