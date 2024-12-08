package com.gc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SigninResponse {
	
	private String jwt;
	private String role;
}

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class SigninResponse {
//	private String jwt;
//	private String mesg;
//}