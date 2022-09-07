package com.s.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
public class CustomWebUrl {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable();  //나중에 알아보기.
		
		http
			.authorizeHttpRequests()
				.antMatchers("/","/login").permitAll()
				.antMatchers("/home").authenticated();
		http
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/home")
			.loginProcessingUrl("/login")
			.permitAll();
		
		http
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login")
			.deleteCookies("JSESSIONID")
			.permitAll();
		
		return http.build();
		
	}
	
	
}
