package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.JobClass;
import com.example.demo.entity.Recruter;



public interface RecruterServiceInterface {
	
	public String upsert(Recruter recruter);
	
	public Recruter displayBYID(long id);
	
	public Recruter displayByName(String name);
	
	public List<Recruter>displayAll();
	
	public String deleteBYID(long id);
	
	public String deleteAll();
	
	public String addjobpost(JobClass job);
	
public String updateJob(JobClass job,long id);
	
	public JobClass displayjobBYID(long id);
	
	//public JobClass displayByName(String name);
	
	public List<JobClass>displayAlljobs();
	
	public String removebyid(long id);
	
	public String removeall();
	

}
