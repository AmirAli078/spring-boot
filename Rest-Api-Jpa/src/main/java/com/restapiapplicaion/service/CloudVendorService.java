package com.restapiapplicaion.service;

import java.util.List;

import com.restapiapplicaion.model.CloudVendor;

public interface CloudVendorService {
    public String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor);
    public CloudVendor getCloudVendor(String vendorId);
    public String deleteCloudVendor(String vendorId);
    public List<CloudVendor> getAllcloudVendor();
}
