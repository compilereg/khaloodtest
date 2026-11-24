package edu.aast.cndc.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import edu.aast.cndc.dto.LoginUserResponse;

@Service
public class AuthService {
	
	private AuthenticationManager authenticationManager;

	public AuthService(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}
	
	public  LoginUserResponse doLogin(String username, String password) throws AuthenticationException {
		Authentication authentication = authenticationManager.authenticate(
	            UsernamePasswordAuthenticationToken.unauthenticated(username, password)
	        );
		
		
		//GEt Roles
		String role = authentication.getAuthorities().stream()
			    .map(GrantedAuthority::getAuthority)
			    .map(authority -> authority)
			    .findFirst()
			    .orElse("NONE");
			    System.out.println("Authorizties : "  + role);	    
			    
			    
		return new LoginUserResponse(username, role ,"123");
		
		
	}
}
