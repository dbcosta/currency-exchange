package com.project.currencyexchangeservice;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class Oauth2AuthorizationConfig extends WebSecurityConfigurerAdapter{

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests().antMatchers("/oauth/token").permitAll();
		httpSecurity.requestMatchers().antMatchers("/currency-exchange/**")
		.and().authorizeRequests().antMatchers("/currency-exchange/**").hasAnyRole("USER");
	}
	
	@Bean
	@Override
	public UserDetailsService userDetailsServiceBean() {
		UserDetails userDetails = User.builder().username("user").password(passwordEncoder().encode("secret")).roles("USER").build();
		return new InMemoryUserDetailsManager(userDetails);
	}
}
