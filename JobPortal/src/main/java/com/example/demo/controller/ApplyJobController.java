package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.JobClass;
import com.example.demo.services.ApplyJobServices;

@RestController
@RequestMapping("/apply")
public class ApplyJobController {
	
	@Autowired
	private ApplyJobServices ajs;
	@PostMapping("/applyjob/{job_id}/{jsid}")
	public ResponseEntity<String>applyjobs(@PathVariable long job_id,@PathVariable long jsid)
	{
		String str=ajs.applyjob(job_id, jsid);
		return new ResponseEntity<String>(str,HttpStatus.CREATED);
	}
	
	@GetMapping("/displayapplied/{job_id}/{jsid}")
	public ResponseEntity<List<JobClass>>displayappliedjobs(@PathVariable long job_id,@PathVariable long jsid)
	{
		return new ResponseEntity<>(ajs.viewappliedjobs(jsid, job_id),HttpStatus.OK);
	}

}
