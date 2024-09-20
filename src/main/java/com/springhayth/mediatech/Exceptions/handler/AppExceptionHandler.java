package com.springhayth.mediatech.Exceptions.handler;

import com.springhayth.mediatech.Exceptions.EntityAlreadyExistsException;
import com.springhayth.mediatech.Exceptions.EntityNotFoundException;
import com.springhayth.mediatech.shared.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Object> entityNotFoundException(EntityNotFoundException e) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(e.getMessage())
                .timestamp(new Date())
                .errorCode(404)
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> HandleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        Map<String,String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(errors, HttpStatus.UNPROCESSABLE_ENTITY);

    }


    @ExceptionHandler(value = {EntityAlreadyExistsException.class})
    public ResponseEntity<Object> entityNotFoundException(EntityAlreadyExistsException e) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(e.getMessage())
                .timestamp(new Date())
                .errorCode(409)
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }
}
