package com.consultancy.services.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.consultancy.services.security.JwtAuthEntryPoint;
import com.consultancy.services.security.JwtAuthFilter;
import com.consultancy.services.services.UserEntityUserDetailsService;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtAuthEntryPoint point;
	
	@Autowired
	private JwtAuthFilter filter;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .authorizeHttpRequests(auth -> auth
//	        		.requestMatchers("/consultant", "/getAppointmentsForStudents", "/bookConsultant/**", "/book-appointment/**").hasAuthority("STUDENT")
//	        		.requestMatchers("/getAppointments", "/change-status/**").hasAuthority("CONSULTANT")
//	        		.requestMatchers("/").hasAnyAuthority("CONSULTANT", "STUDENT")
	                .requestMatchers("/**").permitAll()
	                .anyRequest().authenticated()
                )
//        	.formLogin(t -> {t
//        		.loginPage("/login")
//        		.usernameParameter("email")
//        		.passwordParameter("password")
//        		.successHandler((request, response, authentication) -> {
//        			System.out.println("in handler");
//        			response.sendRedirect("/");
//        		});
//        	})
//        	.authenticationProvider(authenticationProvider)
                .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        		.authenticationProvider(authenticationProvider());
        	
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
	}
	
	@Bean
	protected AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder);
		
		return authProvider;
	}
	

	
	@Bean
	protected AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
		return builder.getAuthenticationManager();
	}
}
