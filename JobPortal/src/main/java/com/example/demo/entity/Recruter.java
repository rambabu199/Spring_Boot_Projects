package com.example.demo.entity;

import java.util.Set;
import java.util.TreeSet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="recruter_boot")
public class Recruter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull(message = "recruter name should not be null")
	private String name;
	@Pattern(regexp = "^[6-9]\\d{9}$",message = "mobile number should start with 6-9 series only and 10 digits")
	private String mobielnumber;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobielnumber() {
		return mobielnumber;
	}

	public void setMobielnumber(String mobielnumber) {
		this.mobielnumber = mobielnumber;
	}

	

	@Override
	public String toString() {
		return "Recruter [id=" + id + ", name=" + name + ", mobielnumber=" + mobielnumber + ","+ "]";
	}
	
	
	
	

}
