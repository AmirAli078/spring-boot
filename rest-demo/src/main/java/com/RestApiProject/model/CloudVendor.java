 package com.RestApiProject.model;

public class CloudVendor {
  private String vendorId;
  private String vendorName;
  private String vendorAddress;
  private String vendorPhone;

  
public CloudVendor() {
}


public CloudVendor(String vendorId, String vendorName, String vendorAddress, String vendorPhone) {
    this.vendorId = vendorId;
    this.vendorName = vendorName;
    this.vendorAddress = vendorAddress;
    this.vendorPhone = vendorPhone;
}


public String getVendorId() {
    return vendorId;
}


public void setVendorId(String vendorId) {
    this.vendorId = vendorId;
}


public String getVendorName() {
    return vendorName;
}


public void setVendorName(String vendorName) {
    this.vendorName = vendorName;
}


public String getVendorAddress() {
    return vendorAddress;
}


public void setVendorAddress(String vendorAddress) {
    this.vendorAddress = vendorAddress;
}


public String getVendorPhone() {
    return vendorPhone;
}


public void setVendorPhone(String vendorPhone) {
    this.vendorPhone = vendorPhone;
}

  
    
}