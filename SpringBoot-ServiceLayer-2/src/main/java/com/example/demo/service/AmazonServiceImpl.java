package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Amazon;
import com.example.demo.repository.AmazonRepo;

@Service
public class AmazonServiceImpl implements AmazonServiceInterface{
	@Autowired
	private AmazonRepo amazonrepo;

	@Override
	public Amazon addProduct(Amazon amazon) {
		// TODO Auto-generated method stub
		return amazonrepo.save(amazon);
	}

	@Override
	public List<Amazon> displayAll() {
		// TODO Auto-generated method stub
		return amazonrepo.findAll();
	}

	@Override
	public Optional<Amazon> showByID(int id) {
		// TODO Auto-generated method stub
		Optional<Amazon>a=amazonrepo.findById(id);
		if(a.isPresent()) {
		return a;
		}
		else {
			System.out.println("record not found");
			return null;
		}
	}
	
	public List<Amazon>showByName(String name)
	{
		List<Amazon>a=amazonrepo.findByName(name);
		if(a.isEmpty()) {
			System.out.println("no records found");
		return null;
		}
		else
			return a;
		
	}

	@Override
	public List<Amazon> showByCatagory(String catagory) {
		List<Amazon>a=amazonrepo.findByCatagory(catagory);
		if(a.isEmpty()) {
			System.out.println("no records found");
		return null;
		}
		else
			return a;
	}

	@Override
	public List<Amazon> showByPrice(double price) {
		List<Amazon>a=amazonrepo.findByPrice(price);
		if(a.isEmpty()) {
			System.out.println("no records found");
		return null;
		}
		else
			return a;
	}
	
	
	
	

}
