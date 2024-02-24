package com.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.jpa.entities.User;

public interface UserRepositry extends CrudRepository<User, Integer>{

}
