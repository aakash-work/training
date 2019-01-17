package com.miq.bootcamp.springboottraining.model;

/**
 * ErrorDetails
 */

public class ErrorDetails {

    private String message;
    private String details;

    public ErrorDetails() {
    }

    public ErrorDetails(String message, String details) {
        this.message = message;
        this.details = details;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}