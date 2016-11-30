package bg.elsys.ip.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/cars")
@Api(value = "Api for querying cars")
public class CarResource {
	@GET
	@ApiOperation(value = "get  all or filtered cars", response=Car.class, responseContainer = "List")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCars(@QueryParam("brandFilter")String brandFilter, 
			@QueryParam("modelFilter")String modelFilter,
			@QueryParam("yearFilter")Integer yearFilter,
			@QueryParam("priceFilter")Integer priceFilter,
			@QueryParam("hpFilter")Integer hpFilter){
		List<Car> cars = CarData.getCars();
		if(brandFilter != null && !(brandFilter.equals(""))){
			cars = CarData.filterBrand(cars, brandFilter);
		}
		if(modelFilter != null && !(modelFilter.equals(""))){
			cars = CarData.filterModel(cars, modelFilter);
			
		}
		if(yearFilter != null ){
			cars = CarData.filterYear(cars, yearFilter);
		}
		if(priceFilter != null ){
			cars = CarData.filterPrice(cars, priceFilter);
		}
		if(hpFilter != null ){
			cars = CarData.filterHp(cars, hpFilter);
		}
		
		return Response.ok(cars).build();
	}
	@POST
	@ApiOperation(value = "add new car", response=Integer.class)
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCar(Car newCar){
		CarData.addCar(newCar);
		return Response.ok(newCar.getId()).status(Status.CREATED).build();
	}
	
	@Path("/autocomplete")
	@GET
	@ApiOperation(value = "autocomplete", response=String.class, responseContainer = "List")
	@Produces(MediaType.APPLICATION_JSON)
	public Response autocomplete(){
		List<String> brands = CarData.brandList();
		return Response.ok(brands).build();
	}
	
}
