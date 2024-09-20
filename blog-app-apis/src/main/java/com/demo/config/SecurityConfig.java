package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
				
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails normalUSer=User
				.withUsername("amir")
				.password(passwordEncoder()
						.encode("password"))
				.roles("NORMAL")
				.build();
		
		UserDetails adminUser=User.withUsername("amir1")
				.password(passwordEncoder()
						.encode("password"))
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(normalUSer, adminUser);
	}
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf()
		.disable()
		.authorizeHttpRequests()
		.requestMatchers("/api/categories")
		.permitAll().anyRequest().authenticated()
		.and()
		.formLogin();
		return http.build();
	}
}
