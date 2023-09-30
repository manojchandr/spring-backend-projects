package com.synchrony.imgurapi.exception;

public class AuthenticationException extends IllegalArgumentException{
    public AuthenticationException(String msg) {
        super(msg);
    }
}
