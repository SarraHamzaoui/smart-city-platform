package com.smartcity.orchestratorservice.service;

import com.smartcity.orchestratorservice.service.ZoneOverviewModels.GraphqlResponse;
import com.smartcity.orchestratorservice.service.ZoneOverviewModels.ZoneOverview;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@Component
public class CitizenGraphqlClient {

    private final WebClient webClient;

    public CitizenGraphqlClient() {
        // Dynamic host configuration: check env var, default to localhost
        String host = System.getenv("CITIZEN_HOST") != null ? System.getenv("CITIZEN_HOST") : "localhost";

        this.webClient = WebClient.builder()
                .baseUrl("http://" + host + ":8083")
                .build();
    }

    public ZoneOverview getZoneOverview(String zone) {

        String query = """
                query($zone:String!) {
                  zoneOverview(zone: $zone) {
                    zone
                    population
                    serviceCount
                    hasHospital
                    hasMetro
                  }
                }
                """;

        Map<String, Object> variables = new HashMap<>();
        variables.put("zone", zone);

        Map<String, Object> body = new HashMap<>();
        body.put("query", query);
        body.put("variables", variables);

        try {
            GraphqlResponse response = webClient.post()
                    .uri("/citizen/graphql")
                    .bodyValue(body)
                    .retrieve()
                    .bodyToMono(GraphqlResponse.class)
                    .block();

            return (response != null && response.getData() != null)
                    ? response.getData().getZoneOverview()
                    : null;
        } catch (Exception e) {
            System.err.println("Error calling GraphQL Service: " + e.getMessage());
            return null;
        }
    }
}