package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.services.CustomerServicesInterface;

public class CustomerServicesImpl implements CustomerServicesInterface{
	
	@Autowired
	private CustomerRepo custrepo;

	@Override
	public String addcustomer(Customer customer) {
		
		Customer c= custrepo.save(customer);
		if(c!=null)
		{
			return "customer details added successfully";
		}
		else
		return "failed";
	}

	@Override
	public String updateCustomerDetails(Customer customer, int id) {
		if(custrepo.existsById(id))
		{
			Customer excust=custrepo.findById(id).get();
			excust.setCus_mobile(customer.getCus_mobile());
			excust.setLicenceNum(customer.getLicenceNum());
			excust.setName(customer.getName());
			custrepo.save(excust);
			return" customer details with id:"+id+" updated successfully";
		}
		else		
		return "no records found with customer id:"+id;
	}

	@Override
	public String deleteCustomerByID(int id) {
		if(custrepo.existsById(id))
		{
			custrepo.deleteById(id);
			return "customer record with id:"+id+" is deleted successfully";
		}
		else
		return "no records found with customer id:"+id;
	}

	@Override
	public String deleteAllCustomers() {
		custrepo.deleteAll();
		return "all records deleted successfully";
	}

	@Override
	public Customer displayCustomerByID(int id) {
		if(custrepo.existsById(id))
		{
			Customer c= custrepo.findById(id).get();
			return c;
		}
		else
		return null;
	}

	@Override
	public List<Customer> displayAllCustomers() {
		// TODO Auto-generated method stub
		return custrepo.findAll();
	}

	@Override
	public List<Customer> displayCustomerByName(String name) {
		// TODO Auto-generated method stub
		return custrepo.findbyName(name);
	}

	@Override
	public Customer dispalyCustomerByMobileNumber(String mobilenumber) {
		// TODO Auto-generated method stub
		return custrepo.findbyCus_Mobile(mobilenumber);
	}

}
