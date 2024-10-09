package com.example.Users.controller;


import org.slf4j.LoggerFactory;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Users.dtos.Userspojo;
import com.example.Users.models.Users;
import com.example.Users.services.Userservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;



@RestController
@RequestMapping("/user")
public class Usercontroller {
	
	@Autowired
	private Userservice userservice;
	
 private static final Logger LOG = LoggerFactory.getLogger(Usercontroller.class);
	
	@PostMapping("/adduser")
	public ResponseEntity<?> adduser(@RequestBody Users user){
		LOG.info("Inside user");
		
		return new ResponseEntity<>(userservice.addUsers(user),HttpStatus.OK);
	}
	
	
	@GetMapping("/getusers")
	public ResponseEntity<?> getusers(){
		
		LOG.info("Get user");
		return new ResponseEntity<>(userservice.getusers(),HttpStatus.OK);
	}
	
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<?> updateuser(@PathVariable int id,@RequestBody Users user){
		LOG.info("Update user");
		return new ResponseEntity<>(userservice.updateuser(id,user),HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/deleteuser/{id}")
	public void deleteuser(@PathVariable int id) {
		LOG.info("Delete user");
		userservice.deleteuser(id);
	}
	
	@GetMapping("/getappointmentbyuserid/{id}")
	@CircuitBreaker(name="ciremp", fallbackMethod = "fallbackEmployee")
	public Userspojo getAppointmentsbyuserId(@PathVariable int id) {
		
		return userservice.getappointmentsbyuserid(id);
		
		
	}
	public Userspojo fallbackEmployee() {
		return new Userspojo(0,"fallback");
	}

	

}
