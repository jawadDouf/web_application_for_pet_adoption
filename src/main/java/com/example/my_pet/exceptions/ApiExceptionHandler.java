package com.example.my_pet.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ApiException> handleApiRequestException(NotFoundException e){
        // Customise the exception body
        ApiException apiException = new ApiException(e.getMessage(),HttpStatus.NOT_FOUND);
        // Return the exception response
        return new ResponseEntity<>(apiException,apiException.getHttpStatus());
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<ApiException> handleBadRequestException(BadRequestException e){
        // Customise the exception body
        ApiException apiException = new ApiException(e.getMessage(),HttpStatus.BAD_REQUEST);
        // Return the exception response
        return new ResponseEntity<>(apiException,apiException.getHttpStatus());
    }
}
