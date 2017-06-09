package edu.mum.cs545.ws;

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

import cs545.airline.model.Airplane;
import cs545.airline.model.Flight;
import cs545.airline.service.AirplaneService;

@Path("airplane")
public class HelloAirplane {

	@Inject
	private AirplaneService airplaneService;

	@Path("default")
	@GET
	public String helloWorld(@DefaultValue("Amanuel") @QueryParam("name") String name) {
		System.out.println("here is a default");
		return "Hello " + name + "!";
	}

	@POST
	@Path("create")
	@Produces({ MediaType.APPLICATION_JSON })
	public void create(Airplane airplane) {
		airplaneService.create(airplane);
	}

	@DELETE
	@Path("delete")
	@Produces({ MediaType.APPLICATION_JSON })
	public void delete(Airplane airplane) {
		airplaneService.delete(airplane);
	}

	@PUT
	@Path("update")
	@Produces({ MediaType.APPLICATION_JSON })
	public Airplane update(Airplane airplane) {
		return airplaneService.update(airplane);
	}

	@GET
	@Path("find")
	@Produces({ MediaType.APPLICATION_JSON })
	public Airplane find(Airplane airplane) {
		return airplaneService.find(airplane);
	}

	@GET
	@Path("findbyname")
	@Produces({ MediaType.APPLICATION_JSON })
	public Airplane findByName(String serialno) {
		return airplaneService.findBySrlnr(serialno);
	}

	@GET
	@Path("findbyflight")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Airplane> findByFlight(Flight flight) {
		return airplaneService.findByFlight(flight);
	}

	@GET
	@Path("findall")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Airplane> findAll() {
		return airplaneService.findAll();
	}
}
