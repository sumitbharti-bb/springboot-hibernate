package com.sample.service.impl;

import com.sample.dao.UserDetailsDao;
import com.sample.entity.UserDetails;
import com.sample.model.UserDetailsRequest;
import com.sample.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private UserDetailsDao userDetailsDao;
    
    @Override
    @Transactional
    public void createUser(UserDetailsRequest userDetailsRequest) {
        UserDetails userDetails = new UserDetails();
        userDetails.setName(userDetailsRequest.getName());
        userDetails.setEmailAddress(userDetailsRequest.getEmailAddress());
        userDetails.setMobileNumber(userDetailsRequest.getMobileNumber());
        userDetailsDao.persist(userDetails);
    }
    
    @Override
    @Transactional
    public void remove(Integer id) {
        UserDetails userDetails = userDetailsDao.findById(id);
        userDetailsDao.remove(userDetails);
    }
    
    @Override
    @Transactional
    public UserDetails findById(Integer id) {
        UserDetails userDetails =  userDetailsDao.findById(id);
        return userDetails;
    }
    
    @Override
    @Transactional
    public List<UserDetails> findAll() {
        return userDetailsDao.findAll();
    }
    
    @Override
    @Transactional
    public UserDetails findUser(String mobileNumber) {
        return userDetailsDao.findUser(mobileNumber);
    }
    
    @Override
    @Transactional
    public UserDetails findUserByEmailAndName(String emailAddress, String name) {
        return userDetailsDao.findUserByEmailAndName(emailAddress, name);
    }
    
    @Override
    @Transactional
    public UserDetails findUserByEmailAndNameUsingSql(String emailAddress, String name) {
        return userDetailsDao.findUserByEmailAndNameUsingSql(emailAddress, name);
    }
    
    @Override
    @Transactional
    public UserDetails updateUser(Integer userId, UserDetailsRequest userDetailsRequest) {
        UserDetails userDetails = userDetailsDao.findById(userId);
        userDetails.setName(userDetailsRequest.getName());
        userDetails.setEmailAddress(userDetailsRequest.getEmailAddress());
        userDetails.setMobileNumber(userDetailsRequest.getMobileNumber());
        return userDetailsDao.updateUserDetails(userDetails);
    }
}
