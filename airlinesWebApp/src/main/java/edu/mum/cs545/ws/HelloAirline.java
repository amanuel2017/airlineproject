package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cs545.airline.model.Airline;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
@Path("airline")
public class HelloAirline {
	
	@Inject
	private AirlineService airlineService;
	
	@Path("default") 
	@GET
	public String helloWorld(@DefaultValue("Amanuelairline") @QueryParam("name") String name) {
		System.out.println("here is a default");
		return "Hello " + name + "!";
	}

	@POST
	@Path("create")
	@Produces({MediaType.APPLICATION_JSON})
	public void create(Airline airport) {
		System.out.print("creat is successfull");
		airlineService.create(airport);
	}
	@DELETE
	@Path("delete")
	@Produces({MediaType.APPLICATION_JSON})
	public void delete(Airline airport) {
		airlineService.delete(airport);
	}
	@PUT
	@Path("update")
	@Produces({MediaType.APPLICATION_JSON})
	public Airline update(Airline airport) {
		return airlineService.update(airport);
	}
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

