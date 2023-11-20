package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Driver;

public interface DriverServiceInterface {
	
	public String addDriver(Driver driver);
	
	public String updateDriverDetails(int id,Driver driver);
	
	public String deleteDriverByID(int id);
	
	public String deleteAllDrivers();
	
	public Driver displayDriverByID(int id);
	
	public List<Driver>displayAllDrivers();

}
