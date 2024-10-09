package com.example.Appointment.dtos;

import java.sql.Date;

public class Appointmentpojo {
	private int id;
private String desciption;
	
	private Date date;
	
	private String appointmentname;
	private int userid;
	
	
	public Appointmentpojo() {
		
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAppointmentname() {
		return appointmentname;
	}


	public void setAppointmentname(String appointmentname) {
		this.appointmentname = appointmentname;
	}


	public String getDesciption() {
		return desciption;
	}


	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	
	
	public  Appointmentpojo(int id, String appointmentname, String desciption, Date date, int userid) {
		super();
		this.id = id;
		this.appointmentname = appointmentname;
		this.desciption = desciption;
		this.date = date;
		this.userid = userid;
	}



}
