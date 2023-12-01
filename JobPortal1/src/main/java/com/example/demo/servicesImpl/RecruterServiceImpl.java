package com.example.demo.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.JobSeeker;
import com.example.demo.entity.Recruter;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.JobSeekerRepository;
import com.example.demo.repository.RecruterRepository;
import com.example.demo.services.RecruterServiceInterface;

@Service
public class RecruterServiceImpl implements RecruterServiceInterface{
	@Autowired
	private RecruterRepository recrepo;
	
	@Autowired
	private JobSeekerRepository jsrepo;
	
	
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
	public List<JobSeeker> viewapplicants(long rid,long job_id,long jsid) {
		// TODO Auto-generated method stub
		return jsrepo.findApplicants(rid, job_id, jsid);
	}

}
