package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cs545.airline.model.Airline;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
@Path("airline")
public class AirlineWsSerive {
	
	@Inject
	private AirlineService airlineService;


	@Path("default") 
	@GET
	public String helloWorld(@DefaultValue("Amanuelairline") @QueryParam("name") String name) {
		System.out.println("here is a default");
		return "Hello " + name + "!";
	}

	
	@Path("create")
	@Consumes({MediaType.APPLICATION_JSON})
	@POST
	public String create(Airline airport) {
		
		airlineService.create(airport);
		return airport.getName() + " successful " + airport.getId();
	}
	@DELETE
	@Path("delete")
	@Produces({MediaType.APPLICATION_JSON})
	public String delete(String name) {
		
		try{
		Airline airline = airlineService.findByName(name);		
		airlineService.delete(airline);
		System.out.println("delete is successful");
	   }
		catch(Exception e){
			  System.out.println("delete failed");
				e.printStackTrace();
				}
			return "airline";
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Airline update(Airline airline) {
		return airlineService.update(airline);
	}
	
	/*
	@Path("update")
	@Produces({MediaType.APPLICATION_JSON})
	public Response update(Airline airline) {
		try {
			airlineService.update(airline);
			return Response.ok(airline).build();
		} catch (Exception e) {
			return Response.serverError().entity("problem with update airline.").build();
		}
	}*/
	@GET
	@Path("find")
	@Produces({MediaType.APPLICATION_JSON})
	public Airline find(Airline airport) {
		return airlineService.find(airport);
	}
	@GET
	@Path("findbyname")
	@Produces({MediaType.APPLICATION_JSON})
	public Airline findByName( @QueryParam ("findbyname")String name) {
		return airlineService.findByName(name);
	}
	@POST
	@Path("findbyflight")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Airline> findByFlight(Flight flight) {
		return airlineService.findByFlight(flight);
	}
	@GET
	@Path("findall")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Airline> findAll() {
		return airlineService.findAll();
	}
}

