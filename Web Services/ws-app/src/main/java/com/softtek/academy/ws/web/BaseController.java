package com.softtek.academy.ws.web;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.softtek.academy.ws.domain.dto.ErrorResponse;
import com.softtek.academy.ws.exception.InvalidInputException;
import com.softtek.academy.ws.exception.NotFoundException;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestControllerAdvice(basePackages = "com.softtek.academy.ws.web")
public class BaseController {

    

    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleParamErrors(MissingServletRequestParameterException ex) {
        String errorMessage = "Missing parameter: " + ex.getParameterName();

        return this.buildErrorResponse(errorMessage,ex);
    }

    @ExceptionHandler({InvalidInputException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInputValidation(InvalidInputException ex) {
        return this.buildErrorResponse(ex.getMessage(),ex);
    }
    
    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleInputValidation(NotFoundException ex) {
        return this.buildErrorResponse(ex.getMessage(),ex);
    }

    @ExceptionHandler({IllegalArgumentException.class, TypeMismatchException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleClientErrors(RuntimeException ex) {
        String errorMessage = "Illegal argument: " + ExceptionUtils.getRootCauseMessage(ex);

        return this.buildErrorResponse(errorMessage,ex);
    }




    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleServerErrors(Exception ex) {
        String errorMessage = "Fatal service error: " + ExceptionUtils.getRootCauseMessage(ex);

        return this.buildErrorResponse(errorMessage,ex);
    }


    private ErrorResponse buildErrorResponse(String message,Exception ex) {
        log.error(ex.getMessage(), ex);

        return new ErrorResponse(message, ex.getMessage());
    }

}
