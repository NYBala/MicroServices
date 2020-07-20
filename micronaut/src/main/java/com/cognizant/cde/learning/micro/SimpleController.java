package com.cognizant.cde.learning.micro;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;

@Controller("/")
public class SimpleController {

    public static final String SECRET_KEY = "tnazingoc";

    @Get("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello World";
    }

    @Post("/encrypt")
    @Produces(MediaType.TEXT_PLAIN)
    public String encrypt() {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        String privateData = "secret-data";
        textEncryptor.setPasswordCharArray(SECRET_KEY.toCharArray());

        return "Encrypt";
    }

    @Post("/decrypt")
    @Produces(MediaType.TEXT_PLAIN)
    public String decrypt() {
        return "Decrypt";
    }
}
