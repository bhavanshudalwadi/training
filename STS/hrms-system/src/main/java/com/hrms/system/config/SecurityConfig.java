package com.hrms.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.hrms.system.services.UserEntityUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserEntityUserDetailsService();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        
        http.csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .authorizeHttpRequests(requests -> requests
//                    .requestMatchers("/", "/complaint/**").hasAnyAuthority("ADMIN", "RESTAURANT")
//                    .requestMatchers("/city/**", "/area/**", "/category/**", "/sub-category/**","/restaurant-list").hasAuthority("ADMIN")
//                    .requestMatchers("/product/**", "/offer/**", "/feedback/**").hasAuthority("RESTAURANT")
                    .requestMatchers("/**").permitAll()
                    .anyRequest().authenticated()
                )
                .formLogin(form -> form 
            		.loginPage("/login")
                    .loginProcessingUrl("/login")
                )
                .authenticationProvider(authenticationProvider());
		
      return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();																																																																																																																	 
	}
}
