package com.example.demo.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="recruter_boots",uniqueConstraints = {
		@UniqueConstraint(columnNames = "mobielnumber")
})
public class Recruter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rid;
	@NotNull(message = "recruter name should not be null")
	private String name;
	@Pattern(regexp = "^[6-9]\\d{9}$",message = "mobile number should start with 6-9 series only and 10 digits")
	private String mobielnumber;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	List<JobClass>jobs;


	public long getRid() {
		return rid;
	}

	public void setRid(long rid) {
		this.rid = rid;
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

	public List<JobClass> getJobs() {
		return jobs;
	}

	public void setJobs(List<JobClass> jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		return "Recruter [id=" + rid + ", name=" + name + ", mobielnumber=" + mobielnumber + ","+ "]";
	}
	
	
	
	

}
