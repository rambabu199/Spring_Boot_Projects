package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Driver_boot")
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String drivername;
	private String driverlicenceNum;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDrivername() {
		return drivername;
	}
	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}
	public String getDriverlicenceNum() {
		return driverlicenceNum;
	}
	public void setDriverlicenceNum(String driverlicenceNum) {
		this.driverlicenceNum = driverlicenceNum;
	}
	
	
}
