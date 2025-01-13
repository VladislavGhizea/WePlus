package com.weplus.app.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hello")

public class hello {

    @GET

    public String sayHello() {

        return "Hello World";

    }

}