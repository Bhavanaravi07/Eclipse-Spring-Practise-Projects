package com.dxc.client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class App_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		
		URI uri = UriBuilder.fromUri("http://localhost:8080/webservice_01/rest/hello/bhavana").build();
		
		WebTarget webTarget = client.target(uri);
		
		System.out.println(webTarget.request().accept(MediaType.TEXT_PLAIN).get(String.class));
		
		

	}

}
