package com.consultancy.services.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.consultancy.services.services.UserEntityUserDetailsService;

//@Configuration
public class AppConfig {
//	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}
	
//    @Bean
    UserDetailsService userDetailsService() {
//		UserDetails admin = User.builder()
//								.username("admin")
//								.password(passwordEncoder().encode("123"))
//								.roles("ADMIN").build();
//		UserDetails user = User.builder()
//								.username("user")
//								.password(passwordEncoder().encode("123"))
//								.roles("USER").build();
//		return new InMemoryUserDetailsManager(admin, user);
    	return new UserEntityUserDetailsService();
	}

//	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
		return builder.getAuthenticationManager();
	}
}
