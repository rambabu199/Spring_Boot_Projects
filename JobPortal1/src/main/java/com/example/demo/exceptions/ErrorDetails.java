package com.example.demo.exceptions;

import java.util.Date;

public class ErrorDetails {
	private String msg;
	private Date timestamp;
	private String request;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorDetails(String msg, Date timestamp, String request) {
		super();
		this.msg = msg;
		this.timestamp = timestamp;
		this.request = request;
	}
	
	

}
