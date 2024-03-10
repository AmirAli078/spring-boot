package com.RestApiProject.controller;

import org.springframework.web.bind.annotation.RestController;

import com.RestApiProject.model.CloudVendor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/cloudvendor")
public class CloudApiController {
    CloudVendor cloudVendor;

    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(String vendorId){

        return cloudVendor;
        //new CloudVendor("c1","Amir","block hostel muet","1235664412");
    }
    
    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        this.cloudVendor=cloudVendor;
        return "Successfully data is added";
    }


    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        this.cloudVendor=cloudVendor;
        return " Data is Updated Successfully!";
    }


    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(String vendorId){
        this.cloudVendor=null;
        return " Data is Deleted Successfully!";
    }
    
}
