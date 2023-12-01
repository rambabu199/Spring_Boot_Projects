package com.example.demo.services;

import java.util.List;
import java.util.Set;

import com.example.demo.entity.JobClass;
import com.example.demo.entity.JobSeeker;

public interface JobSeekerServices {
	
	public String addjobseeker(JobSeeker jobseeker);
	
	public List<JobSeeker>displayall();
	
	public JobSeeker displaybyid(long id);
	
	public String deletebyid(long id);
	
	public String deleteall();
	
	public String applyjob(JobClass job, long jsid);
	
	public Set<JobClass>viewappliedjobs(long jsid);
	
	public List<JobClass>searchjobsbyLocation(String location);
	public List<JobClass>searchjobsbytitle(String title);
	
	

}
