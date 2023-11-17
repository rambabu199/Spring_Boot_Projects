package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	@Override
	public String toString() {
		return "Car [id=" + id + ", registrationNum=" + registrationNum + ", car_name=" + car_name + ", brand=" + brand
				+ ", rental_price=" + rental_price + "]";
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(String registrationNum, String car_name, String brand, double rental_price) {
		super();
		this.registrationNum = registrationNum;
		this.car_name = car_name;
		this.brand = brand;
		this.rental_price = rental_price;
	}
	
	
	

}
