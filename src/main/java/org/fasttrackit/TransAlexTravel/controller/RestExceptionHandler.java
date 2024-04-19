package org.fasttrackit.TransAlexTravel.controller;

import lombok.Builder;
import org.fasttrackit.TransAlexTravel.exceptions.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    @ResponseStatus(BAD_REQUEST)

    public ErrorResponse handleResourceNotFoundException(ResourceNotFound exception){
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
    }
    @Builder
    record ErrorResponse(String message){

    }
}
