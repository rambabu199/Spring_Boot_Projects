package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="owner_boot")
public class Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ownerid;
	
	private String ownername;
	private String companyname;
	private String address;
	private String ownermobile;
	
	
	@OneToMany(cascade =  CascadeType.ALL,mappedBy = "owner")
	private List<Car>cars=new ArrayList<>();
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
	private List<Driver>drivers=new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
	private List<Customer>customers=new ArrayList<>();
	
	
	public List<Driver> getDrivers() {
		return drivers;
	}
	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	public int getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOwnermobile() {
		return ownermobile;
	}
	public void setOwnermobile(String ownermobile) {
		this.ownermobile = ownermobile;
	}
	
	
	

}
