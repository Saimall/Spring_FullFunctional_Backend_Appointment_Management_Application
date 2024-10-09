package com.example.Users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Users.models.Users;

@Repository
public interface Userrepo extends JpaRepository<Users, Integer> {
	

}
