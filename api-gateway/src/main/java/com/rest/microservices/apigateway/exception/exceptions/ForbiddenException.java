package com.rest.microservices.apigateway.exception.exceptions;


public class ForbiddenException extends RuntimeException {

    private final String message;
    private final String developerMessage;
    private final Throwable cause;
    private final Integer reasonCode;

    public ForbiddenException(String message) {
        this.message = message;
        this.developerMessage = null;
        this.cause = null;
        this.reasonCode = null;
    }

    public ForbiddenException(String message, String developerMessage) {
        this.message = message;
        this.developerMessage = developerMessage;
        this.cause = new ForbiddenException(developerMessage);
        this.reasonCode = null;
    }

    public ForbiddenException(String message, String developerMessage, Throwable cause) {
        this.message = message;
        this.developerMessage = developerMessage;
        this.cause = cause;
        this.reasonCode = null;
    }

    public ForbiddenException(String message, String developerMessage, Integer reasonCode) {
        this.message = message;
        this.developerMessage = developerMessage;
        this.reasonCode = reasonCode;
        this.cause = null;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    @Override
    public synchronized Throwable getCause() {
        return cause;
    }

    public Integer getReasonCode() {
        return reasonCode;
    }
}
