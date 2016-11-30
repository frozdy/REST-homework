package bg.elsys.ip.rest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Car {
	@ApiModelProperty(value="this is the number of the car in the list", example="1")
	private int id;
	@ApiModelProperty(value="this is the brand of the car", example="Mercedes")
	private String brand;
	@ApiModelProperty(value="this is the model of the car", example="S63")
	private String model;
	@ApiModelProperty(value="this is the price of the car", example="13000")
	private int price;
	@ApiModelProperty(value="this is the year of the car", example="2013")
	private int year;
	@ApiModelProperty(value="this is the horsepowers of the car", example="420")
	private int hp;
	private static int counter = 1;
	
	public Car() {
		id = counter;
		counter++;
	}
	
	public Car(String brand, String model, int price, int year, int hp) {
		this();
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.year = year;
		this.hp = hp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	
	
}