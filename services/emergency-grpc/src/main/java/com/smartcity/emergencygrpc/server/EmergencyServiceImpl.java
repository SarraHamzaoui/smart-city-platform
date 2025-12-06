package com.smartcity.emergencygrpc.server;

import com.smartcity.emergencygrpc.stubs.Ack;
import com.smartcity.emergencygrpc.stubs.EmergencyAlert;
import com.smartcity.emergencygrpc.stubs.Empty;
import com.smartcity.emergencygrpc.stubs.EmergencyServiceGrpc;
import com.smartcity.emergencygrpc.stubs.VehiclePosition;
import io.grpc.stub.StreamObserver;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class EmergencyServiceImpl extends EmergencyServiceGrpc.EmergencyServiceImplBase {

    @Override
    public void streamVehiclePositions(Empty request, StreamObserver<VehiclePosition> responseObserver) {
        List<VehiclePosition> positions = Arrays.asList(
                VehiclePosition.newBuilder()
                        .setVehicleId("AMBULANCE-1")
                        .setLine("Urgence 1")
                        .setZone("CENTRE")
                        .setLatitude(36.8000)
                        .setLongitude(10.1800)
                        .setTimestamp(Instant.now().toEpochMilli())
                        .build(),
                VehiclePosition.newBuilder()
                        .setVehicleId("BUS-42")
                        .setLine("Ligne 42")
                        .setZone("UNIVERSITE")
                        .setLatitude(36.8100)
                        .setLongitude(10.1900)
                        .setTimestamp(Instant.now().plusSeconds(5).toEpochMilli())
                        .build(),
                VehiclePosition.newBuilder()
                        .setVehicleId("AMBULANCE-2")
                        .setLine("Urgence 2")
                        .setZone("ZONE_INDUS")
                        .setLatitude(36.8200)
                        .setLongitude(10.2000)
                        .setTimestamp(Instant.now().plusSeconds(10).toEpochMilli())
                        .build()
        );

        for (VehiclePosition pos : positions) {
            responseObserver.onNext(pos);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        responseObserver.onCompleted();
    }

    @Override
    public void sendEmergencyAlert(EmergencyAlert request, StreamObserver<Ack> responseObserver) {
        System.out.println(">>> Emergency alert received: " +
                request.getType() + " in zone " + request.getZone() +
                " - " + request.getDescription());

        Ack ack = Ack.newBuilder()
                .setStatus("OK")
                .setMessage("Alert " + request.getAlertId() + " received and dispatched.")
                .build();

        responseObserver.onNext(ack);
        responseObserver.onCompleted();
    }
}