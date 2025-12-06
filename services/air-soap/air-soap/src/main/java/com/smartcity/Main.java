package com.smartcity;

import com.smartcity.airsoap.service.AirQualityServiceImpl;

import javax.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        String url = "http://0.0.0.0:8082/air-quality";
        Endpoint.publish(url, new AirQualityServiceImpl());
        System.out.println("AirQuality SOAP service running at " + url + "?wsdl");
    }}






