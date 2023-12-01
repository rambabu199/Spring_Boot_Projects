package com.example.demo.servicesImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.JobClass;
import com.example.demo.entity.JobSeeker;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.JobClassRepository;
import com.example.demo.repository.JobSeekerRepository;
import com.example.demo.services.JobSeekerServices;
@Service
public class JobSeekerServiceImpl implements JobSeekerServices{
	
	@Autowired
	private JobSeekerRepository jsrepo;
	
	@Autowired
	private JobClassRepository jobrepo;

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

	@Override
	public String applyjob(JobClass job ,long jsid) {
		
		if(jsrepo.existsById(jsid))
		{
			JobSeeker exjs=jsrepo.findById(jsid).get();
			exjs.getJobClasses().add(job);
			return "job appiled successfully";
		}
	
		else 
		return "job seeker not found";
	}

	@Override
	public Set<JobClass> viewappliedjobs(long jsid) {
		if(jsrepo.existsById(jsid))
		{
			JobSeeker exjs=jsrepo.findById(jsid).get();
			Set<JobClass>appliedjobs=exjs.getJobClasses();
			return appliedjobs;
		}
		else
		
		return null;
	}

	@Override
	public List<JobClass> searchjobsbyLocation(String location) {
		return jobrepo.findbyLocation(location);
	}

	@Override
	public List<JobClass> searchjobsbytitle(String title) {
		// TODO Auto-generated method stub
		return jobrepo.findbyTitle(title);
	}
	
	
}
