package com.smartcity.airsoap.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AirQualityData")
@XmlAccessorType(XmlAccessType.FIELD)
public class AirQualityData {

    private String zone;
    private int aqi;
    private double no2;
    private double co2;
    private double o3;

    public AirQualityData() {
    }

    public AirQualityData(String zone, int aqi, double no2, double co2, double o3) {
        this.zone = zone;
        this.aqi = aqi;
        this.no2 = no2;
        this.co2 = co2;
        this.o3 = o3;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }

    public double getNo2() {
        return no2;
    }

    public void setNo2(double no2) {
        this.no2 = no2;
    }

    public double getCo2() {
        return co2;
    }

    public void setCo2(double co2) {
        this.co2 = co2;
    }

    public double getO3() {
        return o3;
    }

    public void setO3(double o3) {
        this.o3 = o3;
    }
}