package com.cognizant.cde.learning.grpc.server;


import com.cognizant.cde.learning.grpc.*;
import com.cognizant.cde.learning.grpc.server.adapter.EncryptAdapter;
import com.cognizant.cde.learning.grpc.server.adapter.HelloAdapter;
import io.grpc.stub.StreamObserver;

public class SimpleServiceImpl extends SimpleServiceGrpc.SimpleServiceImplBase {

    @Override
    public void sayHello(HelloRequest helloRequest, StreamObserver<HelloResponse> responseObserver) {
        long start = System.currentTimeMillis();
        System.out.println("Request received from client:\n" + helloRequest);
        HelloAdapter helloAdapter = new HelloAdapter();
        HelloResponse response = helloAdapter.execute(helloRequest);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
        long end = System.currentTimeMillis();
        System.out.println("Internal time taken: " + (end-start));
    }

    @Override
    public void encrypt(EncryptRequest encryptRequest, StreamObserver<EncryptResponse> responseObserver) {
        long start = System.currentTimeMillis();
        System.out.println("Encrypt Request received from client:\n");
        EncryptAdapter encryptAdapter = new EncryptAdapter();
        EncryptResponse encryptResponse = encryptAdapter.execute(encryptRequest);
        responseObserver.onNext(encryptResponse);
        responseObserver.onCompleted();
        long end = System.currentTimeMillis();
        System.out.println("Internal time taken: " + (end-start));
    }
}
