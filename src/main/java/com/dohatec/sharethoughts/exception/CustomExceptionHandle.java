package com.dohatec.sharethoughts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandle extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleExceptions(UserNotFoundException exception, WebRequest webRequest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setDateTime(LocalDateTime.now());
        exceptionResponse.setMessage("User is not found with the provided user Id");
        ResponseEntity<Object> entity = new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
        return entity;
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<Object> handleExceptions(PostNotFoundException exception, WebRequest webRequest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setDateTime(LocalDateTime.now());
        exceptionResponse.setMessage("Post is not found with the provided Post Id");
        ResponseEntity<Object> entity = new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
        return entity;
    }
}