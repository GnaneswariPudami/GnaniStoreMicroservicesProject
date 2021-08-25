/**
 * 
 */
package com.gnanistore.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * @author Gnaneswari Pudami
 *
 */
@Configuration
@EnableWebSecurity
public class ExtendWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
			.and()
			.csrf().disable()
			.authorizeRequests().anyRequest().authenticated()
			.and()
			.httpBasic();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("admin").password("{noop}password").roles("ADMIN")
		.and()
		.withUser("user").password("{noop}password").roles("USER");
	}
	
	/*
	 * @Bean public CorsConfigurationSource corsConfigurationSource() {
	 * CorsConfiguration configuration = new CorsConfiguration();
	 * configuration.setAllowedOrigins(Arrays.asList("*"));
	 * configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH",
	 * "DELETE", "OPTIONS"));
	 * configuration.setAllowedHeaders(Arrays.asList("authorization",
	 * "content-type", "x-auth-token"));
	 * configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
	 * UrlBasedCorsConfigurationSource source = new
	 * UrlBasedCorsConfigurationSource(); source.registerCorsConfiguration("/**",
	 * configuration); return source; }
	 */
}
