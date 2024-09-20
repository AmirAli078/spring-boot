package com.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer>{

}
