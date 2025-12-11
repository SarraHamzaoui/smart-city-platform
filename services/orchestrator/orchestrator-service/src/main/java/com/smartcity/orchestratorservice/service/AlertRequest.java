package com.smartcity.orchestratorservice.service;


public class AlertRequest {
    private String type;
    private String zone;
    private String description;

    public AlertRequest() {}

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getZone() { return zone; }
    public void setZone(String zone) { this.zone = zone; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
