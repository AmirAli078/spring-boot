package com.restapiapplicaion.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapiapplicaion.model.CloudVendor;

public interface CloudVendorRepositry extends JpaRepository<CloudVendor, String>{
    
}
