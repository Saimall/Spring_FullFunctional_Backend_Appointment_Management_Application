package com.example.Appointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.Appointment.models.Appointmentmodel;

@Repository
public interface Appointmentrepository extends JpaRepository<Appointmentmodel, Integer>{

	public List<Appointmentmodel>findByUserid(int id);
	
}
