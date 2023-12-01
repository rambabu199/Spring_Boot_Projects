package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.JobClass;

public interface ApplyJobServices {

	public String applyjob(long job_id,long jsid);
	public List<JobClass>viewappliedjobs(long jsid,long job_id);
}
