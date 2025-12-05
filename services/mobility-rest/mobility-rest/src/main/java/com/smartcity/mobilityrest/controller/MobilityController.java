package com.smartcity.mobilityrest.controller;

import com.smartcity.mobilityrest.model.TransportLine;
import com.smartcity.mobilityrest.service.MobilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


import java.util.List;
@RestController
@RequestMapping("/api/lines")
@Tag(name = "Mobility", description = "Gestion des lignes de transport public")
public class MobilityController {

    private final MobilityService mobilityService;

    public MobilityController(MobilityService mobilityService) {
        this.mobilityService = mobilityService;
    }

    @GetMapping
    @Operation(
            summary = "Lister toutes les lignes",
            description = "Retourne la liste des lignes de transport avec leur type et leur état."
    )
    public List<TransportLine> getALLlines() {
        return mobilityService.getAllLines();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Obtenir une ligne par ID",
            description = "Retourne les détails d'une ligne spécifique si elle existe."
    )
    public ResponseEntity<TransportLine> getLineById(@PathVariable String id) {
        return mobilityService.getLineById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
