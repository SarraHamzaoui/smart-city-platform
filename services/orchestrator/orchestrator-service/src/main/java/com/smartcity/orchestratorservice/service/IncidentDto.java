package com.smartcity.orchestratorservice.service;


public class IncidentDto {
    private String alertId;
    private String zone;
    private String type;
    private String description;
    private long timestamp;

    public IncidentDto() {}

    public IncidentDto(String alertId, String zone, String type, String description, long timestamp) {
        this.alertId = alertId;
        this.zone = zone;
        this.type = type;
        this.description = description;
        this.timestamp = timestamp;
    }

    public String getAlertId() { return alertId; }
    public void setAlertId(String alertId) { this.alertId = alertId; }

    public String getZone() { return zone; }
    public void setZone(String zone) { this.zone = zone; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
}
