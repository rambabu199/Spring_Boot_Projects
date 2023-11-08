package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Amazon;
import com.example.demo.service.AmazonServiceInterface;

@RestController
public class AmazonController {

	@Autowired
	private AmazonServiceInterface asi;
	@PostMapping("/adddata")
	public Amazon adddata(@RequestBody Amazon amazon)
	{
		return asi.addProduct(amazon);
		
	}
	@GetMapping("/showall")
	public List<Amazon>displayAlldata()
	{
		return asi.displayAll();
	}
	@GetMapping("/displayByID/{id}")
	public Optional<Amazon>displayByID(@PathVariable int id)
	{
		return asi.showByID(id);
	}
	@GetMapping("/displaybyname/{name}")
	public List<Amazon>displaybyName(@PathVariable String name)
	{
		return asi.showByName(name);
	}
	@GetMapping("/Bycatagory/{catagory}")
	public List<Amazon>showByCatagory(@PathVariable String catagory)
	{
		return asi.showByCatagory(catagory);
	}
	@GetMapping("/byprice/{price}")
	public List<Amazon>showbyprice(@PathVariable double price)
	{
		return asi.showByPrice(price);
	}
	
	
	
	
	
}
