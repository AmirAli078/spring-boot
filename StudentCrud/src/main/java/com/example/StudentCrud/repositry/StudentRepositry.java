package com.example.StudentCrud.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentCrud.domain.Student;

@Repository
public interface  StudentRepositry extends JpaRepository<Student, Long>{

	
}
