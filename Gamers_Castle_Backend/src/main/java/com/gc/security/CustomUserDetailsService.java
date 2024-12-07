package com.gc.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gc.entity.User;
import com.gc.respository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {
	
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user=userRepository.findByEmail(email)
		.orElseThrow(()-> new UsernameNotFoundException("Invalid Email !!"));
		return new CustomUserDetails(user);
	}
}
