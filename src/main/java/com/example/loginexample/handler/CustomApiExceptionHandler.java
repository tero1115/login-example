package com.example.loginexample.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.loginexample.dto.ResponseDto;
import com.example.loginexample.handler.ex.CustomApiException;

@RestControllerAdvice
public class CustomApiExceptionHandler {

    // NullPointException <- RuntimeException
    @ExceptionHandler(CustomApiException.class)
    public ResponseEntity<?> customApiException(CustomApiException e) {
        return new ResponseEntity<>(new ResponseDto<>(-1, e.getMessage(), null), e.getStatus());
    }
}