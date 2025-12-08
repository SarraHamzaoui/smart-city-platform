package com.smartcity.orchestratorservice.controller;


import com.smartcity.orchestratorservice.service.OrchestrationService;
import org.springframework.web.bind.annotation.*;

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
}

