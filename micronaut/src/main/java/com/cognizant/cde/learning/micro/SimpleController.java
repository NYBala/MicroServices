package com.cognizant.cde.learning.micro;

import com.cognizant.cde.learning.micro.service.SimpleService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

@Controller("/")
public class SimpleController {

    @Get("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello World";
    }

    @Get(value = "/encrypt", consumes = MediaType.TEXT_PLAIN, produces = MediaType.TEXT_PLAIN)
    public String encrypt() {
        long start = System.currentTimeMillis();
        String encrypted = "Failed Encryption";
        try {
            SimpleService service = new SimpleService();
            encrypted = service.execute();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        long end = System.currentTimeMillis();
        System.out.println("Internal Time Taken: " + (end-start));
        return encrypted;
    }




}
