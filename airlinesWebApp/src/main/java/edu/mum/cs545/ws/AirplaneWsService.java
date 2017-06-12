package edu.mum.cs545.ws;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cs545.airline.model.Airplane;
import cs545.airline.model.Flight;
import cs545.airline.service.AirplaneService;

@Path("airplane")
public class AirplaneWsService {

	@Inject
	private AirplaneService airplaneService;

	@Path("default")
	@GET
	public String helloWorld(@DefaultValue("Amanuel") @QueryParam("name") String name) {
		System.out.println("here is a default");
		return "Hello " + name + "!";
	}

	@Path("create")
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public void  createAirplane(Airplane airline) {
		airplaneService.create(airline);
	}
	 

	@DELETE
	@Path("delete")
	@Produces({ MediaType.APPLICATION_JSON })
	public void delete(Airplane airplane) {
		airplaneService.delete(airplane);
	}


	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("update")
	public Response update(Airplane airplane) {
		try {
			airplaneService.update(airplane);
			return Response.ok(airplane).build();
		} catch (Exception e) {
			return Response.serverError().entity("Cannot update airplane.").build();
		}
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
	@Path("find/{name}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Airplane> findByFlight(@PathParam("name")String model) {
		return airplaneService.findByModel(model);
	}

	@GET
	@Path("findall")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Airplane> findAll() {
		List<Airplane> result = new ArrayList<>();
		if (airplaneService.findAll() != null) {
			result = airplaneService.findAll();
		}
		return result;
	}
}
