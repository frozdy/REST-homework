package bg.elsys.ip.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarData {

	private static List<Car> cars = null;
	
	private static void initCars(){
		cars = new ArrayList<>();
		
		for (int i = 0; i < 20; i++) {
			cars.add(new Car("Mercedes", "C63", 200000, 2016, 250));
			cars.add(new Car("Mercedes", "S63", 100000, 2016, 350));
			cars.add(new Car("Mercedes", "SL63", 300000, 2016, 450));
			cars.add(new Car("Mercedes", "CLS63", 400000, 2016, 550));
			cars.add(new Car("Audi", "A8", 500000, 2016, 650));
			cars.add(new Car("BMW", "Li750", 300000, 2016, 350));
		}
		
	}
	
	public static List<Car> filterBrand(List<Car>carsList, String brandFilter){
		List<Car> finalBrandFilter = new ArrayList<>();
		for (int index = 0; index < carsList.size(); index++) {
			if(brandFilter.equals(carsList.get(index).getBrand())){
				finalBrandFilter.add(carsList.get(index));
			}
		}
		return finalBrandFilter;
	}
	
	public static List<Car> filterModel(List<Car>carsList, String modelFilter){
		List<Car> finalModelFilter = new ArrayList<>();
		for (int index = 0; index < carsList.size(); index++) {
			if(modelFilter.equals(carsList.get(index).getModel())){
				finalModelFilter.add(carsList.get(index));
			}
		}
		return finalModelFilter;
	}
	
	public static List<Car> filterPrice(List<Car>carsList, int priceFilter){
		List<Car> finalPriceFilter = new ArrayList<>();
		for (int index = 0; index < carsList.size(); index++) {
			if(priceFilter == (carsList.get(index).getPrice())){
				finalPriceFilter.add(carsList.get(index));
			}
		}
		return finalPriceFilter;
	}
	
	public static List<Car> filterYear(List<Car>carsList, int yearFilter){
		List<Car> finalYearFilter = new ArrayList<>();
		for (int index = 0; index < carsList.size(); index++) {
			if(yearFilter == (carsList.get(index).getYear())){
				finalYearFilter.add(carsList.get(index));
			}
		}
		return finalYearFilter;
	}
	
	public static List<Car> filterHp(List<Car>carsList, int hpFilter){
		List<Car> finalHpFilter = new ArrayList<>();
		for (int index = 0; index < carsList.size(); index++) {
			if(hpFilter == (carsList.get(index).getHp())){
				finalHpFilter.add(carsList.get(index));
			}
		}
		return finalHpFilter;
	}
	
	public static List<String> brandList(){
		if(cars == null){
			initCars();
		}
		List<String> brands = new ArrayList<String>();
		for (int index = 0; index < cars.size(); index++) {
			brands.add(cars.get(index).getBrand());
			
		}
		return brands.stream().distinct().collect(Collectors.toList());
	}
	
	
	public static List<Car> getCars(){
		if(cars == null){
			initCars();
		}
		return cars;
	}
	
	public static void addCar(Car newCar){
		if(cars == null){
			initCars();
		}
		cars.add(newCar);
	}
}
