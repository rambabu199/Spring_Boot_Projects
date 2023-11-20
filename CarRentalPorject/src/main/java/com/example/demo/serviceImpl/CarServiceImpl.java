package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepo;
import com.example.demo.services.CarServiceInterface;
@Service
public class CarServiceImpl implements CarServiceInterface{
	@Autowired
	private  CarRepo carrepo;
	
	public CarServiceImpl(CarRepo carrepo)
	{
		this.carrepo=carrepo;
	}
	

	@Override
	public Car addcar(Car car) {
		Car c=carrepo.save(car);
		if(c!=null)
		{
			return c;		}
		else
		return null;
	}


	@Override
	public List<Car> displayAll() {
		
		return carrepo.findAll();
	}


	@Override
	public Car displayByID(int id) {
		if(carrepo.existsById(id))
		{
			return carrepo.findById(id).get();
		}
		else
		return null;
	}


	@Override
	public String updateCar(Car car, int id) {
		if(carrepo.existsById(id))
		{
			Car excar=carrepo.findById(id).get();
			excar.setBrand(car.getBrand());
			excar.setCar_name(car.getCar_name());
			excar.setRegistrationNum(car.getRegistrationNum());
			excar.setRental_price(car.getRental_price());
			carrepo.save(excar);
			return "car details with "+id+" updated successflly";
		}
		else {
			return "car details not found";
		}
	}


	@Override
	public String deletecarByID(int id) {
		if(carrepo.existsById(id))
		{
			carrepo.deleteById(id);
			return" record deleted successfully";
		}
		else
		return "no records found";
	}


	@Override
	public String deleteallCARS() {
		carrepo.deleteAll();
		return "deleted all records successfully";
	}


	@Override
	public List<Car> displayCarByName(String name) {
		List<Car>cars=carrepo.findByCar_name(name);
		if(cars.isEmpty()) {
		return null;
		}
		else
		return cars;
	}


	@Override
	public List<Car> displayCarByBrand(String brand) {
		List<Car>cars=carrepo.findByBrand(brand);
		if(cars.isEmpty()) {
		return null;
		}
		else
		return cars;
	}


	@Override
	public List<Car> displayCarByregNum(String reg_num) {

		List<Car> c= carrepo.findByRegistrationNum(reg_num);
		if(c.isEmpty())
		{
			return null;
		}
		else
		return c;
	}

}
