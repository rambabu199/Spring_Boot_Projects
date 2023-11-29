package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.example.demo.entity.Recruter;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.services.RecruterServiceInterface;

@RestController
@RequestMapping("/recruter")
public class RecruterController {
	@Autowired
	private RecruterServiceInterface recinterface;
	

	
	@PostMapping(value = "/addRecruter",produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addRecruter(@RequestBody Recruter recruter) {
	    try {
	        String result = recinterface.upsert(recruter);
	        return ResponseEntity.status(HttpStatus.CREATED).body(result);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing the request");
	    }
	}

	
	@PostMapping("/updateRecruter")
	public ResponseEntity<String>updaterecruter(@RequestBody Recruter recruter)
	{
		String str=recinterface.upsert(recruter);
		return new ResponseEntity<>(str,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/retrivebyrecid/{id}")
	public ResponseEntity<Recruter>retrivebyrecid(@PathVariable long id)
	{
		
		Recruter rec=null;
		try {
		 rec=recinterface.displayBYID(id);
		return new ResponseEntity<Recruter>(rec,HttpStatus.OK);
		}catch(ResourceNotFoundException e)
		{
			System.out.println("Exception occred"+e);
			return new ResponseEntity<Recruter>(rec,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/retriveallrec")
	public ResponseEntity<List<Recruter>>retriveall()
	{
		List<Recruter> rec=recinterface.displayAll();
		return new ResponseEntity<List<Recruter>>(rec,HttpStatus.OK);
	}
	@GetMapping("/retrivebyname/{name}")
	public ResponseEntity<Recruter>retrivebyname(@PathVariable String name)
	{
		Recruter rec=recinterface.displayByName(name);
		return new ResponseEntity<Recruter>(rec,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/removerecbyid/{id}")
	public ResponseEntity<String>removebyid(@PathVariable long id)
	{
		String str=recinterface.deleteBYID(id);
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteall")
	public ResponseEntity<String>deleteallrec() {
		String str=recinterface.deleteAll();
		return new ResponseEntity<String>(str,HttpStatus.OK);
		
	}
	
	@PostMapping("/addjob")
	public ResponseEntity<String>addpost(@RequestBody JobClass job)
	{
		String str=recinterface.addjobpost(job);
		return new ResponseEntity<String>(str,HttpStatus.CREATED);
	}
	@PutMapping("/updatejob/{id}")
	public ResponseEntity<String>updatepost(@RequestBody JobClass job, @PathVariable long id) {
		String str=recinterface.updateJob(job,id);
		return new ResponseEntity<String>(str,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/displaybyid/{id}")
	public ResponseEntity<JobClass>retrivebyID(@PathVariable  long id)
	{
		try {
		JobClass job=recinterface.displayjobBYID(id);
		return new ResponseEntity<JobClass>(job,HttpStatus.OK);
		}catch(ResourceNotFoundException e)
		{
			System.out.println("Exception occrued"+e.getMessage());
			return new ResponseEntity<JobClass>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/displayALL")
	public ResponseEntity<List<JobClass>>retrivealljobs()
	{
		List<JobClass>jobs=recinterface.displayAlljobs();
		return new ResponseEntity<List<JobClass>>(jobs,HttpStatus.OK);
	}
	
	@DeleteMapping("/removebyid/{id}")	
	public ResponseEntity<String>deletebyid(@PathVariable long id)
	{
		try
		{
			String str=recinterface.removebyid(id);
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
		String str=recinterface.removeall();
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}
	
	@GetMapping("/displayapplicants/{rid},{job_id},{jsid}")
	public ResponseEntity<List<JobSeeker>>displayallApplicants(@PathVariable long rid,@PathVariable long job_id,@PathVariable long jsid)
	{
		List<JobSeeker>applicants=recinterface.viewapplicants(rid, job_id, jsid);
		return new ResponseEntity<List<JobSeeker>>(applicants,HttpStatus.OK);
	}
	
	
	

}
