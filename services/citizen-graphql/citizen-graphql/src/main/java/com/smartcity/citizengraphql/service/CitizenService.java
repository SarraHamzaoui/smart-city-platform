package com.smartcity.citizengraphql.service;

import com.smartcity.citizengraphql.model.CityService;
import com.smartcity.citizengraphql.model.ZoneOverview;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitizenService {

    private final List<CityService> services = Arrays.asList(
            new CityService("S1", "Hôpital Central", "HOSPITAL", "CENTRE", true),
            new CityService("S2", "École Primaire 1", "SCHOOL", "CENTRE", false),
            new CityService("S3", "Station Vélo - Université", "BIKE_STATION", "UNIVERSITE", true),
            new CityService("S4", "Station Métro - Centre", "METRO_STATION", "CENTRE", true)
    );

    public List<CityService> getServicesByZone(String zone) {
        return services.stream()
                .filter(s -> s.getZone().equalsIgnoreCase(zone))
                .collect(Collectors.toList());
    }

    public ZoneOverview getZoneOverview(String zone) {
        List<CityService> zoneServices = getServicesByZone(zone);
        boolean hasHospital = zoneServices.stream().anyMatch(s -> s.getType().equals("HOSPITAL"));
        boolean hasMetro = zoneServices.stream().anyMatch(s -> s.getType().startsWith("METRO"));

        // données simulées
        int population = "CENTRE".equalsIgnoreCase(zone) ? 150000 : 30000;

        return new ZoneOverview(
                zone.toUpperCase(),
                population,
                zoneServices.size(),
                hasHospital,
                hasMetro
        );
    }
}