package com.example.Users.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.Users.dtos.Appointmentpojo;
import com.example.Users.dtos.Userspojo;
import com.example.Users.models.Users;
import com.example.Users.repository.Userrepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class Userservice {
	
	@Autowired
	private Userrepo userrepo;
	
	
	public Users addUsers(Users user) {
		
		return userrepo.save(user);
	}


	public List<Users> getusers() {
		
		return userrepo.findAll();
	}


	public Users updateuser(Integer id,Users user) {
		Optional<Users> userOptional = userrepo.findById(id);
		
		userOptional.get().setName(user.getName());
		
		
		
		return userOptional.get();
		
	}


	public void deleteuser(int id) {
		
		userrepo.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	
	public Userspojo getappointmentsbyuserid(int id) {
		System.out.println(id);
 
		Optional<Users> userspojo = userrepo.findById(id);
		
		Userspojo userspojo2 = new Userspojo();
		
		BeanUtils.copyProperties(userspojo.get(), userspojo2);
		
		RestClient restClient = RestClient.create();
	List<Appointmentpojo>appointmentpojos=	restClient.get().uri("http://localhost:8081/appointment/getappointmentbyuserid/"+id).retrieve().body(List.class);
		 
   userspojo2.setAllAppointmentpojos(appointmentpojos);

		return userspojo2;
	}
	
	
	
}
