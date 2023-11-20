package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Owner;
import com.example.demo.services.OwnerServicesInterface;

@RestController
@RequestMapping("/owner")
public class OwnerController {
	
	@Autowired
	private OwnerServicesInterface ownerservice;
	
	@PostMapping("/addowner")
	public ResponseEntity<String>addowner(@RequestBody Owner owner)
	{
		String str=ownerservice.addownerdeatils(owner);
		return new ResponseEntity<String>(str,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateowner")
	public ResponseEntity<String>updateowner(@RequestBody Owner owner, @PathVariable int id)
	{
		String str =ownerservice.updateownerdetails(owner, id);
		return new ResponseEntity<String>(str,HttpStatus.ACCEPTED);
	}
	



}
