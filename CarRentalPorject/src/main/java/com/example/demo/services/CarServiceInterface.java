package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Car;

public interface CarServiceInterface {
	
	public Car addcar(Car car);
	
	public List<Car>displayAll();
	
	public Car displayByID(int id);
	
	public String updateCar(Car car,int id);
	
	public String deletecarByID(int id);
	
	public String deleteallCARS();
	
	public List<Car>displayCarByName(String name);
	
	public List<Car>displayCarByBrand(String brand);
	
	public List<Car>displayCarByregNum(String reg_num);
	

}
