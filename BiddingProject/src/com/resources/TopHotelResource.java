package com.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/topHotel")
public class TopHotelResource {

	@GET
	@Path("/get")
	public String getPages() {
		//write jdbc connection to fetch data all available pages and return as a string
		return null;
	}
}
