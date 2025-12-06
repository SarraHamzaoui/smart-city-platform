package com.smartcity.emergencygrpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class EmergencyGrpcServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 9090;
        Server server = ServerBuilder.forPort(port)
                .addService(new EmergencyServiceImpl())
                .build();

        server.start();
        System.out.println("gRPC Emergency Server started on port " + port);

        server.awaitTermination();
    }
}
