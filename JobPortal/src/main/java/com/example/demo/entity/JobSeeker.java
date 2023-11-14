package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="job_seeker_boot")
public class JobSeeker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long jsid;
	@NotNull(message = "job seeker name should not be null")
	private String name;
	@NotNull(message = "job seeker mobile number should not be null and should start with 6-9 series only")
	@Pattern(regexp = "^[6-9]\\d{9}$")
	private String mobilenumber;
	@Email(message = "please enter valid email")
	@NotNull(message = "job seeker email should not be null")
	private String email;
	
	private double exp;
	@NotNull(message = "job seeker qualification should not be null")
	private String qualification;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "jobseeker")
	 @JoinTable(
		        name = "jobseeker_jobclass", // Name of the join table
		        joinColumns =@JoinColumn(name="jsid"), // Column in jobseeker_jobclass table that refers to JobSeeker
		        inverseJoinColumns = @JoinColumn(name = "job_id") // Column in jobseeker_jobclass table that refers to JobClass
		    )
	private Set<JobClass> jobClasses = new HashSet<>();

	
	
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
	public Set<JobClass> getJobClasses() {
		return jobClasses;
	}
	public void setJobClasses(Set<JobClass> jobClasses) {
		this.jobClasses = jobClasses;
	}
	
	
	
	
	
	
	

}
