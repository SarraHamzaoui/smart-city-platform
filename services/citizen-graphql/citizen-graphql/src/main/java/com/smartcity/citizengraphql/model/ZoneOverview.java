package com.smartcity.citizengraphql.model;


public class ZoneOverview {
    private String zone;
    private int population;
    private int serviceCount;
    private boolean hasHospital;
    private boolean hasMetro;

    public ZoneOverview() {
    }

    public ZoneOverview(String zone, int population, int serviceCount, boolean hasHospital, boolean hasMetro) {
        this.zone = zone;
        this.population = population;
        this.serviceCount = serviceCount;
        this.hasHospital = hasHospital;
        this.hasMetro = hasMetro;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getServiceCount() {
        return serviceCount;
    }

    public void setServiceCount(int serviceCount) {
        this.serviceCount = serviceCount;
    }

    public boolean isHasHospital() {
        return hasHospital;
    }

    public void setHasHospital(boolean hasHospital) {
        this.hasHospital = hasHospital;
    }

    public boolean isHasMetro() {
        return hasMetro;
    }

    public void setHasMetro(boolean hasMetro) {
        this.hasMetro = hasMetro;
    }
}
