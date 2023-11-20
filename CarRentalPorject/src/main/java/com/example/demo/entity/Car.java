package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "Car_boot")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String registrationNum;
	private String car_name;
	private String brand;
	private double rental_price;
	
	private boolean isAvailable ;
	
	private int num_of_cars;
	
	@ManyToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name="ownerid",referencedColumnName = "ownerid")
	private Owner owner;
	
	
	
	public int getNum_of_cars() {
		return num_of_cars;
	}
	public void setNum_of_cars(int num_of_cars) {
		this.num_of_cars = num_of_cars;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegistrationNum() {
		return registrationNum;
	}
	public void setRegistrationNum(String registrationNum) {
		this.registrationNum = registrationNum;
	}
	public String getCar_name() {
		return car_name;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getRental_price() {
		return rental_price;
	}
	public void setRental_price(double rental_price) {
		this.rental_price = rental_price;
	}
	
	public Car() {
		super();
	}
	
	

}
