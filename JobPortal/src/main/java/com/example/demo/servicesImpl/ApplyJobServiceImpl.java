package com.example.demo.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.ApplyJob;
import com.example.demo.entity.JobClass;
import com.example.demo.repository.ApplyJobRepository;
import com.example.demo.repository.JobClassRepository;
import com.example.demo.repository.JobSeekerRepository;
import com.example.demo.services.ApplyJobServices;

public class ApplyJobServiceImpl implements ApplyJobServices{
	@Autowired
	private ApplyJobRepository applyrepo;
	@Autowired
	private JobSeekerRepository jobseeker;
	@Autowired
	private JobClassRepository jobrepo;

	@Override
	public String applyjob(long job_id, long jsid) {
		if(applyrepo.existsById(job_id)&&jobseeker.existsById(jsid))
		{
			ApplyJob apply=new ApplyJob();
			apply.setJob_id(job_id);
			apply.setJsid(jsid);
			applyrepo.save(apply);
			return "job applies successfully";
		}
		return "failed to apply";
	}

	@Override
	public List<JobClass> viewappliedjobs(long jsid, long job_id) {
		// TODO Auto-generated method stub
		
		return jobrepo.appliedjobs(job_id, jsid);
	}

}
