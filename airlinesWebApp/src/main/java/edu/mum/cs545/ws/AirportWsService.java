package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
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

//import com.sun.mail.iap.Response;

import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirportService;

@Path("airport")
public class AirportWsService {

	@Inject
	private AirportService airportservice;
	List<Airport> airports;

	public List<Airport> getAirports() {
		return airports;
	}

	public void setAirports(List<Airport> airports) {
		this.airports = airports;
	}

	@Path("default")
	@GET
	public String helloWorld(@DefaultValue("Amanuel") @QueryParam("name") String name) {
		System.out.println("here is a default");
		return "Hello " + name + "!";
	}

	@Path("create")
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public void create(Airport airport) {
		airportservice.create(airport);
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@DELETE
	public void delete(Airport airport) {
		airportservice.delete(airport);
	}

	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public Airport update(Airport airport) {
		return airportservice.update(airport);
	}

	@Path("find")
	@Consumes(MediaType.APPLICATION_JSON)
	@GET
	public Airport find(Airport airport) {
		return airportservice.find(airport);
	}

	@Path("findByCode")
	@Consumes(MediaType.APPLICATION_JSON)
	@GET
	public Airport findByCode(String airportcode) {
		return airportservice.findByCode(airportcode);
	}

	@Path("findByArrival")
	@Consumes(MediaType.APPLICATION_JSON)
	@GET
	public List<Airport> findByArrival(Flight flight) {
		return airportservice.findByArrival(flight);
	}

	@Path("findByDepartment")
	@Consumes(MediaType.APPLICATION_JSON)
	@GET
	public List<Airport> findByDeparture(Flight flight) {
		return airportservice.findByDeparture(flight);
	}

	@Path("findByCity")
	@Consumes(MediaType.APPLICATION_JSON)
	@GET
	public List<Airport> findByCity(String city) {
		return airportservice.findByCity(city);
	}

	@Path("findByCountry")
	@Consumes(MediaType.APPLICATION_JSON)
	@GET
	public List<Airport> findByCountry(String country) {
		return airportservice.findByCountry(country);
	}

	@Path("findByName")
	@Consumes(MediaType.APPLICATION_JSON)
	@GET
	public List<Airport> findByName(String name) {
		return airportservice.findByName(name);
	}

	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public String findAll() {
		airports = airportservice.findAll();
		return "airport";
	}
}
