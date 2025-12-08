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
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8083")
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

        GraphqlResponse response = webClient.post()
                .uri("/citizen/graphql")
                .bodyValue(body)
                .retrieve()
                .bodyToMono(GraphqlResponse.class)
                .block();

        if (response == null || response.getData() == null) {
            return null;
        }

        return response.getData().getZoneOverview();
    }
}
