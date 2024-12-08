package com.gc.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gc.customException.ApiException;
import com.gc.dto.SignUpRequest;
import com.gc.entity.User;
import com.gc.respository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private ModelMapper model;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public SignUpRequest userRegistration(SignUpRequest dto) {
		User user=model.map(dto,User.class);
		if(userRepository.existsByEmail(user.getEmail())) 
			throw new ApiException("Email Already exist");
		
		user.setPassword(encoder.encode(user.getPassword()));
		return model.map(userRepository.save(user),SignUpRequest.class);
	}
}
