package com.gc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SigninRequest {
	
	private String email;
	private String password;
	
}
