package com.davcode.minhasfinancas.exception;

public class AuthenticationError extends RuntimeException {
    public AuthenticationError(String message){
        super(message);
    }
}
