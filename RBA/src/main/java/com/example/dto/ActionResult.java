package com.example.dto;

import java.io.Serializable;

public class ActionResult implements Serializable{

    private StatusCode status;
    private String message;

    public StatusCode getStatus() {
        return status;
    }

    public void setStatus(StatusCode status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public enum StatusCode {
        OK,
        ERROR
    }
    
    
}
