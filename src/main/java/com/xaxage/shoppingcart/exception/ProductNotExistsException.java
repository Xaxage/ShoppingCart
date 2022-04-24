package com.xaxage.shoppingcart.exception;

public class ProductNotExistsException extends IllegalArgumentException{
    public ProductNotExistsException(String message){
        super(message);
    }
}
