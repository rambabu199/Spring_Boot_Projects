package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.JobSeeker;

public interface JobSeekerServices {
	
	public String addjobseeker(JobSeeker jobseeker);
	
	public List<JobSeeker>displayall();
	
	public JobSeeker displaybyid(long id);
	
	public String deletebyid(long id);
	
	public String deleteall();
	

}
