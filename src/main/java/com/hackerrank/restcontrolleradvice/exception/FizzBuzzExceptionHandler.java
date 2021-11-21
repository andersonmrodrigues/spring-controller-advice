package com.hackerrank.restcontrolleradvice.exception;

import com.hackerrank.restcontrolleradvice.dto.BuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzBuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzException;
import com.hackerrank.restcontrolleradvice.dto.GlobalError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class FizzBuzzExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(FizzException.class)
    public GlobalError handleFizzExpcetion(FizzException e) {
        return new GlobalError(e.getMessage(), e.getErrorReason());
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BuzzException.class)
    public GlobalError handleBuzzExpcetion(BuzzException e) {
        return new GlobalError(e.getMessage(), e.getErrorReason());
    }

    @ResponseStatus(value = HttpStatus.INSUFFICIENT_STORAGE)
    @ExceptionHandler(FizzBuzzException.class)
    public GlobalError handleFizzBuzzExpcetion(FizzBuzzException e) {
        return new GlobalError(e.getMessage(), e.getErrorReason());
    }

    //TODO:: implement handler methods for FizzException, BuzzException and FizzBuzzException
}
