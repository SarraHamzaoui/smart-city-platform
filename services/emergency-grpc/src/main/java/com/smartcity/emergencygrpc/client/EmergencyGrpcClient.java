package com.smartcity.emergencygrpc.client;

import com.smartcity.emergencygrpc.stubs.Ack;
import com.smartcity.emergencygrpc.stubs.EmergencyAlert;
import com.smartcity.emergencygrpc.stubs.EmergencyServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.time.Instant;
import java.util.UUID;

public class EmergencyGrpcClient {

    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        EmergencyServiceGrpc.EmergencyServiceBlockingStub stub =
                EmergencyServiceGrpc.newBlockingStub(channel);

        EmergencyAlert alert = EmergencyAlert.newBuilder()
                .setAlertId(UUID.randomUUID().toString())
                .setType("ACCIDENT")
                .setDescription("Accident grave près de la zone CENTRE")
                .setZone("CENTRE")
                .setTimestamp(Instant.now().toEpochMilli())
                .build();

        Ack ack = stub.sendEmergencyAlert(alert);
        System.out.println("Server response: " + ack.getStatus() + " - " + ack.getMessage());

        channel.shutdown();
    }
}
