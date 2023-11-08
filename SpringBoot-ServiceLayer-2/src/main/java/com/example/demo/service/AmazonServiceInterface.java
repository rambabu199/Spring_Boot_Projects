package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Amazon;

@Service
public interface AmazonServiceInterface {

	public Amazon addProduct(Amazon amazon);
	public List<Amazon> displayAll();
	public Optional< Amazon> showByID(int id);
	public List<Amazon>showByName(String name);
	public List<Amazon>showByCatagory(String catagory);
	public List<Amazon>showByPrice(double price);
	public String deleteByID(int id);
	
	
}
