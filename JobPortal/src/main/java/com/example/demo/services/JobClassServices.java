package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.JobClass;
@Service
public interface JobClassServices {

	public String addjob(JobClass job);
	public String updateJob(JobClass job);
	
	public JobClass displayBYID(long id);
	
	//public JobClass displayByName(String name);
	
	public List<JobClass>displayAll();
	
	public String removebyid(long id);
	
	public String removeall();
}
