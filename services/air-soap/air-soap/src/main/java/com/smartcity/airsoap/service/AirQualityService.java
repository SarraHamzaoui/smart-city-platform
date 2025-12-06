package com.smartcity.airsoap.service;

import com.smartcity.airsoap.model.AirQualityData;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface AirQualityService {

    @WebMethod
    AirQualityData getAirQualityByZone(@WebParam(name = "zone") String zone);

}