package com.smartcity.orchestratorservice.service;


public class AckDto {
    private String status;
    private String message;

    public AckDto() {}
    public AckDto(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
