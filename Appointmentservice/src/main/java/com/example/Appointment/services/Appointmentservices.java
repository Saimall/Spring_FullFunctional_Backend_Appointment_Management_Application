package com.example.Appointment.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Appointment.dtos.Appointmentpojo;
import com.example.Appointment.models.Appointmentmodel;
import com.example.Appointment.repository.Appointmentrepository;

@Service
public class Appointmentservices {
	
	@Autowired
	private Appointmentrepository appointmentrepository;
	
	
	public Appointmentmodel addAppointmentmodel(Appointmentmodel app) {
		
		return appointmentrepository.save(app);
		
	}


	public List<Appointmentmodel> getallappointments() {
		
		return appointmentrepository.findAll();
		
	}


	public void deleteappointment(int id) {
		
		appointmentrepository.deleteById(id);
		// TODO Auto-generated method stub
	}
	
	public Appointmentmodel updateAppointmentmodel(int id, Appointmentmodel app) {
		Optional<Appointmentmodel> appdemo = appointmentrepository.findById(id);
		
		appdemo.get().setAppointmentname(app.getAppointmentname());
		
		appdemo.get().setDate(app.getDate());
		
		appdemo.get().setDesciption(app.getDesciption());
		
	appointmentrepository.save(appdemo.get());
	
	return appdemo.get();
		
	}


	public List<Appointmentpojo> getappointmentbyuserid(int id) {
		
		List<Appointmentmodel> appointmentmodels = appointmentrepository.findByUserid(id);
		
		List<Appointmentpojo> appointmentpojos = new ArrayList();
		for (Appointmentmodel appointmentmodel : appointmentmodels) {
			
			Appointmentpojo appointmentpojo = new Appointmentpojo();
			
			BeanUtils.copyProperties(appointmentmodel, appointmentpojo);
			appointmentpojos.add(appointmentpojo);
			
			
			
		}
		return appointmentpojos;
		
	
	}
	

}
