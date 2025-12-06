package com.smartcity.citizengraphql.controller;

import com.smartcity.citizengraphql.model.CityService;
import com.smartcity.citizengraphql.model.ZoneOverview;
import com.smartcity.citizengraphql.service.CitizenService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CitizenGraphQLController {

    private final CitizenService citizenService;

    public CitizenGraphQLController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @QueryMapping
    public List<CityService> servicesByZone(@Argument String zone) {
        return citizenService.getServicesByZone(zone);
    }

    @QueryMapping
    public ZoneOverview zoneOverview(@Argument String zone) {
        return citizenService.getZoneOverview(zone);
    }
}