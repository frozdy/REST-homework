package bg.elsys.ip.rest;

public class Car {
	private int id;
	private String brand;
	private String model;
	private int price;
	private int year;
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