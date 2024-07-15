package com.example.__spring_security.exception;


public class ResourceNotFoundException extends RuntimeException {
    //Object of this class can now pass a message since parameterised constructor
    public ResourceNotFoundException(String message) {
        super(message);//Calls RuntimeException with the error message
    }


}
