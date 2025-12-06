package com.smartcity.airsoap.service;

import com.smartcity.airsoap.model.AirQualityData;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

@WebService(endpointInterface = "com.smartcity.airsoap.service.AirQualityService")
public class AirQualityServiceImpl implements AirQualityService {

    // Données simulées en mémoire
    private static final Map<String, AirQualityData> DATA = new HashMap<>();

    static {
        DATA.put("CENTRE", new AirQualityData("CENTRE", 80, 35.2, 420.5, 60.1));
        DATA.put("UNIVERSITE", new AirQualityData("UNIVERSITE", 55, 20.5, 380.0, 40.3));
        DATA.put("ZONE_INDUS", new AirQualityData("ZONE_INDUS", 120, 60.0, 500.2, 90.0));
    }

    @Override
    public AirQualityData getAirQualityByZone(String zone) {

        if (zone == null || zone.isBlank()) {
            return new AirQualityData("UNKNOWN", -1, 0, 0, 0);
        }

        AirQualityData data = DATA.get(zone.toUpperCase());
        if (data == null) {
            return new AirQualityData(zone, -1, 0, 0, 0);
        }
        return data;
    }

}