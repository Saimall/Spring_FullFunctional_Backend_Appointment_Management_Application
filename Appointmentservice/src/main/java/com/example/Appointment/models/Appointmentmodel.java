package com.example.Appointment.models;

import java.sql.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Appointmentmodel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
@Override
	public String toString() {
		return "Appointmentmodel [id=" + id + ", desciption=" + desciption + ", date=" + date + ", appointmentname="
				+ appointmentname + ", userid=" + userid + "]";
	}




private String desciption;
	
	private Date date;
	
	private String appointmentname;
	private int userid;
	
	
	public Appointmentmodel() {
		
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


	
	
	public Appointmentmodel(int id, String appointmentname, String desciption, Date date, int userid) {
		super();
		this.id = id;
		this.appointmentname = appointmentname;
		this.desciption = desciption;
		this.date = date;
		this.userid = userid;
	}


	
}
