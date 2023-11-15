package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Recruter;



public interface RecruterServiceInterface {
	
	public String upsert(Recruter recruter);
	
	public Recruter displayBYID(long id);
	
	public Recruter displayByName(String name);
	
	public List<Recruter>displayAll();
	
	public String deleteBYID(long id);
	
	public String deleteAll();
	

}
