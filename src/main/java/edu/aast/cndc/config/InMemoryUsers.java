package edu.aast.cndc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class InMemoryUsers {

	
	@Bean PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean UserDetailsService createUsers(PasswordEncoder encoder) {
		UserDetails u1 = User.withUsername("compiler").password(encoder.encode("koko")).disabled(false).roles("ADMIN").build();
		UserDetails u2 = User.withUsername("khalid").password(encoder.encode("koko")).disabled(true).roles("ADMIN").build();
		UserDetails u3 = User.withUsername("shahd").password(encoder.encode("koko")).disabled(false).roles("USER").build();
		
		return new InMemoryUserDetailsManager(u1,u2,u3);
		
	}
}
