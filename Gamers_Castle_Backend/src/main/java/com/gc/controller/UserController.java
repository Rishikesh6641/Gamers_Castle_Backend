package com.gc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gc.dto.SignUpRequest;
import com.gc.dto.SigninRequest;
import com.gc.dto.SigninResponse;
import com.gc.security.JwtUtils;
import com.gc.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private AuthenticationManager authMgr;
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignUpRequest request){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(userService.userRegistration(request));
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticationUser(@RequestBody SigninRequest request){
		try {
			System.out.println("in sign in" + request);
			UsernamePasswordAuthenticationToken token= new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword());
			System.out.println(token);
			Authentication verifiedToken =authMgr.authenticate(token);
			System.out.println(verifiedToken);
	     	SigninResponse resp = new SigninResponse
	    	(jwtUtils.generateJwtToken(verifiedToken), "Successful Auth!!!!");
//			String resp="here";
	        return ResponseEntity.status(HttpStatus.CREATED).body("ok");
			
		}catch(Exception e) {
			return  ResponseEntity.status(HttpStatus.CREATED).body(e.getCause());
		}

		
	}
	

}