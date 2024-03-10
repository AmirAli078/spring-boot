package com.restapiapplicaion.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapiapplicaion.model.CloudVendor;
import com.restapiapplicaion.service.CloudVendorService;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
    

CloudVendorService cloudVendorService;


    public CloudVendorController(CloudVendorService cloudVendorService) {
    this.cloudVendorService = cloudVendorService;
}
      //get specfic cloud vendor
    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
            
        return cloudVendorService.getCloudVendor(vendorId);
        //new CloudVendor("c1","Amir","block hostel muet","1235664412");
    }

    //get all cloud vendors from database
    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails(){
            
        return cloudVendorService.getAllcloudVendor();
        //new CloudVendor("c1","Amir","block hostel muet","1235664412");
    }
    
    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Successfully data is added";
    }


    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return " Data is Updated Successfully!";
    }


    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return " Data is Deleted Successfully!";
    }
}
