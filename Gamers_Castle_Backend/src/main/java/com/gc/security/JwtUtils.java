package com.gc.security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component

public class JwtUtils {
	
	@Value("${SECRET_KEY}")
	private String jwtSecret;
	
	@Value("${EXP_TIMEOUT}")
	private int jwtExpirationMs;
	
	private Key key;
	
	@PostConstruct
	public void init() {
		key =Keys.hmacShaKeyFor(jwtSecret.getBytes());
	}
	
	public String generateJwtToken(Authentication authentication) {
		
		CustomUserDetails userPrincipal=(CustomUserDetails) authentication.getPrincipal();
		return null;
		
//		return Jwts.builder()
//				.setSubject((userPrincipal.getUsername()))
//				.setIssuedAt(new Date())
//				.setExpiration(new Date((new Date()).getTime()+jwtExpirationMs))
//				.claim("authorities",getAuthorities())
				
	}
}
