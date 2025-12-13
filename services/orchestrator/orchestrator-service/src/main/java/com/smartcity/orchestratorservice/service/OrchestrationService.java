package com.smartcity.orchestratorservice.service;

import com.smartcity.orchestrator.soapclient.AirQualityData;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class OrchestrationService {

    private final WebClient mobilityWebClient;
    private final AirSoapClient airSoapClient;
    private final CitizenGraphqlClient citizenGraphqlClient;
    private final EmergencyGrpcClient emergencyGrpcClient;

    public OrchestrationService(AirSoapClient airSoapClient,
                                CitizenGraphqlClient citizenGraphqlClient,
                                EmergencyGrpcClient emergencyGrpcClient) {
        this.airSoapClient = airSoapClient;
        this.citizenGraphqlClient = citizenGraphqlClient;
        this.emergencyGrpcClient = emergencyGrpcClient;

        // --- CORRECTION ICI ---
        // On vérifie si la variable d'environnement Docker existe.
        // Si oui, on l'utilise (mobility-service). Sinon, on reste sur localhost (pour tests locaux).
        String mobilityHost = System.getenv("MOBILITY_HOST") != null ? System.getenv("MOBILITY_HOST") : "localhost";

        this.mobilityWebClient = WebClient.builder()
                .baseUrl("http://" + mobilityHost + ":8081")
                .build();
    }

    public SmartCityRouteResponse planRoute(String zone) {

        SmartCityRouteResponse response = new SmartCityRouteResponse();
        response.setZone(zone);

        // 1) SOAP – qualité de l'air
        try {
            AirQualityData air = airSoapClient.getAirQualityData(zone);
            if (air != null) {
                SmartCityRouteResponse.AirQualitySection airSection = new SmartCityRouteResponse.AirQualitySection();
                airSection.setZone(air.getZone());
                airSection.setAqi(air.getAqi());
                airSection.setNo2(air.getNo2());
                airSection.setCo2(air.getCo2());
                airSection.setO3(air.getO3());

                if (air.getAqi() < 0) {
                    airSection.setLevelLabel("Inconnue");
                    airSection.setAdvisory("Qualité de l’air non disponible pour cette zone.");
                } else if (air.getAqi() <= 50) {
                    airSection.setLevelLabel("Bonne");
                    airSection.setAdvisory("Air très bon, aucune restriction.");
                } else if (air.getAqi() <= 100) {
                    airSection.setLevelLabel("Modérée");
                    airSection.setAdvisory("Air acceptable, attention pour les personnes sensibles.");
                } else {
                    airSection.setLevelLabel("Mauvaise");
                    airSection.setAdvisory("Air pollué, limitez les efforts physiques à l’extérieur.");
                }
                response.setAirQuality(airSection);
            }
        } catch (Exception e) {
            System.err.println("Erreur SOAP: " + e.getMessage());
            // On continue même si le SOAP échoue
        }

        // 2) REST – lignes de transport
        try {
            List<TransportLineDto> lines = mobilityWebClient.get()
                    .uri("/mobility/api/lines")
                    .retrieve()
                    .bodyToFlux(TransportLineDto.class)
                    .collectList()
                    .block();
            response.setTransportLines(lines);
        } catch (Exception e) {
            System.err.println("Erreur REST Mobility: " + e.getMessage());
            // On continue
        }

        // 3) GraphQL – vue zone
        try {
            ZoneOverviewModels.ZoneOverview zoneInfo = citizenGraphqlClient.getZoneOverview(zone);
            if (zoneInfo != null) {
                SmartCityRouteResponse.ZoneOverviewSection zoneSection = new SmartCityRouteResponse.ZoneOverviewSection();
                zoneSection.setPopulation(zoneInfo.getPopulation());
                zoneSection.setServiceCount(zoneInfo.getServiceCount());
                zoneSection.setHasHospital(zoneInfo.isHasHospital());
                zoneSection.setHasMetro(zoneInfo.isHasMetro());
                response.setAnalytics(zoneSection);
            }
        } catch (Exception e) {
            System.err.println("Erreur GraphQL: " + e.getMessage());
        }

        // 4) gRPC – envoyer une « demande d’info » pour le trajet
        try {
            var ack = emergencyGrpcClient.sendZoneInquiry(zone);
            SmartCityRouteResponse.EmergencySection emergencySection = new SmartCityRouteResponse.EmergencySection();
            emergencySection.setStatus(ack.getStatus());
            emergencySection.setMessage(ack.getMessage());
            response.setEmergency(emergencySection);

            // 5) incidents locaux stockés
            response.setIncidents(emergencyGrpcClient.getActiveAlerts());
        } catch (Exception e) {
            System.err.println("Erreur gRPC: " + e.getMessage());
        }

        return response;
    }

    public AckDto sendUserAlert(String zone, String type, String description) {
        var ack = emergencyGrpcClient.sendEmergencyAlert(zone, description == null ? type : description);
        return new AckDto(ack.getStatus(), ack.getMessage());
    }

    public List<IncidentDto> getActiveAlerts() {
        return emergencyGrpcClient.getActiveAlerts();
    }
}