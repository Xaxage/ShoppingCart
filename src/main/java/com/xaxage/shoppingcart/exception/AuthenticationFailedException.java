package com.xaxage.shoppingcart.exception;

public class AuthenticationFailedException extends IllegalArgumentException{
    public AuthenticationFailedException(String msg){
        super(msg);
    }
}
