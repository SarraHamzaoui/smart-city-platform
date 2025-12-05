package com.smartcity.mobilityrest.service;


import com.smartcity.mobilityrest.model.TransportLine;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MobilityService {

    private final List<TransportLine> lines = Arrays.asList(
            new TransportLine("L1", "Ligne 1 - Centre Ville", "METRO", "NORMAL"),
            new TransportLine("B10", "Bus 10 - Gare", "BUS", "DELAYED"),
            new TransportLine("T2", "Tram 2 - Université", "TRAM", "NORMAL")
    );

    public List<TransportLine> getAllLines() {
        return lines;
    }

    public Optional<TransportLine> getLineById(String id) {
        return lines.stream()
                .filter(l -> l.getId().equalsIgnoreCase(id))
                .findFirst();
    }
}