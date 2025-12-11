package com.smartcity.orchestratorservice.service;

import com.smartcity.orchestrator.soapclient.AirQualityData;
import com.smartcity.orchestrator.soapclient.AirQualityService;
import com.smartcity.orchestrator.soapclient.AirQualityServiceImplService;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component
public class AirSoapClient {

    private AirQualityService port;

    private AirQualityService getPort() {
        if (port == null) {
            try {
                URL wsdl = new URL("http://localhost:8082/air-quality?wsdl");
                port = new AirQualityServiceImplService(wsdl).getAirQualityServiceImplPort();
            } catch (Exception e) {
                return null;
            }
        }
        return port;
    }

    public AirQualityData getAirQualityData(String zone) {
        try {
            AirQualityService service = getPort();
            return (service != null) ? service.getAirQualityByZone(zone) : fallback(zone);
        } catch (Exception e) {
            return fallback(zone);
        }
    }

    private AirQualityData fallback(String zone) {
        AirQualityData d = new AirQualityData();
        d.setZone(zone);
        d.setAqi(-1);
        d.setNo2(0);
        d.setCo2(0);
        d.setO3(0);
        return d;
    }
}
