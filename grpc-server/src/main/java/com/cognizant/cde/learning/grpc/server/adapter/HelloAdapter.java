package com.cognizant.cde.learning.grpc.server.adapter;

import com.cognizant.cde.learning.grpc.HelloRequest;
import com.cognizant.cde.learning.grpc.HelloResponse;

public class HelloAdapter {
    public HelloResponse execute(HelloRequest helloRequest) {
        String greeting = new StringBuilder().append("Hello, ")
                .append(helloRequest.getFirstName())
                .append(" ")
                .append(helloRequest.getLastName())
                .toString();
        HelloResponse helloResponse = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();
        return helloResponse;
    }
}
