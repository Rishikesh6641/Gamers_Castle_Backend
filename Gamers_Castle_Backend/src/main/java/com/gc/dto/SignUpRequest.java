package com.gc.dto;

import java.time.LocalDate;

import com.gc.entity.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignUpRequest {
	private String firstName;
	private String lastName;
	private Role role;
	private String contact;
	private String email;
	private String password;
	private LocalDate dob;
	
	public SignUpRequest(String firstName, String lastName, Role role, String contact, String email, String password,
			LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.contact = contact;
		this.email = email;
		this.password = password;
		this.dob = dob;
	}
}
