package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Customer;

public interface CustomerServicesInterface {
	
	public String addcustomer(Customer customer);
	
	public String updateCustomerDetails(Customer customer,int id);
	
	public String deleteCustomerByID(int id);
	
	public String deleteAllCustomers();
	
	public Customer displayCustomerByID(int id);
	
	public List<Customer>displayAllCustomers();
	
	public List<Customer>displayCustomerByName(String name);
	
	public Customer dispalyCustomerByMobileNumber(String mobilenumber);

}
