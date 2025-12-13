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

    private final ManagedChannel channel;
    private final EmergencyServiceGrpc.EmergencyServiceBlockingStub blockingStub;
    private final List<IncidentDto> storedAlerts = new ArrayList<>();

    public EmergencyGrpcClient() {
        // Dynamic host configuration: check env var, default to localhost
        String host = System.getenv("EMERGENCY_HOST") != null ? System.getenv("EMERGENCY_HOST") : "localhost";

        this.channel = ManagedChannelBuilder
                .forAddress(host, 9090)
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

            // Store simple copy -> IncidentDto (for JSON serialization in Orchestrator)
            storedAlerts.add(new IncidentDto(
                    alert.getAlertId(),
                    alert.getZone(),
                    alert.getType(),
                    alert.getDescription(),
                    alert.getTimestamp()
            ));

            return ack;
        } catch (Exception e) {
            System.err.println("gRPC Connection Error: " + e.getMessage());
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

            return blockingStub.sendEmergencyAlert(alert);
        } catch (Exception e) {
            System.err.println("gRPC Inquiry Error: " + e.getMessage());
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