package com.example.demo.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.JobClass;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.JobClassRepository;
import com.example.demo.services.JobClassServices;
@Service
public class JobClassServicesImpl implements JobClassServices{
	@Autowired
	private JobClassRepository jobrepo;

	@Override
	public String addjob(JobClass job) {
		
		jobrepo.save(job);
		return "job inserted successfully";
	}

	@Override
	public String updateJob(JobClass job) {

		long id=job.getJob_id();
		if(jobrepo.existsById(id))
		{
			jobrepo.save(job);
			return "job updated successfully";
		}
		else {
			jobrepo.save(job);
		return "job inserted successfully";
		}
	}

	@Override
	public JobClass displayBYID(long id) {
		if(jobrepo.existsById(id))
		{
			return jobrepo.findById(id).get();
		}
		else
		{
			throw new ResourceNotFoundException("job", "not found", id);
		}
	}

	@Override
	public List<JobClass> displayAll() {
		return jobrepo.findAll();
	}

	@Override
	public String removebyid(long id) {
		if(jobrepo.existsById(id))
		{
			jobrepo.deleteById(id);
			return "record deleted successfully";
		}
		else
		{
			throw new ResourceNotFoundException("no record found", "id", id);
		}
	}

	@Override
	public String removeall() {
		if(jobrepo!=null) {
		jobrepo.deleteAll();
		return "all records deleted successfully";
		}
		else
		{
			return"no records in repository";
		}
	}

	//@Override
	/*public JobClass displayByName(String name) {
		
		return jobrepo.findByJob_title(name);
	}*/

}
