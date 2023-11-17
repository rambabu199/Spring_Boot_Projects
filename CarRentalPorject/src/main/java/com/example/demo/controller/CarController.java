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

import com.example.demo.entity.Car;
import com.example.demo.services.CarServiceInterface;

@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private CarServiceInterface carserint;
	@PostMapping("/savedetails")
	public ResponseEntity<Car>savecar(@RequestBody Car car)
	{
		Car str=carserint.addcar(car);
		return new ResponseEntity<>(str,HttpStatus.CREATED);
	}
	@GetMapping("/displayall")
	public ResponseEntity<List<Car>>retriveall()
	{
		List<Car>c=carserint.displayAll();
		return new ResponseEntity<List<Car>>(c,HttpStatus.OK);
				
				
	}
	@GetMapping("/displayBYID/{id}")
	public ResponseEntity<Car>retriveBYiD(@PathVariable int id)
	{
		Car c=carserint.displayByID(id);
		return new ResponseEntity<Car>(c,HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String>updateCAR(@RequestBody Car car,@PathVariable int id)
	{
		String str=carserint.updateCar(car, id);
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<String>deletecar(@PathVariable int id)
	{
		String str=carserint.deletecarByID(id);
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}
	@DeleteMapping("/deleteall")
	public ResponseEntity<String>deleteallcars()
	{
		String str=carserint.deleteallCARS();
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}
	

}
