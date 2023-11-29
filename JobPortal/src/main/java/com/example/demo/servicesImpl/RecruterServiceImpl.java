package com.example.demo.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.JobClass;
import com.example.demo.entity.JobSeeker;
import com.example.demo.entity.Recruter;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.JobClassRepository;
import com.example.demo.repository.JobSeekerRepository;
import com.example.demo.repository.RecruterRepository;
import com.example.demo.services.RecruterServiceInterface;

@Service
public class RecruterServiceImpl implements RecruterServiceInterface{
	@Autowired
	private RecruterRepository recrepo;
	
	@Autowired
	private JobSeekerRepository jsrepo;
	
	@Autowired
	private JobClassRepository jobrepo;

	@Override
	public String upsert(Recruter recruter) {
		long id=recruter.getRid();
		if(recrepo.existsById(id))
		{
			recrepo.save(recruter);
			return "record updated successfully";
		}
		else
		{
			recrepo.save(recruter);
		return "record inserted successfully";
		}
		
	}

	@Override
	public Recruter displayBYID(long id) {
		if(recrepo.existsById(id))
		{
			return recrepo.findById(id).get();
		}
		else
		{
			
		throw new ResourceNotFoundException("resource not found", "recruter", id);
		}
	}

	@Override
	public List<Recruter> displayAll() {
		return recrepo.findAll();
	}

	@Override
	public String deleteBYID(long id) {
		if(recrepo.existsById(id))
		{
			recrepo.deleteById(id);;
			return "record deleted successfully";
		}
		else
		{
			throw new ResourceNotFoundException("no records found", "recruter", id);
		}
	}

	@Override
	public String deleteAll() {
		recrepo.deleteAll();
		return "All recruter records deleted successfully";
	
	}

	@Override
	public Recruter displayByName(String name) {
		Recruter rec=recrepo.findByName(name);
		return rec;
	}

	@Override
	public String addjobpost(JobClass job) {
		jobrepo.save(job);
		return "job posted successfully";
	}

	@Override
	public String updateJob(JobClass job,long id) {
		if(jobrepo.existsById(id))
		{
			JobClass existedjob=jobrepo.findById(id).get();
			existedjob.setJob_title(job.getJob_title());
			existedjob.setJob_desc(job.getJob_desc());
			existedjob.setLocation(job.getLocation());
			existedjob.setReq_exp(job.getReq_exp());
			existedjob.setReq_keyskills(job.getReq_keyskills());
			existedjob.setReq_qualification(job.getReq_qualification());
			existedjob.setSalary_package(job.getSalary_package());
			jobrepo.save(existedjob);
			return "job updated successfully";
		}
		else {
		throw new ResourceNotFoundException("not found", "id", id);
		}
		
	}

	@Override
	public JobClass displayjobBYID(long id) {
		if(jobrepo.existsById(id))
		{
			return jobrepo.findById(id).get();
		}
		else {
			throw new ResourceNotFoundException("not found", "id", id);
	}}

	@Override
	public List<JobClass> displayAlljobs() {
		
		return jobrepo.findAll();
	}

	@Override
	public String removebyid(long id) {
		if(jobrepo.existsById(id))
		{
			jobrepo.deleteById(id);
			return"record deleted successfully";
		}
		else {
			throw new ResourceNotFoundException("not found", "id", id);
	}
	}

	@Override
	public String removeall() {
	
		jobrepo.deleteAll();
		return "all records deleted successfully";
	}

	@Override
	public List<JobSeeker> viewapplicants(long rid,long job_id,long jsid) {
		// TODO Auto-generated method stub
		return jsrepo.findApplicants(rid, job_id, jsid);
	}

}
