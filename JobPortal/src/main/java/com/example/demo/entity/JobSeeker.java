package com.example.demo.entity;


import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="job_seeker_boot",uniqueConstraints = {
		@UniqueConstraint(columnNames = "email"),
		@UniqueConstraint(columnNames = "mobilenumber")
})
public class JobSeeker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long jsid;
	@NotNull(message = "job seeker name should not be null")
	private String name;
	@NotNull(message = "job seeker mobile number should not be null and should start with 6-9 series only")
	@Pattern(regexp = "^[6-9]\\d{9}$")
	@Column(nullable = false, unique = true)
	private String mobilenumber;
	@Email(message = "please enter valid email")
	@NotNull(message = "job seeker email should not be null")
	@Column(nullable = false, unique = true)
	private String email;
	
	private double exp;
	@NotNull(message = "job seeker qualification should not be null")
	private String qualification;
	

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getExp() {
		return exp;
	}
	public void setExp(double exp) {
		this.exp = exp;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	@Override
	public String toString() {
		return "JobSeeker [id=" + jsid + ", name=" + name + ", mobilenumber=" + mobilenumber + ", email=" + email
				+ ", exp=" + exp + ", qualification=" + qualification + "]";
	}
	public long getJsid() {
		return jsid;
	}
	public void setJsid(long jsid) {
		this.jsid = jsid;
	}
	
	
	
	
	
	
	

}
