package com.cognizant.cde.learning.grpc.client;


import com.cognizant.cde.learning.grpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9000)
                .usePlaintext()
                .build();

        SimpleServiceGrpc.SimpleServiceBlockingStub stub
                = SimpleServiceGrpc.newBlockingStub(channel);

        if(args.length > 0) {
            String firstName = "Alexander";
            String lastName = "Hamilton";
            if(args.length > 0 && args[0] != null && args[0].length() > 0){
                firstName = args[0];
            }
            if(args.length > 1 && args[1] != null && args[1].length() > 0){
                lastName = args[1];
            }
            for(int k = 0; k < 10; k++){
                long start = System.currentTimeMillis();
                HelloResponse helloResponse = stub.sayHello(HelloRequest.newBuilder()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .build());
                long end = System.currentTimeMillis();
                System.out.println("Time Taken in milliseconds: " + (end-start));
                System.out.println("Response received from server:\n" + helloResponse);
            }

        } else {
            for(int k = 0; k < 10; k++){
                long start = System.currentTimeMillis();
                EncryptResponse encryptResponse = stub.encrypt(EncryptRequest.newBuilder()
                        .setCleartext("encrypt")
                        .build());
                long end = System.currentTimeMillis();
                System.out.println("Time Taken in milliseconds: " + (end-start));
                System.out.println("Response received from server:\n" + encryptResponse);
            }
        }




        channel.shutdown();
    }
}
