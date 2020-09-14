package com.sample.controller;

import com.sample.model.UserDetailsRequest;
import com.sample.service.AddressService;
import com.sample.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/address")
@RestController
public class AddressController {
	
	@Autowired
	public AddressService addressService;
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json", value = "/save")
	public String createAddress( @RequestBody UserDetailsRequest userDetailsRequest) {
		return "User created";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getAddress() {
		return "Moni address: bihar";
	}
	
}
