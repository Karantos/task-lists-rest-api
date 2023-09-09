
package com.backend.ListsApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.backend.ListsApp.security.services.UserDetailsServiceImpl;

@Configuration
@EnableMethodSecurity
// (securedEnabled = true,
// jsr250Enabled = true,
// prePostEnabled = true) // by default
public class WebSecurityConfig {
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private AuthEntryPointJwt unathorizedHandler;
	
	@Bean
	public AuthTokenFilter athenthicationJwtTokenFilter() {
		return new AuthTokenFilter();
	}
	
	@Bean
	public DaoAuthenthicationProvider authenthicationProvider() {
		DaoAuthenthicationProvider authProvider = new DaoAuthenthicationProvider();
		
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}
	
	@Bean
	public AuthenthicationManager authenthicationManager(AuthenthicationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenthicationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()) // Disables CSRF
			.exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler)) 
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(auth ->
				auth.requestMatchers("/api/auth/**").permitAll() // Permits all requests to the path that matches pattern
					.requestMatchers("/api/test/**").permitAll()
					.anyRequest().authenticated() // Authenticates all requests except the above
			);
		
		http.authenticationProvider(authenthicationProvider());
		
		http.addFilterBefore(authenthicationJwtTokenFilter(), UsernamePasswordAuthenthicationFilter.class);
		
		return http.build();
	}
}
