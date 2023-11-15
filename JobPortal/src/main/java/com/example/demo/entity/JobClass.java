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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name="Job_Class_boot")
public class JobClass {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long job_id;
	@NotNull(message = "job title should not be null")
	private String job_title;
	@NotNull(message = "job description should not be null")
	private String job_desc;
	@NotNull(message = "required experience should not be null")
	@Min(message = "required experience should not less then 0",value = 0)
	private double req_exp;
	@NotNull(message = "job location should not be null")
	private String location;
	
	private double salary_package;
	@NotNull(message = "required qualification should not be null")
	private String req_qualification;
	@NotNull(message = "required keyskills should not be null")
	private String req_keyskills;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "jobseeker_jobclass",
        joinColumns = @JoinColumn(name="job_id"),
        inverseJoinColumns = @JoinColumn(name = "jsid")
    )
    private Set<JobSeeker> jobSeekers = new HashSet<>();
	
	
	
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name="id",referencedColumnName = "job_id")
	 private Recruter recruter;
	
	
	
	
	
	public long getJob_id() {
		return job_id;
	}
	public void setJob_id(long job_id) {
		this.job_id = job_id;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public String getJob_desc() {
		return job_desc;
	}
	public void setJob_desc(String job_desc) {
		this.job_desc = job_desc;
	}
	public double getReq_exp() {
		return req_exp;
	}
	public void setReq_exp(double req_exp) {
		this.req_exp = req_exp;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getSalary_package() {
		return salary_package;
	}
	public void setSalary_package(double salary_package) {
		this.salary_package = salary_package;
	}
	public String getReq_qualification() {
		return req_qualification;
	}
	public void setReq_qualification(String req_qualification) {
		this.req_qualification = req_qualification;
	}
	public String getReq_keyskills() {
		return req_keyskills;
	}
	public void setReq_keyskills(String req_keyskills) {
		this.req_keyskills = req_keyskills;
	}
	@Override
	public String toString() {
		return "JobClass [job_id=" + job_id + ", job_title=" + job_title + ", job_desc=" + job_desc + ", req_exp="
				+ req_exp + ", location=" + location + ", salary_package=" + salary_package + ", req_qualification="
				+ req_qualification + ", req_keyskills=" + req_keyskills + "]";
	}
	public Set<JobSeeker> getJobSeekers() {
		return jobSeekers;
	}
	public void setJobSeekers(Set<JobSeeker> jobSeekers) {
		this.jobSeekers = jobSeekers;
	}
	
	
	
	
	
	

}
