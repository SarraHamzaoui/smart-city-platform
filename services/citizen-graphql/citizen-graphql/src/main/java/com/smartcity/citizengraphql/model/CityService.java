package com.smartcity.citizengraphql.model;


public class CityService {
    private String id;
    private String name;
    private String type;
    private String zone;
    private boolean openNow;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getZone() {
        return zone;
    }

    public boolean isOpenNow() {
        return openNow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOpenNow(boolean openNow) {
        this.openNow = openNow;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public CityService() {
    }

    public CityService(String id, String name, String type, String zone, boolean openNow) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.zone = zone;
        this.openNow = openNow;
    }

}
