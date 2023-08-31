package com.testing.quizApp.service;

public class CartItemNotExistException extends RuntimeException{
     /**
     *
     */ private String message;

    public CartItemNotExistException() {}

    public CartItemNotExistException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}