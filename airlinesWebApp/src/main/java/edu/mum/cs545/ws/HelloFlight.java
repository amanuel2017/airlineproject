package edu.mum.cs545.ws;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
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
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.FlightService;

@Path("flight")
public class HelloFlight {

	@Inject
	private FlightService flightService;

	@Path("default")
	@GET
	public String helloWorld(@DefaultValue("Amanuel") @QueryParam("name") String name) {
		System.out.println("here is a default");
		return "Hello " + name + "!";
	}

	@POST
	@Path("create")
	@Produces({ MediaType.APPLICATION_JSON })
	public void create(Flight flight) {
		flightService.create(flight);
	}

	@DELETE
	@Path("delete")
	@Produces({ MediaType.APPLICATION_JSON })
	public void delete(Flight flight) {
		flightService.delete(flight);
	}

	@PUT
	@Path("update")
	@Produces({ MediaType.APPLICATION_JSON })
	public Flight update(Flight flight) {
		return flightService.update(flight);
	}

	@GET
	@Path("find")
	@Produces({ MediaType.APPLICATION_JSON })
	public Flight find(Flight flight) {
		return flightService.find(flight);
	}
	@GET
	@Path("findbynumber")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Flight> findByNumber(String flightnr) {
		return flightService.findByNumber(flightnr);
	}

	@GET
	@Path("findbyairline")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Flight> findByAirline(Airline airline) {
		return flightService.findByAirline(airline);
	}
	@GET
	@Path("findbyorigin")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Flight> findByOrigin(Airport airport) {
		return flightService.findByOrigin(airport);
	}
	@GET
	@Path("findbydestination")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Flight> findByDestination(Airport airport) {
		return flightService.findByDestination(airport);
	}
	@GET
	@Path("findbyarrivalairline")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Flight> findByArrival(Airline airline) {
		return flightService.findByAirline(airline);
	}
	
	@GET
	@Path("findbyarrivaldate")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Flight> findByArrival(Date datetime) {
		return flightService.findByArrival(datetime);
	}
	@GET
	@Path("findbyarrivalbetween")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Flight> findByArrivalBetween(Date datetimeFrom, Date datetimeTo) {
		return flightService.findByArrivalBetween(datetimeFrom, datetimeTo);
	}
	
	@GET
	@Path("findbydeparture")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Flight> findByDeparture(Date datetime) {
		return flightService.findByDeparture(datetime);
	}
	
	@GET
	@Path("findbydeparturebetween")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Flight> findByDepartureBetween(Date datetimeFrom, Date datetimeTo) {
		return flightService.findByDepartureBetween(datetimeFrom, datetimeTo);
	}
	
	@GET
	@Path("findall")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Flight> findAll() {
		return flightService.findAll();
	}
}


