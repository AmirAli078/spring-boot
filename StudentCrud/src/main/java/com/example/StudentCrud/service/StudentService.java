package com.example.StudentCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.StudentCrud.domain.Student;

@Service
public class StudentService {

	@Autowired
    private CrudRepository repo;
    
    public List<Student> listAll() {
        return (List<Student>) repo.findAll();
    }
     
    public void save(Student std) {
        repo.save(std);
    }
     
    public Student get(long id) {
        return (Student) repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}
