package com.dxc.rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/hello")

public class HelloWorldServices {
	
	@GET
	@Path("/{param}")
	public String sayHello(@PathParam("param")String name) {
		String hello = "Hello World!!! by "+name;
		System.out.println("Request received from "+name);
		return hello;
	}

}
