package com.cognizant.cde.learning.grpc.server;

import java.io.IOException;
import java.util.Date;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {
    public static final int PORT = 9000;
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(PORT)
          .addService(new SimpleServiceImpl()).build();
        server.start();
        System.out.println("gRPC Server started on "+ PORT + " at " + new Date());
        server.awaitTermination();
    }
}
