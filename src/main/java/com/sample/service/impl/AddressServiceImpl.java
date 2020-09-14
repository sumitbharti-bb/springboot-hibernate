package com.sample.service.impl;

import com.sample.dao.AddressDetailsDao;
import com.sample.entity.Address;
import com.sample.model.AddressDetailsRequest;
import com.sample.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    
    @Autowired
    private AddressDetailsDao addressDetailsDao;
    
    @Override
    @Transactional
    public void createAddress(AddressDetailsRequest addressDetailsRequest) {
        Address address = new Address();
        address.setCity(addressDetailsRequest.getCity());
        address.setPinCode(addressDetailsRequest.getPinCode());
        address.setState(addressDetailsRequest.getState());
        address.setLocation(addressDetailsRequest.getLocation());
        addressDetailsDao.persist(address);
    }
    
    @Override
    @Transactional
    public void remove(Address address) {
        addressDetailsDao.remove(address);
    }
    
    @Override
    @Transactional
    public Address findById(Integer id) {
        return addressDetailsDao.findById(id);
    }
    
    @Override
    @Transactional
    public List<Address> findAll() {
        return addressDetailsDao.findAll();
    }
    
    @Override
    @Transactional
    public Address findAddress(String pinCode, String location) {
        return addressDetailsDao.findAddress(pinCode, location);
    }
}
