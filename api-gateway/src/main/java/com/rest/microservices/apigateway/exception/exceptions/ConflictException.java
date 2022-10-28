package com.rest.microservices.apigateway.exception.exceptions;


public class ConflictException extends RuntimeException {

    private final String message;
    private final String developerMessage;
    private final Throwable cause;

    public ConflictException(String message) {
        this.message = message;
        this.developerMessage = null;
        this.cause = null;
    }

    public ConflictException(String message, String developerMessage) {
        this.message = message;
        this.developerMessage = developerMessage;
        this.cause = new ConflictException(developerMessage);
    }

    public ConflictException(String message, Throwable cause) {
        this.message = message;
        this.cause = cause;
        this.developerMessage = null;
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
}
