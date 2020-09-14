package com.sample.service;


import com.sample.entity.Address;
import com.sample.entity.UserDetails;
import com.sample.model.AddressDetailsRequest;
import com.sample.model.UserDetailsRequest;

import java.util.List;

public interface AddressService {
    
    public void createAddress(AddressDetailsRequest addressDetailsRequest);
    public void remove(Address address);
    public Address findById(Integer id);
    public List<Address> findAll();
    public Address findAddress(String pinCode, String location);
    

}
