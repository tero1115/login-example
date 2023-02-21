package com.example.loginexample.handler.ex;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CustomApiException extends RuntimeException {

    private HttpStatus status;

    public CustomApiException(String msg, HttpStatus status) {
        super(msg);
        this.status = status;
    }

    public CustomApiException(String msg) {
        // super(msg);
        // this.status = HttpStatus.BAD_REQUEST;
        this(msg, HttpStatus.BAD_REQUEST);
    }
}
