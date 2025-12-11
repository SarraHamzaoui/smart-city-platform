package com.smartcity.orchestratorservice.controller;

import com.smartcity.orchestratorservice.service.OrchestrationService;
import com.smartcity.orchestratorservice.service.IncidentDto; // adapte le package si nécessaire
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orchestrator")
public class OrchestratorController {

    private final OrchestrationService service;

    public OrchestratorController(OrchestrationService service) {
        this.service = service;
    }

    @GetMapping("/plan-route")
    public Object planRoute(@RequestParam String zone) {
        return service.planRoute(zone);
    }

    /**
     * Recevoir une alerte depuis le front (POST) et la transmettre via le service.
     * Retourne l'Ack reçu du service (status/message).
     */
    @PostMapping("/alerts")
    public ResponseEntity<Map<String, String>> handleAlert(@RequestBody Map<String, Object> body) {
        String type = (String) body.get("type");
        String zone = (String) body.get("zone");
        String description = (String) body.get("description");

        // Appel du service pour envoyer et stocker l'alerte
        var ack = service.sendUserAlert(zone, type, description); // AckDto attendu

        Map<String, String> resp = Map.of(
                "status", ack.getStatus(),
                "message", ack.getMessage()
        );
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/alerts")
    public ResponseEntity<List<IncidentDto>> listAlerts() {
        List<IncidentDto> alerts = service.getActiveAlerts();
        return ResponseEntity.ok(alerts);
    }
}
