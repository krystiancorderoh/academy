package com.softtek.academy.jpa.web;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.softtek.academy.jpa.exception.InvalidInputException;
import com.softtek.academy.jpa.web.response.ErrorResponse;

@RestControllerAdvice(basePackages = "com.softtek.academy.ws.web")
public class BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);


    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleParamErrors(MissingServletRequestParameterException ex) {
        String errorMessage = "Missing parameter: " + ex.getParameterName();

        return this.buildErrorResponse(ex, errorMessage, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({IllegalArgumentException.class, TypeMismatchException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleClientErrors(Exception ex) {
        String errorMessage = "Illegal argument: " + ExceptionUtils.getRootCauseMessage(ex);

        return this.buildErrorResponse(ex, errorMessage, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({InvalidInputException.class})
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public ErrorResponse handleInputValidation(Exception ex) {
        return this.buildErrorResponse(ex, ex.getMessage(), HttpStatus.PRECONDITION_FAILED);
    }


    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleServerErrors(Exception ex) {
        String errorMessage = "Fatal service error: " + ExceptionUtils.getRootCauseMessage(ex);

        return this.buildErrorResponse(ex, errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    private ErrorResponse buildErrorResponse(Exception ex, String message, HttpStatus finalHttpStatus) {
        LOGGER.error(ex.getMessage(), ex);

        return new ErrorResponse(finalHttpStatus.value(), message, ex.getMessage());
    }

}
