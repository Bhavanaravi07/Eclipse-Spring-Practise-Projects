package com.dxc.rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/conversion")

public class ConversionsService {
	
	@GET
	@Path("/inches2cm/{inch}")
	public String inch2cm(@PathParam("inch") double inch) {
		double cm;
		cm = inch * 2.54;
		return ""+cm;
		
	}
	
	@GET
	@Path("/cm2inches/{cm}")
	public String cm2inches(@PathParam("cm") double cm) {
		double inches;
		inches = cm / 2.54;
		return ""+inches;
		
	}

}
