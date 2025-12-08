package com.smartcity.orchestratorservice.service;

import com.smartcity.orchestrator.soapclient.AirQualityData;
import com.smartcity.orchestrator.soapclient.AirQualityService;
import com.smartcity.orchestrator.soapclient.AirQualityServiceImplService;
import org.springframework.stereotype.Component;

@Component
public class AirSoapClient {

    // Création du port SOAP à la demande
    private AirQualityService createPort() {
        AirQualityServiceImplService service = new AirQualityServiceImplService();
        return service.getAirQualityServiceImplPort();
    }

    public AirQualityData getAirQualityData(String zone) {
        try {
            return createPort().getAirQualityByZone(zone);
        } catch (Exception e) {
            // ici on évite que l'orchestrateur crashe si SOAP est KO
            AirQualityData fallback = new AirQualityData();
            fallback.setZone("ERROR");
            fallback.setAqi(-1);
            fallback.setNo2(0);
            fallback.setCo2(0);
            fallback.setO3(0);
            return fallback;
        }
    }
}