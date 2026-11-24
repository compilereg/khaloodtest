package edu.aast.cndc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.aast.cndc.dto.LoginUserRequest;
import edu.aast.cndc.dto.LoginUserResponse;
import edu.aast.cndc.dto.ResponseMessage;
import edu.aast.cndc.service.AuthService;

@RestController
@RequestMapping("/api/v1/public")
public class PublicController {
	
	private AuthService authService;
	
	public PublicController(AuthService authService) 
	{
		this.authService = authService;
	}
	
	@GetMapping("/check")
	public String getCheck() {
		return "Healthy";
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> startLogin(@RequestBody LoginUserRequest loginUserRequest) {
		try {
		LoginUserResponse result = this.authService.doLogin(loginUserRequest.getUsername(),loginUserRequest.getPassword());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
		} catch ( Exception AuthenticationException) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseMessage("Invalid username/password"));
		}
	}
}
