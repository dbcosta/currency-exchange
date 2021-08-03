package com.project.currencyexchangeservice.resource;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class AuthenticationRequest {

	private String userName;
	private String password;
}
