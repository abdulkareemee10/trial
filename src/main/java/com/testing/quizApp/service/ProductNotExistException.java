package com.testing.quizApp.service;

import org.springframework.stereotype.Service;

@Service

public class ProductNotExistException extends RuntimeException{
    /**
     *
     */ private String message;

    public ProductNotExistException() {}

    public ProductNotExistException(String msg)
    {
        super(msg);
        this.message = msg;
    }

}
