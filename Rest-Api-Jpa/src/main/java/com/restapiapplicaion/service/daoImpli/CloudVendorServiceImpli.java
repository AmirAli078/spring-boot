package com.restapiapplicaion.service.daoImpli;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restapiapplicaion.model.CloudVendor;
import com.restapiapplicaion.repositry.CloudVendorRepositry;
import com.restapiapplicaion.service.CloudVendorService;

@Service
public class CloudVendorServiceImpli implements CloudVendorService{


    CloudVendorRepositry cloudVendorRepositry;
    
    public CloudVendorServiceImpli(CloudVendorRepositry cloudVendorRepositry) {
        this.cloudVendorRepositry = cloudVendorRepositry;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {

        cloudVendorRepositry.save(cloudVendor);
        return "Successfully created";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepositry.save(cloudVendor);
        // TODO Auto-generated method stub
        return" successfully Data is Updated! ";
    }

    @Override
    public CloudVendor getCloudVendor(String vendorId) {
        return cloudVendorRepositry.findById(vendorId).get();
    }

    @Override
    public String deleteCloudVendor(String vendorId) {
        cloudVendorRepositry.deleteById(vendorId);
        return "Successfully Deleted the Record";
    }

    @Override
    public List<CloudVendor> getAllcloudVendor() {
        return cloudVendorRepositry.findAll();
    }
    
}
