package com.rest.microservices.currencyconversionservice.exception;

import com.rest.microservices.currencyconversionservice.exception.constants.StatusCode;
import com.rest.microservices.currencyconversionservice.exception.exceptions.BadRequestException;
import com.rest.microservices.currencyconversionservice.exception.exceptions.ConflictException;
import com.rest.microservices.currencyconversionservice.exception.exceptions.ForbiddenException;
import com.rest.microservices.currencyconversionservice.exception.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class DefaultExceptionMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultExceptionMapper.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage processValidationError(MethodArgumentNotValidException ex,
        HttpServletResponse response) {
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        LOGGER.debug("Validation error on field {}, exception: ", errors, ex);
        ErrorMessage msg = new ErrorMessage();
        msg.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
        msg.setCode(HttpStatus.BAD_REQUEST.value());
        msg.setMessage(StatusCode._400.getDescription());
        msg.setDeveloperMessage("Request caused an MethodArgumentNotValidException: " + errors.toString());
        return msg;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage illegalArgumentToBadRequestException(Exception e,
            HttpServletResponse response) {
        LOGGER.debug("Request caused an IllegalArgumentException", e);
        ErrorMessage msg = new ErrorMessage();
        msg.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
        msg.setCode(HttpStatus.BAD_REQUEST.value());
        msg.setMessage(StatusCode._400.getDescription());
        msg.setDeveloperMessage("Request caused an IllegalArgumentException: " + e.getMessage());
        return msg;
    }



    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage badRequestException(BadRequestException e, HttpServletResponse response) {
        LOGGER.debug(e.getDeveloperMessage(), e.getCause());
        ErrorMessage msg = new ErrorMessage();
        msg.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
        msg.setCode(HttpStatus.BAD_REQUEST.value());
        msg.setMessage(e.getMessage());
        msg.setDeveloperMessage(e.getDeveloperMessage());
        return msg;
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorMessage conflictException(ConflictException e, HttpServletResponse response) {
        LOGGER.debug(e.getDeveloperMessage(), e.getCause());
        ErrorMessage msg = new ErrorMessage();
        msg.setStatus(HttpStatus.CONFLICT.getReasonPhrase());
        msg.setCode(HttpStatus.CONFLICT.value());
        msg.setMessage(e.getMessage());
        msg.setDeveloperMessage(e.getDeveloperMessage());
        return msg;
    }


    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessage notFoundException(NotFoundException e, HttpServletResponse response) {
        LOGGER.debug(e.getDeveloperMessage(), e.getCause());
        ErrorMessage msg = new ErrorMessage();
        msg.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
        msg.setCode(HttpStatus.NOT_FOUND.value());
        msg.setMessage(e.getMessage());
        msg.setDeveloperMessage(e.getDeveloperMessage());
        return msg;
    }

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ErrorMessage forbiddenException(ForbiddenException e, HttpServletResponse response) {
        LOGGER.debug(e.getDeveloperMessage(), e.getCause());
        ErrorMessage msg = new ErrorMessage();
        msg.setStatus(HttpStatus.FORBIDDEN.getReasonPhrase());
        msg.setCode(HttpStatus.FORBIDDEN.value());
        msg.setMessage(e.getMessage());
        msg.setDeveloperMessage(e.getDeveloperMessage());
        msg.setReasonCode(e.getReasonCode());
        return msg;
    }
}
