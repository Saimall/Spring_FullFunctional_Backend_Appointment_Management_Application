package com.example.Users.dtos;

import java.util.List;

public class Userspojo {
	
private int id;
	
	

	private String name;
	
	private List<Appointmentpojo> allAppointmentpojos ;
	
	public List<Appointmentpojo> getAllAppointmentpojos() {
		return allAppointmentpojos;
	}

	public void setAllAppointmentpojos(List<Appointmentpojo> allAppointmentpojos) {
		this.allAppointmentpojos = allAppointmentpojos;
	}

	public Userspojo() {
		
	}
	
	public Userspojo(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.allAppointmentpojos = allAppointmentpojos;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + "]";
	}

}
