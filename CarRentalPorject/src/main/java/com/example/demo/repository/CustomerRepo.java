package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	
	public List<Customer> findbyName(String name);
	
	public Customer findbyCus_Mobile(String mobile);
	
	

}
