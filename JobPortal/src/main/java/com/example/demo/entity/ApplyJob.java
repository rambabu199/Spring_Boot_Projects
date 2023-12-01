package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ApplyJob {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ApplicationNum;
	
	private long job_id;
	private long jsid;
	public long getApplicationNum() {
		return ApplicationNum;
	}
	public void setApplicationNum(long applicationNum) {
		ApplicationNum = applicationNum;
	}
	public long getJob_id() {
		return job_id;
	}
	public void setJob_id(long job_id) {
		this.job_id = job_id;
	}
	public long getJsid() {
		return jsid;
	}
	public void setJsid(long jsid) {
		this.jsid = jsid;
	}
	
	

}
