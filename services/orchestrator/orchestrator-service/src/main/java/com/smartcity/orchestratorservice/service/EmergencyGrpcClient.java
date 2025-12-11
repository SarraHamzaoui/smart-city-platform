package com.smartcity.orchestratorservice.service;

import com.smartcity.emergencygrpc.stubs.Ack;
import com.smartcity.emergencygrpc.stubs.EmergencyAlert;
import com.smartcity.emergencygrpc.stubs.EmergencyServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmergencyGrpcClient {

    private final EmergencyServiceGrpc.EmergencyServiceBlockingStub blockingStub;
    private final List<IncidentDto> storedAlerts = new ArrayList<>();

    public EmergencyGrpcClient() {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        this.blockingStub = EmergencyServiceGrpc.newBlockingStub(channel);
    }

    public Ack sendEmergencyAlert(String zone, String description) {
        try {
            EmergencyAlert alert = EmergencyAlert.newBuilder()
                    .setAlertId("local-" + System.currentTimeMillis())
                    .setZone(zone)
                    .setType("MANUAL")
                    .setDescription(description == null ? "" : description)
                    .setTimestamp(System.currentTimeMillis())
                    .build();

            Ack ack = blockingStub.sendEmergencyAlert(alert);

            // garder copie simple -> IncidentDto (pour sérialisation JSON côté orchestrateur)
            storedAlerts.add(new IncidentDto(
                    alert.getAlertId(),
                    alert.getZone(),
                    alert.getType(),
                    alert.getDescription(),
                    alert.getTimestamp()
            ));

            return ack;
        } catch (Exception e) {
            return Ack.newBuilder()
                    .setStatus("ERROR")
                    .setMessage("gRPC unavailable: " + e.getMessage())
                    .build();
        }
    }

    public Ack sendZoneInquiry(String zone) {
        try {
            EmergencyAlert alert = EmergencyAlert.newBuilder()
                    .setAlertId("inq-" + zone + "-" + System.currentTimeMillis())
                    .setZone(zone)
                    .setType("INQUIRY")
                    .setDescription("Route inquiry")
                    .setTimestamp(System.currentTimeMillis())
                    .build();

            Ack ack = blockingStub.sendEmergencyAlert(alert);
            return ack;
        } catch (Exception e) {
            return Ack.newBuilder()
                    .setStatus("ERROR")
                    .setMessage("Emergency service offline")
                    .build();
        }
    }

    public List<IncidentDto> getActiveAlerts() {
        return Collections.unmodifiableList(storedAlerts);
    }
}
