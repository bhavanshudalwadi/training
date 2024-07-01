package com.rolebased.authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("123")).roles("ADMIN").build();
		UserDetails user = User.builder().username("user").password(passwordEncoder().encode("123")).roles("USER").build();
		return new InMemoryUserDetailsManager(admin, user);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();																																																																																																																	 
	}
	
	@Bean
	@SuppressWarnings("removal")
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> 
                	requests.requestMatchers("/user-details").hasAnyRole("ADMIN","USER")
                			.requestMatchers("/admin-details").hasRole("ADMIN")
                			.requestMatchers("/").permitAll()
                        	.anyRequest().authenticated()
            	)
                .formLogin(Customizer.withDefaults());
		return http.build();
	}
	
}
