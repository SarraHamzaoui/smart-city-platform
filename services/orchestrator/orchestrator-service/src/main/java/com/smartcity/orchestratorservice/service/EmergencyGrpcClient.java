package com.smartcity.orchestratorservice.service;

import com.smartcity.emergencygrpc.stubs.Ack;
import com.smartcity.emergencygrpc.stubs.EmergencyAlert;
import com.smartcity.emergencygrpc.stubs.EmergencyServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;

@Component
public class EmergencyGrpcClient {

    private final ManagedChannel channel;
    private final EmergencyServiceGrpc.EmergencyServiceBlockingStub blockingStub;

    public EmergencyGrpcClient() {
        this.channel = ManagedChannelBuilder
                .forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        this.blockingStub = EmergencyServiceGrpc.newBlockingStub(channel);
    }


    public Ack sendZoneInquiry(String zone) {

        EmergencyAlert alert = EmergencyAlert.newBuilder()
                .setAlertId("check-" + zone)
                .setType("ZONE_INQUIRY")
                .setDescription("Requesting emergency status for zone")
                .setZone(zone)
                .setTimestamp(System.currentTimeMillis())
                .build();

        return blockingStub.sendEmergencyAlert(alert);
    }

    public void shutdown() {
        channel.shutdown();
    }
}
