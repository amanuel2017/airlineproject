package edu.mum.cs545.ws;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.AirplaneService;
import cs545.airline.service.FlightService;

@Named
@Path("hello")
public class HelloRest {

	@Inject
	private AirlineService airlineService;
	
	@Path("default") 
	@GET
	public String helloWorld(@DefaultValue("Amanuel") @QueryParam("name") String name) {
		System.out.println("here is a default");
		return "Hello " + name + "!";
	}

	@Path("create")
	@POST
	public void getCreateAirline(Airline airport) {
		airlineService.create(airport);
	}

	@Path("delite")
	@GET
	public void getDeleteAirline(Airline airport) {
		airlineService.delete(airport);
	}

	@Path("update")
	@PUT
	public Airline getUpdateAirline(Airline airport) {
		Airline airline = new Airline();
		airline = airlineService.update(airport);
		return airline;
	}

	@Path("find")
	@GET
	public Airline getFindAirline(Airline airport) {
		Airline airline = new Airline();
		airline = airlineService.find(airport);
		return airline;
	}

	@Path("findbyname")
	@GET
	public String getAirlineTest() {
		String result = "Nil!";
		Airline airline = airlineService.findByName("oneworld");
		if (airline != null) {
			result = "This is an airline: " + airline.getName();

		}
		return result;
	}

	@Path("findbyflight")
	@GET
	public List<Airline> getfindByFlight(Flight flight) {

		return airlineService.findByFlight(flight);
	}

	@Path("findall")
	@GET
	@Produces
	public List<Airline> getAllAirline() {
		List<Airline> airline = new ArrayList<Airline>();
		airline = airlineService.findAll();
		return airline;
	}
	
//	@POST
//	@Path("/new")
//	@Produces({MediaType.APPLICATION_JSON})
//	public void create(Airline airport) {
//		airlineService.create(airport);
//	}
//	@DELETE
//	@Path("/delete")
//	@Produces({MediaType.APPLICATION_JSON})
//	public void delete(Airline airport) {
//		airlineService.delete(airport);
//	}
//	@PUT
//	@Path("/update")
//	@Produces({MediaType.APPLICATION_JSON})
//	public Airline update(Airline airport) {
//		return airlineService.update(airport);
//	}
//	@GET
//	@Path("/find")
//	@Produces({MediaType.APPLICATION_JSON})
//	public Airline find(Airline airport) {
//		return airlineService.find(airport);
//	}
//	@GET
//	@Path("/findbyname")
//	@Produces({MediaType.APPLICATION_JSON})
//	public Airline findByName(String name) {
//		return airlineService.findByName(name);
//	}
//	@GET
//	@Path("/findbyflight")
//	@Produces({MediaType.APPLICATION_JSON})
//	public List<Airline> findByFlight(Flight flight) {
//		return airlineService.findByFlight(flight);
//	}
//	@GET
//	@Path("/findall")
//	@Produces({MediaType.APPLICATION_JSON})
//	public List<Airline> findAll() {
//		return airlineService.findAll();
//	}
}
