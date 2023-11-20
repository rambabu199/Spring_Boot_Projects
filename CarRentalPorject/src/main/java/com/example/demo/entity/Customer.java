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
@Table(name="Customer_Boot")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String licenceNum;
	private String cus_mobile;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ownerid",referencedColumnName = "ownerid")
	private Owner owner;
	
	
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLicenceNum() {
		return licenceNum;
	}
	public void setLicenceNum(String licenceNum) {
		this.licenceNum = licenceNum;
	}
	
	public String getCus_mobile() {
		return cus_mobile;
	}
	public void setCus_mobile(String cus_mobile) {
		this.cus_mobile = cus_mobile;
	}
	
	
	

}
