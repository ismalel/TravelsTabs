package com.encora.travelstab.http;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class ApiResponse implements Serializable {

    @JsonIgnore
    private static final long serialVersionUID = 7702134516418120340L;

    @JsonProperty("success")
    private Boolean success;

    @JsonProperty("message")
    private String message;

    @JsonIgnore
    private HttpStatus status;

    public ApiResponse() {

    }

    public ApiResponse(Boolean success, String message) {
        this.setSuccess(success);
        this.setMessage(message);
    }

    public ApiResponse(Boolean success, String message, HttpStatus httpStatus) {
        this.setSuccess(success);
        this.setMessage(message);
        this.setStatus(httpStatus);
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
