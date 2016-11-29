package bg.elsys.ip.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/cars")
public class CarResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCars(@QueryParam("brandFilter")String brandFilter, @QueryParam("modelFilter")String modelFilter){
		List<Car> cars = CarData.getCars();
		if(brandFilter != null && !(brandFilter.equals(""))){
			cars = CarData.filterBrand(cars, brandFilter);
		}
		if(modelFilter != null && !(modelFilter.equals(""))){
			cars = CarData.filterModel(cars, modelFilter);
		}
		
		return Response.ok(cars).build();
	}
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCar(Car newCar){
		CarData.addCar(newCar);
		return Response.ok(newCar.getId()).status(Status.CREATED).build();
	}
	
	@Path("/autocomplete")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response autocomplete(){
		List<String> brands = CarData.brandList();
		return Response.ok(brands).build();
	}
	
}
