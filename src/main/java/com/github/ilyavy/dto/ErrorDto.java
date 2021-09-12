package com.github.ilyavy.dto;

import java.time.Instant;

public class ErrorDto {

    private Instant timestamp;

    private int status;

    private String error;

    private String message;

    private String path;

    public Instant getTimestamp() {
        return timestamp;
    }

    public ErrorDto setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public ErrorDto setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getError() {
        return error;
    }

    public ErrorDto setError(String error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ErrorDto setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getPath() {
        return path;
    }

    public ErrorDto setPath(String path) {
        this.path = path;
        return this;
    }
}
