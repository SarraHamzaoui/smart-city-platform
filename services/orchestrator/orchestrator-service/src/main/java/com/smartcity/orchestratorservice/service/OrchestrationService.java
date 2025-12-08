package com.smartcity.orchestratorservice.service;

import com.smartcity.emergencygrpc.stubs.Ack;
import com.smartcity.orchestrator.soapclient.AirQualityData;
import com.smartcity.orchestratorservice.service.ZoneOverviewModels.ZoneOverview;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OrchestrationService {

    private final WebClient mobilityWebClient;
    private final AirSoapClient airSoapClient;
    private final CitizenGraphqlClient citizenGraphqlClient;
    private final EmergencyGrpcClient emergencyGrpcClient;

    public OrchestrationService(
            AirSoapClient airSoapClient,
            CitizenGraphqlClient citizenGraphqlClient,
            EmergencyGrpcClient emergencyGrpcClient) {

        this.airSoapClient = airSoapClient;
        this.citizenGraphqlClient = citizenGraphqlClient;
        this.emergencyGrpcClient = emergencyGrpcClient;

        this.mobilityWebClient = WebClient.builder()
                .baseUrl("http://localhost:8081")
                .build();
    }

    public String planRoute(String zone) {

        AirQualityData air = airSoapClient.getAirQualityData(zone);

        String transportData = mobilityWebClient.get()
                .uri("/mobility/api/lines")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        ZoneOverview zoneInfo = citizenGraphqlClient.getZoneOverview(zone);

        Ack emergencyAck = emergencyGrpcClient.sendZoneInquiry(zone);

        String emergencyMessage = emergencyAck != null
                ? String.format("Emergency system replied: %s (%s)",
                emergencyAck.getStatus(),
                emergencyAck.getMessage())
                : "No emergency data available.";

        return """
                [Smart City Orchestrator]

                ---- Zone: %s ----

                Air Quality (SOAP)
                AQI: %d

                Zone Overview (GraphQL)
                %s

                Emergency Live Check (gRPC)
                %s

                Transport Lines (REST)
                %s
                """.formatted(
                zone,
                air.getAqi(),
                zoneInfo != null
                        ? "Population ~" + zoneInfo.getPopulation() + " — metro: " + zoneInfo.isHasMetro()
                        : "No info",
                emergencyMessage,
                transportData
        );
    }
}
