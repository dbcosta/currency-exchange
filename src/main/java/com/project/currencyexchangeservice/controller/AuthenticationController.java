package com.project.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.currencyexchangeservice.resource.AuthenticationRequest;
import com.project.currencyexchangeservice.util.JwtUtil;

@RestController
public class AuthenticationController {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthenticationRequest authRequest) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		return jwtUtil.generateToken(authRequest.getUserName());
	}
}
