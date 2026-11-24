package edu.aast.cndc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoadUserDetails implements UserDetailsService {

	private final PasswordEncoder pwEncoder =
			PasswordEncoderFactories.createDelegatingPasswordEncoder();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ( username.equals("compiler"))
			return User.withUsername(username).password(pwEncoder.encode("koko")).disabled(false).roles("ADMIN").build();
		if ( username.equals("khalid"))
			return User.withUsername(username).password(pwEncoder.encode("koko")).disabled(true).roles("ADMIN").build();
		if ( username.equals("shahd"))
			return User.withUsername(username).password(pwEncoder.encode("koko")).disabled(false).roles("USER").build();
		
		return null;
	}

	
	
	
}
