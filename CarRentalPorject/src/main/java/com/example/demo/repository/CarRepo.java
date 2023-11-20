package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Car;

public interface CarRepo extends JpaRepository<Car, Integer>{

	
	public List<Car> findByCar_name(String name);
	
	public List<Car>findByBrand(String brand);
	
	public List<Car> findByRegistrationNum(String registrationNum);
	
	
}
