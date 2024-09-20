package com.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	

}
