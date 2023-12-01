package com.example.demo.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.JobClass;
import com.example.demo.entity.JobSeeker;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.services.JobSeekerServices;

@RestController
@RequestMapping("/jobseeker")
public class JobSeekerController {
	@Autowired
	private JobSeekerServices jsservices;
	@PostMapping("/addjobseeker")
	public ResponseEntity<String>addjobseeker(@RequestBody JobSeeker jobseeker)
	{
		String js=jsservices.addjobseeker(jobseeker);
		return new ResponseEntity<>(js,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<String>updatejobseeker(JobSeeker job)
	{
		String js=jsservices.addjobseeker(job);
		return new ResponseEntity<String>(js,HttpStatus.CREATED);
	}
	
	@GetMapping("/displayall")
	public ResponseEntity<List<JobSeeker>>retriveall()
	{
		List<JobSeeker>jobs=jsservices.displayall();
		return new ResponseEntity<List<JobSeeker>>(jobs,HttpStatus.OK);
	}
	
	@GetMapping("/displayByid/{id}")
	public ResponseEntity<JobSeeker>retrivebyid(@PathVariable long id)
	{
		try {
		JobSeeker js=jsservices.displaybyid(id);
		return new ResponseEntity<JobSeeker>(js,HttpStatus.OK);
		}
		catch(ResourceNotFoundException e)
		{
			System.out.println("exception:"+e.getMessage());
			return new ResponseEntity<JobSeeker>(HttpStatus.NOT_FOUND);
			
		}
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<String>removebyid(@PathVariable long id)
	{
		try {
		String str=jsservices.deletebyid(id);
		return new ResponseEntity<String>(str,HttpStatus.OK);
		
		}
		catch(ResourceNotFoundException e)
		{
			System.out.println("Exception:"+e.getMessage());
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/removeall")
	public ResponseEntity<String>removeall()
	{
		String str=jsservices.deleteall();
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/searchjobsbylocation/{location}")
	public ResponseEntity<List<JobClass>>searchbylocation(@RequestBody String location)
	{
		List<JobClass>jobs=jsservices.searchjobsbyLocation(location);
		return new ResponseEntity<List<JobClass>>(jobs,HttpStatus.OK);
	}
	
	

}
