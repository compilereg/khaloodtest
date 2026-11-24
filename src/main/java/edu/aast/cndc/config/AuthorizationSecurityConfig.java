package edu.aast.cndc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AuthorizationSecurityConfig {

	
	@Bean AuthenticationManager authenticationManager(
            AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
	
	@Bean SecurityFilterChain doAuthorization(HttpSecurity http) {
		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests( auth -> auth
						.requestMatchers("/api/v1/public/**").permitAll()
						.requestMatchers("/api/v1/user/**").hasRole("USER")
						.requestMatchers("/api/v1/admin/**").hasRole("ADMIN")
						.anyRequest().authenticated() 
					)
			.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
}
