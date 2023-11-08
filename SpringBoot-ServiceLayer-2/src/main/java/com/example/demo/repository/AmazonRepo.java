package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Amazon;

public interface AmazonRepo extends JpaRepository<Amazon, Integer> {
	
	//@Query("select * from amazon_boot where name=?")
	public List<Amazon>findByName(String name);
	public List<Amazon>findByCatagory(String catagory);
	public List<Amazon>findByPrice(double price);
	public String deleteByName(String name);
	

}
