package com.example.demo.controller;

import java.util.List;

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
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.services.JobClassServices;

@RestController
@RequestMapping("/jobclass")
public class JobClassController {
	@Autowired
	private JobClassServices jobservice;
	
	@PostMapping("/addjob")
	public ResponseEntity<String>addpost(@RequestBody JobClass job)
	{
		String str=jobservice.addjob(job);
		return new ResponseEntity<String>(str,HttpStatus.CREATED);
	}
	@PutMapping("/updatejob")
	public ResponseEntity<String>updatepost(@RequestBody JobClass job) {
		String str=jobservice.updateJob(job);
		return new ResponseEntity<String>(str,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/displaybyid/{id}")
	public ResponseEntity<JobClass>retrivebyID(@PathVariable  long id)
	{
		try {
		JobClass job=jobservice.displayBYID(id);
		return new ResponseEntity<JobClass>(job,HttpStatus.OK);
		}catch(ResourceNotFoundException e)
		{
			System.out.println("Exception occrued"+e.getMessage());
			return new ResponseEntity<JobClass>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/displayALL")
	public ResponseEntity<List<JobClass>>retriveall()
	{
		List<JobClass>jobs=jobservice.displayAll();
		return new ResponseEntity<List<JobClass>>(jobs,HttpStatus.OK);
	}
	
	@DeleteMapping("/removebyid/{id}")	
	public ResponseEntity<String>deletebyid(@PathVariable long id)
	{
		try
		{
			String str=jobservice.removebyid(id);
			return new ResponseEntity<String>(str,HttpStatus.OK);
		}
		catch(ResourceNotFoundException e)
		{
			System.out.println("exception:"+e.getMessage());
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/removeall")
	public ResponseEntity<String>deleteallrecords()
	{
		String str=jobservice.removeall();
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}
	
	@GetMapping("/fetchbylocation/{location}")
	public ResponseEntity<List<JobClass>>fetchbylocation(@PathVariable String location)
	{
		return new ResponseEntity<List<JobClass>>(jobservice.searchjobsbyLocation(location),HttpStatus.OK);
	}
	
	
	/*@GetMapping("/retrivebytitle/{title}")
	public ResponseEntity<JobClass>retrivebyname(@PathVariable String title)
	{
		JobClass job=jobservice.displayByName(title);
		return new ResponseEntity<JobClass>(job,HttpStatus.OK);
	}
	*/

	
	

}
