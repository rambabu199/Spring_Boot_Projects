package com.example.demo.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.JobSeeker;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.JobSeekerRepository;
import com.example.demo.services.JobSeekerServices;
@Service
public class JobSeekerServiceImpl implements JobSeekerServices{
	
	@Autowired
	private JobSeekerRepository jsrepo;

	@Override
	public String addjobseeker(JobSeeker jobseeker) {
		long id=jobseeker.getJsid();
		if(jsrepo.existsById(id))
		{
			jsrepo.save(jobseeker);
			return"record updated successfully";
		}
		else {
			jsrepo.save(jobseeker);
		return "record created successfully";
		}
	}

	@Override
	public List<JobSeeker> displayall() {
		return jsrepo.findAll();
	}

	@Override
	public JobSeeker displaybyid(long id) {
		if(jsrepo.existsById(id))
		{
			return jsrepo.findById(id).get();
		}
		else {
		throw new ResourceNotFoundException("record not found", "id", id);
	}

}

	@Override
	public String deletebyid(long id) {
		if(jsrepo.existsById(id))
		{
			jsrepo.deleteById(id);
			return "record deleted successfully";
		}
		else
		{
			throw new ResourceNotFoundException("notfound", "id", id);
		}
	}

	@Override
	public String deleteall() {
		if(jsrepo!=null)
		{
			jsrepo.deleteAll();
			return" all records deleted successfully";
		}
		else
		return "empty set";
	}
}
