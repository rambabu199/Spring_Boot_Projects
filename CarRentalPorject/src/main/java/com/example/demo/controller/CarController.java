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
@RequestMapping("/owner/{ownerid}/car")
public class CarController {
	
	@Autowired
	private CarServiceInterface carserint;
	@PostMapping("/savecardetails")
	public ResponseEntity<Car>savecar(@PathVariable int ownerid, @RequestBody Car car)
	{
		Car str=carserint.addcar(car);
		return new ResponseEntity<>(str,HttpStatus.CREATED);
	}
	@GetMapping("/displayallcars")
	public ResponseEntity<List<Car>>retriveall()
	{
		List<Car>c=carserint.displayAll();
		return new ResponseEntity<List<Car>>(c,HttpStatus.OK);
				
				
	}
	@GetMapping("/displaycarBYID/{id}")
	public ResponseEntity<Car>retriveBYiD(@PathVariable int id)
	{
		Car c=carserint.displayByID(id);
		return new ResponseEntity<Car>(c,HttpStatus.OK);
	}
	@PutMapping("/updatecardetails/{id}")
	public ResponseEntity<String>updateCAR(@RequestBody Car car,@PathVariable int id)
	{
		String str=carserint.updateCar(car, id);
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}
	@DeleteMapping("/deletecarbyid/{id}")
	public ResponseEntity<String>deletecar(@PathVariable int id)
	{
		String str=carserint.deletecarByID(id);
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}
	@DeleteMapping("/deleteallcars")
	public ResponseEntity<String>deleteallcars()
	{
		String str=carserint.deleteallCARS();
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}
	

}
