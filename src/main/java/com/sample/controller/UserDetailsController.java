package com.sample.controller;

import com.sample.entity.UserDetails;
import com.sample.model.UserDetailsRequest;
import com.sample.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserDetailsController {
	
	@Autowired
	public UserDetailsService userDetailsService;
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public String createUser( @RequestBody UserDetailsRequest userDetailsRequest) {
		userDetailsService.createUser(userDetailsRequest);
		return "user created";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{user_id}")
	public UserDetails getUser(@PathVariable("user_id")Integer userId) {
		return userDetailsService.findById(userId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{user_id}")
	public String deleteUser(@PathVariable("user_id") Integer userId) {
		 userDetailsService.remove(userId);
		 return "User with id"+userId+"got deleted";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{user_id}")
	public UserDetails updateUser(@PathVariable("user_id")Integer userId, @RequestBody UserDetailsRequest userDetailsRequest) {
		return userDetailsService.updateUser(userId, userDetailsRequest);
	}
	
	@RequestMapping(method = RequestMethod.GET,  value = "/list")
	public List<UserDetails> getAllUser() {
		return userDetailsService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public UserDetails findUserByEmailAndName(@PathVariable("user_id")Integer userId, @RequestParam("emailAddress")String emailAddress,  @RequestParam("name")String name){
	return userDetailsService.findUserByEmailAndName(emailAddress, name);
	}
	
}
