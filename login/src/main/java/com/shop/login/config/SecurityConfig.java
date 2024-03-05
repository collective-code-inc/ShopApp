package com.shop.login.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.shop.login.jwt.security.JwtAuthenticationEntryPoint;
import com.shop.login.jwt.security.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {

	@Autowired
	private JwtAuthenticationEntryPoint point;
	@Autowired
	private JwtAuthenticationFilter filter;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		//.requestMatchers("/api/login").permitAll().anyRequest().authenticated()
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(authz -> authz.requestMatchers("/jwt/user").authenticated()
						.requestMatchers("/api/login").permitAll().anyRequest().authenticated())
				.httpBasic(httpbc -> httpbc.authenticationEntryPoint(point))
				.sessionManagement(smc -> smc.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

}