package com.example.Appointment.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Appointment.dtos.Appointmentpojo;
import com.example.Appointment.models.Appointmentmodel;
import com.example.Appointment.services.Appointmentservices;


@RestController
@RequestMapping("/appointment")
public class Appointmentcontroller {
	
	@Autowired
	private Appointmentservices appointmentservices;
	
	
	private static final Logger LOG = LoggerFactory.getLogger(Appointmentcontroller.class);
	
	
	@PostMapping("/addappointment")
	public ResponseEntity<?> addappointment(@RequestBody Appointmentmodel app){
		
		LOG.info("Inside appointment");
		
		return new ResponseEntity<>(appointmentservices.addAppointmentmodel(app),HttpStatus.OK);
	}
	
	
	@GetMapping("/getappointment")
	public ResponseEntity<?> getappointments(){
		LOG.info("get appointment");
		
		return new ResponseEntity<>(appointmentservices.getallappointments(),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deletemapping/{id}")
	public void deleteappointment(@PathVariable int id) {
		LOG.info("delete appointment");
		appointmentservices.deleteappointment(id);
	}
	
	
	@GetMapping("/getappointmentbyuserid/{id}")
	public List<Appointmentpojo>getappointmentbyuserid(@PathVariable int id)
	{
		 return appointmentservices.getappointmentbyuserid(id);
	}
	
	
	
	

}
