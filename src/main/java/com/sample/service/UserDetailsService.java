package com.sample.service;

import com.sample.entity.UserDetails;
import com.sample.model.UserDetailsRequest;

import java.util.List;

public interface UserDetailsService {
    
    public void createUser(UserDetailsRequest userDetailsRequest);
    public void remove(Integer id);
    public UserDetails findById(Integer id);
    public List<UserDetails> findAll();
    public UserDetails findUser(String mobileNumber);
    public UserDetails findUserByEmailAndName(String emailAddress, String name);
    public UserDetails findUserByEmailAndNameUsingSql(String emailAddress, String name);
    public UserDetails updateUser(Integer userId, UserDetailsRequest userDetailsRequest);
    
    
}
